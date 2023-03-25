package org.example;

public class Patient extends Person {
    private int uniqueID;
    public Patient(String firstName, String surname, String dateOfBirth, int mobileNumber, int uniqueID) {
        super(firstName, surname, dateOfBirth, mobileNumber);
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return uniqueID;
    }


}
