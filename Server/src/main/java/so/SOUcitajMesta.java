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

    private List<Mesto> listaMesta;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaMesta = (List<Mesto>) (Mesto) dbb.select(new Mesto());
    }

    public List<Mesto> getListaMesta() {
        return listaMesta;
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
