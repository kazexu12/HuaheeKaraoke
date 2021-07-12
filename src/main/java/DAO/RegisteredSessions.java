package DAO;

import DTO.RegisteredSession;
import Generic.DBManager;
import Generic.Pair;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author zkang
 */
public class RegisteredSessions implements DAO<RegisteredSession> {

    private final Logger logger = LogManager.getLogger(RegisteredSessions.class.getName());
    private List<DTO.RegisteredSession> sessions;
    private boolean ready;

    public RegisteredSessions() {
        ready = false;
        DBManager db = new DBManager();
        sessions = new ArrayList<>();
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
            return;
        }
        ready = true;
    }

    @Override
    public List<RegisteredSession> getAll() {
        return sessions;
    }

    @Override
    public void save(RegisteredSession t) {

    }

    @Override
    public void update(RegisteredSession t, String[] params) {

    }

    @Override
    public void delete(RegisteredSession t) {

    }

}
