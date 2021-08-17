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

    public String getSessionId() {
        return session_id;
    }

    public void setSessionId(String session_id) {
        this.session_id = session_id;
    }

    public String getSessionKey() {
        return session_key;
    }

    public void setSessionKey(String session_key) {
        this.session_key = session_key;
    }

    public char getRoomSize() {
        return room_size;
    }

    public void setRoomSize(char room_size) {
        this.room_size = room_size;
    }

    public int getHeadCount() {
        return head_count;
    }

    public void setHeadCount(int head_count) {
        this.head_count = head_count;
    }

    public String getSessionDate() {
        return session_date;
    }

    public void setSessionDate(String session_date) {
        this.session_date = session_date;
    }

    public String getSessionStartTime() {
        return session_start_time;
    }

    public void setSessionStartTime(String session_start_time) {
        this.session_start_time = session_start_time;
    }

    public String getSessionEndTime() {
        return session_end_time;
    }

    public void setSessionEndTime(String session_end_time) {
        this.session_end_time = session_end_time;
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
