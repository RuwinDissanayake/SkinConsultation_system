package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewAvailableDoctors implements ActionListener {
    ArrayList<Doctor> Flist = WestministerSkinConsultationManager.doctors;
    TableModelOfDoctor modelTable = new TableModelOfDoctor(Flist);
    JTable table = new JTable(modelTable);
    JScrollPane Scroll = new JScrollPane(table);
    JButton Sort = new JButton("Select to Sort Alphabetically");
    JFrame fTable = new JFrame();
    ViewAvailableDoctors(){

        fTable.add(Sort);
        fTable.add(Scroll);
        fTable.setSize(850,800);
        fTable.setVisible(true);
        fTable.setResizable(true);
        Sort.setBounds(300,400, 200,50);
        Sort.addActionListener(this);
        fTable.setBackground(Color.pink);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Sort){
             WestministerSkinConsultationManager.printDoctors();
        }
    }
}
