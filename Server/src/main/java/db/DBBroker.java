/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.AbstractObject;
import exception.ServerskiException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kompic
 */
public class DBBroker {

    private Connection connection;
    private static DBBroker instance;

    private DBBroker() {
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws ServerskiException, FileNotFoundException, IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("dbconfig.properties"));
            String url = properties.getProperty("url");
            url.replaceAll("[^a-zA-Z0-9/:]", "");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new ServerskiException("Konekcija na bazu nije uspela!");
        }
    }

    public void disconnect() throws ServerskiException {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new ServerskiException("Raskidanje konekcije nije uspelo!");
        }
    }

    public void commit() throws ServerskiException {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new ServerskiException("Commit nije uspeo!");
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            System.out.println("Rollback nije uspeo!");
        }
    }

    public List<AbstractObject> select(AbstractObject o) throws ServerskiException {
        try {
            String upit = "SELECT * FROM " + o.vratiImeTabele();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            List<AbstractObject> listaObjekata = o.RSuTabelu(rs);
            s.close();
            System.out.println("Upit:\n" + upit);
            return listaObjekata;
        } catch (SQLException ex) {
            throw new ServerskiException("Server ne moze da prikaze podatke o " + o.getClass().getName() + ".");
        }
    }

    public AbstractObject insert(AbstractObject o) throws ServerskiException {
        try {

            String tipUpita = "INSERT";
            String upit = String.format("INSERT INTO %s VALUES (%s)", o.vratiImeTabele(), o.vratiParametre());

            System.out.println("Upit:\n" + upit);
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() as last_id from " + o.vratiImeTabele());
            while (rs.next()) {
                String lastid = rs.getString("last_id");
                o.postaviVrednostPK(lastid);
                break;
            }

            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public AbstractObject selectWithPK(AbstractObject o, String ID) throws ServerskiException {
        String upit;
        if (o.vratiPK() != null) {
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiPK() + "=" + ID;
        } else {
            upit = "SELECT * FROM " + o.vratiImeTabele() + " WHERE " + o.vratiSlozenPK();
        }
        try ( Statement s = connection.createStatement();) {
            ResultSet rs = s.executeQuery(upit);
            List<AbstractObject> listaObjekata = o.RSuTabelu(rs);
            s.close();
            System.out.println("Upit:\n" + upit);
            return listaObjekata.get(0);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
    }

    public AbstractObject delete(AbstractObject o) throws ServerskiException {
        try {
            String upit = "";
            if (o.vratiPK() != null) {
                upit = String.format("DELETE FROM %s WHERE %s = %s", o.vratiImeTabele(), o.vratiPK(), o.vratiVrednostPK());
            } else {
                upit = String.format("DELETE FROM %s WHERE %s", o.vratiImeTabele(), o.vratiSlozenPK());

            }
            Statement s = connection.createStatement();
            System.out.println("Upit:\n" + upit);
            s.executeUpdate(upit);
            commit();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServerskiException(ex.getMessage());
        }
        return o;
    }

    public AbstractObject update(AbstractObject o) throws ServerskiException {
        try {
            String upit;
            if (o.vratiPK() != null) {
                upit = String.format("UPDATE %s SET %s WHERE %s = %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiPK(), o.vratiVrednostPK());
            } else {
                upit = String.format("UPDATE %s SET %s WHERE %s", o.vratiImeTabele(), o.vratiUpdate(), o.vratiSlozenPK());
            }
            System.out.println("Upit:\n" + upit);
            Statement s = connection.createStatement();
            s.executeUpdate(upit);
            s.close();
            return o;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
