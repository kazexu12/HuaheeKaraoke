package SessionManagement.Utility;

import Generic.EventListener;
import DTO.Song;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
import SessionManagement.ADT.DoublyLinkedDeque;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private EventListener onNextSongListener;
    private EventListener onPlayingListener;
    private EventListener onStoppedListener;

    private final Object playerStateLock = new Object();

    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private ArrayList<Pair<Song, Boolean>> nowPlayingSongList;

    public BackgroundPlayer() {
        this.nowPlayingSongList = new ArrayList<>();
        this.playerState = PlayerState.STOPPED;
        this.lyricReader = new LRCReader("LRC/lyrics.lrc", true);
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
            if (onPlayingListener != null) {
                onPlayingListener.callback(null);
            }
        }
    }

    public void nextSong() {
        loadLyric();
        for (int i = 0; i < this.nowPlayingSongList.size(); i++) {
            Song song = nowPlayingSongList.get(i).getLeft();
            boolean isPlaying = nowPlayingSongList.get(i).getRight();
            if (isPlaying && i != nowPlayingSongList.size() - 1) {
                this.changeSong(i + 1);
                if (onNextSongListener != null) {
                    onNextSongListener.callback(null);
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
        if (onStoppedListener != null) {
            onStoppedListener.callback(null);
        }
    }

    /**
     * What to do after next song have been chosen
     *
     * @param e
     */
    public void onNextSong(EventListener e) {
        onNextSongListener = e;
    }

    /**
     * What to do after each seconds of songs played
     *
     * @param e
     */
    public void onPlaying(EventListener e) {
        onPlayingListener = e;
    }

    /**
     * When the player is stopped because the songs finished playing
     *
     * @param e
     */
    public void onStopped(EventListener e) {
        onStoppedListener = e;
    }

    /**
     * Change song.
     *
     * @param idx
     */
    public void changeSong(int idx) {
        for (int i = 0; i < nowPlayingSongList.size(); i++) {
            Pair<Song, Boolean> item = nowPlayingSongList.get(i);
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
        this.lyricReader = new LRCReader("LRC/lyrics.lrc", true);
        this.lyricTop = null;
        this.lyricMiddle = null;
        this.lyricBottom = this.lyricReader.getLyricsDeque().peekFront();
    }

    public PlayerState getPlayerState() {
        synchronized (playerStateLock) {
            return playerState;
        }
    }

    public ArrayList<Pair<Song, Boolean>> getNowPlayingSongList() {
        return this.nowPlayingSongList;
    }

    public void setPlayerState(PlayerState playerState) {
        synchronized (playerStateLock) {
            this.playerState = playerState;
        }
    }

    public void addSong(Song newSong) {
        nowPlayingSongList.add(new Pair<>(newSong, false));
    }

    public void removeSongs(int[] idxs) {
        ArrayList<Pair<Song, Boolean>> newSongList = new ArrayList<>();
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
