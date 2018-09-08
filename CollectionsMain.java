package com.example.masterclass;

import java.util.*;

/*
List, ArrayList and LinkedList form part of the Java Collections framework (together with Sets, Maps, Trees and Queues)

    Top level of this framework is the Collections class
        exposes static methods, such as sort() that operates on Collections, and list() that returns a Collections object

        the interfaces and the Collections framework allow it to be extended
        they define methods for the fundamental operations that are required for the different Collection types

        One of the goals of the Collections framework is that there should be good interoperability amongst various collections
            including anything that represent a collection, be it outside the Collections framework, like arrays

        Arrays couldn't be made part of the Collections framework, but the framework includes methods to move Collections into arrays and vice versa
            and methods to allow arrays to be viewed as collections

        The core element of the Collections framework are interfaces, abstract types that represent collections, including the List interface
        Another one is implementations, the concrete implementations of the interface, including ArrayList and LinkedList classes
        Aldo algorithms; JDK provides a range of polymorphic algorithms that work on objects that implement a Collections interface.

        Let's consider the List interface, and the ArrayList and LinkedList objects, within the context of the Collections framework
 */
public class CollectionsMain {

    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);
//        theater.getSeats();
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats); //creating a copy of an ArrayList
        printList(seatCopy);
        printList(theater.seats); //yup, it works
        //that method is called a 'shallow copy'. Creates an ArrayList containing all the elements from the list passed to the constructor
        //shallow, because it makes new addresses for the object instances, not new instances. Reserve a seat from the copied list,
        //and it'll be reserved in the original list too

        seatCopy.get(1).reserve();
        theater.seats.get(1).reserve();
        System.out.println();

        //they are different ArrayLists, even though they refer to the same objects
        Collections.reverse(seatCopy);//reversing a list
        System.out.println("printing seatCopy");
        printList(seatCopy);
        System.out.println("printing theater.seats");
        printList(theater.seats);

        Collections.shuffle(theater.seats);//shuffling a list
        System.out.println();
        System.out.println("printing seatCopy");
        printList(seatCopy);
        System.out.println("printing theater.seats");
        printList(theater.seats);


        Theater.Seat minSeat = Collections.min(theater.seats);//min and max
        Theater.Seat maxSeat = Collections.max(theater.seats);

        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(theater.seats);
        printList(theater.seats);

        //a deep copy, obviously, contains duplicate instances, rather than duplicate instance addresses

       /* List<Theater.Seat> newList = new ArrayList<>(theater.seats.size());
        Collections.copy(newList, theater.seats);*/
       //will not work as is; not only does the destination List need to be of a large enough size
    }

    public static void printList(List<Theater.Seat> list) {
        for(Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("================================================");
    }

    public static void sortList(List<? extends Theater.Seat> list) { //making your own sort routine, slower than a built in merge sort or bubble sort
        for (int i = 0; i < list.size() - 1; i++) {//slower, but could save memory
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}