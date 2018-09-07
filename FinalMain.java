package com.example.masterclass;

/*
looking at the static equivalent of constructors : static initialisation blocks
    instance constructors are non-static
    static initialisation blocks (or 'class constructors') are only executed once when the class is first loaded into the project
        not often used, advanced feature for rare cases
        a static final variable must be initialised byt the time asl static initialisation blocks terminate
        in the same way that we can set the value of a final field in the constructor
            we can set the value of a static final variable in a static initialisation block
 */
public class FinalMain {
    public static void main(String[] args) {

        /*FinalExample one = new FinalExample("one");
        FinalExample two = new FinalExample("two");
        FinalExample three = new FinalExample("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        int pw = 1358468;
        Password password = new ExtendedPassword(1358468);
        password.storePassword();

        password.letMeIn(48794);
        password.letMeIn(747300078);
        password.letMeIn(1358467);
        password.letMeIn(1358468);*/

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("owner is " + SIBTest.owner);
    }
}
