/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.AbstractObject;
import exception.ServerskiException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * Apstraktna klasa koju ce da implementiraju sve klase namenski kreirane za
 * izvrsenje sistemskih operacija.
 *
 * @author kompic
 */
public abstract class AbstractSO {

    protected DBBroker dbb;

    /**
     * Metoda koja poziva redom metode validate() i execute() i potvrdjuje
     * transakcuju ako nije doslo do greske; u suprotnom ponistava transakciju
     * nad bazom.
     *
     * @param ao
     * @throws Exception ako dodje do neke greske
     */
    synchronized public void templateExecute(AbstractObject ao) throws Exception {
        try {
            connect();
            execute(ao);
            commit();
            disconnect();
        } catch (Exception ex) {
            rollback();
            throw ex;
        }
    }

    /**
     * Potvrdjuje transakciju nad bazom.
     *
     * @throws SQLException
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    /**
     * Ponistava transakciju nad bazom
     *
     * @throws SQLException
     */
    private void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }

    /**
     * Prekida vezu sa bazom.
     *
     * @throws ServerskiException
     */
    private void disconnect() throws ServerskiException {
        dbb.disconnect();
    }

    /**
     * Uspostavlja vezu sa bazom.
     *
     * @throws ServerskiException
     * @throws IOException
     */
    private void connect() throws ServerskiException, IOException {
        dbb.connect();
    }

    /**
     * Metoda kojom se poziva odgovarajuca metoda DBBroker-a i primaju povratni
     * podaci ako ih ima.
     *
     * @param ao
     * @throws Exception - ako dodje do greske prilikom neke transakcije nad
     * bazom ili kastovanje povratnih podataka (ako ih ima).
     */
    protected abstract void execute(AbstractObject ao) throws ServerskiException;

}
