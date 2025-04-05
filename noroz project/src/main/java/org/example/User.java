package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Account {

    JSONObject obj = new JSONObject(File.ReadData());
//    JSONArray users = obj.getJSONArray("Accounts");


    public void AddComment(String songname) {

        ShowComments(songname);
        System.out.println("Add a comment... ");
        Scanner sc = new Scanner(System.in);
        String comment = sc.nextLine();

        JSONObject addcomment = new JSONObject();
        addcomment.put("songname", songname);
        addcomment.put("comment", comment);
        addcomment.put("Time", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));


        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userobj = usersArray.getJSONObject(i);
            if (userobj.getString("Username").equals(this.getUsername()) &&
                    userobj.optString("Password").equals(this.getPassword())) {

                JSONArray comments = userobj.optJSONArray("Comments");
//                if (comments == null) {
//                    comments = new JSONArray();
//                    userobj.put("Comments", comments);
//                }
                comments.put(addcomment);
                break;
            }
        }


        File.WriteData(data);
        ShowComments(songname);
    }

    public void ShowComments(String songname) {
        System.out.println("___Comments__\n");


        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        ArrayList<Comment> comments = new ArrayList<>();
        Comment comment;

        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userobj = usersArray.getJSONObject(i);
            JSONArray commentobj = userobj.optJSONArray("Comments");

            if (commentobj == null) continue;

            for (int j = 0; j < commentobj.length(); j++) {
                JSONObject obj = commentobj.getJSONObject(j);
                if (obj.optString("songname").equals(songname)) {
                    comment = new Comment(obj.optString("comment"),
                            userobj.optString("Username"),
                            obj.optString("Time"));
                    comments.add(comment);
                }
            }
        }

        for (Comment userscomm : comments) {
            System.out.println(userscomm.getAuthor());
            System.out.println(userscomm.getComment());
            System.out.println(userscomm.getDate());
            System.out.println("--".repeat(30));
        }
    }

    public void Editlyric(Song song) {

        System.out.println("_________Editlyrics____________\n");
        Scanner sc = new Scanner(System.in);
        String editlyric = sc.nextLine();
        sc.close();
        System.out.println("Thanks! If this lyrics edit gets approved by the artist or an admin, it will replace the original text.");
        //متدی که این استرینگ و یوزنیم رو میگیره و بولینه
        //بعد میگیم اگه درست بود ....
    }

    public void followsong(Song song) {

        String jsonData = File.ReadData();
        JSONObject data = new JSONObject(jsonData);
        JSONArray usersArray = data.getJSONArray("Accounts");

        for (int i = 0; i < usersArray.length(); i++) {

            JSONObject user = usersArray.getJSONObject(i);
            if (user.getString("Username").equals(this.getUsername())) {
                JSONArray followedSongs = user.getJSONArray("FollowingSongs");


                JSONObject songInfo = new JSONObject();
                songInfo.put("song", song.getName());
                songInfo.put("artist", song.getArtist());
                followedSongs.put(songInfo);
                System.out.println("you followed the song " + song.getName()+"succesfully");

                break;
            }
        }
        File.WriteData(data);
    }
}