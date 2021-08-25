/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement.ADT;

import DAO.UserDAO;
import DTO.UserDTO;
import java.util.ArrayList;



/**
 *
 * @author ASUS
 */
public class test {
    public static void main(String[] args){
        
        ArrayList<UserDTO> db;
        Linkedlist<String> llist = new Linkedlist();
        UserDAO ur = new UserDAO();
        db = ur.getAll();
        Linkedlist<UserDTO> dbllist = new Linkedlist();
        llist.addData("Hello");
        llist.addData("Fuck!");
        llist.addData("AAAAAA!");
        llist.addData("NOOOOO!");
        
        int success = 0;
        int getId = 0;
        llist.changeDataFromFront(3, "fucking!!");
        for(int i = 0; i < llist.size(); i++ ){
            if(llist.contain("Fuck!")){
                System.out.print("Ok!");
            }
           
            }
        
        if(llist.checkEmpty()){
            System.out.printf("OMG");
        }else{
            System.out.printf("SUCCESS");
        }
        
        }

    }
