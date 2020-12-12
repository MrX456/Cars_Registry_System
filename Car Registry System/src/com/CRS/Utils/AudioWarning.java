/*
 * This module contains some methods those play warning sounds when
 * some error occurs
 */
package com.CRS.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * Car Registry System / Utils / Audio Warning
 * @author MRX
 * Version : 1.0.0
 */

public class AudioWarning {
    
    /* Methods used here can't be used in a static method, we must create a 
     * object first to use theses methods
     */
    
    //When a exception or error occurs lets play a sound for the user
    public void errorWarning() {
        
        try {
            
            String audio = "error.wav";
            InputStream is = getClass().getResourceAsStream(audio);
            InputStream buf = new BufferedInputStream(is);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(buf);
            clip.open(ais);
            //No repeat
            clip.loop(0);
            
        } catch (Exception e) {
            e.printStackTrace();
            Logs.generateExceptionLog(e.toString());
        }
    }
    
    //When login failed lets play this sound
    public void loginFailedWarning() {
        
        try {
            
            String audio = "login_failed.wav";
            InputStream is = getClass().getResourceAsStream(audio);
            InputStream buf = new BufferedInputStream(is);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(buf);
            clip.open(ais);
            clip.loop(0);
            
        } catch (Exception e) {
            e.printStackTrace();
            Logs.generateExceptionLog(e.toString());
        }
    }
    
}
