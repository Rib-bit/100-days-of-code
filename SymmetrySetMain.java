package com.example.masterclass;

/*
looking at the remaining mathematical operations that can be performed on sets
    we already know about addAll() for a union
    what about the other 'bulk operations' for sets?
            https://docs.oracle.com/javase/tutorial/collections/interfaces/set.html

            Set<Type> s1 = new HashSet<Type>();         UNION
            union.addAll(s2);

                                                        UNION-INTERSECTION = SYMMETRIC DIFFERENCE

            Set<Type> s1 = new HashSet<Type>();         INTERSECTION
            intersection.retainAll(s2);

            Set<Type> s1 = new HashSet<Type>();         DIFFERENCE (ASYMMETRIC)
            difference.removeAll(s2);

            Set<Type> s1 = new HashSet<Type>();         IS_SUBSET
            checkSubset.containsAll(s2);
 */

import java.util.*;

public class SymmetrySetMain {

    public static void main(String[] args) {

        Set<Integer> squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println(squares.size() + " elements in squares");//100
        System.out.println(cubes.size() + " elements in cubes");//100

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println(union.size() + " elements in union");//196 distinct elements
        System.out.println(squares.size() + " elements in squares now");//100
        System.out.println(cubes.size() + " elements in cubes now");//100

        //all bulk operations in sets are destructive, we created a new hashset containing the elements of square to preserve the original
        //nearly all collection classes have constructors that can take another collection and use the elements within to populate the new one

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println(intersection.size() + " elements in intersection");//4 common elements

        for (int i : intersection) {//here they are, in no particular order
            System.out.println(i + " is square of " + Math.sqrt(i) + " :and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));// asList() is intended to make a bridge between the two APIs
        //it provides a convenient way to initialise a collection with a list of values

        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "is", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        System.out.println("_________________________");
        System.out.println("nature - divine = ");

        printSet(diff1);

        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);

        System.out.println("divine - nature = ");

        printSet(diff2);

        Set<String> intersection2 = new HashSet<>(divine);
        intersection2.retainAll(nature);

        System.out.println("divine & nature = ");

        printSet(intersection2);

        Set<String> union2 = new HashSet<>(divine);
        union2.addAll(nature);

        System.out.println("divine + nature = ");

        printSet(union2);

        union2.removeAll(intersection2);

        System.out.println("divine + nature - (divine & nature) = ");

        printSet(union2);

        System.out.println("intersection2 is a subset of divine: " + divine.containsAll(intersection2));
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
