
//Encapsulation
//mechanism that allows us to restrict access to certain components in the objects we create.
//Gives more control, enables us to change things locally without breaking something elsewhere

package masterclass;

public class TestsEncapsulation {

    public static void main(String[] args) {

        Player player = new Player();
        player.name = "Tim"; //remember, we set those fields as public
        player.health = 20;
        player.wieldedWeapon = "Sword";

        int damage = 11;
        player.health = 200;//we take control over that class' state from another class.
        player.loseHealth(damage);//we may want to control that process, with a constructor and private fields for example. That also ensures all is set and valid
        System.out.println("Remaining health = " + player.healthRemaining());

        System.out.println("******************");

        PlayerEnhanced playerHero = new PlayerEnhanced("Alex", 150, "Hatchet");
        //playerHero.health = 54; // no can do
        System.out.println("Initial health is " + playerHero.getHealth());

        playerHero.loseHealth(89);
        System.out.println("Initial health is " + playerHero.getHealth());

        System.out.println("*******************");

        Printer printer = new Printer(10, false, 500);
        Printer printerDuplex = new Printer(75, true, 500);

        printer.tonerRefill(18.72);
        printer.tonerRefill(-18.72);
        printer.tonerRefill(18.78679);
        printer.tonerRefill(54.3);
        printer.tonerRefill(18.0);
        printer.paperRefill(500);
        printer.paperRefill(1);


        printerDuplex.print(427);
        printerDuplex.print(214);
        printerDuplex.print(155);
        printerDuplex.tonerRefill(50);
        printerDuplex.print(250);
        printerDuplex.paperRefill(124);
    }
}