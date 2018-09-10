package com.example.test;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits); //we put exits in the constructor, thus creating a copy of the HashMap
        //we're programming defensively, making sure nothing can be accessed that doesn't need to be.
        //That way, nothing outside this class can change the HashMap.
        //The getter returns a copy of exits, so that if the calling program wants to remove mappings from it
        // the exits mapping field won't be affected. This is a way to make our classes immutable; returning different mutable objects in getters
    }
}