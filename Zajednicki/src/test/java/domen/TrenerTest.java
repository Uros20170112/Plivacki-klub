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
 * Test of class Trener.
 *
 * @author kompic
 */
public class TrenerTest {

    Trener t;

    public TrenerTest() {
    }

    @Before
    public void setUp() {
        t = new Trener();
    }

    @After
    public void tearDown() {
        t = null;
    }

    /**
     * Test of setTrenerId method, of class Trener.
     */
    @Test
    public void testSetTrenerId() {
        t.setTrenerId("1");

        assertEquals("1", t.getTrenerId());
    }

    /**
     * Test of setTrenerId method, of class Trener.
     */
    @Test
    public void testSetTrenerIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> t.setTrenerId(null));
    }

    /**
     * Test of setTrenerId method, of class Trener.
     */
    @Test
    public void testSetTrenerIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> t.setTrenerId(""));
    }

    /**
     * Test of setTrenerId method, of class Trener.
     */
    @Test
    public void testSetTrenerIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> t.setTrenerId("0"));
    }

    /**
     * Test of setIme method, of class Trener.
     */
    @Test
    public void testSetIme() {
        t.setIme("Pera");

        assertEquals("Pera", t.getIme());
    }

    /**
     * Test of setIme method, of class Trener.
     */
    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> t.setIme(null));
    }

    /**
     * Test of setIme method, of class Trener.
     */
    @Test
    public void testSetImeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> t.setIme("P"));
    }

    /**
     * Test of setPrezime method, of class Trener.
     */
    @Test
    public void testSetPrezime() {
        t.setPrezime("Peric");

        assertEquals("Peric", t.getPrezime());
    }

    /**
     * Test of setPrezime method, of class Trener.
     */
    @Test
    public void testSetPrezimeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> t.setPrezime(null));
    }

    @Test
    public void testSetPrezimeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> t.setPrezime("P"));
    }

    /**
     * Test of setTipTrenera method, of class Trener.
     */
    @Test
    public void testSetTipTrenera() {
        t.setTipTrenera("Glavni");

        assertEquals("Glavni", t.getTipTrenera());
    }

    /**
     * Test of setTipTrenera method, of class Trener.
     */
    @Test
    public void testSetTipTreneraNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> t.setTipTrenera(null));
    }

    /**
     * Test of setTipTrenera method, of class Trener.
     */
    @Test
    public void testSetTipTreneraManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> t.setTipTrenera("G"));
    }

    /**
     * Test of toString method, of class Trener.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.toString());
    }

    /**
     * Test of toString method, of class Trener.
     */
    @Test
    public void testToString() {
        t.setIme("Petar");
        t.setPrezime("Peric");
        assertEquals("Petar Peric", t.toString());
    }

    /**
     * Test of equals method, of class Trener.
     */
    @Test
    public void testEquals() {
        t.setTrenerId("1");
        Trener trener = new Trener();
        trener.setTrenerId("1");
        assertEquals(t, trener);
    }
}
