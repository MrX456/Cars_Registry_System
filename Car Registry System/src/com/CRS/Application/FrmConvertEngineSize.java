/*
 * This JFrame is responsible for size conversions
 */
package com.CRS.Application;

import com.CRS.Utils.Converter;
import com.CRS.Utils.CoolStuff;

/*
 * Car Registry System / Application / Conversions / Size
 * @author MRX
 * Version : 1.0.0
 */

public class FrmConvertEngineSize extends javax.swing.JFrame {

    /**
     * Creates new form FrmConvertEngineSize
     */
    public FrmConvertEngineSize() {
        initComponents();
        // Custom icon for jar and Jframe
        this.setIconImage(CoolStuff.createIcon().getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpConverter = new javax.swing.ButtonGroup();
        panColor = new javax.swing.JPanel();
        btnConvert = new javax.swing.JButton();
        panCCtoInch = new javax.swing.JPanel();
        radCCtoInch = new javax.swing.JRadioButton();
        lblCC = new javax.swing.JLabel();
        txtCC = new javax.swing.JTextField();
        lblInch = new javax.swing.JLabel();
        txtInch = new javax.swing.JTextField();
        panInchtoCC = new javax.swing.JPanel();
        lblInch2 = new javax.swing.JLabel();
        txtInch2 = new javax.swing.JTextField();
        radInchtoCC = new javax.swing.JRadioButton();
        lblCC2 = new javax.swing.JLabel();
        txtCC2 = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRS - Engine Size Converter");
        setResizable(false);

        panColor.setBackground(new java.awt.Color(255, 204, 204));

        btnConvert.setText("Convert");
        btnConvert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConvert.setEnabled(false);
        btnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertActionPerformed(evt);
            }
        });

        panCCtoInch.setBackground(new java.awt.Color(255, 204, 204));
        panCCtoInch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        grpConverter.add(radCCtoInch);
        radCCtoInch.setText("cc to inch");
        radCCtoInch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radCCtoInch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCCtoInchActionPerformed(evt);
            }
        });

        lblCC.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCC.setText("cc :");

        txtCC.setEditable(false);
        txtCC.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCCKeyReleased(evt);
            }
        });

        lblInch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblInch.setText("inch :");

        txtInch.setEditable(false);
        txtInch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout panCCtoInchLayout = new javax.swing.GroupLayout(panCCtoInch);
        panCCtoInch.setLayout(panCCtoInchLayout);
        panCCtoInchLayout.setHorizontalGroup(
            panCCtoInchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCCtoInchLayout.createSequentialGroup()
                .addGroup(panCCtoInchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCCtoInchLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(radCCtoInch))
                    .addGroup(panCCtoInchLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panCCtoInchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInch)
                            .addComponent(txtInch, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCC))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panCCtoInchLayout.setVerticalGroup(
            panCCtoInchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCCtoInchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radCCtoInch)
                .addGap(24, 24, 24)
                .addComponent(lblCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        panInchtoCC.setBackground(new java.awt.Color(255, 204, 204));
        panInchtoCC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblInch2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblInch2.setText("inch :");

        txtInch2.setEditable(false);
        txtInch2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtInch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInch2KeyReleased(evt);
            }
        });

        grpConverter.add(radInchtoCC);
        radInchtoCC.setText("inch to cc");
        radInchtoCC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radInchtoCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radInchtoCCActionPerformed(evt);
            }
        });

        lblCC2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCC2.setText("cc :");

        txtCC2.setEditable(false);
        txtCC2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout panInchtoCCLayout = new javax.swing.GroupLayout(panInchtoCC);
        panInchtoCC.setLayout(panInchtoCCLayout);
        panInchtoCCLayout.setHorizontalGroup(
            panInchtoCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInchtoCCLayout.createSequentialGroup()
                .addGroup(panInchtoCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panInchtoCCLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(radInchtoCC))
                    .addGroup(panInchtoCCLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panInchtoCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInch2)
                            .addComponent(txtInch2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCC2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCC2))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panInchtoCCLayout.setVerticalGroup(
            panInchtoCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInchtoCCLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radInchtoCC)
                .addGap(26, 26, 26)
                .addComponent(lblInch2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCC2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/piston.png"))); // NOI18N
        lblTitle.setText("Engine Size Converter");

        lblTip.setBackground(new java.awt.Color(255, 204, 204));
        lblTip.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTip.setForeground(new java.awt.Color(0, 0, 204));
        lblTip.setText("?");
        lblTip.setToolTipText("cubic centimeter / cubic inch");
        lblTip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(panCCtoInch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panInchtoCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btnConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106)
                        .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(646, Short.MAX_VALUE))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panInchtoCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCCtoInch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConvert)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(530, 367));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radCCtoInchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCCtoInchActionPerformed
        // Enable first panel
        txtCC.setEditable(true);
        txtInch2.setEditable(false);
        txtCC.requestFocus();
        
        txtCC2.setText(null);
        txtInch2.setText(null);
        
        btnConvert.setEnabled(true);
    }//GEN-LAST:event_radCCtoInchActionPerformed

    private void radInchtoCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radInchtoCCActionPerformed
        // Enable second panel
        txtInch2.setEditable(true);
        txtCC.setEditable(false);
        txtInch2.requestFocus();
        
        txtCC.setText(null);
        txtInch.setText(null);
        
        btnConvert.setEnabled(true);
    }//GEN-LAST:event_radInchtoCCActionPerformed

    private void txtCCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCCKeyReleased
        // Only numbers allowed
        if(! CoolStuff.isNumber(txtCC.getText()))
            txtCC.setText(null);
    }//GEN-LAST:event_txtCCKeyReleased

    private void txtInch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInch2KeyReleased
        // Only numbers allowed
         if(! CoolStuff.isNumber(txtInch2.getText()))
            txtInch2.setText(null);
    }//GEN-LAST:event_txtInch2KeyReleased

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed
        
        // Need to verify which radio was selected
        if(radCCtoInch.isSelected()) {
            
            // We need to parse cc textbox value and pass it to method
        
            Integer res = Converter.ccToInch(Integer.parseInt(txtCC.getText()));
            txtInch.setText(res.toString());
            
        } else {
            
            // We need to parse inch textbox value and pass it to method
        
            Integer res = Converter.inchToCC(Integer.parseInt(txtInch2.getText()));
            txtCC2.setText(res.toString());
            
        }
        
    }//GEN-LAST:event_btnConvertActionPerformed

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
            java.util.logging.Logger.getLogger(FrmConvertEngineSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineSize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConvertEngineSize().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvert;
    private javax.swing.ButtonGroup grpConverter;
    private javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblCC2;
    private javax.swing.JLabel lblInch;
    private javax.swing.JLabel lblInch2;
    private javax.swing.JLabel lblTip;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panCCtoInch;
    private javax.swing.JPanel panColor;
    private javax.swing.JPanel panInchtoCC;
    private javax.swing.JRadioButton radCCtoInch;
    private javax.swing.JRadioButton radInchtoCC;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtCC2;
    private javax.swing.JTextField txtInch;
    private javax.swing.JTextField txtInch2;
    // End of variables declaration//GEN-END:variables
}
