/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObject;
import domen.Clan;
import domen.Korisnik;
import domen.Paket;
import domen.Trener;
import exception.ServerskiException;
import java.util.ArrayList;
import java.util.List;
import so.*;

/**
 *
 * @author kompic
 */
public class Kontroler {

    private static Kontroler instance;

    private List<AbstractObject> listaAktivnihKorisnika;

    private Kontroler() {
        listaAktivnihKorisnika = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public AbstractObject ulogujKorisnika(Korisnik k) throws ServerskiException {
        SOUlogujKorisnika sok = new SOUlogujKorisnika();
        sok.setUnetiParametri(k);
        sok.izvrsiOperaciju();
        AbstractObject ulogovan = sok.getUlogovanKorisnik();
//        listaAktivnihKorisnika.add(ulogovan);
        return ulogovan;
    }

    public List<AbstractObject> getListaAktivnihKorisnika() {
        return listaAktivnihKorisnika;
    }

    public List<AbstractObject> vratiListuKorisnika() throws ServerskiException {
        SOUcitajKorisnike soul = new SOUcitajKorisnike();
        soul.izvrsiOperaciju();
        return soul.getLista();
    }

    public void izlogujKorisnika(AbstractObject korisnik) throws ServerskiException {
        SOIzlogujKorisnika soik = new SOIzlogujKorisnika();
        soik.setKorisnik(korisnik);
        soik.izvrsiOperaciju();
    }

    public List<AbstractObject> pretraziPakete(String string) throws ServerskiException {
        SOPretraziPakete soplj = new SOPretraziPakete();
        soplj.setPretraga(string);
        soplj.izvrsiOperaciju();
        return soplj.getListaNadjenih();
    }

    public List<AbstractObject> pretraziClanove(String pretr) throws ServerskiException {
        SOPretraziClanove soppp = new SOPretraziClanove();
        soppp.setPretraga(pretr);
        soppp.izvrsiOperaciju();
        return soppp.getListaNadjenih();
    }

    public AbstractObject sacuvajKorisnika(Korisnik k) throws ServerskiException {
        SOZapamtiKorisnika sozk = new SOZapamtiKorisnika(k);
        sozk.izvrsiOperaciju();
        return sozk.getKorisnik();
    }

    public void obrisiKorisnika(Korisnik k) throws ServerskiException {
        SOObrisiKorisnika sook = new SOObrisiKorisnika(k);
        sook.izvrsiOperaciju();
        listaAktivnihKorisnika.remove(k);
    }

    public void azurirajKorisnike() throws ServerskiException {
        List<AbstractObject> izBaze = vratiListuKorisnika();
        for (AbstractObject AbstractObject : izBaze) {
            Korisnik k = (Korisnik) AbstractObject;

            if (listaAktivnihKorisnika.contains(k)) {
                k.setStatusKorisnika("online");
            }
        }
        listaAktivnihKorisnika = izBaze;
    }

    public List<AbstractObject> ucitajMesta() throws ServerskiException {
        SOUcitajMesta sovm = new SOUcitajMesta();
        sovm.izvrsiOperaciju();
        return sovm.getListaMesta();
    }

    public List<AbstractObject> ucitajClanove() throws ServerskiException {
        SOUcitajClanove sovlc = new SOUcitajClanove();
        sovlc.izvrsiOperaciju();
        return sovlc.getListaClanova();
    }

    public List<AbstractObject> ucitajPromenePaketa() throws ServerskiException {
        SOUcitajPromenePaketa sovlc = new SOUcitajPromenePaketa();
        sovlc.izvrsiOperaciju();
        return sovlc.getListaIstorijatPaketa();
    }

    public List<AbstractObject> ucitajPakete() throws ServerskiException {
        SOUcitajPakete sovlc = new SOUcitajPakete();
        sovlc.izvrsiOperaciju();
        return sovlc.getPaketi();
    }

    public AbstractObject zapamtiClana(List<Object> parametri) throws ServerskiException {
        SOZapamtiClana som = new SOZapamtiClana(parametri);
        som.izvrsiOperaciju();
        return som.getClan();
    }

    public AbstractObject izmeniClana(List<Object> lista) throws ServerskiException {
        SOIzmeniClana soic = new SOIzmeniClana(lista);
        soic.izvrsiOperaciju();
        return soic.getClan();
    }

    public AbstractObject obrisiClana(Clan zaBrisanje) throws ServerskiException {
        SOObrisiClana som = new SOObrisiClana(zaBrisanje);
        som.izvrsiOperaciju();
        return som.getClan();
    }

    public AbstractObject zapamtiPaket(Paket p) throws ServerskiException {
        SOZapamtiPaket som = new SOZapamtiPaket(p);
        som.izvrsiOperaciju();
        return som.getPaket();
    }

    public AbstractObject azurirajPaket(Paket p) throws ServerskiException {
        SOIzmeniPaket soip = new SOIzmeniPaket(p);
        soip.izvrsiOperaciju();
        return soip.getPaket();
    }

    public List<AbstractObject> vratiSvePretplate() throws ServerskiException {
        SOUcitajPretplate soup = new SOUcitajPretplate();
        soup.izvrsiOperaciju();
        return soup.getPretplate();
    }

    public AbstractObject zapamtiPretplatu(AbstractObject pretplata) throws ServerskiException {
        SOZapamtiPretplatu sozp = new SOZapamtiPretplatu(pretplata);
        sozp.izvrsiOperaciju();
        return sozp.getPretplata();
    }

    public List<AbstractObject> pretraziPretplate(Paket pak) throws ServerskiException {
        SOPretraziPretplate sopp = new SOPretraziPretplate(pak);
        sopp.izvrsiOperaciju();
        return sopp.getPretplate();
    }

    public ArrayList<AbstractObject> vratiTrenere() throws ServerskiException {
        SOUcitajTrenere sout = new SOUcitajTrenere();
        sout.izvrsiOperaciju();
        return (ArrayList<AbstractObject>) sout.getLista();
    }

    public Trener zapamtiTrenera(Trener t) throws ServerskiException {
        SOZapamtiTrenera sozt = new SOZapamtiTrenera(t);
        sozt.izvrsiOperaciju();
        return (Trener) sozt.getTrener();
    }

    public Trener izmeniTrenera(Trener tr) throws ServerskiException {
        SOIzmeniTrenera soit = new SOIzmeniTrenera(tr);
        soit.izvrsiOperaciju();
        return (Trener) soit.getTrener();
    }

    public AbstractObject obrisiTrenera(Trener brisiTrenera) throws ServerskiException {
        SOObrisiTrenera soot = new SOObrisiTrenera(brisiTrenera);
        soot.izvrsiOperaciju();
        return soot.getTrener();
    }
}
