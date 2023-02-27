/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.Trener;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabeleTrener extends AbstractTableModel{
    ArrayList<Trener> treneri;
    String[] kolone = {"Ime", "Prezime", "Tip Trenera"};

    public ModelTabeleTrener() {
        treneri = new ArrayList<>();
    }

    

    @Override
    public int getRowCount() {
        return treneri.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ArrayList<Trener> getTreneri() {
        return treneri;
    }
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trener t = treneri.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return t.getIme();
            case 1:
                return t.getPrezime();
            case 2:
                return t.getTipTrenera();
        }
        return t;
    }

    public void popuniTabelu(ArrayList<Trener> treneri) {
        this.treneri = treneri;
        fireTableDataChanged();
    }
    
}
