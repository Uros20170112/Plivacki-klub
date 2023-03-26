/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Mesto;
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
public class TestSOUcitajMesta {
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
     * Test of execute method, of class SOUcitajMesta. Tabela mesta je
     * ispraznjena za ovaj test.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();

        ArrayList<Mesto> listaMesta = new ArrayList<>();

        for (Mesto mesto : listaMesta) {
            (new SOZapamtiClana()).execute(mesto);
        }

        ArrayList<AbstractObject> mesta = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Mesto());
        ArrayList<Mesto> listaPom = (ArrayList<Mesto>) (ArrayList<?>) mesta;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaMesta.get(i).getMestoId().equals(listaPom.get(i).getMestoId())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        try {
            String upit = "DELETE FROM mesto";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
