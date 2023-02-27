/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kompic
 */
public class Mesto extends AbstractObject {

    private String mestoid;
    private String naziv;
    private String ptt;

    public Mesto() {
    }

    public Mesto(String mestoid, String naziv, String ptt) {
        this.mestoid = mestoid;
        this.naziv = naziv;
        this.ptt = ptt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesto other = (Mesto) obj;
        if (!Objects.equals(this.mestoid, other.mestoid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ptt + " " + naziv;
    }

    public String getMestoid() {
        return mestoid;
    }

    public void setMestoid(String mestoid) {
        this.mestoid = mestoid;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    @Override
    public String vratiImeTabele() {
        return "mesto";
    }

    @Override
    public String vratiParametre() {
        return null;
    }

    @Override
    public String vratiPK() {
        return "mestoId";
    }

    @Override
    public String vratiVrednostPK() {
        return mestoid;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> mesta = new ArrayList<>();
        try {
            while (rs.next()) {
                String MESTOID = rs.getString("mestoId");
                String NAZIV = rs.getString("naziv");
                String PTT = rs.getString("ptt");
                Mesto m = new Mesto(MESTOID, NAZIV, PTT);
                mesta.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mesta;
    }

    @Override
    public String vratiUpdate() {
        return null;
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.mestoid=pk;
    }
    
}
