package masterclass;

/*
Generics
Just as we can create methods that take arguments in Java, and we can replace the parameters that we declare for the method...
... Generics allow to create classes, interfaces and methods that take Types as parameters : type parameters


    It is commonly understood that the earlier a bug is spotted in production code, the easier and cheaper it is to fix.
    The code itself must then be fully tested, to make sure the fix didn't introduce other bugs, before being redeployed.
    Any other apps that rely on the program also have to be tested again, to make sure the fix hasn't broken interoperability
    between the two systems.
    If the bug is spotted during testing, the required effort is slightly reduced, but we still have to redo all the tests
    that were done now that we've 'fixed' it.

    If the bug is spotted at compile time, it has much lower impact. That's what we want.
 */


import java.util.ArrayList;

public class GenericsMain {

    public static void main(String[] args) {

        ArrayList<Integer> items = new ArrayList<>(); //<> diamond came with Java 7. No need to specify again.
        items.add(1); //using autoboxing
        items.add(2);
        //items.add("two and a half");
        items.add(3);//if we replaced this integer by a String, we wouldn't get a 'red alarm', the program would compile
        items.add(4);//...but we would get an exception at run-time. And the IDE warns us that we have an unchecked call to add(E)
        items.add(5);//"Main.java uses unchecked or unsafe operations."

        //ArrayList is a generic type, here used without specifying a type parameter. Raw type. Should not be used anymore, only left for backward compatibility
        //We're supposed to provide a type parameter to a generic type, for 'type safety' purposes. This is called a parametised type, specified using angled brackets

        printDoubled(items);

    }

    private static void printDoubled(ArrayList<Integer> n) {
        /*for (Object i : n) { //'Object' had to be used because we didn't specify the type above at first
            System.out.println((Integer)i * 2); //casting it as an integer
        }*/

        for (int i : n) {
            System.out.println(i * 2);
        }
    }
}


