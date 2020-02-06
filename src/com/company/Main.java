package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {


        Album album = new Album("Music x Road", "Headie One");
        album.addSong("Both", 3.34);
        album.addSong("Ball in Peace", 2.24);
        album.addSong("Rubbery Bandz", 3.07);
        album.addSong("18Hunna", 3.09);
        album.addSong("Back to Basics", 3.14);
        albums.add(album);

        album = new Album("Kirk", "DaBaby");
        album.addSong("BOP", 2.40);
        album.addSong("VIBEZ", 2.25);
        album.addSong("POP STAR", 3.03);
        album.addSong("GOSPEL", 3.34);
        album.addSong("TOES", 2.16);
        album.addSong("REALLY", 2.21);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addSongToPlaylist("Both", playlist);
        albums.get(0).addSongToPlaylist("Ball in Peace", playlist);
        albums.get(0).addSongToPlaylist("Rubbery Bandz", playlist);

        albums.get(0).addSongToPlaylist("Rubbery Bands", playlist); // shouldn't add as its incorrect spelling.

        albums.get(1).addSongToPlaylist("VIBEZ", playlist); //
        albums.get(1).addSongToPlaylist("TOES", playlist);
        albums.get(1).addSongToPlaylist("REALLY", playlist);

        albums.get(0).addSongToPlaylist("REALLY", playlist); // shouldn't add as its accessing the wrong album at index 0.
        albums.get(1).addSongToPlaylist("Short Sticks", playlist); // shouldn't add as it is not in album.


        album.play(playlist);


    }


}
