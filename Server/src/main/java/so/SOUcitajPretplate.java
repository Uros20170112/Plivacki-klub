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

    private List<Pretplata> pretplate;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        pretplate = (List<Pretplata>) (Pretplata) dbb.select(new Pretplata());
        ucitajClanovePakete();
    }

    public List<Pretplata> getPretplate() {
        return pretplate;
    }

    private void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : pretplate) {
            Pretplata ip = (Pretplata) abs;
            ip.setClan((Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId()));
            ip.setPaket((Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId()));
        }
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
