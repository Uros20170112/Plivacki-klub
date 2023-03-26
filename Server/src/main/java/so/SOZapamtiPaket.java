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
 *
 * @author kompic
 */
public class SOZapamtiPaket extends AbstractSO {

    private AbstractObject paket;

    public SOZapamtiPaket(Paket p) {
        this.paket = p;
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(paket);
        Paket pa = (Paket) paket;
        for (Termin ter : pa.getTermini()) {
            zapamtiTermin(ter);
        }
    }

    public AbstractObject getPaket() {
        return paket;
    }

    private void zapamtiTermin(Termin t) throws ServerskiException {
        dbb.insert(t);
    }

}
