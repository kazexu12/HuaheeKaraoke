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
public class Song {

    private String song_id;
    private String name;
    private String artist;
    private String album;
    private String genre;
    private int duration;
    private int date_created;
    private int date_modified;

    public Song() {

    }

    public Song(String song_id, String name, String artist, String album, String genre, int duration, int date_created, int date_modified) {
        this.song_id = song_id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.date_created = date_created;
        this.date_modified = date_modified;
    }

    public String getSongId() {
        return song_id;
    }

    public void setSongId(String song_id) {
        this.song_id = song_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getDurationString() {
        return String.format("%02d:%02d", new Object[]{(int) (duration / 60), duration % 60});
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
