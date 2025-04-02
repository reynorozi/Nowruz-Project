package org.example;

import java.util.ArrayList;

public  class Song {
    private String name;
    private String artist;
    private String album;
    private String lyric;
    private String genre;
    private int release;
    private int view;

    public Song(String name, String artist, String album, String lyric, String genre, int release, int view) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.lyric = lyric;
        this.genre = genre;
        this.release = release;
        this.view = view;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
    static  String money = "[Intro]\n" +
            "(Money)\n" +
            "(Money) Lie for it, spy for it\n" +
            "Kill for it, die for it\n" +
            "\n" +
            "[Verse 1]\n" +
            "So you call it trust, but I say it's just\n" +
            "In the devil's game of greed and lust\n" +
            "They don't care, they'd do me for the money\n" +
            "They don't care, they use me for the money\n" +
            "So you go to church, read the holy word\n" +
            "In the scheme of life, it's all absurd\n" +
            "They don't care, they'd kill for the money\n" +
            "Do or dare, the thrill for the money\n" +
            "You're saluting the flag, your country trusts you\n" +
            "Now you're wearing a badge, you're called the \"Just Few\"\n" +
            "And you're fighting the wars, a soldier must do\n" +
            "I'll never betray or deceive you, my friend, but\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "If you show me the cash, then I will take it (Ah)\n" +
            "If you tell me to cry, then I will fake it (Ah)\n" +
            "If you give me a hand, then I will shake it\n" +
            "You would do anything for money\n" +
            "\n" +
            "[Chorus]\n" +
            "Anything, anything (Ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "Anything, anything (Ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "\n" +
            "[Verse 2]\n" +
            "Insurance? Where do your loyalties lie?\n" +
            "Is that your alibi? (Ah) I don't think so\n" +
            "You don't care, you'd do her for the money\n" +
            "Say it's fair, you sue her for the money\n" +
            "Want your pot of gold, need the Midas touch\n" +
            "Bet you sell your soul 'cause your god is such\n" +
            "You don't care, you kill for the money\n" +
            "Do or dare, the thrill for the money\n" +
            "Are you infected with the same disease of lust, gluttony and greed?\n" +
            "Then watch the ones with the biggest smiles, the idle jabbers\n" +
            "'Cause they're the backstabbers\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "If you know it's a lie, then you will swear it (Ah)\n" +
            "If you give it with guilt, then you will bear it (Ah)\n" +
            "If it's taking a chance, then you will dare it\n" +
            "You would do anything for money\n" +
            "\n" +
            "[Chorus]\n" +
            "Anything, anything (Ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "Anything, anything (Ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "Anything, anything (Hee, ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "Anything, anything (Hee, ah), anything for money (Ah, ah)\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil\n" +
            "\n" +
            "[Bridge]\n" +
            "You say you wouldn't do it for all the money in the world\n" +
            "I don't think so\n" +
            "If you show me the man, then I will sell him\n" +
            "If you ask me to lie, then I will tell him\n" +
            "If it's dealing with God, then you will hell Him\n" +
            "You would do anything for money\n" +
            "\n" +
            "[Chorus]\n" +
            "Anything (Ah), anything for money\n" +
            "Would lie for you, would die for you (Ah)\n" +
            "Even sell my soul to the devil (Ah)\n" +
            "Anything, anything (Ah), anything for money (Ah, ah)\n" +
            "Would lie for you (If you want it, you can earn it with dignity), would die for you\n" +
            "Even sell my soul to the devil\n" +
            "Anything, anything (Vanderbilt, Morgan), anything for money (Trump)\n" +
            "Would lie for you, would die for you (Rockefeller)\n" +
            "Even sell my soul to the devil (Carnegie)\n" +
            "Anything, anything (Getty), anything for money (Getty)\n" +
            "Would lie for you, would die for you (Getty)\n" +
            "Even sell my soul to the devil (Getty, Getty, Getty!)\n" +
            "Anything, anything (Money makes the world go round)\n" +
            "Anything for money (Money makes the world go round)\n" +
            "Would lie for you (Money makes the world go round)\n" +
            "Would die for you (Don't sell it)\n" +
            "Even sell my soul to the devil (Money makes the world go round)\n" +
            "Anything, anything (Money makes the world go round)\n" +
            "Anything for money (Money makes the world go round)\n" +
            "Would lie for you (Money makes the world go round)\n" +
            "Would die for you\n" +
            "Even sell my soul to the devil (Money makes the world go round)\n" +
            "Anything (Money makes the world go round)\n" +
            "Anything for money (Money makes the world go round)\n" +
            "Would lie for you (Money makes the world go round)\n" +
            "Would die for you\n" +
            "Even sell my soul to the devil (Money makes the world go round)\n" +
            "Anything, anything\n" +
            "Anything for money (Money makes the world go round)\n" +
            "Would lie for you (Money makes the world go round)\n" +
            "Would die for you\n" +
            "Even sell my soul to the devil";
     static  String myboy = "[Verse 1]\n" +
            "Oh, here we go again\n" +
            "The voices in his head\n" +
            "Called the rain to end our days of wild\n" +
            "The sickest army doll\n" +
            "Purchased at the mall\n" +
            "Rivulets descend my plastic smile\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "But you should've seen him when he first got me\n" +
            "\n" +
            "[Chorus]\n" +
            "My boy only breaks his favorite toys, toys, oh\n" +
            "I'm queen of sand castles he destroys, oh, oh\n" +
            "'Cause it fit too right, puzzle pieces in the dead of night\n" +
            "I should've known it was a matter of time, oh, oh\n" +
            "My boy only breaks his favorite toys, oh, oh\n" +
            "\n" +
            "[Verse 2]\n" +
            "There was a litany of reasons why\n" +
            "We could've played for keeps this time\n" +
            "I know I'm just repeating myself\n" +
            "Put me back on my shelf\n" +
            "But first, pull the string\n" +
            "And I'll tell you that he runs\n" +
            "Because he loves me (He loves me)\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "'Cause you should've seen him when he first saw me\n" +
            "\n" +
            "[Chorus]\n" +
            "My boy (My boy), only breaks his favorite toys, toys, oh\n" +
            "I'm queen (I'm queen), of sand castles he destroys, oh, oh\n" +
            "'Cause I knew too much, there was danger in the heat of my touch\n" +
            "He saw forever, so he smashed it up, oh, oh\n" +
            "My boy (My boy), only breaks his favorite toys, oh, oh\n" +
            "\n" +
            "[Bridge]\n" +
            "(Oh-oh-oh, oh-oh-oh) Once I fix me\n" +
            "(Oh-oh-oh, oh-oh-oh) He's gonna miss me\n" +
            "(Oh-oh-oh, oh-oh-oh) Once I fix me\n" +
            "(Oh-oh-oh, oh-oh-oh) He's gonna miss me\n" +
            "\n" +
            "[Outro]\n" +
            "Just say when, I'd play again\n" +
            "He was my best friend down at the sandlot\n" +
            "I felt more when we played pretend\n" +
            "Than with all the Kens\n" +
            "'Cause he took me out of my box\n" +
            "Stole my tortured heart\n" +
            "Left all these broken parts\n" +
            "Told me I'm better off\n" +
            "But I'm not\n" +
            "I'm not, I'm not";
     static  String  DieWithSmile = "[Intro: Bruno Mars]\n" +
            "(Ooh, ooh)\n" +
            "\n" +
            "[Verse 1: Bruno Mars]\n" +
            "I, I just woke up from a dream\n" +
            "Where you and I had to say goodbye\n" +
            "And I don't know what it all means\n" +
            "But since I survived, I realized\n" +
            "\n" +
            "[Pre-Chorus: Bruno Mars]\n" +
            "Wherever you go, that's where I'll follow\n" +
            "Nobody's promised tomorrow\n" +
            "So I'ma love you every night like it's the last night\n" +
            "Like it's the last night\n" +
            "\n" +
            "[Chorus: Bruno Mars]\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "If the party was over\n" +
            "And our time on Earth was through\n" +
            "I'd wanna hold you just for a while\n" +
            "And die with a smile\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "\n" +
            "[Post-Chorus: Bruno Mars]\n" +
            "(Ooh, ooh)\n" +
            "\n" +
            "[Verse 2: Lady Gaga, Lady Gaga & Bruno Mars]\n" +
            "Ooh, lost, lost in the words that we scream\n" +
            "I don't even wanna do this anymore\n" +
            "'Cause you already know what you mean to me\n" +
            "And our love's the only war worth fighting for\n" +
            "\n" +
            "[Pre-Chorus: Lady Gaga & Bruno Mars]\n" +
            "Wherever you go, that's where I'll follow\n" +
            "Nobody's promised tomorrow\n" +
            "So I'ma love you every night like it's the last night\n" +
            "Like it's the last night\n" +
            "\n" +
            "[Chorus: Lady Gaga & Bruno Mars, Lady Gaga]\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "If the party was over\n" +
            "And our time on Earth was through\n" +
            "I'd wanna hold you just for a while\n" +
            "And die with a smile\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "\n" +
            "[Bridge: Bruno Mars, Lady Gaga, Both]\n" +
            "Right next to you\n" +
            "Next to you\n" +
            "Right next to you\n" +
            "Oh-oh\n" +
            "\n" +
            "[Chorus: Lady Gaga, Lady Gaga & Bruno Mars, Bruno Mars]\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "If the party was over\n" +
            "And our time on Earth was through\n" +
            "I'd wanna hold you just for a while\n" +
            "And die with a smile\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "If the world was ending\n" +
            "I'd wanna be next to you\n" +
            "\n" +
            "[Outro: Bruno Mars, Lady Gaga & Bruno Mars]\n" +
            "(Ooh, ooh)\n" +
            "I'd wanna be next to you\n" +
            "Embed\n";


    static String monster = "[Intro]\n" +
            "(Ah!) Ha, aaow!\n" +
            "(Ah!) Ha, aaow!\n" +
            "\n" +
            "[Verse 1]\n" +
            "Ah, you can look at them comin' out the walls\n" +
            "You can look at them climbin' out the bushes\n" +
            "You can find them when the letter's 'bout to fall\n" +
            "He be waitin' with his camera right on focus (No)\n" +
            "Everywhere you seem to turn, there's a monster\n" +
            "When you look up in the air, there's a monster\n" +
            "Paparazzi got you scared like a monster\n" +
            "Monster, monster\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "Too bad (Oh-oh, Hollywood)\n" +
            "It's got you jumpin' like you should (Too bad)\n" +
            "It's got you bouncin' off the wall\n" +
            "It's got you drunk enough to fall (Too bad, oh-oh, Hollywood)\n" +
            "Just look in the mirror\n" +
            "And tell me you like, don't you, don't you like it? (Aaow)\n" +
            "\n" +
            "[Chorus]\n" +
            "Monster, he's a monster (Mmm)\n" +
            "He's an animal\n" +
            "Monster (Yeah), he's a monster\n" +
            "He's an animal (Mmm, oh-oh-oh)\n" +
            "\n" +
            "[Verse 2]\n" +
            "He's comin' at ya, comin' at ya rather too fast\n" +
            "Mama-say, mama got you in a zig-zag\n" +
            "And you're runnin', and you're runnin' just to escape it\n" +
            "But they're gunnin' for the money, so they fake it\n" +
            "Everywhere you seem to turn, there's a monster\n" +
            "When you look up in the air, there's a monster\n" +
            "When you see them in the street, that's a monster\n" +
            "Monster, monster\n" +
            "\n" +
            "[Pre-Chorus]\n" +
            "Too bad (Oh-oh, Hollywood)\n" +
            "It's got you jumpin' like you should (Too bad)\n" +
            "It's got you bouncin' off the wall\n" +
            "It's got you drunk enough to fall (Too bad, oh-oh, Hollywood)\n" +
            "Just look in the mirror\n" +
            "And tell me you like what you see\n" +
            "\n" +
            "[Chorus]\n" +
            "Monster (He's like an animal), he's a monster (Just like an animal)\n" +
            "He's an animal (And he's movin' in the air, ah)\n" +
            "Monster, he's a monster\n" +
            "He's an animal (Everybody wanna be a star, ooh)\n" +
            "\n" +
            "[Bridge]\n" +
            "Why are they (Why are they) never satisfied (Satisfied)\n" +
            "Within all you give? (Yeah, yeah, yeah, yeah) Ah\n" +
            "You give them your all, they're watching you fall\n" +
            "And they eat your soul (Ah!)\n" +
            "\n" +
            "[Verse 3: 50 Cent]\n" +
            "Yeah, yeah, yeah\n" +
            "Catch me in a bad mood flipping, you'll take a whippin' (Ha)\n" +
            "Animal, Hannibal, cannibal addiction\n" +
            "Tears appear, yeah, blurring your vision\n" +
            "Fear in the air, screaming, your blood drippin' (Aaow)\n" +
            "Shiver a second, now, now, now, what is it? (Ha)\n" +
            "Funerals, cemeteries, don't worry, it's time to visit\n" +
            "Broke bones, tombstones, how do you think I'm kiddin'?\n" +
            "It's home, sweet home, the land of the forbidden (Aaow)\n" +
            "All hail, run, tell, the King has risen (Ha)\n" +
            "2010 Thriller, there's nothin' iller, it's killer\n" +
            "Their vision, they miss 'em, won't impact, this is that\n" +
            "It's the bomb, ring the alarm, MJ number one (Aaow)\n" +
            "It goes on and on, it goes on and on (Ha)\n" +
            "We get to creeping and crawling in the early morn' (Haha)\n" +
            "Dream on, dreamer, there's nowhere to run\n" +
            "You can try but you're done\n" +
            "I can feel it in the air, here the monster come\n" +
            "\n" +
            "[Outro]\n" +
            "He's draggin' you down like a monster\n" +
            "He's keepin' you down like a monster\n" +
            "He's draggin' you down like a monster\n" +
            "He's keepin' you down like a monster";

    public static  ArrayList<Song> getSongs() {
        ArrayList<Song> songs = new ArrayList<>();
        Song song1 = new Song("Money", "Michael jackson", "m",money,"pop",1995,484123);
        Song song2 = new Song("Die with Smile", "Lady Gaga", "single",DieWithSmile,"pop",2024,234);
        Song song3 = new Song("My boy", "Taylor Swift", " The Tortured Poets Department",myboy,"pop",2024,25);
        Song song4 = new Song("Monster","Michael jackson","s",monster,"pop",1999,456789);

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);

        for (int i = 0; i < songs.size(); i++) {
            for (int j = i + 1; j < songs.size(); j++) {
                if (songs.get(i).getView() < songs.get(j).getView()) {
                    Song temp = songs.get(i);
                    songs.set(i, songs.get(j));
                    songs.set(j, temp);

                }
            }
        }
        return songs;
    }
    /*
    view met
     */

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}


