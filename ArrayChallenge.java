package masterclass;

import java.util.Arrays;
import java.util.Scanner;

/*
create a program using arrays that sorts a list of integers in descending order
set up the program so that the numbers are read in from the keyboard
printArray prints out the content of the array
sortIntegers should sort the array and return a new array containing the sorted numbers

the challenge resides mainly in
    copying the array elements from the passed array into a new array, sort them, and return the new sorted array
 */
public class ArrayChallenge {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myArray = getInput(5);
        int[] sortedArray = sortIntegers(myArray);
        printArray(sortedArray);
    }

    public static int[] getInput(int number) {
        System.out.println("Enter " + number + " integer values for sorting.\r");
        int[] values = new int[number];

        for (int i = 0; i < number; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", typed as " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            sortedArray[i] = array[i];
//        }
        // Here's an inbuilt method for this

        int[] sortedArray = Arrays.copyOf(array, array.length); //heavily optimised builtin methods save the dev and the user a lot of time

        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;

            for (int i = 0; i < sortedArray.length-1; i++) { //length-1 because of i+1 below

                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                    /*
                    init:2 7 4 56 24
                    1.0:7 2 4 56 24
                    1.1:7 4 2 56 24
                    1.2:7 4 56 2 24
                    1.3:7 4 56 24 2

                    2.0:""
                    2.1:7 56 4 24 2
                    etc. Would have needed to sleep on it, at least, to come up with that one. Arrays are cool but man am I rusty!
                     */
                }
            }
        }
        return sortedArray;
    }
}
