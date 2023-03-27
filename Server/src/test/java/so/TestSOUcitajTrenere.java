/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import domen.Paket;
import domen.Trener;
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
public class TestSOUcitajTrenere {
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
     * Test of execute method, of class SOUcitajTrenere. Tabela trenera je
     * ispraznjena za ovaj test.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        isprazniTabelu();

        ArrayList<Trener> listaTrenera = new ArrayList<>();
        listaTrenera.add(new Trener("1", "trener1", "trener1", "tip1"));
        listaTrenera.add(new Trener("2", "trener2", "trener2", "tip2"));
        listaTrenera.add(new Trener("3", "trener3", "trener3", "tip3"));

        for (Trener trener : listaTrenera) {
            (new SOZapamtiTrenera(trener)).execute(trener);
        }

        ArrayList<AbstractObject> treneri = (ArrayList<AbstractObject>) DBBroker.getInstance().select(new Trener());
        ArrayList<Trener> listaPom = (ArrayList<Trener>) (ArrayList<?>) treneri;

        boolean b = true;
        for (int i = 0; i < listaPom.size(); i++) {
            if (!listaTrenera.get(i).getTrenerId().equals(listaPom.get(i).getTrenerId())) {
                b = false;
            }
        }
        isprazniTabelu();
        assertTrue(b);
    }

    private void isprazniTabelu() {
        try {
            String upit = "DELETE FROM trener";
            System.out.println(upit);
            Statement s = DBBroker.getInstance().getConnection().createStatement();
            s.executeUpdate(upit);
        } catch (SQLException ex) {
            Logger.getLogger(SOUcitajClanove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
