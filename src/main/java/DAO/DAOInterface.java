
package DAO;

import java.util.List;

/**
 * Abstract class for Data Access Objects used in this program
 * @author Loo Zi Kang
 * @param <T> type used in this DAO
 */
public interface DAOInterface<T> {

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
