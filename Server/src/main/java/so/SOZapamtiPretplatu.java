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
public class SOZapamtiPretplatu extends AbstractSO {
    
    private AbstractObject pretplata;

    public SOZapamtiPretplatu(AbstractObject pretplata) {
        this.pretplata = pretplata;
    }
    @Override
    protected void execute(AbstractObject ao) throws ServerskiException {
            dbb.insert(pretplata);
    }
    public AbstractObject getPretplata() {
        return pretplata;
    }

    @Override
    protected void validate(AbstractObject ao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
