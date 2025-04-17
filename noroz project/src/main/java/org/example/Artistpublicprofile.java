package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Artistpublicprofile implements Page {

    private Artist artist;
    private User user;
    private Page previousPage;  // Store the previous page for navigation

    // Constructor to initialize the artist, user, and previous page for navigation
    public Artistpublicprofile(Artist artist, User user, Page previousPage) {
        this.artist = artist;
        this.user = user;
        this.previousPage = previousPage;  // Initialize the previous page
    }

    @Override
    public void show() {
        // Get all songs from the artist and their albums
        ArrayList<Song> songs = getAllSongs();

        // Display artist details and their followers
        System.out.println("Name: " + artist.getName());
        System.out.println("Artist username for fetching followers: " + artist.getUsername());
        System.out.println("Followers: " + SaveData.getArtistFollowersCount(artist.getUsername()));
        System.out.println("_____________________________________________");
        System.out.println("┏               ┓\n" + "️Follow\n" + "┗               ┛");

        // Display the artist's banner
        System.out.println(
                "█▀█ █▀█ █▀█ █ █ █   ▄▀█ █▀█   █▀ █▀█ █▄ █ █▀▀\n" +
                        "█▀▀ █▄█ █▀▀ █▄█ █▄▄ █▀█ █▀▄   ▄█ █▄█ █ ▀█ █▄█");

        // Display songs list
        Song.displaySongs(songs);

        // Display album list
        System.out.println("▄▀█ █   █▄▄ █ █ █▀▄▀█ █▀\n" +
                "█▀█ █▄▄ █▄█ █▄█ █ ▀ █ ▄█\n");
        System.out.println("______________________________________________");

        ArrayList<Album> albums = artist.getAlbums();
        Album.displayAlbumsOfArtist(albums);
        System.out.println("______________________________________________");

        // Initialize the services for user and artist
        UserServices service = new UserServices(user);
        ArtistServices artistService = new ArtistServices();

        // User input to choose actions
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("F: Follow Artist");
        System.out.println("S: Show Song Lyrics");
        System.out.println("A: Show Album and Song Lyrics");
        System.out.println("R: Return to previous page");

        char input = scanner.next().charAt(0);

        // Switch case for different user actions
        switch (Character.toUpperCase(input)) {
            case 'F' -> {
                // Follow artist
                service.followArtist(artist);
                SaveData.saveFollow(user, artist);

                System.out.println("You followed " + artist.getName());
                System.out.println("Followers: " + service.getFollowedArtists());
            }
            case 'S' -> {
                // Show lyrics for a selected song
                System.out.println("Enter the song number to view lyrics:");
                int songChoice = scanner.nextInt();
                if (songChoice > 0 && songChoice <= songs.size()) {
                    UserLyrics UUU = new UserLyrics(songs.get(songChoice - 1), user);
                    UUU.show();
                } else {
                    System.out.println("Invalid song choice.");
                }
            }
            case 'A' -> {
                // Show lyrics for a song from the selected album
                System.out.println("Enter the album number to view songs:");
                int albumChoice = scanner.nextInt();
                if (albumChoice > 0 && albumChoice <= albums.size()) {
                    Album selectedAlbum = albums.get(albumChoice - 1);
                    selectedAlbum.displayAlbum();
                    System.out.println("Enter the song number to view lyrics from this album:");
                    int songChoiceFromAlbum = scanner.nextInt();
                    ArrayList<Song> tracklist = selectedAlbum.getTracklist();
                    if (songChoiceFromAlbum > 0 && songChoiceFromAlbum <= tracklist.size()) {
                        UserLyrics UUU = new UserLyrics(tracklist.get(songChoiceFromAlbum - 1), user);
                        UUU.show();
                    } else {
                        System.out.println("Invalid song choice from album.");
                    }
                } else {
                    System.out.println("Invalid album choice.");
                }
            }
            case 'R' -> previousPage.show();  // Return to previous page
            default -> System.out.println("Invalid option. Try F, S, or A.");
        }
    }

    // Method to retrieve all songs from the artist and their albums
    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> allSongs = new ArrayList<>();
        allSongs.addAll(artist.getSongs());
        // Add songs from each album to the list
        for (Album album : artist.getAlbums()) {
            allSongs.addAll(album.getTracklist());
        }
        return Song.Showchart(allSongs);  // Display the song chart
    }
}
