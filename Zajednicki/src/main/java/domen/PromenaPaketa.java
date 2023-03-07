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
    private Clan clan;
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

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumOdabira() {
        return datumOdabira;
    }

    public void setDatumOdabira(Date datumOdabira) {
        if(datumOdabira == null) {
            throw new NullPointerException("datum ne sme biti null");
        }
        this.datumOdabira = datumOdabira;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        if (clan == null) {
            throw new NullPointerException("clan ne sme biti null");
        }
        this.clan = clan;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new NullPointerException("paket ne sme biti null");
        }
        this.paket = paket;
    }

    @Override
    public String vratiImeTabele() {
        return "istorijatpaketa";
    }

    @Override
    public String vratiParametre() {
        int aktivanBr = 0;
        Date datumSQL = new java.sql.Date(getDatumOdabira().getTime());
        if (aktivan) {
            aktivanBr = 1;
        }
        return String.format("'%s', '%s', '%s', '%s', '%s'", aktivanBr, datumSQL, clan.getClanId(), paket.getPaketId(), id);
    }

    @Override
    public String vratiPK() {
        return "id";
    }

    @Override
    public String vratiVrednostPK() {
        return id;
    }

    @Override
    public String vratiSlozenPK() {
        return "id=" + id + " AND paketId=" + getPaket().getPaketId()
                + " AND clanId=" + getClan().getClanId();
    }

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

    @Override
    public void postaviVrednostPK(String pk) {
        this.id = pk;
    }

}
