package SessionManagement.ADT;

/**
 * Interface for double ended queue
 * @author Loo Zi Kang
 * @param <T> type of the data to store
 */
public interface DequeInterface<T> {
    /**
     * Add item behind of the Deque
     * @param item 
     */
    void pushBack(T item);
    
    /**
     * Add Item in front of the Deque
     * @param item 
     */
    void pushFront(T item);
    
    /**
     * Remove item from the back of the Deque
     * @return 
     */
    T removeBack();
    
    /**
     * Remove item from the front of Deque
     * @return 
     */
    T removeFront();
    
    /**
     * Return the first item in Deque without removing it
     * @return 
     */
    T peekFront();
    
    /**
     * Return the last item in Deque without removing it
     * @return 
     */
    T peekBack();
    
    /**
     * Get the amount of items in Deque
     * @return 
     */
    int size();
    
    /**
     * Get a shallow copy of the Deque
     * @return 
     */
    DequeInterface copy();
    
    /**
     * Check if Deque is empty
     * @return 
     */
    boolean isEmpty();
    
    /**
     * Clear Queue
     */
    void clear();
}
