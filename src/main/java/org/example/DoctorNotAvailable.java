package org.example;
import java.util.Date;

public class DoctorNotAvailable {

    public static boolean Available = true;

    public DoctorNotAvailable(){

    }
    public static void checking(Doctor doctor, Date date){

        for (int i = 0; i < Consultation.Appointments.size(); i++) {

            if (date.toString().equals(Consultation.Appointments.get(i).getAppointmentDate().toString())){
                System.out.println("DoctorNotAvailable");
                Available = false;
            }
        }
    }

}
