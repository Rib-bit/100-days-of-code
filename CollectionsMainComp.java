package com.example.masterclass;

/*
Comparable and Comparator
    see TheaterComp class for details on the Comparable interface

    Another way to use the sort() method is to pass it a Comparator
        Similar to a Comparable. the Comparator interface defines a single method called compare()
        unlike Comparable, the objects to be sorted don't have to implement Comparator
            instead, we can create an object of type Comparator, with a compare() method
            More than one Comparator can be created, which can allow for objects to be sorted in different ways

            Two common ways
                we can create a Comparator object within an existing class
                we can create a new class that implements the Comparator interface

 */
public class CollectionsMainComp {

    public static void main(String[] args) {
        TheaterComp theater = new TheaterComp("Olympian", 5, 14);

        theater.reserveSeat("D12");
        theater.reserveSeat("D12");
        theater.reserveSeat("B06");
        theater.reserveSeat("M06");
        theater.reserveSeat("G11");
        theater.reserveSeat("B13");
        theater.reserveSeat("B16");

        theater.myToString();

        theater.sortPrice();
        System.out.println("=================================================");

        theater.myToString();

        theater.addSeat('A', 4, 14);
        theater.myToString();
        theater.sortPrice();
        System.out.println("======");
        theater.myToString();

    }
}