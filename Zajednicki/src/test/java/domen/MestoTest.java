/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.gen5.api.AfterAll;
import static org.junit.gen5.api.Assertions.assertThrows;
import org.junit.gen5.api.BeforeAll;

/**
 *
 * @author kompic
 */
public class MestoTest {

    Mesto m;

    public MestoTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        m = new Mesto();
    }

    @After
    public void tearDown() {
        m = null;
    }

    /**
     * Test of setMestoId method, of class Mesto
     */
    @Test
    public void testSetMestoId() {
        m.setMestoId("1");

        assertEquals("1", m.getMestoId());
    }

    /**
     * Test of setMestoId method, of class Mesto
     */
    @Test
    public void testSetMestoIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setMestoId(null));
    }

    /**
     * Test of setMestoId method, of class Mesto
     */
    @Test
    public void testSetMestoIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> m.setMestoId(""));
    }

    /**
     * Test of setMestoId method, of class Mesto
     */
    @Test
    public void testSetMestoIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setMestoId("0"));
    }

    /**
     * Test of setNaziv method, of class Mesto
     */
    @Test
    public void testSetNaziv() {
        m.setNaziv("Beograd");

        assertEquals("Beograd", m.getNaziv());
    }

    /**
     * Test of setNaziv method, of class Mesto
     */
    @Test
    public void testSetNazivNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setNaziv(null));
    }

    /**
     * Test of setNaziv method, of class Mesto
     */
    @Test
    public void testSetNazivManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setNaziv("B"));
    }

    /**
     * Test of setPtt method, of class Mesto
     */
    @Test
    public void testSetPtt() {
        m.setPtt("11000");

        assertEquals("11000", m.getPtt());
    }

    /**
     * Test of setPtt method, of class Mesto
     */
    @Test
    public void testSetPttNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setPtt(null));
    }

    /**
     * Test of setPtt method, of class Mesto
     */
    @Test
    public void testSetPttNijeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> m.setPtt("1100a"));
    }

    /**
     * Test of setPtt method, of class Mesto
     */
    @Test
    public void testSetPttManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setPtt("1"));
    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, () -> m.toString());
    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToString() {
        m.setNaziv("Beograd");
        m.setPtt("11000");
        assertEquals("11000 Beograd", m.toString());
    }

    /**
     * Test of equals method, of class Clan.
     */
    @Test
    public void testEquals() {
        m.setMestoId("1");
        Mesto mesto = new Mesto();
        mesto.setMestoId("1");
        assertEquals(m, mesto);
    }
}
