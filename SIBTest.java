package com.example.masterclass;

public class SIBTest {
    public static final String owner;

    static{
        owner = "Tim";
        System.out.println("SIBTest static initialisation block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }//putting the constructor here can be misleading, as the static initialisation blocks will always execute first

    static{
        System.out.println("2nd static initialisation block called");
    }//there can be as many static initialisation blocks as you like. Called in the order they are declared in the class

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
