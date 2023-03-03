/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author kompic
 */
public class Pretplata extends AbstractObject {

    private String pretplataId;
    private Date datum;
    private Date vaziDo;
    /**
     * Clan koji pripada pretplati
     */
    private Clan clan;
    /**
     * Paket koji pripada pretplati
     */
    private Paket paket;

    public Pretplata(String pretplataId, Date datum, Clan clan, Paket paket, Date vaziDo) {
        this.pretplataId = pretplataId;
        this.datum = datum;
        this.clan = clan;
        this.paket = paket;
        this.vaziDo=vaziDo;
    }

    public Pretplata() {
    }
/**
 * Vraca id pretplate
 * @return String pretplataId
 */
    public String getPretplata() {
        return pretplataId;
    }
/**
 * Postavlja vrednost za id pretplate
 * @param pretplata 
 */
    public void setPretplata(String pretplata) {
        this.pretplataId = pretplata;
    }
/**
 * Vraca datum pretplate
 * @return Date datum
 */
    public Date getDatum() {
        return datum;
    }
/**
 * Postavlja vrednost za datum pretplate
 * @param datum 
 */
    public void setDatum(Date datum) {
        this.datum = datum;
    }
/**
 * Vraca clana koji pripada pretplati
 * @return Clan clan
 */
    public Clan getClan() {
        return clan;
    }
/**
 * Postavlja vrednost za clana
 * @param clan 
 */
    public void setClan(Clan clan) {
        this.clan = clan;
    }
/**
 * Vraca paket koji pripada pretplati
 * @return Paket paket
 */
    public Paket getPaket() {
        return paket;
    }
/**
 * Postavlja vrednost za datum vezenja paketa
 * @param vaziDo 
 */
    public void setVaziDo(Date vaziDo) {
        this.vaziDo = vaziDo;
    }
/**
 * Vraca datum vazenja paketa
 * @return Date vaziDo
 */
    public Date getVaziDo() {
        return vaziDo;
    }
/**
 * Postavlja vrednost paketa za pretplatu
 * @param paket 
 */
    public void setPaket(Paket paket) {
        this.paket = paket;
    }
    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "pretplata";
    }
    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        Date datumDoSQL = new java.sql.Date(getVaziDo().getTime());
        return String.format("'%s', '%s', '%s', '%s', '%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(),datumDoSQL);
    }
    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "pretplataId";
    }
    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String pretplataId
     */
    @Override
    public String vratiVrednostPK() {
        return pretplataId;
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Pretplata i vraca je
     *
     * @param rs
     * @return lista objekata Pretplata
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> pretplate = new ArrayList<>();
        try {
            while (rs.next()) {

                String PRETPLATAID = rs.getString("pretplataId");
                Date DATUM = rs.getDate("datum");
                String clanId = rs.getString("clanId");
                String paketId = rs.getString("paketId");
                Date VAZIDO = rs.getDate("vaziDo");
                Pretplata p = new Pretplata(PRETPLATAID,
                        DATUM, new Clan(clanId, null, null, null, null, null, null),
                        new Paket(paketId, null, null),VAZIDO);

                pretplate.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod pretplate");
        }
        return pretplate;
    }
    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        Date datumDoSQL = new java.sql.Date(getVaziDo().getTime());
        return String.format("pretplataId='%s',datum='%s',clanId='%s',,paketId='%s', vaziDo='%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(),datumDoSQL);
    }
    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.pretplataId = pk;
    }

}
