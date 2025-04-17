package org.example;

import java.util.Scanner;

public class UserLyrics implements Page {
    private Song song; // The song object that contains the details of the selected song
    private User user; // The current user viewing the song

    // Constructor that accepts a song and a user
    public UserLyrics(Song song, User user) {
        this.song = song;
        this.user = user;
    }

    // Method to display the song details
    @Override
    public void show() {
        // Increase the view count for the song
        SaveData.increaseView(song);

        // Display the song details
        Song.displaySongDetails(song);

        // Display options: comment, follow, and edit lyrics
        System.out.println("┏               ┓" + " ┏               ┓" + "  ┏               ┓");
        System.out.println("  💬Comment" + "  " + "      🫧Follow" + "  " + "         ✍️Edit lyric");
        System.out.println("┗               ┛" + " ┗               ┛" + "  ┗               ┛");

        // Instructions to go to the artist's profile or return to the previous page
        System.out.println("A: Artist Profile");
        System.out.println("R: Return");

        // Take input from the user
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);

        // Create a UserServices object to perform various actions
        UserServices us = new UserServices(user);

        // Get the artist associated with the song
        Artist artist = ArtistData.getArtistByName(song.getArtist());

        // Switch based on the user's input to handle different options
        switch (Character.toUpperCase(ch)) {
            case 'C' -> us.AddComment(song.getName(), user); // Add a comment to the song
            case 'F' -> us.followsong(song, user); // Follow the song
            case 'E' -> us.EditLyric(song); // Edit the lyrics of the song
            case 'A' -> PageNavigator.showPage(new Artistpublicprofile(artist, user, this)); // Go to the artist's profile
            case 'R' -> PageNavigator.goBack(); // Return to the previous page
            default -> System.out.println("Invalid option!"); // If the input is invalid
        }

        // Call the show method recursively to keep the page open
        show();
    }
}
