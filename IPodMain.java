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

import java.util.Scanner;

public class IPodMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        IPod iPod = new IPod();

        iPod.makeAlbumFromIPod("a");
        iPod.makeAlbumFromIPod("b");
        iPod.makeAlbumFromIPod("c");

        iPod.addToList("a");
        iPod.addToList("c");
        iPod.addToList("e");

        iPod.addToList("b", "10");
        iPod.addToList("b", "b - 7");
        iPod.addToList("b", "3");
        iPod.addToList("d", "3");
        iPod.addToList("b", "13");

        iPod.playList();

    }
}
