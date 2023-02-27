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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOPretraziClanove extends AbstractSO {

    private String pretraga;
    private List<AbstractObject> sviClanovi;
    private List<AbstractObject> listaNadjenih = new ArrayList<>();
    
    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        sviClanovi = dbb.vratiSveObjekte(new Clan());
        ucitajMesta();
        for (AbstractObject clanIzBaze : sviClanovi) {
            Clan clb = (Clan) clanIzBaze;
            if (clb.getIme().toLowerCase().contains(pretraga) || clb.getAdresa().toLowerCase().contains(pretraga)
                    || clb.getEmail().toLowerCase().contains(pretraga)
                    || clb.getMesto().getNaziv().toLowerCase().contains(pretraga)
                    || clb.getPrezime().toLowerCase().contains(pretraga)
                    || clb.getTelefon().toLowerCase().contains(pretraga)
                    || clb.getMesto().getNaziv().contains(pretraga)) {

                listaNadjenih.add(clb);
            }
        }
    }

    public String getPretraga() {
        return pretraga;
    }

    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

    public List<AbstractObject> getListaNadjenih() {
        return listaNadjenih;
    }

    public void setListaNadjenih(List<AbstractObject> listaNadjenih) {
        this.listaNadjenih = listaNadjenih;
    }

    private void ucitajMesta() throws ServerskiException {
        for (AbstractObject abs : sviClanovi) {
            Clan cl = (Clan) abs;
            cl.setMesto((Mesto) dbb.vratiObjekatPoKljucu(new Mesto(),cl.getMesto().getMestoid()));
        }
    }

}
