package com.example.masterclass;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

    /*@Override
    public void storePassword() {
        System.out.println("Saving password as " + this.decryptedPassword);
    } not possible with a final method*/
}
