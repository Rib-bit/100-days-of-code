package masterclass;

import java.util.ArrayList;

public class Team<T extends Athlete> implements Comparable<Team<T>> { //'<T>' indicates there will be a type there. Can extend from a single class,
    // and implement multiple parameters. Class first, then interfaces.
    //using any type that extends from athlete or subclass of athlete. Athlete is said to be the upper bound of T...
    // T is a bounded type parameter. Multiple bounds are added using ' & '

    //more code would be needed if we wanted to have multiple bounds. To check what type of objects we're dealing with

    //The argument passed for a type parameter can either be a class or an interface
    //Actually, interfaces themselves can specify type parameters: we can create instances of a class that implement
    // an interface, and ensure that the interface methods you implement act on a specific type of object
    //ex: List is an interface that accepts certain type parameters, like String

    //with us now using the Comparable interface, we must implement the abstract method compareTo();
    //we would want to compare only comparable objects. <Team<T>> lets us specify a generic type as a parameter

    //knowing how to use the Comparable interface will be useful in the upcoming challenge.
    //when we have a list of objects that implement Comparable, such as ArrayList<T>, we can sort the list using
    // the static sort method of the Collections class

    //ArrayList<Team> teams;
    //Collections.sort(teams);

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T athlete) {
        if(members.contains(athlete)){
            System.out.println(athlete.getName() + " is already on the team");
            return false;
        } else {
            members.add(athlete);
            System.out.println(athlete.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){

        String message;
        if(ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;

        if(opponent != null) { //using null so we can save the result on their file too, while making sure it doesn't
            //start an infinite loop
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()) {
            return -1; //not ranked higher than the instance from which the method was called
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
