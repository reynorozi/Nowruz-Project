package org.example;

import java.util.ArrayList;

public class ArtistData {

    // Method to get the artist by name
    public static Artist getArtistByName(String name) {
        Parseinfo parser = new Parseinfo();
        ArrayList<Account> accounts = parser.parsinfo();

        // Iterate over the list of accounts to find the artist by name
        for (Account account : accounts) {
            if (account instanceof Artist) {  // Check if the account is of type Artist
                Artist artist = (Artist) account;
                if (artist.getName().equals(name)) {  // Compare artist names
                    return artist;  // Return the artist if found
                }
            }
        }

        return null;  // Return null if no artist found
    }
}
