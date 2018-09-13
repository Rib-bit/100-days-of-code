package com.example.masterclass;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMainAgain {

    private static Map<String, HeavenlyBodyAgain> solarSystem = new HashMap<>();
    private static Set<HeavenlyBodyAgain> planets = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBodyAgain temp;
        HeavenlyBodyAgain tempMoon;

        temp = new HeavenlyBodyAgain("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBodyAgain("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBodyAgain("Earth", 365.2);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBodyAgain("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBodyAgain("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBodyAgain("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBodyAgain("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBodyAgain("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBodyAgain("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBodyAgain("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBodyAgain("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        tempMoon = new HeavenlyBodyAgain("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBodyAgain("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBodyAgain("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBodyAgain("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBodyAgain("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");

        for (HeavenlyBodyAgain planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBodyAgain body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBodyAgain jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        Set<HeavenlyBodyAgain> moons = new HashSet<>();
        for (HeavenlyBodyAgain planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBodyAgain moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        //The Java documentation warns us about using our own objects as keys in a map or elements in a set
        //if we go through with it, we should override the equals() and hashCode() methods

        HeavenlyBodyAgain pluto = new HeavenlyBodyAgain("Pluto", 842);
        planets.add(pluto);

        System.out.println("______________________________");
        for (HeavenlyBodyAgain planet: planets){
            System.out.println(planet.getName() + " : " + planet.getOrbitalPeriod());
        }

        //Pluto shows up twice, which shouldn't happen in a set. The reason is that the two instances are not strictly equal. temp and pluto are two distinct instances of te class
        //We thus have to override the equals() method in our HeavenlyBody class.

        //They don't compare equal because the base Object class from which all other objects are derived defines a simple method to perform
        //what is known as "referential equality." If both references point to the same instance, they're equal by default. Basically '==', which we've learnt not to do with objects

        Object o = new Object();
        System.out.println(o.equals(o));
        System.out.println("pluto".equals(""));

        /*Checking out the equals() method for the String class, we see that it is more complex than the default Object method
        More optimised too : it first checks whether it's being compared to itself, if not it ensures the compared object is indeed a String or subclass thereof
        it casts it into a String for good measure, and (in previous versions) would compare the lengths of the strings before comparing each character
        if lengths are different, or as soon as one character differs, the method returns false; if the loop finishes without finding a difference, the two strings are equal

        If two objects compare equal, they must have the same hashcode.

         public boolean equals(Object anObject) {s
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String aString = (String)anObject;
            if (coder() == aString.coder()) {
                return isLatin1() ? StringLatin1.equals(value, aString.value)
                                  : StringUTF16.equals(value, aString.value);
            }
        }
        return false;
    }
         */
    }
}
