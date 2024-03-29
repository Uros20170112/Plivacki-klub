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
 * Klasa koja pretrazuje sve clanove. Nasledjuje AbstractSO i implementira
 * metodu execute.
 *
 * @author kompic
 */
public class SOPretraziClanove extends AbstractSO {

    private String pretraga;
    private List<AbstractObject> sviClanovi;
    private List<AbstractObject> listaNadjenih = new ArrayList<>();

    /**
     * Pokrece metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        sviClanovi = dbb.select(new Clan());
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

    /**
     * Vraca pretragu.
     *
     * @return String
     */
    public String getPretraga() {
        return pretraga;
    }

    /**
     * Postavlja vrednost za pretragu.
     *
     * @param pretraga String koji oznacava pretragu.
     */
    public void setPretraga(String pretraga) {
        this.pretraga = pretraga;
    }

    /**
     * Vraca listu nadjenih Clanova
     *
     * @return List<AbstractObject>
     */
    public List<AbstractObject> getListaNadjenih() {
        return listaNadjenih;
    }

    /**
     * Posatavlja vrednosti za listu.
     *
     * @param listaNadjenih lista nadjenih clanova.
     */
    public void setListaNadjenih(List<AbstractObject> listaNadjenih) {
        this.listaNadjenih = listaNadjenih;
    }

    /**
     * Poziva metodu select kako bi nasla sva mesta koristeci primarni kljuc za
     * mesta koji se nalaze u clanovima, pravi objekat Mesto i postavlja ga u
     * Clan.
     *
     * @throws ServerskiException
     */
    private void ucitajMesta() throws ServerskiException {
        for (AbstractObject abs : sviClanovi) {
            Clan cl = (Clan) abs;
            cl.setMesto((Mesto) dbb.selectWithPK(new Mesto(), cl.getMesto().getMestoId()));
        }
    }

}
