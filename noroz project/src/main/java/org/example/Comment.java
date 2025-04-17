package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class Comment {
    private String comment;  // The content of the comment
    private String author;   // The author of the comment
    private String date;     // The date when the comment was made

    // Constructor for creating a new comment object
    public Comment(String comment, String author, String date) {
        this.comment = comment;
        this.author = author;
        this.date = date;
    }

    // Getter and setter methods for comment, author, and date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Method to get the list of comments made by a specific user
    public static ArrayList<Comment> getCommentsByUsername(String username) {
        ArrayList<Comment> comments = new ArrayList<>();  // Create a list to store comments
        String jsonData = File.ReadData();  // Read the data from the file
        JSONObject dataObject = new JSONObject(jsonData);  // Parse the data into a JSONObject
        JSONArray accounts = dataObject.getJSONArray("Accounts");  // Get the list of accounts from the JSON data

        // Iterate through all accounts to find the one with the given username
        for (int i = 0; i < accounts.length(); i++) {
            JSONObject account = accounts.getJSONObject(i);
            // Check if the account is a user and matches the given username
            if (account.getString("Role").equals("User") && account.getString("Username").equals(username)) {
                // Get the array of comments associated with this user
                JSONArray commentArray = account.getJSONArray("Comments");

                // Iterate through the comments and add them to the list
                for (int j = 0; j < commentArray.length(); j++) {
                    JSONObject jsonComment = commentArray.getJSONObject(j);  // Get the individual comment
                    String text = jsonComment.getString("comment");  // Extract the comment text
                    String date = jsonComment.getString("Time");  // Extract the comment's date
                    String songname = jsonComment.getString("songname");  // Extract the song's name the comment is related to
                    Comment comment = new Comment(text, songname, date);  // Create a new Comment object
                    comments.add(comment);  // Add the comment to the list
                }
                break;  // Stop searching once the comments for the user are found
            }
        }

        // Define the date format to parse the comment dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Sort the comments based on their date (oldest to newest)
        comments.sort(Comparator.comparing(c -> LocalDate.parse(c.getDate(), formatter)));

        return comments;  // Return the sorted list of comments
    }
}
