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
        HashMap<String, String> test = new HashMap();
        
        for (int i = 0; i < 120; i++) {
            test.add("test" + i, "test" + i);
        }
        
        System.out.print(test.get("test118"));
    }
}
