/*
 * This module will be responsable for user table business logic
 */
package com.CRS.Controller;

import com.CRS.Application.FrmHome;
import com.CRS.Application.FrmLogin;
import com.CRS.DAL.DAL;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.Logs;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Car Registry System / Controller / Users Business Logic
 * @author MRX
 * Version : 1.0.0
 */

public class UserBusinessLogic implements CrudUser {
    
     Connection conn = null;
     PreparedStatement pst = null;
     ResultSet rs = null;

    @Override
    public void login(String login, String password) {
        
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getSearchThisCredential());
            pst.setString(1, login);
            pst.setString(2, password);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                
                //Init new JFrame
                FrmHome home = new FrmHome();
                home.setVisible(true);
                
                /*
                 * The user profile must be checked
                 * only administrators can acess all system functions
                 */
                if(rs.getString(6).equals("administrator")) {
                    
                    //Let's activate all hidden options
                    FrmHome.mitUsers.setVisible(true);
                    FrmHome.menReports.setVisible(true);
                    
                    //Lets change user icon and label text
                    FrmHome.lblUserName.setIcon(new ImageIcon(getClass()
                            .getResource("/com/CRS/icons_package/user_suit.png")));
                    FrmHome.lblUserName.setText(rs.getString(2));
                    FrmHome.lblUserName.setForeground(Color.red);
                    
                                      
                }
                //Simple user 
                else if(rs.getString(3).equals("male")) {
                    
                    //Let's change user icon
                    FrmHome.lblUserName.setIcon(new ImageIcon(getClass()
                            .getResource("/com/CRS/icons_package/user.png")));
                    FrmHome.lblUserName.setText(rs.getString(2));
                } else {
                    
                     //Let's change user icon
                    FrmHome.lblUserName.setIcon(new ImageIcon(getClass()
                            .getResource("/com/CRS/icons_package/user_female.png")));
                    FrmHome.lblUserName.setText(rs.getString(2));
                    
                }
                
                conn.close();
                
            //User not found
            } else {
                
                conn.close();
                // The login JFrame will be disposed anyway we need a new
                FrmLogin reload = new FrmLogin();
                reload.setVisible(true);
                
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.loginFailedWarning();
                
                // Control turned into public and static
                FrmLogin.lblLoginError.setText("*Invalid login / password");
            }
            
           
            
        } catch (Exception e) {
            //Lets generate a log with our method
            Logs.generateExceptionLog(e.toString());
        }
    }

    @Override
    public void registerUser(String name, String sex, String login, String password, String profile) {
        
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getRegisterThisUser());
            pst.setString(1, name);
            pst.setString(2, sex);
            pst.setString(3, login);
            pst.setString(4, password);
            pst.setString(5, profile);
            
            // Need to verify update
            int add = pst.executeUpdate();
            
            if(add > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully added user!"
                   ,"Registration confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                conn.close();
            }
            
        } catch (Exception e) {
            
            //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible add user!"
                   ,"Registration error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public ResultSet searchUsers(String nameLike) {
        
        //This method will return a database ResultSet
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getSearchTheseUsers());
            /*
             * Sql instruction uses like, we must to concatenate our text
             * with % character
             */
            pst.setString(1, nameLike + "%");
            
            rs = pst.executeQuery();
            
            return rs;
           
            
        } catch (Exception e) {
            
            //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible find user!"
                   ,"Search error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            //Null ResultSet
            return rs;
            
        }
    }

    @Override
    public void updateUser(String name, String sex, String login, String password, String profile, String id) {
        
        try {
            
            //Updating a user
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getUpdateThisUser());
            pst.setString(1, name);
            pst.setString(2, sex);
            pst.setString(3, login);
            pst.setString(4, password);
            pst.setString(5, profile);
            pst.setString(6, id);
            
            // Administrator default user cannot be edited
            if(name.equals("Administrator")) {
                
                //Lets play warning sound with our method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                                
                JOptionPane.showMessageDialog(null, "Cannot update Administrator default user!", 
                                      "Update failed", JOptionPane.ERROR_MESSAGE);
                
                conn.close();
            } else {
                
                int add = pst.executeUpdate();
                
                if(add > 0) {
                    
                    JOptionPane.showMessageDialog(null, "Successfully updated user!"
                              ,"Update confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                   conn.close();
                    
                }
            }
            
            
        } catch (Exception e) {
            
             //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible update user!"
                   ,"Update error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public void deleteUser(String id) {
        
        
           // Administrator default user cannot be deleted
        if (id.equals("1")) {

            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();

            JOptionPane.showMessageDialog(null, "Cannot delete Administrator default user!",
                    "Delete failed", JOptionPane.ERROR_MESSAGE);

        } else {

            //Confirm exclusion
            int confirm = JOptionPane.showConfirmDialog(null, "Would you like to delete this user?",
                    "Delete user", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == 0) {
                
                try {
                    
                    conn = DAL.requestConnection();
                    
                    pst = conn.prepareStatement(SqlCommand.getDeleteThisUser());
                    pst.setString(1, id);
                    
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Successfully deleted user!"
                              ,"Delete confirmed", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (Exception e) {
                    
                    //Let´s play a warning sound with your method
                    AudioWarning aw = new AudioWarning();
                    aw.errorWarning();
                    JOptionPane.showMessageDialog(null, "Cannot possible delete user!"
                           ,"Delete error", JOptionPane.ERROR_MESSAGE);
                    Logs.generateExceptionLog(e.toString());
                     
                }
            }
        }
    }
}
