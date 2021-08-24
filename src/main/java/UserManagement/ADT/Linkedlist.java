/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement.ADT;

/**
 *
 * @author ASUS
 */
public class Linkedlist<T> implements ListInterface<T> {

    private Node firstNode;
    private Node lastNode;
    private int numOfList;

    @Override
    public boolean addData(T newEntry) {
        if (numOfList == 0) {
            firstNode = new Node(newEntry);
            lastNode = firstNode;
            numOfList++;
            return true;
        }
        Node newLastNode = new Node(newEntry);
        lastNode.next = newLastNode;
        lastNode = newLastNode;
        numOfList++;
        return true;
    }

    @Override
    public boolean addData(int nextPosition, T newEntry) {  //for add the data with choosing position
        Node ptr = firstNode;
        if ((nextPosition < 1) || (nextPosition > numOfList + 1)) {
            return false;
        }

        if (numOfList == 0) {
            firstNode = new Node(newEntry);
            lastNode = firstNode;
            numOfList++;
            return true;
        }

        if (nextPosition == 1) {
            Node newData = new Node(newEntry);
            newData.next = firstNode;
            firstNode = newData;
            numOfList++;
            return true;
        }

        if (nextPosition == numOfList + 1) {
            Node newData = new Node(newEntry);
            lastNode.next = newData;
            lastNode = newData;
            numOfList++;
            return true;
        }

        while (nextPosition > 2) {
            ptr = ptr.next;
            nextPosition--;
        }

        Node newData = new Node(newEntry);
        newData.next = ptr.next;
        ptr.next = newData;

        numOfList++;
        return true;
    }

    @Override
    public T deleteSelectList(int givenPosition) {
        if (givenPosition < 1 || givenPosition > numOfList) {
            return null;
        }

        if (givenPosition == 1) {
            T ret = firstNode.data;
            firstNode = firstNode.next;
            numOfList--;
            return ret;
        }

        if (givenPosition == numOfList) {
            T ret = lastNode.data;
            lastNode = lastNode.next;
            numOfList--;
            return ret;
        }

        Node ptr = firstNode;
        while (givenPosition > 2) {
            ptr = ptr.next;
            givenPosition--;
        }

        T removeItem = ptr.next.data;
        ptr.next = ptr.next.next;
        numOfList--;
        return removeItem;

    }

    @Override
    public void clear() { //clear all data
        firstNode = null;
        numOfList = 0;
    }

    @Override
    public boolean changeDataFromFront(int givenPosition, T newEntry) {
        boolean replaceSuccess = true;

        if ((givenPosition >= 0) && (givenPosition < numOfList)) {
            Node currentNode = firstNode;
            for (int i = 0; i <= givenPosition; ++i) {
                if(i == givenPosition){
                    currentNode.data = newEntry;
                }
                currentNode = currentNode.next;
            } 
        } else {
            replaceSuccess = false;
        }
        return replaceSuccess;
    }

    @Override
    public T getDataFromFront(int givenPosition) { //get data result of givenPosition
        var ori = givenPosition;
        if (givenPosition < 1 || givenPosition > numOfList) {
            return null;
        }
        Node ptr = this.firstNode;
        while (givenPosition != 1) {
            ptr = ptr.next;
            givenPosition--;
        }
        if (ptr == null) {
            return null;
        }
        return ptr.data;
    }

    @Override
    public T getDataForChecking(int givenPosition) {
    T result = null;

    if ((givenPosition >= 0) && (givenPosition < numOfList)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }

    @Override
    public boolean contain(T anEntry) { // if found is false, then means there are no have data in linkedlist list which same with data entry 
        boolean found = true;
        Node currentNode = firstNode;

        while (found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                return found;
            } else {
                currentNode = currentNode.next;
            }
        }
        found = false;
        return found;
    }

    @Override
    public boolean checkEmpty() {  //check the linkedlist is empty of not

        if (numOfList == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int size() {
        return numOfList;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
