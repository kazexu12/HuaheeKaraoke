/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement.Utility;

import TransactionManagement.ADT.HashMap;

/**
 *
 * @author cafer
 */
public class StatusString {
    HashMap<Integer, String> hm;
    
    public StatusString() {
        hm = new HashMap();
        hm.add(0, "Expired");
        hm.add(1, "Active");
        hm.add(2, "Refunded");
    }
    
    public String get(int key) {
        return hm.get(key);
    }
    
}
