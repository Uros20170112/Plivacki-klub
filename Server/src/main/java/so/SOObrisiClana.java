/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;

/**
 *
 * @author kompic
 */
public class SOObrisiClana extends AbstractSO {

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.delete(ao);
    }

}
