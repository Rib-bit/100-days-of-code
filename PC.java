package masterclass;

public class PC { //Composition, instance variables can be classes. Standard Java inheritance only lets us extend from one class
    private Case theCase;// Composition helps us create a class that inherits from several classes at a time
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    public void codeCodeCode(double hours) {
        powerUp();
        System.out.println("You code for " + hours + " hours before logging your progress online. Baby steps!");
    }

    private void drawLogo() {
        // Imagine fancy graphics code
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    private Case getTheCase() {
        return theCase;
    }

    private Monitor getMonitor() {
        return monitor;
    }

    private Motherboard getMotherboard() {
        return motherboard;
    }
}
