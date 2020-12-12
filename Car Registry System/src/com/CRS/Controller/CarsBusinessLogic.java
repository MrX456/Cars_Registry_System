/*
 * This module will be responsable for cars table business logic,
 * the most important data structure of this system
 */
package com.CRS.Controller;

import com.CRS.Application.FrmCars;
import com.CRS.DAL.DAL;
import com.CRS.Utils.AudioWarning;
import com.CRS.Utils.CoolStuff;
import static com.CRS.Utils.CoolStuff.resizeSelectedImage;
import com.CRS.Utils.Logs;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Car Registry System / Controller / Cars Business Logic
 * @author MRX
 * Version : 1.0.0
 */

public class CarsBusinessLogic implements CrudCars {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void registerCar(String maker, String model, String country, String year, String body, String color, String speed, String price, String imgPath, String byUser, String idEngineModel) {
        
         try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getRegisterThisCar());
            pst.setString(1, maker);
            pst.setString(2, model);
            pst.setString(3, country);
            pst.setString(4, year);
            pst.setString(5, body);
            pst.setString(6, color);
            pst.setString(7, speed);
            pst.setString(8, price);
            
            /*
             * Here goes the image. If the path is null, we insert 
             * this on database
             */
            if(imgPath == null) {
                
                pst.setNull(9, java.sql.Types.BLOB);
                
            } else {
                
                // Case path exists we need to pass it as parameter to our method
                FileInputStream fis = CoolStuff.storeImage(imgPath);
                
                // Now we have a FileInputStream to store on database
                pst.setBinaryStream(9, fis);
                
            }
                
            // The code continues
            
            pst.setString(10, byUser);
            pst.setString(11, idEngineModel);
            
            // Need to verify update
            int add = pst.executeUpdate();
            if(add > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully added car!"
                   ,"Registration confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                conn.close();
            }
            
        } catch (Exception e) {
            
            //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible add car!"
                   ,"Registration error", JOptionPane.ERROR_MESSAGE);
             Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public ResultSet searchCars(String modelLike) {
        
         //This method will return a database ResultSet
        try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getSearchTheseCars());
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
            JOptionPane.showMessageDialog(null, "Cannot possible find car!"
                   ,"Search error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            //Null ResultSet
            return rs;
            
        }
    }

    @Override
    public void searchPhoto(String carID) {
        
        try {
            
            conn = DAL.requestConnection();
            
            final String imgPath = Logs.getDocumentsGenericPath() + "\\temp\\image.jpg";
            File file = new File(imgPath);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] img_array;
            Blob blob;
            
            pst = conn.prepareStatement(SqlCommand.getSerchThisPhoto());
            
            pst.setString(1, carID);
            rs = pst.executeQuery();
            
            // Create a image with this blob column
            if(rs.next()) {
                
                 blob = rs.getBlob("photo"); //Database Column name
                 try {
                     
                    img_array = blob.getBytes(1, (int)blob.length());
                    fos.write(img_array);
                    fos.close();
                    
                    // Resize and use created image as label icon
                    FrmCars.lblImage.setIcon(resizeSelectedImage(imgPath));
                    
                 } catch(Exception ex){
                     
                     // Null value on blob column
                     FrmCars.lblImage.setIcon(new ImageIcon(getClass().getResource("/com/CRS/images/default-image.jpg")));
                     
                 }
            }
            
        } catch (Exception e) {
            
            // FileNotFoundException
            Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public void updateCar(String maker, String model, String country, String year, String body, String color, String speed, String price, String byUser, String id) {
        
           try {
            
            conn = DAL.requestConnection();
            
            pst = conn.prepareStatement(SqlCommand.getUpdateThisCar());
            pst.setString(1, maker);
            pst.setString(2, model);
            pst.setString(3, country);
            pst.setString(4, year);
            pst.setString(5, body);
            pst.setString(6, color);
            pst.setString(7, speed);
            pst.setString(8, price);
            
            // Image and engine model cannot be updated
            
            pst.setString(9, byUser);
            pst.setString(10, id);
            
            // Need to verify update
            int add = pst.executeUpdate();
            if(add > 0) {
                
                JOptionPane.showMessageDialog(null, "Successfully updated car!"
                   ,"Update confirmed", JOptionPane.INFORMATION_MESSAGE);
                
                conn.close();
            }
            
        } catch (Exception e) {
            
             //Let´s play a warning sound with your method
            AudioWarning aw = new AudioWarning();
            aw.errorWarning();
            JOptionPane.showMessageDialog(null, "Cannot possible update car!"
                   ,"Update error", JOptionPane.ERROR_MESSAGE);
            Logs.generateExceptionLog(e.toString());
            
        }
    }

    @Override
    public void deleteCar(String id, String car, String color, String user, String motive) {
        
            //Confirm exclusion
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to delete this car?",
                "Delete car", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (confirm == 0) {

            try {

                conn = DAL.requestConnection();

                pst = conn.prepareStatement(SqlCommand.getDeleteThisCar());
                //Model is unique constraint
                pst.setString(1, id);

                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully deleted car!", "Delete confirmed", JOptionPane.INFORMATION_MESSAGE);

                //Generate a log
                String date = CoolStuff.getTimeNow();
                Logs.deletedCar(car, color, user, motive, date);

                conn.close();

            } catch (Exception e) {
               
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                JOptionPane.showMessageDialog(null, "Cannot possible delete car!"
                       ,"Delete error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());

            }
        }
    }
}
    
    
    
    

