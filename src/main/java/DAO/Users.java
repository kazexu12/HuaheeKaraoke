package DAO;

import DTO.User;
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
public class Users implements DAOInterface<User> {

    private DBManager db;
    private final Logger logger = LogManager.getLogger(Users.class.getName());

    public Users() {
        db = new DBManager();
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> retArr = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet resultSet = result.getRight();

            while (resultSet.next()) {
                User userData = new User(
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
    public void save(User t) throws SQLException {
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

    public User findUserById(String user_id) {
        String sql = String.format("SELECT * FROM users WHERE user_id = '%s'", new Object[]{user_id});
        try {
            Pair<Connection, ResultSet> result = db.resultQuery(sql);
            Connection conn = result.getLeft();
            ResultSet rs = result.getRight();
            boolean found = false;
            while (rs.next()) {
                found = true;
                User userData = new User(
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
    public void update(User t, HashMap params) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
