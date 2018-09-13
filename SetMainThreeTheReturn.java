package com.example.masterclass;

public class SetMainThreeTheReturn {

    public static void main(String[] args) {
        Pikachu pika = new Pikachu("Pikachu");
        Chipmunk pika2 = new Chipmunk("Pikachu");


        //would return true if we hadn't overridden the equals() method in the subclass
        System.out.println(pika.equals(pika2));//returns false, because Chipmunk is not an instance of Pikachu
        System.out.println(pika2.equals(pika));//returns true, because Pikachu is an instance of Chipmunk
        //this violates the 'symmetricity' rule


    }
}

