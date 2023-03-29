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
 * Klasa koja ucitava sve clanove. Nasledjuje AbstractSO i implementira metodu
 * execute.
 *
 * @author kompic
 */
public class SOUcitajClanove extends AbstractSO {

    private List<Clan> listaClanova;

    /**
     * POkrece metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaClanova = (List<Clan>) (Clan) dbb.select(new Clan());
        ucitajMesta();
    }

    /**
     * Vraca listu clanova
     *
     * @return List<Clan>
     */
    public List<Clan> getListaClanova() {
        return listaClanova;
    }

    /**
     * Poziva metodu select kako bi nasla sva mesta koristeci primarni kljuc za
     * mesta koji se nalaze u clanovima, pravi objekat Mesto i postavlja ga u
     * Clan.
     *
     * @throws ServerskiException
     */
    private void ucitajMesta() throws ServerskiException {
        for (AbstractObject abs : listaClanova) {
            Clan cl = (Clan) abs;
            String mestoID = cl.getMesto().getMestoId();
            Mesto m = (Mesto) dbb.selectWithPK(new Mesto(), mestoID);
            cl.setMesto(m);
        }
    }

}
