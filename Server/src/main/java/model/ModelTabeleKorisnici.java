/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kontroler.Kontroler;

/**
 *
 * @author kompic
 */
public class ModelTabeleKorisnici extends AbstractTableModel {

    List<Korisnik> korisnici;
    String[] kolone = new String[]{"E-mail", "Ime", "Username", "Status"};

    public ModelTabeleKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik kor = korisnici.get(rowIndex);
        List<Korisnik> aktivni = new ArrayList<>();
        aktivni = Kontroler.getInstance().getListaAktivnihKorisnika();
        switch (columnIndex) {
            case 0:
                return kor.getEmail();
            case 1:
                return kor.getIme();
            case 2:
                return kor.getUsername();
            case 3:
                if (aktivni.contains(kor)) {
                    return "online";
                } else {
                    return "offline";
                }
            default:
                return "N/A";
        }
    }

    public void dodajKorisnika(Korisnik k) {
        korisnici.add(k);
        fireTableDataChanged();
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public void obrisiKorisnika(Korisnik k) {
        korisnici.remove(k);
        fireTableDataChanged();
    }

}
