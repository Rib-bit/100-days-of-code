package masterclass;
//Polymorphism challenge

/*
public class Main {

   public static void main(String[] args) {
        Mercedes mercedes = new Mercedes();
        Renault renault = new Renault();
        Skoda skoda = new Skoda();

        mercedes.accelerate(10);
        mercedes.accelerate(20);
        mercedes.brake(15);
        System.out.println(mercedes.getCylinders() + " cylinders");
        renault.accelerate(10);
        renault.accelerate(20);
        renault.brake(15);
        System.out.println(renault.getCylinders() + " cylinders");
        skoda.accelerate(10);
        skoda.accelerate(20);
        skoda.brake(15);
        System.out.println(skoda.getCylinders() + " cylinders");
    }

}
*/
public class Car {
    private String name;
    private boolean hasEngine;
    private int cylinders;
    private int wheels;
    private int speed;

    public void startEngine() {
        if(hasEngine){
            System.out.println("The engine starts up. Vrooommm.");
        } else {
            System.out.println("No engine detected.");
        }
    }

    public int accelerate(int figure) {
        this.speed += figure + this.cylinders; //All right, turns out you can dynamically fetch the class name and potentially do away with the name field. See below
        System.out.println("The " + getClass().getSimpleName() + " accelerates by " + figure + ". New speed= " + this.speed); //getClass() is a method from the Object class
        return (this.speed); //thanks to overriding (I assume, motl), 'this' applies to the subclass that called the method
    }

    public int brake(int figure) {
        System.out.println("The " + name + " decelerates by " + figure + ". New speed= " + (this.speed - figure));
        return (this.speed - figure);
    }

    public Car(String name, int cylinders) { //whip it up real quick, hardcoding some constant values to type only one constructor
        this.name = name;
        this.hasEngine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
        this.speed = 0;
    }

    public String getName() {
        return name;
    }

    public boolean hasEngine() {
        return hasEngine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }

    public int getSpeed () {
        return speed;
    }
}

class Mercedes extends Car {
    public Mercedes() {
        super("Mercedes", 8);
    }

    @Override
    public int accelerate(int figure) {
        return super.accelerate(figure); //Tim just wrote the same code and didn't use 'super' - he changed the variables manually. I need to research polymorphism to find out
        //... what it is exactly. I just wanted to avoid duplicating code.
    }

    @Override
    public int brake(int figure) {
        return super.brake(figure);
    }
}

class Renault extends Car {
    public Renault() {
        super("Renault", 5);
    }

    @Override
    public int accelerate(int figure) {
        return super.accelerate(figure);
    }

    @Override
    public int brake(int figure) {
        return super.brake(figure);
    }
}

class Skoda extends Car {
    public Skoda(){
        super("Skoda", 6);
    }

    @Override
    public int accelerate(int figure) {
        return super.accelerate(figure);
    }

    @Override
    public int brake(int figure) {
        return super.brake(figure);
    }
}

