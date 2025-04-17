package org.example;
import org.json.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {

    // Checks if the username is valid using regex
    private boolean ValidUsername(String Username) {

        // Regex pattern for validating username: must be 8-12 characters, contain letters/numbers/underscores/periods
        String regex = "^(?=.*[a-zA-Z])[a-zA-Z0-9._]{8,12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Username);
        if (!matcher.matches()) {
            // If the username doesn't match the pattern, print error message
            System.out.println("Invalid Username!\nYour username must contain:\n✅ at least one letter\n✅ have no spaces\n✅ be between 8 to 12 characters long");
            return false;
        } else {
            return true;
        }
    }

    // Checks if the password is valid using regex
    private boolean ValidPassword(String password) {

        // Regex pattern for validating password: must be at least 8 characters long, with uppercase, lowercase, number, and special char
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[\\S]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (!matcher.matches()) {
            // If the password doesn't match the pattern, print error message
            System.out.println("Invalid password!\nYour password must contain:\n✅ at least 8 characters\n✅ include at least one uppercase letter, and at least a lowercase\n✅ at least one number and at least a special char !@#$%^&*\n✅ have no spaces");
            return false;
        } else {
            return true;
        }
    }

    // This method handles the entire sign-up process, including username/password validation, role selection, and saving user data to a JSON file
    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n______________________SignUp_____________________");

        // Collect user's basic information
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Get and validate username
        System.out.print("Username: ");
        String Username = scanner.nextLine();
        boolean Valid = ValidUsername(Username);
        while (!Valid) {
            // If username is invalid, prompt again
            System.out.print("Username: ");
            Username = scanner.nextLine();
            Valid = ValidUsername(Username);
        }

        // Get and validate password
        System.out.print("Password: ");
        String Password = scanner.nextLine();
        boolean Validpass = ValidPassword(Password);
        while (!Validpass) {
            // If password is invalid, prompt again
            System.out.print("Password: ");
            Password = scanner.nextLine();
            Validpass = ValidPassword(Password);
        }

        // Determine the user's role (Artist or User)
        Account account;
        System.out.print("Choose your Role:\n1.Artist.\n2.User\n");
        String Role = (scanner.nextInt() == 1) ? "Artist" : "User";

        // Create an account based on the selected role
        if ("Artist".equals(Role)) {
            account = new Artist(Username, age, Password, name);
            System.out.println("Welcome  " + name);
        } else {
            account = new User(Username, age, Password, name);
            System.out.println("Welcome  " + name);
        }

        // Set the account's properties
        account.setName(name);
        account.setAge(age);
        account.setUsername(Username);
        account.setPassword(Password);

        // Create a JSONObject for the new user
        JSONObject user = new JSONObject();
        user.put("Name", name);
        user.put("Age", age);
        user.put("Username", Username);
        user.put("Password", Password);
        user.put("Role", Role);

        // Add additional properties based on the user's role
        if ("Artist".equals(Role)) {
            user.put("Followers", new JSONArray());
            user.put("Albums", new JSONArray());
            user.put("Songs", new JSONArray());
        } else if ("User".equals(Role)) {
            user.put("Comments", new JSONArray());
            user.put("FollowingSongs", new JSONArray());
            user.put("FollowingArtists", new JSONArray());
        }

        // Read existing data from the JSON file
        JSONObject existingData;
        try {
            existingData = new JSONObject(File.ReadData());
        } catch (Exception e) {
            // If there's an error reading the file, create a new JSON object
            System.out.println("Error reading data! Creating new JSON object...");
            existingData = new JSONObject();
        }

        // Get the existing list of accounts from the JSON object
        JSONArray users = existingData.optJSONArray("Accounts");
        if (users == null) {
            users = new JSONArray(); // Create new array if not present
        }

        // Add the new user to the accounts array
        users.put(user);
        existingData.put("Accounts", users);

        // Write the updated data back to the file
        System.out.println("Writing to file...");
        File.WriteData(existingData);
        System.out.println("Data written successfully!");

        // Redirect user to their homepage based on their role
        if (account instanceof User) {
            User userAccount = (User) account;
            PageNavigator.showPage(new Userhomepage(userAccount));
        }
        if (account instanceof Artist) {
            ArtistHomepage artisthome = new ArtistHomepage((Artist) account);
            artisthome.displayArtistHomepage();
        }
    }
}
