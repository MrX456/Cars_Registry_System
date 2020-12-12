/*
 * This module will be responsable for engine model table business logic
 */
package com.CRS.Controller;

import com.CRS.DAL.DAL;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.CoolStuff;
import com.CRS.Utils.Logs;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * Car Registry System / Controller / Engine Model Business Logic
 * @author MRX
 * Version : 1.0.0
 */

public class EngineBusinessLogic implements CrudEngine {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

   @Override
    public void registerEngineModel(String engineModel, String size, String power, String torque) {
        
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getRegisterThisEngine());
            pst.setString(1, engineModel);
            //Java will parse automatically
            pst.setString(2, size);
            pst.setString(3, power);
            pst.setString(4, torque);
            
            // Need to verify update
            int add = pst.executeUpdate();
            if(add > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully added engine model!"
                   ,"Registration confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                conn.close();
            }
            
        } catch (Exception e) {
            
            //Lets play warning sound with our method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            //Engine model column has unique constraint and can trigger a exception
            JOptionPane.showMessageDialog(null, "This engine model is already registered!"
                                     ,"Registration Failed", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public ResultSet searchEnginesModels(String modelLike) {
        
         //This method will return a database ResultSet
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getSearchTheseEngines());
            /*
             * Sql instruction uses like, we must to concatenate our text
             * with % character
             */
            pst.setString(1, modelLike + "%");
            
            rs = pst.executeQuery();
            
            return rs;
           
            
        } catch (Exception e) {
            
            //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible find engine model!"
                   ,"Search error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            //Null ResultSet
            return rs;
            
        }
    }

    @Override
    public void updateEngineModel(String engineModel, String size, String power, String torque, String id) {
        
         try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getUpdateThisEngine());
            pst.setString(1, engineModel);
            //Java will parse automatically
            pst.setString(2, size);
            pst.setString(3, power);
            pst.setString(4, torque);
            pst.setString(5, id);
            
            // Need to verify update
            int add = pst.executeUpdate();
            if(add > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully updated engine model!"
                                 ,"Update confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                conn.close();
            }
        } catch (Exception e) {
            
            //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible update engine!"
                   ,"Update error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            
        }
         
    }

    @Override
    public void deleteEngineModel(String model, String user, String motive) {
        
         //Confirm exclusion
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to delete this engine?",
                "Delete engine", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == 0) {

            try {

                conn = DAL.requestConnection();

                pst = conn.prepareStatement(SqlCommand.getDeleteThisEngine());
                //Model is unique constraint
                pst.setString(1, model);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully deleted engine!",
                            "Delete confirmed", JOptionPane.INFORMATION_MESSAGE);

                //Generate a log
                String date = CoolStuff.getTimeNow();
                Logs.deletedEngineModel(model, user, motive, date);

                conn.close();

            } catch (Exception e) {

                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                //Used engine cannot be deleted
                JOptionPane.showMessageDialog(null, "Cannot delete engine model already in use!", 
                                                       "Delete error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());

            }
        }
    }
}
