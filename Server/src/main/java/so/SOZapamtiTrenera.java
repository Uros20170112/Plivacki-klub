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
public class SOZapamtiTrenera extends AbstractSO{

    private AbstractObject trener;

    public SOZapamtiTrenera(AbstractObject trener) {
        this.trener = trener;
    }

    @Override
    protected void execute() throws ServerskiException {
        dbb.insert(trener);
    }

    public AbstractObject getTrener() {
        return trener;
    }
}
