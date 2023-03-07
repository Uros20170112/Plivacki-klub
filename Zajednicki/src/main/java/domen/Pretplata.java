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
    private Clan clan;
    private Paket paket;

    public Pretplata(String pretplataId, Date datum, Clan clan, Paket paket, Date vaziDo) {
        this.pretplataId = pretplataId;
        this.datum = datum;
        this.clan = clan;
        this.paket = paket;
        this.vaziDo = vaziDo;
    }

    public Pretplata() {
    }

    public String getPretplata() {
        return pretplataId;
    }

    public void setPretplata(String pretplataId) {
        if (pretplataId == null) {
            throw new NullPointerException("id pretplate ne sme biti null");
        }
        if (pretplataId.equals("0") || pretplataId.contains("-")) {
            throw new RuntimeException("id pretplate ne sme biti nula, niti negativan broj");
        }
        this.pretplataId = pretplataId;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("datum ne sme biti null");
        }
        if (datum.before(new Date())) {
            throw new RuntimeException("datum ne sme biti pre danasnjeg datuma");
        }
        this.datum = datum;
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

    public void setVaziDo(Date vaziDo) {
        if (vaziDo == null) {
            throw new NullPointerException("vaziDo ne sme biti null");
        }
        if (vaziDo.before(new Date())) {
            throw new RuntimeException("vaziDo ne sme biti pre danasnjeg datuma");
        }
        if (vaziDo.before(datum)) {
            throw new RuntimeException("vaziDo ne sme biti pre datuma prijave");
        }
        this.vaziDo = vaziDo;
    }

    public Date getVaziDo() {
        return vaziDo;
    }

    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new NullPointerException("paket ne sme biti null");
        }
        this.paket = paket;
    }

    @Override
    public String vratiImeTabele() {
        return "pretplata";
    }

    @Override
    public String vratiParametre() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        Date datumDoSQL = new java.sql.Date(getVaziDo().getTime());
        return String.format("'%s', '%s', '%s', '%s', '%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(), datumDoSQL);
    }

    @Override
    public String vratiPK() {
        return "pretplataId";
    }

    @Override
    public String vratiVrednostPK() {
        return pretplataId;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

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
                        new Paket(paketId, null, null), VAZIDO);

                pretplate.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Greska RSuTabelu kod pretplate");
        }
        return pretplate;
    }

    @Override
    public String vratiUpdate() {
        Date datumSQL = new java.sql.Date(getDatum().getTime());
        Date datumDoSQL = new java.sql.Date(getVaziDo().getTime());
        return String.format("pretplataId='%s',datum='%s',clanId='%s',,paketId='%s', vaziDo='%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(), datumDoSQL);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.pretplataId = pk;
    }

}
