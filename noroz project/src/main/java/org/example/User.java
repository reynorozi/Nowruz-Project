package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Account{

    JSONObject obj = new JSONObject(File.ReadData());
    JSONArray users = obj.getJSONArray("Accounts");
//
//public User() {
//
//}
public void AddComment(String songname) {
ShowComments(songname);
System.out.println("Add a comment... ");
Scanner sc = new Scanner(System.in);
String comment = sc.nextLine();
sc.close();

JSONObject addcomment = new JSONObject();

addcomment.put("songname", songname);
addcomment.put("comment", comment);
addcomment.put("Time", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));




for(int i = 0; i < users.length(); i++) {
    JSONObject userobj = users.getJSONObject(i);

    if(userobj.getString("Username").equals(this.getUsername())&&
            userobj.optString("Password").equals(this.getPassword())) {

        JSONArray comments = userobj.optJSONArray("Comments");
        if(comments == null) {
            comments = new JSONArray();
            userobj.put("Comments", comments);
        }
        comments.put(addcomment);
        break;
    }
}
File.WriteData(obj);
ShowComments(songname);
}

public void ShowComments(String songname) {
    System.out.println("_________Comments____________\n");
    ArrayList<Comment> comments = new ArrayList<>();
    Comment comment;

    for(int i = 0; i < users.length(); i++) {
        JSONObject userobj = users.getJSONObject(i);

        JSONArray commentobj = userobj.optJSONArray("Comments");
        if(commentobj == null) {
            continue;
        }
        for(int j = 0; j < commentobj.length(); j++) {

            JSONObject obj = commentobj.getJSONObject(j);

            if(commentobj != null && obj.optString("songname").equals(songname)) {

                comment = new Comment(obj.optString("comment"),userobj.optString("Username"),obj.optString("Time"));
                comments.add(comment);
            }

        }
    }

        for(int k = 0; k < comments.size(); k++) {
            Comment userscomm =  comments.get(k);
            System.out.println(userscomm.getAuthor());
            System.out.println(userscomm.getComment());
            System.out.println(userscomm.getDate());
            System.out.println("--".repeat(30));
        }
    }

}


/*
add comment done
edit lyrics
follow artist
list of comment
list of follow artist

 */