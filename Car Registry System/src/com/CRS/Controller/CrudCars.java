/*
 * In this interface CRUD database operations for cars table
 * will be declared.  
 */
package com.CRS.Controller;

import java.sql.ResultSet;

/*
 * Car Registry System / Controller / Cars Business Logic Interface
 * @author MRX
 * Version : 1.0.0
 */ 

public interface CrudCars {
    
    public abstract void registerCar(String maker, String model, String country, 
                   String year, String body, String color, String speed, String price, 
                         String imgPath, String byUser, String idEngineModel);
    
    public abstract ResultSet searchCars(String modelLike);
    
    public abstract void searchPhoto(String carID);
    
    public abstract void updateCar(String maker, String model, String country, 
                   String year, String body, String color, String speed, String price, 
                                                            String byUser, String id);
    
    public abstract void deleteCar(String id, String car, String color, String user, String motive);
}
