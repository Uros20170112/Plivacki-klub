/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.AbstractObject;
import domen.Clan;
import domen.Korisnik;
import domen.Paket;
import domen.Pretplata;
import domen.Trener;
import exception.ServerskiException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Operacije;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author kompic
 */
public class ObradaKlijentskihZahteva extends Thread {

    private Socket socket;
    private List<ObradaKlijentskihZahteva> klijenti;
    ObjectInputStream in;
    ObjectOutputStream out;
    AbstractObject korisnik;

    public ObradaKlijentskihZahteva(Socket socket, List<ObradaKlijentskihZahteva> klijenti) {
        this.socket = socket;
        this.klijenti = klijenti;
    }

    @Override
    public void run() {
//        System.out.println("Klijent nit pokrenuta...");
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                KlijentskiZahtev kz = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor so = new ServerskiOdgovor();
                try {
                    int operacija = kz.getOperacija();
                    switch (operacija) {
                        case Operacije.ULOGUJ_KORISNIKA:
                            Korisnik k = (Korisnik) kz.getParametar();
                            korisnik = Kontroler.getInstance().ulogujKorisnika(k);
                            so.setPodaci(korisnik);
                            break;
                        case Operacije.IZLOGUJ_KORISNIKA:
                            Korisnik kor = (Korisnik) kz.getParametar();
                            Kontroler.getInstance().izlogujKorisnika(kor);
                            break;
                        case Operacije.UCITAJ_CLANOVE:
                            List<AbstractObject> clanovi = Kontroler.getInstance().ucitajClanove();
                            so.setPodaci(clanovi);
                            break;
                        case Operacije.UCITAJ_MESTA:
                            List<AbstractObject> mesta = Kontroler.getInstance().ucitajMesta();
                            so.setPodaci(mesta);
                            break;
                        case Operacije.UCITAJ_PROMENE_PAKETA:
                            List<AbstractObject> istorije = Kontroler.getInstance().ucitajPromenePaketa();
                            so.setPodaci(istorije);
                            break;
                        case Operacije.UCITAJ_PAKETE:
                            List<AbstractObject> paketi = Kontroler.getInstance().ucitajPakete();
                            so.setPodaci(paketi);
                            break;
                        case Operacije.ZAPAMTI_CLANA:
                            List<Object> parametri = (List<Object>) kz.getParametar();
                            AbstractObject clan = Kontroler.getInstance().zapamtiClana(parametri);
                            so.setPodaci(clan);
                            break;
                        case Operacije.PRETRAZI_CLANOVE:
                            String pretr = (String) kz.getParametar();
                            List<AbstractObject> listaNadjenihClanova = Kontroler.getInstance().pretraziClanove(pretr);
                            so.setPodaci(listaNadjenihClanova);
                            break;
                        case Operacije.IZMENI_CLANA:
                            List<Object> lista = (List<Object>) kz.getParametar();
                            AbstractObject izmenjenClan = Kontroler.getInstance().izmeniClana(lista);
                            so.setPodaci(izmenjenClan);
                            break;
                        case Operacije.OBRISI_CLANA:
                            Clan zaBrisanje = (Clan) kz.getParametar();
                            AbstractObject obrisan = Kontroler.getInstance().obrisiClana(zaBrisanje);
                            so.setPodaci(obrisan);
                            break;
                        case Operacije.ZAPAMTI_PAKET:
                            Paket p = (Paket) kz.getParametar();
                            Paket sacuvan = (Paket) Kontroler.getInstance().zapamtiPaket(p);
                            so.setPodaci(sacuvan);
                            break;
                        case Operacije.IZMENI_PAKET:
                            Paket pa = (Paket) kz.getParametar();
                            Paket azuriranPaket = (Paket) Kontroler.getInstance().azurirajPaket(pa);
                            so.setPodaci(azuriranPaket);
                            break;
                        case Operacije.PRETRAZI_PAKETE:
                            String pret = (String) kz.getParametar();
                            List<AbstractObject> listaNadjenihPaketa = Kontroler.getInstance().pretraziPakete(pret);
                            so.setPodaci(listaNadjenihPaketa);
                            break;
                        case Operacije.ZAPAMTI_PRETPLATU:
                            Pretplata pretpl = (Pretplata) kz.getParametar();
                            Pretplata pretplata = (Pretplata) Kontroler.getInstance().zapamtiPretplatu(pretpl);
                            so.setPodaci(pretplata);
                            break;
                        case Operacije.UCITAJ_PRETPLATE:
                            List<AbstractObject> pretplate = Kontroler.getInstance().vratiSvePretplate();
                            so.setPodaci(pretplate);
                            break;
                        case Operacije.PRETRAZI_PRETPLATE:
                            Paket pak = (Paket) kz.getParametar();
                            List<AbstractObject> listaNadjenihPretplata = Kontroler.getInstance().pretraziPretplate(pak);
                            so.setPodaci(listaNadjenihPretplata);
                            break;
                        case Operacije.VRATI_TRENERE:
                            ArrayList<AbstractObject> treneri = Kontroler.getInstance().vratiTrenere();
                            so.setPodaci(treneri);
                            break;
                        case Operacije.ZAPAMTI_TRENERA:
                            Trener t = (Trener) kz.getParametar();
                            Trener trener = Kontroler.getInstance().zapamtiTrenera(t);
                            so.setPodaci(trener);
                            break;
                        case Operacije.IZMENI_TRENERA:
                            Trener tr = (Trener) kz.getParametar();
                            Trener tr1 = Kontroler.getInstance().izmeniTrenera(tr);
                            so.setPodaci(tr1);
                        case Operacije.OBRISI_TRENERA:
                            Trener brisiTrenera = (Trener) kz.getParametar();
                            AbstractObject obrisanTrener = Kontroler.getInstance().obrisiTrenera(brisiTrenera);
                            so.setPodaci(obrisanTrener);
                            break;
                        default:
                            break;
                    }
                    so.setUspesnost(1);
                } catch (ServerskiException ex) {
                    so.setUspesnost(-1);
                    so.setException(ex);
                }
                out.writeUnshared(so);
            }
        } catch (SocketException ex) {
            try {
                System.out.println("Klijent se iskljucuje...");
                Kontroler.getInstance().izlogujKorisnika(korisnik);
                in.close();
                out.close();
                socket.close();
                klijenti.remove(this);
            } catch (IOException ex1) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (ServerskiException ex1) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public AbstractObject getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(AbstractObject korisnik) {
        this.korisnik = korisnik;
    }

}
