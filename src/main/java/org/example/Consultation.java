package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Consultation {

    private Patient patient;
    private Doctor doctor;
    public  int consultationNo = 0;
    private int consultationCost;
    private  Date AppointmentDate;
    private String notes;

    private File File;
    public static ArrayList<Consultation> Appointments = new ArrayList<>();


    public Consultation(Patient patient, Doctor doctor, int consultationAmount, String notes, int consultationNo, File FileUser, Date consultationDate ){
        this.patient = patient;
        this.doctor = doctor;
        this.consultationCost = consultationAmount;
        this.notes = notes;
        this.consultationNo = consultationNo;
        this.AppointmentDate = consultationDate;
        this.File = FileUser;

    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getConsultationNo() {
        return consultationNo;
    }

    public int getConsultationCost() {
        return consultationCost;
    }

    public Date getAppointmentDate() {
        return AppointmentDate;
    }

    public String getNotes() {
        return notes;
    }

}
