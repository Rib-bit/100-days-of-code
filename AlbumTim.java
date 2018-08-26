package masterclass;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlbumTim {
    private String name;
    private String artist;
    private ArrayList<SongTim> songs;

    public AlbumTim(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<SongTim>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null) {
            this.songs.add(new SongTim(title, duration));
            return true;
        }
        return false;
    }

    private SongTim findSong(String title) {
        for(SongTim checkedSong: this.songs) { //for each command. Goes through this.songs, creates a variable called checkedSong for every entry in our ArrayList
            if(checkedSong.getTitle().equals(title)) {//checkedSong is a temp var that holds each element of the ...
                // ... array in succession, and we can perform a comparison between that var and our args
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<SongTim> playlist) {
        int index = trackNumber - 1;
        if((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<SongTim> playlist) {
        SongTim checkedSong = findSong(title);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

}
