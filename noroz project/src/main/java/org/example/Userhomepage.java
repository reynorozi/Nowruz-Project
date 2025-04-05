package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Userhomepage {
    public static final String Blue = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String lightYellow = "\u001B[38;2;255;255;153m";

    public void displayuserHome(User user) {


        System.out.println("\n\n\n\n\n");
        System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET);

        System.out.println("┏               ┓" + "\t".repeat(18) + lightYellow + "█▀▀█ █▀▀ █▀▀▄  ▀  █  █ █▀▀" + RESET + "\t".repeat(16) + "┏               ┓\n"
                           + " 🔍search...    " + "\t".repeat(18) + lightYellow + "█ ▄▄ █▀▀ █  █  █▀ █  █ ▀▀▄" + RESET + "\t".repeat(16) + "  Profile\n" +
                           "┗               ┛" + "\t".repeat(18) + lightYellow + "█▄▄▀ ▀▀▀ ▀  ▀ ▀▀▀  ▀▀▀ ▀▀▀" + RESET + "\t".repeat(16) + "┗               ┛");

        System.out.println((Blue + "━━━━━━" + lightYellow + "━━━━━━").repeat(20) + RESET + "\n");


        System.out.println("▄▀▀ █▄█ ▄▀▄ █▀▄ ▀█▀\n▀▄▄ █ █ █▀█ █▀▄  █");


        ArrayList<Song> songs = Song.getSongs();
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

        if (input.equals("s")) {
            //call the search method
        } else {
            int num = Integer.parseInt(input);
            if (num > songs.size()) {
                System.out.println("Please enter a number less than " + songs.size() + ".");
                num = scan.nextInt();
            }
            lyricspage(songs.get(num - 1), user);
        }
    }


    public void lyricspage(Song song, User user) {
        printDivider();
        System.out.println(song.getName() + "\nArtist: " + song.getArtist() + "\nAlbum: " + song.getAlbum() + "\nGenre: " + song.getGenre() + "\n");
        printDivider();
        System.out.println("┏               ┓" + " ┏               ┓" + "  ┏               ┓");
        System.out.println("  💬Comment" + "  " + "      🫧Follow" + "  " + "         ✍️Edit lyric");
        System.out.println("┗               ┛" + " ┗               ┛" + "  ┗               ┛");
        printDivider();
        System.out.println(song.getLyric());
        printDivider();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);


        switch (Character.toUpperCase(ch)) {
            case 'C' -> user.AddComment(song.getName());
            case 'F' -> user.followsong(song);
            case 'E' -> user.Editlyric(song);
            case 'B' -> displayuserHome(user);
//            case 'A' -> //FFFFFFFFFFFFFFFFFFFFFFFFFFFF
            default -> System.out.println("Invalid option!");

        }
//        lyricspage(song, user);
    }


    private void printDivider() {
        System.out.println("━━".repeat(30));
    }
}

