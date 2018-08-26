package masterclass;

import java.util.*;

public class WalkmanTim {

    private static ArrayList<AlbumTim> albums = new ArrayList<AlbumTim>();

    public static void main(String[] args) {
        AlbumTim album = new AlbumTim("Stormbringer", "Deep purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't Mean a Thing", 4.22);
        album.addSong("Holy Man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady Double Dealer", 3.21);
        album.addSong("You can't Do It Right", 6.23);
        album.addSong("High Ball Shooter", 4.27);
        album.addSong("The Gypsy", 4.2);
        album.addSong("Soldier of Fortune", 3.13);
        albums.add(album);

        album = new AlbumTim("For Those about to Rock", "AC/DC");
        album.addSong("For Those about to Rock", 4.6);
        album.addSong("I Put the Finger on You", 4.22);
        album.addSong("Let's Go", 4.3);
        album.addSong("Inject the Venom", 5.6);
        album.addSong("Snowballed", 3.21);
        album.addSong("Evil Walks", 6.23);
        album.addSong("C.O.D.", 4.27);
        album.addSong("Breaking the Rules", 4.2);
        album.addSong("Night of the Long Knives", 3.13);
        albums.add(album);

        LinkedList<SongTim> playlist = new LinkedList<SongTim>();
        albums.get(0).addToPlaylist("You can't Do It Right", playlist);
        albums.get(0).addToPlaylist("Holy Man", playlist);
        albums.get(0).addToPlaylist("Speed King", playlist);//does not exist
        albums.get(0).addToPlaylist(9, playlist);

        albums.get(1).addToPlaylist(8, playlist);
        albums.get(1).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(24, playlist); //does not exist

        play(playlist);
        }

        private static void play(LinkedList<SongTim> playlist) {

            Scanner scanner = new Scanner(System.in);
            boolean quit = false;
            boolean forward = true;

            ListIterator<SongTim> listIterator = playlist.listIterator();
            if(playlist.size() ==  0) {
                System.out.println("No songs in playlist");
                return;
            } else {
                printMenu();
                System.out.println("Now playing " + listIterator.next().toString()); //the overridden toString method
            }//without the overridden toString(), we get masterclass.SongTim@6a56fe meant to represent the memory location of the object

            while(!quit) {
                int action = scanner.nextInt();
                scanner.nextLine();

                switch(action) {
                    case 0:
                        System.out.println("Playlist done");
                        quit = true;
                        break;
                    case 1:
                        if(!forward) {
                            if(listIterator.hasNext()) {
                                listIterator.next();
                            }
                            forward = true;
                        }
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next().toString());
                        } else {
                            System.out.println("We have reached the end of the playlist");
                            forward = false;
                        }
                        break;
                    case 2:
                        if(forward) {
                            if(listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            forward = false;
                        }
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                        } else {
                            System.out.println("We are at the start of the list");
                            forward = true;
                        }
                        break;
                    case 3:
                        if(forward) {
                            if(listIterator.hasPrevious()){
                                System.out.println("Now replaying " + listIterator.previous().toString());
                                forward = false;
                            } else {
                                System.out.println("We are at the start of the list");
                            }
                        } else {
                            if(listIterator.hasNext()){
                                System.out.println("Now replaying " + listIterator.next().toString());
                                forward = true;
                            } else {
                                System.out.println("We have reached the end of the playlist");
                            }
                        }
                        break;
                    case 4:
                        printList(playlist);
                        break;
                    case 5:
                        printMenu();
                        break;
                    case 6 :
                        if(playlist.size() > 2) {
                            listIterator.remove();
                            if(listIterator.hasNext()) {
                                System.out.println("Now playing " + listIterator.next());
                            } else if(listIterator.hasPrevious()) {
                                System.out.println("Now playing " + listIterator.previous());
                            }
                        } else {
                            System.out.println("Not enough songs to delete another one. " +
                                    "To delete the playlist, go to main menu");
                        }
                        break;
                }
            }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list songs in the playlist\n" +
                "5 - to print available actions\n" +
                "6 - to delete current song from playlist.");
    }

    private static void printList(LinkedList<SongTim> playlist) {
        Iterator<SongTim> iterator = playlist.iterator(); //no need for a list iterator, flexibility. we just need to loop through once
        System.out.println("=====================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=====================================");
    }



















}
