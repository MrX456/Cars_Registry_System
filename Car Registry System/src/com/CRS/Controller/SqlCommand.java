/*
 * This module will be responsable for encapsule all mysql instructions, used
 * on business logic modules
 */
package com.CRS.Controller;

/*
 * Car Registry System / Controller /Sql Encapsuled Commands
 * @author MRX
 * Version : 1.0.0
 */

public class SqlCommand {
    
    // #region Users table
    
    private static final String searchThisCredential = "SELECT * FROM tbl_users"
            + " WHERE login = ? AND user_password = ?";

    private static final String registerThisUser = "INSERT INTO tbl_users"
            + "(user_name, sex, login, user_password, user_profile)"
            + "VALUES (?, ?, ?, ?, ?)";
    
    private static final String searchTheseUsers = "SELECT * FROM tbl_users WHERE "
                                                              + "user_name LIKE ?";
    
    private final static String updateThisUser = "UPDATE tbl_users SET user_name = ?,"
            + " sex = ?, login = ?, user_password = ?, user_profile = ? WHERE id_user"
                                                                               + "= ?";
    
    private final static String deleteThisUser = "DELETE FROM tbl_users "
                                                         + "WHERE id_user = ?";
    
    // #endregion
    
    // #region Engine Model table
    
    private static final String registerThisEngine =  "INSERT INTO tbl_engineModel"
                                       + "(engine_model, size, power, torque)"
                                                         + "VALUES (?, ?, ?, ?)";
    
    private static final String searchTheseEngines = "SELECT * FROM tbl_engineModel WHERE "
                                                              + "engine_model LIKE ?";
    
    private final static String updateThisEngine = "UPDATE tbl_engineModel SET engine_model = ?,"
                                  + " size = ?, power = ?, torque = ? WHERE id_engineModel = ?";
    
    private final static String deleteThisEngine = "DELETE FROM tbl_engineModel "
                                                         + "WHERE engine_model = ?";
    
    // #endregion
    
    // #region Cars Table
    
    private static final String registerThisCar = "INSERT INTO tbl_cars(maker, model, "
            + "country, year_built, body_type, color, top_speed, price, photo, "
            + "by_user, id_engineModel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    
    private static final String searchTheseCars = "SELECT C.id_car, maker, model, "
            + "country, year_built, body_type, color, top_speed, price, "
            + "E.engine_model, size, power, torque FROM tbl_cars AS C INNER JOIN"
            + " tbl_engineModel AS E ON(C.id_engineModel = E.id_engineModel)"
            + " WHERE model LIKE ?";
    
    private static final String serchThisPhoto = "SELECT (photo) FROM tbl_cars "
                                                            + "WHERE id_car = ?";
    
    private static final String updateThisCar = "UPDATE tbl_cars SET maker = ?, model = ?, "
            + "country = ?, year_built = ?, body_type = ?, color = ?, top_speed = ?, price = ?,"
            + " by_user = ? WHERE id_car = ?";
    
    private final static String deleteThisCar = "DELETE FROM tbl_cars "
                                                         + "WHERE id_car = ?";
    
    // #endregion
    
    // #region Users Getters
    
    public static String getSearchThisCredential() {
        return searchThisCredential;
    }

    public static String getRegisterThisUser() {
        return registerThisUser;
    }

    public static String getSearchTheseUsers() {
        return searchTheseUsers;
    }

    public static String getUpdateThisUser() {
        return updateThisUser;
    }

    public static String getDeleteThisUser() {
        return deleteThisUser;
    }
    
    // #endregion

    // #region Engines Models Getters
    
    public static String getRegisterThisEngine() {
        return registerThisEngine;
    }

    public static String getSearchTheseEngines() {
        return searchTheseEngines;
    }

    public static String getUpdateThisEngine() {
        return updateThisEngine;
    }

    public static String getDeleteThisEngine() {
        return deleteThisEngine;
    }
    
    // #endregion

    // #region Cars Getters
    public static String getRegisterThisCar() {
        return registerThisCar;
    }

    public static String getSearchTheseCars() {
        return searchTheseCars;
    }

    public static String getSerchThisPhoto() {
        return serchThisPhoto;
    }

    public static String getUpdateThisCar() {
        return updateThisCar;
    }

    public static String getDeleteThisCar() {
        return deleteThisCar;
    }
    
    // #endregion
}
