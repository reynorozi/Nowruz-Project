package org.example;


import java.util.ArrayList;

public class Artist extends Account {

    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<Account> followers;

    public Artist(String username,int age, String password, String name) {
        super(username,age, password, name);

    }

    /*In these methods, by sending the artist's name from the songs&albums JSON file,
     we retrieve the number of songs by the artist and return it as an array of Song objects and Album objects .*/

    public ArrayList<Song> getSongs() {

        songs = SaveData.getSongs(this.getName());
        return songs;
    }

    public ArrayList<Album> getAlbums() {

        albums = SaveData.getAlbum(this.getName());
        return albums;
    }

    public ArrayList<Account> getFollowers() {

        return followers;
    }

    public void setFollowers(ArrayList<Account> followers) {
        this.followers = followers;
    }

}
