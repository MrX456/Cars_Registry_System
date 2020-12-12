/*
 * This JFrame is responsible for torque conversions
 */
package com.CRS.Application;

import com.CRS.Utils.Converter;
import com.CRS.Utils.CoolStuff;

/*
 * Car Registry System / Application / Conversions / Torque
 * @author MRX
 * Version : 1.0.0
 */

public class FrmConvertEngineTorque extends javax.swing.JFrame {

    /**
     * Creates new form FrmConvertEngineTorque
     */
    public FrmConvertEngineTorque() {
        initComponents();
        // Custom icon for jar and Jframe
        this.setIconImage(CoolStuff.createIcon().getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpConvert = new javax.swing.ButtonGroup();
        panColor = new javax.swing.JPanel();
        btnConvert = new javax.swing.JButton();
        panNmtoFtlb = new javax.swing.JPanel();
        radNmtoFtlb = new javax.swing.JRadioButton();
        lblNm = new javax.swing.JLabel();
        txtNm = new javax.swing.JTextField();
        lblFtlb = new javax.swing.JLabel();
        txtFtlb = new javax.swing.JTextField();
        panLbfttoNm = new javax.swing.JPanel();
        radLbfttoNm = new javax.swing.JRadioButton();
        lblFtlb2 = new javax.swing.JLabel();
        txtFtlb2 = new javax.swing.JTextField();
        lblNm2 = new javax.swing.JLabel();
        txNm2 = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRS - Convert Engine Torque");
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

        panNmtoFtlb.setBackground(new java.awt.Color(255, 204, 204));
        panNmtoFtlb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        grpConvert.add(radNmtoFtlb);
        radNmtoFtlb.setText("Nm to ft-lb");
        radNmtoFtlb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radNmtoFtlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNmtoFtlbActionPerformed(evt);
            }
        });

        lblNm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNm.setText("Nm :");

        txtNm.setEditable(false);
        txtNm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNmKeyReleased(evt);
            }
        });

        lblFtlb.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFtlb.setText("ft-lb");

        txtFtlb.setEditable(false);
        txtFtlb.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout panNmtoFtlbLayout = new javax.swing.GroupLayout(panNmtoFtlb);
        panNmtoFtlb.setLayout(panNmtoFtlbLayout);
        panNmtoFtlbLayout.setHorizontalGroup(
            panNmtoFtlbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panNmtoFtlbLayout.createSequentialGroup()
                .addGroup(panNmtoFtlbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panNmtoFtlbLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(radNmtoFtlb))
                    .addGroup(panNmtoFtlbLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panNmtoFtlbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFtlb)
                            .addComponent(txtFtlb, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNm, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNm))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        panNmtoFtlbLayout.setVerticalGroup(
            panNmtoFtlbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panNmtoFtlbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radNmtoFtlb)
                .addGap(24, 24, 24)
                .addComponent(lblNm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFtlb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFtlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        panLbfttoNm.setBackground(new java.awt.Color(255, 204, 204));
        panLbfttoNm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        grpConvert.add(radLbfttoNm);
        radLbfttoNm.setText("ft-lb to Nm");
        radLbfttoNm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        radLbfttoNm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radLbfttoNmActionPerformed(evt);
            }
        });

        lblFtlb2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblFtlb2.setText("ft-lb");

        txtFtlb2.setEditable(false);
        txtFtlb2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFtlb2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFtlb2KeyReleased(evt);
            }
        });

        lblNm2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNm2.setText("Nm :");

        txNm2.setEditable(false);
        txNm2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout panLbfttoNmLayout = new javax.swing.GroupLayout(panLbfttoNm);
        panLbfttoNm.setLayout(panLbfttoNmLayout);
        panLbfttoNmLayout.setHorizontalGroup(
            panLbfttoNmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLbfttoNmLayout.createSequentialGroup()
                .addGroup(panLbfttoNmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panLbfttoNmLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(radLbfttoNm))
                    .addGroup(panLbfttoNmLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panLbfttoNmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFtlb2)
                            .addComponent(txtFtlb2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txNm2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNm2))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panLbfttoNmLayout.setVerticalGroup(
            panLbfttoNmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLbfttoNmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radLbfttoNm)
                .addGap(26, 26, 26)
                .addComponent(lblFtlb2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFtlb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNm2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txNm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/wrench.png"))); // NOI18N
        lblTitle.setText("Engine Torque Converter");

        lblTip.setBackground(new java.awt.Color(255, 204, 204));
        lblTip.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTip.setForeground(new java.awt.Color(0, 0, 204));
        lblTip.setText("?");
        lblTip.setToolTipText("Newton meter / foot pound");
        lblTip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(panNmtoFtlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panLbfttoNm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(btnConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lblTitle)
                        .addGap(106, 106, 106)
                        .addComponent(lblTip, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(653, Short.MAX_VALUE))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblTip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panLbfttoNm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panNmtoFtlb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed

        // Need to verify which radio was selected
        if(radNmtoFtlb.isSelected()) {

            // We need to parse cc textbox value and pass it to method

            Integer res = Converter.nmToFtlb(Integer.parseInt(txtNm.getText()));
            txtFtlb.setText(res.toString());

        } else {

            // We need to parse inch textbox value and pass it to method

            Integer res = Converter.ftlbToNm(Integer.parseInt(txtFtlb2.getText()));
            txNm2.setText(res.toString());

        }
    }//GEN-LAST:event_btnConvertActionPerformed

    private void radNmtoFtlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNmtoFtlbActionPerformed
        // Enable first panel
        txtNm.setEditable(true);
        txtFtlb2.setEditable(false);
        txtNm.requestFocus();

        txNm2.setText(null);
        txtFtlb2.setText(null);

        btnConvert.setEnabled(true);
    }//GEN-LAST:event_radNmtoFtlbActionPerformed

    private void txtNmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNmKeyReleased
        // Only numbers allowed
        if(! CoolStuff.isNumber(txtNm.getText()))
        txtNm.setText(null);
    }//GEN-LAST:event_txtNmKeyReleased

    private void radLbfttoNmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radLbfttoNmActionPerformed
        // Enable second panel
        txtFtlb2.setEditable(true);
        txtNm.setEditable(false);
        txtFtlb2.requestFocus();

        txtNm.setText(null);
        txtFtlb.setText(null);

        btnConvert.setEnabled(true);
    }//GEN-LAST:event_radLbfttoNmActionPerformed

    private void txtFtlb2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFtlb2KeyReleased
        // Only numbers allowed
        if(! CoolStuff.isNumber(txtFtlb2.getText()))
        txtFtlb2.setText(null);
    }//GEN-LAST:event_txtFtlb2KeyReleased

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
            java.util.logging.Logger.getLogger(FrmConvertEngineTorque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineTorque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineTorque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConvertEngineTorque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmConvertEngineTorque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvert;
    private javax.swing.ButtonGroup grpConvert;
    private javax.swing.JLabel lblFtlb;
    private javax.swing.JLabel lblFtlb2;
    private javax.swing.JLabel lblNm;
    private javax.swing.JLabel lblNm2;
    private javax.swing.JLabel lblTip;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panColor;
    private javax.swing.JPanel panLbfttoNm;
    private javax.swing.JPanel panNmtoFtlb;
    private javax.swing.JRadioButton radLbfttoNm;
    private javax.swing.JRadioButton radNmtoFtlb;
    private javax.swing.JTextField txNm2;
    private javax.swing.JTextField txtFtlb;
    private javax.swing.JTextField txtFtlb2;
    private javax.swing.JTextField txtNm;
    // End of variables declaration//GEN-END:variables
}