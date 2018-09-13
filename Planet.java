package com.example.masterclass;

public class Planet extends HeavenlyBodyChallenge {
    public Planet(String name, double orbitalPeriod) {
        super(name, BodyTypes.PLANET, orbitalPeriod);
    }

    @Override
    public boolean addSatellite(HeavenlyBodyChallenge moon) {
        if(moon.getKey().getBodyType() == BodyTypes.SATELLITE){
            return super.addSatellite(moon);
        } else {
            System.out.println("Only bodies of type Satellite can orbit a planet");
            return false;
        }
    }
}
