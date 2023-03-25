package org.example;

public class Person {
    protected String Firstname;
    protected String surname;
    protected String dateOfBirth;
    protected int mobileNumber;
    public Person(String name, String surname, String dateOfBirth, int mobileNo) {
        this.Firstname = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNo;
    }


    public String getFirstName() {
        return Firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }


}
