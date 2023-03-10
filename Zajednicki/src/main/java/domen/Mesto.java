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
public class Mesto extends AbstractObject {

    private String mestoId;
    private String naziv;
    private String ptt;

    public Mesto() {
    }

    public Mesto(String mestoId, String naziv, String ptt) {
        this.mestoId = mestoId;
        this.naziv = naziv;
        this.ptt = ptt;
    }

    /**
     * Poredi dva objekta Mesto i utvrdjuje da li su isti
     *
     * @param obj
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Mesto i imaju isti mestoId
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
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.mestoId, other.mestoId)) {
            return false;
        }
        return true;
    }

    /**
     * Vraca String sa bitnim informacijama o mestu
     *
     * @return ptt i naziv mesta
     */
    @Override
    public String toString() {
        if (ptt == null || naziv == null) {
            throw new NullPointerException("Nijedna od vrednosti za toString() ne sme biti null");
        }
        return ptt + " " + naziv;
    }

    /**
     * Vraca id mesta
     *
     * @return String mestoid
     */
    public String getMestoId() {
        return mestoId;
    }

    /**
     * Postavlja vednost za id mesta
     *
     * @param mestoId
     */
    public void setMestoId(String mestoId) {
        if(mestoId == null){
            throw new NullPointerException("id mesta ne sme biti null");
        }
        if(mestoId.equals("")){
            throw new IllegalArgumentException("id mesta ne sme biti prazan string");
        }
        if( mestoId.equals("0") || mestoId.contains("-")){
            throw new RuntimeException("id mesta ne sme biti nula, niti negativan broj");
        }
        this.mestoId = mestoId;
    }

    /**
     * Vraca naziv mesta
     *
     * @return String naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost za naziv mesta
     *
     * @param naziv
     */
    public void setNaziv(String naziv) {
        if(naziv == null){
            throw new NullPointerException("naziv mesta ne sme biti null");
        }
        if(naziv.length() < 2){
            throw new RuntimeException("naziv mesta ne sme biti krace od 2 karaktera");
        }
        this.naziv = naziv;
    }

    /**
     * Vraca ptt mesta
     *
     * @return String ptt
     */
    public String getPtt() {
        return ptt;
    }

    /**
     * Postavlja vrednost za ptt mesta
     *
     * @param ptt
     */
    public void setPtt(String ptt) {
        if(ptt == null){
            throw new NullPointerException("ptt mesta ne sme biti null");
        }
        char[] digit = ptt.toCharArray();
        for (char c : digit) {
            if(!Character.isDigit(c))
                throw new IllegalArgumentException("ptt mora da sadrzi samo brojeve");
        }
        if(ptt.length() < 2){
            throw new RuntimeException("ptt ne sme biti krace od 2 karaktera");
        }
        this.ptt = ptt;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za mesto kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "mesto";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return null;
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "mestoId";
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String mestoid
     */
    @Override
    public String vratiVrednostPK() {
        return mestoId;
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Mesto i vraca je
     *
     * @param rs
     * @return lista objekata Mesto
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> mesta = new ArrayList<>();
        try {
            while (rs.next()) {
                String MESTOID = rs.getString("mestoId");
                String NAZIV = rs.getString("naziv");
                String PTT = rs.getString("ptt");
                Mesto m = new Mesto(MESTOID, NAZIV, PTT);
                mesta.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mesta;
    }

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return null;
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.mestoId = pk;
    }

}
