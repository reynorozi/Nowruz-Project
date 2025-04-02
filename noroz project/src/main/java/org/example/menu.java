package org.example;

public class menu {
    public void display(int choice){
        //for cleaning the console
        clean.screen();
        //display the login page
        System.out.print(
               "\t".repeat(12)+"┏━━━┓┏━━━┓┏━┓ ┏┓┏━━┓┏┓ ┏┓┏━━━┓\n"+
               "\t".repeat(12) +"┃┏━┓┃┃┏━━┛┃ ┗┓┃┃┗┫┣┛┃┃ ┃┃┃┏━┓┃\n" +
               "\t".repeat(12)+"┃┃ ┗┛┃┗━━┓┃┏┓┗┛┃ ┃┃ ┃┃ ┃┃┃┗━━┓\n"+
               "\t".repeat(12)+"┃┃┏━┓┃┏━━┛┃┃┗┓ ┃ ┃┃ ┃┃ ┃┃┗━━┓┃\n"+
               "\t".repeat(12)+"┃┗┻━┃┃┗━━┓┃┃ ┃ ┃┏┫┣┓┃┗━┛┃┃┗━┛┃\n"+
               "\t".repeat(12)+"┗━━━┛┗━━━┛┗┛ ┗━┛┗━━┛┗━━━┛┗━━━┛\n\n\n");

        System.out.print ( "\t".repeat(12)+"   ╔");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.println ("╗");
        if (choice == 0){
            System.out.print ( "\t".repeat(12)+"   ║     > Sign Up       ║\n");
        }
        else{
            System.out.print ( "\t".repeat(12)+"   ║       Sign Up       ║\n");
        }
        System.out.print ( "\t".repeat(12)+"   ╚");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.print ("╝\n");
        System.out.print ( "\t".repeat(12)+"   ╔");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.println ("╗");
        if (choice == 1){
            System.out.print ( "\t".repeat(12)+"   ║     > Log in        ║\n");
        }
        else{
        System.out.print ( "\t".repeat(12)+"   ║       Log in        ║\n");
        }
        System.out.print ( "\t".repeat(12)+"   ╚");
        for (int i = 0; i <= 20; i++)
        {
            System.out.print("═");
        }
        System.out.print ("╝\n");
    }
}

