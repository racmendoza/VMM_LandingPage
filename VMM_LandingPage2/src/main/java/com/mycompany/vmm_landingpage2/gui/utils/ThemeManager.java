/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage2.gui.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author racmendoza
 */
public class ThemeManager {
    private static ThemeManager instance;
    private boolean darkMode = false;
    
    private final List<ThemeChangeListener> listeners = new ArrayList<>();
    
    // Color schemes
    private Color VMM_Maroon = new Color(0xBB0000); 
    private Color VMM_Green = new Color(0x2E8B57); 
    private Color VMM_Beige = new Color(0xF5DEB3); 
    private Color VMM_Red = new Color(0xFF4500); 
    private Color VMM_Grey = new Color(0xD3D3D3); 
    private Color VMM_White = Color.WHITE; 
    private Color VMM_Black = Color.BLACK;
    
    //private Color lightBackground = Color.WHITE;
    //private Color lightForeground = Color.BLACK;
    //private Color lightComponent = new Color(240, 240, 240);
    
    private Color darkBackground = new Color(45, 45, 45);
    private Color darkForeground = Color.WHITE;
    private Color darkComponent = new Color(60, 60, 60);

    private ThemeManager() {
        // Private constructor for singleton
    }

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }
    
    public boolean isDarkMode() {
        return darkMode;
    }
    
    public void toggleDarkMode() {
        darkMode = !darkMode;
        applyThemeToAllComponents();
        notifyListeners();
    }
    
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        applyThemeToAllComponents();
        notifyListeners();
    }
    
    public void addThemeChangeListener(ThemeChangeListener listener) {
        listeners.add(listener);
    }
    
    public void removeThemeChangeListener(ThemeChangeListener listener) {
        listeners.remove(listener);
    }
    
    private void notifyListeners() {
        for (ThemeChangeListener listener : listeners) {
            listener.onThemeChanged(darkMode);
        }
    }
    
    public void applyThemeToAllComponents() {
        // Apply to all existing frames and dialogs
        for (Window window : Window.getWindows()) {
            applyThemeToContainer(window);
        }
    }
    
    public void applyThemeToContainer(Container container) {
        applyThemeToComponent(container);
        
        for (Component comp : container.getComponents()) {
            if (comp instanceof Container) {
                applyThemeToContainer((Container) comp);
            } else {
                applyThemeToComponent(comp);
            }
        }
    }
    
    private void applyThemeToComponent(Component comp) {
        if (darkMode) {
            applyDarkTheme(comp);
        } else {
            applyLightTheme(comp);
        }
    }
    
    private void applyDarkTheme(Component comp) {
        comp.setForeground(darkForeground);
        
        if (comp instanceof JComponent) {
            JComponent jcomp = (JComponent) comp;
            
            if (jcomp instanceof JPanel || jcomp instanceof JLabel) {
                jcomp.setBackground(darkBackground);
            } else if (jcomp instanceof JButton || jcomp instanceof JTextField || 
                       jcomp instanceof JComboBox || jcomp instanceof JList) {
                jcomp.setBackground(darkComponent);
                jcomp.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
            }
            
            // Special cases
            if (jcomp instanceof JTextArea || jcomp instanceof JTextPane) {
                jcomp.setBackground(darkComponent);
                jcomp.setForeground(darkForeground);
            }
            
            if (jcomp instanceof JScrollPane) {
                jcomp.setBackground(darkBackground);
            }
        }
    }
    
    private void applyLightTheme(Component comp) {
        comp.setForeground(VMM_Grey);
        
        if (comp instanceof JComponent) {
            JComponent jcomp = (JComponent) comp;
            
            if (jcomp instanceof JPanel || jcomp instanceof JLabel) {
                jcomp.setBackground(VMM_White);
            } else if (jcomp instanceof JButton || jcomp instanceof JTextField || 
                       jcomp instanceof JComboBox || jcomp instanceof JList) {
                jcomp.setBackground(VMM_Black);
                jcomp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
            
            // Special cases
            if (jcomp instanceof JTextArea || jcomp instanceof JTextPane) {
                jcomp.setBackground(Color.WHITE);
                jcomp.setForeground(VMM_Black);
            }
            
            if (jcomp instanceof JScrollPane) {
                jcomp.setBackground(VMM_White);
            }
        }
    }
    
    public Color getBackgroundColor() {
        return darkMode ? darkBackground : VMM_White;
    }
    
    public Color getForegroundColor() {
        return darkMode ? darkForeground : VMM_Black;
    }
    
    public Color getComponentColor() {
        return darkMode ? darkComponent : VMM_Grey;
    }
    
    public interface ThemeChangeListener {
        void onThemeChanged(boolean isDarkMode);
    }
}
