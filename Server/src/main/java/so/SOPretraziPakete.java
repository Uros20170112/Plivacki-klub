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
 * Klasa koja pretrazuje sve pakete. Nasledjuje AbstractSO i implementira metodu
 * execute.
 *
 * @author kompic
 */
public class SOPretraziPakete extends AbstractSO {

    private String pretraga;
    private List<AbstractObject> listaNadjenih = new ArrayList<>();

    /**
     * Pokrece metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        List<AbstractObject> sviPaketi = dbb.select(new Paket());
        for (AbstractObject abs : sviPaketi) {
            Paket pak = (Paket) abs;
            if (pak.getNaziv().contains(pretraga) || pak.getCena().contains(pretraga)) {
                listaNadjenih.add(pak);
            }
        }
        ucitajTermine();
    }

    /**
     * Vraca pretagu.
     *
     * @return String
     */
    public String getPretraga() {
        return pretraga;
    }

    /**
     * Postavlja vrednosti za pretragu.
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
     * Poziva metodu select kako bi nasla sve termine koristeci primarni kljuc
     * za pakete, pravi objekat Paket i postavlja ga u Termin.
     *
     * @throws ServerskiException
     */
    private void ucitajTermine() throws ServerskiException {
        List<AbstractObject> termini = dbb.select(new Termin());
        for (AbstractObject AbstractObject : listaNadjenih) {
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
