//draia, 23/08/2018

package masterclass;

import java.util.ArrayList;

public class Customer {

    private ArrayList<Double> transactions;
    private String name;
    private String accountNumber;
    private double initAmount;
    private double balance;

    public boolean addTransaction(double transAmount) {
        if (transAmount == 0) {
            System.out.println("No amount specified. Please try again.");
            return false;
        }
        balance += transAmount;
        transactions.add(transAmount);
        if(balance < 0) {
            balance -= transAmount;
            transactions.remove(transAmount);
            System.out.println("\nBalance insufficient. " + this.name + ", AN#: " + this.accountNumber +
                    ", may only withdraw $" + this.balance);
            return false;
        }
        System.out.println("\nTransaction processed. Amount: $" + transAmount + ". New balance is " + this.balance);
        return true;
    }

    public void getTransactions() {
        String transaction = "Transaction ";
        System.out.println("\n" + transaction + "history from account " + accountNumber + " owned by " + name);
        System.out.print("\n\tOpening deposit: " + initAmount);
        double newBalance = initAmount;

        for (int i = 0; i < transactions.size(); i++) {
            double amount = transactions.get(i);
            newBalance += amount;

            if(amount<0){
                transaction = "Debit";
            } else {
                transaction = "Credit";
            }
            System.out.print("\n\t" + transaction + ": " + amount + " (" + newBalance + ")");
        }
        System.out.println("\n\tCurrent balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer(String name, String accountNumber, double initAmount) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.initAmount = initAmount;
        this.balance += initAmount;
        this.transactions = new ArrayList<Double>();
    }
}
