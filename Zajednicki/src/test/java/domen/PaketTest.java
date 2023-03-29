/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.gen5.api.Assertions.assertThrows;

/**
 *
 * @author kompic
 */
public class PaketTest {

    Paket p;

    public PaketTest() {
    }

    @Before
    public void setUp() {
        p = new Paket();
    }

    @After
    public void tearDown() {
        p = null;
    }

    /**
     * Test method of setPaketId, of class paket
     */
    @Test
    public void testSetPaketId() {
        p.setPaketId("1");

        assertEquals("1", p.getPaketId());
    }

    /**
     * Test method of setPaketId, of class paket
     */
    @Test
    public void testSetPaketIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setPaketId(null));
    }

    /**
     * Test method of setPaketId, of class paket
     */
    @Test
    public void testSetPaketIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setPaketId(""));
    }

    /**
     * Test method of setPaketId, of class paket
     */
    @Test
    public void testSetPaketIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setPaketId("0"));
    }

    /**
     * Test method of setNaziv, of class paket
     */
    @Test
    public void testSetNaziv() {
        p.setNaziv("Rekreativno plivanje");

        assertEquals("Rekreativno plivanje", p.getNaziv());
    }

    /**
     * Test method of setNaziv, of class paket
     */
    @Test
    public void testSetNazivNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setNaziv(null));
    }

    /**
     * Test method of setNaziv, of class paket
     */
    @Test
    public void testSetNazivManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setNaziv("R"));
    }

    /**
     * Test method of setCena, of class paket
     */
    @Test
    public void testSetCena() {
        p.setCena("1000");

        assertEquals("1000", p.getCena());
    }

    /**
     * Test method of setCena, of class paket
     */
    @Test
    public void testSetCenaNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setCena(null));
    }

    /**
     * Test method of setCena, of class paket
     */
    @Test
    public void testSetCenaNijeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setCena("1100a"));
    }

    /**
     * Test method of setCena, of class paket
     */
    @Test
    public void testSetCenaManjeOdNule() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setPaketId("-1"));
    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, () -> p.toString());
    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToString() {
        p.setNaziv("Telefon");
        p.setCena("1000");
        assertEquals("Telefon - 1000 RSD", p.toString());
    }

    /**
     * Test of equals method, of class Clan.
     */
    @Test
    public void testEquals() {
        p.setPaketId("1");
        Paket paket = new Paket();
        paket.setPaketId("1");
        assertEquals(p, paket);
    }
}
