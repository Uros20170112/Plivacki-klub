/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 * Klasa koja menja trenutno izabranog trenera. Nasledjuje AbstractSO i
 * implementira metodu execute.
 *
 * @author kompic
 */
public class SOIzmeniTrenera extends AbstractSO {

    /**
     * privatna promenljiva trener
     */
    private AbstractObject trener;

    /**
     * Parametrizovani konstruktor
     *
     * @param trener
     */
    public SOIzmeniTrenera(AbstractObject trener) {
        this.trener = trener;
    }

    /**
     * Poziva metodu update iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.update(trener);
    }

    /**
     * Vraca trenera
     *
     * @return Trener
     */
    public AbstractObject getTrener() {
        return trener;
    }

}
