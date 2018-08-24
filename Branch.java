//draia, 23/08/2018

package masterclass;

import java.util.ArrayList;

public class Branch {

    private String location;
    private ArrayList<Customer> customers;

    public boolean addCustomer(String name, String accountNumber, double initAmount) {
        if((findCustomer(name)>=0) || (findCustomer(accountNumber)>=0)) {
            System.out.println("ERROR : Customer name or account number already exists");
            return false;
        }

        System.out.print("\nCustomer '" + name + "' added successfully");
        return customers.add(new Customer(name, accountNumber, initAmount));
    }

    public boolean addTransaction(String id, double transAmount) {
        int i = findCustomer(id);
        if(i>=0) {
            return customers.get(i).addTransaction(transAmount);
        }
        System.out.println("Customer not found. Please check customer id");
        return false;
    }

    public void queryCustomer(String id) {
        int i = findCustomer(id);
        if (i>=0) {
            Customer queried = customers.get(i);
            System.out.println("Customer " + queried.getName() +
                    " (AN# : " + queried.getAccountNumber() + ") was found." +
                    " Their account holds " + queried.getBalance());
            return;
        }
          System.out.println("No such customer in the " + location + " branch");
      }

    public void printCustomers(boolean transactionDetail) {
        for (int i = 0; i < customers.size(); i++) {
            Customer queried = customers.get(i);
            System.out.println("\nCustomer " + (i+1) + ":\n\tName= " + queried.getName() +
                    "\n\tAN= " + queried.getAccountNumber() +
                    "\n\tBalance= " + queried.getBalance());
            if(transactionDetail) {
                printHistory(queried.getName());
            }
        }
    }

    public void printHistory(String id) {
        int i = findCustomer(id);
        if(i>=0) {
            customers.get(i).getTransactions();
            return;
        }
        System.out.println("Customer not found. Please check customer id");
    }

    public String getLocation() {
        return location;
    }

    private int findCustomer(String id) {
        for (int i = 0; i < customers.size(); i++) {
            Customer queried = customers.get(i);
            if ((queried.getName().equals(id)) || (queried.getAccountNumber().equals(id))) {
                return i;
            }
        }
        return -1;
    }

    private int findCustomer(Customer customer) {
        return customers.indexOf(customer);
    }

    public Branch(String location) {
        this.location = location;
        this.customers = new ArrayList<Customer>();
    }
}
