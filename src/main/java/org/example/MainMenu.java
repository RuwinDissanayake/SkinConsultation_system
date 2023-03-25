package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    JFrame Frame = new JFrame();
    JButton ViewDoctors = new JButton("Available Doctors");
    JButton Exit = new JButton("Exit");
    JButton ViewAppointments = new JButton("Appointments");
    JButton EnterAppointment = new JButton("Enter a Appointment");
    MainMenu(){

        EnterAppointment.addActionListener(this);
        EnterAppointment.setBackground(Color.gray);
        EnterAppointment.setForeground(Color.WHITE);
        EnterAppointment.setSize(10,10);
        ViewDoctors.addActionListener(this);
        ViewDoctors.setBackground(Color.gray);
        ViewDoctors.setForeground(Color.WHITE);
        ViewAppointments.addActionListener(this);
        ViewAppointments.setBackground(Color.gray);
        ViewAppointments.setForeground(Color.WHITE);
        Exit.addActionListener(this);
        Exit.setBackground(Color.gray);
        Exit.setForeground(Color.WHITE);
        Frame.add(EnterAppointment);
        Frame.add(ViewDoctors);
        Frame.add(ViewAppointments);
        Frame.add(Exit);

        GridLayout layout = new GridLayout(2,2,5,5);
        layout.setVgap(5);

        Frame.setLayout(layout);
        Frame.setSize(800,400);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == EnterAppointment){AppointmentsForm View1 = new AppointmentsForm();
        } else if (e.getSource() == ViewDoctors) {
            ViewAvailableDoctors View2 = new ViewAvailableDoctors();
        } else if (e.getSource()== ViewAppointments) {Appointments View3 = new Appointments();
        } else if (e.getSource() == Exit) {System.exit(0);

        }
    }

}
