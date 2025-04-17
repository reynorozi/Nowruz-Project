package org.example;

import java.util.ArrayList;


public class SearchHandler {

    // Method to search for artists by their username or name
    public ArrayList<Artist> searchArtists(String keyword) {
        Parseinfo parsinfo = new Parseinfo();
        ArrayList<Account> accounts = parsinfo.parsinfo(); // Parse account info
        ArrayList<Artist> matchedArtists = new ArrayList<>();

        // Check if the keyword is valid
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Invalid search keyword");
            return matchedArtists; // Return empty list if the keyword is invalid
        }

        // Loop through all accounts and check if they are artists
        for (Account account : accounts) {
            if (account instanceof Artist) {
                Artist artist = (Artist) account;

                // Case-insensitive comparison of username and name
                if (artist.getUsername().toLowerCase().contains(keyword.toLowerCase()) ||
                        artist.getName().toLowerCase().contains(keyword.toLowerCase())) {
                    matchedArtists.add(artist);
                }
            }
        }
        return matchedArtists; // Return the list of matching artists
    }

    // Method to search for a song by its name
    public ArrayList<Song> searchSong(String keyword) {
        // Get all songs using the Allsongs method
        ArrayList<Song> allSongs = SaveData.Allsongs();

        ArrayList<Song> matchedSongs = new ArrayList<>();

        // Check if the keyword is valid
        if (keyword == null || keyword.trim().isEmpty()) {
            System.out.println("Invalid search keyword");
            return matchedSongs; // Return empty list if the keyword is invalid
        }

        // Loop through all songs and compare the name with the keyword
        for (Song song : allSongs) {
            // Case-insensitive comparison for song name
            if (song.getName().toLowerCase().contains(keyword.toLowerCase())) {
                matchedSongs.add(song);
            }
        }

        return matchedSongs; // Return the list of matching songs
    }
}
