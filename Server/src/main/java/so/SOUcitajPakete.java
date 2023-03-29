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
 * Klasa koja ucitava sve pakete. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajPakete extends AbstractSO {

    private List<Paket> paketi;

    /**
     * Pokrece metodu select iz DBBroke-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        paketi = (List<Paket>) (Paket) dbb.select(new Paket());
        ucitajTermine();
    }

    /**
     * Vraca listu svih paketa.
     *
     * @return List<Paket>
     */
    public List<Paket> getPaketi() {
        return paketi;
    }

    /**
     * Poziva metodu select kako bi nasla sve termine koristeci primarni kljuc
     * za pakete, pravi objekat Paket i postavlja ga u Termin.
     *
     * @throws ServerskiException
     */
    private void ucitajTermine() throws ServerskiException {
        List<AbstractObject> termini = dbb.select(new Termin());
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
