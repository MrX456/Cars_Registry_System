/*
 * This JFrame is a splash screen used to test database connection
 * before open the application
 */
package com.CRS.Application;

import com.CRS.DAL.DAL;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.CoolStuff;
import com.CRS.Utils.Logs;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.sql.Connection;
import javax.swing.JOptionPane;


/*
 * Car Registry System / Application / Splash Screen
 * @author MRX
 * Version : 1.0.0
 */

public class FrmSplashScreen extends javax.swing.JFrame {

    //We need Connection object
    Connection conn = null;
      
    public FrmSplashScreen() {
        
        initComponents();
        // Custom icon for jar and Jframe
        this.setIconImage(CoolStuff.createIcon().getImage());
        hideCursor();
        fillBar();
    }

    //Fill progress bar method
    private void fillBar() {
        
        new Thread(){
            @Override
            public void run() {
                //Bar load until 100
                for(int i = 0; i < 101; i++) {
                    try {
                        
                        sleep(60);
                        pbLoading.setValue(i);
                        
                        //Try to connect to database
                        if(i == 30) {
                            lblStatus.setText("trying to connect to database...");
                            conn = DAL.requestConnection();
                            
                            //Connection failed
                            if(conn == null) {
                                FrmSplashScreen.this.dispose();
                                
                                //Lets play warning sound with our method
                                AudioWarning aw = new AudioWarning();
                                aw.errorWarning();
                                
                                JOptionPane.showMessageDialog(null, "Cannot connect to database!", 
                                      "Connection error", JOptionPane.ERROR_MESSAGE);
                                //We must close the application
                                System.exit(0);
                            }
                        }
                        else if(i == 80) {
                            lblStatus.setText("loading data...");
                        }
                        
                    } catch (Exception e) {
                        
                        Logs.generateExceptionLog(e.toString());
                    }
                    
                }
                //Open login jframe
                FrmSplashScreen.this.dispose();
                FrmLogin login = new FrmLogin();
                login.setVisible(true);
            }
        }.start();
    }
    
    //This method hide the cursor in this screen
    private void hideCursor() {
        
        //Let's create transparent image and set it as cursor
        int[] pixels = new int[16*16];
        Image img = Toolkit.getDefaultToolkit().createImage(
        new MemoryImageSource(16, 16, pixels, 0, 16));
        Cursor transparentCursor = 
        Toolkit.getDefaultToolkit().createCustomCursor
                                (img,new Point(0, 0), "invisible cursor");
        this.setCursor(transparentCursor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbLoading = new javax.swing.JProgressBar();
        lblStatus = new javax.swing.JLabel();
        lblWallPaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);
        getContentPane().setLayout(null);
        getContentPane().add(pbLoading);
        pbLoading.setBounds(80, 240, 280, 20);

        lblStatus.setForeground(new java.awt.Color(255, 153, 153));
        lblStatus.setText("...");
        getContentPane().add(lblStatus);
        lblStatus.setBounds(140, 260, 210, 16);

        lblWallPaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/splash_wallpaper.jpg"))); // NOI18N
        getContentPane().add(lblWallPaper);
        lblWallPaper.setBounds(0, 0, 450, 280);

        setSize(new java.awt.Dimension(439, 279));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblWallPaper;
    private javax.swing.JProgressBar pbLoading;
    // End of variables declaration//GEN-END:variables
}
