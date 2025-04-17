package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Artistprofile implements Page {
    private Artist artist;
    private Page previousPage;

    // Constructor to initialize artist and previous page for navigation
    public Artistprofile(Artist artist, Page previousPage) {
        this.artist = artist;
        this.previousPage = previousPage;
    }

    // Main method to display the artist's profile
    public void displayArtistProfile() {
        // Print banner and sections for songs and albums
        printBanner();
        printSongs();
        printAlbums();

        // Scanner for taking user input
        Scanner scan = new Scanner(System.in);
        System.out.println("\nType 'R' to return to the previous page.");
        System.out.println("Type 'S' followed by the song number to view lyrics.");
        System.out.println("Type 'A' followed by the album number to view its details.");
        System.out.println("For example: S1 for song 1, A2 for album 2.");

        String input = scan.nextLine().trim();

        try {
            // Handle user input for navigation and viewing details
            if (input.equalsIgnoreCase("R")) {
                previousPage.show(); // Return to the previous page
            } else if (input.length() > 1) {
                // Get the choice (S for song or A for album) and index
                char choice = input.charAt(0);
                int selectedIndex = Integer.parseInt(input.substring(1)) - 1;

                switch (Character.toUpperCase(choice)) {
                    case 'S':
                        showLyrics(artist.getSongs().get(selectedIndex)); // Show lyrics for the selected song
                        break;
                    case 'A':
                        // Display details of the selected album
                        Album selectedAlbum = artist.getAlbums().get(selectedIndex);
                        selectedAlbum.displayAlbum();
                        handleAlbumSongChoice(selectedAlbum); // Handle song choice from album
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
            System.out.println("Invalid number format. Please enter a valid number.");
        } catch (IndexOutOfBoundsException e) {
            // Handle out-of-bounds index error
            System.out.println("The selected song or album number is out of range. Please try again.");
        } catch (Exception e) {
            // Catch any other general exceptions
            System.out.println("An error occurred. Please try again.");
        }
    }

    // Method to print the profile banner
    private void printBanner() {
        System.out.println("█▀█  █▀█  █▀█  █▀▀  █  █    █▀▀\n" +
                "█▀▀  █▀▄  █▄█  █▀   █  █▄▄  ██▄");
        printDivider();

        System.out.println("█▄█  █▀█  █ █  █▀█   █▀  █▀█  █▄ █  █▀▀  █▀\n" +
                " █   █▄█  █▄█  █▀▄   ▄█  █▄█  █ ▀█  █▄█  ▄█");
        printDivider();
    }

    // Method to print the list of songs by the artist
    private void printSongs() {
        ArrayList<Song> songs = artist.getSongs();
        Song.displaySongs(songs); // Display the songs
        printDivider();
    }

    // Method to print the list of albums by the artist
    private void printAlbums() {
        ArrayList<Album> albums = artist.getAlbums();
        Album.displayAlbumsOfArtist(albums); // Display the albums
        printDivider();
    }

    // Method to handle the song choice within an album
    private void handleAlbumSongChoice(Album album) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter song number to view lyrics:");
        int songChoice = scan.nextInt();
        // Check if the song choice is within the album's tracklist size
        if (songChoice > 0 && songChoice <= album.getTracklist().size()) {
            showLyrics(album.getTracklist().get(songChoice - 1)); // Show lyrics for the selected song
        } else {
            System.out.println("Invalid song choice.");
        }
    }

    // Method to print a visual divider
    private void printDivider() {
        System.out.println("━━".repeat(30));
    }

    // Method to show the lyrics of a selected song
    private void showLyrics(Song song) {
        HandleLyrics(song, artist); // Call the method to handle lyrics display/editing
    }

    // Method to handle lyrics editing
    public void HandleLyrics(Song song, Account account) {
        System.out.println(song); // Display the song

        // Prompt user to edit lyrics
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 'e' to edit lyrics, or any other key to exit.");
        char input = scan.next().charAt(0);
        if (Character.toLowerCase(input) == 'e') {
            ArtistServices artistServices = new ArtistServices();
            artistServices.EditLyric(song); // Allow the artist to edit the lyrics
        }
    }

    @Override
    public void show() {
        displayArtistProfile(); // Show the artist profile when this page is navigated to
    }
}
