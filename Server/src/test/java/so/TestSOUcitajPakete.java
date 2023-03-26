/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Paket;
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
public class TestSOUcitajPakete {
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
     * Test of execute method, of class SOUcitajPaket. Tabela paketa je
     * ispraznjena za ovaj test.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();

        ArrayList<Paket> listaPaketa = new ArrayList<>();
        listaPaketa.add(new Paket("1", "Paket1", "10000"));
        listaPaketa.add(new Paket("2", "Paket2", "10000"));
        listaPaketa.add(new Paket("3", "Paket3", "10000"));

        for (Paket Paket : listaPaketa) {
            (new SOZapamtiPaket(Paket)).execute(Paket);
        }

        ArrayList<AbstractObject> paketi = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Paket());
        ArrayList<Paket> listaPom = (ArrayList<Paket>) (ArrayList<?>) paketi;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaPaketa.get(i).getPaketId().equals(listaPom.get(i).getPaketId())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        try {
            String upit = "DELETE FROM paket";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
