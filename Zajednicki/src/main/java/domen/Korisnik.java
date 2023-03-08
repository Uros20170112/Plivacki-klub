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
 * Apstraktna klasa koju nasledjuje svaka domenska klasa i implementira njene
 * metode u zavisnosti od same baze i zahtevanih sistemskih operacija.
 *
 * @author kompic
 */
public class Korisnik extends AbstractObject {

    private String ime;
    private String email;
    private String password;
    private String username;
    private String statusKorisnika = "offline";

    public Korisnik(String ime, String email, String password, String username) {
        this.ime = ime;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Korisnik() {
    }

    /**
     * Poredi dva objekta Korisnik i utvrdjuje da li su isti
     *
     * @param obj
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Korisnik i imaju isti username i
     * password
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za korisnika kako bi mogao da se
     * napravi upit
     */
    @Override
    public String vratiImeTabele() {
        return "korisnik";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", ime, email, password, username);

    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return null;
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String ime, email, username, password
     */
    @Override
    public String vratiVrednostPK() {
        return ime + ", " + email + "," + username + ", " + password;
    }

    /**
     *
     * @return vraca slozen primarni kljuc
     */
    @Override
    public String vratiSlozenPK() {
        return String.format("username='%s' AND email='%s'", username, email); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return String.format("ime='%s',email='%s',password='%s',username='%s'", email, password, ime, username); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Korisnik i vraca
     * je
     *
     * @param rs
     * @return lista objekata Korisnik
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> korisnici = new ArrayList<>();
        try {
            while (rs.next()) {
                String ime = rs.getString("ime");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");

                Korisnik k = new Korisnik(ime, email, password, username);
                korisnici.add(k);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {

    }

    /**
     * Vraca String sa bitnim informacijama o korisniku
     *
     * @return ime korinsika
     */
    @Override
    public String toString() {
        if (ime == null) {
            throw new NullPointerException("Nijedna od vrednosti za toString() ne sme biti null");
        }
        return ime; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Vraca ime korisnika
     *
     * @return String ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost ime korisnik
     *
     * @param ime
     */
    public void setIme(String ime) {
        if(ime == null){
            throw new NullPointerException("ime korisnika ne sme biti null");
        }
        if(ime.length() < 2){
            throw new RuntimeException("ime korisnika ne sme biti krace od 2 karaktera");
        }
        this.ime = ime;
    }

    /**
     * Vraca email korisnika
     *
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja vrednost email korisnika
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
     * Vraca sifru korisnika
     *
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja vrednost sifra korisnika
     *
     * @param password
     */
    public void setPassword(String password) {
        if(password == null){
            throw new NullPointerException("password ne sme biti null");
        }
        char[] pass = password.toCharArray();
        boolean digit = false;
        for (char c : pass) {
            if(Character.isDigit(c))
                digit = true;
                continue;
        }
        if(digit == false && password.length()<7) {
            throw new IllegalArgumentException("password mora da sardzi barem jedna broj i mora da sadrzi "
                    + "barem 7 karaktera ");
        }
        this.password = password;
    }

    /**
     * Vraca korisnikcko ime korisnika
     *
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja vrednost korisnickog imena
     *
     * @param username
     */
    public void setUsername(String username) {
        if(username == null){
            throw new NullPointerException("username korisnika ne sme biti null");
        }
        if(username.length() < 5){
            throw new RuntimeException("username korisnika ne sme biti krace od 5 karaktera");
        }
        this.username = username;
    }

    /**
     * Vraca status korisnika
     *
     * @return String statusKorisnika
     */
    public String getStatusKorisnika() {
        return statusKorisnika;
    }

    /**
     * Postavlja status korisnika
     *
     * @param statusKorisnika
     */
    public void setStatusKorisnika(String statusKorisnika) {
        if(statusKorisnika == null){
            throw new NullPointerException("status korisnika ne sme biti null");
        }
        if(!(statusKorisnika.equals("offline") || statusKorisnika.equals("online"))){
            throw new RuntimeException("status ne sme biti drugaciji od online ili offline ");
        }
        this.statusKorisnika = statusKorisnika;
    }

}
