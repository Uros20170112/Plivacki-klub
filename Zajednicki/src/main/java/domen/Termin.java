/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kompic
 */
public class Termin extends AbstractObject {

    private String smena;
    private String dan;
    /**
     * Paket koji pripada terminu
     */
    private Paket paket;
    private String id;
    private String stanje;
    /**
     * trener koji pripada terminu
     */
    private Trener trener;

    public Termin(String smena, String dan, Paket paket, String id, Trener trener) {
        this.smena = smena;
        this.dan = dan;
        this.paket = paket;
        this.id = id;
        this.stanje = "aktivan";
        this.trener = trener;
    }

    public Termin() {
    }

    /**
     * Vraca stanje termina
     *
     * @return String stanje
     */
    public String getStanje() {
        return stanje;
    }

    /**
     * Postavlja vrednost stanja
     *
     * @param stanje
     */
    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    /**
     * Vraca u kojoj smeni je termin
     *
     * @return String smena
     */
    public String getSmena() {
        return smena;
    }

    /**
     * Postavlja vrednost za smenu termina
     *
     * @param smena
     */
    public void setSmena(String smena) {
        this.smena = smena;
    }

    /**
     * Vraca vrednost za koji je dan u nedelji termin
     *
     * @return String dan
     */
    public String getDan() {
        return dan;
    }

    /**
     * Postavlja vrednost za vrednost dan
     *
     * @param dan
     */
    public void setDan(String dan) {
        this.dan = dan;
    }

    /**
     * Vraca koji je paket u pitanju
     *
     * @return Paket paket
     */
    public Paket getPaket() {
        return paket;
    }

    /**
     * Postavlja vrednost za paket
     *
     * @param paket
     */
    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    /**
     * Vraca id za termin
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Postavlja vrednost za id za termin
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Vraca trenera koji trenira u terminu
     *
     * @return Trener trener
     */
    public Trener getTrener() {
        return trener;
    }

    /**
     * Postavlja vrednost za trenera
     *
     * @param trener
     */
    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "termin";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s'", id, smena, dan, paket.getPaketId(), trener.getTrenerId());
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "terminId";
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String id
     */
    @Override
    public String vratiVrednostPK() {
        return id;
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Termin i vraca je
     *
     * @param rs
     * @return lista objekata Termin
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> termini = new ArrayList<>();
        try {
            while (rs.next()) {
                String terminId = rs.getString("terminId");
                String smena = rs.getString("smena");
                String dan = rs.getString("dan");
                String paketId = rs.getString("paketId");
                String trenerId = rs.getString("trenerId");

                Termin t = new Termin(smena, dan, new Paket(paketId, null, null), terminId, new Trener(trenerId, null, null, null));
                termini.add(t);
            }
        } catch (Exception e) {
            System.out.println("Greska kod RS Termina.");
        }
        return termini;
    }

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {

        return String.format("terminId='%s',smena='%s',dan='%s',paketId='%s',trenerId='%s'", id, smena, dan, paket.getPaketId(), trener.getTrenerId());
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.id = pk;
    }

}
