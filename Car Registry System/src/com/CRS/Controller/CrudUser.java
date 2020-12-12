/*
 * In this interface CRUD database operations for users table
 * will be declared.  
 */
package com.CRS.Controller;

import java.sql.ResultSet;

/*
 * Car Registry System / Controller / Users Business Logic Interface
 * @author MRX
 * Version : 1.0.0
 */ 

public interface CrudUser {
    
    public abstract void login(String login, String password);
    
    public abstract void registerUser(String name, String sex, String login,
                                           String password, String profile);
    
    public abstract ResultSet searchUsers(String nameLike);
    
    public abstract void updateUser(String name, String sex, String login,
                                    String password, String profile, String id);
    
    public abstract void deleteUser(String id);
}
