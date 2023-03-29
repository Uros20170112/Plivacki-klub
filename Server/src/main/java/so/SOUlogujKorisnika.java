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
import kontroler.Kontroler;

/**
 * Klasa koja prijavljuje Korisnika. Nasledjuje AbstractSO i implementira metodu
 * execute
 *
 * @author kompic
 */
public class SOUlogujKorisnika extends AbstractSO {

    private AbstractObject unetiParametri;
    private AbstractObject ulogovanKorisnik;

    /**
     * Poziva select metodu iz DBBroker-a i iz liste svih korisnikika uporedjuje
     * unete parametre i prijavljuje odgovarajuceg korisnika
     *
     * @param ao
     * @throws ServerskiException
     */
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        List<AbstractObject> listaKorisnika = dbb.select(new Korisnik());
        Korisnik unetiKorisnik = (Korisnik) unetiParametri;
        for (AbstractObject AbstractObject : listaKorisnika) {
            Korisnik izBaze = (Korisnik) AbstractObject;
            if (izBaze.equals(unetiKorisnik)) {
                ulogovanKorisnik = izBaze;
                List<Korisnik> aktivni = Kontroler.getInstance().getListaAktivnihKorisnika();
                if (aktivni.contains(ulogovanKorisnik)) {
                    throw new ServerskiException("Korisnik je vec ulogovan!");
                } else {
                    Kontroler.getInstance().getListaAktivnihKorisnika().add((Korisnik) ulogovanKorisnik);
                }
                System.out.println("Ubacio korisnika u listu ulogovanih.");
                return;
            }
        }
        throw new ServerskiException("Nije pronadjen korisnik!");
    }

    /**
     * Vraca unete parametre.
     *
     * @return AbstractObject
     */
    public AbstractObject getUnetiParametri() {
        return unetiParametri;
    }

    /**
     * Postavlja unete parametre.
     *
     * @param unetiParametri
     */
    public void setUnetiParametri(AbstractObject unetiParametri) {
        this.unetiParametri = unetiParametri;
    }

    /**
     * Vraca ulogovanog korisnika.
     *
     * @return AbstractObject
     */
    public AbstractObject getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    /**
     * Postavlja ulogovanog korisnika.
     *
     * @param ulogovanKorisnik
     */
    public void setUlogovanKorisnik(AbstractObject ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

}
