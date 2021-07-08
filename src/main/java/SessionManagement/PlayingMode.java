package SessionManagement;

/**
 * ENUM for playing mode of current karaoke session
 *
 * @author zkang
 */
public enum PlayingMode {
    /**
     * Songs is removed from queue after playing
     */
    DEFAULT,
    /**
     * Song will repeat itself onFinish<br>
     * Song is not removed from queue
     */
    LOOP_ONCE,
    /**
     * Song will play the first in queue after reaching its end<br>
     * Song is not removed from queue
     */
    LOOP_ALL,
    /**
     * Song is randomly selected onFinish<br>
     * Song is not removed from queue
     */
    SHUFFLE
}
