/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vmm_landingpage2;

import com.mycompany.vmm_landingpage2.gui.currentFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author racmendoza
 */
public class VMM_LandingPage2 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater(()->{
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception ex){
                ex.printStackTrace();
            }
            currentFrame currentFrame = new currentFrame();
            currentFrame.setVisible(true);
        });
    }
}
