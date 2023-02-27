/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.Clan;
import domen.Pretplata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabelePretplate extends AbstractTableModel {

    List<AbstractObject> pretplate;
    String[] kolone = new String[]{"Datum","Važi do", "Član", "Paket"};

    public ModelTabelePretplate(List<AbstractObject> pretplate) {
        this.pretplate = pretplate;
    }

    public ModelTabelePretplate() {
        this.pretplate = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return pretplate.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Pretplata p = (Pretplata) pretplate.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sdf.format(p.getDatum());
            case 1:
                return sdf.format(p.getVaziDo());
            case 2:
                return p.getClan();
            case 3:
                return p.getPaket();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void resetTabele(List<AbstractObject> pretplate) {
        this.pretplate = pretplate;
        fireTableDataChanged();
    }

    public List<AbstractObject> vratiListu() {
        return pretplate;
    }
}
