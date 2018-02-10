/**
 * Filename:    SoundEffect.java
 * Description: Enumeration for playing the Calculator Sound Effects.
 * 
 * Adapted from;
 *    Title:        SoundEffectDemo
 *    Author:       Chua Hock-Chuan
 *    Date:         04/09/2008
 *    Code version: Unknown
 *    Availability: https://www.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
 */
package com.software.laing.calculator;

import java.net.URL;
import javax.sound.sampled.*;
   
/**
 * Enumeration for playing sound effects.
 */
public enum SoundEffect 
{
    CLEAR("com/software/laing/calculator/clearSound.wav"),  
    ERROR("com/software/laing/calculator/errorSound.wav"),
    CLICK("com/software/laing/calculator/keyPress.wav");
   
    /**
     * Nested enumeration for specifying sound volumes.
     */
    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }
   
    private Clip clip;    
    public static Volume volume = Volume.LOW;
    private boolean loaded = true;

    /* Default constructor */
    SoundEffect(String fileName) 
    {
        try {
            URL url = this.getClass().getClassLoader().getResource(fileName);
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);

            clip = AudioSystem.getClip();
            clip.open(ais);
        } 
        catch (Exception e) {
            //e.printStackTrace();
            loaded = false;
        } 
    }
   
    
    /**
     * The method play is used to play the sound effect.
     */
    public void play() 
    {
        if (loaded && volume!=Volume.MUTE) 
        {
            if (clip.isRunning())
                clip.stop();          // Stop the player if sound is still running
            
            clip.setFramePosition(0); // rewind to the beginning of the clip
            clip.start();
        }
    }
   
    /**
     * The method init is used to pre-load all the sound files.
     */
    static void init() {
        values();    // calls the constructor for all the elements
    }
}
