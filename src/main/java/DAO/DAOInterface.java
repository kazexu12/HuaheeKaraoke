
package DAO;

import SessionManagement.ADT.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Abstract class for Data Access Objects used in this program
 * @author Loo Zi Kang
 * @param <T> type used in this DAO
 */
public interface DAOInterface<T> {

    ArrayList<T> getAll();

    void save(T t) throws SQLException;

    void update(T t, HashMap<String, Object> params) throws SQLException;

    void delete(T t) throws SQLException;
}
