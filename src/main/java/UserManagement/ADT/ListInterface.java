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
     
     public boolean addDataFromFirst(int newPosition, T newEntry);
     
     public boolean addDataFromLast(int newPosition, T newEntry);
    
     public T deleteSelectList(int givenPosition);
     
     public void clear();
     
     public boolean changeData(int givenPosition, T newEntry);
     
     public T getData(int givenPosition);
     
     public boolean contain(T anEntry);
     
     public boolean checkEmpty();
     
     public int size();
     
}
