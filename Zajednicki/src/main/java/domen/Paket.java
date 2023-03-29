/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Klasa koja predstavlja paket plivackog kluba i koja nasledjuje apstraktnu
 * klasu AbstractObject i implementira njene metode.
 *
 * @author kompic
 */
public class Paket extends AbstractObject {

    private String paketId;
    private String naziv;
    private String cena;
    /**
     * Lista termina koji pripadaju paketu
     */
    private List<Termin> termini;

    public Paket(String paketId, String naziv, String cena) {
        this.paketId = paketId;
        this.naziv = naziv;
        this.cena = cena;
    }

    public Paket() {
    }

    /**
     * Vraca String sa bitnim informacijama o paketu
     *
     * @return naziv i cenu clana
     */
    @Override
    public String toString() {
        if(naziv == null || cena == null) {
            throw new NullPointerException();
        }
        return naziv + " - " + cena + " RSD";
    }

    /**
     * Vraca id paketa
     *
     * @return String paketId
     */
    public String getPaketId() {
        return paketId;
    }

    /**
     * Postavlja vrednost id paketa
     *
     * @param paketId paketId je string, ne sme biti null, prazan string ili 0 i
     * negativan broj.
     * @throws NullPointerException ako je paketId null.
     * @throws IllegalArgumentException ako je paketId prazan String.
     * @throws RuntimeException ako je paketId 0 ili negativan broj.
     */
    public void setPaketId(String paketId) {
        if (paketId == null) {
            throw new NullPointerException("id mesta ne sme biti null");
        }
        if (paketId.equals("")) {
            throw new IllegalArgumentException("id mesta ne sme biti prazan string");
        }
        if (paketId.equals("0") || paketId.contains("-")) {
            throw new RuntimeException("id mesta ne sme biti nula, niti negativan broj");
        }
        this.paketId = paketId;
    }

    /**
     * Vraca naziv paketa
     *
     * @return String naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja vrednost za naziv paketa
     *
     * @param naziv naziv je String i ne sme da bude null ili krace od 2
     * karaktera.
     * @throws NullPointerException ako je naziv null.
     * @throws RuntimeException ako je naziv 0 ili negativan broj.
     */
    public void setNaziv(String naziv) {
        if (naziv == null) {
            throw new NullPointerException("naziv mesta ne sme biti null");
        }
        if (naziv.length() < 2) {
            throw new RuntimeException("naziv mesta ne sme biti krace od 2 karaktera");
        }
        this.naziv = naziv;
    }

    /**
     * Vraca cenu paketa
     *
     * @return String cena
     */
    public String getCena() {
        return cena;
    }

    /**
     * Postavlja vrednost za cenu paketa
     *
     * @param cena cena je String, en sme biti null i mora sadrzati samo cifre.
     * @throws NullPointerException ako je cena null.
     * @throws IllegalArgumentException ako u ceni nisu samo cifre.
     * @throws RuntimeException ako je cena negativan broj.
     */
    public void setCena(String cena) {
        if (cena == null) {
            throw new NullPointerException("cena mesta ne sme biti null");
        }
        char[] digit = cena.toCharArray();
        for (char c : digit) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("cena mora da sadrzi samo brojeve");
            }
        }
        if (cena.contains("-")) {
            throw new RuntimeException("cena ne sme biti negativan broj");
        }
        this.cena = cena;
    }

    /**
     *
     * @return vraca naziv tabele u bazi za clana kako bi mogao da se napravi
     * upit
     */
    @Override
    public String vratiImeTabele() {
        return "paket";
    }

    /**
     *
     * @return vraca parametre iz tabele
     */
    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", paketId, naziv, cena);
    }

    /**
     *
     * @return vraca ime primarnog kljuca
     */
    @Override
    public String vratiPK() {
        return "paketId";
    }

    /**
     * Vraca vrednost primarnog kljuca
     *
     * @return String paketId
     */
    @Override
    public String vratiVrednostPK() {
        return paketId;
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
     * Prima ResultSet(tabelu) i pretvara je u listu objekata Paket i vraca je
     *
     * @param rs rs je resultset
     * @return lista objekata Paket
     */
    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> paketi = new ArrayList<>();
        try {
            while (rs.next()) {
                String paketId = rs.getString("paketId");
                String naziv = rs.getString("naziv");
                String cena = rs.getString("cena");

                Paket p = new Paket(paketId, naziv, cena);
                paketi.add(p);
                //System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije.");
        }
        return paketi;
    }

    /**
     *
     * @return vraca formu za pravljenje SQL upita za update
     */
    @Override
    public String vratiUpdate() {
        return String.format("paketId='%s',naziv='%s',cena='%s'", paketId, naziv, cena);
    }

    /**
     * Postavlja vrednost primarnog kljuca
     *
     * @param pk pk je primarni kljuc
     */
    @Override
    public void postaviVrednostPK(String pk) {
        this.paketId = pk;
    }

    /**
     * Poredi dva objekta Paket i utvrdjuje da li su isti
     *
     * @param obj obj je objekat
     * @return
     * <ul>
     * <li>true ako su oba objekta klase Paket i imaju isti paketId
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
        final Paket other = (Paket) obj;
        if (!Objects.equals(this.paketId, other.paketId)) {
            return false;
        }
        return true;
    }

    /**
     * Vraca listu termina koji se nalaze u paketu
     *
     * @return termini
     */
    public List<Termin> getTermini() {
        return termini;
    }

    /**
     * Postavlja vrednost za listu termini
     *
     * @param termini termini su Termin
     */
    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

}
