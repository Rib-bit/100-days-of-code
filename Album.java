package masterclass;

import java.util.ArrayList;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

//    public static Song findSong(Song song) {
//        if() {
//            return foundSong;
//        } else {
//            return null;
//        }
//    }
}
