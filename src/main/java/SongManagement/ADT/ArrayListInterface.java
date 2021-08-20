/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SongManagement.ADT;

/**
 *
 * @author  : Chin Sze Sing
 * @Date    : 17/8/2021
 */
public interface ArrayListInterface<T> {
    
    public abstract void add(T element);
    
    public abstract void add(int x,T element);
    
    public abstract T remove(int x);
    
    public abstract T get(int x);
    
    public abstract T set(int x, T element);
    
    public abstract int size();
    
    public abstract boolean isEmpty();
    
    public abstract int find(T element);
    
    public abstract void clear();
}
