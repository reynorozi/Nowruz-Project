package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaveData {

    // Main method to save songs either as single tracks or as part of an album
    public static void Savesongs(ArrayList<Song> songs) {
        JSONObject allData = Read();  // Read data from the JSON file

        // Check if the songs are individual or part of an album
        if (songs.size() < 2) {
            saveSingleSongs(allData, songs);  // Save individual songs
        } else {
            saveAlbumSongs(allData, songs);  // Save songs as part of an album
        }

        WriteSongs(allData);  // Write updated data back to the JSON file
    }

    // Save individual songs to the "Songs" section
    private static void saveSingleSongs(JSONObject allData, ArrayList<Song> songs) {
        JSONObject songsObj = allData.optJSONObject("Songs");
        if (songsObj == null) songsObj = new JSONObject();  // Create a new JSONObject if not found

        // Loop through each song and add it to the "Songs" section
        for (Song song : songs) {
            songsObj.put(song.getName(), songToJson(song));  // Convert song to JSON format and add to the object
        }

        allData.put("Songs", songsObj);  // Add the updated songs object to the overall data
    }

    // Save songs as part of an album to the "Albums" section
    private static void saveAlbumSongs(JSONObject allData, ArrayList<Song> songs) {
        JSONObject albumsObj = allData.optJSONObject("Albums");
        if (albumsObj == null) albumsObj = new JSONObject();  // Create a new JSONObject if not found

        String albumName = songs.get(0).getAlbum();  // Get the album name from the first song
        JSONArray albumSongs = new JSONArray();  // Create a new JSONArray to store the songs of the album

        // Loop through each song in the album and convert to JSON format
        for (Song song : songs) {
            albumSongs.put(songToJson(song));  // Convert song to JSON format and add to the array
        }

        albumsObj.put(albumName, albumSongs);  // Add the album songs to the albums object
        allData.put("Albums", albumsObj);  // Add the updated albums object to the overall data
    }

    // Convert a Song object to JSON format
    private static JSONObject songToJson(Song song) {
        JSONObject songData = new JSONObject();
        songData.put("Song", song.getName());
        songData.put("Singer", song.getArtist());
        songData.put("Album", song.getAlbum());
        songData.put("Lyric", song.getLyric());
        songData.put("Genre", song.getGenre());
        songData.put("Release", song.getRelease());
        songData.put("View", song.getView());
        return songData;  // Return the JSON object representing the song
    }

    // Write the updated song data to the JSON file
    public static void WriteSongs(JSONObject songs) {
        try (FileWriter file = new FileWriter("songs&albums.json")) {
            file.write(songs.toString(4));  // Write data with indentation for readability
        } catch (Exception e) {
            e.printStackTrace();  // Print any errors that occur
        }
    }

    // Read song and album data from the JSON file
    public static JSONObject Read() {
        try {
            String content = new String(Files.readAllBytes(Paths.get("songs&albums.json")));
            return new JSONObject(content);  // Return the JSON object read from the file
        } catch (IOException e) {
            return new JSONObject();  // Return an empty JSONObject if there was an error reading the file
        }
    }

    // Get all songs by a specific artist
    public static ArrayList<Song> getSongs(String artist) {
        ArrayList<Song> songs = new ArrayList<>();
        JSONObject allData = Read();  // Read data from the file
        JSONObject songsObj = allData.optJSONObject("Songs");

        if (songsObj != null) {
            // Loop through each song and check if the artist matches
            for (String songName : songsObj.keySet()) {
                JSONObject songData = songsObj.optJSONObject(songName);
                if (songData != null && artist.equals(songData.optString("Singer"))) {
                    songs.add(jsonToSong(songName, songData));  // Add matching song to the list
                }
            }
        }
        return songs;  // Return the list of songs by the artist
    }

    // Edit the lyrics of a song (either single or album song)
    public static void saveeditlyric(Song song, String lyric) {
        JSONObject allData = Read();  // Read data from the file

        // Check if the song is a single or part of an album and update the lyrics accordingly
        if (song.getAlbum().equals("Single")) {
            JSONObject songsObj = allData.optJSONObject("Songs");
            if (songsObj != null && songsObj.has(song.getName())) {
                songsObj.getJSONObject(song.getName()).put("Lyric", lyric);
            }
        } else {
            JSONObject albumsObj = allData.optJSONObject("Albums");
            if (albumsObj != null && albumsObj.has(song.getAlbum())) {
                JSONArray album = albumsObj.getJSONArray(song.getAlbum());
                for (int j = 0; j < album.length(); j++) {
                    JSONObject albumSong = album.getJSONObject(j);
                    if (song.getName().equals(albumSong.optString("Song"))) {
                        albumSong.put("Lyric", lyric);  // Update the lyric for the song in the album
                        break;
                    }
                }
            }
        }

        WriteSongs(allData);  // Write the updated data back to the file
    }

    // Increase the view count of a song (either single or album song)
    public static void increaseView(Song song) {
        JSONObject allData = Read();  // Read data from the file

        // Check if the song is a single or part of an album and update the view count accordingly
        if (song.getAlbum().equals("Single")) {
            JSONObject songsObj = allData.optJSONObject("Songs");
            if (songsObj != null && songsObj.has(song.getName())) {
                JSONObject songData = songsObj.getJSONObject(song.getName());
                songData.put("View", songData.getInt("View") + 1);  // Increment the view count by 1
            }
        } else {
            JSONObject albumsObj = allData.optJSONObject("Albums");
            if (albumsObj != null && albumsObj.has(song.getAlbum())) {
                JSONArray albumSongs = albumsObj.getJSONArray(song.getAlbum());
                for (int i = 0; i < albumSongs.length(); i++) {
                    JSONObject songObj = albumSongs.getJSONObject(i);
                    if (song.getName().equals(songObj.optString("Song"))) {
                        songObj.put("View", songObj.getInt("View") + 1);  // Increment the view count by 1
                        break;
                    }
                }
            }
        }

        WriteSongs(allData);  // Write the updated data back to the file
    }

    // Get all songs (both singles and albums)
    public static ArrayList<Song> Allsongs() {
        ArrayList<Song> songs = new ArrayList<>();
        JSONObject allData = Read();  // Read data from the file

        // Get all single songs
        JSONObject songsObj = allData.optJSONObject("Songs");
        if (songsObj != null) {
            for (String songName : songsObj.keySet()) {
                JSONObject songJson = songsObj.optJSONObject(songName);
                if (songJson != null) {
                    songs.add(jsonToSong(songName, songJson));  // Add each song to the list
                }
            }
        }

        // Get all album songs
        JSONObject albumsObj = allData.optJSONObject("Albums");
        if (albumsObj != null) {
            for (String albumName : albumsObj.keySet()) {
                JSONArray albumSongs = albumsObj.optJSONArray(albumName);
                if (albumSongs != null) {
                    for (int j = 0; j < albumSongs.length(); j++) {
                        JSONObject songJson = albumSongs.optJSONObject(j);
                        if (songJson != null) {
                            songs.add(jsonToSong(songJson.optString("Song"), songJson));  // Add each song to the list
                        }
                    }
                }
            }
        }

        return songs;  // Return the list of all songs
    }

    // Convert JSON object to Song object
    static Song jsonToSong(String songName, JSONObject json) {
        return new Song(
                songName,
                json.optString("Singer", ""),
                json.optString("Album", ""),
                json.optString("Lyric", ""),
                json.optString("Genre", ""),
                json.optString("Release", ""),
                json.optInt("View", 0)
        );  // Create and return a Song object from the JSON data
    }

    // Get all albums by a specific artist
    public static ArrayList<Album> getAlbum(String artist) {
        ArrayList<Album> Albumss = new ArrayList<>();
        JSONObject All = Read();  // Read data from the file
        JSONObject Albumobj = All.optJSONObject("Albums");

        // Loop through each album and check if the artist matches
        for (String Albumname : Albumobj.keySet()) {

            JSONArray Songsarray = Albumobj.getJSONArray(Albumname);
            ArrayList<Song> songs = new ArrayList<>();

            // Loop through each song in the album and check if the artist matches
            for (int i = 0; i < Songsarray.length(); i++) {

                JSONObject songobj = Songsarray.getJSONObject(i);
                String singer = songobj.optString("Singer");

                if (singer.equals(artist)) {

                    Song song = new Song(
                            songobj.optString("Song"),
                            artist,
                            songobj.optString("Album"),
                            songobj.optString("Lyric"),
                            songobj.optString("Genre"),
                            songobj.optString("Release"),
                            songobj.optInt("View")
                    );
                    songs.add(song);  // Add the song to the album's list
                }
            }
            if (!songs.isEmpty()) {
                Albumss.add(new Album(Albumname, songs));  // Add the album with its songs to the list
            }
        }
        return Albumss;  // Return the list of albums by the artist
    }

    // Save the artist follow by a user to Data.json using the File class
    public static void saveFollow(User user, Artist artist) {
        try {
            String jsonData = File.ReadData();  // Read the existing data from the file
            JSONObject root = new JSONObject(jsonData);
            org.json.JSONArray accounts = root.optJSONArray("Accounts");

            if (accounts == null) return;

            // Loop through each account to find the user and artist
            for (int i = 0; i < accounts.length(); i++) {
                JSONObject account = accounts.getJSONObject(i);
                String role = account.optString("Role");

                // Update user: add followed artist
                if (role.equals("User") && account.optString("Username").equals(user.getUsername())) {
                    org.json.JSONArray followingArtists = account.optJSONArray("FollowingArtists");
                    if (followingArtists == null) followingArtists = new org.json.JSONArray();

                    if (!followingArtists.toList().contains(artist.getName())) {
                        followingArtists.put(artist.getName());  // Add the artist to the list of followed artists
                        account.put("FollowingArtists", followingArtists);
                    }
                }

                // Update artist: add follower
                if (role.equals("Artist") && account.optString("Username").equals(artist.getUsername())) {
                    org.json.JSONArray followers = account.optJSONArray("Followers");
                    if (followers == null) followers = new org.json.JSONArray();

                    if (!followers.toList().contains(user.getUsername())) {
                        followers.put(user.getUsername());  // Add the user to the list of followers
                        account.put("Followers", followers);
                    }
                }
            }

            // Write the updated data back to the file
            JSONObject updatedRoot = new JSONObject();
            updatedRoot.put("Accounts", accounts);
            File.WriteData(updatedRoot);

        } catch (Exception e) {
            e.printStackTrace();  // Print any errors that occur
        }
    }

    // Get the number of followers for a specific artist
    public static int getArtistFollowersCount(String artistUsername) {
        String data = File.ReadData();  // Read the data from the file
        JSONObject jsonData = new JSONObject(data);
        org.json.JSONArray accounts = jsonData.getJSONArray("Accounts");

        // Loop through each account to find the artist and count their followers
        for (int i = 0; i < accounts.length(); i++) {
            JSONObject account = accounts.getJSONObject(i);
            if (account.optString("Username").equals(artistUsername)) {

                org.json.JSONArray followers = account.optJSONArray("Followers");
                return followers != null ? followers.length() : 0;  // Return the number of followers
            }
        }

        return 0;  // Return 0 if no followers are found
    }
}
