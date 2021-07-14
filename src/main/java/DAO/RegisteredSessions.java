package DAO;

import DTO.RegisteredSession;
import Generic.DBManager;
import Generic.Pair;
import SessionManagement.ADT.ArrayList;
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
    private ArrayList<DTO.RegisteredSession> sessions;

    public RegisteredSessions() {
        sessions = new ArrayList<>();

        DBManager db = new DBManager();
        String query = "SELECT * FROM RegisteredSessions;";
        Pair<Connection, ResultSet> queryResult;
        Connection dbconn;
        ResultSet sessionResult;
        try {
            queryResult = db.resultQuery(query);
            dbconn = queryResult.getLeft();
            sessionResult = queryResult.getRight();
        } catch (SQLException e) {
            logger.error("Unable to query registered sessions from DB", e);
            return;
        }

        try {
            while (sessionResult.next()) {
                RegisteredSession sess = new RegisteredSession(
                        sessionResult.getString("session_id"),
                        sessionResult.getString("session_key"),
                        sessionResult.getString("room_size").charAt(0),
                        sessionResult.getInt("head_count"),
                        sessionResult.getString("session_date"),
                        sessionResult.getString("session_start_time"),
                        sessionResult.getString("session_end_time"),
                        sessionResult.getInt("date_created"),
                        sessionResult.getInt("date_modified")
                );
                sessions.add(sess);
            }
        } catch (SQLException e) {
            logger.error("Unable to read ResultSet of registered session query", e);
        }
    }

    @Override
    public ArrayList<RegisteredSession> getAll() {
        return sessions;
    }

    @Override
    public void save(RegisteredSession t) throws SQLException {
        DBManager db = new DBManager();
        Object[] args = new Object[]{
            t.getSession_id(),
            t.getSession_key(),
            t.getRoom_size(),
            t.getHead_count(),
            t.getSession_date(),
            t.getSession_start_time(),
            t.getSession_end_time()
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
        logger.info("Successfully added record in DB (session_id: " + t.getSession_id() + ")");

        this.sessions.add(t);
    }

    @Override
    public void update(RegisteredSession t, HashMap<String, Object> params) throws SQLException {
        DBManager db = new DBManager();
        String setClause = "SET ";
        String whereClause = String.format(" WHERE session_id='%s'", t.getSession_id());

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
        logger.info("Successfully updated record in DB (session_id: " + t.getSession_id() + ")");
    }

    @Override
    public void delete(RegisteredSession t) throws SQLException {
        DBManager db = new DBManager();
        this.sessions.remove(t);
        String query = String.format("DELETE FROM RegisteredSessions WHERE session_id='%s'", new Object[]{t.getSession_id()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (session_id: " + t.getSession_id() + ")");
    }
}
