package com.addressbooksystem;
import java.util.*;

public class AddressBookMain {
    private static List<ContactPerson> addressBook;
    private static Map<String, List<ContactPerson>> addressBookSystem = new TreeMap<>();
    public AddressBookMain() {
        addressBook = new ArrayList<>();
    }
    public static void addAddressBookToSystem(String addressBookName, List<ContactPerson> addressBook) {
        addressBookSystem.put(addressBookName, addressBook);
    }

    public static Map<String, List<ContactPerson>> getAddressBookSystem() {
        return addressBookSystem;
    }
    public static List<ContactPerson> getAddressBook() {
        return addressBook;
    }

    public void addContactPersonDetails(ContactPerson contactPerson) {
        addressBook.add(contactPerson);
    }
    public static void editContactPersonDetailsByName(String phoneBookName, String personName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            List<ContactPerson> list=new ArrayList<>();
            if(phBookName.equals(phoneBookName)) {
                for(ContactPerson contactPerson : phoneBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(!name.equals(personName)) {
                        list.add(contactPerson);
                    }
                    else
                    {
                        ContactPerson contactPersonDetails = addContactPersonDetails();
                        list.add(contactPersonDetails);
                    }
                }
                addAddressBookToSystem(phoneBookName,list);
            }
        }
    }

    public static void deleteContactPersonDetailsByName(String phoneBookName, String personName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            List<ContactPerson> list=new ArrayList<>();
            if(phBookName.equals(phoneBookName)) {
                for(ContactPerson contactPerson : phoneBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(!name.equals(personName)) {
                        list.add(contactPerson);
                    }
                }
                addAddressBookToSystem(phoneBookName,list);
            }
        }
    }
    public static void showAddressBookSystem() {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phoneBookName= me.getKey();
            System.out.println("The contact details of the "+phoneBookName);
            for(ContactPerson contactPerson: me.getValue()) {
                System.out.println(contactPerson);
            }
        }
    }
    public static ContactPerson addContactPersonDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name:");
        String firstName=sc.next();
        System.out.println("Enter the last name:");
        String lastName=sc.next();
        System.out.println("Enter the address:");
        sc.nextLine();
        String address=sc.nextLine();
        ContactPerson personDetails=new ContactPerson(firstName,lastName,address);
        return personDetails;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Address Book to be added:");
        int noOfAddressBook = sc.nextInt();
        for(int i=0;i<noOfAddressBook;i++) {
            System.out.println("Enter the name of the address book:");
            sc.nextLine();
            String addressBookName = sc.nextLine();

            System.out.println("Number of Person's details to be added:");
            int noOfPerson=sc.nextInt();

            AddressBookMain addressBookMain=new AddressBookMain();

            for(int j=0;j<noOfPerson;j++) {
                ContactPerson personDetails=addContactPersonDetails();
                addressBookMain.addContactPersonDetails(personDetails);
            }
            addressBookMain.addAddressBookToSystem(addressBookName,addressBook);
        }
        System.out.println("List of the person's details");
        showAddressBookSystem();

        System.out.println("Name of the address book in which person's details to be edited");
        sc.nextLine();
        String bookName=sc.nextLine();
        System.out.println("Name of the person whose details to be edited");
        String personName=sc.nextLine();
        editContactPersonDetailsByName(bookName,personName);
        System.out.println("List of the person's details after edition");
        showAddressBookSystem();
        System.out.println("Name of the address book from which person's details to be deleted");
        String bookName1=sc.nextLine();
        System.out.println("Name of the person whose details to be deleted");
        String personName1=sc.nextLine();
        deleteContactPersonDetailsByName(bookName1,personName1);
        System.out.println("List of the person's details after deletion:");
        showAddressBookSystem();
    }
}