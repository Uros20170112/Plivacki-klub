/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.gen5.api.Assertions.assertEquals;
import static org.junit.gen5.api.Assertions.assertSame;

/**
 *
 * @author kompic
 */
public class ServerskiOdgovorTest {

    ServerskiOdgovor so;

    public ServerskiOdgovorTest() {
    }


    @Before
    public void setUp() {
        so = new ServerskiOdgovor();
    }

    @After
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
