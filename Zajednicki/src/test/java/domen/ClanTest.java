/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import static org.junit.gen5.api.Assertions.assertThrows;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;

/**
 *
 * @author kompic
 */
public class ClanTest {

    Connection connection;
    Clan c;
    Mesto m;

    public ClanTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        c = new Clan();
        m = new Mesto();
    }

    @AfterEach
    public void tearDown() {
        c = null;
        m = null;
    }

    @Test
    public void testSetClanId() {
        c.setClanId("1");

        assertEquals("1", c.getClanId());
    }

    @Test
    public void testSetClanIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setClanId(null));
    }

    @Test
    public void testSetClanIdPrazanString() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setClanId(""));
    }

    @Test
    public void testSetClanIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setClanId("0"));
    }

    @Test
    public void testSetIme() {
        c.setIme("Pera");

        assertEquals("Pera", c.getIme());
    }

    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setIme(null));
    }

    @Test
    public void testSetImeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setIme("P"));
    }

    @Test
    public void testSetPrezime() {
        c.setIme("Peric");

        assertEquals("Peric", c.getPrezime());
    }

    @Test
    public void testSetPrezimeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setPrezime(null));
    }

    @Test
    public void testSetPrezimeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setPrezime("P"));
    }

    @Test
    public void testSetEmail() {
        c.setEmail("pera@gmail.com");

        assertEquals("pera@gmail.com", c.getEmail());
    }

    @Test
    public void testSetEmailNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setEmail(null));
    }

    @Test
    public void testSetEmailNemaLudoA() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setEmail("peragmail.com"));
    }

    @Test
    public void testSetAdresa() {
        c.setIme("Vojvode Stepe");

        assertEquals("Vojvode Stepe", c.getPrezime());
    }

    @Test
    public void testSetAdresaNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setAdresa(null));
    }

    @Test
    public void testSetAdresaManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setAdresa("V"));
    }

    /**
     * Test of setTelefon method, of class Clan.
     */
    @Test
    public void testSetTelefon() {
        c.setTelefon("+38106412345678");
        assertEquals("+38106412345678", c.getTelefon());
    }

    @Test
    public void testSetTelefonNull() {
        assertThrows(java.lang.NullPointerException.class, () -> c.setTelefon(null));
    }

    /**
     * Test of setTelefon method, of class Clan.
     */
    @Test
    public void testSetTelefonFormat() {
        assertThrows(java.lang.RuntimeException.class, () -> c.setTelefon("abc123"));
    }

    /**
     * Test of setTelefon method, of class Clan.
     */
    @Test
    public void testSetTelefonDuzina() {
        assertThrows(java.lang.RuntimeException.class, () -> c.setTelefon("0646412"));
    }

    /**
     * Test of setMesto method, of class Clan.
     */
    @Test
    public void testSetMesto() {
        Mesto m1 = new Mesto();

        m.setNaziv("Beograd");
        m1.setNaziv("Beograd");

        c.setMesto(m);

        assertEquals(m1, c.getMesto());
    }

    /**
     * Test of setMesto method, of class Clan.
     */
    @Test
    public void testSetMestoNull() {
        assertThrows(java.lang.NullPointerException.class, () -> c.setMesto(null));
    }

}
