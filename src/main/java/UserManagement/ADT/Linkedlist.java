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
    public boolean addData(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if (checkEmpty()){
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
    public boolean addData(int nextPosition, T newEntry) {
        boolean addSuccess = true;
        
        if((nextPosition >= 1) && (nextPosition <= numOfList + 1)){
            Node newNode = new Node (newEntry);
            
            if(checkEmpty() || (nextPosition == 1)){ //add at beginning place 
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
                Node nodeBefore = firstNode;  
                for(int i =0 ; i < nextPosition - 1; ++i){
                    nodeBefore = nodeBefore.next;
                }
                
                newNode.next = nodeBefore.next;
                nodeBefore.next = newNode;
            }
            
            numOfList++;
            
        }else{
            addSuccess = false;
        }
        
        return addSuccess;
    }
  
    

    @Override
    public T deleteSelectList(int givenPosition) {
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= numOfList)){
            if(givenPosition == 1){
                result = firstNode.data;
                firstNode = firstNode.next;
            }else{
                Node nodeSelect = firstNode;
                for(int i = 1; i < givenPosition - 1; ++i){
                    nodeSelect = nodeSelect.next;
                }
                result = nodeSelect.next.data;
                nodeSelect.next = nodeSelect.next.next;
            }
            numOfList--;
        }
        return result;
    }

    @Override
    public void clear() {
        firstNode = null;
        numOfList = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean replaceSuccess = true;
        
        if ((givenPosition >= 1) && (givenPosition <= numOfList)){
            Node currentNode = firstNode;
            for(int i = 0; i < givenPosition - 1; ++i){
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        }else{
            replaceSuccess = false;
        }
        return replaceSuccess;
    }

    @Override
    public T getData(int givenPosition) { //get data result of givenPosition
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= numOfList)){
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i){
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public boolean checkEquals(T anEntry) { // if found is false, then means there are no have data in linkedlist list which same with data entry 
        boolean found = true;
        Node currentNode = firstNode;
        
        while(found && (currentNode != null)){
            if (anEntry.equals(currentNode != null)){
                found = true;
            }else{
                currentNode = currentNode.next;
            }
    }
        return found = false;
    }

    @Override
    public boolean checkEmpty() {  //check the linkedlist is empty of not
        
        if (numOfList == 0)
        {
             return true;
        } else
        {
            return false;
        }
       
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
