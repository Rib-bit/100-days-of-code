package masterclass;

public class Table {
    private int legs;
    private boolean extended;

    public void shapeTable() {
        if(extended) {
            System.out.println("You painstakingly fold the table.");
            extended = false;
        } else {
            System.out.println("The table is effortlessly extended.");
            extended = true;
        }
    }

    public Table() {
        this(4, false);
    }

    public Table(int legs, boolean extended) {
        this.legs = legs;
        this.extended = extended;
    }

    public int getLegs() {
        return legs;
    }

    public boolean isExtended() {
        return extended;
    }
}
