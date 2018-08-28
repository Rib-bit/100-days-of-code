package masterclass;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;
    //better than work with the shadowing (see below), you will want to reduce confusion and rename your field
    //for instance, 'private int currentGear = 0;' instead of 'private int gearNumber = 0;'


    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        Gear neutral = new Gear(0, 0.0); // we shall interact with Gear through Gearbox only. Encapsulation ahoy!
        this.gears.add(neutral);

        for (int i = 0; i < maxGears; i++) {
            addGear(i, i*5.3);
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    private void addGear(int number, double ratio) {
        if((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if((newGear >= 0) && (newGear < gears.size()) && (this.clutchIsIn)) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected");
        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        }

        return revs  * gears.get(currentGear).getRatio();
    }//we've typed the Gearbox class so that it could do all the work the Gear class was supposed to perform

    private class Gear { //Gear as an inner class because it is only useful when in the context of a Gearbox. Makes sense to make it private
        private int gearNumber; //however, we can then no longer instantiate gears from the main method. We need to use the Gearbox class
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        } //instances of the Gear class have access to all the methods and fields of the outer class Gearbox, even the private ones
    }//as for gearNumber, we have to distinguish between the two. If we want to access the outer one from an instance of Gear
    //we have to use Gearbox.this.gearNumber - where a variable or parameter name is the name one as that of the oouter class..
    // ... it is said to shadow the declaration in the outer class
}
