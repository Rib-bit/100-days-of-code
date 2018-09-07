package com.example.masterclass;

import java.util.Scanner;

public class X {

    Scanner x = new Scanner(System.in);

    public X() {
        System.out.println("created a new instance of class X");
    }

    public void x() {
        System.out.println("Enter an integer value:");

        int[] x = new int[2];
        x[0] = this.x.nextInt();

        for (x[1] = 1; x[1] < 13; x[1]++) {
            System.out.println(x[0] + " times " + x[1] + " equals " + (x[0] * x[1]));
        }
        this.x.nextLine();
    }
}
