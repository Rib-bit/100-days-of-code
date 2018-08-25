package masterclass;

/*
check out oracle.com ListIterator

the listiterator is never at a 'current' position as such, it hovers between a previous and a next element
set up so it cannot error into an infinite loop. serious problem in the past, 'tortoise and the hare' algorithm

we need to keep track of which direction we're going in, as a consequence, and allow for the 'in-between' nature of the iterator

 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        addInOrder(placesToVisit, "Darwin");
        addInOrder(placesToVisit, "Alice Springs");


        printList(placesToVisit);

        visit(placesToVisit);
        //placesToVisit.add(1, "Alice Springs");
        //printList(placesToVisit);//Sydney is now pointing to Alice Springs, and Alice Springs is now pointing to Melbourne

        //placesToVisit.remove(4);
        //printList(placesToVisit);//Brisbane is now pointing to Canberra, and the garbage collection will take Perth away

    //let's try something cooler now. Something we can do easily with a linkedlist. See addInOrder
    }

    private static void printList(LinkedList<String> linkedList) {
        //an iterator is another way of going through all entries in an array or list
        Iterator<String> i = linkedList.iterator();//the iterator method is already part of the linkedlist
        while(i.hasNext()) {//a linkedlist entry points to another entry. While an element is pointing to something else in our list, we show the current record
            System.out.println("Now visiting " + i.next());//i.next() gives you the current record and increments at the same time. Like {get(i) + i++}
        }
        System.out.println("=============");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator(); //this time we create a listIterator, giving us more flexibility

        /*
        about the code below
            when we created the stringListIterator, we still needed to run the .next() method once for it to go to the first entry of the linkedlist

        writing methods with side effects is generally to be avoided. Here, we're returning a boolean while changing the elements of a list

         */

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {//0 would be a match, do not add
                System.out.println(newCity + " was already in the register");
                return false;
            } else if (comparison > 0) {//newCity should appear before this one
                stringListIterator.previous(); //because we used .next() 5 lines above, we need to go back before we insert newCity. listIterator enables us to go back
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                //move on to next element
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities found in itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next()); //gets the iterator started
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {     //**extra steps due to the in-between nature of the iterator
                        if(listIterator.hasNext()) {//**extra check too
                            listIterator.next();//**
                        }//**
                        goingForward = true;//**
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;//**
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Reached the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - to go to next city\n" +
                "2 - to go to previous city\n" +
                "3 - to print menu options");
    }
}
