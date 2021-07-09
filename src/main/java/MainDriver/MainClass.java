package MainDriver;

import Generic.DBManager;
import java.lang.Thread.UncaughtExceptionHandler;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass {

    private static final Logger logger = LogManager.getLogger(MainClass.class.getName());
    
    public static void init() throws Exception {
        // Initializing DB
        try {
            DBManager db = new DBManager();
            db.prepareTable();
        } catch (SQLException err) {
            logger.error("Unable to create database", err);
        }

        System.out.println("Clear me pls");
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("henlo");
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
        new java.util.Scanner(System.in).nextLine();
    }
}
