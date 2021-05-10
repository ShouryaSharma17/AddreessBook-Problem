package com.addressbooksystem;
import java.util.*;

public class AddressBookMain {
    public ContactPerson contactPerson;
    public List<ContactPerson> addressBook = new ArrayList<>();

    public List<ContactPerson> getAddressBook() {
        return addressBook;
    }

    public void addContactPersonDetails(ContactPerson contactPerson) {
        addressBook.add(contactPerson);
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void editContactPersonDetailsByName(String name) {
        int count=0;
        for(ContactPerson contactPerson: addressBook) {
            String personName=contactPerson.getFirstName()+" "+contactPerson.getLastName();
            if(name.equals(personName)) {
                contactPerson = AddressBookMain.addContactPersonDetails();
                addressBook.set(count,contactPerson);
                System.out.println("Contact Deatails of the person: "+name+" is edited");
                break;
            }
            count++;
        }
    }

    public void deleteContactPersonDetailsByName(String name) {
        int count=0;
        for(ContactPerson contactPerson: addressBook) {
            String personName=contactPerson.getFirstName()+" "+contactPerson.getLastName();
            if(name.equals(personName)) {
                addressBook.remove(count);
                System.out.println("Contact Details of the person: "+name+" is deleted");
                break;
            }
            count++;
        }
    }

    public static ContactPerson addContactPersonDetails(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName=sc.next();
        System.out.println("Enter the last name:");
        String lastName=sc.next();
        System.out.println("Enter the address:");
        sc.nextLine();
        String address=sc.nextLine();
        System.out.println("Enter the city:");
        String city=sc.nextLine();
        System.out.println("Enter the state:");
        String state=sc.nextLine();
        System.out.println("Enter the zip:");
        int zip=sc.nextInt();
        System.out.println("Enter the phoneNo:");
        long phoneNo=sc.nextLong();
        System.out.println("Enter the email:");
        String emailId=sc.next();

        ContactPerson personDetails=new ContactPerson(firstName,lastName,address,city,state,zip,phoneNo,emailId);
        return personDetails;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        AddressBookMain addressBookMain=new AddressBookMain();

        System.out.println("Number of Person's details to be added:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++) {
            ContactPerson personDetails=addressBookMain.addContactPersonDetails();
            addressBookMain.addContactPersonDetails(personDetails);
        }

        System.out.println("List of the person's details");
        for(ContactPerson contactPerson: addressBookMain.getAddressBook()) {
            System.out.println(contactPerson);
        }

        System.out.println("Name of the person whose details to be edited");
        sc.nextLine();
        String name=sc.nextLine();
        addressBookMain.editContactPersonDetailsByName(name);

        for(ContactPerson contactPerson: addressBookMain.getAddressBook()) {
            System.out.println(contactPerson);
        }

        System.out.println("Name of Person whose details to be deleted:");
        String deleteName=sc.nextLine();
        addressBookMain.deleteContactPersonDetailsByName(deleteName);

        System.out.println("Person's details after deletion:");
        for(ContactPerson contactPerson: addressBookMain.getAddressBook()) {
            System.out.println(contactPerson);
        }
    }
}