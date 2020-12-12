/*
 * This module will be responsable for database access
 */
package com.CRS.DAL;

import com.CRS.Utils.Logs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Car Registry System / DAL / Access Layer
 * @author MRX
 * Version : 1.0.0
 */

public class DAL {
    
    //Lets create a method to connect to database
    public static Connection requestConnection() {
        Connection connection = null;
        
        //Connection driver
        final String driver = "com.mysql.jdbc.Driver";
        
        //Database informations(Local server)
        final String url = "jdbc:mysql://localhost:3306/vehicle_database";
        
        //User and password
        final String user = "root";
        final String password = "";
        
        //Let´s try to connect database
        try {
            
            Class.forName(driver);
            
            connection = DriverManager.getConnection(url, user, password);
            return connection;
            
        } catch (SQLException | ClassNotFoundException e) {
            
            //Lets generate a log with our method
            Logs.generateExceptionLog(e.toString());
            return null;
            //Connection failed
            
        }
    }
}
