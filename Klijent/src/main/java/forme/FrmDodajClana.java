/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.Clan;
import domen.PromenaPaketa;
import domen.Mesto;
import domen.Paket;
import exception.ValidacijaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author kompic
 */
public class FrmDodajClana extends javax.swing.JFrame {

    String mod;
    JFrame glavna;
    Clan clan;

    /**
     * Creates new form FrmDodajClana
     */
    public FrmDodajClana() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public FrmDodajClana(JFrame glavna) {
        initComponents();
        setLocationRelativeTo(null);
        popuniCB();
        this.glavna = glavna;
        this.mod = "kreiraj";
        this.setTitle("Unos člana plivačkog kluba");
    }

    public FrmDodajClana(FrmClanovi glavna, Clan clan, Paket p ) {
        initComponents();
        popuniCB();
        this.clan = clan;
        ucitajClana(p);
        this.glavna = glavna;
        this.mod = "izmeni";
        this.setTitle("Izmena člana "+clan.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtxtIme = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtPrezime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtTelefon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtAdresa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jcbMesto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jcbPaket = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbtDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos člana plivačkog saveza");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("E-mail:");

        jLabel4.setText("Telefon:");

        jLabel5.setText("Adresa:");

        jLabel6.setText("Mesto:");

        jcbPaket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPaketActionPerformed(evt);
            }
        });

        jLabel7.setText("Paket usluga:");

        jbtDodaj.setText("Sačuvaj");
        jbtDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbPaket, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbMesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtxtTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jbtDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jbtDodaj)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 376, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPaketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPaketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbPaketActionPerformed

    private void jbtDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDodajActionPerformed
        try {
            // TODO add your handling code here:

            String ime = jtxtIme.getText().trim();
            String prezime = jtxtPrezime.getText().trim();
            String email = jtxtEmail.getText().trim();
            String tel = jtxtTelefon.getText().trim();
            String adresa = jtxtAdresa.getText().trim();
            Mesto mesto = (Mesto) jcbMesto.getSelectedItem();
            Paket paket = (Paket) jcbPaket.getSelectedItem();

            Clan c = kreirajClana(ime, prezime, email, tel, adresa, mesto, paket);
            List<Object> parametri = new ArrayList<>();
            parametri.add(c);
            Date trenutnoVreme = new Date();
            PromenaPaketa ip = new PromenaPaketa(true, trenutnoVreme, c, paket, "0");
            parametri.add(ip);
            if (mod.equals("kreiraj")) {
                Clan cl = (Clan) Kontroler.getInstance().zapamtiClana(parametri);
                JOptionPane.showMessageDialog(this, "Uspešno ste sačuvali člana " + cl.toString());

            } else {
                Clan cla = Kontroler.getInstance().izmeniClana(parametri);
                JOptionPane.showMessageDialog(this, "Uspešno ste sačuvali člana " + cla.toString());
            }
            glavna.setVisible(true);
            dispose();
        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validacija", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmDodajClana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmDodajClana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbtDodajActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        glavna.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDodajClana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDodajClana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbtDodaj;
    private javax.swing.JComboBox<AbstractObject> jcbMesto;
    private javax.swing.JComboBox<AbstractObject> jcbPaket;
    private javax.swing.JTextField jtxtAdresa;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtIme;
    private javax.swing.JTextField jtxtPrezime;
    private javax.swing.JTextField jtxtTelefon;
    // End of variables declaration//GEN-END:variables

    private void popuniCB() {
        try {
            List<AbstractObject> mesta = new ArrayList<>();
            List<AbstractObject> paketi = new ArrayList<>();
            mesta = Kontroler.getInstance().ucitajMesta();
            paketi = Kontroler.getInstance().ucitajPakete();
            for (AbstractObject m : mesta) {
                jcbMesto.addItem(m);
            }
            for (AbstractObject p : paketi) {
                jcbPaket.addItem(p);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmDodajClana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Clan kreirajClana(String ime, String prezime, String email, String tel, String adresa, Mesto mesto, Paket paket) throws ValidacijaException {
        if (ime.isEmpty() || prezime.isEmpty() || email.isEmpty() || tel.isEmpty() || adresa.isEmpty() || mesto == null || paket == null) {
            throw new ValidacijaException("Sva polja su obavezna!");
        }

        if (!validirajTelefon(tel)) {
            throw new ValidacijaException("Nije unet validan broj telefona!");
        }

        if (!validirajMejl(email)) {
            throw new ValidacijaException("Nije unet validan e-mail!");
        }
        Clan cl = new Clan();
        if (mod.equals("kreiraj")) {
            cl = new Clan("0", ime, prezime, email, adresa, tel, mesto);
        } else {
            cl = new Clan(clan.getClanId(), ime, prezime, email, adresa, tel, mesto);
        }
        return cl;

//        if (mode.equals("update")) {
//            //            JOptionPane.showMessageDialog(jcbPaket, "Član nije izmenjen"
//            //                    , "Greška!", JOptionPane.ERROR_MESSAGE);
//
//            Mesto mesto = (Mesto) jcbMesto.getSelectedItem();
//            Paket paket = (Paket) jcbPaket.getSelectedItem();
//            Clan clan = new Clan(clanUpdate.getClanId(), ime, prezime, email, adresa, tel, mesto);
//
//            List<Object> lista = new ArrayList<>();
//            lista.add(clan);
//            Date datumSys = new Date();
//            PromenaPaketa ip = new PromenaPaketa(true, datumSys, clan, paket, "0");
//            lista.add(ip);
//
//            try {
//                Kontroler.vratiKontrolera().izmeniClana(lista);
//                //                JOptionPane.showMessageDialog(jcbPaket, "Uspesno izmenjen clan: " + clanServer.getIme());
//
//                List<AbstractObject> cip = Kontroler.vratiKontrolera().ucitajPromenePaketa();
//                tbl.filterFormeIP(cip);
//                List<AbstractObject> clanovi = Kontroler.vratiKontrolera().ucitajClanove();
//                tbl.filterForme(clanovi);
//
//                JOptionPane.showMessageDialog(jcbPaket, "Uspešno izmenjen član",
//                        "Poruka", JOptionPane.INFORMATION_MESSAGE);
//                //            Kontroler.vratiKontrolera().izmniClan()
//            } catch (IOException ex) {
//                Logger.getLogger(DodajClanaFrm.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(DodajClanaFrm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    private boolean validirajTelefon(String tel) {
        if (tel.length() < 9) {
            return false;
        }
        for (int i = 0; i < tel.length(); i++) {
            if (!Character.isDigit(tel.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean validirajMejl(String email) {
        if (email.length() < 3) {
            return false;
        }
        if (email.charAt(0) != '@' && email.charAt(email.length() - 1) != '@' && email.contains("@")) {
            return true;
        }
        return false;
    }

    private void ucitajClana(Paket paket) {
        jtxtIme.setText(clan.getIme());
        jtxtPrezime.setText(clan.getPrezime());
        jtxtAdresa.setText(clan.getAdresa());
        jtxtTelefon.setText(clan.getTelefon());
        jtxtEmail.setText(clan.getEmail());
        jcbMesto.setSelectedItem(clan.getMesto());
        jcbPaket.setSelectedItem(paket);
    }
}
