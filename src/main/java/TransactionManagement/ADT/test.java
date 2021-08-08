/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.ADT;

/**
 *
 * @author cafer
 */
public class test {
    public static void main(String[] args) {
        HashMap<Integer, String> test = new HashMap();
        
        test.add(20, "Test");
        test.add(121, "Aaaaaa");
        
        System.out.print(test.remove(121));
    }
}
