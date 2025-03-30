package org.example;

public class Loginmenu {
    public void display(int choice){
        //for cleaning the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //display the login page
        System.out.print(
                        "\t\t\t\t\t\t┏━━━┓┏━━━┓┏━┓ ┏┓┏━━┓┏┓ ┏┓┏━━━┓\n"+
                        "\t\t\t\t\t\t┃┏━┓┃┃┏━━┛┃ ┗┓┃┃┗┫┣┛┃┃ ┃┃┃┏━┓┃\n" +
                        "\t\t\t\t\t\t┃┃ ┗┛┃┗━━┓┃┏┓┗┛┃ ┃┃ ┃┃ ┃┃┃┗━━┓\n"+
                        "\t\t\t\t\t\t┃┃┏━┓┃┏━━┛┃┃┗┓ ┃ ┃┃ ┃┃ ┃┃┗━━┓┃\n"+
                        "\t\t\t\t\t\t┃┗┻━┃┃┗━━┓┃┃ ┃ ┃┏┫┣┓┃┗━┛┃┃┗━┛┃\n"+
                        "\t\t\t\t\t\t┗━━━┛┗━━━┛┗┛ ┗━┛┗━━┛┗━━━┛┗━━━┛\n\n\n");

        System.out.print ("\t\t\t\t\t\t   ╔");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.println ("╗");
        if (choice == 0){
            System.out.print ("\t\t\t\t\t\t   ║     > Sign Up       ║\n");
        }
        else{
            System.out.print ("\t\t\t\t\t\t   ║       Sign Up       ║\n");
        }
        System.out.print ("\t\t\t\t\t\t   ╚");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.print ("╝\n");
        System.out.print ("\t\t\t\t\t\t   ╔");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.println ("╗");
        if (choice == 1){
            System.out.print ("\t\t\t\t\t\t   ║     > Log in        ║\n");
        }
        else{
        System.out.print ("\t\t\t\t\t\t   ║       Log in        ║\n");
        }
        System.out.print ("\t\t\t\t\t\t   ╚");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.print ("╝\n");
    }
}

