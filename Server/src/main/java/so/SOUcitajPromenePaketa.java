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
 * Klasa koja ucitava sve promene paketa. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajPromenePaketa extends AbstractSO {

    private List<PromenaPaketa> listaIstorijatPaketa;

    /**
     * Poziva metodu select iz DBbroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        listaIstorijatPaketa = (List<PromenaPaketa>) (PromenaPaketa) dbb.select(new PromenaPaketa());
        ucitajClanovePakete();
    }

    /**
     * Vraca listu istorije promena paketa
     *
     * @return List<PromenaPaketa>
     */
    public List<PromenaPaketa> getListaIstorijatPaketa() {
        return listaIstorijatPaketa;
    }

    /**
     * Poziva metodu select kako bi nasla sva mesta koristeci primarni kljuc za
     * clanove i pakete, pravi objekte Clan i Paket i postavlja ga u Pretplatu.
     *
     * @throws ServerskiException
     */
    public void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : listaIstorijatPaketa) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            Paket p = (Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId());
            Clan c = (Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId());
            ip.setClan(c);
            ip.setPaket(p);
        }
    }
}
