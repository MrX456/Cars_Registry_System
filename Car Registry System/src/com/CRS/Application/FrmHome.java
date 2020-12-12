/*
 * This JFrame is a principal JFrame of this application.
 * It will be parent of all database Jframes
 */
package com.CRS.Application;

import com.CRS.Utils.CoolStuff;
import com.CRS.Utils.Reports;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Car Registry System / Application / Home Screen
 * @author MRX
 * Version : 1.0.0
 */

public class FrmHome extends javax.swing.JFrame {

    
    public FrmHome() {
        initComponents();
        // Custom icon for jar and Jframe
        this.setIconImage(CoolStuff.createIcon().getImage());
        //Full screen
        this.setExtendedState(MAXIMIZED_BOTH);
        hideOptions();
    }

    //Let´s hide some options from menu(only administrators can see)
    private void hideOptions() {
        //All them turned public and static
        mitUsers.setVisible(false);
        menReports.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panColor = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        lblDate = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        menMenu = new javax.swing.JMenuBar();
        menReg = new javax.swing.JMenu();
        sepReg = new javax.swing.JPopupMenu.Separator();
        menEngine = new javax.swing.JMenu();
        mitAddEngine = new javax.swing.JMenuItem();
        mitDelEngine = new javax.swing.JMenuItem();
        menCars = new javax.swing.JMenu();
        mitAddCar = new javax.swing.JMenuItem();
        mitDelCar = new javax.swing.JMenuItem();
        mitUsers = new javax.swing.JMenuItem();
        menReports = new javax.swing.JMenu();
        sepReports = new javax.swing.JPopupMenu.Separator();
        mitReportEngineModels = new javax.swing.JMenuItem();
        mitReportCars = new javax.swing.JMenuItem();
        mitReportUsers = new javax.swing.JMenuItem();
        menUtils = new javax.swing.JMenu();
        sepUtils = new javax.swing.JPopupMenu.Separator();
        menConverters = new javax.swing.JMenu();
        mitSize = new javax.swing.JMenuItem();
        mitPower = new javax.swing.JMenuItem();
        mitTorque = new javax.swing.JMenuItem();
        mitSpeed = new javax.swing.JMenuItem();
        menHelp = new javax.swing.JMenu();
        sepHelp = new javax.swing.JPopupMenu.Separator();
        mitAbout = new javax.swing.JMenuItem();
        mitDocumentation = new javax.swing.JMenuItem();
        mitHotKey = new javax.swing.JMenuItem();
        menOptions = new javax.swing.JMenu();
        sepOptions = new javax.swing.JPopupMenu.Separator();
        mitExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Registry System  -  Version 1.0.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        panColor.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblDate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblDate.setText("Date");

        lblUserName.setText("User Name");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/logo.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Footlight MT Light", 1, 36)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 0, 153));
        lblName.setText("C R S");

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lblUserName))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogo)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName)
                .addGap(22, 22, 22)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDate)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        menMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/database.png"))); // NOI18N
        menReg.setText("Registration");
        menReg.add(sepReg);

        menEngine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/engine.png"))); // NOI18N
        menEngine.setText("Engine Models");
        menEngine.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mitAddEngine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        mitAddEngine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/database_add.png"))); // NOI18N
        mitAddEngine.setText("Add / Update");
        mitAddEngine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAddEngine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAddEngineActionPerformed(evt);
            }
        });
        menEngine.add(mitAddEngine);

        mitDelEngine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        mitDelEngine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/database_delete.png"))); // NOI18N
        mitDelEngine.setText("Delete");
        mitDelEngine.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitDelEngine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitDelEngineActionPerformed(evt);
            }
        });
        menEngine.add(mitDelEngine);

        menReg.add(menEngine);

        menCars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/car.png"))); // NOI18N
        menCars.setText("Cars");

        mitAddCar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mitAddCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/database_add.png"))); // NOI18N
        mitAddCar.setText("Add / Update");
        mitAddCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAddCarActionPerformed(evt);
            }
        });
        menCars.add(mitAddCar);

        mitDelCar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        mitDelCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/database_delete.png"))); // NOI18N
        mitDelCar.setText("Delete");
        mitDelCar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitDelCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitDelCarActionPerformed(evt);
            }
        });
        menCars.add(mitDelCar);

        menReg.add(menCars);

        mitUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        mitUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/group_key.png"))); // NOI18N
        mitUsers.setText("Users");
        mitUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitUsersActionPerformed(evt);
            }
        });
        menReg.add(mitUsers);

        menMenu.add(menReg);

        menReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/report_add.png"))); // NOI18N
        menReports.setText("Reports");
        menReports.add(sepReports);

        mitReportEngineModels.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        mitReportEngineModels.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/engine.png"))); // NOI18N
        mitReportEngineModels.setText("Engine Models");
        mitReportEngineModels.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitReportEngineModels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitReportEngineModelsActionPerformed(evt);
            }
        });
        menReports.add(mitReportEngineModels);

        mitReportCars.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK));
        mitReportCars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/car.png"))); // NOI18N
        mitReportCars.setText("Cars");
        mitReportCars.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitReportCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitReportCarsActionPerformed(evt);
            }
        });
        menReports.add(mitReportCars);

        mitReportUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        mitReportUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/group_key.png"))); // NOI18N
        mitReportUsers.setText("Users");
        mitReportUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitReportUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitReportUsersActionPerformed(evt);
            }
        });
        menReports.add(mitReportUsers);

        menMenu.add(menReports);

        menUtils.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/briefcase.png"))); // NOI18N
        menUtils.setText("Utils");
        menUtils.add(sepUtils);

        menConverters.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/bullet_go.png"))); // NOI18N
        menConverters.setText("Converters");

        mitSize.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK));
        mitSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/piston.png"))); // NOI18N
        mitSize.setText("Size");
        mitSize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSizeActionPerformed(evt);
            }
        });
        menConverters.add(mitSize);

        mitPower.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        mitPower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/turbo.png"))); // NOI18N
        mitPower.setText("Power");
        mitPower.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPowerActionPerformed(evt);
            }
        });
        menConverters.add(mitPower);

        mitTorque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        mitTorque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/wrench.png"))); // NOI18N
        mitTorque.setText("Torque");
        mitTorque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitTorque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTorqueActionPerformed(evt);
            }
        });
        menConverters.add(mitTorque);

        mitSpeed.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK));
        mitSpeed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/speedometer.png"))); // NOI18N
        mitSpeed.setText("Speed");
        mitSpeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitSpeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSpeedActionPerformed(evt);
            }
        });
        menConverters.add(mitSpeed);

        menUtils.add(menConverters);

        menMenu.add(menUtils);

        menHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/help.png"))); // NOI18N
        menHelp.setText("Help");
        menHelp.add(sepHelp);

        mitAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mitAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/information.png"))); // NOI18N
        mitAbout.setText("About");
        mitAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAboutActionPerformed(evt);
            }
        });
        menHelp.add(mitAbout);

        mitDocumentation.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mitDocumentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/book.png"))); // NOI18N
        mitDocumentation.setText("Documentation");
        mitDocumentation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitDocumentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitDocumentationActionPerformed(evt);
            }
        });
        menHelp.add(mitDocumentation);

        mitHotKey.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        mitHotKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/keyboard.png"))); // NOI18N
        mitHotKey.setText("Hotkeys");
        mitHotKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitHotKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitHotKeyActionPerformed(evt);
            }
        });
        menHelp.add(mitHotKey);

        menMenu.add(menHelp);

        menOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/cursor.png"))); // NOI18N
        menOptions.setText("Options");
        menOptions.add(sepOptions);

        mitExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mitExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/door_out.png"))); // NOI18N
        mitExit.setText("Exit");
        mitExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mitExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitExitActionPerformed(evt);
            }
        });
        menOptions.add(mitExit);

        menMenu.add(menOptions);

        setJMenuBar(menMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1286, 758));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Showing date and time
        new Timer(0, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                 lblDate.setText(CoolStuff.getTimeNow());
                 
            }
        }).start();
        
    }//GEN-LAST:event_formWindowActivated

    // #region Main Menu
    
    private void mitExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitExitActionPerformed
        //Close application
        int exit = JOptionPane.showConfirmDialog(null, "Would you like to exit?",
                "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(exit == 0)
            System.exit(0);
        
    }//GEN-LAST:event_mitExitActionPerformed

    private void mitAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAboutActionPerformed
        // Open About JFrame
        FrmAbout about = new FrmAbout();
        about.setVisible(true);
    }//GEN-LAST:event_mitAboutActionPerformed

    private void mitDocumentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitDocumentationActionPerformed
        // Open pdf documentation file
        CoolStuff.openDocumentation();
    }//GEN-LAST:event_mitDocumentationActionPerformed

    private void mitHotKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitHotKeyActionPerformed
        // Open Hotkeys JFrame
        FrmHotkeys hk = new FrmHotkeys();
        hk.setVisible(true);
    }//GEN-LAST:event_mitHotKeyActionPerformed

    private void mitSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSizeActionPerformed
        // Open convert engine size jframe
        FrmConvertEngineSize size = new FrmConvertEngineSize();
        size.setVisible(true);
    }//GEN-LAST:event_mitSizeActionPerformed

    private void mitPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPowerActionPerformed
        // Open convert engine power jframe
        FrmConvertEnginePower power = new FrmConvertEnginePower();
        power.setVisible(true);
    }//GEN-LAST:event_mitPowerActionPerformed

    private void mitTorqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTorqueActionPerformed
        // Open convert engine torque jframe
        FrmConvertEngineTorque torque = new FrmConvertEngineTorque();
        torque.setVisible(true);
    }//GEN-LAST:event_mitTorqueActionPerformed

    private void mitSpeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSpeedActionPerformed
        // Open convert engine torque jframe
        FrmConvertSpeed speed = new FrmConvertSpeed();
        speed.setVisible(true);
    }//GEN-LAST:event_mitSpeedActionPerformed

   
    
    private void mitUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitUsersActionPerformed
        // Open internal JFrame users
        FrmUsers users = new FrmUsers();
        users.setVisible(true);
        Desktop.add(users);
        // Open maximized JInternalFrame
        Desktop.getDesktopManager().maximizeFrame(users); 
    }//GEN-LAST:event_mitUsersActionPerformed

    
    
    private void mitAddEngineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAddEngineActionPerformed
        // Open internal JFrame Engine Models
        FrmEngineModels engine = new FrmEngineModels();
        engine.setVisible(true);
        Desktop.add(engine);
        Desktop.getDesktopManager().maximizeFrame(engine);
    }//GEN-LAST:event_mitAddEngineActionPerformed

    private void mitDelEngineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitDelEngineActionPerformed
        // Open internal JFrame Delete Engine Models
        FrmDelEngineModel delEngine = new FrmDelEngineModel();
        delEngine.setVisible(true);
        Desktop.add(delEngine);
        Desktop.getDesktopManager().maximizeFrame(delEngine);
    }//GEN-LAST:event_mitDelEngineActionPerformed

    private void mitAddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAddCarActionPerformed
        // Open internal JFrame Cars
        FrmCars car = new FrmCars();
        car.setVisible(true);
        Desktop.add(car);
        Desktop.getDesktopManager().maximizeFrame(car);
    }//GEN-LAST:event_mitAddCarActionPerformed

    private void mitDelCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitDelCarActionPerformed
        // Open internal JFrame Cars
        FrmDelCar delCar = new FrmDelCar();
        delCar.setVisible(true);
        Desktop.add(delCar);
        Desktop.getDesktopManager().maximizeFrame(delCar); 
    }//GEN-LAST:event_mitDelCarActionPerformed

    // #region Reports
    
    private void mitReportEngineModelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitReportEngineModelsActionPerformed
        // Generate engine report
        Reports report = new Reports();
        report.engineModelsReport();
    }//GEN-LAST:event_mitReportEngineModelsActionPerformed

    private void mitReportCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitReportCarsActionPerformed
        // Generate cars report
        Reports report = new Reports();
        report.carsReport();
    }//GEN-LAST:event_mitReportCarsActionPerformed

    private void mitReportUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitReportUsersActionPerformed
        // Generate users report
        Reports report = new Reports();
        report.usersReport();
    }//GEN-LAST:event_mitReportUsersActionPerformed

    // #endregion
    
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
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblName;
    public static javax.swing.JLabel lblUserName;
    private javax.swing.JMenu menCars;
    private javax.swing.JMenu menConverters;
    private javax.swing.JMenu menEngine;
    private javax.swing.JMenu menHelp;
    private javax.swing.JMenuBar menMenu;
    private javax.swing.JMenu menOptions;
    private javax.swing.JMenu menReg;
    public static javax.swing.JMenu menReports;
    private javax.swing.JMenu menUtils;
    private javax.swing.JMenuItem mitAbout;
    private javax.swing.JMenuItem mitAddCar;
    private javax.swing.JMenuItem mitAddEngine;
    private javax.swing.JMenuItem mitDelCar;
    private javax.swing.JMenuItem mitDelEngine;
    private javax.swing.JMenuItem mitDocumentation;
    private javax.swing.JMenuItem mitExit;
    private javax.swing.JMenuItem mitHotKey;
    private javax.swing.JMenuItem mitPower;
    private javax.swing.JMenuItem mitReportCars;
    private javax.swing.JMenuItem mitReportEngineModels;
    private javax.swing.JMenuItem mitReportUsers;
    private javax.swing.JMenuItem mitSize;
    private javax.swing.JMenuItem mitSpeed;
    private javax.swing.JMenuItem mitTorque;
    public static javax.swing.JMenuItem mitUsers;
    private javax.swing.JPanel panColor;
    private javax.swing.JPopupMenu.Separator sepHelp;
    private javax.swing.JPopupMenu.Separator sepOptions;
    private javax.swing.JPopupMenu.Separator sepReg;
    private javax.swing.JPopupMenu.Separator sepReports;
    private javax.swing.JPopupMenu.Separator sepUtils;
    // End of variables declaration//GEN-END:variables
}
