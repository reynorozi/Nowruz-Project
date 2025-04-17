package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserServices implements Edit {

    private ArrayList<Artist> followedArtists = new ArrayList<>(); // List of artists followed by the user
    private User user; // The current user interacting with the system

    // Constructor that accepts a User object
    public UserServices(User user) {
        this.user = user;
    }

    // Method to add a comment on a song
    public void AddComment(String songname, User user) {
        ShowComments(songname); // Show existing comments
        System.out.println("Add a comment... ");
        Scanner sc = new Scanner(System.in);
        String comment = sc.nextLine(); // Take user input for the comment

        // Create a JSON object for the new comment
        JSONObject addcomment = new JSONObject();
        addcomment.put("songname", songname);
        addcomment.put("comment", comment);
        addcomment.put("Time", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Read existing data from the file
        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        // Find the user in the JSON data and add the comment to their profile
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userobj = usersArray.getJSONObject(i);
            if (userobj.getString("Username").equals(user.getUsername()) &&
                    userobj.optString("Password").equals(user.getPassword())) {

                JSONArray comments = userobj.optJSONArray("Comments");
                comments.put(addcomment); // Add the new comment
                break;
            }
        }

        // Save the updated data back to the file
        File.WriteData(data);
        ShowComments(songname); // Show the updated comments
    }

    // Method to show the comments on a specific song
    public void ShowComments(String songname) {
        System.out.println("___Comments___\n");

        // Read the existing data from the file
        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        ArrayList<Comment> comments = new ArrayList<>(); // List to store comments

        // Iterate through the users and gather comments for the specified song
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userobj = usersArray.getJSONObject(i);
            JSONArray commentobj = userobj.optJSONArray("Comments");

            if (commentobj == null) continue;

            for (int j = 0; j < commentobj.length(); j++) {
                JSONObject obj = commentobj.getJSONObject(j);
                if (obj.optString("songname").equals(songname)) {
                    // Create a Comment object and add it to the list
                    Comment comment = new Comment(obj.optString("comment"),
                            userobj.optString("Username"),
                            obj.optString("Time"));
                    comments.add(comment);
                }
            }
        }

        // Display all the comments for the song
        for (Comment userscomm : comments) {
            System.out.println(userscomm.getAuthor());
            System.out.println(userscomm.getComment());
            System.out.println(userscomm.getDate());
            System.out.println("--".repeat(30)); // Divider between comments
        }
    }

    // Method to edit the lyrics of a song (only for the artist or admin)
    @Override
    public void EditLyric(Song song) {
        System.out.println("_________Edit lyrics____________\n");
        Scanner sc = new Scanner(System.in);
        String editLyric = sc.nextLine(); // Start taking the new lyrics from user

        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break; // Break the loop when an empty line is entered
            }
            editLyric += line + "\n"; // Append each line to the lyrics
        }

        // Create an edit request and add it to the edit request manager
        EditRequest request = new EditRequest(song, editLyric, user);
        EditRequestManager requestManager = new EditRequestManager();
        requestManager.addRequest(request);

        System.out.println("Thanks! If this lyrics edit gets approved by the artist or an admin, it will replace the original text.");
    }

    // Method to follow a song
    public void followsong(Song song, User user) {
        // Read the existing data from the file
        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        // Find the user and add the song to their followed songs list
        for (int i = 0; i < usersArray.length(); i++) {

            JSONObject userr = usersArray.getJSONObject(i);
            if (userr.getString("Username").equals(user.getUsername())) {
                JSONArray followedSongs = userr.getJSONArray("FollowingSongs");

                // Check if the song is already followed
                boolean alreadyFollowed = false;
                for (int j = 0; j < followedSongs.length(); j++) {
                    JSONObject existingSong = followedSongs.getJSONObject(j);
                    if (existingSong.getString("song").equals(song.getName())) {
                        alreadyFollowed = true;
                        break;
                    }
                }

                // If not already followed, add the song to the followed list
                if (!alreadyFollowed) {
                    JSONObject songInfo = new JSONObject();
                    songInfo.put("song", song.getName());
                    songInfo.put("artist", song.getArtist());
                    followedSongs.put(songInfo);
                    System.out.println("You followed the song " + song.getName() + " successfully.");
                } else {
                    System.out.println("You have already followed the song " + song.getName() + ".");
                }

                break;
            }
        }

        // Save the updated data back to the file
        File.WriteData(data);
    }

    // Method to follow an artist
    public void followArtist(Artist artist) {
        if (!followedArtists.contains(artist)) {
            followedArtists.add(artist); // Add the artist to the followed artists list
        }
    }

    // Method to get the number of followed artists
    public int getFollowedArtists() {
        return followedArtists.size();
    }

    // Static method to get the artists followed by a specific user
    public static ArrayList<Artist> getFollowingArtists(String username) {
        ArrayList<Artist> followedArtists = new ArrayList<>();

        // Read the existing data from the file
        String data = File.ReadData();
        JSONObject dataObject = new JSONObject(data);
        JSONArray accounts = dataObject.getJSONArray("Accounts");

        // Find the user and fetch the artists they are following
        for (int i = 0; i < accounts.length(); i++) {
            JSONObject account = accounts.getJSONObject(i);
            if (account.getString("Username").equals(username)) {
                JSONArray followingArtists = account.getJSONArray("FollowingArtists");

                // Add each followed artist to the list
                for (int j = 0; j < followingArtists.length(); j++) {
                    String artistName = followingArtists.getString(j);
                    Artist artist = ArtistData.getArtistByName(artistName);
                    if (artist != null) {
                        followedArtists.add(artist);
                    }
                }

                break; // No need to continue after finding the user
            }
        }

        return followedArtists; // Return the list of followed artists
    }

}
