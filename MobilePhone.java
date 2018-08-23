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

import java.util.Scanner;

public class MobilePhone {

    private static Scanner scanner = new Scanner(System.in);

    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {

        boolean go = true;
        int choice;

        printInstructions();

        while (go) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    contacts.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    go = false;
                    break;
            }
        }
    }

    private static void printInstructions () {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts");
        System.out.println("\t 2 - To add a contact to the list");
        System.out.println("\t 3 - To modify a contact in the list");
        System.out.println("\t 4 - To remove a contact from the list");
        System.out.println("\t 5 - To search for a contact in the list");
        System.out.println("\t 6 - To quit the menu");
    }

    private static void addContact () {
        System.out.print("Please enter the contact name: ");
        String contactName = scanner.nextLine();
        System.out.print("Please enter the contact number: ");
        String contactNumber = scanner.nextLine();
        contacts.addContact(contactName, contactNumber);
    }

    private static void modifyContact () {
        System.out.print("Enter contact name or number: ");
        String currentContactData = scanner.nextLine();
        System.out.print("Enter replacement contact name or number: ");
        String newContactData = scanner.nextLine();

        contacts.modifyContact(currentContactData, newContactData);
    }

    private static void removeContact () {
        System.out.print("Enter contact name or number: ");
        String contact = scanner.nextLine();
        contacts.removeContact(contact);
    }

    private static void searchForContact () {
        System.out.print("Enter name or number to search for: ");
        String searchContact = scanner.nextLine();

        if ((contacts.onFileName(searchContact)) || (contacts.onFileNumber(searchContact))) {
            System.out.println("Found " + searchContact + " on file");
        } else {
            System.out.println(searchContact + " not on file");
        }
    }
}
