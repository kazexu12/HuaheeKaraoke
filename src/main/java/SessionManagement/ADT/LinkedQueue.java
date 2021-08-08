package SessionManagement.ADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Loo Zi Kang
 * @param <T> type of data this LinkedQueue stores
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public LinkedQueue() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void enqueue(T data) {
        if (first == null || last == null) {
            first = new Node(data);
            last = first;
            return;
        }

        Node newLast = new Node(data);
        last.next = newLast;
        this.last = newLast;
        size++;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T retData = first.data;
        first = first.next;
        return retData;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private class LinkedQueueIterator implements java.util.Iterator<T> {

        private Node currentNode;

        public LinkedQueueIterator() {
            currentNode = first;
        }
 
       @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T data = (T) currentNode.data;
            currentNode = currentNode.next;
            return data;
        }

    }

    @Override
    public Iterator<T> getIterator() {
        return new LinkedQueueIterator();
    }

}
