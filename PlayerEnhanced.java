package masterclass;
//Example of a class with encapsulation. Keep things where they ought to be etc.
public class PlayerEnhanced {
    private String name;
    private int hitPoints = 100; // we define a default value
    private String weapon; //select, double click, refactor, rename : cool stuff! a local change does not affect other classes

    public PlayerEnhanced(String name, int health, String weapon) {
        this.name = name;

        if ((health>0) && (health<=100)) { //implementing validation within the class. We could do more
            this.hitPoints = health;
        }

        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitPoints -= damage;
        if(this.hitPoints <=0) {
            System.out.println("Player knocked out");
            //Reduce number of lives remaining to the player
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return hitPoints;
    }

    public String getWeapon() {
        return weapon;
    }
}