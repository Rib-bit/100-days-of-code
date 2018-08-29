package masterclass;



public abstract class Animal { //keyword 'abstract'

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat(); //this looks familiar... + 'abstract'
    public abstract void breathe();

    public String getName() {
        return name;
    }


}
