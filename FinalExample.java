package com.example.masterclass;

/*
In most cases, we will see 'final' preceded by 'static'. That is because, for a constant value, it usually makes more sense
to be assigned to a whole class, rather than each and every instance.

Here, with instanceNumber, we didn't declare a proper constant, we just didn't want the variable to be accessible after instantiation



System.out.println(Math.PI); //declared as a public static final double

        the Math class itself cannot be instantiated, because the constructor is declared as private.
        they even declared the class as 'final', so as to ensure no one could subclass it
        no "public class MyMath extends Math{...}"

if we wish for a class to be extendable, but have some methods that are crucial to the proper operation of your class
marking them as final will prevent them from being overridden
 */

public class FinalExample {
    private static int classCounter = 0;
    private final int instanceNumber;// = 1;
    private final String name;

    public FinalExample(String name) {
        this.name = name;
        classCounter++; //why may we want to initialize the final variable in the constructor?
        instanceNumber = classCounter;//it might be the result of some calculation; or may need some other code, like a method from another class
        System.out.println(name + " created. Instance " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
