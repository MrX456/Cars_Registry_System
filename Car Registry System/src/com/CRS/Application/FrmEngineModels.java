/*
 * This JFrame is responsible for engine models table operations
 */
package com.CRS.Application;

import com.CRS.Controller.EngineBusinessLogic;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.CoolStuff;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * Car Registry System / Application / Engine Model
 * @author MRX
 * Version : 1.0.0
 */

public class FrmEngineModels extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmEngineModels
     */
    public FrmEngineModels() {
        initComponents();
    }

    //Fields validation
    private boolean validateEngineEntry() {
        
        if(txtEmodel.getText().isEmpty() || txtEmodel.getText().length() > 20) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this engine model!"
                                       ,"Engine Model Error", JOptionPane.ERROR_MESSAGE);
            txtEmodel.requestFocus();
           
            return false;
        }
        
        if(txtSize.getText().isEmpty()) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Engine size field cannot be empty!!"
                                       ,"Engine Size Error", JOptionPane.ERROR_MESSAGE);
            txtSize.requestFocus();
           
            return false;
        }
        
         if(txtPower.getText().isEmpty()) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Engine power field cannot be empty!!"
                                       ,"Engine Power Error", JOptionPane.ERROR_MESSAGE);
            txtPower.requestFocus();
           
            return false;
        }
         
        if(txtTorque.getText().isEmpty()) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Engine torque field cannot be empty!!"
                                       ,"Engine Torque Error", JOptionPane.ERROR_MESSAGE);
            txtTorque.requestFocus();
           
            return false;
        }
        
        return true;
    }
    
    //Set JTable row on text fields
    private void setFields() {
        
        int puts = dgvEngineModels.getSelectedRow();
        
        txtID.setText(dgvEngineModels.getModel().getValueAt(puts, 0).toString());
        txtEmodel.setText(dgvEngineModels.getModel().getValueAt(puts, 1).toString());
        txtSize.setText(dgvEngineModels.getModel().getValueAt(puts, 2).toString());
        txtPower.setText(dgvEngineModels.getModel().getValueAt(puts, 3).toString());
        txtTorque.setText(dgvEngineModels.getModel().getValueAt(puts, 4).toString());
        
        //Let´s deactivate add label
        btnAdd.setEnabled(false);
        // Activate update and delete
        btnUpdate.setEnabled(true);
        
    }
    //Default fields state
    private void setDefaultState() {
        
        txtID.setText(null);
        txtEmodel.setText(null);
        txtSize.setText(null);
        txtPower.setText(null);
        txtTorque.setText(null);
        
        txtModel.setText(null);
        ((DefaultTableModel)dgvEngineModels.getModel()).setRowCount(0);
        
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panColor = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        scpPanel = new javax.swing.JScrollPane();
        dgvEngineModels = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        lblEmodel = new javax.swing.JLabel();
        txtEmodel = new javax.swing.JTextField();
        lblSize = new javax.swing.JLabel();
        txtSize = new javax.swing.JTextField();
        lblPower = new javax.swing.JLabel();
        txtPower = new javax.swing.JTextField();
        lblTorque = new javax.swing.JLabel();
        txtTorque = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CRS - Engines Registration");

        panColor.setBackground(new java.awt.Color(255, 204, 204));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/engine.png"))); // NOI18N
        lblTitle.setText("Engines Models");

        lblModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblModel.setText("Engine Model :");

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/search.png"))); // NOI18N

        txtModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModelKeyReleased(evt);
            }
        });

        dgvEngineModels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "model", "size", "power", "torque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvEngineModels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvEngineModelsMouseClicked(evt);
            }
        });
        scpPanel.setViewportView(dgvEngineModels);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setText("ID :");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setEnabled(false);

        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblEmodel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmodel.setText("Model :");

        txtEmodel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSize.setText("Size :");

        txtSize.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSize.setToolTipText("cc or inch");
        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSizeKeyReleased(evt);
            }
        });

        lblPower.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPower.setText("Power :");

        txtPower.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPower.setToolTipText("hp or kw");
        txtPower.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPowerKeyReleased(evt);
            }
        });

        lblTorque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTorque.setText("Torque :");

        txtTorque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTorque.setToolTipText("Nm or ft-lb");
        txtTorque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTorqueKeyReleased(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/add.png"))); // NOI18N
        btnAdd.setToolTipText("Add engine model");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/reload.png"))); // NOI18N
        btnUpdate.setToolTipText("Update engine model");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panColorLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSize, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panColorLayout.createSequentialGroup()
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panColorLayout.createSequentialGroup()
                                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblPower)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addComponent(lblTorque)
                                .addGap(18, 18, 18)
                                .addComponent(txtTorque, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSearch)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(396, 396, 396))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371))))
            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panColorLayout.createSequentialGroup()
                    .addGap(280, 280, 280)
                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(668, Short.MAX_VALUE)))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmodel)
                            .addComponent(txtEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSize)
                            .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPower)))
                    .addComponent(btnReset))
                .addGap(29, 29, 29)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTorque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTorque))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panColorLayout.createSequentialGroup()
                    .addGap(305, 305, 305)
                    .addComponent(lblID)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );

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

        setBounds(0, 0, 1000, 700);
    }// </editor-fold>//GEN-END:initComponents

    //Fill JTable
    private void txtModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModelKeyReleased
        EngineBusinessLogic engine = new EngineBusinessLogic();
        dgvEngineModels.setModel(DbUtils.resultSetToTableModel
            (engine.searchEnginesModels(txtModel.getText())));
        /*
        * searchEnginesModels method returns a ResultSet and DbUtil
        * insert this ResultSet into a jTable
        */
    }//GEN-LAST:event_txtModelKeyReleased

    private void dgvEngineModelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvEngineModelsMouseClicked
        // Set all fields with JTabel selected row contents
        this.setFields();
    }//GEN-LAST:event_dgvEngineModelsMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.setDefaultState();
    }//GEN-LAST:event_btnResetActionPerformed

    // #region Validate numbers
    
    private void txtSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyReleased
        // We need this event to validate if user typed a number
        if(! CoolStuff.isNumber(txtSize.getText()))
            txtSize.setText(null);
    }//GEN-LAST:event_txtSizeKeyReleased

    private void txtPowerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPowerKeyReleased
       if(! CoolStuff.isNumber(txtPower.getText()))
            txtPower.setText(null);
    }//GEN-LAST:event_txtPowerKeyReleased

    private void txtTorqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTorqueKeyReleased
        if(! CoolStuff.isNumber(txtTorque.getText()))
            txtTorque.setText(null);
    }//GEN-LAST:event_txtTorqueKeyReleased

     // #endregion
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Register engine
        if(this.validateEngineEntry()) {
            EngineBusinessLogic engine = new EngineBusinessLogic();
            engine.registerEngineModel(txtEmodel.getText(), txtSize.getText()
                                    , txtPower.getText(), txtTorque.getText());
            
            // Clear all fields
            this.setDefaultState();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Update engine
        if(this.validateEngineEntry()) {
             EngineBusinessLogic engine = new EngineBusinessLogic();
             engine.updateEngineModel(txtEmodel.getText(), txtSize.getText(), 
                       txtPower.getText(), txtTorque.getText(),txtID.getText());
              
            // Clear all fields
            this.setDefaultState();

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable dgvEngineModels;
    private javax.swing.JLabel lblEmodel;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblPower;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSize;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTorque;
    private javax.swing.JPanel panColor;
    private javax.swing.JScrollPane scpPanel;
    private javax.swing.JTextField txtEmodel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtPower;
    private javax.swing.JTextField txtSize;
    private javax.swing.JTextField txtTorque;
    // End of variables declaration//GEN-END:variables
}
