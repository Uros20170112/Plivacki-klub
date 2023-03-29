/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 * Klasa koja brise trenutno izabranog clana. Nasledjuje AbstractSO i
 * implementira metodu execute.
 *
 * @author kompic
 */
public class SOObrisiClana extends AbstractSO {

    /**
     * Pokrece metodu delete iz DBBroker-a.
     *
     * @param ao prosledjuje clana.
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.delete(ao);
    }

}
