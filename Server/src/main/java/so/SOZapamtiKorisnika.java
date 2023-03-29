/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 * Klasa koja cuva korisnika. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOZapamtiKorisnika extends AbstractSO {

    private AbstractObject korisnik;

    /**
     * Parametrizovani konstrukor
     *
     * @param korisnik
     */
    public SOZapamtiKorisnika(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

    /**
     * Poziva inert metodu iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(korisnik);
    }

    /**
     * Vraca korisnika
     *
     * @return AbstractObject
     */
    public AbstractObject getKorisnik() {
        return korisnik;
    }
}
