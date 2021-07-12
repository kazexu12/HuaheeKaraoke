package Generic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(DBManager.class.getName());

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
     * @throws IOException
     */
    public void prepareTable() throws SQLException, IOException {
        Connection conn = connectDB();

        // Read SQL file from resource folder
        InputStream is = getClass().getClassLoader().getResourceAsStream("SQL/TABLE_SCHEMA.sql");
        BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String schemaQuery = sb.toString();

        Statement stmt = conn.createStatement();
        String[] queries = schemaQuery.split(";");
        for (String query : queries) {
            if(query.trim().compareTo("") == 0) {
                continue;
            }
            stmt.addBatch(query);
        }
        stmt.executeBatch();
        conn.close();
        logger.info("Finished preparing the SQL tables");
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
