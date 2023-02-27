/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Clan;
import domen.Paket;
import domen.Pretplata;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOUcitajPretplate extends AbstractSO {

    private List<AbstractObject> pretplate;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        pretplate = dbb.vratiSveObjekte(new Pretplata());
        ucitajClanovePakete();
    }

    public List<AbstractObject> getPretplate() {
        return pretplate;
    }

    private void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : pretplate) {
            Pretplata ip = (Pretplata) abs;
            ip.setClan((Clan) dbb.vratiObjekatPoKljucu(new Clan(), ip.getClan().getClanId()));
            ip.setPaket((Paket) dbb.vratiObjekatPoKljucu(new Paket(), ip.getPaket().getPaketId()));
        }
    }

}
