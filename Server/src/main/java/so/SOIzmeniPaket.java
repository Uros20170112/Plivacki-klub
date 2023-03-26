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
public class SOIzmeniPaket extends AbstractSO {

    private AbstractObject paket;

    public SOIzmeniPaket(AbstractObject paket) {
        this.paket = paket;
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        Paket p = (Paket) paket;
        dbb.update(p);
        for (Termin termin : p.getTermini()) {
            switch (termin.getStanje()) {
                case "nov":
                    dbb.insert(termin);
                    break;
                case "izmenjen":
                    dbb.update(termin);
                    break;
                case "obrisan":
                    dbb.delete(termin);
                    break;
                default:

            }
        }
    }

    public AbstractObject getPaket() {
        return paket;
    }

}
