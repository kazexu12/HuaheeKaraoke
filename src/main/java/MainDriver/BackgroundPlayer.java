package MainDriver;

import DTO.Song;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Loo Zi Kang
 */
public class BackgroundPlayer extends Thread {

    private static final Logger logger = LogManager.getLogger(BackgroundPlayer.class.getName());
    private KaraokeSessionFrame parent;
    private PlayerState playerState;
    private int timestampNow;
    private int timestampMax;
    /**
     * Boolean on the right indicate is the song is being played at the moment
     */
    private final ArrayList<Pair<Song, Boolean>> nowPlayingSongList;

    public BackgroundPlayer(KaraokeSessionFrame parent) {
        this.parent = parent;
        this.nowPlayingSongList = new ArrayList<>();
        this.playerState = PlayerState.STOPPED;
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

}
