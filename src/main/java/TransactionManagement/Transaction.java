/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionManagement;

/**
 *
 * @author cafer
 */
public class Transaction {

    String id;
    char roomSize;
    int headCount;
    int discount;

    // need to change to user customer class instead.
    String memberId;
    char memberLevel;

    // need to change to user staff class instead.
    String staffId;

    public String Transaction(String memberId, char memberLevel, String staffId) {
        this.memberId = memberId;
        this.memberLevel = memberLevel;
        this.staffId = staffId;

        // generate id.
        return id;
    }
    
    // getter.
    
    public String getId() {
        return id;
    }
    
    // setter.
    
    public void setRoomSize(char roomSize) {
        this.roomSize = roomSize;
    }

    public void setHeadCount(int headCount) {
        this.headCount = headCount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    // calcuate final price of the transaction.

    public void calcFinalPrice() {
        
    }
}
