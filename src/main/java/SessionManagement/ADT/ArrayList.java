package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> type of objects to store
 */
public class ArrayList<T> implements ListInterface<T> {

    private T[] arr;
    private final int DEFAULT_CAPACITY = 5;
    private int size;

    public ArrayList() {
        size = 0;
        arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(T item) {
        if (size == arr.length) {
            expandArray();
        }
        arr[size++] = item;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final ArrayList<?> other = (ArrayList<?>) obj;
        if (other.size() != this.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (!arr[i].equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0) {
            throw new RuntimeException("Cannot insert at negative position " + pos);
        }

        if (pos > size()) {
            throw new RuntimeException("Cannot insert at position that exceed list size: " + pos);
        }

        if (size == arr.length) {
            expandArray();
        }

        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = item;
        size++;
    }

    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size(); i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T get(int pos) {
        if (pos >= size || pos < 0) {
            throw new RuntimeException("Cannot get item at pos: " + pos + "; Reason: Out of bound");
        }
        return (T) arr[pos];
    }

    @Override
    public T remove(int pos) {
        if (pos < 0) {
            throw new RuntimeException("Cannot delete at negative position " + pos);
        }

        if (pos > size()) {
            throw new RuntimeException("Cannot delete in position that do not exists: " + pos);
        }
        
        if(pos == 0 && size == 1) {
            size--;
            return arr[0];
        }

        if (pos == size - 1) {
            size--;
            return arr[size - 1];
        }

        T returnObj = arr[pos];

        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;
        return returnObj;
    }

    @Override
    public T remove(Object o) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        boolean found = false;
        int i;
        for (i = 0; i < arr.length; i++) {
            if (arr[i].equals(o)) {
                found = true;
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("Object is not in the list");
        }
        return remove(i);
    }
    @Override
    public ListInterface copy() {
        ArrayList<T> cloned = new ArrayList<>();
        for(int i = 0; i < this.size; i++) {
            cloned.add(this.arr[i]);
        }
        return cloned;
    }

    private void expandArray() {
        final int newLength = arr.length * 2;
        T[] newArr = (T[]) new Object[newLength];
        System.arraycopy(arr, 0, newArr, 0, size());
        arr = newArr;
    }
}
