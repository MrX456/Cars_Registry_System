/*
 * This module will be responsible for reports
 */

package com.CRS.Utils;

import com.CRS.DAL.DAL;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * Car Registry System / Utils / Reports
 * @author MRX
 * Version : 1.0.0
 */

public class Reports {
    
    // We need connection to generate reports
    private Connection conn = DAL.requestConnection();
    
   public void usersReport() {
        
        // generate users report
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to view this report?",
                        "See Report", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(confirm == 0) {
            
            try {
                
                // Use Jasper Report Ireport to generate this report
                
                final String reportPath = Logs.getDocumentsGenericPath() + "\\Reports Templates\\users_report.jasper";
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, conn);
                
                // Report view
                JasperViewer.viewReport(print, false);
                
            } catch (Exception e) {
                
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                JOptionPane.showMessageDialog(null, "Cannot possible generate report!"
                       ,"Report error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());
            
            }
        }
    }
    
    public void engineModelsReport() {
        
        // generate engines report
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to view this report?",
                        "See Report", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(confirm == 0) {
            
            try {
                
                // Use Jasper Report Ireport to generate this report
                
               final String reportPath = Logs.getDocumentsGenericPath() + "\\Reports Templates\\engine_model_report.jasper";
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, conn);
                
                // Report view
                JasperViewer.viewReport(print, false);
                
            } catch (Exception e) {
                
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                JOptionPane.showMessageDialog(null, "Cannot possible generate report!"
                       ,"Report error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());
                
            }
        }
    }
    
    public void carsReport() {
        
        // generate engines report
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to view this report?",
                        "See Report", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(confirm == 0) {
            
            try {
                
                // Use Jasper Report Ireport to generate this report
                
                final String reportPath = Logs.getDocumentsGenericPath() + "\\Reports Templates\\vehicle_database_report.jasper";
                JasperPrint print = JasperFillManager.fillReport(reportPath, null, conn);
                
                // Report view
                JasperViewer.viewReport(print, false);
                
            } catch (Exception e) {
               
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                JOptionPane.showMessageDialog(null, "Cannot possible generate report!"
                       ,"Report error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());
                
            }
        }
        
    }
    
    public void printSpecs(String carID) {
        
        // This method print selected car specs
        int confirm = JOptionPane.showConfirmDialog(null, "Would you like to print this car specs?",
                        "Print specs", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(confirm == 0) {
            
            try {
                
                // We need a filter
                HashMap filter = new HashMap();
                
                // This id was defined in Ireport design
                filter.put("id", Integer.parseInt(carID));

                final String reportPath = Logs.getDocumentsGenericPath() + "\\Reports Templates\\car_spec.jasper";
                JasperPrint print = JasperFillManager.fillReport(reportPath, filter, conn);
                                               

                
                JasperViewer.viewReport(print, false);
                
            } catch (Exception e) {
               
                //Let´s play a warning sound with your method
                AudioWarning aw = new AudioWarning();
                aw.errorWarning();
                JOptionPane.showMessageDialog(null, "Cannot possible print these specs!"
                       ,"Report error", JOptionPane.ERROR_MESSAGE);
                Logs.generateExceptionLog(e.toString());
                
            }
        }
    }
}
