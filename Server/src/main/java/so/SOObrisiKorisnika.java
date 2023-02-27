/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 *
 * @author kompic
 */
public class SOObrisiKorisnika extends AbstractSO {

    private AbstractObject korisnik;

    public SOObrisiKorisnika(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        dbb.obrisiObjekat(korisnik);
    }

    public AbstractObject getKorisnik() {
        return korisnik;
    }
}
