package SessionManagement.ADT;

/**
 * Interface for double ended queue
 * @author Loo Zi Kang
 * @param <T> type of the data to store
 */
public interface DequeInterface<T> {
    /**
     * Add item behind of the queue
     * @param item 
     */
    void pushBack(T item);
    
    /**
     * Add Item in front of the queue
     * @param item 
     */
    void pushFront(T item);
    
    /**
     * Remove item from the back of the queue
     * @return 
     */
    T removeBack();
    
    /**
     * Remove item from the front of queue
     * @return 
     */
    T removeFront();
    
    /**
     * Return the first item in queue without removing it
     * @return 
     */
    T peekFront();
    
    /**
     * Return the last item in queue without removing it
     * @return 
     */
    T peekBack();
    
    /**
     * Get the amount of items in queue
     * @return 
     */
    int size();
    
    /**
     * Check if queue is empty
     * @return 
     */
    boolean isEmpty();
    
    /**
     * Clear Queue
     */
    void clear();
}
