/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.AbstractObject;
import domen.Paket;
import domen.Termin;
import domen.Trener;
import exception.ValidacijaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import komunikacija.Komunikacija;
import konstante.Operacije;
import kontroler.Kontroler;
import model.ModelTabeleTermini;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author kompic
 */
public class FrmDodajPaket extends javax.swing.JFrame {

    JFrame glavna;
    String mod;
    ModelTabeleTermini mtt;
    Paket paket;
    String naziv;

    /**
     * Creates new form FrmDodajPaket
     */
    public FrmDodajPaket() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public FrmDodajPaket(JFrame glavna) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        this.glavna = glavna;
        this.mod = "kreiraj";
        srediTabelu();
        srediCB();
        jtxtBrTermina.setEditable(false);
        jtxtBrTermina.setFocusable(false);
        this.setTitle("Unos novog paketa");
    }

    public FrmDodajPaket(FrmPaketi glavna, Paket paket) throws Exception {
        initComponents();
        this.glavna = glavna;
        this.mod = "izmeni";
        this.paket = paket;
        srediTabelu();
        srediCB();
        ucitajPaket();
        jtxtBrTermina.setEditable(false);
        jtxtBrTermina.setFocusable(false);
        this.setTitle("Izmena paketa "+paket.getNaziv());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jtxtNaziv = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtxtCena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtBrTermina = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtSacuvaj = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTermini = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Naziv paketa:");

        jLabel2.setText("Cena paketa:");

        jtxtBrTermina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBrTerminaActionPerformed(evt);
            }
        });

        jLabel3.setText("Broj termina:");

        jbtSacuvaj.setText("Sačuvaj");
        jbtSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtBrTermina, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtxtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jbtSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtBrTermina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(jbtSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Termini"));

        tblTermini.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTermini);

        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtBrTerminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBrTerminaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBrTerminaActionPerformed

    private void jbtSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSacuvajActionPerformed
        try {
            // TODO add your handling code here:
            String brTermina = jtxtBrTermina.getText();
            String nazivPaketa = jtxtNaziv.getText();
            String cena = jtxtCena.getText();
            List<Termin> termini = mtt.vratiListuTermina();
            Paket noviPaket = kreirajPaket(nazivPaketa, cena, brTermina, termini);
            if (mod.equals("kreiraj")) {
                Paket sacuvan = Kontroler.getInstance().zapamtiPaket(noviPaket);
                JOptionPane.showMessageDialog(this, "Dodat je paket sa nazivom: "
                        + sacuvan.getNaziv());
                glavna.setVisible(true);
                dispose();
            } else {
                List<AbstractObject> zaBrisanje = mtt.getZaBrisanje();
                for (AbstractObject AbstractObject : zaBrisanje) {
                    termini.add((Termin) AbstractObject);
                }
                List<Termin> noviTermini = napraviListuNovihTermina(termini);
                Paket azuriran = Kontroler.getInstance().izmeniPaket(noviPaket);
                JOptionPane.showMessageDialog(this, "Izmenjen je paket sa nazivom: "
                        + azuriran.getNaziv());
                glavna.setVisible(true);
                dispose();
            }
        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validacija", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FrmDodajPaket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrmDodajPaket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FrmDodajPaket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtSacuvajActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        glavna.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mtt.napraviRed();
        brojTermina();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int red = tblTermini.getSelectedRow();

        if (red != -1) {
            if (tblTermini.isEditing()) {
                tblTermini.getCellEditor().stopCellEditing();
            }
            if (mod.equals("izmeni")) {
                mtt.obrisi(red);
            } else {
                mtt.izbaci(red);
            }
            brojTermina();
        } else {
            JOptionPane.showMessageDialog(this, "Nije odabran termin "
                    + "za izbacivanje!", "Greška!", JOptionPane.ERROR_MESSAGE, null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void srediCB() throws Exception {
        String[] smene = {"07:00-11:00", "11:00-15:00", "15:00-18:00"};
        JComboBox cbSmena = new JComboBox(smene);
        TableColumn tcSmene = tblTermini.getColumnModel().getColumn(1);
        tcSmene.setCellEditor(new DefaultCellEditor(cbSmena));
        
        String[] radniDani = {"Ponedeljak", "Utorak", "Sreda", "Cetvrtak", "Petak", "Subota", "Nedelja"};
        JComboBox cbRadniDani = new JComboBox(radniDani);
        TableColumn tcRadniDani = tblTermini.getColumnModel().getColumn(0);
        tcRadniDani.setCellEditor(new DefaultCellEditor(cbRadniDani));
        
        ArrayList<Trener> treneri = new ArrayList<>();
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_TRENERE);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor st = Komunikacija.getInstance().procitajOdgovor();
        treneri = (ArrayList<Trener>) st.getPodaci();
        ArrayList<String> sTreneri = new ArrayList<>();
        for (Trener trener : treneri) {
            sTreneri.add(trener.toString());
        }
        System.out.println(sTreneri);
        JComboBox cbTreneri = new JComboBox(sTreneri.toArray());
        TableColumn tcTreneri = tblTermini.getColumnModel().getColumn(2);
        tcTreneri.setCellEditor(new DefaultCellEditor(cbTreneri));
        
    }

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
            java.util.logging.Logger.getLogger(FrmDodajPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDodajPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDodajPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDodajPaket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDodajPaket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtSacuvaj;
    private javax.swing.JTextField jtxtBrTermina;
    private javax.swing.JTextField jtxtCena;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTable tblTermini;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
        if (mod.equals("kreiraj")) {
            mtt = new ModelTabeleTermini();
            tblTermini.setModel(mtt);
        } else {
            mtt = new ModelTabeleTermini(paket.getTermini());
        }
        tblTermini.setModel(mtt);
    }

    private void brojTermina() {
        jtxtBrTermina.setText(mtt.vratiListuTermina().size() + "");
    }

    private Paket kreirajPaket(String nazivPaketa, String cena, String brTermina, List<Termin> termini) throws ValidacijaException, Exception {
        if (nazivPaketa.isEmpty() || cena.isEmpty()) {
            throw new ValidacijaException("Sva polja su obavezna!");
        }
        if (termini.isEmpty()) {
            throw new ValidacijaException("Nije unet ni jedan termin!");
        }
        if (!proveriNaziv(nazivPaketa)) {
            throw new ValidacijaException("Već postoji paket sa tim imenom.");
        }
        if (!proveriCenu(cena)) {
            throw new ValidacijaException("Cena nije uneta u odgovarajućem formatu.");
        }

        Paket pak = new Paket();
        pak.setNaziv(nazivPaketa);
        pak.setCena(cena);
        int j = 0;

        for (Termin termin : termini) {
            j++;
            if (termin.getSmena().equals("Odaberite smenu")) {
                throw new ValidacijaException("Nije odabrana smena za termin na poziciji: " + j);
            } else if (termin.getDan().equals("Odaberite dan")) {
                throw new ValidacijaException("Nije odabran dan za termin na poziciji: " + j);
            } else {

                for (int i = 0; i < termini.size(); i++) {

                    Termin t1 = termini.get(i);
                    if (t1 == termin) {
                        continue;
                    }
                    if (t1.getSmena().equals(termin.getSmena()) && t1.getDan().equals(termin.getDan())) {
                        throw new ValidacijaException("Uneli ste dva identična termina za ovaj paket!");
                    }
                }
                termin.setPaket(pak);
            }
        }
        pak.setTermini(termini);
        if (mod.equals("kreiraj")) {
            pak.setPaketId("0");
        } else {
//            if(!paket.getNaziv().equals(nazivPaketa) || !paket.getCena().equals(cena))
//            {
//                pak.set"izmenjen");
//            }
            pak.setPaketId(paket.getPaketId());
        }
        return pak;
    }

    private boolean proveriNaziv(String nazivPaketa) throws Exception {
        List<AbstractObject> paketi = Kontroler.getInstance().ucitajPakete();
        for (AbstractObject abs : paketi) {
            Paket p = (Paket) abs;
            if (p.getNaziv().equals(nazivPaketa) && !p.getNaziv().equals(paket.getNaziv())) {
                return false;
            }
        }
        return true;
    }

    private boolean proveriCenu(String cena) {
        for (int i = 0; i < cena.length(); i++) {
            if (!Character.isDigit(cena.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private List<Termin> napraviListuNovihTermina(List<Termin> termini) {
        List<Termin> novi = new ArrayList<>();
        List<Termin> term = paket.getTermini();
        for (Termin termin : termini) {
            if (!term.contains(termin)) {
                novi.add(termin);
            }
        }
        return novi;
    }

    private void ucitajPaket() {
        jtxtNaziv.setText(paket.getNaziv());
        jtxtCena.setText(paket.getCena());
        jtxtBrTermina.setText(paket.getTermini().size() + "");
    }

}
