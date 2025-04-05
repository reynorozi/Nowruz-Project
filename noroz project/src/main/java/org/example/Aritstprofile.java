package org.example;

import java.util.ArrayList;

public class Aritstprofile {

    public void Aritstprofile(Artist artist) {
        System.out.println("█▀█  █▀█  █▀█  █▀▀  █  █    █▀▀\n" +
                           "█▀▀  █▀▄  █▄█  █▀   █  █▄▄  ██▄");
        printDivider();

        System.out.println(artist.getName());
        System.out.println("█▄█  █▀█  █ █  █▀█   █▀  █▀█  █▄ █  █▀▀  █▀\n" +
                           " █   █▄█  █▄█  █▀▄   ▄█  █▄█  █ ▀█  █▄█  ▄█");
        printDivider();
        ArrayList<Song> songs = Savesongs.getSongs(artist.getName(),true);
        int num = 1;
        for(int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            System.out.println(num+". " + song.getName()+"\n"+song.getArtist());
            System.out.println("____________________________");

        }
        System.out.println(
                "█▄█ █▀█ █ █ █▀█   ▄▀█ █   █▄▄ █ █ █▀▄▀█ █▀\n"+
                " █  █▄█ █▄█ █▀▄   █▀█ █▄▄ █▄█ █▄█ █ ▀ █ ▄█\n");
        printDivider();
//        ArrayList<Song> Albums = Savesongs.getSongs(artist.getName(),false);
//
//




    }
    private void printDivider() {
        System.out.println("━━".repeat(30));
    }
}
