package org.example;

import java.util.ArrayList;

public class Album {

    // Instance variables to store album details
    public String nameAlbum;  // Name of the album
    public ArrayList<Song> tracklist;  // List of songs (tracks) in the album
    public String releaseDate;  // Release date of the album

    // Constructor to initialize the album with a name and tracklist
    public Album(String nameAlbum, ArrayList<Song> tracklist) {
        this.nameAlbum = nameAlbum;
        this.tracklist = tracklist;
    }

    // Override the toString method to return a formatted string representation of the album details
    @Override
    public String toString() {
        StringBuilder albumDetails = new StringBuilder();

        // Appending album name, release date, and tracklist
        albumDetails.append("Album Name: ").append(nameAlbum).append("\n")
                .append("Release Date: ").append(releaseDate != null ? releaseDate : "N/A").append("\n")
                .append("Tracklist:\n");

        // Looping through the tracklist and appending each song's name
        for (int i = 0; i < tracklist.size(); i++) {
            albumDetails.append(i + 1).append(". ").append(tracklist.get(i).getName()).append("\n");
        }
        return albumDetails.toString();  // Return formatted album details
    }

    // Getter and setter methods for the album's release date, tracklist, and album name
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Song> getTracklist() {
        return tracklist;
    }

    public void setTracklist(ArrayList<Song> tracklist) {
        this.tracklist = tracklist;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    // Method to display the album's name, release date (if available), and tracklist
    public void displayAlbum() {
        System.out.println("NAME: " + this.nameAlbum);  // Print album name
        if (!tracklist.isEmpty()) {
            System.out.println("RELEASE: " + tracklist.get(0).getRelease());  // Print release date from the first song (if available)
        }

        int num = 1;
        // Loop through the tracklist and display each song's name with its index
        for (Song song : tracklist) {
            System.out.println(num + ". " + song.getName());
            System.out.println("____________________________");
            num++;
        }
        System.out.println("━━".repeat(30));  // Print a divider at the end of the album display
    }

    // Static method to display the list of albums of an artist
    public static void displayAlbumsOfArtist(ArrayList<Album> albums) {
        int num = 1;
        // Loop through the albums and display each album's name with its index
        for (Album album : albums) {
            System.out.println(num + ". " + album.getNameAlbum());
            System.out.println("____________________________");
            num++;
        }
    }
}
