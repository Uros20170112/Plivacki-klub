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
 *
 * @author kompic
 */
public class SOUcitajMesta extends AbstractSO {
    
    private List<AbstractObject> listaMesta;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaMesta = dbb.vratiSveObjekte(new Mesto());
    }

    public List<AbstractObject> getListaMesta() {
        return listaMesta;
    }
    
}
