/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Clan;
import domen.Mesto;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOUcitajClanove extends AbstractSO {

    private List<Clan> listaClanova;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaClanova = (List<Clan>) (Clan) dbb.select(new Clan());
        ucitajMesta();
    }

    public List<Clan> getListaClanova() {
        return listaClanova;
    }

    private void ucitajMesta() throws ServerskiException {
        for (AbstractObject abs : listaClanova) {
            Clan cl = (Clan) abs;
            String mestoID = cl.getMesto().getMestoId();
            Mesto m = (Mesto) dbb.selectWithPK(new Mesto(), mestoID);
            cl.setMesto(m);
        }
    }

}
