/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Clan;
import domen.Mesto;
import domen.Paket;
import domen.Pretplata;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.gen5.api.Test;

/**
 *
 * @author kompic
 */
public class TestSOUcitajPretplate {

    @Before
    void setUp() throws Exception {
        try {
            Properties properties = new Properties();
            FileOutputStream out = new FileOutputStream("dbconfig.properties");

            properties.setProperty("url", "jdbc:mysql://localhost:3306/test_plivaliste");
            properties.setProperty("username", "root");
            properties.setProperty("password", "");

            properties.store(out, null);
            properties.clear();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOIzmeniClana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    void tearDown() throws Exception {
        try {
            Properties properties = new Properties();
            FileOutputStream out = new FileOutputStream("dbconfig.properties");

            properties.setProperty("url", "jdbc:mysql://localhost:3306/plivaliste");
            properties.setProperty("username", "root");
            properties.setProperty("password", "");

            properties.store(out, null);

            properties.clear();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SOIzmeniClana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of execute method, of class SOUcitajPretplate. Tabela pretplata je
     * ispraznjena za ovaj test.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();
        isprazniClanove();
        isprazniPakete();

        Mesto m = new Mesto("1", "Beograd", "11000");
        dodajMesto(m);

        Clan clan = new Clan("1", "ime", "prezime", "email@email.com", "adresa", "0001112222", m);
        Paket paket = new Paket("1", "paket1", "1000");
        dodajPaket(paket);
        dodajCana(clan);

        ArrayList<Pretplata> listaPretplata = new ArrayList<>();
        listaPretplata.add(new Pretplata("1", new Date(), clan, paket, new Date()));
        listaPretplata.add(new Pretplata("2", new Date(), clan, paket, new Date()));
        listaPretplata.add(new Pretplata("3", new Date(), clan, paket, new Date()));

        for (Pretplata pretplata : listaPretplata) {
            (new SOZapamtiPretplatu(pretplata)).execute(pretplata);
        }

        ArrayList<AbstractObject> pretplate = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Pretplata());
        ArrayList<Pretplata> listaPom = (ArrayList<Pretplata>) (ArrayList<?>) pretplate;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaPretplata.get(i).getPretplataId().equals(listaPom.get(i).getPretplataId())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        isprazniPakete();
        isprazniClanove();
        isprazniMesta();
        try {
            String upit = "DELETE FROM Pretplata";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajPretplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isprazniPakete() {
        try {
            String upit = "DELETE FROM paket";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajPakete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dodajPaket(Paket p) {
        try {
            String upit = "INSERT INTO mesto values(?,?,?)";
            System.out.println(upit);
            PreparedStatement ps = DBBroker.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getPaketId());
            ps.setString(2, p.getNaziv());
            ps.setString(3, p.getCena());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniPaket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isprazniClanove() {
        isprazniMesta();
        try {
            String upit = "DELETE FROM clan";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajPakete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isprazniMesta() {
        try {
            String upit = "DELETE FROM mesto";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dodajMesto(Mesto m) {
        try {
            String upit = "INSERT INTO mesto values(?,?,?)";
            System.out.println(upit);
            PreparedStatement ps = DBBroker.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getMestoId());
            ps.setString(2, m.getNaziv());
            ps.setString(3, m.getPtt());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniClana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void dodajCana(Clan clan) {
        try {
            String upit = "INSERT INTO mesto values(?,?,?,?,?,?,?)";
            System.out.println(upit);
            PreparedStatement ps = DBBroker.getInstance().getConnection().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, clan.getClanId());
            ps.setString(2, clan.getIme());
            ps.setString(3, clan.getPrezime());
            ps.setString(4, clan.getEmail());
            ps.setString(5, clan.getAdresa());
            ps.setString(6, clan.getTelefon());
            ps.setString(7, clan.getMesto().getMestoId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SOIzmeniClana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
