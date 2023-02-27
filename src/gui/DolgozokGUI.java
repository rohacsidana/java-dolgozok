package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ember;

public class DolgozokGUI extends javax.swing.JFrame {

    static List<Ember> emberek = new ArrayList<>();
    static List<Ember> lanyok = new ArrayList<>();
    static List<Ember> fiuk = new ArrayList<>();
    static Ember valasztottEmber;

    public DolgozokGUI(List<Ember> e) {
        emberek = e;
        initComponents();
        buttonGroupFiuLany.add(radioFiu);
        buttonGroupFiuLany.add(radioLany);
        nemekSzerintiBontas();
        emberekrolAdatBetolt('L');
    }

    public DolgozokGUI() {
        initComponents();
    }

    public void emberAdataiBetolt() {
        labelKor.setText("" + valasztottEmber.getKor());
        labelMiotaDolgozik.setText("" + valasztottEmber.getMunkTöltÉv() + " éve");
    }

    public void emberekrolAdatBetolt(char nem) {
        List<Ember> vizsgaltEmberek = vizsgaltEmberekEldontes(nem);

        labelLegidosebb.setText(legidosebbEmber(vizsgaltEmberek).getKor() + " éves");
        labelOsszKor.setText("" + osszKor(vizsgaltEmberek) + " év");
        String nevek = hatEveIttDolgozokNevei(vizsgaltEmberek);
        label6eveDolgozok.setText(nevek);
    }

    public void fajlbaIras(char nem) throws IOException {

        File fileName = new File("ember-adatok.txt");
        try (FileWriter fw = new FileWriter(fileName)) {
            if (nem == 'L' || nem == 'M') {
                fw.write("Lányok:" + "\n");
                fw.write("Legidősebb: " + legidosebbEmber(lanyok).getKor() + " éves\n");
                fw.write("Összes kor: " + osszKor(lanyok) + " év\n");
                fw.write("6 éve dolgozók: " + hatEveIttDolgozokNevei(lanyok) + "\n");
            }
            if (nem == 'F' || nem == 'M') {
                fw.write("Fiúk:" + "\n");
                fw.write("Legidősebb: " + legidosebbEmber(fiuk).getKor() + " éves\n");
                fw.write("Összes kor: " + osszKor(fiuk) + " év\n");
                fw.write("6 éve dolgozók: " + hatEveIttDolgozokNevei(fiuk) + "\n");
            }
        }
    }

    public void embertKeres(String nev) {
        for (Ember ember : emberek) {
            if (ember.getNev().equals(nev)) {
                valasztottEmber = ember;
            }
        }
        emberAdataiBetolt();
    }

    public void nemekSzerintiBontas() {

        for (int i = 0; i < emberek.size(); i++) {
            if (emberek.get(i).getNem() == 'L') {
                lanyok.add(emberek.get(i));
            } else if (emberek.get(i).getNem() == 'F') {
                fiuk.add(emberek.get(i));
            }
        }

        for (Ember lany : lanyok) {
            comboLanyok.addItem(lany.getNev());
        }
        for (Ember fiu : fiuk) {
            comboFiuk.addItem(fiu.getNev());
        }
    }

    public List<Ember> vizsgaltEmberekEldontes(char nem) {
        List<Ember> vizsgaltEmberek = new ArrayList<>();
        switch (nem) {
            case 'L' ->
                vizsgaltEmberek = lanyok;
            case 'F' ->
                vizsgaltEmberek = fiuk;
            case 'M' ->
                vizsgaltEmberek = emberek;
            default -> {
            }
        }
        return vizsgaltEmberek;
    }

    public String hatEveIttDolgozokNevei(List<Ember> emberLista) {
        List<String> hatEveDolgozok = new ArrayList<>();

        for (Ember ember : emberLista) {
            if (ember.getMunkTöltÉv() >= 6) {
                hatEveDolgozok.add(ember.getNev());
            }
        }

        String nevek = "";
        if (hatEveDolgozok.isEmpty()) {
            nevek = "nincs";
        } else {
            for (int i = 0; i < hatEveDolgozok.size(); i++) {
                nevek += hatEveDolgozok.get(i);
                if (!(hatEveDolgozok.get(i).equals(hatEveDolgozok.get(hatEveDolgozok.size()-1)))) {
                    nevek += ", ";

                }
            }
        }

        return nevek;
    }

    public int osszKor(List<Ember> emberLista) {
        int sum = 0;
        for (Ember ember : emberLista) {
            sum += ember.getKor();
        }
        return sum;
    }

    public Ember legidosebbEmber(List<Ember> emberLista) {
        Ember legidosebb = new Ember("", 0, 'L');

        for (Ember ember : emberLista) {
            if (ember.getKor() > legidosebb.getKor()) {
                legidosebb = ember;
            }
        }
        return legidosebb;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupFiuLany = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        comboLanyok = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboFiuk = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        radioLany = new javax.swing.JRadioButton();
        radioFiu = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelLegidosebb = new javax.swing.JLabel();
        labelOsszKor = new javax.swing.JLabel();
        label6eveDolgozok = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelKor = new javax.swing.JLabel();
        labelMiotaDolgozik = new javax.swing.JLabel();
        checkMindkettoNem = new javax.swing.JCheckBox();
        buttonMentes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dolgozók");

        jLabel1.setText("Lányok");

        comboLanyok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboLanyokActionPerformed(evt);
            }
        });

        jLabel2.setText("Fiúk");

        comboFiuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFiukActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Összesítő"));

        radioLany.setSelected(true);
        radioLany.setText("lány");
        radioLany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLanyActionPerformed(evt);
            }
        });

        radioFiu.setText("fiú");
        radioFiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFiuActionPerformed(evt);
            }
        });

        jLabel3.setText("legidősebb:");

        jLabel4.setText("összes kor:");

        jLabel5.setText("6 éve dolgozó:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioLany)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioFiu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelLegidosebb, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOsszKor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label6eveDolgozok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioLany)
                    .addComponent(radioFiu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(labelLegidosebb, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(labelOsszKor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(label6eveDolgozok, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Adatok"));

        jLabel6.setText("kor:");

        jLabel7.setText("mióta dolgozik:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(labelKor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelMiotaDolgozik, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelKor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMiotaDolgozik, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        checkMindkettoNem.setText("Mindkettő nem");

        buttonMentes.setText("Mentés");
        buttonMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboLanyok, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboFiuk, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkMindkettoNem)
                    .addComponent(buttonMentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboLanyok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboFiuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkMindkettoNem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonMentes))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboLanyokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboLanyokActionPerformed
        embertKeres((String) comboLanyok.getSelectedItem());
    }//GEN-LAST:event_comboLanyokActionPerformed

    private void comboFiukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFiukActionPerformed
        embertKeres((String) comboFiuk.getSelectedItem());
    }//GEN-LAST:event_comboFiukActionPerformed

    private void radioLanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLanyActionPerformed
        emberekrolAdatBetolt('L');
    }//GEN-LAST:event_radioLanyActionPerformed

    private void radioFiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFiuActionPerformed
        emberekrolAdatBetolt('F');
    }//GEN-LAST:event_radioFiuActionPerformed

    private void buttonMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMentesActionPerformed
        char vizsgaltEmberek = 'M';
        if (checkMindkettoNem.isSelected()) {
            vizsgaltEmberek = 'M';
        } else if (radioLany.isSelected()) {
            vizsgaltEmberek = 'L';
        } else if (radioFiu.isSelected()) {
            vizsgaltEmberek = 'F';
        }
        try {
            fajlbaIras(vizsgaltEmberek);
        } catch (IOException ex) {
            Logger.getLogger(DolgozokGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonMentesActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(DolgozokGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DolgozokGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DolgozokGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DolgozokGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DolgozokGUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupFiuLany;
    private javax.swing.JButton buttonMentes;
    private javax.swing.JCheckBox checkMindkettoNem;
    private javax.swing.JComboBox<String> comboFiuk;
    private javax.swing.JComboBox<String> comboLanyok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label6eveDolgozok;
    private javax.swing.JLabel labelKor;
    private javax.swing.JLabel labelLegidosebb;
    private javax.swing.JLabel labelMiotaDolgozik;
    private javax.swing.JLabel labelOsszKor;
    private javax.swing.JRadioButton radioFiu;
    private javax.swing.JRadioButton radioLany;
    // End of variables declaration//GEN-END:variables
}
