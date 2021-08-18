package SongManagement.ADT;
/**
*  @author : Chin Sze Sing
*  @Date   : 17/8/2021
*
*/
public class ArrayList<T> implements ArrayListInterface<T>{

    private int size;
    private T[] array;
    private static int DEFAULT_CAPACITY =10;
    
    public ArrayList(){
        size = 0;
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    private void extandArray(){
        int arrayLength = array.length;
        T[] temp = (T[])new Object[2 * arrayLength];
        for(int i = 0; i < this.size; i++){
            temp[i] = array[i];	
        }
        array = temp;
    }
    
    public void add(T element){
	if(this.size == array.length){
            extandArray();
        }
	array[size] = element;
	size++;
    }
    
    @Override
    public void add(int x, T element){
        if(x >= 0 || x < array.length){
            if(x < this.size){
                if(this.size == array.length)extandArray();
                for(int i = this.size-1; i >= x; i--){
                    array[i+1] = array[i];
                }
                array[x] = element;
                size++;
            }	
        }
        else if(x == array.length){
            add(element);
        }
        else throw new RuntimeException();
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
