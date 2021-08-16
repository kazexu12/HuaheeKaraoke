package SessionManagement.ADT;

/**
 * Interface for double ended queue
 * @author Loo Zi Kang
 * @param <T> type of the data to store
 */
public interface DequeInterface<T> {
    /**
     * Add item in front of the queue
     * @param item 
     */
    void add(T item);
    
    /**
     * Add Item behind the queue
     * @param item 
     */
    void push(T item);
    
    /**
     * Remove item from the front of the queue
     * @return 
     */
    T remove();
    
    /**
     * Remove specific item from queue
     * @param item
     * @return 
     */
    T remove(T item);
    
    /**
     * Remove last item from queue
     * @return 
     */
    T pop();
    
    /**
     * Return the first item in queue without removing it
     * @return 
     */
    T poll();
    
    /**
     * Return the last item in queue without removing it
     * @return 
     */
    T peek();
    
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
