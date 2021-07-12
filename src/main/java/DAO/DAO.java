/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author zkang
 * @param <T> type used in this DAO
 */
public interface DAO<T> {

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}
