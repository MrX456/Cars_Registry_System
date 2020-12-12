/*
 * This JFrame shows some information about this application
 */
package com.CRS.Application;

import com.CRS.Utils.CoolStuff;

/*
 * Car Registry System / Application / About
 * @author MRX
 * Version : 1.0.0
 */

public class FrmAbout extends javax.swing.JFrame {

    //Mouse coordinates
    int xx = 0;
    int yy = 0;
    
    public FrmAbout() {
        initComponents();
        // Custom icon for jar and Jframe
        this.setIconImage(CoolStuff.createIcon().getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPanel = new javax.swing.JPanel();
        lblLic = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblLine3 = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblDev = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblLine2 = new javax.swing.JLabel();
        lblLine1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panPanelMouseDragged(evt);
            }
        });
        panPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panPanelMousePressed(evt);
            }
        });

        lblLic.setText("Under GPL License");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/GNU_Logo.png"))); // NOI18N

        lblLine3.setText("the use of images of each registered vehicle.");

        lblClose.setForeground(new java.awt.Color(255, 0, 51));
        lblClose.setText("Close [x]");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        lblDev.setText("Developed by :  MRX");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("C R S");

        lblLine2.setText("to register vehicles in database. This system also allows ");

        lblLine1.setText("CRS is a car registration system, that allows the user");

        javax.swing.GroupLayout panPanelLayout = new javax.swing.GroupLayout(panPanel);
        panPanel.setLayout(panPanelLayout);
        panPanelLayout.setHorizontalGroup(
            panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPanelLayout.createSequentialGroup()
                .addGroup(panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panPanelLayout.createSequentialGroup()
                        .addGroup(panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panPanelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblLine1)
                                    .addGroup(panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLine2)
                                        .addComponent(lblLine3))))
                            .addGroup(panPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDev)
                                    .addComponent(lblLic))))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblClose)))
                .addContainerGap())
            .addGroup(panPanelLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo)
                .addGap(167, 167, 167))
        );
        panPanelLayout.setVerticalGroup(
            panPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPanelLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblLine1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLine2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLine3)
                .addGap(29, 29, 29)
                .addComponent(lblDev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLic)
                .addGap(22, 22, 22)
                .addComponent(lblLogo)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(388, 274));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPanelMousePressed
       
        xx = evt.getX();
        yy = evt.getY();
        
    }//GEN-LAST:event_panPanelMousePressed

    private void panPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panPanelMouseDragged
        
        // Drag JFrame 
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x -xx, y-yy);
        
    }//GEN-LAST:event_panPanelMouseDragged

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        //Close this JFrame
        this.dispose();
    }//GEN-LAST:event_lblCloseMouseClicked

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
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAbout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAbout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblDev;
    private javax.swing.JLabel lblLic;
    private javax.swing.JLabel lblLine1;
    private javax.swing.JLabel lblLine2;
    private javax.swing.JLabel lblLine3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panPanel;
    // End of variables declaration//GEN-END:variables
}
