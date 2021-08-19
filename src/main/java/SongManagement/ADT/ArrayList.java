package SongManagement.ADT;
/**
*  @author : Chin Sze Sing
*  @Date   : 17/8/2021
*
*/
public class ArrayList<T> implements ArrayListInterface<T>{

    private int size;
    private T[] array;
    private static int DEFAULT_CAPACITY =5;
    
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayList(int initialCapacity){
        size = 0;
        array = (T[]) new Object[initialCapacity];
    }
    
    private void extandArray(){
        int arrayLength = array.length;
        T[] temp = (T[])new Object[2 * arrayLength];
        for(int i = 0; i < this.size; i++){
            temp[i] = array[i];	
        }
        array = temp;
    }
    
    @Override
    public void add(T element){
	if(this.size == array.length){
            extandArray();
        }
	array[size] = element;
	size++;
    }
    
    @Override
    public void add(int x, T element){
        if (x < 0) {
            throw new RuntimeException("Cannot insert data at the negative position: " + x);
        }

        if (x > size()) {
            throw new RuntimeException("Position that exceed the list size: " + x);
        }

        if (size == array.length) {
            extandArray();
        }

        for (int i = size; i > x; i--) {
            array[i] = array[i - 1];
        }
        array[x] = element;
        size++;
    }

    @Override
    public T remove(int x) {
        if(x < 0 || x >= this.size) throw new RuntimeException();
	T returnElement = array[x];
	for(int i = x; i < this.size; i++){
            array[i] = array[i+1];
        }
        array[this.size] = null;
        this.size--;
	return returnElement;
    }

    @Override
    public T get(int x) {
        if(x < 0 || x >= this.size) throw new RuntimeException();
	return array[x];
    }

    @Override
    public T set(int x, T element) {
        if(x < 0 || x >= this.size) throw new RuntimeException();
	T returnElement = array[x];
	array[x] = element;
	return returnElement;	
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int find(T element) {
        int arrayNum = -1;
	for(int i = 0; i < this.size; i++){
            if(array[i].equals(element)){
                arrayNum = i;
		break;
            }
        }
        return arrayNum;
    }
}
