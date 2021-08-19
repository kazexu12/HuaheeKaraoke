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
    private Node lastNode;
    private int numOfList;

    @Override
    public boolean addData(T newEntry) {
        Node newNode = new Node(newEntry);
        
        if (checkEmpty()){
            firstNode = newNode;
        }else{
            Node currentNode = firstNode;
            while (currentNode.next != null){ // if current Node no last node, then continue move to next node, and next node were become current node
                currentNode = currentNode.next;
            }
            currentNode.next = newNode; //if this is last node, then last node is cvurrent node
        }
        numOfList++;
        return true;
    }

   
    @Override
    public boolean addDataFromFirst(int nextPosition, T newEntry) {  //for add the data with choosing position
        boolean addSuccess = true;
        
        if((nextPosition >= 1) && (nextPosition <= numOfList + 1)){
            Node newNode = new Node (newEntry);
            
            if(checkEmpty() || (nextPosition == 1)){ //add at beginning place 
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
                Node nodeBefore = firstNode;  
                for(int i =0 ; i < nextPosition - 1; i++){
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
    public boolean addDataFromLast(int nextPosition, T newEntry) {  //for add the data with choosing position
        boolean addSuccess = true;
        
        if((nextPosition >= 1) && (nextPosition <= numOfList + 1)){
            Node newNode = new Node (newEntry);
            
            if(checkEmpty() || (nextPosition == 1)){ //add at beginning place 
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
                Node nodeBefore = firstNode;  
                for(int i =0 ; i < nextPosition - 1; i++){
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
    public T deleteSelectList(int givenPosition) { //Delete the data that have been choose
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= numOfList)){
            if(givenPosition == 1){
                result = firstNode.data;
                firstNode = firstNode.next;
            }else{
                Node nodeSelect = firstNode;
                for(int i = 1; i < givenPosition - 1; i++){
                    nodeSelect = nodeSelect.next;
                }
                result = nodeSelect.next.data;
                nodeSelect.next = nodeSelect.next.next; //skip the node which want to delete
            }
            numOfList--;
        }
        return result;
    }

    @Override
    public void clear() { //clear all data
        firstNode = null;
        numOfList = 0;
    }

    @Override
    public boolean changeData(int givenPosition, T newEntry) {
        boolean replaceSuccess = true;
        
        if ((givenPosition >= 1) && (givenPosition <= numOfList)){
            Node currentNode = firstNode;
            for(int i = 0; i < givenPosition - 1; i++){
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
            for (int i = 0; i < givenPosition - 1; i++){
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public boolean contain(T anEntry) { // if found is false, then means there are no have data in linkedlist list which same with data entry 
        boolean found = true;
        Node currentNode = firstNode;
        
        while(found && (currentNode != null)){
            if (anEntry.equals(currentNode.data)){
                return found;
            }else{
                currentNode = currentNode.next;
            }
    }
        found = false;
        return found;
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
    public int size(){
         return numOfList;
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
