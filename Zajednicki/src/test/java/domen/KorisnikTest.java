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
public class KorisnikTest {

    Korisnik k;

    @Before
    public void setUp() {
        k = new Korisnik();
    }

    @After
    public void tearDown() {
        k = null;
    }

    /**
     * Test of setIme method, of class Korisnik
     */
    @Test
    public void testSetIme() {
        k.setIme("Pera");

        assertEquals("Pera", k.getIme());
    }

    /**
     * Test of setIme method, of class Korisnik
     */
    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setIme(null));
    }

    /**
     * Test of setIme method, of class Korisnik
     */
    @Test
    public void testSetImeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setIme("P"));
    }

    /**
     * Test of setEmail method, of class Korisnik
     */
    @Test
    public void testSetEmail() {
        k.setEmail("pera@gmail.com");

        assertEquals("pera@gmail.com", k.getEmail());
    }

    /**
     * Test of setEmail method, of class Korisnik
     */
    @Test
    public void testSetEmailNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setEmail(null));
    }

    /**
     * Test of setEmail method, of class Korisnik
     */
    @Test
    public void testSetEmailNemaLudoA() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setEmail("peragmail.com"));
    }

    /**
     * Test of setPassword method, of class Korisnik
     */
    @Test
    public void testSetPassword() {
        k.setPassword("peraperic1");

        assertEquals("peraperic1", k.getPassword());
    }

    /**
     * Test of setPassword method, of class Korisnik
     */
    @Test
    public void testSetPasswordNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setPassword(null));
    }

    /**
     * Test of setPassword method, of class Korisnik
     */
    @Test
    public void testSetPasswordManjeOdSedam() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setEmail("pera"));
    }

    /**
     * Test of setPassword method, of class Korisnik
     */
    @Test
    public void testSetPasswordNemaBroja() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setEmail("peraperic"));
    }

    /**
     * Test of setUsername method, of class Korisnik
     */
    @Test
    public void testSetUsername() {
        k.setUsername("Peric");

        assertEquals("Peric", k.getUsername());
    }

    /**
     * Test of setUsername method, of class Korisnik
     */
    @Test
    public void testSetUsernameNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setUsername(null));
    }

    /**
     * Test of setUsername method, of class Korisnik
     */
    @Test
    public void testSetUsernameManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setUsername("P"));
    }

    /**
     * Test of toString method, of class Korisnik.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, () -> k.toString());
    }

    /**
     * Test of toString method, of class Korisnik.
     */
    @Test
    public void testToString() {
        k.setIme("Petar");
        assertEquals("Petar", k.toString());
    }
    
    @Test
    public void testEquals() {
        k.setUsername("username");
        k.setPassword("password");
        Korisnik korisnik = new Korisnik();
        korisnik.setUsername("username");
        korisnik.setPassword("password");
        
        assertEquals(korisnik, k);
    }
}
