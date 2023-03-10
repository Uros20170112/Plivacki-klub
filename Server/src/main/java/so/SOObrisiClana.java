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
public class SOObrisiClana extends AbstractSO {

    private AbstractObject clan;

    public SOObrisiClana(AbstractObject clan) {
        this.clan = clan;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        clan = dbb.obrisiObjekat(clan);
    }

    public AbstractObject getClan() {
        return clan;
    }
}