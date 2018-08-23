package masterclass;

public class ContactsTim {
    private String contactName;
    private String contactNumber;

    public static ContactsTim createContact(String contactName, String contactNumber) {//static because convenience method, 'factory' method
        return new ContactsTim(contactName, contactNumber);//will allow us to create a new contact class without having an instance or an object to call the method on
    }

    public ContactsTim(String contactName, String contactNumber) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
