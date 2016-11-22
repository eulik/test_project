package ru.olga.addressbook.model;

public class PersonalData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String byear;

    public PersonalData(String firstname, String middlename, String lastname, String nickname, String byear) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.byear = byear;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getByear() {
        return byear;
    }
}
