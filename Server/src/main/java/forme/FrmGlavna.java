/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.Korisnik;
import exception.ServerskiException;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleKorisnici;
import niti.OsveziNit;
import server.Server;

/**
 *
 * @author kompic
 */
public class FrmGlavna extends javax.swing.JFrame {

    Server server;
    ModelTabeleKorisnici mtk;

    /**
     * Creates new form FrmGlavna
     */
    public FrmGlavna() {
        initComponents();
        srediFormu();
        skloniAdminPanel();
        srediTabelu();
        startujOsvezavanje();
        this.getRootPane().setDefaultButton(btnPokreniZaustavi);
        setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        pnlAdmin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKorisnici = new javax.swing.JTable();
        btnDodajKorisnika = new javax.swing.JButton();
        btnObrisiKorisnika = new javax.swing.JButton();
        btnPokreniZaustavi = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server program");
        setResizable(false);

        pnlAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin opcije"));

        tblKorisnici.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblKorisnici);

        btnDodajKorisnika.setText("Dodaj korisnika");
        btnDodajKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajKorisnikaActionPerformed(evt);
            }
        });

        btnObrisiKorisnika.setText("Obriši korisnika");
        btnObrisiKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiKorisnikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAdminLayout = new javax.swing.GroupLayout(pnlAdmin);
        pnlAdmin.setLayout(pnlAdminLayout);
        pnlAdminLayout.setHorizontalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajKorisnika)
                    .addComponent(btnObrisiKorisnika))
                .addGap(6, 6, 6))
        );
        pnlAdminLayout.setVerticalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDodajKorisnika, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrisiKorisnika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );

        btnPokreniZaustavi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPokreniZaustavi.setText("Pokreni server");
        btnPokreniZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniZaustaviActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 51, 0));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("SERVER NIJE POKRENUT");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(pnlAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(btnPokreniZaustavi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPokreniZaustavi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniZaustaviActionPerformed
        if (!Server.isRadi()) {
            server = new Server();
            server.start();
            Server.setRadi(true);
            serverRadi();
        } else {
            server.zaustaviNiti();
            serverNeRadi();
            Server.setRadi(false);
        }
    }//GEN-LAST:event_btnPokreniZaustaviActionPerformed

    private void btnDodajKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajKorisnikaActionPerformed
        FrmDodajKorisnika fdk = new FrmDodajKorisnika(this);
        fdk.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDodajKorisnikaActionPerformed

    private void btnObrisiKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiKorisnikaActionPerformed
        int red = tblKorisnici.getSelectedRow();
        if (red != -1) {
            Korisnik k = mtk.getKorisnici().get(red);
            String ulogovan = (String) mtk.getValueAt(red, 3);
            if (ulogovan.equals("online")) {
                JOptionPane.showMessageDialog(rootPane, "Korisnik " + k.getIme() + " je trenutno ulogovan.", "Greška", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int odluka = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete korisnika " + k.getIme() + "?", "", JOptionPane.WARNING_MESSAGE);

            if (odluka == 0) {
                try {
                    Kontroler.getInstance().obrisiKorisnika(k);
                    JOptionPane.showMessageDialog(rootPane, "Obrisan je korisnik " + k.getIme());
                    mtk.obrisiKorisnika(k);
                } catch (ServerskiException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Došlo je do greške kod brisanja korisnika " + k.getIme() + ". Korisnik nije obrisan.", "Greška", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selektujte korisnika kog želite da obrišete.", "Greška", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnObrisiKorisnikaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavna().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajKorisnika;
    private javax.swing.JButton btnObrisiKorisnika;
    private javax.swing.JButton btnPokreniZaustavi;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlAdmin;
    private javax.swing.JTable tblKorisnici;
    // End of variables declaration//GEN-END:variables

    private void serverRadi() {
        btnPokreniZaustavi.setText("Zaustavi server");
        lblStatus.setText("SERVER JE POKRENUT");
        lblStatus.setForeground(Color.green);
        omoguciAdminPanel();
        srediTabelu();
        //postavi meni korisnici da se vidi
        //meni server da se ne vidi
    }

    private void serverNeRadi() {
        btnPokreniZaustavi.setText("Pokreni server");
        lblStatus.setText("SERVER NIJE POKRENUT");
        lblStatus.setForeground(Color.red);
        skloniAdminPanel();
        //postavi meni korisnici da se ne vidi
        //meni server da se vidi
    }

    private void srediFormu() {
        serverNeRadi();
    }

    private void skloniAdminPanel() {
        pnlAdmin.setVisible(false);
        pack();
    }

    private void omoguciAdminPanel() {
        pnlAdmin.setVisible(true);
        pack();
    }

    public void srediTabelu() {
        try {
            mtk = new ModelTabeleKorisnici(new ArrayList<Korisnik>());
            List<Korisnik> korisniciBaza = new ArrayList<>();
            korisniciBaza = Kontroler.getInstance().vratiListuKorisnika();
            for (AbstractObject AbstractObject : korisniciBaza) {
                Korisnik k = (Korisnik) AbstractObject;
                mtk.dodajKorisnika(k);
            }
            tblKorisnici.setModel(mtk);
        } catch (ServerskiException ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške kod učitavanja podataka o korisnicima!", "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setVisible(boolean b) {
        srediTabelu();
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }

    public void osveziTabelu() {
        try {
            Kontroler.getInstance().azurirajKorisnike();
            srediTabelu();
            System.out.println("Osvezio korisnike");
        } catch (ServerskiException ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmGlavna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startujOsvezavanje() {
        OsveziNit osvezi = new OsveziNit(this);
        osvezi.start();
    }

}
