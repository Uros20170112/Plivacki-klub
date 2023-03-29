/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 * Klasa koja cuva trenera. Nasledjuje AbstractSO i implementira metodu execute
 *
 * @author kompic
 */
public class SOZapamtiTrenera extends AbstractSO {

    private AbstractObject trener;
/**
 * Parametrizovani konstruktor.
 * @param trener 
 */
    public SOZapamtiTrenera(AbstractObject trener) {
        this.trener = trener;
    }
/**
 * Poziva metodu insert iz DBBroker-a.
 * @param ao
 * @throws ServerskiException 
 */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(trener);
    }
/**
 * Vraca trenera
 * @return AbstractObject
 */
    public AbstractObject getTrener() {
        return trener;
    }
}
