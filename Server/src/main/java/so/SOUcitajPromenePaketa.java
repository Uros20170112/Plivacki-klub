/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Clan;
import domen.PromenaPaketa;
import domen.Paket;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOUcitajPromenePaketa extends AbstractSO {

    private List<AbstractObject> listaIstorijatPaketa;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        listaIstorijatPaketa = dbb.vratiSveObjekte(new PromenaPaketa());
        ucitajClanovePakete();
    }

    public List<AbstractObject> getListaIstorijatPaketa() {
        return listaIstorijatPaketa;
    }

    public void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : listaIstorijatPaketa) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            Paket p = (Paket) dbb.vratiObjekatPoKljucu(new Paket(), ip.getPaket().getPaketId());
            Clan c = (Clan) dbb.vratiObjekatPoKljucu(new Clan(), ip.getClan().getClanId());
            ip.setClan(c);
            ip.setPaket(p);
        }
    }

}
