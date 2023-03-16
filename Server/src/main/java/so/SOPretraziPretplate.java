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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOPretraziPretplate extends AbstractSO {

    AbstractObject paket;
    List<AbstractObject> pretplate;

    public SOPretraziPretplate(AbstractObject paket) {
        this.paket = paket;
        this.pretplate = new ArrayList<>();
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        List<AbstractObject> svePretplate = dbb.select(new Pretplata());
        for (AbstractObject AbstractObject : svePretplate) {
            Pretplata p = (Pretplata) AbstractObject;
            if (p.getPaket().equals(paket)) {
                p.setClan((Clan) dbb.selectWithPK(new Clan(), p.getClan().getClanId()));
                p.setPaket((Paket) paket);
                pretplate.add(p);
            }
        }
    }

    public List<AbstractObject> getPretplate() {
        return pretplate;
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
