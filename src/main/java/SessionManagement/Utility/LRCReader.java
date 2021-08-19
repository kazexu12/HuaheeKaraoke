package SessionManagement.Utility;

import Generic.Pair;
import SessionManagement.ADT.DoublyLinkedDeque;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for parsing LRC into lyrics
 *
 * @author Loo Zi Kang
 */
public class LRCReader {

    private static final Logger logger = LogManager.getLogger(LRCReader.class.getName());
    /**
     * Stores the lyrics queue
     */
    private DoublyLinkedDeque<Pair<Integer, String>> lyricsDeque;

    public LRCReader() {
        lyricsDeque = new DoublyLinkedDeque();
    }

    public LRCReader(String filename) {
        lyricsDeque = new DoublyLinkedDeque();
        try {
            Path path = Paths.get(filename);
            BufferedReader buf = Files.newBufferedReader(path);
            parse(buf);
        } catch (IOException e) {
            logger.error("Failed to read file from path: " + filename, e);
        }
    }

    public LRCReader(String filename, boolean readFromResource) {
        lyricsDeque = new DoublyLinkedDeque();
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

    public DoublyLinkedDeque<Pair<Integer, String>> getLyricsDeque() {
        return lyricsDeque;
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
                        lyricsDeque.pushBack(lyricPair);
                    }
                } catch (NumberFormatException e) {

                }
            }
        } catch (IOException e) {
            logger.error("BufferedReader failed to readline()", e);
        }
    }
}
