//draia, 23/08/2018
/*

 */
package masterclass;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public boolean addBranch(String location) {
        if(findBranch(location)>=0) {
            System.out.println("ERROR : branch already exists");
            return false;
        }

        System.out.println("\nBranch '" + location + "' added successfully");
        return branches.add(new Branch(location));
    }

    public boolean addCustomer(String location, String name, String accountNumber, double initAmount) {
        int i = findBranch(location);
        if(i>=0) {
            return branches.get(i).addCustomer(name, accountNumber, initAmount);
        }
        System.out.println("The " + location + " branch does not exist yet");
        return false;
    }

    public boolean addTransaction(String location, String id, double transAmount) {
        int i = findBranch(location);
        if(i>=0) {
            return branches.get(i).addTransaction(id, transAmount);
        }
        System.out.println("The " + location + " branch does not exist yet");
        return false;
    }

    public void queryCustomer(String location, String id) {
        int i = findBranch(location);
        if(i>=0) {
            branches.get(i).queryCustomer(id);
            return;
        }
        System.out.println("No such branch in this bank");
    }

    public void printCustomers(String location, boolean transactionDetail){
        int i = findBranch(location);
        if(i>=0) {
            branches.get(i).printCustomers(transactionDetail);
            return;
        }
        System.out.println("Could not find branch " + location);
    }

    public void printBranches(boolean customerDetail, boolean transactionDetail) {
        for (int i = 0; i < branches.size(); i++) {
            String branchName = branches.get(i).getLocation();
            System.out.println("\nBranch " + (i+1) + ":\n\tName= " + branchName);
            if(customerDetail){
                printCustomers(branchName, transactionDetail);
            }
        }
    }

    public void printHistory(String location, String id) {
        int i = findBranch(location);
        if(i>=0) {
            branches.get(i).printHistory(id);
            return;
        }
        System.out.println("The " + location + " branch does not exist yet");
    }

    public String getName() {
        return name;
    }

    private int findBranch(Branch branch) {
        return branches.indexOf(branch);
    }

    private int findBranch(String location) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getLocation().equals(location)) {
                return i;
            }
        }
        return -1;
    }

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
}
