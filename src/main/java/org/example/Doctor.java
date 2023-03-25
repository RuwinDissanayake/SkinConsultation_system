package org.example;

public class Doctor extends Person {
    private String specialisation;
    private int medicalLicenceNo;




    public Doctor(String firstName, String surname, int mobileNumber, String dateOfBirth, String specialisation, int medicalLicenceNo) {
        super(firstName, surname, dateOfBirth, mobileNumber);
        this.specialisation = specialisation;
        this.medicalLicenceNo = medicalLicenceNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public int getMedicalLicenceNo() {
        return medicalLicenceNo;
    }


}

