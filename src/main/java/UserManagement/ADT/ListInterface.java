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
    
     public boolean add(T newEntry);
     
     public boolean add(int newPosition, T newEntry);
    
     public T remove(int givenPosition);
     
     public void clear();
     
     public boolean replace(int givenPosition, T newEntry);
     
     public T getEntry(int givenPosition);
     
     public boolean contains(T anEntry);
     
     public boolean isEmpty();
     
     public boolean isFull();
     
}