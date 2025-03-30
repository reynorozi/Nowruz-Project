package org.example;

public class cleanscreen {
    public void cleanscreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
