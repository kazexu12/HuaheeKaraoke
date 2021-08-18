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
public interface ListInterface <T> {
    
     public boolean addData(T newEntry);
     
     public boolean addData(int newPosition, T newEntry);
    
     public T deleteSelectList(int givenPosition);
     
     public void clear();
     
     public boolean replace(int givenPosition, T newEntry);
     
     public T getData(int givenPosition);
     
     public boolean checkEquals(T anEntry);
     
     public boolean checkEmpty();
     
     public boolean isFull();
     
}
