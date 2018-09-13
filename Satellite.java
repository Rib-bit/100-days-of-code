package com.example.masterclass;

public class Satellite extends HeavenlyBodyChallenge {
    public Satellite(String name, double orbitalPeriod) {
        super(name, BodyTypes.SATELLITE, orbitalPeriod);
    }
}
