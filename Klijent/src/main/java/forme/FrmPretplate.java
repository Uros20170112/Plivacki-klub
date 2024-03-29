/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.Clan;
import domen.Paket;
import domen.Pretplata;
import exception.ValidacijaException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleClanovi;
import model.ModelTabelePretplate;

/**
 *
 * @author kompic
 */
public class FrmPretplate extends javax.swing.JFrame {

    private FrmGlavna glavna;
    private ModelTabeleClanovi mtc;
    private Clan odabrani;
    private Date datum;
    private Paket paket;
    private ModelTabelePretplate mtp;

    /**
     * Creates new form FrmClanarine
     */
    public FrmPretplate() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public FrmPretplate(FrmGlavna glavna) {
        initComponents();
        setLocationRelativeTo(null);
        this.glavna = glavna;
        datum = new Date();
        srediTabelu();
        srediTabeluPretplate();
        popuniCB();
        skloniPanel();
        tblPretplate.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPretragaClanova = new javax.swing.JTextField();
        btnPretraziClanove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClanovi = new javax.swing.JTable();
        btnPonistiClanove = new javax.swing.JButton();
        btnIzaberiClana = new javax.swing.JButton();
        pnlEvidencija = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblImePrezime = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPaket = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPretplate = new javax.swing.JTable();
        cbPaketi = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga"));

        jLabel1.setText("Unesite kriterijum pretrage:");

        btnPretraziClanove.setText("Pretraži");
        btnPretraziClanove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziClanoveActionPerformed(evt);
            }
        });

        tblClanovi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblClanovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblClanovi);

        btnPonistiClanove.setText("Poništi");
        btnPonistiClanove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonistiClanoveActionPerformed(evt);
            }
        });

        btnIzaberiClana.setText("Izaberi");
        btnIzaberiClana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzaberiClanaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretragaClanova))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPretraziClanove, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(btnPonistiClanove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIzaberiClana)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretragaClanova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPretraziClanove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPonistiClanove))
                    .addComponent(btnIzaberiClana, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Ime i prezime:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("E-mail:");

        lblImePrezime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblImePrezime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblImePrezime.setText("jLabel2");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEmail.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Paket:");

        lblPaket.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPaket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaket.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Datum:");

        lblDatum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblDatum.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDatum.setText("jLabel2");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton4.setText("Evidentiraj pretplatu");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlEvidencijaLayout = new javax.swing.GroupLayout(pnlEvidencija);
        pnlEvidencija.setLayout(pnlEvidencijaLayout);
        pnlEvidencijaLayout.setHorizontalGroup(
            pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImePrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(lblDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEvidencijaLayout.setVerticalGroup(
            pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEvidencijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlEvidencijaLayout.createSequentialGroup()
                        .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(lblImePrezime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlEvidencijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPaket)
                            .addComponent(lblDatum))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretplate"));

        tblPretplate.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPretplate);

        jButton5.setText("Pretraži pretplate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Poništi");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cbPaketi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPaketi)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlEvidencija, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlEvidencija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziClanoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziClanoveActionPerformed
        try {
            skloniPanel();

            String pretraga = txtPretragaClanova.getText().trim();
            if (pretraga.isEmpty()) {

                srediTabelu();
                return;
            }
            List<AbstractObject> clanovi = Kontroler.getInstance().pretraziClanove(pretraga);
            if (clanovi.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Ne postoji član po "
                        + "zadatoj vrednosti!", "Greška!", JOptionPane.ERROR_MESSAGE, null);
                return;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sistem je našao članove koji zadovoljavaju zadate vrednosti", "", JOptionPane.INFORMATION_MESSAGE);
                mtc.setClanovi(clanovi);
                mtc.fireTableDataChanged();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Greška!", JOptionPane.ERROR_MESSAGE, null);
            Logger.getLogger(FrmClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPretraziClanoveActionPerformed

    private void btnPonistiClanoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonistiClanoveActionPerformed
        srediTabelu();
    }//GEN-LAST:event_btnPonistiClanoveActionPerformed

    private void btnIzaberiClanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzaberiClanaActionPerformed
        int index = tblClanovi.getSelectedRow();
        if (index != -1) {
            Clan cl = (Clan) mtc.getClanovi().get(index);
            odabrani = cl;
            ucitajClana();
            prikaziPanel();
        } else {
            JOptionPane.showMessageDialog(this, "Selektujte člana!");
        }
    }//GEN-LAST:event_btnIzaberiClanaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(datum);
            cal.add(Calendar.DATE, +30);
            Date vaziDo = cal.getTime();
            proveriDatum();
            Pretplata pre = new Pretplata("0", datum, odabrani, paket, vaziDo);
            Pretplata p = (Pretplata) Kontroler.getInstance().zapamtiPretplatu(pre);
            JOptionPane.showMessageDialog(rootPane, "Pretplata je evidentirana! ",
                    "Poruka", JOptionPane.INFORMATION_MESSAGE, null);
            srediTabeluPretplate();
            skloniPanel();
            odabrani = null;
            tblClanovi.clearSelection();

        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Greška!", JOptionPane.ERROR_MESSAGE, null);
        } catch (Exception ex) {
            Logger.getLogger(FrmPretplate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Greška!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            Paket izabran = (Paket) cbPaketi.getSelectedItem();
            List<AbstractObject> nadjenePretplate = Kontroler.getInstance().pretraziPretplate(izabran);
            mtp = new ModelTabelePretplate(nadjenePretplate);
            tblPretplate.setModel(mtp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Greška!", JOptionPane.ERROR_MESSAGE, null);
            Logger.getLogger(FrmPretplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        srediTabeluPretplate();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPretplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPretplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPretplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPretplate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPretplate().setVisible(true);
            }
        });
    }

    private void srediTabelu() {
        try {
            List<AbstractObject> clanovi;
            List<AbstractObject> mesta;
            List<AbstractObject> listaIp;
            List<AbstractObject> paketi;

            clanovi = Kontroler.getInstance().ucitajClanove();
            mesta = Kontroler.getInstance().ucitajMesta();
            listaIp = Kontroler.getInstance().ucitajPromenePaketa();
            paketi = Kontroler.getInstance().ucitajPakete();

            mtc = new ModelTabeleClanovi(clanovi, mesta, listaIp, paketi);
            tblClanovi.setModel(mtc);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške. Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmClanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzaberiClana;
    private javax.swing.JButton btnPonistiClanove;
    private javax.swing.JButton btnPretraziClanove;
    private javax.swing.JComboBox<AbstractObject> cbPaketi;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblPaket;
    private javax.swing.JPanel pnlEvidencija;
    private javax.swing.JTable tblClanovi;
    private javax.swing.JTable tblPretplate;
    private javax.swing.JTextField txtPretragaClanova;
    // End of variables declaration//GEN-END:variables

    private void popuniCB() {
        try {
            List<AbstractObject> paketi = Kontroler.getInstance().ucitajPakete();
            cbPaketi.removeAll();
            for (AbstractObject AbstractObject : paketi) {
                Paket p = (Paket) AbstractObject;
                cbPaketi.addItem(p);
            }
            cbPaketi.setSelectedIndex(0);
        } catch (Exception ex) {
            Logger.getLogger(FrmPretplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ucitajClana() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        paket = (Paket) mtc.vratiPaket(mtc.vratiPaketId(odabrani));
        lblImePrezime.setText(odabrani.toString());
        lblEmail.setText(odabrani.getEmail());
        lblPaket.setText(paket.toString());
        lblDatum.setText(sdf.format(datum));
    }

    private void skloniPanel() {
        pnlEvidencija.setVisible(false);
        pack();
    }

    private void prikaziPanel() {
        pnlEvidencija.setVisible(true);
        pack();
    }

    private void srediTabeluPretplate() {
        try {
            mtp = new ModelTabelePretplate();
            List<AbstractObject> pretplate = Kontroler.getInstance().vratiListuPretplata();
            mtp.resetTabele(pretplate);
            tblPretplate.setModel(mtp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Došlo je do greške. Pokušajte ponovo.");
            Logger.getLogger(FrmPretplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void proveriDatum() throws ValidacijaException {
        List<AbstractObject> pretplate = mtp.vratiListu();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        for (AbstractObject AbstractObject : pretplate) {
            Pretplata p = (Pretplata) AbstractObject;
            Clan clan = p.getClan();
            Paket pak = p.getPaket();
            if (clan.equals(odabrani) && pak.equals(paket) && sdf.format(p.getDatum()).equals(sdf.format(datum))) {
                throw new ValidacijaException("Već je evidentirana uplata za ovaj period!");
            }
        }
    }
}
