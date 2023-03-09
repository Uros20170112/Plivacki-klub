/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.gen5.api.Assertions.assertThrows;

/**
 *
 * @author kompic
 */
public class KorisnikTest {

    Korisnik k;

    @Test
    public void testSetIme() {
        k.setIme("Pera");

        assertEquals("Pera", k.getIme());
    }

    @Test
    public void testSetImeNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setIme(null));
    }

    @Test
    public void testSetImeManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setIme("P"));
    }

    @Test
    public void testSetEmail() {
        k.setEmail("pera@gmail.com");

        assertEquals("pera@gmail.com", k.getEmail());
    }

    @Test
    public void testSetEmailNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setEmail(null));
    }

    @Test
    public void testSetEmailNemaLudoA() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setEmail("peragmail.com"));
    }

    @Test
    public void testSetPassword() {
        k.setPassword("peraperic1");

        assertEquals("peraperic1", k.getEmail());
    }

    @Test
    public void testSetPasswordNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setPassword(null));
    }

    @Test
    public void testSetPasswordManjeOdSedam() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setEmail("pera"));
    }

    @Test
    public void testSetPasswordNemaBroja() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> k.setEmail("peraperic"));
    }
    
    @Test
    public void testSetUsername() {
        k.setUsername("Peric");

        assertEquals("Peric", k.getUsername());
    }

    @Test
    public void testSetUsernameNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> k.setUsername(null));
    }

    @Test
    public void testSetUsernameManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> k.setUsername("P"));
    }
}
