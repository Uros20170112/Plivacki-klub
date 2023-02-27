/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.PromenaPaketa;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabelePromenePaketa extends AbstractTableModel {

    String[] kolone = new String[]{"Paket", "Datum odabira", "Status"};
    List<AbstractObject> listaIp;
    List<AbstractObject> paketi;

    public ModelTabelePromenePaketa(List<AbstractObject> paketi, List<AbstractObject> listaIp) {
        this.listaIp = listaIp;
        this.paketi = paketi;
    }

    @Override
    public int getRowCount() {
        return listaIp.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PromenaPaketa ip = (PromenaPaketa) listaIp.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch (columnIndex) {
            case 0:
                return ip.getPaket();
            case 1:
                return sdf.format(ip.getDatumOdabira());
            case 2:
                
                if (ip.isAktivan()) {
                    return "AKTIVAN";
                } else {
                    return "NEAKTIVAN";
                }
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
