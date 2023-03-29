/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Paket;
import domen.Termin;
import exception.ServerskiException;

/**
 * Klasa koja cuva paket. Nasledjuje AbstractSO i implementira metodu execute
 *
 * @author kompic
 */
public class SOZapamtiPaket extends AbstractSO {

    private AbstractObject paket;

    /**
     * Parametrizovani konstruktor
     *
     * @param p
     */
    public SOZapamtiPaket(Paket p) {
        this.paket = p;
    }

    /**
     * Poziva insert metodu iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(paket);
        Paket pa = (Paket) paket;
        for (Termin ter : pa.getTermini()) {
            zapamtiTermin(ter);
        }
    }

    /**
     * Vraca paket
     *
     * @return AbstractObject
     */
    public AbstractObject getPaket() {
        return paket;
    }

    /**
     * Poziva insert metodu iz DBBroker-a za cuvanje termina.
     *
     * @param t
     * @throws ServerskiException
     */
    private void zapamtiTermin(Termin t) throws ServerskiException {
        dbb.insert(t);
    }

}
