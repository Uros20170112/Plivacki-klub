/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.Termin;
import domen.Trener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabeleTermini extends AbstractTableModel {

    List<Termin> termini;
    String[] kolone = new String[]{"Dan", "Smena", "Trener"};
    List<AbstractObject> zaBrisanje;

    public ModelTabeleTermini() {
        termini = new ArrayList<>();
        this.zaBrisanje = new ArrayList<>();

    }

    public ModelTabeleTermini(List<Termin> termini) {
        this.termini = termini;
        this.zaBrisanje = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return termini.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Termin termin = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return termin.getDan();
            case 1:
                return termin.getSmena();
            case 2:
                return termin.getTrener().getTrenerId();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void napraviRed() {
        Termin t = new Termin();
        t.setId("0");
        t.setSmena("Odaberite smenu");
        t.setDan("Odaberite dan");
        t.setStanje("nov");
        t.setTrener(new Trener("Odaberite trenera", null, null, null));
        termini.add(t);
        fireTableRowsInserted(termini.size(), termini.size());
    }

    public void izbaci(int red) {
        termini.remove(red);
        fireTableDataChanged();
    }

    public List<Termin> vratiListuTermina() {
        return termini;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String vrednost = (String) aValue;
        Termin t = termini.get(rowIndex);
        switch (columnIndex) {
            case 0:
                if (!t.getDan().equals(vrednost)) {
                    t.setDan(vrednost);
                    if (!t.getStanje().equals("nov")) {
                        t.setStanje("izmenjen");
                    }
                }
                break;
            case 1:
                if (!t.getSmena().equals(vrednost)) {
                    t.setSmena(vrednost);
                    if (!t.getStanje().equals("nov")) {
                        t.setStanje("izmenjen");
                    }
                }
                break;
            case 2:
                if (!t.getTrener().getTrenerId().equals(vrednost)) {
                    t.getTrener().setTrenerId(vrednost);
                    if (!t.getStanje().equals("nov")) {
                        t.setStanje("izmenjen");
                    }
                }

                break;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex
    ) {
        return true;
    }

    public void resetTabele(List<AbstractObject> absTerm) {
        termini.clear();
        for (AbstractObject abs : absTerm) {
            Termin ter = (Termin) abs;
            termini.add(ter);
        }
        fireTableDataChanged();
    }

    public void obrisi(int red) {
        Termin t = termini.get(red);
        t.setStanje("obrisan");
        termini.remove(red);
        zaBrisanje.add(t);
        fireTableRowsDeleted(red, red);
    }

    public List<AbstractObject> getZaBrisanje() {
        return zaBrisanje;
    }

}
