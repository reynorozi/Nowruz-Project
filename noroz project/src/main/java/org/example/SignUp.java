package org.example;
import org.json.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SignUp {

    //check the username is valid or not by using regex
    private boolean ValidUsername(String Username) {

        String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9._]{8,12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Username);
        if (!matcher.matches()) {
            System.out.println("Invalid Username!\nYour username must contain:\n✅ at least one letter\n✅have no spaces\n✅ be between 8 to 12 characters long");
            return false;
        } else {
            return true;
        }
    }

    //check the password is vaild or not
    private boolean ValidPassword(String password) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[\\S]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            System.out.println("Invalid password!\nYour password must contain:\n✅ at least 8 characters\n✅has to include at least one uppercase letter, and at least a lowercase\n✅at least one number and at least a special char !@#$%^&*\n✅have no spaces");
            return false;
        } else {
            return true;
        }
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n______________________SignUp_____________________");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Username: ");
        String Username = scanner.nextLine();
        boolean Valid = ValidUsername(Username);
        while (!Valid) {
            System.out.print("Username: ");
            Username = scanner.nextLine();
            Valid = ValidUsername(Username);
        }

        System.out.print("Password: ");
        String Password = scanner.nextLine();
        boolean Validpass = ValidPassword(Password);
        while (!Validpass) {
            System.out.print("Password: ");
            Password = scanner.nextLine();
            Validpass = ValidPassword(Password);
        }

        Account account;
        System.out.print("Choose your Role:\n1.Artist.\n2.User\n");
        String Role = (scanner.nextInt() == 1) ? "Artist" : "User";
        if ("Artist".equals(Role)) {
            account = new Artist();
            System.out.println("Welcome  " + name);
        } else {
            account = new User();
            System.out.println("Welcome  " + name);
        }

        account.setName(name);
        account.setAge(age);
        account.setUsername(Username);
        account.setPassword(Password);



        JSONObject user = new JSONObject();
        user.put("Name", name);
        user.put("Age", age);
        user.put("Username", Username);
        user.put("Password", Password);
        user.put("Role", Role);

        if(Role == "Artist"){
            user.put("Followers", new JSONArray());
            user.put("Albums", new JSONArray());
            user.put("Songs", new JSONArray());
        }
        else if(Role == "User"){

        user.put("Comments", new JSONArray());
        user.put("FollowingSongs", new JSONArray());
        user.put("FollowingArtists", new JSONArray());
        }


        JSONObject existingData;
        try {
            existingData = new JSONObject(File.ReadData());
        } catch (Exception e) {
            System.out.println("Error reading data! Creating new JSON object...");
            existingData = new JSONObject();
        }

            JSONArray users = existingData.optJSONArray("Accounts");
            if (users == null) {
                users = new JSONArray();
            }

            users.put(user);
            existingData.put("Accounts", users);

            System.out.println("Writing to file...");
            File.WriteData(existingData);
            System.out.println("Data written successfully!");

            if (account instanceof User) {
                Userhomepage userhome = new Userhomepage();
                userhome.displayuserHome((User) account);
            }
            if (account instanceof Artist) {
                ArtistHomepage artisthome = new ArtistHomepage();
                artisthome.displayArtistHomepage((Artist) account);
            }
        }
    }
