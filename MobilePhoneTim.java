package masterclass;

import java.util.ArrayList;

public class MobilePhoneTim {
    private String myNumber;
    private ArrayList<ContactsTim> myContacts; //OOooooooh an array of classes! mmmMMMmmmh...

    public MobilePhoneTim(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<ContactsTim>();
    }

    public boolean addNewContact(ContactsTim contact) {
        if(findContact(contact.getContactName()) >= 0) {
            System.out.println("contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(ContactsTim oldContact, ContactsTim newContact) {
        int foundPosition = findContact(oldContact);
        if(foundPosition<0) {
            System.out.println(oldContact.getContactName() + " was not found");
            return false;
        } else if(findContact(newContact.getContactName()) != -1) {
            System.out.println("Contact with name " + newContact.getContactName() +
                    " already exists. Update failed.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getContactName() + " was replaced with " + newContact.getContactName());
        return true;
    }

    public boolean removeContact(ContactsTim contact) {
        int foundPosition = findContact(contact);
        if(foundPosition<0) {
            System.out.println(contact.getContactName() + " was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getContactName() + " was deleted");
        return true;
    }

    private int findContact(ContactsTim contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i = 0; i < myContacts.size() ; i++) {
            ContactsTim contact = this.myContacts.get(i);
            if(contact.getContactName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public ContactsTim queryContact(String name) {
        int position = findContact(name);
        if(position>=0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public String queryContact(ContactsTim contact) {
        if(findContact(contact) >= 0) {
            return contact.getContactName();
        }
        return null;
    }

    public void printContacts() {
        System.out.println("Contact List");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i+1) + "." +
                    this.myContacts.get(i).getContactName() + "->" +
                    this.myContacts.get(i).getContactNumber());
        }
    }
}


