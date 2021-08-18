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
public class User {

    private String user_id;
    private int privillage;
    private String name;
    private String pw_hash;
    private String first_name;
    private String last_name;
    private int member_point;
    private char member_level;
    private int date_created;
    private int date_modified;

    public User() {

    }

    public User(String user_id,
            int privillage,
            String name,
            String pw_hash,
            String first_name,
            String last_name,
            int member_point,
            char member_level,
            int date_created,
            int date_modified) {
        this.user_id = user_id;
        this.privillage = privillage;
        this.name = name;
        this.pw_hash = pw_hash;
        this.first_name = first_name;
        this.last_name = last_name;
        this.member_point = member_point;
        this.member_level = member_level;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getPrivillage() {
        return privillage;
    }

    public void setPrivillage(int privillage) {
        this.privillage = privillage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw_hash() {
        return pw_hash;
    }

    public void setPw_hash(String pw_hash) {
        this.pw_hash = pw_hash;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getMember_point() {
        return member_point;
    }

    public void setMember_point(int member_point) {
        this.member_point = member_point;
    }

    public char getMember_level() {
        return member_level;
    }

    public void setMember_level(char member_level) {
        this.member_level = member_level;
    }

    public int getDate_created() {
        return date_created;
    }

    public void setDate_created(int date_created) {
        this.date_created = date_created;
    }

    public int getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(int date_modified) {
        this.date_modified = date_modified;
    }

}
