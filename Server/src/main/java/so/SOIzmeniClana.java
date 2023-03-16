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
public class SOIzmeniClana extends AbstractSO {

    private AbstractObject clan;
    private AbstractObject istorijatPaketa;
    PromenaPaketa istorijatP;
    List<AbstractObject> izBaze;
    

    public SOIzmeniClana(List<Object> parametri) {
        super();
        this.clan = (AbstractObject) parametri.get(0);
        this.istorijatPaketa = (AbstractObject) parametri.get(1);
        this.istorijatP = (PromenaPaketa) parametri.get(1);
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        
        dbb.update(clan);
        izBaze = dbb.select(new PromenaPaketa());
        ucatijClanovePakete();
        
        if(daLiMenjam()){
            deaktiviraj();
            dodaj();
        }
    }

   
    public AbstractObject getClan() {
        return clan;
    }

    private void ucatijClanovePakete() throws ServerskiException {
         for (AbstractObject abs : izBaze) {
                PromenaPaketa ip = (PromenaPaketa) abs;
                ip.setClan((Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId()));
                ip.setPaket((Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId()));
        }
    }

    private boolean daLiMenjam() {
        for (AbstractObject abs : izBaze) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            if(ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true){
                return true;
            }
        }
        return false;
    }

    private void deaktiviraj() throws ServerskiException {
        for (AbstractObject abs : izBaze) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            if(ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true){
                  ip.setAktivan(false);
                  dbb.update(ip);
            }
        }
    }

    private void dodaj() throws ServerskiException {
        dbb.insert(istorijatPaketa);
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
