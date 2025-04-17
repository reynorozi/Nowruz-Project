package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Userhomepage implements Page {

    // User instance representing the current user
    private User user;

    // Number of songs to show initially
    private int shownCount = 10;

    // Color codes for styling the terminal output
    public static final String Blue = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String lightYellow = "\u001B[38;2;255;255;153m";

    // Constructor to initialize the homepage with the current user
    public Userhomepage(User user) {
        this.user = user;
    }

    // Method to display the homepage and handle user interactions
    public void show() {
        while (true) {
            // Clear the screen and print the page layout
            System.out.println("\n\n\n\n\n");
            System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET);

            // Display menu options and interface styling
            System.out.println("┏               ┓" + "\t".repeat(18) + lightYellow + "█▀▀█ █▀▀ █▀▀▄  ▀  █  █ █▀▀" + RESET + "\t".repeat(16) + "┏               ┓\n"
                    + " 🔍search...    " + "\t".repeat(18) + lightYellow + "█ ▄▄ █▀▀ █  █  █▀ █  █ ▀▀▄" + RESET + "\t".repeat(16) + "  Profile\n" +
                    "┗               ┛" + "\t".repeat(18) + lightYellow + "█▄▄▀ ▀▀▀ ▀  ▀ ▀▀▀  ▀▀▀ ▀▀▀" + RESET + "\t".repeat(16) + "┗               ┛");

            // Display footer
            System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET + "\n");

            // Display ASCII art or logo
            System.out.println("▄▀▀ █▄█ ▄▀▄ █▀▄ ▀█▀\n" +
                    "▀▄▄ █ █ █▀█ █▀▄  █");

            // Fetch and sort the list of songs
            ArrayList<Song> songs = Song.Showchart(SaveData.Allsongs());

            // Handle case when no songs are found
            if (songs == null || songs.isEmpty()) {
                System.out.println("No songs found");
                return;
            }

            // Limit the number of songs displayed
            shownCount = Math.min(shownCount, songs.size());

            // Display the list of songs
            for (int i = 0; i < shownCount; i++) {
                System.out.println((i + 1) + ". '" + songs.get(i).getName() + "'\t " + songs.get(i).getArtist() + " \tview:" + songs.get(i).getView());
                printDivider();  // Call helper method to print separator
            }

            // Display navigation options
            if (shownCount < songs.size()) {
                System.out.println("\nType a number to select a song \n'Show more' to load more\n 'search' to search \n 'profile' to view your profile\n'exit' to get back to sign up page");
            } else {
                System.out.println("\nType a number to select a song\n 'search' to search\n'profile' to view your profile.");
            }

            // Read user input for navigation
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().trim();

            // Handle different commands based on user input
            if (input.equalsIgnoreCase("search")) {
                // Navigate to the search page
                PageNavigator.showPage(new Search(this, user));
                return;
            } else if (input.equalsIgnoreCase("profile")) {
                // Navigate to the user's profile page
                PageNavigator.showPage(new Userprofile(user, this));
                return;
            } else if (input.equalsIgnoreCase("Show more")) {
                // Show more songs if there are more available
                if (shownCount < songs.size()) {
                    shownCount = Math.min(shownCount + 10, songs.size());
                } else {
                    System.out.println("No more songs to show.");
                }
            } else if(input.equalsIgnoreCase("Exit")) {
                // Navigate back to the main menu
                Handlemenu f = new Handlemenu();
                f.show();
            } else {
                // Handle case when the input is a song number
                try {
                    int choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= songs.size()) {
                        // Navigate to the lyrics page for the selected song
                        Song selectedSong = songs.get(choice - 1);
                        PageNavigator.showPage(new UserLyrics(selectedSong, user));
                        return;
                    } else {
                        System.out.println("Invalid song number.");
                    }
                } catch (NumberFormatException e) {
                    // Handle invalid input (not a number)
                    System.out.println("Invalid input. Please enter a number or type 'search', 'Show more', or 'profile'.");
                }
            }
        }
    }

    // Helper method to print a divider line
    private void printDivider() {
        System.out.println("━━".repeat(30));
    }
}
