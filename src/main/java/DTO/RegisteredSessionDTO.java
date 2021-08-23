/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author Loo Zi Kang
 */
public class RegisteredSessionDTO {

    private String session_id;
    private String session_key;
    private char room_size;
    private int head_count;
    private String session_date;
    private String session_start_time;
    private String session_end_time;
    private int date_created;
    private int date_modified;

    public RegisteredSessionDTO() {

    }

    /**
     * Constructor for new session data
     *
     * @param room_size
     * @param head_count
     * @param session_date
     */
    public RegisteredSessionDTO(char room_size, int head_count, String session_date) {
        this.room_size = room_size;
        this.head_count = head_count;
        this.session_date = session_date;
    }

    /**
     * Constructor for loading data from DB
     *
     * @param session_id
     * @param session_key
     * @param room_size
     * @param head_count
     * @param session_date
     * @param session_start_time
     * @param session_end_time
     * @param date_created
     * @param date_modified
     */
    public RegisteredSessionDTO(String session_id, String session_key, char room_size, int head_count, String session_date, String session_start_time, String session_end_time, int date_created, int date_modified) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisteredSessionDTO other = (RegisteredSessionDTO) obj;
        return Objects.equals(this.session_id, other.session_id);
    }

    @Override
    public String toString() {
        return String.format("Date Registered\t\t: %s\n"
                + "Head Count\t\t: %d\n"
                + "Room Size\t\t: %c\n"
                + "Session Date\t\t: %s\n"
                + "Session Start Time\t: %s\n"
                + "Session End Time\t: %s\n"
                + "Session ID\t\t: %s\n", new Object[]{
                    new java.util.Date((long) date_created * 1000).toString(),
                    head_count,
                    room_size,
                    session_date,
                    session_start_time,
                    session_end_time,
                    session_id
                });
    }

}
