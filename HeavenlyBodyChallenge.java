package com.example.masterclass;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBodyChallenge {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBodyChallenge> satellites;

    public enum BodyTypes{
        STAR,
        PLANET,
        SATELLITE,
    }

    /*
    about Enums

    we get an error at compile time if the value is invalid, as opposed to having constants as fields and a switch in the constructor (error ar runtime)

    a nested Enum is automatically static
        therefore possible to refer to the Enum values without creating an instance of a HeavenlyBody first
     */

    public HeavenlyBodyChallenge(String name,BodyTypes bodyType, double orbitalPeriod)  {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBodyChallenge> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addSatellite(HeavenlyBodyChallenge moon) {
        return this.satellites.add(moon);
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if(obj instanceof HeavenlyBodyChallenge) {
            HeavenlyBodyChallenge theObject = (HeavenlyBodyChallenge) obj;
            return this.key.equals(theObject.getKey());
        }

        return false;
    }

    @Override
    public final int hashCode() {

        return this.key.hashCode(); //Enum constants have a hashcode as well
    }

    @Override
    public String toString() {
        return this.key.bodyType + ": " + this.key.name + ", " + this.orbitalPeriod;
    }

    //////////////////////////////////////////////////////////////////////////////

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) {
                return(this.bodyType == key.getBodyType());
            }
            return false;
        }

        @Override
        public String toString() {
            return this.bodyType + ": " + this.name;
        }
    }
}