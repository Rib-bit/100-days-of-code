package masterclass;

import java.util.ArrayList;

public class BankTim {
    private String name;
    private ArrayList<BranchTim> branches;

    public BankTim(String name) {
        this.name = name;
        this.branches = new ArrayList<BranchTim>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new BranchTim(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        BranchTim branch = findBranch(branchName);  //we leave the customer check to the branch : not putting a whole bunch of validation in one place is key...
        if (branch != null) { //...validating only a specific thing in a specific area, making it easier to maintain and understand, like a blackbox
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        BranchTim branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount); //thanks to the boolean return type, we can save lines here
        }
        return false;
    }

    private BranchTim findBranch(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            BranchTim checkedBranch = this.branches.get(i);
            if ((checkedBranch).getName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        BranchTim branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<CustomerTim> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {          // this will also handle an ArrayList of size 0 :)
                CustomerTim branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
