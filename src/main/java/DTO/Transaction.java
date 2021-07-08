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
    private char room_size;
    private int head_count;
    private double discount;
    private double final_price;
    private User member;
    private User staff;
    private int date_created;
    private List<Gift> gifts;

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public char getRoom_size() {
        return room_size;
    }

    public void setRoom_size(char room_size) {
        this.room_size = room_size;
    }

    public int getHead_count() {
        return head_count;
    }

    public void setHead_count(int head_count) {
        this.head_count = head_count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinal_price() {
        return final_price;
    }

    public void setFinal_price(double final_price) {
        this.final_price = final_price;
    }

    public User getMember() {
        return member;
    }

    public void setMember(User member) {
        this.member = member;
    }

    public User getStaff() {
        return staff;
    }

    public void setStaff(User staff) {
        this.staff = staff;
    }

    public int getDate_created() {
        return date_created;
    }

    public void setDate_created(int date_created) {
        this.date_created = date_created;
    }
}
