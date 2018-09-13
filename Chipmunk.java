package com.example.masterclass;

public class Chipmunk {
    private final String name;

    public Chipmunk(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {//making sure a subclass, if they are allowed, cannot override equals too

        /*
        if a subclass would reasonably only add methods that don't alter the way that equality should work, we can allow it, but mark equals() and hashCode() as final

        if it's likely to be a different object, we can use the method we used in HeavenlyBody to make a comparison between the subclass and the base class return false

        if neither, then make the class final and force clients to use composition instead of inheritance
         */
        if(this==obj) {
            return true;
        }

        if(obj instanceof Chipmunk) {
            String objName = ((Chipmunk)obj).getName();
            return this.name.equals(objName);
        }

        return false;
    }
}
