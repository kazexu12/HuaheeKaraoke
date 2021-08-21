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
public class test {
    public static void main(String[] args){
        Linkedlist<String> llist = new Linkedlist();
        
        llist.addData("Hello");
        llist.addData("Fuck!");
        llist.addData("AAAAAA!");
        llist.addData("NOOOOO!");
 

       
        
 
            System.out.print(llist.getDataFromFront(0));
            System.out.print(llist.getDataFromFront(1));
            System.out.print(llist.getDataFromFront(2));


        
        
    }
}
