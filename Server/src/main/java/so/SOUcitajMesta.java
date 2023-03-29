/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Mesto;
import exception.ServerskiException;
import java.util.List;

/**
 * Klasa koja ucitava sva mesta. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajMesta extends AbstractSO {

    private List<Mesto> listaMesta;

    /**
     * Poziva metodu selct iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaMesta = (List<Mesto>) (Mesto) dbb.select(new Mesto());
    }

    /**
     * Vraca listu svih mesta.
     *
     * @return List<Mesto>
     */
    public List<Mesto> getListaMesta() {
        return listaMesta;
    }

}
