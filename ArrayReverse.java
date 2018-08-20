package masterclass;

import java.util.Arrays;

public class ArrayReverse{

    public static void main(String[] args) {
        int[] intArray = {5, 8, 4, 1, 7};

        reverse(intArray);
    }

    public static void reverse(int[] array){
        int[] reversed = new int[array.length];

        for (int i = array.length-1; i >= 0 ; i--) {
            reversed[(array.length-1)-i] = array[i];
        }

        System.out.println("original: " + Arrays.toString(array));
        System.out.println("reversed: " + Arrays.toString(reversed));
    }
}
/*
            Tim's solution - half as many iterations, quite elegantly done sir.

package masterclass;

public class ArrayReverse{

    public static void main(String[] args) {

        int[] array = {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);
        System.out.println("Reversed array = " + Arrays.toString(array));
    }

    private static void reverse(int[] array){

        int maxIndex = array.length - 1;
        int halfLength = array.length / 2; //if we don't use halfLength, we end up reversing all the reversed elements back to their original positions before the loop stops

        for(int i=0; i<halfLength; i++) {
            int temp = array[i];                //again, using a temp to swap elements around in an array. I'd better remember that
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = int temp;
        }
    }

}
 */