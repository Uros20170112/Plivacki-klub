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
 * Klasa koja Menja trenutno izabranog clana. Nasledjuje AbstractSO i
 * implementira metodu execute.
 *
 * @author kompic
 */
public class SOIzmeniClana extends AbstractSO {

    private AbstractObject clan;
    private AbstractObject istorijatPaketa;
    PromenaPaketa istorijatP;
    List<AbstractObject> izBaze;

    /**
     * Menja izabranog clana
     *
     * @param parametri prvi parametar je instanca klase Clan, drugi je
     * PromenaPaketa.
     */
    public SOIzmeniClana(List<Object> parametri) {
        super();
        this.clan = (AbstractObject) parametri.get(0);
        this.istorijatPaketa = (AbstractObject) parametri.get(1);
        this.istorijatP = (PromenaPaketa) parametri.get(1);
    }

    /**
     * Poziva metodu select iz DBBroker-a.
     *
     * @param ao prosledjeni clan.
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {

        dbb.update(clan);
        izBaze = dbb.select(new PromenaPaketa());
        ucatijClanovePakete();

        if (daLiMenjam()) {
            deaktiviraj();
            dodaj();
        }
    }

    /**
     * Vraca clana
     *
     * @return Clan
     */
    public AbstractObject getClan() {
        return clan;
    }

    /**
     * Ucitava sbe clanove paketa.
     *
     * @throws ServerskiException
     */
    private void ucatijClanovePakete() throws ServerskiException {
        for (AbstractObject abs : izBaze) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            ip.setClan((Clan) dbb.selectWithPK(new Clan(), ip.getClan().getClanId()));
            ip.setPaket((Paket) dbb.selectWithPK(new Paket(), ip.getPaket().getPaketId()));
        }
    }

    /**
     * Proverava iz baze da li da menja paket.
     *
     * @return
     */
    private boolean daLiMenjam() {
        for (AbstractObject abs : izBaze) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            if (ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * Proverava iz baze da li deaktivira paket.
     *
     * @throws ServerskiException
     */
    private void deaktiviraj() throws ServerskiException {
        for (AbstractObject abs : izBaze) {
            PromenaPaketa ip = (PromenaPaketa) abs;
            if (ip.getClan().equals(istorijatP.getClan())
                    && !ip.getPaket().equals(istorijatP.getPaket())
                    && ip.isAktivan() == true) {
                ip.setAktivan(false);
                dbb.update(ip);
            }
        }
    }

    /**
     * Poziva metodu insert iz DBBroker-a.
     *
     * @throws ServerskiException
     */
    private void dodaj() throws ServerskiException {
        dbb.insert(istorijatPaketa);
    }

}
