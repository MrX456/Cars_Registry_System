/*
 * This JFrame is responsible for cars exclusions
 */
package com.CRS.Application;

import com.CRS.Controller.CarsBusinessLogic;
import com.CRS.Utils.AudioWarning;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * Car Registry System / Application / Cars
 * @author MRX
 * Version : 1.0.0
 */

public class FrmDelCar extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmDelCar
     */
    public FrmDelCar() {
        initComponents();
    }

    //We need to validate the motive of exclusion
    private boolean validateMotive() { 
        
        if(atxtMotive.getText().isEmpty()) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Inform the motive of this exclusion!"
                                       ,"Delete Error", JOptionPane.ERROR_MESSAGE);
            atxtMotive.requestFocus();
           
            return false;
        }
        return true;
    }
    
    private void setFields() {
        
        int puts = dgvCarModels.getSelectedRow();
        
        txtIDCar.setText(dgvCarModels.getModel().getValueAt(puts, 0).toString());
        txtMaker.setText(dgvCarModels.getModel().getValueAt(puts, 1).toString());
        txtModel.setText(dgvCarModels.getModel().getValueAt(puts, 2).toString());
        txtColor.setText(dgvCarModels.getModel().getValueAt(puts, 6).toString());
        
        //Let´s activate delete button
        btnDelete.setEnabled(true);
        
    }
    
    private void setDefaultState() {
        
        txtCarModel.setText(null);
        txtIDCar.setText(null);
        txtMaker.setText(null);
        txtModel.setText(null);
        txtColor.setText(null);
        atxtMotive.setText(null);
        btnDelete.setEnabled(false);
        
        txtModel.setText(null);
        ((DefaultTableModel)dgvCarModels.getModel()).setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panColor = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblCarModel = new javax.swing.JLabel();
        txtCarModel = new javax.swing.JTextField();
        scpPanel1 = new javax.swing.JScrollPane();
        dgvCarModels = new javax.swing.JTable();
        lblSearch1 = new javax.swing.JLabel();
        lblCarID = new javax.swing.JLabel();
        txtIDCar = new javax.swing.JTextField();
        lblMaker = new javax.swing.JLabel();
        txtMaker = new javax.swing.JTextField();
        lblModel = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblMotive = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxtMotive = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        panColor.setBackground(new java.awt.Color(255, 204, 204));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 0, 51));
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/car.png"))); // NOI18N
        lblTitle.setText("Delete* Car");

        lblCarModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCarModel.setText("Car Model :");

        txtCarModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCarModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCarModelKeyReleased(evt);
            }
        });

        dgvCarModels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id_car", "maker", "model", "country", "year_built", "body_type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvCarModels.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvCarModelsMouseClicked(evt);
            }
        });
        scpPanel1.setViewportView(dgvCarModels);

        lblSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/search.png"))); // NOI18N

        lblCarID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCarID.setText("Car ID :");

        txtIDCar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIDCar.setEnabled(false);

        lblMaker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaker.setText("Maker :");

        txtMaker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaker.setEnabled(false);

        lblModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblModel.setText("Model :");

        txtModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtModel.setEnabled(false);

        lblColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblColor.setText("Color :");

        txtColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtColor.setEnabled(false);

        lblMotive.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMotive.setText("Motive * :");

        atxtMotive.setColumns(20);
        atxtMotive.setRows(5);
        jScrollPane1.setViewportView(atxtMotive);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/x-button.png"))); // NOI18N
        btnDelete.setToolTipText("Delete car");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                .addGap(0, 108, Short.MAX_VALUE)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addComponent(txtCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSearch1)))
                        .addGap(331, 331, 331)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtIDCar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCarID))))
                .addGap(97, 97, 97))
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panColorLayout.createSequentialGroup()
                            .addGap(396, 396, 396)
                            .addComponent(lblTitle))
                        .addGroup(panColorLayout.createSequentialGroup()
                            .addGap(261, 261, 261)
                            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panColorLayout.createSequentialGroup()
                                    .addComponent(lblModel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtModel))
                                .addGroup(panColorLayout.createSequentialGroup()
                                    .addComponent(lblMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                            .addGap(270, 270, 270)
                            .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                                    .addComponent(lblColor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMotive, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle)
                        .addGap(48, 48, 48)
                        .addComponent(lblCarModel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSearch1))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(txtCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panColorLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCarID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIDCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(scpPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaker)
                    .addComponent(txtMaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMotive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
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

    private void txtCarModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCarModelKeyReleased
        //Not resize jtable columns automatically
        dgvCarModels.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        CarsBusinessLogic car = new CarsBusinessLogic();
        dgvCarModels.setModel(DbUtils.resultSetToTableModel
            (car.searchCars(txtCarModel.getText())));

        /*
        * searchEnginesModels method returns a ResultSet and DbUtil
        * insert this ResultSet into a jTable
        */
    }//GEN-LAST:event_txtCarModelKeyReleased

    private void dgvCarModelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvCarModelsMouseClicked
        // Set the content on textboxes
        this.setFields();

    }//GEN-LAST:event_dgvCarModelsMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Delete engine
        if(this.validateMotive()) {

            CarsBusinessLogic car = new CarsBusinessLogic();
            car.deleteCar(txtIDCar.getText(), txtModel.getText(), txtColor.getText(),
                                FrmHome.lblUserName.getText(), atxtMotive.getText());
            this.setDefaultState();

        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxtMotive;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTable dgvCarModels;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCarID;
    private javax.swing.JLabel lblCarModel;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblMaker;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblMotive;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panColor;
    private javax.swing.JScrollPane scpPanel1;
    private javax.swing.JTextField txtCarModel;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIDCar;
    private javax.swing.JTextField txtMaker;
    private javax.swing.JTextField txtModel;
    // End of variables declaration//GEN-END:variables
}
