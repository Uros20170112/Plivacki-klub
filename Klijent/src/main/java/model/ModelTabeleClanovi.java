/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domen.AbstractObject;
import domen.Clan;
import domen.PromenaPaketa;
import domen.Paket;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kompic
 */
public class ModelTabeleClanovi extends AbstractTableModel {

    List<AbstractObject> clanovi;
    String[] kolone = new String[]{"Ime", "Prezime", "Paket", "E-mail", "Telefon", "Adresa", "Mesto"};
    List<AbstractObject> mesta;
    List<AbstractObject> promenePaketa;
    List<AbstractObject> paketi;

    public ModelTabeleClanovi(List<AbstractObject> clanovi, List<AbstractObject> mesta, List<AbstractObject> promenePaketa, List<AbstractObject> paketi) {
        this.clanovi = clanovi;
        this.mesta = mesta;
        this.promenePaketa = promenePaketa;
        this.paketi = paketi;
    }

    public List<AbstractObject> getPromenePaketa() {
        return promenePaketa;
    }

    public List<AbstractObject> getPaketi() {
        return paketi;
    }

    public List<AbstractObject> getClanovi() {
        return clanovi;
    }

    public void setClanovi(List<AbstractObject> clanovi) {
        this.clanovi = clanovi;
    }
    
    @Override
    public int getRowCount() {
        return clanovi.size();
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
        Clan clan = (Clan) clanovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return clan.getIme();
            case 1:
                return clan.getPrezime();
            case 2:
                return vratiPaket(vratiPaketId(clan));
            case 3:
                return clan.getEmail();
            case 4:
                return clan.getTelefon();
            case 5:
                return clan.getAdresa();
            case 6:
                return clan.getMesto();
            default:
                return "n/a";
        }
    }

    public Object vratiPaketId(Clan clan) {
        for (AbstractObject abs : promenePaketa) {
            PromenaPaketa promena = (PromenaPaketa) abs;
            if (clan.equals(promena.getClan())
                    && (promena.isAktivan() == true)) {
                return promena.getPaket().getPaketId();
            }
        }

        return null;
    }

    public Object vratiPaket(Object vratiPaketId) {
        for (AbstractObject abs : paketi) {
            Paket p = (Paket) abs;
            if (p.getPaketId().equals(vratiPaketId)) {
                return p;
            }
        }
        return null;
    }

}
