package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Login {

    private Parseinfo parseinfo;

    /**
     * Constructor that initializes the Parseinfo object.
     * The Parseinfo object is responsible for parsing the data from the JSON file.
     */
    public Login() {
        parseinfo = new Parseinfo();
    }

    /**
     * This method handles the login process.
     * It first checks if the username exists and then verifies the password.
     * The user has 3 attempts to enter the correct username and 4 attempts to enter the correct password.
     * If successful, it redirects the user to the corresponding homepage (Artist or User).
     * If login fails, it directs the user to the signup page.
     *
     * @throws IOException if an I/O error occurs while reading data
     */
    public void Login() throws IOException {

        // Parse the account data from the JSON file
        ArrayList<Account> accounts = parseinfo.parsinfo();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n\n\n______________________Login_____________________");

        // Check for a valid username (3 attempts)
        String username = "";
        boolean usernameFound = false;
        int counter = 3; // Number of attempts for username
        while (counter > 0 && !usernameFound) {
            System.out.print("Username: ");
            username = scanner.nextLine(); // Get the username input from the user

            // Search for the username in the accounts list
            for (Account account : accounts) {
                if (account.getUsername().equals(username)) {
                    usernameFound = true; // If found, exit loop
                    break;
                }
            }

            if (!usernameFound) {
                System.out.println("Username not found! Please try again.");
                counter--; // Decrease attempt count
            }
        }

        // If username found, check for the password (4 attempts)
        int chance = 4; // Number of attempts for password
        boolean passwordCorrect = false;
        while (chance > 0 && !passwordCorrect && usernameFound) {
            System.out.print("Password: ");
            String password = scanner.nextLine(); // Get the password input

            // Search for the account and verify the password
            for (Account account : accounts) {
                if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                    passwordCorrect = true; // If password matches, exit loop
                    System.out.println("You are logged in!");

                    // Redirect to the homepage based on account type (Artist or User)
                    if (account instanceof Artist) {
                        System.out.println("Welcome back " + account.getName());
                        ArtistHomepage artisthome = new ArtistHomepage((Artist) account);
                        artisthome.displayArtistHomepage(); // Artist homepage
                    } else if (account instanceof User) {
                        System.out.println("Welcome back " + account.getName());
                        User userAccount = (User) account;
                        PageNavigator.showPage(new Userhomepage(userAccount));// User homepage
                    }
                    else if (account instanceof Admin) {
                        System.out.println("Welcome back " + account.getName());

                        Admin adminAccount = (Admin) account;


                        EditRequestManager manager = new EditRequestManager();

                        AdminPage adminPage = new AdminPage(adminAccount, manager);
                        adminPage.show();
                    }

                    break;
                }
            }

            if (!passwordCorrect) {
                System.out.println("Incorrect password! Please try again.");
                chance--; // Decrease attempt count
            }
        }

        // If either username or password is incorrect, prompt signup
        if (!usernameFound || !passwordCorrect) {
            System.out.println("you are not logged in!");
            SignUp signup = new SignUp();
            signup.signUp(); // Redirect to sign-up page
        }
    }
}
