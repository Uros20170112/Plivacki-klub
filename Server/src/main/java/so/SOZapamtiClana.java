/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;
import java.util.List;

/**
 * Klasa koja cuva clana. Nasledjuje AbstractSO i implementira metodu execute
 *
 * @author kompic
 */
public class SOZapamtiClana extends AbstractSO {

    private AbstractObject clan;
    private AbstractObject istorijatPaketa;

    public SOZapamtiClana() {
    }

    /**
     * Parametrizovani konstruktor
     *
     * @param parametri
     */
    public SOZapamtiClana(List<Object> parametri) {
        this.clan = (AbstractObject) parametri.get(0);
        this.istorijatPaketa = (AbstractObject) parametri.get(1);
    }

    /**
     * Poziva insert metodu iz DBBroker-a za clana i istoriju paketa,
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(clan);
        dbb.insert(istorijatPaketa);
    }

    /**
     * Vraca clana
     *
     * @return AbstractObject
     */
    public AbstractObject getClan() {
        return clan;
    }

}
