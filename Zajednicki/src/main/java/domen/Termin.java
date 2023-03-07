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
    private Paket paket;
    private String id;
    private String stanje;
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

    public String getStanje() {
        return stanje;
    }

    public void setStanje(String stanje) {
        this.stanje = stanje;
    }

    public String getSmena() {
        return smena;
    }

    public void setSmena(String smena) {
        if (smena == null) {
            throw new NullPointerException("smena ne sme da bude null");
        }
        if (!Pattern.matches("^[0-2][0-3]:[0-5][0-9]-[0-2][0-3]:[0-5][0-9]$", smena)) {
            throw new IllegalArgumentException("nije dobro unesena smena");
        }
        this.smena = smena;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        if(dan == null) {
            throw new NullPointerException("dan ne sme da bude null");
        }
        if (!(dan == "Ponedeljak" || dan == "Utorak" || dan == "Sreda" || dan == "Cetvrtak"
                || dan == "Petak" || dan == "Subota" || dan == "Nedelja")) {
            throw new IllegalArgumentException("nije unesen dobar dan");
        }
        this.dan = dan;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        if(paket == null) {
            throw new NullPointerException("paket ne sme da bude null");
        }
        this.paket = paket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id == null){
            throw new NullPointerException("id ne sme biti null");
        }
        if( id.equals("0") || id.contains("-")){
            throw new RuntimeException("id ne sme biti nula, niti negativan broj");
        }
        this.id = id;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        if(trener == null) {
            throw new NullPointerException("trener ne sme da bude null");
        }
        this.trener = trener;
    }

    @Override
    public String vratiImeTabele() {
        return "termin";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s'", id, smena, dan, paket.getPaketId(), trener.getTrenerId());
    }

    @Override
    public String vratiPK() {
        return "terminId";
    }

    @Override
    public String vratiVrednostPK() {
        return id;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    @Override
    public String vratiUpdate() {

        return String.format("terminId='%s',smena='%s',dan='%s',paketId='%s',trenerId='%s'", id, smena, dan, paket.getPaketId(), trener.getTrenerId());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.id = pk;
    }

}
