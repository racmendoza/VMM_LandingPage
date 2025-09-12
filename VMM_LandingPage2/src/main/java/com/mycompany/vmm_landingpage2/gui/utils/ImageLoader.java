/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage2.gui.utils;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author racmendoza
 */
public class ImageLoader{
    private static ImageLoader instance;
        
    private ImageIcon TwitterIcon = new ImageIcon("twitter-x-logo-png-9.png");
    private ImageIcon FacebookIcon = new ImageIcon("facebook-logo.png");
    private ImageIcon InstagramIcon = new ImageIcon("1658587303instagram-png.png");
    private ImageIcon Logo = new ImageIcon("MP_Logo.png");
    
    private ImageLoader(){
    }
    
    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public ImageIcon getTwitterIcon() {
        return TwitterIcon;
    }
    public ImageIcon getFacebookIcon() {
        return FacebookIcon;
    }
    public ImageIcon getInstagramIcon() {
        return InstagramIcon;
    }
    public ImageIcon getLogo() {
        return Logo;
    }
    
}
