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
        this.clan = (AbstractObject) parametri.get(0);
        this.istorijatPaketa = (AbstractObject) parametri.get(1);
        this.istorijatP = (PromenaPaketa) parametri.get(1);
    }

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        
        dbb.azurirajObjekat(clan);
        izBaze = dbb.vratiSveObjekte(new PromenaPaketa());
        ucatijaClanovePakete();
        
        if(daLiMenjam()){
            deaktiviraj();
            dodaj();
        }
    }

   
    public AbstractObject getClan() {
        return clan;
    }

    private void ucatijaClanovePakete() throws ServerskiException {
         for (AbstractObject abs : izBaze) {
                PromenaPaketa ip = (PromenaPaketa) abs;
                ip.setClan((Clan) dbb.vratiObjekatPoKljucu(new Clan(), ip.getClan().getClanId()));
                ip.setPaket((Paket) dbb.vratiObjekatPoKljucu(new Paket(), ip.getPaket().getPaketId()));
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
                  dbb.azurirajObjekat(ip);
            }
        }
    }

    private void dodaj() throws ServerskiException {
        dbb.sacuvajObjekat(istorijatPaketa);
    }
    
}
