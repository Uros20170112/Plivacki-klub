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
import java.util.regex.Pattern;

/**
 * Klasa koja predstavlja clana plivackog kluba i koja nasledjuje apstraktnu
 * klasu AbstractObject i implementira njene metode.
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
    /**
     * Mesto kome pripada clan
     */
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

    /**
     * Vraca vrednost ID clana
     *
     * @return String clanId
     */
    public String getClanId() {
        return clanId;
    }

    /**
     * Postavlja vrednost clanId
     *
     * @param clanId
     */
    public void setClanId(String clanId) {
        if(clanId == null){
            throw new NullPointerException("id clana ne sme biti null");
        }
        if( clanId.equals("0") || clanId.contains("-")){
            throw new RuntimeException("id clana ne sme biti nula, niti negativan broj");
        }
        this.clanId = clanId;
    }

    /**
     * Vraca ime clana
     *
     * @return String ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost ime clana
     *
     * @param ime
     */
    public void setIme(String ime) {
        if(ime == null){
            throw new NullPointerException("ime clana ne sme biti null");
        }
        if(ime.length() < 2){
            throw new RuntimeException("ime clana ne sme biti krace od 2 karaktera");
        }
        this.ime = ime;
    }

    /**
     * Vraca prezime clana
     *
     * @return String prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost prezime clana
     *
     * @param prezime
     */
    public void setPrezime(String prezime) {
        if(prezime == null){
            throw new NullPointerException("prezime clana ne sme biti null");
        }
        if(prezime.length() < 2){
            throw new RuntimeException("prezime clana ne sme biti krace od 2 karaktera");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca email clana
     *
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja vrednost email clana
     *
     * @param email
     */
    public void setEmail(String email) {
        if(email == null){
            throw new NullPointerException("email ne sme biti null");
        }
        if(!email.contains("@")){
            throw new RuntimeException("email mora sadrzati karakter '@'");
        }
        this.email = email;
    }

    /**
     * Vraca vrednost adrese clana
     *
     * @return String adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Postavlja adresu clana
     *
     * @param adresa
     */
    public void setAdresa(String adresa) {
        if(adresa == null){
            throw new NullPointerException("adresa clana ne sme biti null");
        }
        if(adresa.length() < 10){
            throw new RuntimeException("adresa clana ne sme biti krace od 2 karaktera");
        }
        this.adresa = adresa;
    }

    /**
     * Vraca vrednost broja telefona clana
     *
     * @return String telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Postavlja vrednost broja telefona clana
     *
     * @param telefon
     */
    public void setTelefon(String telefon) {
        if(telefon == null){
            throw new NullPointerException("Telefon ne sme biti null");
        }
        if(Pattern.matches("[a-zA-Z+]+", telefon)){
            throw new RuntimeException("Telefon moze sadrzati samo brojeve i znak '+'");
        }
        if(telefon.length() < 10){
            throw new RuntimeException("telefon mora imati duzinu od bar 10 karaktera");
        }
        this.telefon = telefon;
    }

    /**
     * Vraca mesto odakle je clan
     *
     * @return String mesto
     */
    public Mesto getMesto() {
        return mesto;
    }

    /**
     * Postavlja vrednost mesta clana
     *
     * @param mesto
     */
    public void setMesto(Mesto mesto) {
        if(mesto == null){
            throw new NullPointerException("mesto ne sme biti null");
        }
        this.mesto = mesto;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "clan";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("%s, '%s', '%s', '%s', '%s', '%s', '%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "clanId";
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String clanId
     */
    @Override
    public String vratiVrednostPK() {
        return clanId;
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Clan i vraca je
     *
     * @param rs
     * @return lista objekata Clan
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
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

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return String.format("clanId=%s,ime='%s',prezime='%s',email='%s',adresa='%s',telefon='%s',mestoId='%s'", clanId, ime, prezime, email, adresa, telefon, mesto.getMestoid());
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.clanId = pk;
    }

    /**
     * Poredi dva objekta Clan i utvrdjuje da li su isti
     *
     * @param obj
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Clan i imaju isti clanID
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
        final Clan other = (Clan) obj;
        if (!Objects.equals(this.clanId, other.clanId)) {
            return false;
        }
        return true;
    }

    /**
     * Vraca String sa bitnim informacijama o clanu
     *
     * @return ime i prezime clana
     */
    @Override
    public String toString() {
        if (ime == null || prezime == null) {
            throw new NullPointerException("Nijedna od vrednosti za toString() ne sme biti null");
        }

        return ime + " " + prezime; //To change body of generated methods, choose Tools | Templates.
    }

}
