package org.example;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TableModelOfDoctor extends AbstractTableModel implements TableModelListener {

    private ArrayList<Doctor> doclist;
    private String[] columnTitles = {"FirstName", "SurName","DateOfBirth", "MobileNumber", "Specialization", "Medical Licence No"};

    public TableModelOfDoctor(ArrayList<Doctor> doctorList){
            doclist = doctorList;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;

        if(columnIndex == 0){temp = doclist.get(rowIndex).getFirstName();}
        else if(columnIndex == 1){temp = doclist.get(rowIndex).getSurname();}
        else if(columnIndex == 2){temp = doclist.get(rowIndex).getDateOfBirth();}
        else if(columnIndex == 3){temp = doclist.get(rowIndex).getMobileNumber();}
        else if(columnIndex == 4){temp = doclist.get(rowIndex).getSpecialisation();}
        else if(columnIndex == 5){temp = doclist.get(rowIndex).getMedicalLicenceNo();}
        return temp;
    }

    @Override
    public int getColumnCount() {
        return columnTitles.length;
    }
    @Override
    public int getRowCount() {
        return doclist.size();
    }
    @Override
    public void tableChanged(TableModelEvent e) {}
    public String getColumnName(int col){
        return columnTitles[col];
    }
}
