package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Login {

    private ArrayList<Account> accounts;

public void parsinfo() throws IOException {

accounts = new ArrayList<>();
String Data = new String(Files.readAllBytes(Paths.get("Data.json")));
JSONObject obj = new JSONObject(Data);
JSONArray users = obj.getJSONArray("Users");

for(int i = 0; i < users.length(); i++) {

    JSONObject userobj = users.getJSONObject(i);
    Account account = new Account();

    account.setUsername(userobj.optString("Username"));
    account.setPassword(userobj.optString("Password"));
    account.setName(userobj.optString("Name"));
    account.setAge(userobj.optInt("Age"));
    account.setRole(userobj.optString("Role"));
    accounts.add(account);
    }

}
    public void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n______________________Login_____________________");


        String username = "";
        boolean usernameFound = false;
        int counter = 3;
        while (counter > 0 && !usernameFound) {
            System.out.print("Username: ");
            username = scanner.nextLine();

            for (Account account : accounts) {
                if (account.getUsername().equals(username)) {
                    usernameFound = true;
                    break;
                }
            }

            if (!usernameFound) {
                System.out.println("Username not found! Please try again.");
                counter--;
            }
        }
        int chance = 4;
        boolean passwordCorrect = false;
        while (chance > 0 &&!passwordCorrect&& usernameFound) {
            System.out.print("Password: ");
            String password = scanner.nextLine();


            for (Account account : accounts) {
                if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                    passwordCorrect = true;
                    System.out.println("You are logged in!");

                    if (account.getRole().equals("Artist")) {
                        // go to the artist page
                        System.out.println("Welcome Artist!");
                    } else {
                        // go to the User page
                        System.out.println("Welcome User!");
                    }
                    break;
                }
            }

            if (!passwordCorrect) {
                System.out.println("Incorrect password! Please try again.");
                chance--;
            }
        }
        if (!usernameFound || !passwordCorrect) {
            System.out.println("you are not logged in!");
            SignUp signup = new SignUp();
            signup.signUp();
        }
    }
}