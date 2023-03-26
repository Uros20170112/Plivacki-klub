/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 *
 * @author kompic
 */
public class SOZapamtiKorisnika extends AbstractSO {

    private AbstractObject korisnik;

    public SOZapamtiKorisnika(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(korisnik);
    }

    public AbstractObject getKorisnik() {
        return korisnik;
    }
}
