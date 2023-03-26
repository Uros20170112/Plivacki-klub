/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;
import kontroler.Kontroler;

/**
 *
 * @author kompic
 */
public class SOIzlogujKorisnika extends AbstractSO {

    private AbstractObject korisnik;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        int indeks = Kontroler.getInstance().getListaAktivnihKorisnika().indexOf(korisnik);
        if (indeks != -1) {
            Kontroler.getInstance().getListaAktivnihKorisnika().remove(indeks);
        }
    }

    public AbstractObject getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

}
