package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtistHomepage implements Page {
    private Artist artist;

    // Constructor to initialize the artist object
    public ArtistHomepage(Artist artist) {
        this.artist = artist;
    }

    // Constants for color codes used in the terminal output
    public static final String Blue = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String lightYellow = "\u001B[38;2;255;255;153m";

    // Main method to display the artist homepage
    @Override
    public void show() {
        displayArtistHomepage();
    }

    // Method to display the artist's homepage
    public void displayArtistHomepage() {
        // Fetch all songs and check if the list is empty
        ArrayList<Song> songs = Song.Showchart(SaveData.Allsongs());
        if (songs == null || songs.isEmpty()) {
            System.out.println("No songs found.");
            return;
        }

        // Initialize scanner and artist services
        Scanner scan = new Scanner(System.in);
        ArtistServices artistServices = new ArtistServices();
        int shownCount = 0;

        // Infinite loop to handle the display and user input
        while (true) {
            System.out.println("\n\n\n\n\n");
            // Displaying decorated header
            System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET);

            // Displaying menu with options
            System.out.println("┏               ┓" + " ┏               ┓" + "\t".repeat(14) + lightYellow + "█▀▀█ █▀▀ █▀▀▄  ▀  █  █ █▀▀" + RESET + "\t".repeat(10) + "┏               ┓"+"┏               ┓\n"
                    + "  🎵Add Song   " + "     🎼Add Album  " + "\t".repeat(14) + lightYellow + "█ ▄▄ █▀▀ █  █  █▀ █  █ ▀▀▄" + RESET + "\t".repeat(10) + "    Profile" +"         Requests\n"+
                    "┗               ┛" + " ┗               ┛" + "\t".repeat(14) + lightYellow + "█▄▄▀ ▀▀▀ ▀  ▀ ▀▀▀  ▀▀▀ ▀▀▀" + RESET + "\t".repeat(10) + "┗               ┛"+" ┗               ┛\n");

            System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET + "\n");

            // Update the number of songs to display
            shownCount = Math.min(shownCount + 10, songs.size());

            // Display the songs in the list with a simple enumeration
            int numsongs = 1;
            for (int i = 0; i < shownCount; i++) {
                System.out.println(numsongs + ". '" + songs.get(i).getName() + "'\t " + songs.get(i).getArtist() + " \tview: " + songs.get(i).getView());
                numsongs++;
                System.out.println("━━".repeat(30));
            }

            // Check if all songs have been displayed
            if (shownCount >= songs.size()) {
                System.out.println("🎵 All songs displayed 🎵");
            } else {
                System.out.println("┏               ┓\n️Show more\n┗               ┛");
            }

            // Ask for user input to proceed with options
            System.out.println("\nType your choice (Add Song / Add Album / Profile / Show more/return):");
            String input = scan.nextLine().trim();

            try {
                // Handle user input
                if (input.equalsIgnoreCase("Add Song")) {
                    artistServices.AddSong(artist); // Handle adding a new song
                    PageNavigator.push(this); // Navigate to the current page
                    this.show(); // Refresh the page
                    return;

                } else if (input.equalsIgnoreCase("Add Album")) {
                    artistServices.AddAlbum(artist); // Handle adding a new album
                    PageNavigator.push(this); // Navigate to the current page
                    this.show(); // Refresh the page
                    return;

                } else if (input.equalsIgnoreCase("Profile")) {
                    Artistprofile ar = new Artistprofile(artist, this);
                    PageNavigator.push(this); // Navigate to the profile page
                    ar.displayArtistProfile();
                    return;

                } else if (input.equalsIgnoreCase("Show more")) {
                    // Check if there are more songs to show
                    if (shownCount >= songs.size()) {
                        System.out.println("No more songs to show.");
                    }
                } else if (input.equalsIgnoreCase("Requests")) {
                    // Handle requests from the artist
                    artistServices.handleLyricsByArtist(artist, this);
                } else if (input.equalsIgnoreCase("Return")) {
                    // Navigate back to the main menu
                    Handlemenu m = new Handlemenu();
                    m.show();
                } else {
                    // Handle invalid input
                    System.out.println("Invalid input. Please try again.");
                }
            } catch (Exception e) {
                // Handle any exceptions that occur during the process
                System.out.println("An error occurred. Please try again.");
            }
        }
    }
}
