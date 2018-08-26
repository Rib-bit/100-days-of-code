package masterclass;

import java.util.*;

public class Walkman {

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    public Walkman() {
        this.albums = new ArrayList<Album>();
        this.playlist = new LinkedList<Song>();
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
                        if(listIterator.hasNext()) {
                            int songIndex = listIterator.previousIndex();
                            System.out.println("Deleted " + playlist.get(songIndex).getTitle());
                            onScreenPlayer(songIndex + 1);
                            listIterator.remove();
                            listIterator.next();
                        } else if (listIterator.hasPrevious()){
                            int songIndex = listIterator.nextIndex();
                            System.out.println("Deleted " + playlist.get(songIndex).getTitle());
                            onScreenPlayer(songIndex - 1);
                            listIterator.remove();
                            listIterator.previous();
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

    public void makeAlbumFromWalkman(String albumName){
        Album album = new Album(albumName);
        this.albums.add(album.makeAlbum(albumName, album));
    }

    public void printPlaylist() {
        int size = getPlaylist().size();
        System.out.println(size + " songs in current playlist");
        if(size > 0) {
            int j = 0;
            Iterator<Song> i = playlist.iterator();
            while(i.hasNext()) {
                System.out.println("[" + (++j) + "] " + i.next().getTitle());
            }
        }
    }

    private void onScreenPlayer(int songIndex) {
        Song playingSong = playlist.get(songIndex);
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

    private Song findSong(String albumName, String songName) {
        Album checkedAlbum = findAlbum(albumName);

        if(checkedAlbum != null) {
            Song checkedSong = checkedAlbum.findSong(songName);

            if(checkedSong != null) {
                return checkedSong;
            }
            System.out.println(songName + ": No such song in any owned album");
            return null;
        }
        System.out.println(albumName + "No such album in library");
        return null;
    }

    private Song findSongInList(String songName) {

        for (int i = 0; i < this.playlist.size(); i++) {

            Song checkedSong = this.playlist.get(i);
            if(checkedSong.getTitle().equals(songName)) {
                return checkedSong;
            }
        }
        return null;
    }

    private Album findAlbum(String albumName) {
        for (int i = 0; i < this.albums.size(); i++) {

            Album checkedAlbum = this.albums.get(i);
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

        Song foundSong = findSong(albumName, songName);
        Song existingSong = findSongInList(songName);

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
        Album foundAlbum = findAlbum(albumName);

        if(foundAlbum!=null) {
            for (int i = 0; i < foundAlbum.getSongs().size(); i++) {
                String foundSongTitle = foundAlbum.getOneSong(i).getTitle();
                addToList(albumName, foundSongTitle);
            }
        } else {
            System.out.println("You do not own album " + albumName + " yet");
        }
    }
}
