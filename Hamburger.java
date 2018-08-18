/*
Bill's Burgers
designed to help Bill select type of burger, additions, and pricing
base hamburger (bread roll type, meat, up to 4 additions (lettuce, tomato, pickle, cheddar...))
Constructor will only include roll type, meat, and price, and name of burger
additions will be charged, we need to track each one. Final price is base price + additions
	Healthy burger (brown rye roll only, up to 6 additions (jalapeno, grilled tofu...))
		process the extra 2 in the subclass
	Deluxe burger (same as base, but comes with chips and a drink, and no additions. Menu.)
		automatically add chips and drink,
All 3 should have a method to display the name, the base price,
	all additions and their prices, and the total (args should be adds)
*/
package masterclass;

public class Hamburger {
    private String roll; //I was tempted to make a Roll class after the fact, to use that lesson as well, but decided against it because of all the refactoring that would be needed
    private boolean hasMeat;//... and it didn't seem useful. Might come back to this.
    private double basePrice = 6.89;
    private String name = "Big Bill's";

    private boolean hasLettuce;//Instructor sticks to not including additions to constructor
    private boolean hasTomato;//I have yet to see how clunky or not the constructing is, doing it that way
    private boolean hasPickles;//[later on] yup, looks pretty clunky, idk.. Am I relying on constructors to do all my work? Would that even be bad?
    private boolean hasCheddar;

    public void whatIn() {
        System.out.print("As you requested, your burger contained: " + getRoll() + ", " + hasMeat() + " patties, ");
        System.out.println(hasLettuce() + ", " + hasTomato() + ", " + hasPickles() + ", and " + hasCheddar());
    }

    public void check() {
        System.out.println(getName() + ": $" + getBasePrice());

        double total = getBasePrice() + checkAdds();

        System.out.println("Total: $" + total + "\n" + "Thank you for visiting us at Bill's Burgers!");
    }

    public double checkAdds(){
        double totalAdds = 0;
        double addVeg = 0.2;
        double addCheese = 0.5;
        if(this.hasLettuce) {
            totalAdds += addVeg;
            System.out.println("+ Lettuce: $" + addVeg);
        }
        if(this.hasTomato) {
            totalAdds += addVeg;
            System.out.println("+ Tomato: $" + addVeg);
        }
        if(this.hasPickles) {
            totalAdds += addVeg;
            System.out.println("+ Pickles: $" + addVeg);
        }
        if (this.hasCheddar) {
            totalAdds += addCheese;
            System.out.println("+ Cheddar: $" + addCheese);
        }
        return totalAdds;
    }

    public Hamburger(boolean hasLettuce, boolean hasTomato, boolean hasPickles, boolean hasCheddar) {
        this("white bread", true, hasLettuce, hasTomato, hasPickles, hasCheddar);
    }

    public Hamburger(String roll, boolean hasMeat, boolean hasLettuce, boolean hasTomato, boolean hasPickles, boolean hasCheddar) {
        this.roll = roll + " roll";
        this.hasMeat = hasMeat;
        this.hasLettuce = hasLettuce;
        this.hasTomato = hasTomato;
        this.hasPickles = hasPickles;
        this.hasCheddar = hasCheddar;
    }

    public String getRoll() {
        return roll;
    }

    public String hasMeat() {
        if(hasMeat) {
            return "some meat";
        } else {
            return "no meat";
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public String hasLettuce() {
        if(hasLettuce){
            return "extra lettuce";
        } else {
            return "no lettuce";
        }
    }

    public String hasTomato() {
        if(hasTomato){
            return "extra tomato";
        } else {
            return "no tomato";
        }
    }

    public String hasPickles() {
        if(hasPickles){
            return "extra pickles";
        } else {
            return "no pickles";
        }
    }

    public String hasCheddar() {
        if(hasCheddar){
            return "extra cheddar";
        } else {
            return "no cheddar";
        }
    }
}
