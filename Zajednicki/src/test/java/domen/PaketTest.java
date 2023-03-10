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

    @Test
    public void testSetPaketId() {
        p.setPaketId("1");

        assertEquals("1", p.getPaketId());
    }

    @Test
    public void testSetPaketIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setPaketId(null));
    }

    @Test
    public void testSetPaketIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setPaketId(""));
    }

    @Test
    public void testSetPaketIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setPaketId("0"));
    }

    @Test
    public void testSetNaziv() {
        p.setNaziv("Rekreativno plivanje");

        assertEquals("Rekreativno plivanje", p.getNaziv());
    }

    @Test
    public void testSetNazivNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setNaziv(null));
    }

    @Test
    public void testSetNazivManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setNaziv("R"));
    }

    @Test
    public void testSetCena() {
        p.setCena("1000");

        assertEquals("1000", p.getCena());
    }

    @Test
    public void testSetCenaNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setCena(null));
    }

    @Test
    public void testSetCenaNijeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setCena("1100a"));
    }

    @Test
    public void testSetCenaManjeOdNule() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setPaketId("-1"));
    }

}
