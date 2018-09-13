package com.example.masterclass;

public class Pikachu extends Chipmunk {
    private final String colour;
    public Pikachu(String name) {
        super(name);
        this.colour = "brown and yellow";
    }

    /*@Override
    public boolean equals(Object obj) {
        if(this==obj) {
            return true;
        }

        if(obj instanceof Pikachu) {
            String objName = ((Pikachu)obj).getName();
            return this.getName().equals(objName);
        }

        return false;
    }*/
}
