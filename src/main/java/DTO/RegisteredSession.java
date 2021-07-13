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
public class RegisteredSession {

    private String session_id;
    private String session_key;
    private char room_size;
    private int head_count;
    private String session_date;
    private String session_start_time;
    private String session_end_time;
    private int date_created;
    private int date_modified;

    public RegisteredSession() {

    }

    public RegisteredSession(String session_id, String session_key, char room_size, int head_count, String session_date, String session_start_time, String session_end_time, int date_created, int date_modified) {
        this.session_id = session_id;
        this.session_key = session_key;
        this.room_size = room_size;
        this.head_count = head_count;
        this.session_date = session_date;
        this.session_start_time = session_start_time;
        this.session_end_time = session_end_time;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
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

    public String getSession_date() {
        return session_date;
    }

    public void setSession_date(String session_date) {
        this.session_date = session_date;
    }

    public String getSession_start_time() {
        return session_start_time;
    }

    public void setSession_start_time(String session_start_time) {
        this.session_start_time = session_start_time;
    }

    public String getSession_end_time() {
        return session_end_time;
    }

    public void setSession_end_time(String session_end_time) {
        this.session_end_time = session_end_time;
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
