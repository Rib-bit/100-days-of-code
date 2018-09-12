package com.example.masterclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Sets and HashSets

Less common than Lists and Maps, but can be very useful

While a list can contain duplicates and is ordered
    Sets are chaotic, and cannot contain duplicates
    The lack of duplicates is the most prominent feature, since there are ordered Sets, like LinkedHashSets and TreeSets

    to ensure that there are no duplicates in your collection, you may want to use a Set

    The set interface is generic and takes a single type. Don't use a raw set unless you have an excellent reason

    this interface defines the basic methods add(), remove() and clear()
        as well as a size() and isEmpty() method
            the contains() method can help check if a specific item is in the set

        No way to retrieve an item from a set: you can only check if it exists, or iterate over all the elements

    We've already used a Set when calling the keySet() method in a Map. It follows that the rules applying to keys in a Map also apply to items in a set
        namely, using immutable objects if you need to use objects
        a set cannot be an element of itself

    The best performing implementation of a Set interface is a HashSet class, because it uses hashes to store the items
    Currently, the HashSet implementation uses a HashMap: if a set can be implemented using a map, you could use a corresponding map object, using only the keys

    HashSets are super fast
 */
public class SetMain {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp;
        HeavenlyBody tempMoon;

        temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365.2);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);//adding the satellite to the solar system
        temp.addMoon(tempMoon);//adding "Moon" to the satellites of Earth, because temp is still Earth

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");

        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        //the set interface does support iteration

        /*
        say we wanted to gather all the moons of the different planets in one set
        we can easily generate the union of the set of each planet's moons
        in Set theory, a union of two or more sets is a set containing all the elements of the sets

        sets don't contain duplicates, so each element in the union will only appear once, even if it was present in more than one set
        we can use the addAll() method in a for each loop
         */
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        /*a case could be made to include a destination field in HeavenlyBody, to determine in which set a body should be added
        the sets would be built up by iterating through the entire solar system, checking the destination, and adding to the appropriate set

        a common confusing point is that it's only references to the objects that are being stored in a set
        While Europa appears in the solarSystem Map, and in the satellites Set for Jupiter, but there's only one instance of the HeavenlyBody class for europa
        a common mistake would be to include only the name of an instance in a set, instead of a reference to it
            that code would work but the reasoning behind it is flawed
            One would think that one could save kbs by storing a String instead,but a reference is always reference-sized,
                while the code becomes more complex in order to retrieve the object from the Map
            If the id of an object was an integer rather than a string, it might be tempting to store that in the set
                also a false optimisation: on a 32bit JVM, an integer and an object reference both take 4bytes (32bits)
                on a 64bit JVM, an object reference takes 8bytes, but Java7 uses compressed pointers that can use less than 32b for an int

                check out : https://docs.oracle.com/javase/8/docs/technotes/guides/vm/performance-enhancements-7.html

        One good reason for using the body's name in a set : we want to make classes immutable if we are to add them to a set
        But then again, new info is constantly being discovered about heavenly bodies, and changes will need to be made to the class, or the instances...


        */
    }
}
