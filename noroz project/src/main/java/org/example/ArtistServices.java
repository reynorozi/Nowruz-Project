package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ArtistServices implements Edit {

    ArrayList<Song> songlist = new ArrayList<>();  // List of songs
    ArrayList<User> Followers = new ArrayList<>(); // List of followers

    // Method for adding a new song
    public void AddSong(Artist artist) {

        Scanner scaninfo = new Scanner(System.in);
        System.out.println("Enter the name of the song:");  // Ask for the song name

        String namesong = scaninfo.nextLine();  // Read the song name
        System.out.println("Enter the lyrics of the song:");  // Ask for the song lyrics

        String lyricssong = scaninfo.nextLine();  // Read the lyrics
        while (true) {
            String line = scaninfo.nextLine();
            if (line.isEmpty()) {  // If no more lines are entered, stop reading
                break;
            }
            lyricssong += line + "\n";  // Append the line to the lyrics
        }

        System.out.println("Enter the genre of the song:");  // Ask for the genre
        String genressong = scaninfo.nextLine();  // Read the genre

        String release = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));  // Get the current date as release date

        // Create a new song object with the provided details
        Song song = new Song(namesong, artist.getName(), "Single", lyricssong, genressong, release, 0);
        songlist.add(song);  // Add the song to the song list
        SaveData.Savesongs(songlist);  // Save the updated song list
        System.out.println("Song added to the list");
    }

    // Method for adding a new album
    public void AddAlbum(Artist artist) {

        int choice = 1;
        System.out.println("Enter the name of the album:");  // Ask for the album name
        Scanner scan = new Scanner(System.in);
        String AlbumName = scan.nextLine();  // Read the album name

        System.out.println("Enter the genre of the album:");  // Ask for the album genre
        String genreAlbum = scan.nextLine();  // Read the album genre

        // Loop to add songs to the album
        while (choice == 1) {

            System.out.println("Enter the name of the song:");  // Ask for the song name
            String namesong = scan.nextLine();  // Read the song name

            System.out.println("Enter the lyrics of the song:");  // Ask for the song lyrics
            String lyricssong = scan.nextLine();  // Read the lyrics
            while (true) {
                String line = scan.nextLine();
                if (line.isEmpty()) {  // If no more lines are entered, stop reading
                    break;
                }
                lyricssong += line + "\n";  // Append the line to the lyrics
            }

            String release = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));  // Get the current date as release date

            // Create a new song object and add it to the song list
            Song addsong = new Song(namesong, artist.getName(), AlbumName, lyricssong, genreAlbum, release, 0);
            songlist.add(addsong);

            System.out.println("1.Add another Song  2.Finish\n");  // Ask if the user wants to add another song
            choice = scan.nextInt();
            if (choice == 2) {  // If the user chooses to finish
                if (songlist.size() > 2) {  // If the album has more than 2 songs, show an error
                    System.out.println("The Album should have at most 2 songs\n");
                    choice = 1;
                    continue;
                }
                break;
            }
        }

        SaveData.Savesongs(songlist);  // Save the album with the songs added
    }

    // Method to edit the lyrics of a song
    @Override
    public void EditLyric(Song song) {
        System.out.println("_________Editlyrics____________\n");

        Scanner scan = new Scanner(System.in);
        String lyricssong = scan.nextLine();  // Read the new lyrics
        while (true) {
            String line = scan.nextLine();
            if (line.isEmpty()) {  // If no more lines are entered, stop reading
                break;
            }
            lyricssong += line + "\n";  // Append the line to the new lyrics
        }

        SaveData.saveeditlyric(song, lyricssong);  // Save the edited lyrics
    }

    // Method to set a user as a follower of the artist
    public void SetFollowers(User user) {
        if (!Followers.contains(user)) {  // If the user is not already a follower
            Followers.add(user);  // Add the user to the followers list
        }
    }

    // Method for handling lyrics requests by the artist
    public void handleLyricsByArtist(Artist artist, Page page) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("===== Artist Panel =====");

            EditRequestManager.displayRequestsForArtist(artist);  // Display the edit requests for the artist

            System.out.println("Options:");
            System.out.println("A: Approve a request");
            System.out.println("R: Reject a request");
            System.out.println("B: Back");

            char choice = scanner.next().toUpperCase().charAt(0);  // Get the user's choice

            switch (choice) {
                case 'A' -> {  // If the user wants to approve a request
                    System.out.print("Enter request number to approve: ");
                    int index = scanner.nextInt() - 1;  // Get the request number to approve
                    EditRequestManager.approveRequest(index); // Approve the request
                }
                case 'R' -> {  // If the user wants to reject a request
                    System.out.print("Enter request number to reject: ");
                    int index = scanner.nextInt() - 1;  // Get the request number to reject
                    EditRequestManager.rejectRequest(index); // Reject the request
                }
                case 'B' ->{  // If the user wants to go back
                    running = false;  // Exit the loop
                    Handlemenu m = new Handlemenu();  // Create a new menu object
                    m.show();  // Show the menu
                }
                default -> System.out.println("Invalid option.");  // If the user enters an invalid option
            }
        }
    }
}
