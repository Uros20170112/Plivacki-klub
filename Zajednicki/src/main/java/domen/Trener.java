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
public class Trener extends AbstractObject {

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

    /**
     * Vraca id trenera
     *
     * @return String trenerId
     */
    public String getTrenerId() {
        return trenerId;
    }

    /**
     * Postavlja vrednost za id trenera
     *
     * @param trenerId
     */
    public void setTrenerId(String trenerId) {
        if(trenerId == null){
            throw new NullPointerException("trener Id ne sme biti null");
        }
        if( trenerId.equals("0") || trenerId.contains("-")){
            throw new RuntimeException("trener Id ne sme biti nula, niti negativan broj");
        }
        this.trenerId = trenerId;
    }

    /**
     * Vraca ime trenera
     *
     * @return String ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost za ime trenera
     *
     * @param ime
     */
    public void setIme(String ime) {
        if(ime == null){
            throw new NullPointerException("ime trenera ne sme biti null");
        }
        if(ime.length() < 2){
            throw new RuntimeException("ime trenera ne sme biti krace od 2 karaktera");
        }
        this.ime = ime;
    }

    /**
     * Vraca prezime trenera
     *
     * @return String prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost za prezime trenera
     *
     * @param prezime
     */
    public void setPrezime(String prezime) {
        if(prezime == null){
            throw new NullPointerException("prezime trenera ne sme biti null");
        }
        if(prezime.length() < 2){
            throw new RuntimeException("prezime trenera ne sme biti krace od 2 karaktera");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca koji je tip trenera
     *
     * @return String tipTrenera
     */
    public String getTipTrenera() {
        return tipTrenera;
    }

    /**
     * Postavlja vrednost za tip trenera
     *
     * @param tipTrenera
     */
    public void setTipTrenera(String tipTrenera) {
        if(tipTrenera == null){
            throw new NullPointerException("tip trenera ne sme biti null");
        }
        if(tipTrenera.length() < 2){
            throw new RuntimeException("tip trenera ne sme biti krace od 2 karaktera");
        }
        this.tipTrenera = tipTrenera;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "trener";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", trenerId, ime, prezime, tipTrenera);
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "trenerid";
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String trenerId
     */
    @Override
    public String vratiVrednostPK() {
        return trenerId;
    }

    /**
     *
     * @return vraca slozen primarni kljuc
     */
    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Trener i vraca je
     *
     * @param rs
     * @return lista objekata Trener
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> treneri = new ArrayList<>();
        try {
            while (rs.next()) {
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

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return String.format("trenerId = '%s', ime = '%s', prezime = '%s', tipTrenera = '%s'", trenerId, ime, prezime, tipTrenera);
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.trenerId = pk;
    }

    /**
     * Vraca String sa bitnim informacijama o treneru
     *
     * @return ime i prezime trenera
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * Poredi dva objekta Mesto i utvrdjuje da li su isti
     *
     * @param obj
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Trener i imaju isti mestoId
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
        final Trener other = (Trener) obj;
        if (!Objects.equals(this.trenerId, other.trenerId)) {
            return false;
        }
        return true;
    }

}
