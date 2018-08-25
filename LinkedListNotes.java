package masterclass;

import java.util.ArrayList;

/*
LinkedListNotes is another type of list

       Arrays are indexed lists of items (primitive types in normal arrays, objects in ArrayLists...)

Looking at Linkedist for an array of seven integers

Index       Address     Value
0           100         34
1           104         18
2           108         91
3           112         57
4           116         453
5           120         68
6           124         6

Internally, Java allocates 4b of memory for each int, bcs it needs that much to store the largest ones
Java will try to do this contiguously, and there's a formula fo Java to figure out which physical memory address to use to grab a value
    Looking at the base address, here '100', we can determine where a certain element will be found
    elementAddress = baseAddress + (i * allocatedMemory)
            intArray[3]'s address = 100 + (3 * 4)
        <=> intArray[3]'s address = 112

    The allocated memory is different for different datatypes (8b for doubles, etc.)

When dealing with objects, like Strings, Java has to proceed differently

Index       Address     String Address                  Address     Done
0           100         1034                            1024        Hello World
1           108         1037                            1034        Tim
2           116         1046                            1037        Australia
3           124         1024                            1046        Java
4           132         4000                            1050        Array
5           140         1050                            1055        ArrayList
6           148         1055                            4000        Done

Object addresses are stored in the array, not the objects themselves. We see that the actual object addresses don't need to be contiguous
    StrArrayList[2]'s address = 100 + (2 * 8) = 116
        contains the address 1046, which points to the string "Java"

Once the program goes out of scope or stops executing, Java's garbage collection process frees up that memory
 */
public class LinkedListNotes {

    public static void main(String[] args) {
        CustomerLinked customer = new CustomerLinked("Tim", 54.96);
        CustomerLinked anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        //System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance()); //prints 12.18

        //the 'why' relates to what we learned about memory
        //when we assign anotherCustomer = customer, internally we assigned the 2nd class to point to the 1st class
        //Java saved the memory address, instead of creating a separate class. Referencing vs instantiating...

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        System.out.println("*****");
        intList.add(1, 2); //using an overloaded .add() to insert an element at a specific index position

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        /*
        '1: 2' was inserted. Elements now in position 2 and 3 had to be moved down in order to make room for that new entry
        with larger arrays, it's a lot more work for the computer, and could greatly increase processing time
        same problem with deleting.

        that's were LinkedLists come in
        stores the actual link to the next item in the list, as well as the actual data
        each element in the list holds a link to the item that follows it, and the value

        Index       Address     String Address                  Address     Done
        0           100         1034                            1024        Hello World
        1           108         1037                            1034        Tim
        2           116         1046                            1037        Australia
        3           124         1024                            1046        Java
        4           132         4000                            1050        Array
        5           140         1050                            1055        ArrayList
        6           148         1055                            4000        Done

        The example above would look as follow if it was a linkedlist

            'each element in the list holds a link to the item that follows it'
        (1034) -> Tim(1037) -> Australia(1046) -> Java(1024) -> Hello World(4000) -> Done(1050) -> Array(1055) -> ArrayList(null)

            we can i_n_s_e_r_t an element without reassigning other elements in the list
        (1034) -> Tim(1037) -> Australia(1_0_7_2) -> U_d_e_m_y(1_0_4_6) -> Java(1024) -> Hello World(4000) -> Done(1050) -> Array(1055) -> ArrayList(null)

            same with deletion^
        (1034) -> Tim(1037) -> Australia(1046) -> Java(1024) -> Hello World(^1050) ^ -> Array(1055) -> ArrayList(null)


        */
    }
}

class CustomerLinked {
    private String name;
    private double balance;

    public CustomerLinked(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
