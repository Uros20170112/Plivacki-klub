/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.FrmGlavna;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kompic
 */
public class OsveziNit extends Thread {

    FrmGlavna forma;

    public OsveziNit(FrmGlavna forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        while (true) {
            forma.srediTabelu();
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(OsveziNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
