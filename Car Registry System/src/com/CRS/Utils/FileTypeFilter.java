/*
 * This module is responsible for filter the file type what can be chosen
 */

package com.CRS.Utils;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/*
 * Car Registry System / Utils / File Type Filter
 * @author MRX
 * Version : 1.0.0
 */

public class FileTypeFilter extends FileFilter {

    private final String extension;
    private final String description;
    
    //Constructor
    public FileTypeFilter(String extension, String description){
        this.extension = extension;
        this.description = description;
    }
    
    @Override
    public boolean accept(File file) {
        
        if(file.isDirectory()){
            return true;
        }
        return file.getName().endsWith(extension);
        
    }

    @Override
    public String getDescription() {
        
         return description + String.format(" (*%S)", extension);
         
    }
    
}
