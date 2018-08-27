//draia, 27/08/2018

package masterclass;

public class Interfaces {

    public static void main(String[] args) {

        ITelephone timsPhone; //typing 'ITelephone timsphone = new ITelephone' wouldn't be valid, IntelliJ would try to create a class within the implementation
        // and override all the methods again.The interface is only there at an abstract level as a contract for how some classes must be implemented
        // typing 'Deskphone timsPhone' would work though, and might be preferable in some cases. Provided we use an appropriate class that has implemented the interface. Motl.
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(24565); //since they both implement the same interface, we can instantiate MobilePhone thus
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();

    }
}

/*
in the Walkman Class, we use List interfaces extensively. If we were to go back and change LinkedLists to Lists or ArrayLists, for instance, or Vector, we could still run it
    because the Java library uses interfaces extensively. Makes the code more robust when you change some implementations
    As a consequence, it's pretty normal to define basic Lists in code and only specify the type of list when we initialise the variable.. Motl

    Deciding between implementing an interface or extending, inheriting from a superclass...
        with the ITelephone interface, the DeskPhone class and the MobilePhone class, we could have had a Telephone class from which both inherit state and behaviour
        but let us consider the relationship between the final classes and the object they're extending or implementing.
            The desk phone and the mobile phone both have a telephone, but the mobile phone is much more than a phone
            A mobile phone can telephone, we should see it as a computer that has a phone interface

    In Java, a class can only inherit from a single class, but it can implement many interfaces. Very powerful
        Consider the Animal class. Not all animals can walk, so we cannot put the walk(); method in the superclass
            but we could define a IWalk interface, since many subclasses of animals would use it. Same for ISwim, IFly...
                a dog would extend Animal, and implement IWalk
                a common bird would extend Animal, and implement IWalk and IFly.
 */