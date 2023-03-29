/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.gen5.api.Assertions.assertThrows;

/**
 * Test of class Clan
 *
 * @author kompic
 */
public class ClanTest {

    Clan c;
    Mesto m;

    public ClanTest() {
    }

    @Before
    public void setUp() {
        c = new Clan();
        m = new Mesto();
    }

    @After
    public void tearDown() {
        c = null;
        m = null;
    }

    /**
     * Test of setClanId method, of class Clan.
     */
    @Test
    public void testSetClanId() {
        c.setClanId("1");

        assertEquals("1", c.getClanId());
    }

    /**
     * Test of setClanId method, of class Clan.
     */
    @Test
    public void testSetClanIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setClanId(null));
    }

    /**
     * Test of setClanId method, of class Clan.
     */
    @Test
    public void testSetClanIdPrazanString() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setClanId(""));
    }

    /**
     * Test of setClanId method, of class Clan.
     */
    @Test
    public void testSetClanIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setClanId("0"));
    }

    /**
     * Test of setIme method, of class Clan.
     */
    @Test
    public void testSetIme() {
        c.setIme("Pera");

        assertEquals("Pera", c.getIme());
    }

    /**
     * Test of setIme method, of class Clan.
     */
    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setIme(null));
    }

    /**
     * Test of setIme method, of class Clan.
     */
    @Test
    public void testSetImeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setIme("P"));
    }

    /**
     * Test of setPrezime method, of class Clan.
     */
    @Test
    public void testSetPrezime() {
        c.setPrezime("Peric");

        assertEquals("Peric", c.getPrezime());
    }

    /**
     * Test of setPrezime method, of class Clan.
     */
    @Test
    public void testSetPrezimeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setPrezime(null));
    }

    /**
     * Test of setPrezime method, of class Clan.
     */
    @Test
    public void testSetPrezimeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setPrezime("P"));
    }

    /**
     * Test of setEmail method, of class Clan.
     */
    @Test
    public void testSetEmail() {
        c.setEmail("pera@gmail.com");

        assertEquals("pera@gmail.com", c.getEmail());
    }

    /**
     * Test of setEmail method, of class Clan.
     */
    @Test
    public void testSetEmailNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setEmail(null));
    }

    /**
     * Test of setEmail method, of class Clan.
     */
    public void testSetEmailNemaLudoA() {
        assertThrows(java.lang.RuntimeException.class,
                () -> c.setEmail("peragmail.com"));
    }

    /**
     * Test of setAdresa method, of class Clan.
     */
    @Test
    public void testSetAdresa() {
        c.setAdresa("Vojvode Stepe");

        assertEquals("Vojvode Stepe", c.getAdresa());
    }

    /**
     * Test of setAdresa method, of class Clan.
     */
    @Test
    public void testSetAdresaNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> c.setAdresa(null));
    }

    /**
     * Test of setAdresa method, of class Clan.
     */
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

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, () -> c.toString());
    }

    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToString() {
        c.setIme("Petar");
        c.setPrezime("Peric");
        assertEquals("Petar Peric", c.toString());
    }

    /**
     * Test of equals method, of class Clan.
     */
    @Test
    public void testEquals() {
        c.setClanId("1");
        Clan clan = new Clan();
        clan.setClanId("1");
        assertEquals(c, clan);
    }
}
