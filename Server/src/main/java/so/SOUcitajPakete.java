/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Paket;
import domen.Termin;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kompic
 */
public class SOUcitajPakete extends AbstractSO {

    private List<AbstractObject> paketi;

    @Override
    protected void izvrsiKonkretnuOperaciju() throws ServerskiException {
        paketi = dbb.vratiSveObjekte(new Paket());
        ucitajTermine();
    }

    public List<AbstractObject> getPaketi() {
        return paketi;
    }

    private void ucitajTermine() throws ServerskiException {
        List<AbstractObject> termini = dbb.vratiSveObjekte(new Termin());
        for (AbstractObject AbstractObject : paketi) {
            Paket p = (Paket) AbstractObject;
            List<Termin> terminiPaketa = new ArrayList<>();
            for (AbstractObject abstractObjekat1 : termini) {
                Termin t = (Termin) abstractObjekat1;
                if (t.getPaket().getPaketId().equals(p.getPaketId())) {
                    t.setPaket(p);
                    terminiPaketa.add(t);
                }
            }
            p.setTermini(terminiPaketa);
        }
    }

}
