package org.example;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Loginmenu loginmenu = new Loginmenu();

        int choice = 0;
        boolean showmenu = true;
        loginmenu.display(choice);
        Scanner scanner = new Scanner(System.in);
        while (showmenu) {
            String select = scanner.nextLine();
            if (select.isEmpty()) {
                showmenu = false;
            } else {
                if(select.equals("w")) {
                    choice = Math.max(0, choice - 1);
                }
                else if (select.equals("s")) {
                    choice = Math.min(1, choice + 1);
                }
            }
                loginmenu.display(choice);
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Account account = new Account();
        SignUp signup = new SignUp();
        Login login = new Login();
        if (choice == 0) {
           signup.signUp();

        } else if (choice == 1) {
            login.parsinfo();
            login.Login();
        }
    }
}
