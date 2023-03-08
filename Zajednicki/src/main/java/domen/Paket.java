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
    /**
     * Lista termina koji pripadaju paketu
     */
    private List<Termin> termini;

    public Paket(String paketId, String naziv, String cena) {
        this.paketId = paketId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Paket() {
    }
    /**
     * Vraca String sa bitnim informacijama o paketu
     *
     * @return naziv i cenu clana
     */
    @Override
    public String toString() {
        return naziv + " - " + cena + " RSD";
    }
/**
 * Vraca id paketa
 * @return String paketId
 */
    public String getPaketId() {
        return paketId;
    }
/**
 * Postavlja vrednost id paketa
 * @param paketId 
 */
    public void setPaketId(String paketId) {
        this.paketId = paketId;
    }
/**
 * Vraca naziv paketa
 * @return String naziv
 */
    public String getNaziv() {
        return naziv;
    }
/**
 * Postavlja vrednost za naziv paketa
 * @param naziv 
 */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
/**
 * Vraca cenu paketa
 * @return String cena
 */
    public String getCena() {
        return cena;
    }
/**
 * Postavlja vrednost za cenu paketa
 * @param cena 
 */
    public void setCena(String cena) {
        this.cena = cena;
    }
    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "paket";
    }
    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", paketId, naziv, cena);
    }
    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "paketId";
    }
    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String paketId
     */
    @Override
    public String vratiVrednostPK() {
        return paketId;
    }
    /**
     *
     * @return vraca slozen primarni kljuc
     */
    @Override
    public String vratiSlozenPK() {
        return null;
    }
    /**
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Paket i vraca je
     *
     * @param rs
     * @return lista objekata Paket
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
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
    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return String.format("paketId='%s',naziv='%s',cena='%s'", paketId, naziv, cena);
    }
    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.paketId = pk;
    }
    /**
     * Poredi dva objekta Paket i utvrdjuje da li su isti
     *
     * @param obj
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Paket i imaju isti paketId
     * <li>false u svakom drugom slucaju
     * </ul>
     */
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
/**
 * Vraca listu termina koji se nalaze u paketu
 * @return List<Termin> termini
 */
    public List<Termin> getTermini() {
        return termini;
    }
/**
 * Postavlja vrednost za listu termini
 * @param termini 
 */
    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }
    
}
