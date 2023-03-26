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
 * @author kompic
 */
public abstract class AbstractSO {

    protected DBBroker dbb;

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
    

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    private void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }

    private void disconnect() throws ServerskiException {
        dbb.disconnect();
    }

    private void connect() throws ServerskiException, IOException {
        dbb.connect();
    }

    protected abstract void execute(AbstractObject ao) throws ServerskiException;

}
