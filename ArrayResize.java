package masterclass;

/*
Resizing an array
    then

ArrayList
    check out 'oracle java util list' for the official documentation
    lists are similar to arrays, they are ordered collections, sequences, controllable and accessible
        ArrayList is a class, a resizable-array implementation of the List interface.
            Yup, resizable.
 */

import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayResize {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[3];

    public static void main(String[] args) {

        System.out.println("Enter " + baseData.length + " integers:\r");
        getInput();
        printArray(baseData);

        resizeArray(4);
        baseData[3] = 99;

        printArray(baseData);

    }

    private static void getInput() {
        for (int i = 0; i <baseData.length ; i++) {
            baseData[i] = s.nextInt();
        }
    }

    private static void printArray(int[] array) {
        for (int n : array) {         //foreach, made by IntelliJ. Automatically iterates through an array
            System.out.print(n + " "); //for now, I'll assume that it's good to use it since it's an optimised built in method
        }
        System.out.println();
    }

    private static void resizeArray(int newLength) {
        int[] original = baseData;

        baseData = new int[newLength];

        /*
        IntStream.range(0, original.length).forEach(i -> baseData[i] = original[i]); //another foreach... what it your secret?
        */

        for (int i = 0; i < original.length; i++) { //using a for loop instead, that's witchcraft
            baseData[i] = original[i];
        }
    }
}
