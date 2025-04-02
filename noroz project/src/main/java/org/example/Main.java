package org.example;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        menu MENU = new menu();

        int choice = 0;
        boolean showmenu = true;
        MENU.display(choice);
        Scanner scanner = new Scanner(System.in);
        while (showmenu) {
            String select = scanner.nextLine();
            if (select.isEmpty()) {
                showmenu = false;
            } else {
                if(select.equals("w") || select.equals("W")) {
                    choice = Math.max(0, choice - 1);
                }
                else if (select.equals("s") || select.equals("S")) {
                    choice = Math.min(1, choice + 1);
                }
            }
                MENU.display(choice);
        }

        clean.screen();

        SignUp signup = new SignUp();
        Login login = new Login();
        if (choice == 0) {
           signup.signUp();

        } else if (choice == 1) {
            clean.screen();
            Userhomepage userhome = new Userhomepage();
//            userhome.displayHome();
            login.Login();
        }
    }
}
