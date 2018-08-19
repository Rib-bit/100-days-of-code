package masterclass;

import java.util.Scanner;

//Arrays allow us to store multiple values *of the same type*. Multi-core variable
public class Arrays {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int myVariable = 50;

        // int[] myIntArray = new int[10]; //'new', datatype, number of values to be stored
        // myIntArray[5] = 50; //'50' is placed in position 6, because arrays are zero-indexed. myIntArray ranges from 0 to 9

        //int[] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //initialising all values in an array is possible when declaring the array



        int [] myIntArray = new int[30];
        for (int i = 0; i <myIntArray.length; i++) { //initialising all values in the array is also often done using a for loop
            myIntArray[i] = i * 10;
            // System.out.println("Element " + i + ", value is " + myIntArray[i]);
        }

        System.out.println(myIntArray.length); // the 'length' property is useful for limiting code maintenance. I can change the number of elements in the array and not worry about it

        double[] myDoubleArray = new double[17];
        printArray(myDoubleArray);

        int[] myIntegers = getIntegers(5); // or use a scanner to let the user fill it in
        for (int i = 0; i < myIntegers.length; i++) {
            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }
        System.out.println("The average is " + getAverage(myIntegers)); //and why not do some stuff with that data too
    }

    public static void printArray(double[] array) {
        for (int i = 0; i <array.length; i++) { //delegating that work to a method can make that code reusable for all double[] arrays
            array[i] = i * 2.19;
            //System.out.println("Element " + i + ", value is " + array[i]);
        }
    }

    public static int[] getIntegers(int number) { //temporarily set to 5 in the method call above
        System.out.println("Enter " + number + " integer values.\r"); //prompting the user to enter 5 values. '\r' is for next line
        int[] values = new int[number]; // creating a throw-away array with the input stored inside

        for (int i = 0; i < values.length ; i++) {
            values[i] = scanner.nextInt();
        }
        return values; //transferring the array to myIntegers, the external array
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double average = (double) sum / array.length;
        return average;
    }
}
