/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 * Apstraktna klasa koju nasledjuje svaka domenska klasa i implementira njene
 * metode u zavisnosti od same baze i zahtevanih sistemskih operacija.
 *
 * @author kompic
 */
public abstract class AbstractObject implements Serializable {

    public abstract String vratiImeTabele();

    public abstract String vratiParametre();

    public abstract String vratiPK();

    public abstract String vratiVrednostPK();

    public abstract String vratiSlozenPK();

    public abstract List<AbstractObject> RSuTabelu(ResultSet rs);

    public abstract String vratiUpdate();

    public abstract void postaviVrednostPK(String pk);

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
