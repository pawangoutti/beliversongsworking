package com.pawan.beliverssongs;

public class Model {
    String title, song;

    public Model() {
    }

    public Model(String title, String song) {
        this.title = title;
        this.song = song;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
