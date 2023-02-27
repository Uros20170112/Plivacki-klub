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
public class SOObrisiTrenera extends AbstractSO{
    private AbstractObject trener;

    public SOObrisiTrenera(AbstractObject trener) {
        this.trener = trener;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        dbb.obrisiObjekat(trener);
    }

    public AbstractObject getTrener() {
        return trener;
    }
}
