package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Artist extends Account {

    ArrayList<Song> songlist = new ArrayList<>();

    public void AddSong() {

        Scanner scaninfo = new Scanner(System.in);
        System.out.println("Enter the name of the song:");

        String namesong = scaninfo.nextLine();
        System.out.println("Enter the lyrics of the song:");

        String lyricssong = scaninfo.nextLine();
        while (true) {
            String line = scaninfo.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lyricssong += line + "\n";
        }

        System.out.println("Enter the genre of the song:");
        String genressong = scaninfo.nextLine();

        String release = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Song song = new Song(namesong, this.getName(), "Single", lyricssong, genressong, release, 0);
        songlist.add(song);
        Savesongs.Savesongs(songlist);
    }

    public void AddAlbum() {


        int choice = 1;
            System.out.println("Enter the name of the album:");
            Scanner scan = new Scanner(System.in);
            String AlbumName = scan.nextLine();

            System.out.println("Enter the genre of the album:");
            String genreAlbum = scan.nextLine();

        while (choice==1){

            System.out.println("Enter the name of the song:");
            String namesong = scan.nextLine();

            System.out.println("Enter the lyrics of the song:");
            String lyricssong = scan.nextLine();
            while (true) {
                String line = scan.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                lyricssong += line + "\n";
            }

            String release = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Song addsong = new Song(namesong, this.getName(), AlbumName, lyricssong, genreAlbum, release, 0);
            songlist.add(addsong);

            System.out.println("1.Add another Song  2.Finish\n");
            choice = scan.nextInt();
            if(choice==2){
                if(songlist.size()>2){
                    System.out.println("The Album should have at most 2 songs\n");
                    choice = 1;
                    continue;
                }
            break;}
        }

        Savesongs.Savesongs(songlist);
    }

}

/*
create album
can edit her\his own song lyrics
add new song
 */