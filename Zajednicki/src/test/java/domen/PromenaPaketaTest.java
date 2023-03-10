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
public class PromenaPaketaTest {

    PromenaPaketa pp;
    Clan c;
    Paket p;

    @Before
    public void setUp() {
        pp = new PromenaPaketa();
        c = new Clan();
        p = new Paket();
    }

    @After
    public void tearDown() {
        pp = null;
        c = null;
        p = null;
    }

    @Test
    public void testSetPretplataId() {
        pp.setId("1");

        assertEquals("1", pp.getId());
    }

    @Test
    public void testSetIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> pp.setId(null));
    }

    @Test
    public void testSetIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> pp.setId(""));
    }

    @Test
    public void testSetIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> pp.setId("0"));
    }

    @Test
    public void testSetClan() {
        Clan c1 = new Clan();
        c.setClanId("1");
        c1.setClanId("1");

        pp.setClan(c);

        assertEquals(c1, pp.getClan());
    }

    @Test
    public void testSetClanNull() {
        assertThrows(java.lang.NullPointerException.class, () -> pp.setClan(null));
    }

    @Test
    public void testSetPaket() {
        Paket p1 = new Paket();
        p.setPaketId("1");
        p1.setPaketId("1");

        pp.setPaket(p);

        assertEquals(p1, pp.getPaket());
    }

    @Test
    public void testSetPaketNull() {
        assertThrows(java.lang.NullPointerException.class, () -> pp.setPaket(null));
    }

    @Test
    public void testSetDatum() {
        pp.setDatumOdabira(new Date());
        
        assertEquals(new Date(), pp.getDatumOdabira());
    }

    @Test
    public void testSetDatumNull() {
        assertThrows(java.lang.NullPointerException.class, () -> pp.setDatumOdabira(null));
    }

}
