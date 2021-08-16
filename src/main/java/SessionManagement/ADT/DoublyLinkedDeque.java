package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> Type of data to store
 */
public class DoublyLinkedDeque<T> implements DequeInterface<T> {

    class Node<T> {

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
    public void add(T item) {
        if (size == 0) {
            this.front = new Node<>(item);
            this.rear = this.front;
            size++;
            return;
        }
        Node<T> ptr = this.front;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node<>(item, ptr);
        this.rear = ptr.next;
        size++;
    }

    @Override
    public void push(T item) {
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
    public T remove() {
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

//    @Override
//    public T remove(T item) {
//        if (size == 0) {
//            throw new IllegalStateException("There are no items to remove");
//        }
//        Node<T> ptr = this.front;
//        while (ptr != null) {
//            if (ptr.data.equals(item)) {
//                ptr.prev.next = ptr.next;
//                ptr.next.prev = ptr.prev;
//                break;
//            }
//            ptr = ptr.next;
//        }
//        size--;
//        if (size == 0) {
//            this.front = null;
//            this.rear = null;
//        }
//        return item;
//    }

    @Override
    public T pop() {
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
    public T poll() {
        if (this.front == null) {
            return null;
        }
        return this.front.data;
    }

    @Override
    public T peek() {
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

}
