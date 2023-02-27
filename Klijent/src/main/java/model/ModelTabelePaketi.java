/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.Paket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabelePaketi extends AbstractTableModel {

    List<AbstractObject> paketi;
    String[] kolone = new String[]{"Naziv", "Cena"};

    public ModelTabelePaketi(List<AbstractObject> paketi) {
        this.paketi = paketi;
    }

    public List<AbstractObject> getPaketi() {
        return paketi;
    }

    public void setPaketi(List<AbstractObject> paketi) {
        this.paketi = paketi;
    }
    
    @Override
    public int getRowCount() {
        return paketi.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paket paket = (Paket) paketi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return paket.getNaziv();
            case 1:
                return paket.getCena() + " RSD";
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void resetTabele(List<AbstractObject> paketi) {
        this.paketi = paketi;
        fireTableDataChanged();
    }

    public AbstractObject vratiPaket(int red) {
        return paketi.get(red);
    }

    public List<AbstractObject> vratiListu() {
        return paketi;
    }
}
