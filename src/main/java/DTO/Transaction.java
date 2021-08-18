/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author cafer
 */
public class Transaction {

    private String transaction_id;
    private String member_level_atm;
    private RegisteredSession session_id;
    private double discount;
    private double final_price;
    private User member;
    private User staff;
    private int date_created;
    private int date_modified;
    private List<Gift> gifts;
    
    public Transaction(String transaction_id, RegisteredSession session_id, double discount, double final_price, User member, String member_level_atm, User staff, int date_created, int date_modified) {
        this.transaction_id = transaction_id;
        this.session_id = session_id;
        this.discount = discount;
        this.final_price = final_price;
        this.member = member;
        this.member_level_atm = member_level_atm;
        this.staff = staff;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public String getMemberLevelAtm() {
        return member_level_atm;
    }

    public void setMemberLevelAtm(String member_level_atm) {
        this.member_level_atm = member_level_atm;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public String getTransactionId() {
        return transaction_id;
    }

    public void setTransactionId(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public RegisteredSession getSessionId() {
        return session_id;
    }

    public void setSessionId(RegisteredSession session_id) {
        this.session_id = session_id;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return final_price;
    }

    public void setFinalPrice(double final_price) {
        this.final_price = final_price;
    }

    public String getMemberId() {
        return member.getUser_id();
    }

    public String getStaffId() {
        return staff.getUser_id();
    }

    public int getDateCreated() {
        return date_created;
    }

    public void setDateCreated(int date_created) {
        this.date_created = date_created;
    }

    public int getDateModified() {
        return date_modified;
    }

    public void setDateModified(int date_modified) {
        this.date_modified = date_modified;
    }
}
