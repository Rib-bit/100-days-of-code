package com.example.maths;

public class Series {

    public static long nSum(int n) {
        //returns the sum of all numbers from 0 to n
        System.out.println("\n");
        if(n<0) {
            System.out.print("Invalid value");
            return -1;
        }

        System.out.print("nSum(" + n + ") : ");
        long x = 0;
        for (int i = 0; i<=n; i++) {
            x += i; // or x = (n*(n+1)/2);
            System.out.print("\n[" + i + "]" + x + " ");
        }
        System.out.print("\nresult: " + x);
        return x;
    }

    public static long factorial(int n) {
        //returns the product of all numbers from 1 to n
        System.out.println("\n");
        if(n<0) {
            System.out.print("Invalid value");
            return -1;
        }

        System.out.print("factorial(" + n + ") : ");
        long x = 1;
        for (int i = 0; i<=n; i++) {
            if(i==0){
                x = 1;
            } else {
                x *= i;
            }
            System.out.print("\n[" + i + "]" + x + " ");
        }
        System.out.print("\nresult: " + x);
        return x;
    }

    public static long fibonacci(int n) {
        //returns the nth Fibonacci number
        //f(0) = 0
        //f(1) = 1
        //f(2) = f(1) + f(0) = 1
        //f(n) = f(n-1) + f(n-2)
        System.out.println("\n");
        if (n < 0) {
            System.out.print("Invalid value");
            return -1;
        }

        System.out.print("fibonacci(" + n + ") : ");

        long x = 0;
        long nMinus1 = 1;
        long nMinus2 = 0;

        for (int i = 0; i <= n; i++) {


            if ((i == 0) || (i == 1)) {
                x = i;
            } else {
                x = (nMinus1 + nMinus2);
                nMinus2 = nMinus1;
                nMinus1 = x;
            }
            System.out.print("\n[" + i + "]" + x + " ");
        }

        System.out.print("\nresult: " + x);
        return x;
    }

    //then test in Main, copy, delete, produce a jar
    //create project MathsTest, add the Series library, and copy your Main to run the tests
}
