package masterclass;

public class Drawer {
    private String cables;
    private int boards;
    private String misc;

    public void searchDrawer(String query) {
        System.out.println("There are " + cables + " cables in there, but you can't find the " + query + " you're looking for!");
    }

    public Drawer() {
        this("many", 14, "a bunch of miscellaneous objects related to IT in some fashion");
    }

    public Drawer(String cables, int boards, String misc) {
        this.cables = cables;
        this.boards = boards;
        this.misc = misc;
    }

    public String getCables() {
        return cables;
    }

    public int getBoards() {
        return boards;
    }

    public String getMisc() {
        return misc;
    }
}
