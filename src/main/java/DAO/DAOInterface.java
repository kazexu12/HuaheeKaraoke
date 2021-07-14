
package DAO;

import SessionManagement.ADT.ArrayList;

/**
 * Abstract class for Data Access Objects used in this program
 * @author Loo Zi Kang
 * @param <T> type used in this DAO
 */
public interface DAOInterface<T> {

    ArrayList<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
