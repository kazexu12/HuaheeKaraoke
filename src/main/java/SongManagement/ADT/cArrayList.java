package SongManagement.ADT;
/**
*  @author : Chin Sze Sing
*  @Date   : 17/8/2021
*
*/
public class cArrayList<T> implements ArrayListInterface<T>{

    private int size =0;
    private T[] array;
    private static int DEFAULT_CAPACITY =5;
    
    
    public cArrayList(){
        size = 0;
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    public cArrayList(int tableSize){
        size = 0;
        array = (T[]) new Object[tableSize];
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
            if (i != this.size-1){
                array[i] = array[i+1];
            } 
        }
        array[this.size-1] = null;
        
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
        if(x < 0 || x >= this.size()) throw new RuntimeException();
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

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
        size = 0;
    }
}
