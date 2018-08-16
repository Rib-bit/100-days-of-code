package masterclass;
//Example of class without encapsulation
public class Player {
    public String name; //we normally use 'private'
    public int health;
    public String wieldedWeapon; //changing anything forces us to change things in other classes

    public void loseHealth(int damage) {
        this.health -= damage;
        if(this.health<=0) {
            System.out.println("Player knocked out");
            //Reduce number of lives remaining to the player
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}