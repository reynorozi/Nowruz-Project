package org.example;

import java.util.ArrayList;

public class EditRequestManager {

    // The requests are kept static so that they are accessible from anywhere
    public static ArrayList<EditRequest> pendingRequests = new ArrayList<>();

    // Method to add a new edit request to the pending list
    public static void addRequest(EditRequest request) {
        pendingRequests.add(request);
    }

    // Method to get all the pending requests (for display or processing in AdminPage or ArtistPage)
    public static ArrayList<EditRequest> getAllRequests() {
        return pendingRequests;
    }

    // Method to display all the requests
    public static void displayRequests() {
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            for (int i = 0; i < pendingRequests.size(); i++) {
                EditRequest req = pendingRequests.get(i);
                System.out.println((i + 1) + ". Song: " + req.getSong().getName());
                System.out.println("   Suggested Lyrics: \n" + req.getNewLyrics());
                System.out.println("   By User: " + req.getUser().getUsername());
                System.out.println("   Status: " + (req.isApproved() ? "Approved" : "Pending"));
                System.out.println("--------------------------------------------");
            }
        }
    }

    // Method to approve a request (change the lyrics in the song)
    public static void approveRequest(int index) {
        if (index >= 0 && index < pendingRequests.size()) {
            EditRequest request = pendingRequests.get(index);
            Song song = request.getSong();

            if (song != null) {
                // 🟢 Here, call your method to change the song lyrics
                SaveData.saveeditlyric(song, request.getNewLyrics());

                System.out.println("✅ Lyrics updated successfully!");

                // Remove the request after approval
                pendingRequests.remove(index);
            } else {
                System.out.println("❌ Song not found!");
            }
        } else {
            System.out.println("Invalid request index.");
        }
    }

    // Method to reject a request (simply removes it from the list)
    public static void rejectRequest(int index) {
        if (index >= 0 && index < pendingRequests.size()) {
            pendingRequests.remove(index);
            System.out.println("❌ Request rejected and removed.");
        } else {
            System.out.println("Invalid request index.");
        }
    }

    // Method to clear all requests (e.g., after saving or when the admin logs out)
    public static void clearRequests() {
        pendingRequests.clear();
    }

    // Getter method to return the list of pending requests
    public static ArrayList<EditRequest> getPendingRequests() {
        return pendingRequests;
    }

    // Setter method to set the list of pending requests (for external manipulation)
    public static void setPendingRequests(ArrayList<EditRequest> pendingRequests) {
        EditRequestManager.pendingRequests = pendingRequests;
    }

    // Method to display the requests for a specific artist
    public static void displayRequestsForArtist(Artist artist) {
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            boolean hasRequest = false;
            for (int i = 0; i < pendingRequests.size(); i++) {
                EditRequest req = pendingRequests.get(i);
                Song song = req.getSong();

                // Debugging: Print song and artist details
                if (song != null) {
                    System.out.println("Checking Song: " + song.getName() + " by " + song.getArtist());
                }

                // Check if the song belongs to the artist
                if (song != null && song.getArtist().equals(artist.getName())) {
                    hasRequest = true;
                    System.out.println((i + 1) + ". Song: " + song.getName());
                    System.out.println("   Suggested Lyrics: \n" + req.getNewLyrics());
                    System.out.println("   By User: " + req.getUser().getUsername());
                    System.out.println("   Status: " + (req.isApproved() ? "Approved" : "Pending"));
                    System.out.println("--------------------------------------------");
                }
            }

            if (!hasRequest) {
                System.out.println("No pending requests for your songs.");
            }
        }
    }
}
