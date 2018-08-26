package masterclass;

public class PlaylistTest {

    public static void main(String[] args) {

        Walkman walkman = new Walkman();
        walkman.makeAlbumFromWalkman("a");
        walkman.makeAlbumFromWalkman("b");
        walkman.makeAlbumFromWalkman("c");

        walkman.addToList("a");
        walkman.addToList("b");
        walkman.addToList("d");
        walkman.addToList("c", "1");
        walkman.addToList("c", "6");
        walkman.addToList("c", "7");
        walkman.addToList("c", "12");
        walkman.addToList("b", "2");


        walkman.printPlaylist();
        walkman.playList();

    }
}
