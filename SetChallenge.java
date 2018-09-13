package com.example.masterclass;

import java.util.*;

/*

 */

public class SetChallenge {
    
    private static Map<HeavenlyBodyChallenge.Key, HeavenlyBodyChallenge> solarSystem = new HashMap<>();

    private static Set<Star> stars = new HashSet<>();
    private static Set<Planet> planets = new HashSet<>();
    private static Set<Satellite> satellites = new HashSet<>();

    public static void main(String[] args) {
        Star tempStar;
        Planet tempPlanet;
        Satellite tempSatellite;

        tempStar = new Star("Sun", 0);
        solarSystem.put(tempStar.getKey(), tempStar);
        stars.add(tempStar);

        tempPlanet = new Planet("Mercury", 88);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Venus", 225);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Earth", 365.2);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempSatellite = new Satellite("Moon", 27);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempSatellite = new Satellite("Deimos", 1.3);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempSatellite = new Satellite("Phobos", 0.3);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempPlanet = new Planet("Jupiter", 4332);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempSatellite = new Satellite("Io", 1.8);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempSatellite = new Satellite("Europa", 3.5);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempSatellite = new Satellite("Ganymede", 7.1);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempSatellite = new Satellite("Callisto", 16.7);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempPlanet.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempPlanet = new Planet("Saturn", 10759);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Uranus", 30660);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Neptune", 165);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        tempStar.addSatellite(tempPlanet);
        planets.add(tempPlanet);

        tempStar = new Star("BetaMinor", 0);
        solarSystem.put(tempStar.getKey(), tempStar);
        stars.add(tempStar);

        tempSatellite = new Satellite("BetaMinor", 13.5);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempStar.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        tempSatellite = new Satellite("Pluto", 248);
        solarSystem.put(tempSatellite.getKey(), tempSatellite);
        tempStar.addSatellite(tempSatellite);
        satellites.add(tempSatellite);

        Satellite pluto = new Satellite("Pluto", 842);
        solarSystem.put(pluto.getKey(), pluto);

//        System.out.println("pluto & tempSatellite: isEqual? " + pluto.equals(tempSatellite));
//        System.out.println("tempSatellite & pluto: isEqual? " + tempSatellite.equals(pluto));

        System.out.println("The Pluto Delusion - from map\n" + solarSystem.get(pluto.getKey()));

       /* System.out.println("The Solar System - map");
        for (HeavenlyBodyChallenge body : solarSystem.values()) {
            System.out.println(body);
        }*/

        System.out.println("\nThe Heavenly Bodies - set");
        printSet(stars, true);
        System.out.println("\nThe Planets - set");
        printSet(planets, false);
        System.out.println("\nThe Satellites - set");
        printSet(satellites, false);

    }

    private static void printSet(Set<? extends HeavenlyBodyChallenge> set, boolean printAll) {

        for (HeavenlyBodyChallenge body : set) {
            System.out.println(body);
            if((!body.getSatellites().isEmpty()) && (printAll)) {
                printSet(body.getSatellites(), true);
            }
        }
    }
}
