/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement.ADT;

import org.w3c.dom.Node;

/**
 *
 * @author ASUS
 */
public class Linkedlist<T> implements ListInterface<T>{
    
    private Node firstNode;
    private int numOfList;

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if (isEmpty()){
            firstNode = newNode;
        }else{
            Node currentNode = firstNode;
            while (currentNode.next != null){ // if no last node, then continue move to next node, and next node were become current node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; //if this is last node, then last node is cvurrent node
        }
        numOfList++;
        return true;
    }

   
    @Override
    public boolean add(int newPosition, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    

    @Override
    public T remove(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        firstNode = null;
        numOfList = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getEntry(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Node{
        private T data;
        private Node next;
        
        private Node(T data){
            this.data = data;
            this.next= null;
        }
        
        private Node (T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    
}
