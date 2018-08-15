package masterclass;

public class LivingRoom extends Room {
    private Table table;
    private Drawer messDrawer;
    private Plant george;
    private PC schnabelfear;

    public LivingRoom(int walls, boolean ceiling, String floor, int doors, Table table, Drawer messDrawer, Plant george, PC schnabelfear) {
        super(walls, ceiling, floor, doors);
        this.table = table;
        this.messDrawer = messDrawer;
        this.george = george;
        this.schnabelfear = schnabelfear;
    }

    public void doRandomStuff(){
        messDrawer.searchDrawer("LAN cable");
        System.out.println("Still not tomorrow. What now?");
        george.waterPlant();
        System.out.println("Hmm. Back to it I suppose...");
        schnabelfear.codeCodeCode(4.5);
        cook();
    }

    public Table getTable() {
        return table;
    }

    @Override
    public void walkAround() {
        super.walkAround();
        System.out.println("The floor is cool under your feet.");
    }

    private void cook() {
        System.out.println("Your stomach grumbles. You start chopping and slicing, with no regard for Tim's lessons for a few minutes.");
    }

    public Drawer getMessDrawer() {
        return messDrawer;
    }

    public Plant getGeorge() {
        return george;
    }

    public PC getSchnabelfear() {
        return schnabelfear;
    }
}
