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
public class SOPretraziPakete extends AbstractSO {

    private String pretraga;
    private List<AbstractObject> listaNadjenih = new ArrayList<>();

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

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
