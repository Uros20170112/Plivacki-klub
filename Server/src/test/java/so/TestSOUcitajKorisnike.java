/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Korisnik;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
public class TestSOUcitajKorisnike {

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
     * Test of execute method, of class SOUcitajKorisnike. Tabela korisnika je
     * ispraznjena za ovaj test.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();

        ArrayList<Korisnik> listaKorisnika = new ArrayList<>();
        listaKorisnika.add(new Korisnik("korisnik1", "korisnik1@mail.com", "korisnik1", "korisnik1"));
        listaKorisnika.add(new Korisnik("korisnik2", "korisnik2@mail.com", "korisnik2", "korisnik2"));

        for (Korisnik korisnik : listaKorisnika) {
            (new SOZapamtiClana()).execute(korisnik);
        }

        ArrayList<AbstractObject> korisnici = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Korisnik());
        ArrayList<Korisnik> listaPom = (ArrayList<Korisnik>) (ArrayList<?>) korisnici;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaKorisnika.get(i).getEmail().equals(listaPom.get(i).getEmail())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        try {
            String upit = "DELETE FROM korisnik";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
