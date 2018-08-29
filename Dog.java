package masterclass;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating"); //getName is available in this class, although implemented in the Animal class
        //we couldn't do this mix and abstract and implemented in an interface
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");
    }

}
