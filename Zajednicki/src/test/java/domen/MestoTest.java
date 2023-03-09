/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import static org.junit.Assert.assertEquals;
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

    @BeforeEach
    public void setUp() {
        m = new Mesto();
    }

    @AfterEach
    public void tearDown() {
        m = null;
    }

    @Test
    public void testSetMestoId() {
        m.setMestoid("1");

        assertEquals("1", m.getMestoid());
    }

    @Test
    public void testSetMestoIdNull() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setMestoid(null));
    }

    @Test
    public void testSetMestoIdPrazanString() {
        assertThrows(java.lang.NullPointerException.class,
                () -> m.setMestoid(""));
    }

    @Test
    public void testSetMestoIdNulaIliManje() {
        assertThrows(java.lang.RuntimeException.class,
                () -> m.setMestoid("0"));
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
