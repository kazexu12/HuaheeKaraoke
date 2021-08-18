
package DAO;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Abstract class for Data Access Objects used in this program
 * @author Loo Zi Kang
 * @param <T> type used in this DAO
 */
public interface DAOInterface<T> {

    /**
     * Return all data in database in form of Arraylist
     * @return 
     */
    ArrayList<T> getAll();

    /**
     * Insert data into database.
     * If there is an conflict in primary key, the function should throw SQLException
     * @param t
     * @throws SQLException 
     */
    void save(T t) throws SQLException;

    /**
     * Update data in database. Will use primary key in the data to determine which data to update
     * @param t
     * @throws SQLException 
     */
    void update(T t, HashMap<String, Object> params) throws SQLException;

    /**
     * Delete a data in database
     * @param t
     * @throws SQLException 
     */
    void delete(T t) throws SQLException;
}
