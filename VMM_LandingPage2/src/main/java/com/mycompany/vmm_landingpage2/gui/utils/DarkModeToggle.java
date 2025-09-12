/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage2.gui.utils;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author racmendoza
 */
public class DarkModeToggle extends JPanel{
    private final JToggleButton toggleButton;
    
    public DarkModeToggle() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setOpaque(false);
        
        toggleButton = new JToggleButton();
        updateButtonAppearance();
        
        toggleButton.addActionListener(e -> {
            ThemeManager.getInstance().toggleDarkMode();
            updateButtonAppearance();
        });
        
        add(toggleButton);
    }
    
    private void updateButtonAppearance() {
        boolean isDarkMode = ThemeManager.getInstance().isDarkMode();
        
        if (isDarkMode) {
            toggleButton.setText("☀️ Light Mode");
            toggleButton.setToolTipText("Switch to light theme");
        } else {
            toggleButton.setText("🌙 Dark Mode");
            toggleButton.setToolTipText("Switch to dark theme");
        }
        
        // Style the button to match current theme
        toggleButton.setBackground(ThemeManager.getInstance().getComponentColor());
        toggleButton.setForeground(ThemeManager.getInstance().getForegroundColor());
    }
}
