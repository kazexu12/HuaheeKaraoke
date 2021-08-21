/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.ADT;

import java.io.Serializable;

/**
 *
 * @author cafer
 */
public class HashMap<K, V> implements DictionaryInterface<K, V>, Serializable {

    private Node<K, V>[] hashTable;
    private int numberOfEntries;
    private static final int DEFAULT_SIZE = 101;

    public HashMap() {
        hashTable = new Node[DEFAULT_SIZE];
    }

    public HashMap(int tableSize) {
        int primeSize = nextPrime(tableSize);

        hashTable = new Node[primeSize];
    }

    @Override
    public V add(K key, V value) {
        boolean isAdded = false;
        int index = 0;

        // Double hashing.
        int turn = 0;
        while (!isAdded) {
            if (hashTable.length >= numberOfEntries) {
                expandTable();
            }

            index = hash1(key) + turn * hash2(key);
            
            // Jump back to starting point if index is larger than array length.
            index %= hashTable.length;
            if (index < 0) index *= -1;

            if (hashTable[index] == null) {
                hashTable[index] = new Node(key, value);

                numberOfEntries++;
                isAdded = true;
            } else {
                turn++;
            }
        }

        return value;
    }

    @Override
    public V remove(K key) {
        V removedValue = null;
        int index = 0;

        // Double hashing.
        for (int turn = 0; turn < hashTable.length; turn++) {
            
            index = hash1(key) + turn * hash2(key);
            index %= hashTable.length;
            if (index < 0) index *= -1;

            if (hashTable[index] == null) {
                break;
            } else if (hashTable[index].key.equals(key)) {
                removedValue = hashTable[index].value;
                hashTable[index] = null;
                
                numberOfEntries--;
                break;
            }
            
        }

        return removedValue;
    }

    @Override
    public V get(K key) {
        V getValue = null;
        int index = 0;

        // Double hashing.
        for (int turn = 0; turn < hashTable.length; turn++) {
            
            index = hash1(key) + turn * hash2(key);
            index %= hashTable.length;
            if (index < 0) index *= -1;
            
            if (hashTable[index] == null) {
                break;
            } else if (hashTable[index].key.equals(key)) {
                getValue = hashTable[index].value;
                break;
            }
        }

        return getValue;
    }

    @Override
    public boolean containsKey(K key) {
        boolean isContain = false;
        int index = 0;

        // Double hashing.
        for (int turn = 0; turn < hashTable.length; turn++) {
            index = hash1(key) + turn * hash2(key);

            if (hashTable[index] == null) {
                break;
            } else if (hashTable[index].key.equals(key)) {
                isContain = true;
                break;
            }
        }

        return isContain;
    }

    @Override
    public boolean containsValue(V value) {
        boolean isContain = false;
        
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].value.equals(value)) {
                isContain = true;
                break;
            }
        }
        
        return isContain;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public void clear() {
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = null;
        }

        numberOfEntries = 0;
    }

    // -------------------------------------------------------------------------
    private int hash1(K key) {
        return key.hashCode() % 7;
    }

    private int hash2(K key) {
        return 5 - (key.hashCode() % 5);
    }

    // https://www.geeksforgeeks.org/program-to-find-the-next-prime-number/
    private boolean isPrime(int n) {
        // Corner cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private int nextPrime(int n) {

        // Base case
        if (n <= 1) {
            return 2;
        }

        int prime = n;
        boolean found = false;

        // Loop continuously until isPrime returns
        // true for a number greater than n
        while (!found) {
            prime++;

            if (isPrime(prime)) {
                found = true;
            }
        }

        return prime;
    }

    private void expandTable() {
        Node<K, V>[] newTable = new Node[nextPrime(hashTable.length + 1)];
        
        for (int i = 0; i < hashTable.length; i++) {
            newTable[i] = hashTable[i];
        }
        
        hashTable = newTable;
    }
    
    private class Node<K, V> implements Serializable {

        private K key;
        private V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
