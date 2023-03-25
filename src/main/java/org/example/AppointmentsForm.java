package org.example;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilCalendarModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.Random;



public class AppointmentsForm extends  JFrame implements ActionListener{

    JDatePickerImpl datePicker;
    String [] DropdownList = new String[10];
    JButton Enter = new JButton("Book Appointment");
    JTextArea Notes = new JTextArea("---");
    JFileChooser ChooseFile = new JFileChooser();
    JButton FileOpen = new JButton("Choose a file");
    JTextField pFirstName = new JTextField(5);
    JTextField pSurName = new JTextField(5);
    JTextField pMobileNumber = new JTextField(5);
    JTextField pDateOfBirth = new JTextField(5);
    JTextField pNIC = new JTextField(5);
    File FileSelect;
    SpinnerNumberModel ModelNumber = new SpinnerNumberModel(1, 1, 4, 1);
    JSpinner hoursNo = new JSpinner(ModelNumber);
    String ChooseDoctor;
    JComboBox<String> Box = new JComboBox();
    AppointmentsForm(){

        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JPanel textFieldsPanel = new JPanel(new GridLayout(20,5,0,5));
        UtilCalendarModel mdl1 = new UtilCalendarModel();
        UtilCalendarModel model1 = new UtilCalendarModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(mdl1, p);
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model1, p);
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateComponentFormatter());


        textFieldsPanel.add(new JLabel("Select The Doctor"));
        for (int i = 0; i < WestministerSkinConsultationManager.doctors.size(); i++) {
            DropdownList[i] = WestministerSkinConsultationManager.doctors.get(i).getFirstName();
        }

        for (int i = 0; i < DropdownList.length; i++) {
            Box.addItem(DropdownList[i]);

        }
        textFieldsPanel.add(Box);
        textFieldsPanel.add(new JLabel("Enter First Name:"));
        textFieldsPanel.add(pFirstName);
        textFieldsPanel.add(new JLabel("Enter Surname:"));
        textFieldsPanel.add(pSurName);
        textFieldsPanel.add(new JLabel("Enter Date Of Birth: "));
        textFieldsPanel.add(datePicker2);
        textFieldsPanel.add(new JLabel("Enter Mobile No:"));
        textFieldsPanel.add(pMobileNumber);
        textFieldsPanel.add(new JLabel("Enter NIC No"));
        textFieldsPanel.add(pNIC);
        textFieldsPanel.add(new JLabel("Enter Notes here"));
        textFieldsPanel.add(Notes);
        textFieldsPanel.add(new JLabel("Select Date For Consultation:"));
        textFieldsPanel.add(datePicker);
        textFieldsPanel.add(new JLabel("Number of Hours:"));
        textFieldsPanel.add(hoursNo);
        textFieldsPanel.add(new JLabel("Select a file:"));
        textFieldsPanel.setBackground(Color.pink);
        FileOpen.addActionListener(this);
        textFieldsPanel.add(FileOpen);

        JPanel secondPanel = new JPanel();
        Enter.addActionListener(this);
        secondPanel.add(Enter);
        secondPanel.add(Enter);

        Container cp = this.getContentPane();
        cp.setLayout(new BorderLayout(2,25));
        cp.add(textFieldsPanel, BorderLayout.NORTH);
        cp.add(secondPanel, BorderLayout.CENTER);

        setSize(500,720);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean NullErrors = true;
        Doctor doctor = null;
        boolean FirstAppointment = true;

        ChooseDoctor = (String) Box.getSelectedItem();
        int year = datePicker.getModel().getYear();
        int month = datePicker.getModel().getMonth();
        int day = datePicker.getModel().getDay();
        Date AppointmentDate = new Date(year,month,day);
        System.out.println(AppointmentDate);


        if (e.getSource() == FileOpen){
            ChooseFile.setCurrentDirectory(new File("C:\\"));
            ChooseFile.setFileFilter(new FileNameExtensionFilter(".png files", "png"));
            ChooseFile.setDialogTitle("Select a file");
            int returnValue = ChooseFile.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = ChooseFile.getSelectedFile();
            }
        }

        if (e.getSource() == Enter){

            for (int j = 0; j < WestministerSkinConsultationManager.doctors.size(); j++) {

                if (ChooseDoctor == WestministerSkinConsultationManager.doctors.get(j).getFirstName()){

                    doctor = WestministerSkinConsultationManager.doctors.get(j);
                    DoctorNotAvailable.checking(doctor, AppointmentDate );
                    if (!DoctorNotAvailable.Available){
                        JOptionPane.showMessageDialog(null, "Random Doctor Will be assigned", "Doctor not available", JOptionPane.WARNING_MESSAGE);

                        if (WestministerSkinConsultationManager.doctors.size() <= 1){
                            JOptionPane.showMessageDialog(null, "Doctors not available, Please Come back later!!!", "Doctor not available", JOptionPane.ERROR_MESSAGE);
                            NullErrors = false;
                        }
                        else {
                            DoctorNotAvailable.Available = true;
                            Random random = new Random();
                            int index = random.nextInt(WestministerSkinConsultationManager.doctors.size());

                            while (index == j){
                                index = random.nextInt(WestministerSkinConsultationManager.doctors.size());
                            }

                            doctor = WestministerSkinConsultationManager.doctors.get(index);
                        }

                    }
                }
            }

            try {
                int mobileNumber = Integer.parseInt(pMobileNumber.getText());
                int NIC = Integer.parseInt(pNIC.getText());
            }
            catch (Exception e1){
                JOptionPane.showMessageDialog(null, "Mobile Number or NIC Incorrect!!!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                NullErrors = false;
            }

            }

            if (pFirstName.getText() == "" || ChooseDoctor == null || datePicker.getModel().getValue() == null){
                JOptionPane.showMessageDialog(null, "Please Check Again!!!", "Field Empty", JOptionPane.ERROR_MESSAGE);
                NullErrors = false;

            }



            if (NullErrors){

                int mobileNumber = Integer.parseInt(pMobileNumber.getText());
                int NIC = Integer.parseInt(pNIC.getText());
                Patient patient = new Patient(pFirstName.getText(), pSurName.getText(), pDateOfBirth.getText(), mobileNumber, NIC);
                if (FirstAppointment == true){

                    int consultationAmount = (int) hoursNo.getValue() * 15;
                    int consultationNo = 1;
                    Consultation consultation = new Consultation(patient, doctor, consultationAmount, Notes.getText(), consultationNo, FileSelect, AppointmentDate);
                    Consultation.Appointments.add(consultation);
                }
                JOptionPane.showMessageDialog(null, "Appointment successfully saved!", "", JOptionPane.PLAIN_MESSAGE);
                this.dispose();

                for (int i = 0; i < Consultation.Appointments.size(); i++) {
                    if (Consultation.Appointments.get(i).getPatient().getUniqueID() == NIC){

                        int newConsultationNo = Consultation.Appointments.get(i).consultationNo;
                        int consultationAmount = (int) hoursNo.getValue() * 25;
                        newConsultationNo++;
                        FirstAppointment = false;

                        Consultation consultation = new Consultation(patient, doctor, consultationAmount, Notes.getText(), newConsultationNo, FileSelect, AppointmentDate);
                        Consultation.Appointments.add(consultation);
                        break;
                    }
                }

            }


        }



    }

