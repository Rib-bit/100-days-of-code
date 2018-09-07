package com.example.masterclass;
/*
Access control is granted both at the top level and at the member level

    At the top level, you can make your classes and interfaces (and enums) public, or package-private. e.g. you can't make a class private at the tp level.
        Everything else must be included within one of these
            Public means public, accessible to all classes everywhere; in the same package, or after importing the package
            Package-private is public, but only within its own package. No 'package-private' keyword

    At the member level (within the class itself)
        Public has the same meaning as in the top level.
        Package-private has the same meaning as in the top level.
            Private : the object is only visible within the class it is declared in.
                Not even visible in subclasses of its class
            Protected : the object visible anywhere in its own package,
                But also in subclasses even if they are in another package

 */
public class AccessModifiers {
    public static void main(String[] args) {

        Account a = new Account("My account");
        a.deposit(1000);
        a.withdraw(500);
        a.withdraw(-200);
        a.deposit(-20);
        a.calculateBalance();
//        a.balance = 5000;             //without declaring the fields as private, they can be accessed and modified from outside
//        a.transactions.add(4500);     //balance and transactions, here, should only be modified through the proper channels

        a.calculateBalance();
        System.out.println("Balance on account is " + a.getBalance());

    }
}
