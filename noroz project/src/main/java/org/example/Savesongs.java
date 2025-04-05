package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Savesongs {
    public static void Savesongs(ArrayList<Song> songs) {
        JSONObject allData = Read();

        if (songs.size() < 2) {

            JSONObject songsObj = allData.optJSONObject("Songs");
            if (songsObj == null) songsObj = new JSONObject();

            for (Song song : songs) {
                JSONObject songData = new JSONObject();
                songData.put("Song", song.getName());
                songData.put("Singer", song.getArtist());
                songData.put("Album", song.getAlbum());
                songData.put("Lyric", song.getLyric());
                songData.put("Genre", song.getGenre());
                songData.put("Release", song.getRelease());
                songData.put("View", song.getView());

                songsObj.put(song.getName(), songData);
            }

            allData.put("Songs", songsObj);

        } else {

            JSONObject albumsObj = allData.optJSONObject("Albums");
            if (albumsObj == null) albumsObj = new JSONObject();

            String albumName = songs.get(0).getAlbum();
            JSONArray albumSongs = new JSONArray();

            for (Song song : songs) {
                JSONObject songData = new JSONObject();
                songData.put("Song", song.getName());
                songData.put("Singer", song.getArtist());
                songData.put("Album", song.getAlbum());
                songData.put("Lyric", song.getLyric());
                songData.put("Genre", song.getGenre());
                songData.put("Release", song.getRelease());
                songData.put("View", song.getView());

                albumSongs.put(songData);
            }

            albumsObj.put(albumName, albumSongs);
            allData.put("Albums", albumsObj);
        }

        WriteSongs(allData);
    }

//    public static ArrayList;
    public static void WriteSongs(JSONObject songs) {
        try {
            FileWriter file = new FileWriter("songs&albums.json");
            file.write(songs.toString(4));
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static JSONObject Read() {
        JSONObject allData;
        try {
            String content = new String(Files.readAllBytes(Paths.get("songs&albums.json")));
            allData = new JSONObject(content);
        } catch (IOException e) {
            allData = new JSONObject();
        }
        return allData;
    }
    public static ArrayList<Song> getSongs(String artist,boolean isSong) {
        ArrayList<Song> songs = new ArrayList<>();
        JSONObject All = Read();
        JSONObject songsobj;
        if(isSong) {
        songsobj = All.optJSONObject("Songs");
        }
        else {
            songsobj = All.optJSONObject("Albums");
        }

        for (String songname : songsobj.keySet()) {
            JSONObject Songg = songsobj.getJSONObject(songname);
            for (String songName : Songg.keySet()) {
                JSONObject songData = Songg.getJSONObject(songName);

                if (songData.optString("Singer").equals(artist)) {

                    Song song = new Song(
                            songName,
                            songData.optString("Singer"),
                            songData.optString("Album"),
                            songData.optString("Lyric"),
                            songData.optString("Genre"),
                            songData.optString("Release"),
                            songData.optInt("View")
                    );
                    songs.add(song);
                }
            }
        }
    return songs;
}
}
