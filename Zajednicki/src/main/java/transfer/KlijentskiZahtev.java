/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
/**
 *
 * @author kompic
 */
public class KlijentskiZahtev implements Serializable{
    private int operacija;
    private Object parametar;

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        if(operacija < 0) {
            throw new RuntimeException();
        }
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
    
}
