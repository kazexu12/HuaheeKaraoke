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
 * - Now expects the developer to handle SQLException on their own
 *
 * @author Looz
 * @version 1.1
 */
public class DBManager {

    private final String dbPath = System.getenv("APPDATA") + "\\HuaheeKaraoke\\";
    private final String dbName = "data.db";

    public DBManager() {

    }

    /**
     * Connect to Database
     *
     * @return Connection instance
     */
    private Connection connectDB() throws SQLException {
        // make sure directory exist
        new File(dbPath).mkdir();
        String url = "jdbc:sqlite:" + dbPath + dbName;

        Connection conn;

        // Connecting to the database
        conn = DriverManager.getConnection(url);
        if (conn == null) {
            throw new SQLException();
        }

        return conn;
    }

    /**
     * Set up database schema
     *
     * @throws SQLException
     */
    public void prepareTable() throws SQLException {
        Connection conn = connectDB();
        String tab1 = "CREATE TABLE IF NOT EXISTS Gifts (\n"
                + "	gift_id TEXT,\n"
                + "	gift_name TEXT,\n"
                + "	member_level_min INTEGER,\n"
                + "	PRIMARY KEY(gift_id)\n"
                + ");\n";
        String tab2 = "CREATE TABLE IF NOT EXISTS Songs (\n"
                + "	song_id TEXT,\n"
                + "	name TEXT,\n"
                + "	artist TEXT,\n"
                + "	album TEXT,\n"
                + "	genre TEXT,\n"
                + "	duration INTEGER,\n"
                + "	date_created NUMERIC,\n"
                + "	PRIMARY KEY(song_id)\n"
                + ");\n";
        String tab3 = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "	user_id TEXT,\n"
                + "	privillage INTEGER,\n"
                + "	name TEXT,\n"
                + "	pw_hash TEXT,\n"
                + "	first_name TEXT,\n"
                + "	last_name TEXT,\n"
                + "	member_point INTEGER,\n"
                + "	member_level TEXT,\n"
                + "	date_created NUMERIC,\n"
                + "	PRIMARY KEY(user_id)\n"
                + ");\n";
        String tab4 = "CREATE TABLE IF NOT EXISTS Transactions (\n"
                + "	transaction_id TEXT,\n"
                + "	room_size TEXT,\n"
                + "	head_count INTEGER,\n"
                + "	discount REAL,\n"
                + "	final_price REAL,\n"
                + "	member_id TEXT,\n"
                + "	member_level_atm TEXT,\n"
                + "	staff_id TEXT,\n"
                + "	PRIMARY KEY(transaction_id),\n"
                + "	FOREIGN KEY(member_id) REFERENCES Users(user_id),\n"
                + "	FOREIGN KEY(staff_id) REFERENCES Users(user_id)\n"
                + ");\n";
        String tab5 = "CREATE TABLE IF NOT EXISTS GiftRecords (\n"
                + "	transaction_id TEXT,\n"
                + "	gift_id TEXT,\n"
                + "	amount INTEGER,\n"
                + "	PRIMARY KEY(transaction_id, gift_id),\n"
                + "	FOREIGN KEY(transaction_id) REFERENCES Transactions(transaction_id),\n"
                + "	FOREIGN KEY(gift_id) REFERENCES Gifts(gift_id)\n"
                + ");";

        Statement stmt = conn.createStatement();
        stmt.addBatch(tab1);
        stmt.addBatch(tab2);
        stmt.addBatch(tab3);
        stmt.addBatch(tab4);
        stmt.addBatch(tab5);
        stmt.executeBatch();
        conn.close();
    }

    /**
     * Execute update Query
     *
     * @param q SQLITE query
     * @return rows are affected
     * @throws SQLException
     */
    public int updateQuery(String q) throws SQLException {
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
     * @throws SQLException
     */
    public boolean execQuery(String q) throws SQLException {
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
     * @return ResultSet of the query
     * @throws SQLException
     */
    public ResultSet resultQuery(String q) throws SQLException {
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
