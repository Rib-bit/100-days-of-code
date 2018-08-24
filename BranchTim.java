package masterclass;

import java.util.ArrayList;

public class BranchTim {
    private String name;
    private ArrayList<CustomerTim> customers;

    public BranchTim(String name) {
        this.name = name;
        this.customers = new ArrayList<CustomerTim>();
    }

    public String getName() {
        return name;
    }

    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new CustomerTim(customerName, initialAmount));
            return true;
        }
        System.out.println("ERROR: customer already on file");
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        CustomerTim existingCustomer = findCustomer(customerName);

        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        return false;
    }

    private CustomerTim findCustomer(String customerName) {
        for (int i = 0; i < customers.size(); i++) {
            CustomerTim checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }

    public ArrayList<CustomerTim> getCustomers() {
        return customers;
    }
}
