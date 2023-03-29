/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;
import kontroler.Kontroler;

/**
 * Klasa koja izloguje trenutno ulogovanog korisnika. Nasledjuje AbstractSO i
 * implementira metodu execute.
 *
 * @author kompic
 */
public class SOIzlogujKorisnika extends AbstractSO {

    private AbstractObject korisnik;

    /**
     * Poziva metodu da se izloguje korisnik.
     *
     * @param ao prosledjeni korisnik.
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        int indeks = Kontroler.getInstance().getListaAktivnihKorisnika().indexOf(korisnik);
        if (indeks != -1) {
            Kontroler.getInstance().getListaAktivnihKorisnika().remove(indeks);
        }
    }

    /**
     * Vraca korisnika.
     *
     * @return Korisnik
     */
    public AbstractObject getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja korisnika.
     *
     * @param korisnik uneti korisnik.
     */
    public void setKorisnik(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

}
