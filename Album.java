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

    public Song getOneSong(int index) {
        if(songs.isEmpty()) {
            System.out.println("Album " + this.getName() + " appears to be empty");
            return null;
        }
        return songs.get(index);
    }

    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }

    public Album makeAlbum(String albumName, Album album) {

        for (int i = 1; i < 11; i++) {

            String songName = Integer.toString(i);
            if(findSong(songName) == null) {

                Song song = new Song(songName);
                songs.add(song);
            } else {
                System.out.println(songName + " already exists in album " + albumName);
            }
        }
        nameSongs(songs, albumName);
        return album;
    }

    public Song findSong(String songName) {

        for (int i = 0; i < songs.size(); i++) {

            Song checkedSong = songs.get(i);
            if(checkedSong.getTitle().equals(songName)) {

                return checkedSong;
            }
        }
        return null;
    }

    private void nameSongs(ArrayList<Song> songs, String albumName) {

        for (int i = 0; i <songs.size() ; i++) {

            Song toStamp = songs.get(i);
            String oldTitle = toStamp.getTitle();
            toStamp.setTitle(albumName + " - " + oldTitle);
        }
    }
}
