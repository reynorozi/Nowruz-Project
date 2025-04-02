package org.example;

public class clean {
    public static void screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n\n");
    }
}
