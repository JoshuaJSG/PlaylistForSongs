package com.company;

import java.util.*;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    // create constructor to access name and artist and also to inilialize our
    // songs


    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList();
    }


    public boolean addSong(String title, double duration){
        if (findSong(title) == null){
            songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (Song checkedSong : songs) {
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }


    public boolean addSongToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if (checkedSong !=null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean goingForward = true;
        ListIterator<Song> iterateSongs = playlist.listIterator();
        if (playlist.isEmpty()){
            System.out.println("Playlist is empty");
            return;
        }
        else {
            System.out.println("Now playing " + iterateSongs.next().toString());
        }
        getMenu();
        while (!exit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Leaving album, music has been stopped.");
                    exit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if (iterateSongs.hasNext()){
                            iterateSongs.next();
                        }
                        goingForward = true;
                    }
                    if (iterateSongs.hasNext()){
                        System.out.println("Song Playing is: " +iterateSongs.next().toString());
                    } else {
                        System.out.println("At the end of playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (iterateSongs.hasPrevious()) {
                            iterateSongs.previous();
                            goingForward = false;
                        }
                    }
                    if (iterateSongs.hasPrevious()){
                        System.out.println("Song Playing is: "+iterateSongs.previous().toString());
                    }
                    else {
                        System.out.println("At the beginning of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward){
                        if (iterateSongs.hasPrevious()){
                            System.out.println("Replaying " + iterateSongs.previous().toString());
                            goingForward = true;
                        } else {
                            System.out.println("At start of list");
                        }
                    } else {
                        if (iterateSongs.hasNext()){
                            System.out.println("Now Replaying "+ iterateSongs.next().toString());
                            goingForward = true;
                        } else {
                            System.out.println("You are at the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    getMenu();
                    break;
                case 6:
                    if (playlist.size() > 0 ){
                        iterateSongs.remove();
                        if (iterateSongs.hasNext()){
                            System.out.println("Now Playing "+ iterateSongs.next());
                        }else {
                            if (iterateSongs.hasPrevious()){
                                System.out.println("Now Playing "+ iterateSongs.previous());
                            }
                        }
                    }
                    break;
            }
        }
    }



    private void getMenu(){
        System.out.println("Available commands");
        System.out.println("0 - to exit \n" +
                "1 - Play next Song\n" +
                "2 - Play previous Song\n" +
                "3 - Replay Song\n" +
                "4 - List Songs in the playlist\n" +
                "5 - Print available commands\n" +
                "6 - to remove current song from playlist");
    }


    private void printPlaylist(LinkedList<Song> playlist){
        Iterator<Song> listIterator = playlist.iterator();
        System.out.println("=========================");
        while (listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
        System.out.println("=========================");
    }
}
