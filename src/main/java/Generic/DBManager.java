package Generic;

import java.io.File;
import java.sql.*;

/**
 * Class used to execute queries for database <br>
 *
 * <b>Change Log:</b> <br>
 * 1.0 <br>
 * - Initial <br>
 * 1.1 <br>
 * - Remove lastErrorMessage member from class <br>
 * - Connection will be closed upon completion of any DB operations <br>
 * - Removed disconnectDB() <br>
 *
 * @author Looz
 * @version 1.1
 */
public class DBManager {

    private final String dbPath = System.getenv("APPDATA") + "\\HuaheeKaraoke\\";
    private final String dbName = "data.db";

    /**
     * Only call once throughout the project and pass the reference around
     * thanks
     */
    public DBManager() {
        prepareTable();
    }

    /**
     * Connect to Database
     *
     * @return Connection instance
     */
    private Connection connectDB() {
        // make sure directory exist
        new File(dbPath).mkdir();
        String url = "jdbc:sqlite:" + dbPath + dbName;

        Connection conn;

        // Connecting to the database
        try {
            conn = DriverManager.getConnection(url);
            if (conn == null) {
                throw new SQLException();
            }
        } catch (SQLException err) {
            System.out.println("Failed to connect to database.\nMissing APPDATA env ?");
            System.out.println(err.getMessage());
            System.exit(1);
            return null;
        }

        return conn;
    }

    /**
     * Set up database schema
     */
    private void prepareTable() {
        Connection conn = connectDB();
//        String tab1 = "CREATE TABLE IF NOT EXISTS staff (\n"
//                + "	id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "	date datetime default (datetime('now','localtime')),\n"
//                + "	name TEXT NOT NULL UNIQUE,\n"
//                + "	password TEXT NOT NULL\n"
//                + ");";
//        String tab2 = "CREATE TABLE IF NOT EXISTS member (\n"
//                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "date datetime default (datetime('now','localtime')),\n"
//                + "name TEXT NOT NULL,\n"
//                + "phoneNo TEXT,\n"
//                + "email TEXT,\n"
//                + "IC TEXT NOT NULL UNIQUE,\n"
//                + "points INTEGER\n"
//                + ");";
//        String tab3 = "CREATE TABLE IF NOT EXISTS book (\n"
//                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "date datetime default (datetime('now','localtime')),\n"
//                + "title TEXT NOT NULL,\n"
//                + "author TEXT,\n"
//                + "retailPrice DOUBLE NOT NULL,\n"
//                + "lastRentedBy INTEGER,\n"
//                + "lastReservedBy INTEGER,\n"
//                + "isRented INTEGER,\n"
//                + "isReserved INTEGER,\n"
//                + "FOREIGN KEY (lastRentedBy) REFERENCES member(id),\n"
//                + "FOREIGN KEY (lastReservedBy) REFERENCES member(id)\n"
//                + ");";
//
//        String tab4 = "CREATE TABLE IF NOT EXISTS transactions (\n"
//                + "id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
//                + "date datetime default (datetime('now','localtime')),\n"
//                + "rentDurationInDays INTEGER,\n"
//                + "type TEXT,\n"
//                + "staffHandled INTEGER,\n"
//                + "memberInvolved INTEGER,\n"
//                + "bookInvolved INTEGER,\n"
//                + "cashFlow DOUBLE,\n"
//                + "FOREIGN KEY (staffHandled) REFERENCES staff(id),\n"
//                + "FOREIGN KEY (memberInvolved) REFERENCES member(id),\n"
//                + "FOREIGN KEY (bookInvolved) REFERENCES book(id)\n"
//                + ");";
//
//        try {
//            Statement stmt = conn.createStatement();
//            stmt.addBatch(tab1);
//            stmt.addBatch(tab2);
//            stmt.addBatch(tab3);
//            stmt.addBatch(tab4);
//            stmt.executeBatch();
//        } catch (SQLException err) {
//            System.out.println(err.getMessage());
//        
        // Close DB Connection
        try {
            conn.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    /**
     * Execute update Query
     *
     * @param q SQLITE query
     * @return rows are affected, return -1 if SQLException thrown
     */
    public int updateQuery(String q) {
        Connection conn = connectDB();
        int rowsAffected = -1;
        try {
            Statement stmt = conn.createStatement();
            rowsAffected = stmt.executeUpdate(q);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        // Close DB Connection
        try {
            conn.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return rowsAffected;
    }

    /**
     * Execute query
     *
     * @param q SQLITE Query
     * @return true if the query returned a ResultSet
     */
    public boolean execQuery(String q) {
        Connection conn = connectDB();
        boolean status = false;
        try {
            Statement stmt = conn.createStatement();
            status = stmt.execute(q);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        // Close DB Connection
        try {
            conn.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return status;
    }

    /**
     * Execute query that returns rows of data
     *
     * @param q SQLITE query
     * @return ResultSet of the query, will return null if SQLException thrown
     */
    public ResultSet resultQuery(String q) {
        Connection conn = connectDB();
        ResultSet result = null;
        try {
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(q);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        // Close DB Connection
        try {
            conn.close();
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return result;
    }
}
