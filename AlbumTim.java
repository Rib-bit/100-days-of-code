package masterclass;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlbumTim {
    private String name;
    private String artist;
    private SongListTim songs;

    public AlbumTim(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongListTim();
    }

    public boolean addSong(String title, double duration){
            return this.songs.add(new SongTim(title, duration));
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<SongTim> playlist) {
        SongTim checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong!=null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<SongTim> playlist) {
        SongTim checkedSong = this.songs.findSong(title);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
    /////////////////////////////////////////:
    //  ** Inner Class **
    private class SongListTim {
        private ArrayList<SongTim> songs;

        public SongListTim() {
            this.songs = new ArrayList<SongTim>();
        }

        public boolean add(SongTim song) {
            if(songs.contains(song)){ //keep the contains(object) method in mind
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private SongTim findSong(String title) {
            for(SongTim checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        public SongTim findSong(int trackNumber){
            int index = trackNumber - 1;
            if((index >= 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }

}
