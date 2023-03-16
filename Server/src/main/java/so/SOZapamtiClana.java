/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.AbstractObject;
import exception.ServerskiException;
import java.util.List;

/**
 *
 * @author vujke
 */
public class SOZapamtiClana extends AbstractSO {

    private AbstractObject clan;
    private AbstractObject istorijatPaketa;

    public SOZapamtiClana() {
    }

    public SOZapamtiClana(List<Object> parametri) {
        this.clan = (AbstractObject) parametri.get(0);
        this.istorijatPaketa = (AbstractObject) parametri.get(1);
    }

    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
        dbb.insert(clan);
        dbb.insert(istorijatPaketa);
    }

    public AbstractObject getClan() {
        return clan;
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
