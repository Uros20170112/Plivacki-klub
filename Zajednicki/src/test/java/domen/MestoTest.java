/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.gen5.api.AfterAll;
import org.junit.gen5.api.AfterEach;
import static org.junit.gen5.api.Assertions.assertThrows;
import org.junit.gen5.api.BeforeAll;
import org.junit.gen5.api.BeforeEach;

/**
 *
 * @author kompic
 */
public class MestoTest {
    Mesto m;

    public MestoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        m = new Mesto();
    }

    @After
    public void tearDown() {
        m = null;
    }

    @Test
    public void testSetMestoId() {
        m.setMestoId("1");

        assertEquals("1", m.getMestoId());
    }

    @Test
    public void testSetMestoIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setMestoId(null));
    }

    @Test
    public void testSetMestoIdPrazanString() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> m.setMestoId(""));
    }

    @Test
    public void testSetMestoIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setMestoId("0"));
    }
        @Test
    public void testSetNaziv() {
        m.setNaziv("Beograd");

        assertEquals("Beograd", m.getNaziv());
    }

    @Test
    public void testSetNazivNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setNaziv(null));
    }

    @Test
    public void testSetNazivManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setNaziv("B"));
    }
        @Test
    public void testSetPtt() {
        m.setPtt("11000");

        assertEquals("11000", m.getPtt());
    }

    @Test
    public void testSetPttNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setPtt(null));
    }
    
    @Test
    public void testSetPttNijeBroj() {
        assertThrows(java.lang.IllegalArgumentException.class,
                () -> m.setPtt("1100a"));
    }

    @Test
    public void testSetPttManjeOdDva() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setPtt("1"));
    }
    
    
}
