/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.AbstractObject;
import domen.Clan;
import domen.Korisnik;
import domen.Mesto;
import domen.Paket;
import domen.Pretplata;
import domen.PromenaPaketa;
import domen.Trener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.*;

/**
 * Kalsa koja sluzi kao kontroler u programu 'Server'. Prihvata zahteve od
 * klijenta i prosledjuje ih DBBroker-u, a od njega prihvata serverski odgovor i
 * vraca klijentu. Implementirana je kao singleton.
 *
 * @author kompic
 */
public class Kontroler {

    private static Kontroler instance;

    private List<Korisnik> listaAktivnihKorisnika;

    private Kontroler() {
        listaAktivnihKorisnika = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    /**
     * Vraca ulogovanog korisnika.
     *
     * @param k k je korisnik.
     * @return ulogovan
     */
    public AbstractObject ulogujKorisnika(Korisnik k) {
        try {
            SOUlogujKorisnika sok = new SOUlogujKorisnika();
            sok.setUnetiParametri(k);
            sok.templateExecute(k);
            AbstractObject ulogovan = sok.getUlogovanKorisnik();
            return ulogovan;
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Vraca listu aktivnih korisnika.
     *
     * @return listaAktivnihKorisnika
     */
    public List<Korisnik> getListaAktivnihKorisnika() {
        return listaAktivnihKorisnika;
    }

    /**
     * Vraca listu svih korisnika.
     *
     * @return List<Korisnik>
     */
    public List<Korisnik> vratiListuKorisnika() {
        try {
            SOUcitajKorisnike soul = new SOUcitajKorisnike();
            soul.templateExecute(new Korisnik());
            return soul.getLista();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Izloguje trenutno ulogovanog korisnika.
     *
     * @param korisnik trenutno aktivni korisnik.
     */
    public void izlogujKorisnika(AbstractObject korisnik) {
        try {
            SOIzlogujKorisnika soik = new SOIzlogujKorisnika();
            soik.setKorisnik(korisnik);
            soik.templateExecute(korisnik);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Pretrazuje pakete po unesenim parametrima.
     *
     * @param string uneseni parametar.
     * @return List<Paket>
     */
    public List<AbstractObject> pretraziPakete(String string) {
        try {
            SOPretraziPakete soplj = new SOPretraziPakete();
            soplj.setPretraga(string);
            soplj.templateExecute(new Paket());
            return soplj.getListaNadjenih();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Petrazuje clanove po unesenim parametrima.
     *
     * @param pretr uneseni parameta.
     * @return Clan
     */
    public List<AbstractObject> pretraziClanove(String pretr) {
        try {
            SOPretraziClanove soppp = new SOPretraziClanove();
            soppp.setPretraga(pretr);
            soppp.templateExecute(new Clan());
            return soppp.getListaNadjenih();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Cuva unesenog korisnika.
     *
     * @param k unesni korisnik.
     * @return Korisnik
     */
    public AbstractObject sacuvajKorisnika(Korisnik k) {
        try {
            SOZapamtiKorisnika sozk = new SOZapamtiKorisnika(k);
            sozk.templateExecute(k);
            return sozk.getKorisnik();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Brise izabreanog korisnika.
     *
     * @param k izabrani korisnik.
     */
    public void obrisiKorisnika(Korisnik k) {
        try {
            SOObrisiKorisnika sook = new SOObrisiKorisnika();
            sook.templateExecute(k);
            listaAktivnihKorisnika.remove(k);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Menja korisnika iz baze.
     */
    public void azurirajKorisnike() {
        List<Korisnik> izBaze = vratiListuKorisnika();
        for (AbstractObject AbstractObject : izBaze) {
            Korisnik k = (Korisnik) AbstractObject;

            if (listaAktivnihKorisnika.contains(k)) {
                k.setStatusKorisnika("online");
            }
        }
        listaAktivnihKorisnika = izBaze;
    }

    /**
     * Ucitava sva mesta koja se nalaze u bazi.
     *
     * @return List<Mesto>
     */
    public List<Mesto> ucitajMesta() {
        try {
            SOUcitajMesta sovm = new SOUcitajMesta();
            sovm.templateExecute(new Mesto());
            return sovm.getListaMesta();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Ucitava sve clanove koji se nalaze u bazi.
     *
     * @return List<Clan>
     */
    public List<Clan> ucitajClanove() {
        try {
            SOUcitajClanove sovlc = new SOUcitajClanove();
            sovlc.templateExecute(new Clan());
            return sovlc.getListaClanova();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Ucitava sve promenePaketa iz baze
     *
     * @return List<PromenaPaketa>
     */
    public List<PromenaPaketa> ucitajPromenePaketa() {
        try {
            SOUcitajPromenePaketa sovlc = new SOUcitajPromenePaketa();
            sovlc.templateExecute(new PromenaPaketa());
            return sovlc.getListaIstorijatPaketa();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Ucitava sve pakete iz Promene paketa
     *
     * @return List<Paket>
     */
    public List<Paket> ucitajPakete() {
        try {
            SOUcitajPakete sovlc = new SOUcitajPakete();
            sovlc.templateExecute(new Paket());
            return sovlc.getPaketi();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Ubacuje u bazu unetog clana.
     *
     * @param parametri parametri unetog clana.
     * @return Clan
     */
    public AbstractObject zapamtiClana(List<Object> parametri) {
        try {
            SOZapamtiClana som = new SOZapamtiClana(parametri);
            som.templateExecute(new Clan());
            return som.getClan();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Menja izabrenaog clana.
     *
     * @param lista lista clanova
     * @return Clan
     */
    public AbstractObject izmeniClana(List<Object> lista) {
        try {
            SOIzmeniClana soic = new SOIzmeniClana(lista);
            soic.templateExecute(new Clan());
            return soic.getClan();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Brise izabrenog clana.
     *
     * @param zaBrisanje izabrani clan za brisanje.
     */
    public void obrisiClana(Clan zaBrisanje) {
        try {
            SOObrisiClana som = new SOObrisiClana();
            som.templateExecute(zaBrisanje);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuva uneti paket u bazi.
     *
     * @param p uneti paket.
     * @return Paket
     */
    public AbstractObject zapamtiPaket(Paket p) {
        try {
            SOZapamtiPaket som = new SOZapamtiPaket(p);
            som.templateExecute(p);
            return som.getPaket();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Menja izabrani paket.
 * @param p uneti paket
 * @return paket
 */
    public AbstractObject azurirajPaket(Paket p) {
        try {
            SOIzmeniPaket soip = new SOIzmeniPaket(p);
            soip.templateExecute(p);
            return soip.getPaket();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Vraca listu svih pretplata.
 * 
 * @return List<Pretplata>
 */
    public List<Pretplata> vratiSvePretplate() {
        try {
            SOUcitajPretplate soup = new SOUcitajPretplate();
            soup.templateExecute(new Pretplata());
            return soup.getPretplate();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Unosi u bazu unetu pretplatu.
 * @param pretplata uneta pretplata.
 * @return Pretplata
 */
    public AbstractObject zapamtiPretplatu(AbstractObject pretplata) {
        try {
            SOZapamtiPretplatu sozp = new SOZapamtiPretplatu(pretplata);
            sozp.templateExecute(pretplata);
            return sozp.getPretplata();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Pretrazuje sve pretplate po paketu
 * @param pak uneti paket
 * @return List<Pretplata>
 */
    public List<AbstractObject> pretraziPretplate(Paket pak) {
        try {
            SOPretraziPretplate sopp = new SOPretraziPretplate(pak);
            sopp.templateExecute(new Pretplata());
            return sopp.getPretplate();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Vraca listu svih trenera.
 * 
 * @return List<Trener>
 */
    public List<Trener> vratiTrenere() {
        try {
            SOUcitajTrenere sout = new SOUcitajTrenere();
            sout.templateExecute(new Trener());
            return sout.getLista();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Unosi u bazu unetog trenera.
 * @param t uneti trener.
 * @return Trener
 */
    public Trener zapamtiTrenera(Trener t) {
        try {
            SOZapamtiTrenera sozt = new SOZapamtiTrenera(t);
            sozt.templateExecute(t);
            return (Trener) sozt.getTrener();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Menja trenera iz baze.
 * 
 * @param tr uneti trener
 * @return Trener
 */
    public Trener izmeniTrenera(Trener tr) {
        try {
            SOIzmeniTrenera soit = new SOIzmeniTrenera(tr);
            soit.templateExecute(tr);
            return (Trener) soit.getTrener();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Brise izabranog trenera.
 * 
 * @param brisiTrenera izabrani trener za brisanje.
 */
    public void obrisiTrenera(Trener brisiTrenera) {
        try {
            SOObrisiTrenera soot = new SOObrisiTrenera();
            soot.templateExecute(brisiTrenera);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
