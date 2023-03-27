/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
     * stanje je string
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
     * smena ne sme biti null i mora da sledi strikan sablon
     */
    public void setSmena(String smena) {
        if (smena == null) {
            throw new NullPointerException("smena ne sme da bude null");
        }
        if (!Pattern.matches("^[0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9]$", smena)) {
            throw new IllegalArgumentException("nije dobro unesena smena");
        }
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
     * dan je String i mora da bude jedan od dana u nedelji
     */
    public void setDan(String dan) {
        if (dan == null) {
            throw new NullPointerException("dan ne sme da bude null");
        }
        if (!(dan == "Ponedeljak" || dan == "Utorak" || dan == "Sreda" || dan == "Cetvrtak"
                || dan == "Petak" || dan == "Subota" || dan == "Nedelja")) {
            throw new IllegalArgumentException("nije unesen dobar dan");
        }
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
     * paket ne sme da bude null
     */
    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new NullPointerException("paket ne sme da bude null");
        }
        this.paket = paket;
    }

    /**
     * Vraca id za termin
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Postavlja vrednost za id za termin
     *
     * @param id
     * id je string, ne sme biti null, prazan string ili 0 i negativan broj.
     */
    public void setId(String id) {
        if (id == null) {
            throw new NullPointerException("id ne sme biti null");
        }
        if (id.equals("")) {
            throw new IllegalArgumentException();
        }
        if (id.equals("0") || id.contains("-")) {
            throw new RuntimeException("id ne sme biti nula, niti negativan broj");
        }
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
     * trener ne sme da bdue null
     */
    public void setTrener(Trener trener) {
        if (trener == null) {
            throw new NullPointerException("trener ne sme da bude null");
        }
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
     * rs je resultset
     * @return lista objekata Termin
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
     * pk je primarni kljuc
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.id = pk;
    }

}
