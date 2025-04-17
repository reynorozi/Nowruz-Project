package org.example;

public class EditRequest {
    private Song song;        // The song for which the edit request was made
    private String newLyrics; // The new lyrics that the user wants to apply
    private User user;        // The user who made the edit request
    private boolean approved; // The approval status of the request (true if approved, false if pending or rejected)

    // Constructor to initialize the EditRequest with a song, new lyrics, and the user making the request
    public EditRequest(Song song, String newLyrics, User user) {
        this.song = song;
        this.newLyrics = newLyrics;
        this.user = user;
        this.approved = false; // By default, the request is considered rejected (not approved)
    }

    // Getter method for the song associated with the edit request
    public Song getSong() {
        return song;
    }

    // Getter method for the new lyrics provided in the request
    public String getNewLyrics() {
        return newLyrics;
    }

    // Setter method to change the approval status of the request
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    // Setter method to change the user who made the edit request
    public void setUser(User user) {
        this.user = user;
    }

    // Setter method to change the new lyrics in the request
    public void setNewLyrics(String newLyrics) {
        this.newLyrics = newLyrics;
    }

    // Setter method to change the song associated with the edit request
    public void setSong(Song song) {
        this.song = song;
    }

    // Getter method for the user who made the request
    public User getUser() {
        return user;
    }

    // Getter method to check if the request has been approved or not
    public boolean isApproved() {
        return approved;
    }

    // Method to approve the edit request (sets the approval status to true)
    public void approve() {
        this.approved = true;
    }

    // Method to reject the edit request (sets the approval status to false)
    public void reject() {
        this.approved = false;
    }

    // Overridden toString method to display the details of the edit request in a readable format
    @Override
    public String toString() {
        return "Song: " + song.getName() + "\nNew Lyrics: " + newLyrics + "\nRequested by: " + user.getUsername() + "\nStatus: " + (approved ? "Approved" : "Pending");
    }
}
