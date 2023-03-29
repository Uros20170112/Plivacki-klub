/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import domen.Korisnik;
import exception.ServerskiException;
import java.util.List;

/**
 * Klasa koja ucitava sve korisnike. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUcitajKorisnike extends AbstractSO {

    private List<Korisnik> lista;

    /**
     * Poziva metodu select iz DBBroker-a.
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        lista = (List<Korisnik>) (Korisnik) dbb.select(new Korisnik());
    }

    /**
     * Vraca list svih korisnika.
     *
     * @return List<Korisnik>
     */
    public List<Korisnik> getLista() {
        return lista;
    }

}
