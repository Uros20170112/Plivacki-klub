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
 *
 * @author kompic
 */
public class SOUcitajKorisnike extends AbstractSO {

    private List<Korisnik> lista;

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        lista = (List<Korisnik>) (Korisnik) dbb.select(new Korisnik());
    }

    public List<Korisnik> getLista() {
        return lista;
    }

}
