package DAO;

import DTO.UserDTO;
import Generic.DBManager;
import Generic.Pair;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Loo Zi Kang
 */
public class UserDAO implements DAOInterface<UserDTO> {

    private DBManager db;
    private final Logger logger = LogManager.getLogger(UserDAO.class.getName());
    private ArrayList<DTO.UserDTO> userArray;

    public UserDAO() {
        db = new DBManager();
    }

    @Override
    public ArrayList<UserDTO> getAll() {
        ArrayList<UserDTO> retArr = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet resultSet = result.getRight();

            while (resultSet.next()) {
                UserDTO userData = new UserDTO(
                        resultSet.getString("user_id"),
                        resultSet.getInt("privillage"),
                        resultSet.getString("name"),
                        resultSet.getString("pw_hash"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("member_point"),
                        resultSet.getString("member_level").charAt(0),
                        resultSet.getInt("date_created"),
                        resultSet.getInt("date_modified")
                );
                retArr.add(userData);
            }
            conn.close();
        } catch (SQLException e) {
            logger.error("Failed to get all user data");
        }
        return retArr;
    }

    @Override
    public void save(UserDTO t) throws SQLException {
        db = new DBManager();
        String sql = String.format(
                "INSERT INTO users VALUES('%s', %d, '%s', '%s', '%s', '%s', %d, '%s', %d, %d)",
                new Object[]{
                    t.getUser_id(),
                    t.getPrivillage(),
                    t.getName(),
                    t.getPw_hash(),
                    t.getFirst_name(),
                    t.getLast_name(),
                    t.getMember_point(),
                    t.getMember_level(),
                    t.getDate_created(),
                    t.getDate_modified()
                });
        db.execQuery(sql);
    }

    public UserDTO findUserById(String user_id) {
        String sql = String.format("SELECT * FROM users WHERE user_id = '%s'", new Object[]{user_id});
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();
            boolean found = false;
            while (rs.next()) {
                found = true;
                UserDTO userData = new UserDTO(
                        rs.getString("user_id"),
                        rs.getInt("privillage"),
                        rs.getString("name"),
                        rs.getString("pw_hash"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("member_point"),
                        rs.getString("member_level").charAt(0),
                        rs.getInt("date_created"),
                        rs.getInt("date_modified")
                );
                conn.close();
                return userData;
            }
            conn.close();
            return null;
        } catch (SQLException e) {
            logger.error("SQLError: Failed to find user by id");
        }
        return null;
    }

    @Override
    public void update(UserDTO t, HashMap params) throws SQLException {
        db = new DBManager();
        String setClause = "SET";
        String whereClause = String.format(" WHERE user_id= '%s'", t.getUser_id());
        
        boolean useSetClause = false;
        if (params.containsKey("privillage")){
            setClause += String.format("privillage = '%s',",params.get("privillage"));
        }
        if (params.containsKey("name")){
            setClause += String.format("name = '%s',",params.get("name"));
        }
        if (params.containsKey("pw_hash")){
            setClause += String.format("pw_hash = '%s',",params.get("pw_hash"));
        }
        if (params.containsKey("first_name")){
            setClause += String.format("first_name = '%s',",params.get("first_name"));
        }
        if (params.containsKey("last_name")){
            setClause += String.format("last_name = '%s',",params.get("last_name"));
        }
        if (params.containsKey("member_point")){
            setClause += String.format("member_point = '%s',",params.get("member_point"));
        }
        if (params.containsKey("member_level")){
            setClause += String.format("member_level = '%s',",params.get("member_level"));
        }
        if (params.containsKey("date_created")){
            setClause += String.format("date_created = '%s',",params.get("date_created"));
        }
        if (params.containsKey("date_modified")){
            setClause += String.format("date_modified = '%s',",params.get("date_modified"));
        }
        
        // Remove last character from setClause to remove additional ',' from string
        setClause = setClause.substring(0, setClause.length() - 1);

        String query = "UPDATE Users " + (useSetClause ? setClause : "") + whereClause;
        logger.info("Executing query: " + query);
        db.execQuery(query);
        logger.info("Successfully updated record in DB (user_id: " + t.getUser_id() + ")");
    }

    @Override
    public void delete(UserDTO t) throws SQLException {
        db = new DBManager();
        DBManager db = new DBManager();
        this.userArray.remove(t);
        String query = String.format("DELETE FROM Users WHERE user_id='%s'", new Object[]{t.getUser_id()});
        db.execQuery(query);
        logger.info("Successfully deleted record in DB (user_id: " + t.getUser_id() + ")");
    }

    public String getNewUserID() {
        String sql = "SELECT max(user_id) as user_id FROM Users";
        String maxUserID = "U001";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();

            rs.next();
            String res = rs.getString("user_id");
            conn.close();
            if (res == null) {
                return maxUserID;
            }

            maxUserID = res;

        } catch (SQLException e) {
            logger.error("Fail to get max users id", e);
        }

        // U014
        // "014"
        int num = Integer.parseInt(maxUserID.substring(1, maxUserID.length())) + 1;
        maxUserID = String.format("U%03d", new Object[]{num});
        return maxUserID;
    }

}
