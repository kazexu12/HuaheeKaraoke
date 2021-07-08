package SessionManagement;

import DTO.Song;
import DTO.User;

/**
 * Class that store ongoing karaoke session
 *
 * @author zkang
 */
public class KaraokeSession {

    /**
     * Stores songs
     */
    private Song[] nowPlayingQueue;

    /**
     * Store participant list
     */
    private User[] participants;

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

    public Song[] getNowPlayingQueue() {
        return nowPlayingQueue;
    }

    public void setNowPlayingQueue(Song[] nowPlayingQueue) {
        this.nowPlayingQueue = nowPlayingQueue;
    }

    public User[] getParticipants() {
        return participants;
    }

    public void setParticipants(User[] participants) {
        this.participants = participants;
    } 

    // ================================
    // ================================

}
