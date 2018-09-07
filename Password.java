package com.example.masterclass;

public class Password {

    private static final int key = 748576362;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        return password ^ key; //X or (?)
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }
    //the problem here is that someone could override the storePassword() method in a subclass, and compromise the encryption

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope");
            return false;
        }
    }
}
