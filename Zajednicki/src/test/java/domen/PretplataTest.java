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
 * Test of class Pretplata
 *
 * @author kompic
 */
public class PretplataTest {

    Pretplata p;

    public PretplataTest() {
    }

    @Before
    public void setUp() {
        p = new Pretplata();
        p.setDatum(new Date());
        p.setVaziDo(new Date());
    }

    @After
    public void tearDown() {
        p = null;
    }

    /**
     * Test of setPretplataId method, of class Pretplata
     */
    @Test
    public void testSetPretplataId() {
        p.setPretplataId("1");

        assertEquals("1", p.getPretplataId());
    }

    /**
     * Test of setPretplataId method, of class Pretplata
     */
    @Test
    public void testSetPretplataIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> p.setPretplataId(null));
    }

    /**
     * Test of setPretplataId method, of class Pretplata
     */
    @Test
    public void testSetPretplataIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> p.setPretplataId(""));
    }

    /**
     * Test of setPretplataId method, of class Pretplata
     */
    @Test
    public void testSetPretplataIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> p.setPretplataId("0"));
    }

    /**
     * Test of setDatum method, of class Pretplata
     */
    @Test
    public void testSetDatum() {
        assertEquals(new Date(), p.getDatum());
    }

    /**
     * Test of setDatum method, of class Pretplata
     */
    @Test
    public void testSetDatumNull() {
        assertThrows(java.lang.NullPointerException.class, () -> p.setDatum(null));
    }

    /**
     * Test of setDatum method, of class Pretplata
     */
    @Test
    public void testSetDatumPreDanas() {
        long prevDay = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
        Date prev = new Date(prevDay);
        assertThrows(java.lang.RuntimeException.class, () -> p.setDatum(prev));
    }

    /**
     * Test of setVaziDo method, of class Pretplata
     */
    @Test
    public void testSetVaziDoNull() {
        assertThrows(java.lang.NullPointerException.class, () -> p.setVaziDo(null));
    }

    /**
     * Test of setVaziDo method, of class Pretplata
     */
    @Test
    public void testSetVaziDoPreDanas() {
        long prevDay = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
        Date prev = new Date(prevDay);
        assertThrows(java.lang.RuntimeException.class, () -> p.setVaziDo(prev));
    }

    /**
     * Test of setVaziDo method, of class Pretplata
     */
    public void testSetVaziDoPreDatum() {
        long prevDay = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
        Date prev = new Date(prevDay);
        assertThrows(java.lang.RuntimeException.class, () -> p.setVaziDo(prev));
    }

}
