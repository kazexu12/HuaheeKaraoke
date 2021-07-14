package SessionManagement.ADT;

/**
 * 
 * @author Loo Zi Kang
 * @param <T> type of objects to store
 */
public class ArrayList<T> implements ListInterface<T> {

    private Object[] arr;

    public ArrayList() {
        arr = new Object[]{};
    }

    @Override
    public void add(T item) {
        final int newSize = size() + 1;
        Object[] newArr = new Object[newSize];
        int i;
        for (i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[i] = item;
        arr = newArr;
    }

    @Override
    public void add(int pos, T item) {
        if (pos < 0) {
            throw new RuntimeException("Cannot insert at negative position " + pos);
        }

        if (pos > size()) {
            throw new RuntimeException("Cannot insert at position that exceed list size: " + pos);
        }

        final int newSize = size() + 1;
        Object[] newArr = new Object[newSize];
        int i;
        int j;
        for (i = 0, j = 0; i < pos; i++) {
            newArr[j++] = arr[i];
        }
        newArr[j++] = item;
        for (; i < size(); i++) {
            newArr[j++] = arr[i];
        }
        arr = newArr;
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
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T get(int pos) {
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
        final int newSize = size() - 1;
        Object[] newArr = new Object[newSize];
        int i;
        int j;
        T removedItem = null;
        for (i = 0, j = 0; i < size(); i++) {
            if (i == pos) {
                removedItem = (T) arr[i];
                continue;
            }
            newArr[j++] = arr[i];
        }
        arr = newArr;
        return removedItem;
    }
    
    @Override
    public T remove(Object o) {
        if(isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        final int newSize = size() - 1;
        Object[] newArr = new Object[newSize];
        int i;
        int j;
        T removedItem = null;
        for (i = 0, j = 0; i < size(); i++) {
            if (arr[i].equals(o)) {
                removedItem = (T) arr[i];
                continue;
            }
            newArr[j++] = arr[i];
        }
        arr = newArr;
        return removedItem;
    }

}
