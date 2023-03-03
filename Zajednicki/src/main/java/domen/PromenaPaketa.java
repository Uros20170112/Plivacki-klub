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
public class PromenaPaketa extends AbstractObject {

    private boolean aktivan;
    private Date datumOdabira;
    /**
     * Clan koji pripada promeni paketa
     */
    private Clan clan;
    /**
     * Paket koji se menja
     */
    private Paket paket;
    private String id;

    public PromenaPaketa() {
    }

    public PromenaPaketa(boolean aktivan, Date datumOdabira, Clan clan, Paket paket, String id) {
        this.aktivan = aktivan;
        this.datumOdabira = datumOdabira;
        this.clan = clan;
        this.paket = paket;
        this.id = id;
    }

    /**
     * Vraca da li je paket aktivan
     *
     * @return boolean aktivan
     */
    public boolean isAktivan() {
        return aktivan;
    }

    /**
     * Postavlja vrednost za parametar aktivan
     *
     * @param aktivan
     */
    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    /**
     * Vraca datum odaabranog paketa
     *
     * @return Date datumOdabira
     */
    public Date getDatumOdabira() {
        return datumOdabira;
    }

    /**
     * Postavlja vrednost za datum
     *
     * @param datumOdabira
     */
    public void setDatumOdabira(Date datumOdabira) {
        this.datumOdabira = datumOdabira;
    }

    /**
     * Vraca clana koji pripada promeni paketa
     *
     * @return Clan clan
     */
    public Clan getClan() {
        return clan;
    }

    /**
     * Postavlja vrednost za clana
     *
     * @param clan
     */
    public void setClan(Clan clan) {
        this.clan = clan;
    }

    /**
     * Vraca paket za promenu paketa
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
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "istorijatpaketa";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        int aktivanBr = 0;
        Date datumSQL = new java.sql.Date(getDatumOdabira().getTime());
        if (aktivan) {
            aktivanBr = 1;
        }
        return String.format("'%s', '%s', '%s', '%s', '%s'", aktivanBr, datumSQL, clan.getClanId(), paket.getPaketId(), id);
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "id";
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
        return "id=" + id + " AND paketId=" + getPaket().getPaketId()
                + " AND clanId=" + getClan().getClanId();
    }

    /**
     * Prima ResultSet(tabelu) i pretvara je u listu objekata PromenaPaketa i
     * vraca je
     *
     * @param rs
     * @return lista objekata PromenaPaketa
     * @throws SQLException ako dodje do greske prilikom izvrsavanja upita
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> listaIP = new ArrayList<>();
        try {
            while (rs.next()) {

                boolean aktivan = rs.getBoolean("aktivan");
                Date datumOdabira = rs.getDate("datumOdabira");
                String clanId = rs.getString("clanId");
                String paketId = rs.getString("paketId");
                String id = rs.getString("id");

                PromenaPaketa ip = new PromenaPaketa(aktivan, datumOdabira,
                        new Clan(clanId, null, null, null, null, null, null),
                        new Paket(paketId, null, null), id);
                listaIP.add(ip);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod clana");
        }
        return listaIP;
    }

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        Date datumSQL = new java.sql.Date(getDatumOdabira().getTime());
        int rd = 0;
        if (aktivan == true) {
            rd = 1;
        } else {
            rd = 0;
        }
        return String.format("aktivan='%s',datumOdabira='%s',clanId='%s'"
                + ",paketId='%s',id='%s'",
                rd, datumSQL, clan.getClanId(), paket.getPaketId(), id);
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
