package SessionManagement.Utility;

import DTO.SongDTO;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
import SessionManagement.ADT.DoublyLinkedDeque;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Generic.Event;

/**
 * Class that creates a new Thread upon creation and serve as a timer and
 * PlayerStateManager to KaraokeSessionFrame
 *
 * @author Loo Zi Kang
 */
public class BackgroundPlayer extends Thread {

    private static final Logger logger = LogManager.getLogger(BackgroundPlayer.class.getName());
    private PlayerState playerState;
    private int timestampNow;
    private int timestampMax;
    private LRCReader lyricReader;
    private Pair<Integer, String> lyricTop;
    private Pair<Integer, String> lyricMiddle;
    private Pair<Integer, String> lyricBottom;

    private Event onNextSongEvent;
    private Event onPlayingEvent;
    private Event onStoppedEvent;

    private final Object PLAYER_STATE_LOCK = new Object();
    private final String[] LYRICS_LIST = new String[]{"LRC/lyric-1.lrc", "LRC/lyric-2.lrc", "LRC/lyric-3.lrc", "LRC/lyric-4.lrc"};

    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private ArrayList<Pair<SongDTO, Boolean>> nowPlayingSongList;

    public BackgroundPlayer() {
        this.nowPlayingSongList = new ArrayList<>();
        this.playerState = PlayerState.STOPPED;
        this.lyricReader = new LRCReader(LYRICS_LIST[Math.abs(new java.util.Random().nextInt() % LYRICS_LIST.length)], true);
    }

    @Override
    public void run() {
        while (true) {
            if (this.getPlayerState() != PlayerState.PLAYING) {
                continue;
            }

            if (timestampNow >= timestampMax) {
                nextSong();
                continue;
            }

            timestampNow++;

            // Timer to run this every 1 second
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                logger.error("Timer was interrupted", e);
            }

            DoublyLinkedDeque<Pair<Integer, String>> lyricsDeque = this.lyricReader.getLyricsDeque();
            Pair<Integer, String> lyric = lyricsDeque.peekFront();
            if (lyric != null) {
                if (lyric.getLeft() <= timestampNow) {
                    if (this.lyricMiddle != null) {
                        this.lyricTop = new Pair<>(this.lyricMiddle.getLeft(), this.lyricMiddle.getRight());
                    }
                    this.lyricMiddle = lyricsDeque.removeFront();
                    this.lyricBottom = lyricsDeque.peekFront();
                }
            }

            // onPlaying callback
            if (onPlayingEvent != null) {
                onPlayingEvent.callback(null);
            }
        }
    }

    public void nextSong() {
        loadLyric();
        for (int i = 0; i < this.nowPlayingSongList.size(); i++) {
            SongDTO song = nowPlayingSongList.get(i).getLeft();
            boolean isPlaying = nowPlayingSongList.get(i).getRight();
            if (isPlaying && i != nowPlayingSongList.size() - 1) {
                this.changeSong(i + 1);
                if (onNextSongEvent != null) {
                    onNextSongEvent.callback(null);
                }
                return;
            }
        }

        // Stop Player
        stopPlayer();
    }

    private void stopPlayer() {
        for (int i = 0; i < nowPlayingSongList.size(); i++) {
            nowPlayingSongList.get(i).setRight(false);
        }
        this.setPlayerState(PlayerState.STOPPED);
        this.timestampNow = 0;
        this.timestampMax = 0;
        this.lyricTop = null;
        this.lyricMiddle = null;
        this.lyricBottom = null;
        if (onStoppedEvent != null) {
            onStoppedEvent.callback(null);
        }
    }

    /**
     * What to do after next song have been chosen
     *
     * @param e
     */
    public void onNextSong(Event e) {
        onNextSongEvent = e;
    }

    /**
     * What to do after each seconds of songs played
     *
     * @param e
     */
    public void onPlaying(Event e) {
        onPlayingEvent = e;
    }

    /**
     * When the player is stopped because the songs finished playing
     *
     * @param e
     */
    public void onStopped(Event e) {
        onStoppedEvent = e;
    }

    /**
     * Change song.
     *
     * @param idx
     */
    public void changeSong(int idx) {
        for (int i = 0; i < nowPlayingSongList.size(); i++) {
            Pair<SongDTO, Boolean> item = nowPlayingSongList.get(i);
            if (i != idx) {
                item.setRight(false);
                continue;
            }
            item.setRight(true);
        }

        this.timestampMax = this.nowPlayingSongList.get(idx).getLeft().getDuration();
        this.timestampNow = 0;
        loadLyric();
    }

    private void loadLyric() {
        // Preload lyrics
        this.lyricReader = new LRCReader(LYRICS_LIST[Math.abs(new java.util.Random().nextInt() % LYRICS_LIST.length)], true);
        this.lyricTop = null;
        this.lyricMiddle = null;
        this.lyricBottom = this.lyricReader.getLyricsDeque().peekFront();
    }

    public PlayerState getPlayerState() {
        synchronized (PLAYER_STATE_LOCK) {
            return playerState;
        }
    }

    public ArrayList<Pair<SongDTO, Boolean>> getNowPlayingSongList() {
        return this.nowPlayingSongList;
    }

    public void setPlayerState(PlayerState playerState) {
        synchronized (PLAYER_STATE_LOCK) {
            this.playerState = playerState;
        }
    }

    public void addSong(SongDTO newSong) {
        nowPlayingSongList.add(new Pair<>(newSong, false));
    }

    public void removeSongs(int[] idxs) {
        ArrayList<Pair<SongDTO, Boolean>> newSongList = new ArrayList<>();
        boolean found = false;
        boolean needToChangeSongToClosest = false;
        int closestIdx = -1;
        for (int i = 0; i < this.nowPlayingSongList.size(); i++) {
            boolean isPlaying = nowPlayingSongList.get(i).getRight();

            // Find index in index array
            found = false;
            for (int idx : idxs) {
                if (idx == i) {
                    found = true;
                    break;
                }
            }

            if (found) {
                if (isPlaying) {
                    needToChangeSongToClosest = true;
                }
                continue;
            }

            if (needToChangeSongToClosest && closestIdx == -1) {
                closestIdx = newSongList.size();
            }
            newSongList.add(new Pair<>(nowPlayingSongList.get(i).getLeft(), false));
        }

        this.nowPlayingSongList = newSongList;

        if (newSongList.size() == 0) {
            stopPlayer();
            return;
        }

        if (needToChangeSongToClosest) {
            if (closestIdx == -1) {
                closestIdx = this.nowPlayingSongList.size() - 1;
            }
            this.changeSong(closestIdx);
        }
    }

    public int getTimestampNow() {
        return timestampNow;
    }

    public int getTimestampMax() {
        return timestampMax;
    }

    public Pair<Integer, String> getLyricTop() {
        return lyricTop;
    }

    public Pair<Integer, String> getLyricMiddle() {
        return lyricMiddle;
    }

    public Pair<Integer, String> getLyricBottom() {
        return lyricBottom;

    }
}
