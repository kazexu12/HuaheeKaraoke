/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> type of this queue
 */
public interface QueueInterface<T> {

    public void enqueue(T data);

    public T dequeue();

    public T peek();

    public boolean isEmpty();
    
    public void clear();
            
    public java.util.Iterator<T> getIterator();
}
