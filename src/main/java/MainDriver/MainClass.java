package MainDriver;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import Generic.DBManager;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private static final Logger logger = LogManager.getLogger(MainClass.class.getName());

    public static void init() {
        // Initializing DB
        try {
            DBManager db = new DBManager();
            db.prepareTable();
        } catch (SQLException err) {
            logger.error("Unable to create database", err);
        }

        // Initialising terminal
        try {
            Terminal terminal = TerminalBuilder.builder()
                    .system(true).jna(true).type("windows-vtp")
                    .build();
            terminal.enterRawMode();
            Playground.charInputPlayground(terminal);
        } catch (IOException err) {
            logger.error("Unable to initialise terminal", err);
        }
    }

    /**
     * Self-made class to capture uncaught exceptions
     */
    static class ErrorHandler implements UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            // Logs the exception using log4j 2
            logger.error("Uncaught exception in thread: " + t.getName(), e);
        }

    }

    public static void main(String[] args) throws Exception {
        // Handle uncaught exceptions
        Thread.setDefaultUncaughtExceptionHandler(new ErrorHandler());

        init();
    }
}
