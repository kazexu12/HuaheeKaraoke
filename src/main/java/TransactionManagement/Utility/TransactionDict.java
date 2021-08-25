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
public class TransactionDict {
    HashMap<Character, String> memberTypeLabel;
    HashMap<Character, Double> memberTypeDiscountPrice;
    HashMap<Integer, Character> roomSizeCharacter;
    HashMap<Integer, String> statusLabel;
    
    public TransactionDict() {
        memberTypeLabel = new HashMap<>();
        memberTypeLabel.add('N', "Normal");
        memberTypeLabel.add('S', "Silver");
        memberTypeLabel.add('G', "Gold");

        memberTypeDiscountPrice = new HashMap<>();
        memberTypeDiscountPrice.add('N', 0.00);
        memberTypeDiscountPrice.add('S', 5.00);
        memberTypeDiscountPrice.add('G', 10.00);

        roomSizeCharacter = new HashMap<>();
        roomSizeCharacter.add(0, 'S');
        roomSizeCharacter.add(1, 'M');
        roomSizeCharacter.add(2, 'L');
        
        statusLabel = new HashMap();
        statusLabel.add(0, "Expired");
        statusLabel.add(1, "Active");
        statusLabel.add(2, "Refunded");
    }
    
    public String getMemberTypeLabel(char key) {
        return memberTypeLabel.get(key);
    }
    
    public double getMemberTypeDiscountPrice(char key) {
        return memberTypeDiscountPrice.get(key);
    }
    
    public char getRoomSizeCharacter(int key) {
        return roomSizeCharacter.get(key);
    }
    
    public String getStatusLabel(int key) {
        return statusLabel.get(key);
    }
}
