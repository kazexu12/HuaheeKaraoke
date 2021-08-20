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
    public T deleteSelectList(int givenPosition) { //Delete the data that have been choose
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numOfList)) {
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node nodeSelect = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
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
    public boolean changeDataFromFront(int givenPosition, T newEntry) {
        boolean replaceSuccess = true;

        if ((givenPosition >= 1) && (givenPosition <= numOfList)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            replaceSuccess = false;
        }
        return replaceSuccess;
    }

    @Override
    public boolean changeDataFromLast(int givenPosition, T newEntry) {
        boolean replaceSuccess = true;

        if ((givenPosition >= 1) && (givenPosition <= numOfList)) {
            Node currentNode = firstNode;
            for (int i = numOfList; i < givenPosition - 1; --i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        } else {
            replaceSuccess = false;
        }
        return replaceSuccess;
    }

    @Override
    public T getDataFromFront(int givenPosition) { //get data result of givenPosition
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numOfList)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            result = currentNode.data;
        }
        return result;
    }

    @Override
    public T getDataFromLast(int givenPosition) { //get data result of givenPosition
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numOfList)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
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
