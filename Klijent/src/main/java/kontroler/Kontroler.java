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
import domen.Pretplata;
import exception.KomunikacijaException;
import java.io.IOException;
import java.util.List;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author kompic
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public AbstractObject ulogujKorisnika(String username, String password) throws Exception {
        System.out.println("Logovanje korisnika...");
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ULOGUJ_KORISNIKA);
        Korisnik k = new Korisnik(null, null, password, username);
        kz.setParametar(k);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObject) st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    
    public List<AbstractObject> pretraziPakete(String pretraga) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_PAKETE);
        kz.setParametar(pretraga);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }


    public List<AbstractObject> ucitajClanove() throws Exception {
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.UCITAJ_CLANOVE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObject>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new KomunikacijaException("Doslo je do greske u komunikaciji");
        }
    }

    public List<AbstractObject> ucitajMesta() throws Exception {
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.UCITAJ_MESTA);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObject>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new KomunikacijaException("Doslo je do greske u komunikaciji");
        }
    }

    public List<AbstractObject> ucitajPromenePaketa() throws Exception {
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.UCITAJ_PROMENE_PAKETA);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObject>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new KomunikacijaException("Doslo je do greske u komunikaciji");
        }
    }

    public List<AbstractObject> ucitajPakete() throws Exception {
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.UCITAJ_PAKETE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObject>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new KomunikacijaException("Doslo je do greske u komunikaciji");
        }
    }

    public AbstractObject izlogujKorisnika(Korisnik korisnik) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZLOGUJ_KORISNIKA);

        kz.setParametar(korisnik);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObject) st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public AbstractObject zapamtiClana(List<Object> params) throws IOException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_CLANA);
        kz.setParametar(params);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (Clan) (st.getPodaci());
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public Clan izmeniClana(List<Object> parametri) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_CLANA);
        kz.setParametar(parametri);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (Clan) (st.getPodaci());
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public Clan obrisiClana(Clan clan) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.OBRISI_CLANA);
        kz.setParametar(clan);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == -1) {
            Exception ex = st.getException();
            throw ex;
        } else {
            return (Clan) st.getPodaci();
        }
    }

    public List<AbstractObject> pretraziClanove(String pretraga) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_CLANOVE);
        kz.setParametar(pretraga);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public Paket zapamtiPaket(Paket paket) throws IOException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PAKET);
        kz.setParametar(paket);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (Paket) (st.getPodaci());
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public Paket izmeniPaket(Paket paket) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.IZMENI_PAKET);
        kz.setParametar(paket);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (Paket) (st.getPodaci());
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }

    public AbstractObject zapamtiPretplatu(Pretplata p) throws IOException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PRETPLATU);
        kz.setParametar(p);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (AbstractObject) (st.getPodaci());
        } else {
            Exception e = st.getException();
            throw e;
        }
    }

    public List<AbstractObject> vratiListuPretplata() throws Exception {
        try {
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.UCITAJ_PRETPLATE);
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
            if (st.getUspesnost() == 1) {
                return (List<AbstractObject>) st.getPodaci();
            } else {
                Exception exec = st.getException();
                throw exec;
            }
        } catch (IOException | ClassNotFoundException ex) {
            throw new KomunikacijaException("Doslo je do greske u komunikaciji");
        }
    }

    public List<AbstractObject> pretraziPretplate(Paket izabran) throws IOException, ClassNotFoundException, Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRETRAZI_PRETPLATE);
        kz.setParametar(izabran);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        if (st.getUspesnost() == 1) {
            return (List<AbstractObject>) st.getPodaci();
        } else {
            Exception ex = st.getException();
            throw ex;
        }
    }
}
