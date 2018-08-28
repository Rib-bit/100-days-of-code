package masterclass;
/*
challenge is: using the previous LinkedList challenge

    make the AlbumIPod class use an inner class
        instead of using an ArrayList to hold its tracks, it will use an inner class called SongList
            the inner SongList class will use an ArrayList and will provide a method to add a song
            it will also provide findSong() methods which the AlbumIPod class will then use to add songs to the playlist

    Change neither the SongIPod class nor the IPodMain class
        might have to change the IPod class, will try not to (my solution was a bit different from Tim's)

 */
import java.util.ArrayList;

public class AlbumIPod {
    private String name;
    private SongList songs; //initially named it songList, to avoid confusion, but you can work the confusion out of the code too

    public int getSongListSize() {
        return songs.getSongs().size();
    }

    public String getName() {
        return name;
    }

    public SongIPod getOneSong(int index) {
        if(songs.getSongs().isEmpty()) {
            System.out.println("Album " + this.getName() + " appears to be empty");
            return null;
        }
        return songs.getSongs().get(index);
    }

    public AlbumIPod(String name) {
        this.name = name;
        this.songs = new SongList();
    }

    public AlbumIPod makeAlbum(String albumName, AlbumIPod album) {

        for (int i = 1; i < 11; i++) {
            songs.addSong(i);
        }

        nameSongs(songs.songs, albumName);
        return album;
    }

    public SongIPod findSong (String songName) {
        return songs.findSong(songName);
    }

    /*public SongIPod findSong (int trackNumber) {
        return songs.findSong(trackNumber);
    }*/

    private void nameSongs(ArrayList<SongIPod> songs, String albumName) {

        for (int i = 0; i <songs.size() ; i++) {

            SongIPod toStamp = songs.get(i);
            String oldTitle = toStamp.getTitle();
            toStamp.setTitle(albumName + " - " + oldTitle);
        }

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ** Inner Class **
    private class SongList {
        private ArrayList<SongIPod> songs;

        public SongList() {
            this.songs = new ArrayList<SongIPod>();
        }

        public SongIPod addSong(int indexToString) {
            String songName = Integer.toString(indexToString);
            if(findSong(songName) == null) {
                SongIPod song = new SongIPod(songName);
                songs.add(song);
                return song;
            } else {
                System.out.println(songName + " already exists in album " + AlbumIPod.this.getName());
                return null;
            }
        }

        public SongIPod findSong(String songName) {

            for (int i = 0; i < songs.size(); i++) {

                SongIPod checkedSong = songs.get(i);
                if(checkedSong.getTitle().equals(songName)) {

                    return checkedSong;
                }
            }
            return null;
        }

        /*public SongIPod findSong(int trackNumber) {
            int index = trackNumber - 1;
            if((index >= 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }*/

        public ArrayList<SongIPod> getSongs() {
            return songs;
        }
    }
}
