package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class WestministerSkinConsultationManager implements SkinConsultationManager {

    public static ArrayList<Doctor> doctors =  new ArrayList<Doctor>(10);



    static void addNewDoctor(){
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter First Name: ");
            String FirstName = scanner.nextLine();
            System.out.print("Enter Surname: ");
            String SurName = scanner.nextLine();
            System.out.print("Enter Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter Date Of Birth : ");
            String DateOfBirth = scanner.nextLine();
            System.out.print("Enter Mobile Number: ");
            int MobileNumber = scanner.nextInt();
            System.out.print("Enter Medical Licence No: ");
            int medicalLicenceNo = scanner.nextInt();

            Doctor doctor = new Doctor(FirstName,SurName,MobileNumber,DateOfBirth,specialization,medicalLicenceNo);
            if (doctors.size() < 10){
                doctors.add(doctor);
            } else {
                System.out.println("Maximum allowed number of doctors is 10!!");
            }
        }
        catch (Exception e){
            System.out.println("Invalid Input");
            addNewDoctor();
        }

    }

    static void deleteDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Medical Licence No: ");
        int medicalLicense = scanner.nextInt();
        for (int i = 0; i < doctors.size(); i++){
            if (doctors.get(i).getMedicalLicenceNo() == medicalLicense){

                System.out.println("Full Name of Doctor :" + doctors.get(i).getFirstName() + doctors.get(i).getSurname() + "\n Medical ID of Doctor:" + doctors.get(i).getMedicalLicenceNo() + "is deleted");
                doctors.remove(i);
                System.out.println("remaining doctor amount:" + doctors.size());

            }
            else {
                System.out.println("Invalid Medical License no.!!!");
            }
        }
    }

    protected static void printDoctors(){
        Collections.sort(doctors, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());}
        });
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println("Full Name of Doctor: " +doctors.get(i).getFirstName() +" " +doctors.get(i).getSurname() + "\n Medical Licence No:  " + doctors.get(i).getMedicalLicenceNo());
        }
    }

    static void PrintBackFromFile(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("DataFile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static void printFromFile(){

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("DataFile.txt"));

            for (int i = 0; i < doctors.size(); i++) {
                bw.write(doctors.get(i).getFirstName());
                bw.newLine();

                bw.write(doctors.get(i).getSurname());
                bw.newLine();

                bw.write(doctors.get(i).getDateOfBirth());
                bw.newLine();

                bw.write(String.valueOf(doctors.get(i).getMobileNumber()));
                bw.newLine();

                bw.write(String.valueOf(doctors.get(i).getMedicalLicenceNo()));
                bw.newLine();

                bw.write(doctors.get(i).getSpecialisation());
                bw.newLine();

                bw.write("New Doctor inserted");
                System.out.println("New Doctor added");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
