/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author cafer
 */
public class TransactionDTO {

    private String transaction_id;
    private String member_level_atm;
    private RegisteredSessionDTO session;
    private double discount;
    private double final_price;
    private UserDTO member;
    private UserDTO staff;
    private int date_created;
    private int date_modified;
    private int status;

    public TransactionDTO() {

    }

    public TransactionDTO(String transaction_id, RegisteredSessionDTO session, double discount, double final_price, UserDTO member, String member_level_atm, UserDTO staff, int status, int date_created, int date_modified) {
        this.transaction_id = transaction_id;
        this.session = session;
        this.discount = discount;
        this.final_price = final_price;
        this.member = member;
        this.member_level_atm = member_level_atm;
        this.staff = staff;
        this.status = status;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public String getMemberLevelAtm() {
        return member_level_atm;
    }

    public void setMemberLevelAtm(String member_level_atm) {
        this.member_level_atm = member_level_atm;
    }

    public String getTransactionId() {
        return transaction_id;
    }

    public void setTransactionId(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getSessionId() {
        return session.getSessionId();
    }

    public RegisteredSessionDTO getSession() {
        return session;
    }

    public void setSessionId(RegisteredSessionDTO session) {
        this.session = session;
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

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        switch (status) {
            case 0 -> {
                return "Unknown";
            }
            case 1 -> {
                return "Active";
            }
            case 2 -> {
                return "Refunded";
            }
        }
        return "Error";
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
