/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Loo Zi Kang
 */
public class Gift {

    private String gift_id;
    private String gift_name;
    private int member_level_min;

    public String getGift_id() {
        return gift_id;
    }

    public void setGift_id(String gift_id) {
        this.gift_id = gift_id;
    }

    public String getGift_name() {
        return gift_name;
    }

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public int getMember_level_min() {
        return member_level_min;
    }

    public void setMember_level_min(int member_level_min) {
        this.member_level_min = member_level_min;
    }
    
}
