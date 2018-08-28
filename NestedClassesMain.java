package masterclass;

import java.util.Scanner;

/*
It is possible to nest a class inside another class. 4 types of nested classes
    static nested class
        cannot access the non-static members or methods of its outer class without first creating an instance of that class
                mainly to associate a class with its outer class, kinda like a top level class packaged in its outer class

    (non-static) inner class
        We'll start with those, as they tend to be useful more often
             - i.e. when it doesn't make sense to refer to a class without its outer class


    local class (inner class defined inside a scope block, usually a method)
        their code is completely restricted to the block they reside in. (I'm assuming this can help prevent future naming collisions and other conflicts with memory addresses)
               they increase encapsulation, technically, but are used less often in practice

    anonymous class (a local class without a class name)
        has to be declared and instantiated at the same time, having no address.
              used when a local class is required only once. Very common for touching event handlers to buttons in a UI, like in Android apps
*/
public class NestedClassesMain {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
        /*
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3); //slightly different syntax, obviously. Most notably, we cannot create an instance of the ...
        //... Gear object if we don't have an instance of Gearbox to create it from
        System.out.println(first.driveSpeed(1000));
        //Gearbox.Gear second = new Gearbox.Gear(2, 15.4); //'masterclass.Gearbox is not an enclosing class' ERROR
        //Gearbox.Gear second = new mcLaren.Gear(2, 15.4);
        Gearbox.Gear second = mcLaren.new Gear(2, 15.4);
        */

        //now that we've made the inner Gear class private, we need to rework our instantiation etc.



        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));



//        class ClickListener implements Button.OnClickListener { // the local class is applicable to this block only
//            public ClickListener() { //could be useful if for instance we wanted to assign exactly the same object to several buttons
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());

        // now with an anonymous class

        btnPrint.setOnClickListener(new Button.OnClickListener() { //the main difference is we didn't create a separate class
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
