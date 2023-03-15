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
 *
 * @author kompic
 */
public class SOUlogujKorisnika extends AbstractSO{

    private AbstractObject unetiParametri;
    private AbstractObject ulogovanKorisnik;

    
    @Override
    protected void execute() throws ServerskiException {
        List<AbstractObject> listaKorisnika = dbb.select(new Korisnik());
        Korisnik unetiKorisnik = (Korisnik) unetiParametri;
        for (AbstractObject AbstractObject : listaKorisnika) {
            Korisnik izBaze = (Korisnik) AbstractObject;
            if(izBaze.equals(unetiKorisnik)){
                ulogovanKorisnik = izBaze;
                List<AbstractObject> aktivni = Kontroler.getInstance().getListaAktivnihKorisnika();
                if(aktivni.contains(ulogovanKorisnik))
                    throw new ServerskiException("Korisnik je vec ulogovan!");
                else
                    Kontroler.getInstance().getListaAktivnihKorisnika().add(ulogovanKorisnik);
                System.out.println("Ubacio korisnika u listu ulogovanih.");
                return;
            }
        }
        throw new ServerskiException("Nije pronadjen korisnik!");
    }
    
    public AbstractObject getUnetiParametri() {
        return unetiParametri;
    }

    public void setUnetiParametri(AbstractObject unetiParametri) {
        this.unetiParametri = unetiParametri;
    }

    public AbstractObject getUlogovanKorisnik() {
        return ulogovanKorisnik;
    }

    public void setUlogovanKorisnik(AbstractObject ulogovanKorisnik) {
        this.ulogovanKorisnik = ulogovanKorisnik;
    }

    @Override
    protected void validate() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
