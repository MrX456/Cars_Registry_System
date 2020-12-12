/*
 * This module will be responsable for generate some txt logs
 */
package com.CRS.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/*
 * Car Registry System / Utils / Logs
 * @author MRX
 * Version : 1.0.0
 */

public class Logs {
      
    // My documents generic path
    private final static String documentsGenericPath = System.getProperty("user.home") + "\\Documents\\CRS";
     
    public static String getDocumentsGenericPath() {
        return documentsGenericPath;
    }
    
    /* This method will generate a exception txt log, pass any triggered exception 
     * as parameter converted to string
    */
    public static void generateExceptionLog(String exception) {
        
        // The folder CRS/Errors Logs must be present on client computer folder My Documents or will trigger FileNotFound
        
        /*Lets use our method to name the txt file with date,
         * exclude secs and mins to avoid excessive file creations
         */
        String fileName = getDocumentsGenericPath() + "\\Errors Logs\\" + CoolStuff.getTimeNow().substring(0, 14).
                                          replace(":", "")+ ".txt";
        //Create txt file
        File exLog = new File(fileName);
        
        //Let´s try generate the exception log
        try {
            
            FileWriter fw = new FileWriter(exLog);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("----------- Exception Catched -------------");
            bw.newLine();
            bw.newLine();
            bw.write(exception);
            bw.newLine();
            bw.newLine();
            bw.write(CoolStuff.getTimeNow());
            bw.newLine();
            bw.write("--------------------------------------------");
            
            //Closing the document
            bw.flush();
            bw.close();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /* This method will generate a exclusion txt log, cars and engines deleted 
     * will generate this log for audit purposes
    */
    
    public static void deletedEngineModel(String engineModel, String userLogin, String motive, String date) {
        
        // The folder CRS/Delete Logs must be present on client computer folder My Documents or will trigger FileNotFound
        String fileName = getDocumentsGenericPath() + "\\Delete Logs\\deleted-" + CoolStuff.getTimeNow().replace(":", "")+ ".txt";
        
        File delLog = new File(fileName);
        
        try {
            
            FileWriter fw = new FileWriter(delLog);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("----------- Engine Model Deleted -------------");
            bw.newLine();
            bw.newLine();
            bw.write("Engine Model : " + engineModel);
            bw.newLine();
            bw.write("Deleted by : " + userLogin);
            bw.newLine();
            bw.write("Motive : " + motive);
            bw.newLine();
            bw.write(date);
            bw.newLine();
            bw.newLine();
            bw.write("--------------------------------------------");
            
            //Closing the document
            bw.flush();
            bw.close();
            
        } catch (Exception e) {
            
             e.printStackTrace();
             generateExceptionLog(e.toString());
        }
    }
   
    public static void deletedCar(String car, String color, String userLogin, String motive, String date) {
        
        // The folder CRS/Delete Logs must be present on client computer folder My Documents or will trigger FileNotFound
        String fileName = getDocumentsGenericPath() + "\\Delete Logs\\deleted-car-" + CoolStuff.getTimeNow().replace(":", "")+ ".txt";
        
        File delLog = new File(fileName);
        
         try {
            
            FileWriter fw = new FileWriter(delLog);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write("--------------- Car Deleted -----------------");
            bw.newLine();
            bw.newLine();
            bw.write("Car Model : " + car);
            bw.newLine();
            bw.write("Color : " + color);
            bw.newLine();
            bw.write("Deleted by : " + userLogin);
            bw.newLine();
            bw.write("Motive : " + motive);
            bw.newLine();
            bw.write(date);
            bw.newLine();
            bw.newLine();
            bw.write("--------------------------------------------");
            
            //Closing the document
            bw.flush();
            bw.close();
            
        } catch (Exception e) {
            
             e.printStackTrace();
             generateExceptionLog(e.toString());
        }
        
    }

}
