package masterclass;

import java.util.*;

public class IPod {

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<AlbumIPod> albums;
    private LinkedList<SongIPod> playlist;

    public ArrayList<AlbumIPod> getAlbums() {
        return albums;
    }

    public LinkedList<SongIPod> getPlaylist() {
        return playlist;
    }

    public IPod() {
        this.albums = new ArrayList<AlbumIPod>();
        this.playlist = new LinkedList<SongIPod>();
    }

    public void playList() {

        boolean quit = false;
        boolean goingForward = true;

        ListIterator listIterator = this.playlist.listIterator();

        if(this.playlist.size()<2) {
            System.out.println("Playlist is currently empty or too small");
            return;
        } else {
            printMenu();
            int songIndex = listIterator.nextIndex();
            onScreenPlayer(songIndex);
            listIterator.next();
        }


        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0://quit
                    System.out.println("Turning off...");
                    quit = true;
                    break;
                case 1://skip forward
                    if(!goingForward){
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        int songIndex = listIterator.nextIndex();
                        onScreenPlayer(songIndex);
                        listIterator.next();
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2://skip backward
                    if(goingForward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        int songIndex = listIterator.previousIndex();
                        onScreenPlayer(songIndex);
                        listIterator.previous();
                    } else {
                        System.out.println("Reached the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3://replay
                    if(goingForward){
                        goingForward = false;
                        int songIndex = listIterator.previousIndex();
                        System.out.print("Replaying - ");
                        onScreenPlayer(songIndex);
                        listIterator.previous();
                    } else {
                        goingForward = true;
                        int songIndex = listIterator.nextIndex();
                        System.out.print("Replaying - ");
                        onScreenPlayer(songIndex);
                        listIterator.next();
                    }
                    break;
                case 4://print list songs
                    printPlaylist();
                    break;
                case 9://delete song
                    if(playlist.size() > 2) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    } else {
                        System.out.println("Not enough songs to delete another one. " +
                                "To delete the playlist, go to main menu");
                    }
                    break;
                default://print menu
                    printMenu();
                    break;
            }
        }
    }

    public void makeAlbumFromIPod(String albumName){
        AlbumIPod album = new AlbumIPod(albumName);
        this.albums.add(album.makeAlbum(albumName, album));
    }

    public void printPlaylist() {
        int size = getPlaylist().size();
        System.out.println(size + " songs in current playlist");
        if(size > 0) {
            int j = 0;
            Iterator<SongIPod> i = playlist.iterator();
            while(i.hasNext()) {
                System.out.println("[" + (++j) + "] " + i.next().getTitle());
            }
        }
    }

    private void onScreenPlayer(int songIndex) {
        SongIPod playingSong = playlist.get(songIndex);
        int songDuration = (int) playingSong.getDuration();
        System.out.println("Now listening to " + playingSong.getTitle() + "\n * " + songDuration + "s");
    }

    private void printMenu() {
        System.out.println("Personal playlist now playing\npress:");
        System.out.println("0 - to quit\n" +
                "1 - to skip forward\n" +
                "2 - to skip backward\n" +
                "3 - to replay\n" +
                "4 - to display the playlist\n" +
                "9 - to delete this song\n" +
                "any other number to print this menu again");
    }

    private SongIPod findSong(String albumName, String songName) {
        AlbumIPod checkedAlbum = findAlbum(albumName);

        if(checkedAlbum != null) {
            SongIPod checkedSong = checkedAlbum.findSong(songName);

            if(checkedSong != null) {
                return checkedSong;
            }
            System.out.println(songName + ": no such song in any owned album");
            return null;
        }
        System.out.println(albumName + ": no such album in library");
        return null;
    }

    private SongIPod findSongInList(String songName) {

        for (int i = 0; i < this.playlist.size(); i++) {

            SongIPod checkedSong = this.playlist.get(i);
            if(checkedSong.getTitle().equals(songName)) {
                return checkedSong;
            }
        }
        return null;
    }

    private AlbumIPod findAlbum(String albumName) {
        for (int i = 0; i < this.albums.size(); i++) {

            AlbumIPod checkedAlbum = this.albums.get(i);
            if(checkedAlbum.getName().equals(albumName)) {

                return checkedAlbum;
            }
        }
        return null;
    }

    public void addToList(String albumName, String songName) {

        if(songName.matches("[0-9]+")){
            songName = albumName + " - " + songName;
        }

        SongIPod foundSong = findSong(albumName, songName);
        SongIPod existingSong = findSongInList(songName);

        if((foundSong!=null) && (existingSong==null)) {
            System.out.println(songName + " successfully added to playlist");
            playlist.add(foundSong);
        } else if(existingSong!=null) {
            System.out.println("No need to add " + songName + " again");
        } else {
            System.out.println("You do not own song " + songName + " yet");
        }
    }

    public void addToList(String albumName) {
        AlbumIPod foundAlbum = findAlbum(albumName);

        if(foundAlbum!=null) {
            for (int i = 0; i < foundAlbum.getSongListSize(); i++) {
                String foundSongTitle = foundAlbum.getOneSong(i).getTitle();
                addToList(albumName, foundSongTitle);
            }
        } else {
            System.out.println("You do not own album " + albumName + " yet");
        }
    }
}
