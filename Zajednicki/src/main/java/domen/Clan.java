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

/**
 *
 * @author kompic
 */
public class Clan extends AbstractObject {

    private String clanId;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;
    private String telefon;
    private Mesto mesto;

    public Clan(String clanId, String ime, String prezime, String email, String adresa, String telefon, Mesto mesto) {
        this.clanId = clanId;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
        this.telefon = telefon;
        this.mesto = mesto;
    }

    public Clan() {
    }

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String vratiImeTabele() {
        return "clan";
    }

    @Override
    public String vratiParametre() {
        return String.format("%s, '%s', '%s', '%s', '%s', '%s', '%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
    }

    @Override
    public String vratiPK() {
        return "clanId";
    }

    @Override
    public String vratiVrednostPK() {
        return clanId;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> clanovi = new ArrayList<>();
        try {
            while (rs.next()) {

                String clanId = rs.getString("clanId");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                String adresa = rs.getString("adresa");
                String telefon = rs.getString("telefon");
                String mestoId = rs.getString("mestoId");
                Clan c = new Clan(clanId, ime, prezime, email, adresa, telefon, new Mesto(mestoId, null, null));
                clanovi.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return clanovi;
    }

    @Override
    public String vratiUpdate() {
        return String.format("clanId=%s,ime='%s',prezime='%s',email='%s',adresa='%s',telefon='%s',mestoId='%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.clanId = pk;
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
        final Clan other = (Clan) obj;
        if (!Objects.equals(this.clanId, other.clanId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime+" "+prezime; //To change body of generated methods, choose Tools | Templates.
    }
    
}
