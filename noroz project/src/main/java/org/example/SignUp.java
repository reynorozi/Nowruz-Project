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
        Matcher matcher =pattern.matcher(password);
        if (!matcher.matches()) {
            System.out.println("Invalid password!\nYour password must contain:\n✅ at least 8 characters\n✅has to include at least one uppercase letter, and at least a lowercase\n✅at least one number and at least a special char !@#$%^&*\n✅have no spaces" );
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
            Validpass = ValidUsername(Password);
        }

        System.out.print("Choose your Role:\n1.Artist.\n2.User\n");
        String Role = (scanner.nextInt() == 1) ? "Artist" : "User";

        JSONObject user = new JSONObject();
        user.put("Name", name);
        user.put("Age", age);
        user.put("Username", Username);
        user.put("Password", Password);
        user.put("Role",Role);




        JSONArray users = new JSONArray();
        try {

        JSONObject existingData = new JSONObject(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("Data.json"))));
        users = existingData.optJSONArray("Users");
        if (users == null) {
           users = new JSONArray();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        users.put(user);


        JSONObject newData = new JSONObject();
        newData.put("Users", users);

        try (FileWriter file = new FileWriter("Data.json")) {
            file.write(newData.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("User signed up successfully!");
    }
}
