//draia, 22/08/2018
/*
Mobile phone needs to be able to store, modify, remove, and query contactNames
name + phone number in contactNames
phone holds the arraylist of contactNames
add a menu of available options to the phone
    quit, print list of contactNames, add new contact, update existing contact, remove contact, search/find contact
Check for existing contact before adding
Check for existing contact before modifying

Encapsulation! do not reveal the inner workings of Contacts in MobilePhone
 */
package masterclass;

import java.util.ArrayList;

public class Contacts {

    public ArrayList<String> contactNames = new ArrayList<String>();
    public ArrayList<String> contactNumbers = new ArrayList<String>();

    public void printContacts() {
        System.out.println("You have " + contactNames.size() + " contact in your phone book");
        for (int i = 0; i < contactNames.size(); i++) {
            System.out.println((i+1) + " : " + contactNames.get(i) + " - " + contactNumbers.get(i));
        }
    }

    public void addContact(String contactName, String contactNumber) {
        int indexName = findContactName(contactName);
        int indexNumber = findContactNumber(contactNumber);

        if((contactName == "") && (contactNumber == "")) {
            System.out.println("No data entered.");
        } else if((indexName < 0) && (indexNumber < 0)) {
            contactNames.add(contactName);
            contactNumbers.add(contactNumber);
            System.out.println("Contact " + contactName + " has been added with number " + contactNumber);
        } else if((indexName < 0) && (indexNumber >= 0) || ((contactName != "") && (contactNumber == ""))) {
            contactNames.add(contactName);
            contactNumbers.add("no number");
            System.out.println("Contact " + contactName + " has been added without a number");
        } else if((indexName >= 0) && (indexNumber < 0) || ((contactName == "") && (contactNumber != ""))) {
            contactNames.add("no name");
            contactNumbers.add(contactNumber);
            System.out.println("Number " + contactNumber + " has been added without a name");
        } else if ((indexName >= 0) && (indexNumber >= 0)){
            System.out.println("Contact " + contactName + " already exists with number " + contactNumber);
        }
    }

    public void modifyContact(String currentContactData, String newContactData) {
        int indexName = findContactName(currentContactData);
        int indexNumber = findContactNumber(currentContactData);

        if((indexName >= 0) || (indexNumber >= 0)) {
            System.out.println("Contact " + currentContactData + " is being processed");
        }
        if(indexName >= 0) {
            modifyContact(indexName, newContactData);
        } else if(indexNumber >= 0) {
            modifyContact(indexNumber, newContactData);
        } else {
            System.out.println("Contact " + currentContactData + " doesn't exist");
        }
    }

    private void modifyContact(int currentContact, String newContact) {
        if(((findContactName(newContact))>=0) || (findContactNumber(newContact))>=0) {
            System.out.println("contact name or number already exists");
            return;
        }

        if(newContact.matches("[0-9]+")){
            contactNumbers.set(currentContact, newContact);
        } else {
            contactNames.set(currentContact, newContact);
        }
    }

    public void removeContact(String contact) {
        int indexName = findContactName(contact);
        int indexNumber = findContactNumber(contact);
        if(indexName >= 0) {
            removeContact(indexName);
            System.out.println("Contact name " + contact + " has been removed");
        } else if( indexNumber >= 0) {
            removeContact(indexNumber);
            System.out.println("Contact number " + contact + " has been removed");
        } else if((indexName < 0) && (indexNumber < 0)){
            System.out.println("Contact " + contact + " doesn't exist");
        }
    }

    private void removeContact(int index) {
        contactNames.remove(index);
        contactNumbers.remove(index);
    }

    public boolean onFileName(String contact) {
        int index = contactNames.indexOf(contact);
        if(index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onFileNumber(String contact) {
        int index = contactNumbers.indexOf(contact);
        if(index >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int findContactName(String contact) {
        return contactNames.indexOf(contact);
    }

    public int findContactNumber(String contact) {
        return contactNumbers.indexOf(contact);
    }
}
