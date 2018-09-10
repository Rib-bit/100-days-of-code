package com.example.masterclass;

/*
Map is separate from the Collections framework

A Map holds key and value pairs. Like a dictionary, with key being words and values being definitions. Unlike a dictionary, a Map may not
contain duplicate keys and each key can only contain one value

    HashMap and LinkedHashMap implement the Map interface. We'll also look at TreeMap.

    Like all the core Collections interfaces, Maps are generic. They take two types. You can use raw Maps (without specified types), but you'd need a good reason
 */

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        /*java.util.Map<String, String> languages = new HashMap<>(); *///If using a reserved word for a class name, you can type in the complete import declaration
        //to get around the problem

        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "a compiled, high-level, object-oriented, platform independent language");
        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All-purpose Symbolic Instruction Code");
        languages.put("Lisp", "therein lies madness");


        System.out.println(languages.get("Java"));
        //in maps, keys are unique. If we try to use the same key again, the value gets overridden. Like index in arrays
       /* languages.putIfAbsent("Java", "this course is about Java");
        System.out.println(languages.get("Java"));*/

        //the put() method returns a null value if the key is new, and returns the previous value if the key already exists
        //this could be used in validation to ensure nothing is inadvertently overridden
        //we could also use the putIfAbsent() method, although it will not even override a null value. Good to prevent concurrency issues
        //another option is to use the languages.containsKey() method in your validation code


        System.out.println("========================");

        //languages.remove("Lisp"); //the remove() method does what it says on the tin. returns the value to be removed
        if(languages.remove("Algol", "a family of algorithmic languages")) { //we can also pass remove() the key AND value, which makes it return a boolean!
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed: key and value pair not found");
        }

        languages.replace("Lisp", "a functional programming language with imperative features");
        languages.replace("Scala", "this will not be added");//returns the value to be replaced
        //to get a boolean returned, we may pass replace() the key, old value, and new value. It also make double sure you're replacing the right value ^^'


        for(String key : languages.keySet()) { //keySet() returns a list of all the keys in a Map
            System.out.println(key + " : " + languages.get(key));//records are stored in no obvious order, though...
        }

        /*
        Map can use any objects as types. No requirement that the keys be immutable (like Strings and Integers)
        But great care must be exercised if mutable objects are used as map keys. A Map object can behave unpredictably
        if the key objects change in such a way that equals comparisons are affected.

        A Map may not contain itself as a key, but it may contain another Map as a key
         */

    }
}
