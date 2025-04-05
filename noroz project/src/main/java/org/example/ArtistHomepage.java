package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ArtistHomepage {
    public static final String Blue = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String lightYellow = "\u001B[38;2;255;255;153m";

    public void displayArtistHomepage(Artist artist) {

        ArrayList<Song> songs = Song.getSongs();

        System.out.println("\n\n\n\n\n");
        System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET);

        System.out.println("┏               ┓" +" ┏               ┓" +"\t".repeat(14) + lightYellow + "█▀▀█ █▀▀ █▀▀▄  ▀  █  █ █▀▀" + RESET + "\t".repeat(16) + "┏               ┓\n"
                + "  🎵Add Song   " +   "     🎼Add Album  "+"\t".repeat(14) + lightYellow + "█ ▄▄ █▀▀ █  █  █▀ █  █ ▀▀▄" + RESET + "\t".repeat(16) + "    Profile\n" +
                "┗               ┛" + " ┗               ┛"+"\t".repeat(14) + lightYellow + "█▄▄▀ ▀▀▀ ▀  ▀ ▀▀▀  ▀▀▀ ▀▀▀" + RESET + "\t".repeat(16) + "┗               ┛");

        System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET + "\n");


        System.out.println("▄▀▀ █▄█ ▄▀▄ █▀▄ ▀█▀\n▀▄▄ █ █ █▀█ █▀▄  █");

        if(songs == null){
            System.out.println("No songs found");
        }

        int numsongs = 1;

        for (int i = 0; i < songs.size(); i++) {
            System.out.println(numsongs + ". '" + songs.get(i).getName() + "'\t " + songs.get(i).getArtist() + " \tview:" + songs.get(i).getView());
            numsongs++;
            System.out.println("━━".repeat(30));
        }
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.equals("Add Song")){
            artist.AddSong();
        }
        else if(input.equals("Add Album")){
            artist.AddAlbum();
        }
        else if(input.equals("Profile")) {
            Aritstprofile ar = new Aritstprofile();
            ar.Aritstprofile(artist);
        }


    }
}
