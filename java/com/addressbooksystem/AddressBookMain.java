package com.addressbooksystem;
import java.util.*;

public class AddressBookMain {
    public ContactPerson contactPerson;

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public ContactPerson editContactPersonDetailsByName(String name) {
        String personName=contactPerson.getFirstName()+" "+contactPerson.getLastName();
        if(name.equals(personName)) {
            contactPerson = AddressBookMain.addContactPersonDetails();
        }
        return contactPerson;
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
        ContactPerson contactPerson=AddressBookMain.addContactPersonDetails();
        addressBookMain.setContactPerson(contactPerson);
        System.out.println(contactPerson);

        System.out.println("Name of the person whose details to be edited");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println(addressBookMain.editContactPersonDetailsByName(name));
    }
}