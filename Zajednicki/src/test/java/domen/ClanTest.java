/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.gen5.api.AfterEach;
import static org.junit.gen5.api.Assertions.assertThrows;
import org.junit.gen5.api.BeforeEach;

/**
 *
 * @author kompic
 */
public class ClanTest {
    Connection connection;
    Clan c;
    Mesto m;
    
    public ClanTest() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            connection = DriverManager.getConnection(url, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(ClanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        c = new Clan();
        m = new Mesto();
    }
    
    @AfterEach
    public void tearDown() {
        c = null;
        m = null;
    }
    
    /**
     * Test of toString method, of class Clan.
     */
    @Test
    public void testToStringSveNull() {
        assertThrows(java.lang.NullPointerException.class, ()-> c.toString());
    }

    
    
}
