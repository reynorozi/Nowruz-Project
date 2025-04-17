package org.example;

public class Menu {

    // This method displays the menu based on the 'choice' argument
    public void display(int choice) {
        // Clearing the console screen


        // Displaying the logo/banner for the menu
        System.out.print(
                "\t".repeat(12) + "┏━━━┓┏━━━┓┏━┓ ┏┓┏━━┓┏┓ ┏┓┏━━━┓\n" +
                        "\t".repeat(12) + "┃┏━┓┃┃┏━━┛┃ ┗┓┃┃┗┫┣┛┃┃ ┃┃┃┏━┓┃\n" +
                        "\t".repeat(12) + "┃┃ ┗┛┃┗━━┓┃┏┓┗┛┃ ┃┃ ┃┃ ┃┃┃┗━━┓\n" +
                        "\t".repeat(12) + "┃┃┏━┓┃┏━━┛┃┃┗┓ ┃ ┃┃ ┃┃ ┃┃┗━━┓┃\n" +
                        "\t".repeat(12) + "┃┗┻━┃┃┗━━┓┃┃ ┃ ┃┏┫┣┓┃┗━┛┃┃┗━┛┃\n" +
                        "\t".repeat(12) + "┗━━━┛┗━━━┛┗┛ ┗━┛┗━━┛┗━━━┛┗━━━┛\n\n\n");

        // Drawing the first box for 'Sign Up'
        System.out.print( "\t".repeat(12) + "   ╔");
        for (int i = 0; i <= 20; i++) {
            System.out.print("═");
        }
        System.out.println("╗");

        // Checking if 'Sign Up' should be highlighted based on the choice
        if (choice == 0){
            System.out.print( "\t".repeat(12) + "   ║     > Sign Up       ║\n");
        }
        else {
            System.out.print( "\t".repeat(12) + "   ║       Sign Up       ║\n");
        }

        // Closing the first box
        System.out.print( "\t".repeat(12) + "   ╚");
        for (int i = 0; i <= 20; i++) {
            System.out.print("═");
        }
        System.out.print ("╝\n");

        // Drawing the second box for 'Log in'
        System.out.print( "\t".repeat(12) + "   ╔");
        for (int i = 0; i <= 20; i++) {
            System.out.print("═");
        }
        System.out.println("╗");

        // Checking if 'Log in' should be highlighted based on the choice
        if (choice == 1){
            System.out.print( "\t".repeat(12) + "   ║     > Log in        ║\n");
        }
        else {
            System.out.print( "\t".repeat(12) + "   ║       Log in        ║\n");
        }

        // Closing the second box
        System.out.print( "\t".repeat(12) + "   ╚");
        for (int i = 0; i <= 20; i++) {
            System.out.print("═");
        }
        System.out.print ("╝\n");
    }
}

