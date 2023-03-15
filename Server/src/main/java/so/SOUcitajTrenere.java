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
 *
 * @author kompic
 */
public class SOUcitajTrenere extends AbstractSO {

    private List<Trener> lista;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        lista = (List<Trener>) (Trener) dbb.select(new Trener());
    }

    public List<Trener> getLista() {
        return lista;
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
