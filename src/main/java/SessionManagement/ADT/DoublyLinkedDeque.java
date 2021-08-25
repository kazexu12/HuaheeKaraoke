package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> Type of data to store
 */
public class DoublyLinkedDeque<T> implements DequeInterface<T> {

    /**
     * Private Node class for linking data
     *
     * @param <T> Type of data to store
     */
    private class Node<T> {

        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node() {
            this.data = null;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> prev) {
            this.data = data;
            this.prev = prev;
        }

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public DoublyLinkedDeque() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    @Override
    public void pushBack(T item) {
        if (size == 0) {
            this.front = new Node<>(item);
            this.rear = this.front;
            size++;
            return;
        }
        Node<T> newNode = new Node<>(item);
        newNode.prev = this.rear;
        this.rear.next = newNode;
        this.rear = newNode;
        size++;
    }

    @Override
    public void pushFront(T item) {
        if (size == 0) {
            this.front = new Node<>(item);
            this.rear = this.front;
            size++;
            return;
        }
        Node<T> newData = new Node<>(item);
        newData.next = this.front;
        this.front.prev = newData;
        this.front = newData;
        size++;
    }

    @Override
    public T removeBack() {
        if (size == 0) {
            throw new IllegalStateException("There are no items to remove");
        }
        T data = this.rear.data;
        if (this.rear.prev != null) {
            this.rear.prev.next = null;
        }
        this.rear = this.rear.prev;
        size--;
        if (size == 0) {
            this.front = null;
            this.rear = null;
        }
        return data;
    }

    @Override
    public DequeInterface copy() {
        DoublyLinkedDeque<T> deque = new DoublyLinkedDeque<>();
        if (this.front == null) {
            return deque;
        }

        Node<T> ptr = this.front;
        while (ptr.next != null) {
            deque.pushBack(ptr.data);
            ptr = ptr.next;
        }
        return deque;
    }

    @Override
    public T removeFront() {
        if (size == 0) {
            throw new IllegalStateException("There are no items to remove");
        }
        T data = this.front.data;
        this.front = this.front.next;
        if (this.front != null) {
            this.front.prev = null;
        }
        size--;
        if (size == 0) {
            this.front = null;
            this.rear = null;
        }
        return data;
    }

    @Override
    public T peekFront() {
        if (this.front == null) {
            return null;
        }
        return this.front.data;
    }

    @Override
    public T peekBack() {
        if (this.rear == null) {
            return null;
        }
        return this.rear.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public java.util.Iterator<T> getForwardIterator() {
        return new ForwardIterator<>(this.front);
    }

    public java.util.Iterator<T> getReverseIterator() {
        return new ReverseIterator<>(this.rear);
    }

    /**
     * Iterator that starts from the front of the Deque
     *
     * @param <T>
     */
    private class ForwardIterator<T> implements java.util.Iterator<T> {

        private Node<T> pointer;

        public ForwardIterator(Node<T> root) {
            this.pointer = root;
        }

        @Override
        public boolean hasNext() {
            if (this.pointer == null) {
                return false;
            }

            if (this.pointer.data == null) {
                return false;
            }

            return true;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            T data = this.pointer.data;
            this.pointer = this.pointer.next;
            return data;
        }
    }

    /**
     * Iterator that starts from the rear of the Deque
     *
     * @param <T>
     */
    private class ReverseIterator<T> implements java.util.Iterator<T> {

        private Node<T> pointer;

        public ReverseIterator(Node<T> root) {
            this.pointer = root;
        }

        @Override
        public boolean hasNext() {
            if (this.pointer == null) {
                return false;
            }

            if (this.pointer.data == null) {
                return false;
            }

            return true;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
            }
            T data = this.pointer.data;
            this.pointer = this.pointer.prev;
            return data;
        }
    }

}
