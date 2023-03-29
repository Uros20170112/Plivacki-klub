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
 * Klasa koja pretrazuje sve pakete. Nasledjuje AbstractSO i implementira metodu
 * execute.
 *
 * @author kompic
 */
public class SOPretraziPretplate extends AbstractSO {

    AbstractObject paket;
    List<AbstractObject> pretplate;

    /**
     * Parametrizovani konstruktor.
     *
     * @param paket
     */
    public SOPretraziPretplate(AbstractObject paket) {
        this.paket = paket;
        this.pretplate = new ArrayList<>();
    }

    /**
     * Pokrece metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
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

    /**
     * Vraca listu pretplata.
     *
     * @return List<AbstractObject>
     */
    public List<AbstractObject> getPretplate() {
        return pretplate;
    }

}
