package SessionManagement;

/**
 * Class that store ongoing karaoke session
 *
 * @author zkang
 */
public class KaraokeSession {

    /**
     * Stores songs
     */
    private String[] nowPlayingQueue;

    /**
     * Store participant list
     */
    private String[] participants;

    /**
     * Playing mode of the session
     */
    private PlayingMode mode;

    /**
     * Counter for how many songs is played
     */
    private int songsPlayed = 0;

    /**
     * Play next song in queue
     */
    public void nextSong() {

    }

    /**
     * Play previous song in queue
     */
    public void prevSong() {

    }

    /**
     * Generate report of current session in string
     */
    public void generateReport() {

    }

    // ================================
    // Getters & Setters
    // ================================
    public PlayingMode getMode() {
        return mode;
    }

    public void setMode(PlayingMode mode) {
        this.mode = mode;
    }

    public int getSongsPlayed() {
        return songsPlayed;
    }

    public void setSongsPlayed(int songsPlayed) {
        this.songsPlayed = songsPlayed;
    }

    public String[] getNowPlayingQueue() {
        return nowPlayingQueue;
    }

    public String[] getParticipants() {
        return participants;

    }
    // ================================
    // ================================

}
