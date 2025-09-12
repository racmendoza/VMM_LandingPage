/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage2.gui.components;

import com.mycompany.vmm_landingpage2.gui.utils.ImageLoader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author racmendoza
 */
public class headerFactory {
    final static Color VMM_Maroon = new Color(0xBB0000); //REMOVE
    final static Color VMM_Green = new Color(0x2E8B57); //REMOVE
    final static Color VMM_Beige = new Color(0xF5DEB3); //REMOVE
    final static Color VMM_Red = new Color(0xFF4500); //REMOVE
    final static Color VMM_Grey = new Color(0xD3D3D3); //REMOVE 
    final static Color VMM_White = Color.WHITE; //REMOVE
    final static Color VMM_Black = Color.BLACK; //REMOVE

    static ImageIcon logo = new ImageIcon(ImageLoader.getInstance().getLogo().getImage().getScaledInstance(180, 80, Image.SCALE_SMOOTH)); //REMOVE
    
    public static JPanel createHeader(int height, Consumer<String> buttonClicked){
        
        // HEADER
        
        JPanel Header = new JPanel();
        Header.setPreferredSize(new Dimension(Integer.MAX_VALUE,height));
        Header.setBackground(VMM_White); //--------------CHANGE
        Header.setLayout(new BorderLayout());
        
        // HEADER: LOGO
        
        JPanel Header_Left = new JPanel();
        Header_Left.setPreferredSize(new Dimension(230,Integer.MAX_VALUE));
        Header_Left.setBackground(VMM_White); //--------------CHANGE
        
        JLabel Header_Logo = new JLabel();
        Header_Logo.setPreferredSize(new Dimension(200,90));
        Header_Logo.setBackground(VMM_White); //--------------CHANGE
        Header_Logo.setHorizontalAlignment(JLabel.CENTER);
        Header_Logo.setIcon(logo); //--------------CHANGE
        Header_Logo.setOpaque(true);
        
        Header_Left.add(Header_Logo);

        // HEADER : CENTER BUTTONS
        
        JPanel Header_Center = new JPanel();
        Header_Center.setPreferredSize(new Dimension(230,Integer.MAX_VALUE));
        Header_Center.setBackground(VMM_White); //--------------CHANGE
        Header_Center.setLayout(new FlowLayout(FlowLayout.LEFT));
        Header_Center.setBorder(BorderFactory.createEmptyBorder(-5,0,-5,-5));
        
        JLabel LogOut = new JLabel();
        LogOut.setBackground(VMM_Black); //--------------CHANGE
        LogOut.setVerticalAlignment(JLabel.CENTER);
        LogOut.setHorizontalAlignment(JLabel.CENTER);
        LogOut.setOpaque(true);
        LogOut.setPreferredSize(new Dimension(230,80));
        LogOut.setText("Log Out");
        LogOut.setForeground(VMM_Grey); //--------------CHANGE
        LogOut.setFont(Roboto(30)); //--------------CHANGE
        LogOut.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                LogOut.setBackground(Color.DARK_GRAY); //--------------CHANGE
                LogOut.setForeground(VMM_White); //--------------CHANGE
                LogOut.repaint();
            };
            @Override
            public void mouseExited(MouseEvent e){
                LogOut.setBackground(VMM_Black); //--------------CHANGE
                LogOut.setForeground(Color.LIGHT_GRAY); //--------------CHANGE
                LogOut.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                //frame.dispose();
                JOptionPane.showMessageDialog(null,"This panel was pressed");
                //panel.getComponent(0).get;
            }
        });
        
        JLabel FAQ = createHeaderButtons("Landing", buttonClicked);
        JLabel BLOG = createHeaderButtons("Blog", buttonClicked);
        JLabel ABOUT_US = createHeaderButtons("AboutUs", buttonClicked);
        
        Header_Center.add(FAQ);
        Header_Center.add(BLOG);
        Header_Center.add(ABOUT_US);
        
         Header_Center.add(LogOut);
        // HEADER: SIGN OUT
        JPanel Header_Right = new JPanel();
        Header_Right.setPreferredSize(new Dimension(100,Integer.MAX_VALUE));
        Header_Right.setBackground(VMM_White); //--------------CHANGE
        Header_Right.setLayout(new BorderLayout());
        Header_Right.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        
        // HEADER: DARK MODE
        JPanel DMPanel = new JPanel();
        DMPanel.setBackground(VMM_Grey); //--------------CHANGE
        
        
        
        Header_Right.add(DMPanel,BorderLayout.CENTER);
        //
        Header.add(Header_Left,BorderLayout.WEST);
        Header.add(Header_Right,BorderLayout.EAST);
        Header.add(Header_Center,BorderLayout.CENTER);
        ///
        
        return Header;
    }
    
    private static Font Roboto(int fontSize){
        Font Roboto = new Font("Roboto",Font.BOLD,fontSize);
        return Roboto; 
    }
    private static JLabel createHeaderButtons(String text, Consumer<String> buttonClicked){
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(170,100));
        label.setBackground(VMM_White);
        label.setForeground(VMM_Green);
        label.setText(text);
        label.setFont(Roboto(30));
        //label.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        
        label.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                //label.setBackground(Color.DARK_GRAY);
                label.setForeground(VMM_Grey);
                label.repaint();
            };
            @Override
            public void mouseExited(MouseEvent e){
                //label.setBackground(Color.WHITE);
                label.setForeground(VMM_Green);
                label.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                buttonClicked.accept(text);
                JOptionPane.showMessageDialog(null,"This panel was pressed");
            }
        });
        
        return label;
    }
}
