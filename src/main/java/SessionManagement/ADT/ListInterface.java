/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> Type of the list
 */
public interface ListInterface<T> {
    public abstract void add(T item);
    public abstract void add(int pos, T item);
    public abstract boolean contains(T item);
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract T get(int pos);
    public abstract T remove(int pos);
}
