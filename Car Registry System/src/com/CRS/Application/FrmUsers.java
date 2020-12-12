/*
 * This JFrame is responsible for users table operations
 */
package com.CRS.Application;

import com.CRS.Controller.UserBusinessLogic;
import com.CRS.Utils.AudioWarning;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * Car Registry System / Application / Users
 * @author MRX
 * Version : 1.0.0
 */

public class FrmUsers extends javax.swing.JInternalFrame {

    
    public FrmUsers() {
        initComponents();
       
    }

    /*
     * We must to validate every textbox because database will not accept
     * empty values. We must validate the max characters number
     */
    private boolean validateUserEntry() {
       
        if(txtName.getText().isEmpty() || txtName.getText().length() > 80) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this user name!"
                                       ,"Name Error", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
           
            return false;
        }
        
        if(txtLogin.getText().isEmpty() || txtLogin.getText().length() > 40) {
            
             //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this user login!"
                                       ,"Login Error", JOptionPane.ERROR_MESSAGE);
            txtLogin.requestFocus();
           
            return false;
        }
        
        if(txtPassword.getText().isEmpty() || txtPassword.getText().length() > 15) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Password maximum length 15 characters!"
                                       ,"Password Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.requestFocus();
           
            return false;
        }
      
        return true;
        //Comboboxes has already selected index
    }
    
    /*
     * This method get a row in JTable and sets 
     * his values into respective fields
     */
    private void setFields() {
    
        int puts = dgvUsers.getSelectedRow();
        
        txtID.setText(dgvUsers.getModel().getValueAt(puts, 0).toString());
        txtName.setText(dgvUsers.getModel().getValueAt(puts, 1).toString());
        txtLogin.setText(dgvUsers.getModel().getValueAt(puts, 3).toString());
        txtPassword.setText(dgvUsers.getModel().getValueAt(puts, 4).toString());
        
        //Now the comboboxes
        cboSex.setSelectedItem(dgvUsers.getModel().getValueAt(puts, 2));
        cboProfile.setSelectedItem(dgvUsers.getModel().getValueAt(puts, 5));
        
        //Let´s deactivate add label
        btnAdd.setEnabled(false);
        // Activate update and delete
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        
        //If name equals administrator let's deactivate edition of this field
        if(txtName.getText().equals("Administrator"))
            txtName.setEditable(false);
        
    }
    
    //This method clar all fields
    private void setDefaultState() {
        
        txtID.setText(null);
        txtName.setText(null);
        txtLogin.setText(null);
        txtPassword.setText(null);
        //Comboboxes
        cboSex.setSelectedIndex(0);
        cboProfile.setSelectedIndex(0);
        
        txtName.setEditable(true);
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        
        txtUser.setText(null);
        // Clear JTable
        ((DefaultTableModel)dgvUsers.getModel()).setRowCount(0);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panColor = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        scpPanel = new javax.swing.JScrollPane();
        dgvUsers = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        cboSex = new javax.swing.JComboBox();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblProfile = new javax.swing.JLabel();
        cboProfile = new javax.swing.JComboBox();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CRS - Users");

        panColor.setBackground(new java.awt.Color(255, 204, 204));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Users");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserName.setText("Name :");

        dgvUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "name", "sex", "login", "password", "profile"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvUsersMouseClicked(evt);
            }
        });
        scpPanel.setViewportView(dgvUsers);

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/search.png"))); // NOI18N

        lblName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName.setText("Name :");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblSex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSex.setText("Sex:");

        cboSex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboSex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "male", "female" }));
        cboSex.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLogin.setText("Login :");

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblProfile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProfile.setText("Profile: ");

        cboProfile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboProfile.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "administrator", "user" }));
        cboProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setText("ID :");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtID.setEnabled(false);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/add.png"))); // NOI18N
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/reload.png"))); // NOI18N
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/x-button.png"))); // NOI18N
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(403, 403, 403))
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panColorLayout.createSequentialGroup()
                                .addGap(198, 198, 198)
                                .addComponent(lblTitle)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSearch))
                    .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panColorLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSex)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panColorLayout.createSequentialGroup()
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtName))
                        .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panColorLayout.createSequentialGroup()
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panColorLayout.createSequentialGroup()
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40)
                                    .addComponent(lblProfile))
                                .addGroup(panColorLayout.createSequentialGroup()
                                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(61, 61, 61)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panColorLayout.createSequentialGroup()
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(cboProfile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSex)
                    .addComponent(cboSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProfile)
                    .addComponent(cboProfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1000, 700));
    }// </editor-fold>//GEN-END:initComponents

    //Every key pressed search user like
    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
        UserBusinessLogic user = new UserBusinessLogic();
        dgvUsers.setModel(DbUtils.resultSetToTableModel
                                         (user.searchUsers(txtUser.getText())));
        /*
         * searchUsers method returns a ResultSet and DbUtil
         * insert this ResultSet into a jTable
        */
    }//GEN-LAST:event_txtUserKeyReleased

    private void dgvUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvUsersMouseClicked
        // Set all fields with JTabel selected row contents
        this.setFields();
    }//GEN-LAST:event_dgvUsersMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // Register user
        if(this.validateUserEntry()) {
            UserBusinessLogic user = new UserBusinessLogic();
            user.registerUser(txtName.getText(), cboSex.getSelectedItem().toString()
                                        , txtLogin.getText(), txtPassword.getText(),
                                           cboProfile.getSelectedItem().toString());
            // Clear all fields
            this.setDefaultState();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Update user
        if(this.validateUserEntry()) {
            UserBusinessLogic user = new UserBusinessLogic();
            user.updateUser(txtName.getText(), cboSex.getSelectedItem().toString()
                                        , txtLogin.getText(), txtPassword.getText(),
                                           cboProfile.getSelectedItem().toString(),
                                                                  txtID.getText());
            // Clear all fields
            this.setDefaultState();
            
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Delete user
        UserBusinessLogic user = new UserBusinessLogic();
        user.deleteUser(txtID.getText());
        this.setDefaultState();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.setDefaultState();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboProfile;
    private javax.swing.JComboBox cboSex;
    private javax.swing.JTable dgvUsers;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel panColor;
    private javax.swing.JScrollPane scpPanel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
