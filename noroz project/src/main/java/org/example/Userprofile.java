package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Userprofile implements Page {

    private User user; // The current user whose profile is being displayed
    private Page previousPage; // The previous page to return to when needed

    // Constructor accepting the user and the previous page
    public Userprofile(User user, Page previousPage) {
        this.user = user;
        this.previousPage = previousPage;
    }

    // Method to display the user profile page
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        // Print banner and divider
        printBanner();
        printDivider();

        // Display options for comments and following artists
        System.out.println("┏               ┓\n"+ "️Comments\n"+"┗               ┛");
        System.out.println("┏                 ┓\n"+ "️Following Artists\n"+"┗                 ┛");
        System.out.println("R: Return to previous page");

        // Prompt for user choice
        System.out.println("Enter your choice (C: Comments, F: Following Artists, R: Return): ");
        char choice = scanner.next().charAt(0);

        // Switch based on user input
        switch (Character.toUpperCase(choice)) {
            case 'C':
                showComments(); // Show user's comments
                break;
            case 'F':
                showFollowingArtists(); // Show the artists the user is following
                break;
            case 'R':
                previousPage.show(); // Return to the previous page
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                show(); // Re-display the profile if invalid input
                break;
        }
    }

    // Method to display the user's comments
    private void showComments() {
        // Fetch the comments by the user's username
        ArrayList<Comment> comments = Comment.getCommentsByUsername(user.getUsername());

        if (comments.isEmpty()) {
            System.out.println("No comments found.");
            return;
        }

        // Display the comments
        System.out.println("Your comments (sorted by date):\n");

        for (Comment comment : comments) {
            System.out.println("Song: " + comment.getAuthor()); // Show the song for the comment
            System.out.println("Comment: " + comment.getComment()); // Show the comment
            System.out.println("Date: " + comment.getDate()); // Show the date of the comment
            System.out.println("━━".repeat(30)); // Divider between comments
        }

        // Wait for the user to press any key to return to the profile
        System.out.println("Press any key to return to the profile.");
        new Scanner(System.in).nextLine();  // Wait for input before returning to profile
        show(); // Re-display the profile
    }

    // Method to display the artists the user is following
    private void showFollowingArtists() {
        // Fetch the list of artists the user is following
        ArrayList<Artist> followingArtists = UserServices.getFollowingArtists(user.getUsername());

        if (followingArtists.isEmpty()) {
            System.out.println("You are not following any artists.");
            return;
        }

        // Display the list of following artists
        System.out.println("Your following artists:");
        for (int i = 0; i < followingArtists.size(); i++) {
            Artist artist = followingArtists.get(i);
            System.out.println((i + 1) + ". " + artist.getName()); // Display the artist's name
        }

        // Ask the user to either select an artist or return
        System.out.println("Enter the number of the artist to view their public profile, or press R to return.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("R")) {
            show(); // Return to the profile page
            return;
        }

        // Try to parse the user input and handle artist selection
        try {
            int artistChoice = Integer.parseInt(input) - 1;
            if (artistChoice >= 0 && artistChoice < followingArtists.size()) {
                Artist selectedArtist = followingArtists.get(artistChoice);
                Artistpublicprofile artistProfilePage = new Artistpublicprofile(selectedArtist, user, this);
                artistProfilePage.show(); // Show the selected artist's profile
            } else {
                System.out.println("Invalid artist selection.");
                showFollowingArtists(); // If invalid selection, re-display the list
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number or R to return.");
            showFollowingArtists(); // If invalid input, re-display the list
        }
    }

    // Method to print the banner at the top of the profile
    private void printBanner() {
        System.out.println("█▀█  █▀█  █▀█  █▀▀  █  █    █▀▀\n" +
                "█▀▀  █▀▄  █▄█  █▀   █  █▄▄  ██▄");
        printDivider(); // Call printDivider to add a separator
    }

    // Method to print a divider line
    private void printDivider() {
        System.out.println("━━".repeat(30)); // Print a repeated "━━" line to separate sections
    }
}
