/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.junit.gen5.api.Assertions.assertThrows;

/**
 *
 * @author kompic
 */
public class TerminTest {

    Termin t;
    Paket p;
    Trener tr;

    @Before
    public void setUp() {
        t = new Termin();
        p = new Paket();
        tr = new Trener();
    }

    @After
    public void tearDown() {
        t = null;
        p = null;
        tr = null;
    }

    public TerminTest() {
    }

    @Test
    public void testSetTerminId() {
        t.setId("1");

        assertEquals("1", t.getId());
    }

    @Test
    public void testSetTerminIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> t.setId(null));
    }

    @Test
    public void testSetTerminIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> t.setId(""));
    }

    @Test
    public void testSetTerminIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> t.setId("0"));
    }

    @Test
    public void testSetPaket() {
        Paket p1 = new Paket();
        p.setPaketId("1");
        p1.setPaketId("1");

        t.setPaket(p);

        assertEquals(p1, t.getPaket());
    }

    @Test
    public void testSetPaketNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setPaket(null));
    }

    @Test
    public void testSetTrener() {
        Trener tr1 = new Trener();
        tr.setTrenerId("1");
        tr1.setTrenerId("1");

        t.setTrener(tr);

        assertEquals(tr1, t.getTrener());
    }

    @Test
    public void testSetTrenerNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setTrener(null));
    }

    @Test
    public void testSetSmena() {
        t.setSmena("12:00-13:00");

        assertEquals("12:00-13:00", t.getSmena());
    }

    @Test
    public void testSetSmenaNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setSmena(null));
    }

    @Test
    public void testSetSmenaPogresno() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setSmena("1"));
    }

    @Test
    public void testSetDan() {
        t.setDan("Ponedeljak");

        assertEquals("Ponedeljak", t.getDan());
    }

    @Test
    public void testSetDanNull() {
        assertThrows(java.lang.NullPointerException.class, () -> t.setDan(null));
    }

    @Test
    public void testSetDanPogresno() {
        assertThrows(java.lang.IllegalArgumentException.class, () -> t.setDan("1"));
    }

}
