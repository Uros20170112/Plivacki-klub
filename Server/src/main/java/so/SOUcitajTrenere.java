/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Trener;
import exception.ServerskiException;
import java.util.List;

/**
 * Klasa koja ucitava sve trenere. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajTrenere extends AbstractSO {

    private List<Trener> lista;

    /**
     * Poziva metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        lista = (List<Trener>) (Trener) dbb.select(new Trener());
    }

    /**
     * Vraca listu svih trenera.
     *
     * @return List<Trener>
     */
    public List<Trener> getLista() {
        return lista;
    }

}
