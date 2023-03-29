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
 * Klasa koja predstavlja pretplatu u plivackom klubu i koja nasledjuje
 * apstraktnu klasu AbstractObject i implementira njene metode.
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
        this.vaziDo = vaziDo;
    }

    public Pretplata() {
    }

    /**
     * Vraca id pretplate
     *
     * @return String pretplataId
     */
    public String getPretplataId() {
        return pretplataId;
    }

    /**
     * Postavlja vrednost za id pretplate
     *
     * @param pretplataId pretplataId je String, ne sme biti null, prazan string
     * ili 0 i negativan broj.
     * @throws NullPointerException ako je pretplataId null.
     * @throws IllegalArgumentException ako je pretplataId prazan String.
     * @throws RuntimeException ako je pretplataId 0 ili negativan broj.
     */
    public void setPretplataId(String pretplataId) {
        if (pretplataId == null) {
            throw new NullPointerException("id pretplate ne sme biti null");
        }
        if (pretplataId.equals("")) {
            throw new IllegalArgumentException("id pretplate ne sme biti prazan string");
        }
        if (pretplataId.equals("0") || pretplataId.contains("-")) {
            throw new RuntimeException("id pretplate ne sme biti nula, niti negativan broj");
        }
        this.pretplataId = pretplataId;
    }

    /**
     * Vraca datum pretplate
     *
     * @return Date datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * Postavlja vrednost za datum pretplate
     *
     * @param datum datum ne sme biti null i opre danasnjeg datuma.
     * @throws NullPointerException ako je datum null.
     * @throws RuntimeException ako je datum pre danasnjeg datuma.
     */
    public void setDatum(Date datum) {
        if (datum == null) {
            throw new NullPointerException("datum ne sme biti null");
        }
        if (datum.before(new Date())) {
            throw new RuntimeException("datum ne sme biti pre danasnjeg datuma");
        }
        this.datum = datum;
    }

    /**
     * Vraca clana koji pripada pretplati
     *
     * @return Clan clan
     */
    public Clan getClan() {
        return clan;
    }

    /**
     * Postavlja vrednost za clana
     *
     * @param clan clan ne sme biti null
     * @throws NullPointerException ako je clan null.
     */
    public void setClan(Clan clan) {
        if (clan == null) {
            throw new NullPointerException("clan ne sme biti null");
        }
        this.clan = clan;
    }

    /**
     * Vraca paket koji pripada pretplati
     *
     * @return Paket paket
     */
    public Paket getPaket() {
        return paket;
    }

    /**
     * Postavlja vrednost za datum vezenja paketa
     *
     * @param vaziDo vazi do ne sme biti null i pre danasnjeg datuma
     * @throws NullPointerException ako je vaziDo null.
     * @throws RuntimeException ako je vaziDo pre datuma ili danasnjeg datuma.
     */
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

    /**
     * Vraca datum vazenja paketa
     *
     * @return Date vaziDo
     */
    public Date getVaziDo() {
        return vaziDo;
    }

    /**
     * Postavlja vrednost paketa za pretplatu
     *
     * @param paket paket ne sme biti null.
     * @throws NullPointerException ako je paket null.
     */
    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new NullPointerException("paket ne sme biti null");
        }
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
        return String.format("'%s', '%s', '%s', '%s', '%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(), datumDoSQL);
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Pretplata i vraca
     * je
     *
     * @param rs rs je resultset
     * @return lista objekata Pretplata
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
                        new Paket(paketId, null, null), VAZIDO);

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
        return String.format("pretplataId='%s',datum='%s',clanId='%s',,paketId='%s', vaziDo='%s'", pretplataId, datumSQL, clan.getClanId(), paket.getPaketId(), datumDoSQL);
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk pk je primanri kljuc
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.pretplataId = pk;
    }

}
