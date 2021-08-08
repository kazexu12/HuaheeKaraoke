/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.ADT;

/**
 *
 * @author cafer
 */
public interface DictionaryInterface<K, V> {

    public V add(K key, V value);

    public V remove(K key);

    public V get(K key);

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public boolean isEmpty();

    public int size();

    public void clear();
    
}
