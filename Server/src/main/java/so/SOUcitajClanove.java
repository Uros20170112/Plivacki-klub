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

    private List<AbstractObject> listaClanova;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaClanova = dbb.vratiSveObjekte(new Clan());
        ucitajMesta();
    }

    public List<AbstractObject> getListaClanova() {
        return listaClanova;
    }

    private void ucitajMesta() throws ServerskiException {
        for (AbstractObject abs : listaClanova) {
            Clan cl = (Clan) abs;
            String mestoID = cl.getMesto().getMestoid();
            Mesto m = (Mesto) dbb.vratiObjekatPoKljucu(new Mesto(), mestoID);
            cl.setMesto(m);
        }
    }

}
