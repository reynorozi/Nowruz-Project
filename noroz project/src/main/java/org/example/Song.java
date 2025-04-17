package org.example;

import java.util.ArrayList;

public class Song {
    // Fields representing the properties of a song
    private String name;
    private String artist;
    private String album;
    private String lyric;
    private String genre;
    private String release;
    private int view;

    // Constructor to initialize a song with its properties
    public Song(String name, String artist, String album, String lyric, String genre, String release, int view) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.lyric = lyric;
        this.genre = genre;
        this.release = release;
        this.view = view;
    }

    // Returns a string representation of the song, including all its properties
    @Override
    public String toString() {
        return "Song Name: " + name + "\n" +
                "Artist: " + artist + "\n" +
                "Album: " + album + "\n" +
                "Genre: " + genre + "\n" +
                "Release Date: " + release + "\n" +
                "Views: " + view + "\n" +
                "Lyrics:\n" + lyric + "\n";
    }

    // Getter for the number of views
    public int getView() {
        return view;
    }

    // Setter for the number of views
    public void setView(int view) {
        this.view = view;
    }

    // Static method to display songs sorted by views in descending order
    public static ArrayList<Song> Showchart(ArrayList<Song> songs) {
        // Sorting songs based on the number of views
        for (int i = 0; i < songs.size(); i++) {
            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(i).getView() < songs.get(j).getView()) {
                    Song temp = songs.get(i);
                    songs.set(i, songs.get(j));
                    songs.set(j, temp);
                }
            }
        }
        return songs; // Return the sorted list of songs
    }

    // Method to display detailed information about a specific song
    public static void displaySongDetails(Song song) {
        System.out.println("Song Name: " + song.name);
        System.out.println("Artist: " + song.artist);
        System.out.println("Album: " + song.album);
        System.out.println("Release Date: " + song.release);
        System.out.println("Lyrics: " + song.lyric);
        System.out.println("_____________________________________________");
    }

    // Method to display a list of song names and their artists
    public static void displaySongs(ArrayList<Song> songs) {
        int num = 1;
        // Iterate through each song and display its name and artist
        for (Song song : songs) {
            System.out.println(num + ". " + song.getName() + "\n" + song.getArtist());
            System.out.println("____________________________");
            num++;
        }
    }

    // Getter and setter methods for each field (name, artist, album, lyric, genre, release)

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
