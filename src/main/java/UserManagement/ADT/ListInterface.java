/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement.ADT;

public interface ListInterface <T> {
    
     public boolean addData(T newEntry);
     
     public boolean addData(int newPosition, T newEntry);
    
     public T deleteSelectList(int givenPosition);
     
     public void clear();
     
     public boolean changeDataFromFront(int givenPosition, T newEntry);
     
     public T getDataFromFront(int givenPosition);
     
     public T getDataForChecking(int givenPosition);
     
     public boolean contain(T anEntry);
     
     public boolean checkEmpty();
     
     public int size();
     
}
