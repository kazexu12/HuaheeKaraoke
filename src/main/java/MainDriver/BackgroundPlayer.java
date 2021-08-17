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
    private KaraokeSessionFrame parent;
    private PlayerState playerState;
    private int timestampNow;
    private int timestampMax;
    private LRCReader lyricReader;
    private DoublyLinkedDeque<Pair<Integer, String>> currentLyricsQueue;
    private Pair<Integer, String> lyricTop;
    private Pair<Integer, String> lyricMiddle;
    private Pair<Integer, String> lyricBottom;
    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private final ArrayList<Pair<Song, Boolean>> nowPlayingSongList;
    
    public BackgroundPlayer(KaraokeSessionFrame parent) {
        this.parent = parent;
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

            // Update parent view
            updateParentView();
        }
    }
    
    public void updateParentView() {
        this.parent.updateTimestamp(timestampNow, timestampMax);
        this.parent.displayLyrics(
                lyricTop == null ? "" : lyricTop.getRight(),
                lyricMiddle == null ? "" : lyricMiddle.getRight(),
                lyricBottom == null ? "" : lyricBottom.getRight(),
                2
        );
    }
    
    private void nextSong() {
        loadLyric();
        for (int i = 0; i < this.nowPlayingSongList.size(); i++) {
            Song song = nowPlayingSongList.get(i).getLeft();
            boolean isPlaying = nowPlayingSongList.get(i).getRight();
            if (isPlaying) {
                Song playSong = nowPlayingSongList.get(i + 1).getLeft();
                // Suppose to be playSong.getDuration
                this.timestampMax = 240;
                this.timestampNow = 0;
                nowPlayingSongList.get(0).setRight(Boolean.TRUE);
                this.parent.updateCurrentPlaylistTable(this.nowPlayingSongList);
                return;
            }
        }
        
        if (this.nowPlayingSongList.size() != 0) {
            Song playSong = nowPlayingSongList.get(0).getLeft();

            // Suppose to be playSong.getDuration
            this.timestampMax = 240;
            this.timestampNow = 0;
            nowPlayingSongList.get(0).setRight(Boolean.TRUE);
            this.parent.updateCurrentPlaylistTable(this.nowPlayingSongList);
        }
    }

    /**
     * Change song. Song provided must exists in current list or else nothing
     * will happen
     *
     * @param song
     */
    public void changeSong(Song song) {
        boolean found = false;
        for (int i = 0; i < nowPlayingSongList.size(); i++) {
            Pair<Song, Boolean> item = nowPlayingSongList.get(i);
            if (!item.getLeft().equals(song)) {
                item.setRight(false);
                found = true;
                continue;
            }
            item.setRight(true);
        }
        if (!found) {
            logger.warn("changeSong() was called but Song object provided does not exists in list");
            return;
        }
        this.timestampMax = song.getDuration();
        this.timestampNow = 0;
        loadLyric();
        this.parent.updateCurrentPlaylistTable(this.nowPlayingSongList);
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
    
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }
    
    public void addSong(Song newSong) {
        nowPlayingSongList.add(new Pair<>(newSong, false));
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
