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

    public List<Korisnik> getListaAktivnihKorisnika() {
        return listaAktivnihKorisnika;
    }

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

    public void izlogujKorisnika(AbstractObject korisnik) {
        try {
            SOIzlogujKorisnika soik = new SOIzlogujKorisnika();
            soik.setKorisnik(korisnik);
            soik.templateExecute(korisnik);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void obrisiKorisnika(Korisnik k) {
        try {
            SOObrisiKorisnika sook = new SOObrisiKorisnika();
            sook.templateExecute(k);
            listaAktivnihKorisnika.remove(k);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void obrisiClana(Clan zaBrisanje) {
        try {
            SOObrisiClana som = new SOObrisiClana();
            som.templateExecute(zaBrisanje);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

    public void obrisiTrenera(Trener brisiTrenera) {
        try {
            SOObrisiTrenera soot = new SOObrisiTrenera();
            soot.templateExecute(brisiTrenera);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
