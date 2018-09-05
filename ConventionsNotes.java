package com.example.masterclass;

public class ConventionsNotes {

    /*
    Naming conventions do what you would expect, standardising Java and making it easier for others and yourself to read and maintain code

    We will look at how we name packages, classes, interfaces, methods, constants, variables, type parameters

    Packages
        always lower case
        name should be unique
        should use your domain name, reversed, as a prefix.
        check out for more on that: http://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7
            replace invalid characters with an underscore; same with number as first character, or Java keywords
                Switch.suplier.com --> com.supplier._switch
                1world.com --> com._1world
                Experts-exchange.com --> com.experts_exchange

    Classes
        always CamelCase (first word capitalised too)
        should be nouns

    Interfaces
        always CamelCase too
        should represent what the implementers will become, or what they'll be able to do
            (List, Comparable, Serializeable...)

    Methods
        always mixedCase
        should be verbs most of the time, representing the result or the function performed (size(), getName()...)

    Constants
        always ALL_CAPS separated with underscore
        declared with the 'final' keyword

    Variables
        always mixedCase
        should be meaningful and indicative
        never use underscores

    Type parameters
        always single character, capital letter
        more on that at https://docs.oracle.com/javase/tutorial/generics/types.html
            E : element, used extensively by the Java Collections Framework
            K : key
            N : number
            T : type
            V : value
            S, U, V, etc. : 2nd, 3rd, 4th types
     */
}
