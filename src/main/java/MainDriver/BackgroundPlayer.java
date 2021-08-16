package MainDriver;

import DTO.Song;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
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
    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private final ArrayList<Pair<Song, Boolean>> nowPlayingSongList;

    public BackgroundPlayer(KaraokeSessionFrame parent) {
        this.parent = parent;
        this.nowPlayingSongList = new ArrayList<>();
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

            // Update parent view
            updateParentView();
        }
    }

    public void updateParentView() {
        this.parent.updateTimestamp(timestampNow, timestampMax);
        try {
            Pair<Integer, String> lrcObj = this.lyricReader.getLyricsAt(timestampNow);
//            int min = lrcObj.getLeft() / 60;
//            int sec = lrcObj.getLeft() % 60;
//            String lrc = String.format("[%02d:%02d]%s", new Object[]{min, sec, lrcObj.getRight()});
//            this.parent.addLyric(lrc);
            this.parent.addLyric(lrcObj.getRight());
        } catch (IllegalStateException e) {

        }
    }

    private void nextSong() {
        for (int i = 0; i < this.nowPlayingSongList.size(); i++) {
            Song song = nowPlayingSongList.get(i).getLeft();
            boolean isPlaying = nowPlayingSongList.get(i).getRight();
            if (isPlaying) {
                Song playSong = nowPlayingSongList.get(i + 1).getLeft();
                // Suppose to be playSong.getDuration
                this.timestampMax = 240;
                this.timestampNow = 0;
                nowPlayingSongList.get(0).setRight(Boolean.TRUE);
                return;
            }
        }

        if (this.nowPlayingSongList.size() != 0) {
            Song playSong = nowPlayingSongList.get(0).getLeft();

            // Suppose to be playSong.getDuration
            this.timestampMax = 240;
            this.timestampNow = 0;
            nowPlayingSongList.get(0).setRight(Boolean.TRUE);
        }
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
        // LinkedQueue<Pair<Integer, String>> lyricsQueue;

        public LRCReader() {
            // lyricsQueue = new LinkedQueue();
        }

        public LRCReader(String filename) {
            // lyricsQueue = new LinkedQueue();
            try {
                Path path = Paths.get(filename);
                BufferedReader buf = Files.newBufferedReader(path);
                parse(buf);
            } catch (IOException e) {
                logger.error("Failed to read file from path: " + filename, e);
            }
        }

        public LRCReader(String filename, boolean readFromResource) {
            // lyricsQueue = new LinkedQueue();
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

        public Pair<Integer, String> getLyricsAt(int timestamp) throws IllegalStateException {
            // Pair<Integer, String> lyric = lyricsQueue.peek();
            // if (lyric.getLeft() > timestamp) {
            //     throw new IllegalStateException("No new lyrics found at this timestamp");
            // }
            // return lyricsQueue.dequeue();
            return null;
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
                            // lyricsQueue.enqueue(lyricPair);
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
