/*
 * In this interface CRUD database operations for engine models table
 * will be declared.  
 */
package com.CRS.Controller;

import java.sql.ResultSet;

/*
 * Car Registry System / Controller / Engine Models Business Logic Interface
 * @author MRX
 * Version : 1.0.0
 */ 

public interface CrudEngine {
    
    public abstract void registerEngineModel(String engineModel, String size, 
                                                  String power, String torque);
    
    public abstract ResultSet searchEnginesModels(String modelLike);
    
    public abstract void updateEngineModel(String engineModel, String size, 
                                         String power, String torque, String id);
    
    public abstract void deleteEngineModel(String model, String user, String motive);
    
}
