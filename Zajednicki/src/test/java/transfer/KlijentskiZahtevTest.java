/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import org.junit.Test;
import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertThrows;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;

/**
 *
 * @author kompic
 */
public class KlijentskiZahtevTest {

    KlijentskiZahtev kz;

    public KlijentskiZahtevTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        kz = new KlijentskiZahtev();
    }

    @AfterEach
    public void tearDown() {
        kz = null;
    }

    /**
     * Test of setData method, of class KlijentskiZahtev.
     */
    @Test
    public void testSetParametar() {
        Object o1 = new Object();
        kz.setParametar(o1);

        assertEquals(o1, kz.getParametar());
    }

    /**
     * Test of setOperation method, of class KlijentskiZahtev.
     */
    @Test
    public void testSetOperacijaManjeOdJedan() {
        assertThrows(java.lang.RuntimeException.class, () -> kz.setOperacija(-1));
    }

    /**
     * Test of setOperation method, of class KlijentskiZahtev.
     */
    @Test
    public void testSetOperacija() {
        kz.setOperacija(1);
        assertEquals(1, kz.getOperacija());
    }
}
