/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author kompic
 */
public class Paket extends AbstractObject {

    private String paketId;
    private String naziv;
    private String cena;
    private List<Termin> termini;

    public Paket(String paketId, String naziv, String cena) {
        this.paketId = paketId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Paket() {
    }

    @Override
    public String toString() {
        return naziv + " - " + cena + " RSD";
    }

    public String getPaketId() {
        return paketId;
    }

    public void setPaketId(String paketId) {
        this.paketId = paketId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    @Override
    public String vratiImeTabele() {
        return "paket";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", paketId, naziv, cena);
    }

    @Override
    public String vratiPK() {
        return "paketId";
    }

    @Override
    public String vratiVrednostPK() {
        return paketId;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> paketi = new ArrayList<>();
        try {
            while (rs.next()) {
                String paketId = rs.getString("paketId");
                String naziv = rs.getString("naziv");
                String cena = rs.getString("cena");

                Paket p = new Paket(paketId, naziv, cena);
                paketi.add(p);
                //System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return paketi;
    }

    @Override
    public String vratiUpdate() {
        return String.format("paketId='%s',naziv='%s',cena='%s'", paketId, naziv, cena);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.paketId = pk;
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
        final Paket other = (Paket) obj;
        if (!Objects.equals(this.paketId, other.paketId)) {
            return false;
        }
        return true;
    }

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }
    
}
