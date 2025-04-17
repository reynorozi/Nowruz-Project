package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Search implements Page {
    private Page prevPage;
    private User user;
    SearchHandler searchHandler = new SearchHandler();

    public Search(Page page, User user) {
        this.prevPage = page;
        this.user = user;
    }

    @Override
    public void show() {
        System.out.println("================ Search ==================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search keyword: ");
        String searchWord = scanner.nextLine();

        // Get matching songs and artists based on keyword
        ArrayList<Song> matchedSongs = searchHandler.searchSong(searchWord);
        ArrayList<Artist> matchedArtists = searchHandler.searchArtists(searchWord);

        // Display matching songs
        int songIndex = 1;
        System.out.println("\n--- Songs Found ---");
        for (Song song : matchedSongs) {
            System.out.println("S" + songIndex + ". " + song.getName());
            songIndex++;
        }

        // Display matching artists
        int artistIndex = 1;
        System.out.println("\n--- Artists Found ---");
        for (Artist artist : matchedArtists) {
            System.out.println("A" + artistIndex + ". " + artist.getName());
            artistIndex++;
        }

        // Ask for user selection
        System.out.print("\nEnter your choice (e.g., S1 or A2), or R to return: ");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("R")) {
            prevPage.show(); // Go back to previous page
            return;
        }

        // Parse user input
        if (input.length() >= 2) {
            char type = input.charAt(0); // 'S' or 'A'
            int index;
            try {
                index = Integer.parseInt(input.substring(1)) - 1; // Convert string to number (1-based index)
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
                return;
            }

            // Handle song selection
            if (type == 'S' || type == 's') {
                if (index >= 0 && index < matchedSongs.size()) {
                    Song selectedSong = matchedSongs.get(index);
                    System.out.println("You selected song: " + selectedSong.getName());
                    UserLyrics userLyrics = new UserLyrics(selectedSong, user);
                    userLyrics.show();
                } else {
                    System.out.println("Invalid song selection.");
                }
            }
            // Handle artist selection
            else if (type == 'A' || type == 'a') {
                if (index >= 0 && index < matchedArtists.size()) {
                    Artist selectedArtist = matchedArtists.get(index);
                    System.out.println("You selected artist: " + selectedArtist.getName());

                    Artistpublicprofile a = new Artistpublicprofile(selectedArtist,user,prevPage);
                    a.show();
                } else {
                    System.out.println("Invalid artist selection.");
                }
            } else {
                System.out.println("Invalid choice type.");
            }
        } else {
            System.out.println("Invalid input format.");
        }
    }
}
