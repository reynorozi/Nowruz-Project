package org.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Login {

    private Parseinfo parseinfo;

     public Login() {
         parseinfo = new Parseinfo();
     }

    public void Login() throws IOException {

        ArrayList<Account> accounts =parseinfo.parsinfo();

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

                    if (account instanceof Artist) {
                        System.out.println("Welcome back " + account.getName());
                    } else {
                        System.out.println("Welcome back " + account.getName());
                        Userhomepage user = new Userhomepage();
                        user.displayuserHome((User) account);
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