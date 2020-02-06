package com.company;

public class Song {

    public String title;
    public Double duration;

    public Song(String title, Double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return this.title + ":   " + this.duration;
    }
}
