//draia, 23/08/2018

package masterclass;

import java.util.ArrayList;

public class Autoboxing {

    public static void main (String[]args){

        String[] strArray = new String[10];
        int[] intArray = new int[10];
        // brief recap on arrays and ArrayList
        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");


//        ArrayList<int> intArrayList = new ArrayList<int>(); //"type argument cannot be of primitive type". We need a class as an argument for ArrayLists

        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        // but that's messy and tangled up.
        // Fortunately, we have autoboxing : Java supports the primitive types by using object wrappers for classes
        //Integer intValue = new Integer(21);// unnecessary boxing, deprecated code, but...
        //Double dblValue = new Double(12.48);//... illustrates that we have built-in classes for primitive datatypes

        //When using boxing, we can now use shortcuts as shown below, and Java changes the code at compile time
        Integer myIntValue = 56; // Integer.valueOf(56); SEE LINE 41
        int myInt = myIntValue; //myIntValue.intValue(); SEE LINE 46

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            integerArrayList.add(Integer.valueOf(i)); //autboxing, converting an int to an Integer
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " -> " + integerArrayList.get(i).intValue()); //unboxing, taking an Integer instance to convert it into a primitive type
        }

        System.out.println("***************");

        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            doubleArrayList.add(dbl); //autoboxing is done by Java at compile time
        }

        for (int i = 0; i < doubleArrayList.size(); i++) {
            System.out.println(i + " --> " + doubleArrayList.get(i));//so is unboxing
        }

    }
}

class IntClass { //quick and dirty IntClass. A wrapper, myValue will hold the int value is wrapped up in a class, accessible through getters setters and constructors
    private int myValue;

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public IntClass(int myValue) {
        this.myValue = myValue;
    }
}