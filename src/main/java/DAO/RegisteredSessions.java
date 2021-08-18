package DAO;

import DTO.RegisteredSession;
import Generic.DBManager;
import Generic.Pair;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Data access object for RegisteredSession from SQLite DB
 *
 * @author Loo Zi Kang
 */
public class RegisteredSessions implements DAOInterface<RegisteredSession> {

    private final Logger logger = LogManager.getLogger(RegisteredSessions.class.getName());
    private final DBManager db;

    public RegisteredSessions() {
        db = new DBManager();
    }

    @Override
    public ArrayList<RegisteredSession> getAll() {
        ArrayList<RegisteredSession> sessions = new ArrayList<>();
        String query = "SELECT * FROM RegisteredSessions;";
        Pair<Connection, ResultSet> queryResult;
        Connection dbconn;
        ResultSet sessionResult;
        try {
            queryResult = db.resultQuery(query);
            dbconn = queryResult.getLeft();
            sessionResult = queryResult.getRight();

            while (sessionResult.next()) {
                RegisteredSession sess = readRegisteredSessionFromResultSet(sessionResult);
                sessions.add(sess);
            }

        } catch (SQLException e) {
            logger.error("Unable to query registered sessions from DB", e);
        }
        return sessions;
    }

    @Override
    public void save(RegisteredSession t) throws SQLException {
        Object[] args = new Object[]{
            t.getSessionId(),
            t.getSessionKey(),
            t.getRoomSize(),
            t.getHeadCount(),
            t.getSessionDate(),
            t.getSessionStartTime(),
            t.getSessionEndTime()
        };
        String query = String.format("INSERT INTO RegisteredSessions VALUES("
                + "'%s',"
                + "'%s',"
                + "'%c',"
                + "%d,"
                + "'%s',"
                + "'%s',"
                + "'%s',"
                + "strftime('%%s', 'now'),"
                + "strftime('%%s', 'now')"
                + ");", args);
        db.execQuery(query);
        logger.info("Successfully added record in DB (session_id: " + t.getSessionId() + ")");
    }

    @Override
    public void update(RegisteredSession t, HashMap<String, Object> params) throws SQLException {
        String setClause = "SET ";
        String whereClause = String.format(" WHERE session_id='%s'", t.getSessionId());

        boolean useSetClause = false;
        if (params.containsKey("session_key")) {
            setClause += String.format("session_key = '%s',", params.get("session_key"));
            useSetClause = true;
        }
        if (params.containsKey("room_size")) {
            setClause += String.format("room_size = '%s',", params.get("room_size"));
            useSetClause = true;
        }
        if (params.containsKey("head_count")) {
            setClause += String.format("head_count = %d,", params.get("head_count"));
            useSetClause = true;
        }
        if (params.containsKey("session_date")) {
            setClause += String.format("session_date = '%s',", params.get("session_date"));
            useSetClause = true;
        }
        if (params.containsKey("session_start_time")) {
            setClause += String.format("session_start_time = '%s',", params.get("session_start_time"));
            useSetClause = true;
        }
        if (params.containsKey("session_end_time")) {
            setClause += String.format("session_end_time = '%s',", params.get("session_end_time"));
            useSetClause = true;
        }

        // Remove last character from setClause to remove additional ',' from string
        setClause = setClause.substring(0, setClause.length() - 1);

        String query = "UPDATE RegisteredSessions " + (useSetClause ? setClause : "") + whereClause;
        logger.info("Executing query: " + query);
        db.execQuery(query);
        logger.info("Successfully updated record in DB (session_id: " + t.getSessionId() + ")");
    }

    @Override
    public void delete(RegisteredSession t) throws SQLException {
        String query = String.format("DELETE FROM RegisteredSessions WHERE session_id='%s'", new Object[]{t.getSessionId()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (session_id: " + t.getSessionId() + ")");
    }

    public RegisteredSession findBySessionId(String session_id) {
        String sql = String.format("SELECT * FROM RegisteredSessions WHERE session_id = '%s'", new Object[]{session_id});
        try {
            Pair<Connection, ResultSet> queryResult = db.resultQuery(sql);
            Connection dbconn = queryResult.getLeft();
            ResultSet rs = queryResult.getRight();
            while (rs.next()) {
                return readRegisteredSessionFromResultSet(rs);
            }
        } catch (SQLException e) {
            logger.error("Failed to find session by ID", e);
        }
        return null;
    }

    public String getNewSessionID() {
        String sql = "SELECT max(session_id) as session_id FROM RegisteredSessions";
        String maxSessionID = "S001";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();

            rs.next();
            String res = rs.getString("session_id");
            conn.close();
            if (res == null) {
                return maxSessionID;
            }

            maxSessionID = res;

        } catch (SQLException e) {
            logger.error("Fail to get max session id", e);
        }

        // U014
        // "014"
        int num = Integer.parseInt(maxSessionID.substring(1, maxSessionID.length())) + 1;
        maxSessionID = String.format("S%03d", new Object[]{num});
        return maxSessionID;
    }

    private RegisteredSession readRegisteredSessionFromResultSet(ResultSet rs) throws SQLException {
        return new RegisteredSession(
                rs.getString("session_id"),
                rs.getString("session_key"),
                rs.getString("room_size").charAt(0),
                rs.getInt("head_count"),
                rs.getString("session_date"),
                rs.getString("session_start_time"),
                rs.getString("session_end_time"),
                rs.getInt("date_created"),
                rs.getInt("date_modified")
        );
    }
}
