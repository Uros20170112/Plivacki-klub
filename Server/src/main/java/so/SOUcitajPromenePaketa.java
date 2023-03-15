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

    private List<PromenaPaketa> listaIstorijatPaketa;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaIstorijatPaketa = (List<PromenaPaketa>) (PromenaPaketa) dbb.select(new PromenaPaketa());
        ucitajClanovePakete();
    }

    public List<PromenaPaketa> getListaIstorijatPaketa() {
        return listaIstorijatPaketa;
    }

    public void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : listaIstorijatPaketa) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            Paket p = (Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId());
            Clan c = (Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId());
            ip.setClan(c);
            ip.setPaket(p);
        }
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
