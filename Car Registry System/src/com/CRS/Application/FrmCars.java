/*
 * This JFrame is responsible for cars table operations
 */
package com.CRS.Application;

import com.CRS.Controller.CarsBusinessLogic;
import com.CRS.Controller.EngineBusinessLogic;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.CoolStuff;
import com.CRS.Utils.FileTypeFilter;
import com.CRS.Utils.Reports;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/*
 * Car Registry System / Application / Cars
 * @author MRX
 * Version : 1.0.0
 */

public class FrmCars extends javax.swing.JInternalFrame {

    private String imgPath = null;
    
    public FrmCars() {
        initComponents();
    }

    //Validate all required fields
     private boolean validateCarEntry() {
         
        if(txtEmodel.getText().isEmpty()) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Select a engine for this car!"
                                       ,"Engine Model Error", JOptionPane.ERROR_MESSAGE);
            
            txtEngineModel.requestFocus();
           
            return false;
        }
         
        if(txtMaker.getText().isEmpty() || txtMaker.getText().length() > 20) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this maker!"
                                       ,"Maker Error", JOptionPane.ERROR_MESSAGE);
            txtMaker.requestFocus();
           
            return false;
        }
        
        if(txtModel.getText().isEmpty() || txtModel.getText().length() > 50) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this model!"
                                       ,"Model Error", JOptionPane.ERROR_MESSAGE);
            txtModel.requestFocus();
           
            return false;
        }
        
        if(txtCountry.getText().isEmpty() || txtCountry.getText().length() > 25) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this country!"
                                       ,"Country Error", JOptionPane.ERROR_MESSAGE);
            txtCountry.requestFocus();
           
            return false;
        }
        
        if(txtYear.getText().isEmpty() || txtYear.getText().length() > 4) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this year!"
                                       ,"Year Error", JOptionPane.ERROR_MESSAGE);
            txtYear.requestFocus();
           
            return false;
        }
        
        if(txtColor.getText().isEmpty() || txtColor.getText().length() > 15) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot register this color!"
                                       ,"Color Error", JOptionPane.ERROR_MESSAGE);
            txtColor.requestFocus();
           
            return false;
        }
        
        return true;
     }
    
    // Create a JFileChooser for image
    private void chooseImage() {
        
        JFileChooser choose = new JFileChooser("home.user");
        //Only jpg and png files
        choose.setFileFilter(new FileTypeFilter("png", "Image"));
        choose.setFileFilter(new FileTypeFilter("jpg", "Image"));
        
        
        int result = choose.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            
            File selectedFile = choose.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lblImage.setIcon(CoolStuff.resizeSelectedImage(path));
            
            /* 
             * We need the image path to convert the image to FileInputStream
             * must be passed as parameter to registerCar method
             */
            imgPath = path;
        }
    }
    
    //Setting engine fields
    private void setEngineFields() {

        int puts = dgvEngineModels.getSelectedRow();
        
        txtID.setText(dgvEngineModels.getModel().getValueAt(puts, 0).toString());
        txtEmodel.setText(dgvEngineModels.getModel().getValueAt(puts, 1).toString());
        
    }
    
    //Set JTable row on text fields
    private void setFields() {
        
        int puts = dgvCarModels.getSelectedRow();
        
        txtIDCar.setText(dgvCarModels.getModel().getValueAt(puts, 0).toString());
        txtMaker.setText(dgvCarModels.getModel().getValueAt(puts, 1).toString());
        txtModel.setText(dgvCarModels.getModel().getValueAt(puts, 2).toString());
        txtCountry.setText(dgvCarModels.getModel().getValueAt(puts, 3).toString());
        txtYear.setText(dgvCarModels.getModel().getValueAt(puts, 4).toString());
        cboBody.setSelectedItem(dgvCarModels.getModel().getValueAt(puts, 5));
        txtColor.setText(dgvCarModels.getModel().getValueAt(puts, 6).toString());
        txtTopSpeed.setText(dgvCarModels.getModel().getValueAt(puts, 7).toString());
        txtPrice.setText(dgvCarModels.getModel().getValueAt(puts, 8).toString());
        txtEmodel.setText(dgvCarModels.getModel().getValueAt(puts, 9).toString());
        
        /*
         * We have to build the photo
         * This method created a image with blob column content
         * now we get this image and set it as lblImage icon
         */
        CarsBusinessLogic car = new CarsBusinessLogic();
        car.searchPhoto(txtIDCar.getText());
        
        // For security purposes
        txtEngineModel.setEditable(false);
        dgvEngineModels.setEnabled(false);
        btnAdd.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnPrint.setEnabled(true);
        btnSearchImage.setEnabled(false);
        
    }
    
    // Default state
    private void setDefaultState() {
        
        txtID.setText(null);
        txtEmodel.setText(null);
        txtMaker.setText(null);
        txtModel.setText(null);
        txtCountry.setText(null);
        txtYear.setText(null);
        cboBody.setSelectedIndex(0);
        txtColor.setText(null);
        txtTopSpeed.setText(null);
        txtPrice.setText(null);
        
        lblImage.setIcon(new ImageIcon(getClass().getResource("/com/CRS/images/default-image.jpg")));
        
        // We need to set the imgPath null again
        imgPath = null;
        
        txtEngineModel.setEditable(true);
        dgvEngineModels.setEnabled(true);
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnPrint.setEnabled(false);
        btnSearchImage.setEnabled(true);
        
        txtCarModel.setText(null);
        txtIDCar.setText(null);
        ((DefaultTableModel)dgvEngineModels.getModel()).setRowCount(0);
        
        // Search car
        txtEngineModel.setText(null);
        ((DefaultTableModel)dgvCarModels.getModel()).setRowCount(0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panColor = new javax.swing.JPanel();
        lblCars = new javax.swing.JLabel();
        panEngine = new javax.swing.JPanel();
        lblEngineModel = new javax.swing.JLabel();
        txtEngineModel = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        scpPanel = new javax.swing.JScrollPane();
        dgvEngineModels = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblEmodel = new javax.swing.JLabel();
        txtEmodel = new javax.swing.JTextField();
        lblPhoto = new javax.swing.JLabel();
        panImage = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnSearchImage = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        panCarDetails = new javax.swing.JPanel();
        lblMaker = new javax.swing.JLabel();
        txtMaker = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        lblModel = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        lblCountry = new javax.swing.JLabel();
        txtYear = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        lblBody = new javax.swing.JLabel();
        cboBody = new javax.swing.JComboBox();
        lblTopSpeed = new javax.swing.JLabel();
        txtTopSpeed = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        panCarSearch = new javax.swing.JPanel();
        lblCarModel = new javax.swing.JLabel();
        txtCarModel = new javax.swing.JTextField();
        lblSearch1 = new javax.swing.JLabel();
        scpPanel1 = new javax.swing.JScrollPane();
        dgvCarModels = new javax.swing.JTable();
        lblCarID = new javax.swing.JLabel();
        txtIDCar = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CRS - Cars Registration");
        setToolTipText("");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panColor.setBackground(new java.awt.Color(255, 204, 204));
        panColor.setPreferredSize(new java.awt.Dimension(1134, 1000));
        panColor.setRequestFocusEnabled(false);

        lblCars.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/car.png"))); // NOI18N
        lblCars.setText("Cars");

        panEngine.setBackground(new java.awt.Color(255, 204, 204));
        panEngine.setBorder(javax.swing.BorderFactory.createTitledBorder("Engine Model"));

        lblEngineModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEngineModel.setText("Engine Model :");

        txtEngineModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEngineModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEngineModelKeyReleased(evt);
            }
        });

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/search.png"))); // NOI18N

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

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtID.setEnabled(false);

        lblID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblID.setText("ID:");

        lblEmodel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmodel.setText("Model :");

        txtEmodel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmodel.setEnabled(false);

        javax.swing.GroupLayout panEngineLayout = new javax.swing.GroupLayout(panEngine);
        panEngine.setLayout(panEngineLayout);
        panEngineLayout.setHorizontalGroup(
            panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEngineLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEngineLayout.createSequentialGroup()
                        .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEngineModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panEngineLayout.createSequentialGroup()
                                .addComponent(txtEngineModel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSearch))
                            .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(panEngineLayout.createSequentialGroup()
                        .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
        );
        panEngineLayout.setVerticalGroup(
            panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panEngineLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEngineModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEngineModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panEngineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panEngineLayout.createSequentialGroup()
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panEngineLayout.createSequentialGroup()
                        .addComponent(lblEmodel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblPhoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhoto.setText("Photo :");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/default-image.jpg"))); // NOI18N

        javax.swing.GroupLayout panImageLayout = new javax.swing.GroupLayout(panImage);
        panImage.setLayout(panImageLayout);
        panImageLayout.setHorizontalGroup(
            panImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panImageLayout.setVerticalGroup(
            panImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnSearchImage.setText("Search");
        btnSearchImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchImageActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        panCarDetails.setBackground(new java.awt.Color(255, 204, 204));
        panCarDetails.setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));

        lblMaker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMaker.setText("Maker :");

        txtMaker.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblModel.setText("Model :");

        txtCountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCountry.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCountry.setText("Country :");

        txtYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtYearKeyReleased(evt);
            }
        });

        lblYear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblYear.setText("Year :");

        txtColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblColor.setText("Color :");

        lblBody.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblBody.setText("Body Type :");

        cboBody.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboBody.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sport", "muscle", "sedan", "coupe", "suv" }));
        cboBody.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblTopSpeed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTopSpeed.setText("Top Speed :");

        txtTopSpeed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTopSpeed.setToolTipText("mph or kph");
        txtTopSpeed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTopSpeedKeyReleased(evt);
            }
        });

        lblPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrice.setText("Price :");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panCarDetailsLayout = new javax.swing.GroupLayout(panCarDetails);
        panCarDetails.setLayout(panCarDetailsLayout);
        panCarDetailsLayout.setHorizontalGroup(
            panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCarDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panCarDetailsLayout.createSequentialGroup()
                        .addComponent(lblMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblModel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCarDetailsLayout.createSequentialGroup()
                        .addComponent(lblCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCarDetailsLayout.createSequentialGroup()
                        .addComponent(lblBody)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboBody, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(lblColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panCarDetailsLayout.createSequentialGroup()
                        .addComponent(lblTopSpeed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTopSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPrice)
                        .addGap(18, 18, 18)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCarDetailsLayout.setVerticalGroup(
            panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCarDetailsLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaker)
                    .addComponent(txtMaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCountry)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYear)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBody)
                    .addComponent(cboBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panCarDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopSpeed)
                    .addComponent(txtTopSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panCarSearch.setBackground(new java.awt.Color(255, 204, 204));
        panCarSearch.setBorder(javax.swing.BorderFactory.createTitledBorder("Search Car"));

        lblCarModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCarModel.setText("Car Model :");

        txtCarModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCarModel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCarModelKeyReleased(evt);
            }
        });

        lblSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/icons_package/search.png"))); // NOI18N

        dgvCarModels.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_car", "maker", "model", "country", "year_built"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        lblCarID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCarID.setText("Car ID :");

        txtIDCar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIDCar.setEnabled(false);

        javax.swing.GroupLayout panCarSearchLayout = new javax.swing.GroupLayout(panCarSearch);
        panCarSearch.setLayout(panCarSearchLayout);
        panCarSearchLayout.setHorizontalGroup(
            panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCarSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panCarSearchLayout.createSequentialGroup()
                        .addGroup(panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panCarSearchLayout.createSequentialGroup()
                                .addComponent(txtCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSearch1)
                                .addGap(18, 18, 18)
                                .addComponent(txtIDCar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 67, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(panCarSearchLayout.createSequentialGroup()
                        .addComponent(lblCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCarID)
                        .addGap(106, 106, 106))))
        );
        panCarSearchLayout.setVerticalGroup(
            panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCarSearchLayout.createSequentialGroup()
                .addGroup(panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSearch1)
                    .addGroup(panCarSearchLayout.createSequentialGroup()
                        .addGroup(panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCarModel)
                            .addComponent(lblCarID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panCarSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDCar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/reload.png"))); // NOI18N
        btnUpdate.setToolTipText("Update car");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/add.png"))); // NOI18N
        btnAdd.setToolTipText("Add car");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/CRS/images/printer-icon.png"))); // NOI18N
        btnPrint.setToolTipText("Print specs");
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.setEnabled(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panColorLayout = new javax.swing.GroupLayout(panColor);
        panColor.setLayout(panColorLayout);
        panColorLayout.setHorizontalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCars)
                                .addGap(27, 27, 27))
                            .addComponent(panCarDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panEngine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(panCarSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panColorLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panColorLayout.createSequentialGroup()
                                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64)
                                        .addComponent(btnSearchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(203, 203, 203))
        );
        panColorLayout.setVerticalGroup(
            panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panColorLayout.createSequentialGroup()
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(panImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoto)
                            .addComponent(btnSearchImage)))
                    .addGroup(panColorLayout.createSequentialGroup()
                        .addComponent(lblCars)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panEngine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panCarSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCarDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnReset))
                .addContainerGap(390, Short.MAX_VALUE))
        );

        getContentPane().add(panColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setBounds(0, 0, 1000, 700);
    }// </editor-fold>//GEN-END:initComponents

    private void dgvEngineModelsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvEngineModelsMouseClicked
        // Set all fields with JTabel selected row contents
        this.setEngineFields();
    }//GEN-LAST:event_dgvEngineModelsMouseClicked

    private void txtEngineModelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEngineModelKeyReleased
        EngineBusinessLogic engine = new EngineBusinessLogic();
        dgvEngineModels.setModel(DbUtils.resultSetToTableModel
            (engine.searchEnginesModels(txtEngineModel.getText())));
        /*
        * searchEnginesModels method returns a ResultSet and DbUtil
        * insert this ResultSet into a jTable
        */
    }//GEN-LAST:event_txtEngineModelKeyReleased

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // Update car
        if(this.validateCarEntry()) {
            
            CarsBusinessLogic car = new CarsBusinessLogic();
            car.updateCar(txtMaker.getText(), txtModel.getText(), txtCountry.getText(),
                txtYear.getText(), cboBody.getSelectedItem().toString(), txtColor.getText()
                , txtTopSpeed.getText(), txtPrice.getText(), FrmHome.lblUserName.getText()
                                                                         , txtIDCar.getText());
            
            // Clear all fields
            this.setDefaultState();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        // Register car
        if(this.validateCarEntry()) {
            
            CarsBusinessLogic car = new CarsBusinessLogic();
            car.registerCar(txtMaker.getText(), txtModel.getText(), txtCountry.getText(),
                txtYear.getText(), cboBody.getSelectedItem().toString(), txtColor.getText()
                , txtTopSpeed.getText(), txtPrice.getText(), imgPath, FrmHome.lblUserName.getText()
                                                                             , txtID.getText());
            
            // Clear all fields
            this.setDefaultState();
        }
        
        /*
         * OBS: Case the user not choose the image, imgPath String
         * will be passed like null. The business logic module will
         * set on database null value on image column
        */
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchImageActionPerformed
        // Choosing the image
        this.chooseImage();
    }//GEN-LAST:event_btnSearchImageActionPerformed

    // #region Validate only numbers
    
    private void txtYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtYearKeyReleased
         // We need this event to validate if user typed a number
        if(! CoolStuff.isNumber(txtYear.getText()))
            txtYear.setText(null);
    }//GEN-LAST:event_txtYearKeyReleased

    private void txtTopSpeedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTopSpeedKeyReleased
         // We need this event to validate if user typed a number
        if(! CoolStuff.isNumber(txtTopSpeed.getText()))
            txtTopSpeed.setText(null);
    }//GEN-LAST:event_txtTopSpeedKeyReleased

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
         // We need this event to validate if user typed a number
        if(! CoolStuff.isNumber(txtPrice.getText()))
            txtPrice.setText(null);
    }//GEN-LAST:event_txtPriceKeyReleased

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

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // Print car specs
        Reports report = new Reports();
        report.printSpecs(txtIDCar.getText());
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // Clear all fields
        this.setDefaultState();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearchImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboBody;
    private javax.swing.JTable dgvCarModels;
    private javax.swing.JTable dgvEngineModels;
    private javax.swing.JLabel lblBody;
    private javax.swing.JLabel lblCarID;
    private javax.swing.JLabel lblCarModel;
    private javax.swing.JLabel lblCars;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCountry;
    private javax.swing.JLabel lblEmodel;
    private javax.swing.JLabel lblEngineModel;
    private javax.swing.JLabel lblID;
    public static javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblMaker;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblTopSpeed;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel panCarDetails;
    private javax.swing.JPanel panCarSearch;
    private javax.swing.JPanel panColor;
    private javax.swing.JPanel panEngine;
    private javax.swing.JPanel panImage;
    private javax.swing.JScrollPane scpPanel;
    private javax.swing.JScrollPane scpPanel1;
    private javax.swing.JTextField txtCarModel;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmodel;
    private javax.swing.JTextField txtEngineModel;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDCar;
    private javax.swing.JTextField txtMaker;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTopSpeed;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
