package com.example.masterclass;

import java.util.Scanner;

/*
Scope

    Granting or restricting access to our objects. It is the visibility of a class, member, or variable.
    public, private, or protected are one way to restrict the scope of an object. Motl

    But scope is even more important within one class or method
    Whenever we refer to a variable, we refer to the variable of the same name within the most local scope, the narrowest scope
    We can also use the visual concept of enclosing blocks. Java checks the current block, then works backwards all the way to the Object class

    in Java, objects themselves also have visibility, adding to the difficulty of the whole endeavour
    Hence the good practice of giving your variables different names

    An object's scope is the block in which it's declared, including any contained blocks.

    In Java, an object's visibility is defined by its access modifiers. Visibility is connected to scope, and we shall first study scope

    An inner class, for example, has access to all the member variables or fields of its containing class, even if marked private. True the other way around.

    We remember how, with inheritance, we often have a subclass override a method from the superclass. The mechanism for that is very similar to what we just saw with variables
 */

public class ScopeMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String varFour = "this is private to main()"; //same name as ScopeCheck's private int variable, but points to different data
        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();// displays varThree because, though private, it is accessed from a method within the outer class

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
//        System.out.println("varThree is not accessible here : " + innerClass.varThree); //because varThree has private access

        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour); //"this is private to main()" is the only variable with this name that's available, accessible in the current scope

        scopeInstance.timesTwo();
        System.out.println("***********");
        innerClass.timesTwo();


//        X x = new X();
//
//        x.x();

        XTim x = new XTim(new Scanner(System.in));
        x.x();

    }

}
