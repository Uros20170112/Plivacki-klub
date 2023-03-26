/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Clan;
import domen.Mesto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
public class TestSOUcitajClanove {

    Clan clan;
    Mesto mesto;

    @Before
    void setUp() throws Exception {
        mesto = new Mesto("3", "Vozdovac", "11010");
        clan = new Clan(null, "Uros", "Soljaga", "uros@gmail.com",
                "Mikina i Zikina", "0641234567", mesto);
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
        clan = null;
        mesto = null;
    }

    /**
     * Test of execute method, of class SOUcitajClanove.tabela clanova je
     * ispraznjena za ovaj test. U bazi je vec mesto sa ovim vrednostima
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();
        isprazniMesta();
        Mesto m = new Mesto("1", "Beograd", "11000");

        dodajMesto(m);

        ArrayList<Clan> listaClanova = new ArrayList<>();
        listaClanova.add(new Clan(null, "imeime", "prezime", "sad@asd", "adresa123", "01243456789", m));
        listaClanova.add(new Clan(null, "imeime", "prezime", "saad@asd", "adresa123", "01253456789", m));
        listaClanova.add(new Clan(null, "imeime", "prezime", "sabd@asd", "adresa123", "01234356789", m));
        listaClanova.add(new Clan(null, "imeime", "prezime", "sadq@asd", "adresa123", "01223456789", m));

        for (Clan clan : listaClanova) {
            (new SOZapamtiClana()).execute(clan);
        }

        ArrayList<AbstractObject> clanovi = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Clan());
        ArrayList<Clan> listaPom = (ArrayList<Clan>) (ArrayList<?>) clanovi;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaClanova.get(i).getEmail().equals(listaPom.get(i).getEmail())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        isprazniMesta();
        try {
            String upit = "DELETE FROM clan";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
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

}
