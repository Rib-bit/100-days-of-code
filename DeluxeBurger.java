//if we were using a sort of setter, instead of using our constructors, we could override those setters here to make sure
//no further itemisation could be attempted.

package masterclass;

public class DeluxeBurger extends Hamburger{

    private double basePrice = 8.39;
    private String name = "Deluxe Jim's";

    private boolean hasDrink;
    private boolean hasChips;

    public DeluxeBurger() {
        this("white bread", true);
    }

    public DeluxeBurger(String roll, boolean hasMeat) {
        super(roll, hasMeat, false, false, false, false);
        this.hasDrink = true;
        this.hasChips = true;
    }

    @Override
    public void whatIn() {
        super.whatIn();
        System.out.println("... " + hasChips() + " " + hasDrink());
    }

    @Override
    public void check() {
        super.check();
    }

    @Override
    public double checkAdds() {
        double menu = super.checkAdds();
        double addChips = 1.5;
        double addDrink = 2;
        if(this.hasChips) {
            menu += addChips;
            System.out.println("+ Homemade chips: $" + addChips);
        }
        if(this.hasDrink) {
            menu += addDrink;
            System.out.println("+ Soft drink: $" + addDrink);
        }
        return menu;
    }

    public String hasDrink() {
        if(hasDrink) {
            return "and a drink of your choosing";
        } else {
            return "ERROR";
        }
    }

    public String hasChips() {
        if(hasChips) {
            return "with chips";
        } else {
            return "ERROR";
        }
    }

    @Override
    public double getBasePrice() {

        return basePrice;
    }

    @Override
    public String getName() {
        return name;
    }
}
