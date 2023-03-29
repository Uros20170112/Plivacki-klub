/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 * Klasa koja cuva pretplatu. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOZapamtiPretplatu extends AbstractSO {

    private AbstractObject pretplata;

    /**
     * Parametrizovani konstruktor
     *
     * @param pretplata
     */
    public SOZapamtiPretplatu(AbstractObject pretplata) {
        this.pretplata = pretplata;
    }

    /**
     * Poziva insert metodu iz DBBroer-a/
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(pretplata);
    }

    /**
     * Vraca pretplatu.
     *
     * @return AbstractObject
     */
    public AbstractObject getPretplata() {
        return pretplata;
    }

}
