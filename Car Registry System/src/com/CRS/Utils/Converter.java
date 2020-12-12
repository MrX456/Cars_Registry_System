/*
 * This module will be responsible for unit conversions 
 */

package com.CRS.Utils;

/*
 * Car Registry System / Utils / Converter
 * @author MRX
 * Version : 1.0.0
 */

public class Converter {
    
    // #region Engine Size Units
    
    //Convert cubic centimeters to cubic inch
    public static Integer ccToInch (int cc) {
        
        //Converting cc to inch
        double value = cc * 0.06101;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    //Convert  cubic inch to cubic centimeters
    public static Integer inchToCC (int inch) {
        
        //Converting inch to cc
        double value = inch * 16.39;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    // #endregion
    
    // #region Engine Power Units
    
    //Convert horsepower to kilowatt
    public static Integer hpToKW (int hp) {
        
        //Converting hp to kw
        double value = hp / 1.341;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
     //Convert kilowatt to horsepower
    public static Integer kwToHP (int kw) {
        
        //Converting kw to hp
        double value = kw * 1.341;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    // #endregion
    
    // #region Engine Torque Units
    
    //Convert Newton meter to foot-pounds
    public static Integer nmToFtlb (int nm) {
        
        //Converting nm to ft-lb
        double value = nm * 0.73756;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    //Convert foot-pounds to newton meter
    public static Integer ftlbToNm (int ftlb) {
        
        //Converting ft-lb to nm
        double value = ftlb / 0.73756;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    // #endregion
    
    // #region Speed Units
    
    //Convert miles per hour to kilometers per hour
    public static Integer mphToKph (int mph) {
        
        //Converting mph to kph
        double value = mph * 1.6;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    //Convert kilometers per hour to miles per hour
    public static Integer kphToMph (int kph) {
        
        //Converting kph to mph
        double value = kph / 1.6;
        
        // Round the value and parse it to int, autoboxing will be made automatically
        return (int)Math.round(value);
        
    }
    
    // #endregion
}
