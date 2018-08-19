package masterclass;

import java.util.Scanner;

/*
create a program using arrays that sorts a list of integers in descending order
set up the program so that the numbers are read in from the keyboard
printArray prints out the content of the array
sortIntegers should sort the array and return a new array containing the sorted numbers

the challenge resides mainly in
    copying the array elements from the passed array into a new array, sort them, and return the new sorted array
 */
public class ArrayChallengeDraft {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myArray = getInput(5);
        printArray(sortArray(myArray));

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

    public static int[] sortArray(int[] array) {
        int[] sortedArray = new int[array.length];
        int[] messyArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            messyArray[i] = array[i];
        }
                                    // It's been 3hours. I give up for now
        int greaterValue = 0;

        for (int i = 0; i < messyArray.length; i++) {

            for (int j = 0; j < messyArray.length; j++) {

                if(j == 0){
                    greaterValue = messyArray[j];
                    System.out.println("Iteration " + i + "." + j  + " gv#" + i + "= " + greaterValue);

                } else if((messyArray[j] - greaterValue) > 0) {

                    greaterValue = messyArray[j];
                    System.out.println("Iteration " + i + "." + j  + " gv#" + i + "= " + greaterValue);
                }

            }

            sortedArray[i] = greaterValue;
            messyArray[i] = Integer.MIN_VALUE;
        }
        System.out.println("Array sorted");
        return sortedArray;
    }
}
