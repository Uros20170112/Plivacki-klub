/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kompic
 */
public class Trener extends AbstractObject{
    private String trenerId;
    private String ime;
    private String prezime;
    private String tipTrenera;

    public Trener() {
    }

    public Trener(String trenerId, String ime, String prezime, String tipTrenera) {
        this.trenerId = trenerId;
        this.ime = ime;
        this.prezime = prezime;
        this.tipTrenera = tipTrenera;
    }

    public String getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(String trenerId) {
        this.trenerId = trenerId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTipTrenera() {
        return tipTrenera;
    }

    public void setTipTrenera(String tipTrenera) {
        this.tipTrenera = tipTrenera;
    }

    @Override
    public String vratiImeTabele() {
        return "trener";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", trenerId, ime, prezime, tipTrenera);
    }

    @Override
    public String vratiPK() {
        return "trenerid";
    }

    @Override
    public String vratiVrednostPK() {
        return trenerId;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> treneri = new ArrayList<>();
        try {
            while(rs.next()) {
                String trenerId = rs.getString("trenerId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String tipTrenera = rs.getString("tipTrenera");
                
                Trener t = new Trener(trenerId, ime, prezime, tipTrenera);
                treneri.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Greska kod RS Trenera.");
        }
        return treneri;
    }

    @Override
    public String vratiUpdate() {
        return String.format("trenerId = '%s', ime = '%s', prezime = '%s', tipTrenera = '%s'", trenerId, ime, prezime, tipTrenera);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.trenerId, other.trenerId)) {
            return false;
        }
        return true;
    }
    
    
}
