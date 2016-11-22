package ru.olga.addressbook.model;

public class AddressData {
    private final String street;
    private final String phoneNumber;
    private final String emailAdress;

    public AddressData(String street, String phoneNumber, String emailAdress) {
        this.street = street;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;
    }

    public String getStreet() {
        return street;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }
}
