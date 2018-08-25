package masterclass;

import java.util.*;

public class LinkedListChallengeDraft {

    public static void main(String[] args) {

        makeAlbum("a");
        makeAlbum("b");
        makeAlbum("c");

        LinkedList<Song> playlist = new LinkedList<Song>();
//        playlist.add(addToList("a"));
//        playlist.add(addToList("b"));
//        playlist.add(addToList("c", "5"));
//        playlist.add(addToList("c", "9"));
//        playlist.add(addToList("c", "12"));



    }

//    public static Song addToList(String albumName, String songName) {
//        //if(findSong!=null) {}
//
//        return playlist;
//   }

//    public static Song addToList(String albumName) {
//      if(findSong!=null) {}
//
//        return playlist;
//    }

//    public static Album findAlbum(Album album) {
//      Album foundAlbum = new Album(
//
//      if() {
//          return foundAlbum;
//      } else {
//          return null;
//      }
//    }

//    public static Song findSong(Album album, Song song) {
//      if() {
//          return foundSong;
//      } else {
//          return null;
//      }
//    }

    public static void playList(LinkedList playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = playlist.listIterator();

        if(playlist.isEmpty()) {
            System.out.println("Playlist is currently empty");
            return;
        } else {
            System.out.println("Now listening to " + listIterator.next());
        }

        printMenu();

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
                        System.out.println("Now listening to " + listIterator.next());
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
                        System.out.println("Now listening to " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3://replay
                    if(goingForward){
                        goingForward = false;
                        System.out.println("Now replaying " + listIterator.previous());
                    } else {
                        goingForward = true;
                        System.out.println("Now replaying " + listIterator.next());
                    }
                    break;
                case 4://print list songs
                    printPlaylist(playlist);
                    break;
                case 9://delete song
                    listIterator.remove();
                    break;
                default://print menu
                    printMenu();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Personnal playlist now playing\npress:");
        System.out.println("0 - to quit\n" +
                "1 - to skip forward\n" +
                "2 - to skip backward\n" +
                "3 - to replay\n" +
                "4 - to display the playlist\n" +
                "9 - to delete this song\n" +
                "any other number to print this menu again");
    }

    public static void makeAlbum(String albumName){
        Album album = new Album(albumName);
        ArrayList<Song> songs = album.getSongs();

        for (int i = 0; i < 14; i++) {
            String songName = Integer.toString(i);
            Song song = new Song(songName, (Math.random() * 7));
            songs.add(song);
        }
    }

    private static void printPlaylist(LinkedList<String> linkedList) {
        int j = 1;
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println("[" + j + "] " + i.next());
            j++;
        }
    }
}
