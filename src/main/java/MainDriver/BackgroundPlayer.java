package MainDriver;

import DTO.Song;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
import SessionManagement.ADT.DoublyLinkedDeque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private DoublyLinkedDeque<Pair<Integer, String>> currentLyricsQueue;
    private Pair<Integer, String> lyricTop;
    private Pair<Integer, String> lyricMiddle;
    private Pair<Integer, String> lyricBottom;

    private EventListener onNextSongListener;
    private EventListener onPlayingListener;
    private EventListener onStoppedListener;

    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private ArrayList<Pair<Song, Boolean>> nowPlayingSongList;

    public BackgroundPlayer() {
        this.nowPlayingSongList = new ArrayList<>();
        this.currentLyricsQueue = new DoublyLinkedDeque<>();
        this.playerState = PlayerState.STOPPED;
        this.lyricReader = new LRCReader("LRC/lyrics.lrc", true);
    }

    @Override
    public void run() {
        while (true) {
            if (this.playerState != PlayerState.PLAYING) {
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

            Pair<Integer, String> lyric = this.lyricReader.lyricsQueue.peekFront();
            if (lyric.getLeft() <= timestampNow) {
                if (this.lyricMiddle != null) {
                    this.lyricTop = new Pair<>(this.lyricMiddle.getLeft(), this.lyricMiddle.getRight());
                }
                this.lyricMiddle = this.lyricReader.lyricsQueue.removeFront();
                this.lyricBottom = this.lyricReader.lyricsQueue.peekFront();
            }

            // onPlaying callback
            if (onPlayingListener != null) {
                onPlayingListener.callback(null);
            }
        }
    }

    private void nextSong() {
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

        // Reset Player
        for (int i = 0; i < nowPlayingSongList.size(); i++) {
            nowPlayingSongList.get(i).setRight(false);
        }
        this.playerState = PlayerState.STOPPED;
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
        this.lyricBottom = this.lyricReader.lyricsQueue.peekFront();
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public ArrayList<Pair<Song, Boolean>> getNowPlayingSongList() {
        return this.nowPlayingSongList;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
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

    private class LRCReader {

        /**
         * Stores the lyrics queue
         */
        DoublyLinkedDeque<Pair<Integer, String>> lyricsQueue;

        public LRCReader() {
            lyricsQueue = new DoublyLinkedDeque();
        }

        public LRCReader(String filename) {
            lyricsQueue = new DoublyLinkedDeque();
            try {
                Path path = Paths.get(filename);
                BufferedReader buf = Files.newBufferedReader(path);
                parse(buf);
            } catch (IOException e) {
                logger.error("Failed to read file from path: " + filename, e);
            }
        }

        public LRCReader(String filename, boolean readFromResource) {
            lyricsQueue = new DoublyLinkedDeque();
            try {
                if (!readFromResource) {
                    Path path = Paths.get(filename);
                    BufferedReader buf = Files.newBufferedReader(path);
                    parse(buf);
                } else {
                    InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
                    BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    parse(buf);
                }
            } catch (IOException e) {
                logger.error("Failed to read file from resources folder", e);
            }
        }

        private void parse(BufferedReader buf) {
            String pattern = "\\[(\\d{1,2})(?:\\:|.)(\\d{1,2})(?:\\:|.)(\\d{1,2})\\](.*)";
            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);

            try {
                String line;
                while ((line = buf.readLine()) != null) {
                    Matcher m = r.matcher(line);
                    try {
                        if (m.find()) {
                            int min = Integer.parseInt(m.group(1));
                            int sec = Integer.parseInt(m.group(2));
                            int ms = Integer.parseInt(m.group(3));
                            int timestamp = min * 60 + sec;
                            String lyric = m.group(4);
                            Pair<Integer, String> lyricPair = new Pair<>(timestamp, lyric);
                            lyricsQueue.pushBack(lyricPair);
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            } catch (IOException e) {
                logger.error("BufferedReader failed to readline()", e);
            }
        }
    }

}
