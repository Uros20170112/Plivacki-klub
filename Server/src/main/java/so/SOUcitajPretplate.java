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
 * Klasa koja ucitava sve Pretplate. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajPretplate extends AbstractSO {

    private List<Pretplata> pretplate;

    /**
     * Poziva metodu select iz DBBroke-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        pretplate = (List<Pretplata>) (Pretplata) dbb.select(new Pretplata());
        ucitajClanovePakete();
    }

    /**
     * Vraca listu pretplata.
     *
     * @return List<Pretplata>
     */
    public List<Pretplata> getPretplate() {
        return pretplate;
    }

    /**
     * Poziva metodu select kako bi nasla sva mesta koristeci primarni kljuc za
     * clanove i pakete, pravi objekte Clan i Paket i postavlja ga u Pretplatu.
     *
     * @throws ServerskiException
     */
    private void ucitajClanovePakete() throws ServerskiException {
        for (AbstractObject abs : pretplate) {
            Pretplata ip = (Pretplata) abs;
            ip.setClan((Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId()));
            ip.setPaket((Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId()));
        }
    }

}
