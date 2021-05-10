package com.addressbooksystem;

public class ContactPerson {
    public String firstName, lastName, address, city, state;
    public int zip;
    public long phoneNo;
    public  String emailId;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }
    public ContactPerson(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
        @Override
        public String toString() {
            return "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                    + city + ", state=" + state + ", zip=" + zip + ", phoneNo=" + phoneNo + ", emailId=" + emailId;
        }
    }
