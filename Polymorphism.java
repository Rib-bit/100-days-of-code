//Polymorphism
//Mechanism that allows actions on different objects to act differently depending on the object.
//Polymorphism is linked to overriding, for instance

package masterclass;

public class Polymorphism {

    public static void main(String[] args) {
        for(int i=1; i<11;  i++){
            Movie movie = randomMovie(); //see method below.
            System.out.println("Movie # " + i +
                    " : " + movie.getName() + "\n" +
                    "Plot: " + movie.plot() + "\n"); //if no movie.plot, Java will look for Movie.plot automatically. That one line does a lot of work
        }
    }

    public static Movie randomMovie() { //classes, datatypes on steroids
        int randomNumber = (int) ((Math.random() * 5) + 1); //Math.random returns a random double between 0 and 1. '*5' : btwn 0 and 4. '+1' for readability
        System.out.println("RNG was: " + randomNumber);
        switch(randomNumber) {
            case 1:
                return new Jaws(); //...datatypes on steroid. Method returns an instance of the Movie superclass, which is why we needed to set up inheritance here.
            case 2:
                return new IndependenceDay();
            case 3:
                return new MazeRunner();
            case 4:
                return new StarWars();
            case 5:
                return new Forgetable();
            default:
                return null;
        }
    }

}

class Movie {//we can create a new class within the Main.java sourcefile.
    private String name;//handy when you create small, one-use classes. Scope issues

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here.";
    }

    public String getName() {
        return name;
    }
}

class Jaws extends Movie{
    public Jaws() {
        super("Jaws");
    }

    @Override
    public String plot() {
        return "A shark eats lots of people.";
    }
}

class IndependenceDay extends Movie{
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet.";
    }

}

class MazeRunner extends Movie{
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze.";
    }

}

class StarWars extends Movie{
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe.";
    }
}

class Forgetable extends Movie{
    public Forgetable() {
        super("Forgetable");
    }

    //No plot method
}
