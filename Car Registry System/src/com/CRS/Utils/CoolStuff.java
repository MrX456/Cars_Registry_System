/*
 * This module contains some interesting methods to use in your application
 */
package com.CRS.Utils;

import com.CRS.Application.FrmCars;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;

/*
 * Car Registry System / Utils / Cool Stuff
 * @author MRX
 * Version : 1.0.0
 */

public class CoolStuff {
    
    // Get system time and return it wherever we need
    public static String getTimeNow() {
        
        //Get complete time with seconds
        Date date = new Date();
        final String formated = "dd-MM-yyyy hh:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(formated);
        String now = sdf.format(date);
        
        return now;
   
    }
    
     // Open documentation file
    public static void openDocumentation() {
        if(Desktop.isDesktopSupported()) {
            
            try {
                
               
                final String path = Logs.getDocumentsGenericPath() + "\\Crs_Documentation.pdf";
                File doc = new File(path);
                Desktop.getDesktop().open(doc);
            
                
            } catch (Exception e) {
                e.printStackTrace();
                Logs.generateExceptionLog(e.toString());
            }
            
        }
    }
    
    // Validate only numbers in specific fields
    public static boolean isNumber(String str) {
        
        //Let´s try parse to verify
        try {
            
            double d = Double.parseDouble(str);
            return true;
            
        } catch (Exception e) {
            
            return false;
        }
    }
    
    // Transform Image into a FileInputStream to be stored in database
    public static FileInputStream storeImage(String imgPath) {
        
        try {
            
            File file = new File(imgPath);
            FileInputStream fis = new FileInputStream(file);
            return fis;
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
            Logs.generateExceptionLog(e.toString());
            return null;
            
        } 
    }
    
    /*
     * Resize the image on FrmCars lblImage icon
     * we need to use this method outside FrmCars,
     * lblImage turned public and static
     */
    public static ImageIcon resizeSelectedImage(String path) {
        
        ImageIcon image = new ImageIcon(path);
        Image img = image.getImage();
        Image resize = img.getScaledInstance(FrmCars.lblImage.getWidth(), FrmCars.lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(resize);
        return i;
        
    }
    
    // This method create a image to use as icon on application
    public static ImageIcon createIcon() {
        
        return new ImageIcon(Toolkit.getDefaultToolkit().getClass().getResource("/com/CRS/icons_package/logo.png"));
    }
}
