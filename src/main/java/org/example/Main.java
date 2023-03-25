package org.example;

import java.util.Scanner;

import static org.example.WestministerSkinConsultationManager.*;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        while (i < 2) {
            System.out.println("""
                        ----------------------------Welcome to Westminister Skin Consultation-----------------------------------
                                        
                        1.To add a new Doctor Select "1"
                                        
                        2.To Delete a Doctor Select "2"
                                        
                        3.To Print the Doctors Alphabetically Select "3"
                                        
                        4.To Save the Doctor to a file Select "4"
                                        
                        5.To View the GUI Select "5"
                        
                        6.To Exit Select "6"
                                        
                        --------------------------------------------------------------------------------------------------------
                        """);

            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.print("Enter the Selected option :");
                int Select = scanner1.nextInt();

                if (Select == 1) {
                    addNewDoctor();
                    Thread.sleep(2000);

                } else if (Select == 2) {
                    deleteDoctor();
                    Thread.sleep(2000);

                } else if (Select == 3) {
                    printDoctors();
                    Thread.sleep(2000);

                } else if (Select == 4) {
                    PrintBackFromFile();
                    Thread.sleep(2000);

                } else if (Select == 5) {
                    new MainMenu();
                    Thread.sleep(2000);

                } else if (Select == 6){
                    Thread.sleep(2000);
                    i = 3;

                }else {
                    System.out.println("Invalid Input!!!");
                    Thread.sleep(2000);
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Please Enter a valid Input Type!!!");
                main(args);
            }


        }
    }
}
