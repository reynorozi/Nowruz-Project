package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Handlemenu implements Page {

    // Method to display the menu and handle user input
    @Override
    public void show() {

        Menu MENU = new Menu(); // Create a new Menu object
        int choice = 0; // Default choice is 0 (Sign Up)
        boolean showmenu = true; // Flag to keep showing the menu

        MENU.display(choice); // Display the menu with the current choice

        Scanner scanner = new Scanner(System.in); // Scanner to read user input

        // Loop to keep showing the menu until user makes a choice
        while (showmenu) {
            String select = scanner.nextLine(); // Get user input

            // If input is empty, stop showing the menu
            if (select.isEmpty()) {
                showmenu = false;
            } else {
                // If user presses 'w' or 'W', decrease choice (move up)
                if (select.equals("w") || select.equals("W")) {
                    choice = Math.max(0, choice - 1); // Ensure choice doesn't go below 0
                }
                // If user presses 's' or 'S', increase choice (move down)
                else if (select.equals("s") || select.equals("S")) {
                    choice = Math.min(1, choice + 1); // Ensure choice doesn't go above 1
                }
            }
            // Display the updated menu after the user input
            MENU.display(choice);
        }

        // Create SignUp and Login objects
        SignUp signup = new SignUp();
        Login login = new Login();

        // Perform the corresponding action based on the user's choice
        if (choice == 0) {
            signup.signUp(); // If choice is 0, call the sign-up method
        } else if (choice == 1) {
            try {
                login.Login(); // If choice is 1, call the login method
            } catch (IOException e) {
                throw new RuntimeException(e); // Handle IOException if login fails
            }
        }
    }
}
