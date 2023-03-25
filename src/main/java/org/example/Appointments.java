package org.example;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Appointments extends JFrame{

    public String[] columns = {"Appointment Number", "Doctor FirstName", "Patient FirstName","Patient Surname", "Patient ID", "Consultation Price", "Date","Notes"};

    ArrayList<Consultation> appointments = Consultation.Appointments;

    Appointments() {
        JTable table = new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return appointments.size();
            }

            @Override
            public int getColumnCount() {
                return columns.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Object temp = null;
                if (columnIndex == 0) {
                    temp = appointments.get(rowIndex).getConsultationNo();
                } else if (columnIndex == 1) {
                    temp = appointments.get(rowIndex).getDoctor().getFirstName();
                } else if (columnIndex == 2) {
                    temp = appointments.get(rowIndex).getPatient().getFirstName();
                } else if (columnIndex == 3) {
                    temp = appointments.get(rowIndex).getPatient().getSurname();
                } else if (columnIndex == 4) {
                    temp = appointments.get(rowIndex).getPatient().getUniqueID();
                } else if (columnIndex == 5) {
                    temp = appointments.get(rowIndex).getConsultationCost() + "£";
                } else if (columnIndex == 6) {
                    temp = appointments.get(rowIndex).getAppointmentDate().toString();
                } else if (columnIndex == 7) {
                    temp = appointments.get(rowIndex).getNotes();
                }
                return temp;
            }

            public String getColumnName(int col) {
                return columns[col];
            }
        });

        JScrollPane viewAppointments = new JScrollPane(table);
        this.add(viewAppointments);
        this.setSize(800, 600);
        this.setVisible(true);

    }
}

