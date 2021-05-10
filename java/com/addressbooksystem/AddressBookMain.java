package com.addressbooksystem;
import java.util.*;

public class AddressBookMain {
    private List<ContactPerson> addressBook =new ArrayList<>();
    private static Map<String, List<ContactPerson>> addressBookSystem = new TreeMap<>();
    public List<ContactPerson> getAddressBook(){
        return addressBook;
    }

    public void addContactPersonDetails(ContactPerson contactPerson) {
        addressBook.add(contactPerson);
    }
    public static void addAddressBookToSystem(String addressBookName, List<ContactPerson> addressBook) {
        addressBookSystem.put(addressBookName, addressBook);
    }

    public static boolean isPresentAddressBook(String phoneBookName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            if(phBookName.equals(phoneBookName))
                return true;
        }
        return false;
    }

    public static boolean editContactPersonDetailsByName(String phoneBookName, String personName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            if(phBookName.equals(phoneBookName)) {
                for(ContactPerson contactPerson : phoneBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(name.equals(personName)) {
                        phoneBook.remove(contactPerson);
                        ContactPerson contactPerson1 =addContactPersonDetails();
                        phoneBook.add(contactPerson1);
                        addAddressBookToSystem(phoneBookName,phoneBook);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean deleteContactPersonDetailsByName(String phoneBookName, String personName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            if(phBookName.equals(phoneBookName)) {
                for(ContactPerson contactPerson : phoneBook)
                {
                    String name=contactPerson.getFirstName()+" "+contactPerson.getLastName();
                    if(name.equals(personName)) {
                        phoneBook.remove(contactPerson);
                        addAddressBookToSystem(phoneBookName,phoneBook);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void showAddressBook(String phoneBookName) {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            if(phBookName.equals(phoneBookName)) {
                if(phoneBook.size()==0) {
                    System.out.println("Sorry, there is no contact left in the "+phoneBookName+" after deletion.");
                    break;
                }
                else {
                    System.out.println("The contact details of the "+phoneBookName+":");
                    for(ContactPerson contactPerson: phoneBook) {
                        System.out.println(contactPerson);
                    }
                    break;
                }
            }
        }
    }

    public static void showAddressBookSystem() {
        for(Map.Entry<String, List<ContactPerson>> me : addressBookSystem.entrySet()) {
            String phoneBookName= me.getKey();
            List<ContactPerson> phoneBook=me.getValue();
            System.out.println("The contact details of the "+phoneBookName+":");
            if(phoneBook.size()==0) {
                System.out.println("Sorry, there is no contact in the "+phoneBookName+".");
            }
            else {
                for(ContactPerson contactPerson: phoneBook) {
                    System.out.println(contactPerson);
                }
            }
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

        Scanner sc=new Scanner(System.in);
        System.out.println("Number of Address Book to be added:");
        int noOfAddressBook = sc.nextInt();

        for(int i=0;i<noOfAddressBook;i++) {
            System.out.println("Enter the details of the Address Book "+(i+1));
            System.out.println("Enter the name of the address book:");
            sc.nextLine();
            String addressBookName = sc.nextLine();

            System.out.println("Enter the number of person's details to be added:");
            int noOfPerson=sc.nextInt();

            AddressBookMain addressBookMain=new AddressBookMain();
            for(int j=0;j<noOfPerson;j++) {
                System.out.println("Enter the details of the Contact Person "+(j+1));
                ContactPerson personDetails=addContactPersonDetails();
                addressBookMain.addContactPersonDetails(personDetails);
            }

            List<ContactPerson> addressBook = addressBookMain.getAddressBook();
            addAddressBookToSystem(addressBookName,addressBook);
        }

        System.out.println("List of the address book(s):");
        showAddressBookSystem();

        System.out.println("Enter the name of the address book in which person's details to be edited:");
        sc.nextLine();
        String bookName=sc.nextLine();
        if(isPresentAddressBook(bookName)) {
            System.out.println("Enter the name of the person whose details to be edited:");
            while(true) {
                String personName=sc.nextLine();
                boolean result= editContactPersonDetailsByName(bookName,personName);
                if(result) {
                    System.out.println("The contact details of the "+personName+" from "+bookName+" is edited.");
                    showAddressBook(bookName);
                    break;
                }
                else {
                    System.out.println("Sorry, the contact details of the "+personName+" is not found in "+bookName+".");
                    System.out.println("Please, enter the correct name:");
                    continue;
                }
            }
        }
        else
            System.out.println("Sorry, the "+bookName+" is not found in the system. We can't proceed to edit.");

        System.out.println("Enter the name of the address book from which person's details to be deleted:");
        String bookName1=sc.nextLine();
        if(isPresentAddressBook(bookName1)) {
            System.out.println("Enter the name of the person whose details to be deleted:");
            while(true) {
                String personName1=sc.nextLine();
                boolean result= deleteContactPersonDetailsByName(bookName1,personName1);
                if(result) {
                    System.out.println("The contact details of the "+personName1+" from "+bookName1+" is deleted.");
                    showAddressBook(bookName1);
                    break;
                }
                else {
                    System.out.println("Sorry, the contact details of the "+personName1+" is not found in "+bookName1+".");
                    System.out.println("Please, enter the correct name:");
                    continue;
                }
            }
        }
        else
            System.out.println("Sorry, the "+bookName1+" is not found in the system. We can't proceed to delete.");
    }
}
