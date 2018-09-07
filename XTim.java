package com.example.masterclass;

import java.util.Scanner;

public class XTim {
    private int x;

    public XTim(Scanner x) {
        System.out.println("Please enter an integer:");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x < 13; x++) {
            System.out.println(x + " times " + this.x + " equals " + (x * this.x));
        }
    }
}
