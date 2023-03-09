/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import org.junit.Test;
import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertSame;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;

/**
 *
 * @author kompic
 */
public class ServerskiOdgovorTest {

    ServerskiOdgovor so;

    public ServerskiOdgovorTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        so = new ServerskiOdgovor();
    }

    @AfterEach
    public void tearDown() {
        so = null;
    }

    /**
     * Test of setData method, of class ServerskiOdgovor.
     */
    @Test
    public void testSetData() {
        so.setPodaci(1);
        assertEquals(1, so.getPodaci());
    }

    /**
     * Test of setException method, of class ServerskiOdgovor.
     */
    @Test
    public void testSetException() {
        Exception exc = new NullPointerException();
        so.setException(exc);
        assertSame(exc, so.getException());
    }

}
