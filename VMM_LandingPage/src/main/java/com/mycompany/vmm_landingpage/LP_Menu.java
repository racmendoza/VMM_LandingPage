/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vmm_landingpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author racmendoza
 */
public class LP_Menu extends JFrame{
    
    JFrame frame = new JFrame();
    //int fontSize;
    //Font Roboto = new Font("Roboto",Font.BOLD,fontSize);
    
    Color VMM_Maroon = new Color(0xBB0000);
    Color VMM_Green = new Color(0x2E8B57);
    Color VMM_Beige = new Color(0xF5DEB3);
    Color VMM_Red = new Color(0xFF4500);
    Color VMM_Grey = new Color(0xD3D3D3);
    
    
    public LP_Menu(){
        
        
        //FRAME
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("VMM_LandingPage");
        frame.getContentPane().setBackground(VMM_Grey);
        frame.setLayout(new BorderLayout(0,0));
        
        // IMAGEICONS
        
        ImageIcon unscaledNoteTaking = new ImageIcon("notetaking.jpeg");
        ImageIcon noteTaking = new ImageIcon(unscaledNoteTaking.getImage().getScaledInstance(650, 450, Image.SCALE_REPLICATE));
        
        ImageIcon unscaledTwitterIcon = new ImageIcon("twitter-x-logo-png-9.png");
        ImageIcon twitterIcon = new ImageIcon(unscaledTwitterIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
        ImageIcon unscaledFacebookIcon = new ImageIcon("facebook-logo.png");
        ImageIcon facebookIcon = new ImageIcon(unscaledFacebookIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
        ImageIcon unscaledInstagramIcon = new ImageIcon("1658587303instagram-png.png");
        ImageIcon instagramIcon = new ImageIcon(unscaledInstagramIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        
        ImageIcon unscaledLogo = new ImageIcon("MP_Logo.png");
        ImageIcon logo = new ImageIcon(unscaledLogo.getImage().getScaledInstance(180, 80, Image.SCALE_SMOOTH));
        
        // CENTER
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 2));
        
        //CENTER : IMAGE SLOGAN PANEL
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(VMM_Beige);
        
        JLabel slogan = new JLabel();
        slogan.setText("Note taking beyond knowledge.");
        slogan.setForeground(Color.BLACK);
        slogan.setFont(new Font("Helvetica Bold", Font.BOLD, 30));
        slogan.setVerticalAlignment(JLabel.CENTER);
        slogan.setHorizontalAlignment(JLabel.CENTER);
        slogan.setPreferredSize(new Dimension(500,100));
        
        leftPanel.add(slogan);
        leftPanel.add(new JLabel(noteTaking));
        
        //CENTER : GET STARTED PANEL
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(VMM_Grey);
        rightPanel.setBorder(new EmptyBorder(60, 40, 60, 40));
        
        JLabel yourLabel = new JLabel("<html>Your time. <br> Your goals. <br> You're the boss. </html>");
        yourLabel.setFont(Roboto(36));
        yourLabel.setForeground(Color.BLACK);
        yourLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        JLabel subtitleLabel = new JLabel("Start and stop when you want");
        subtitleLabel.setFont(Roboto(16));
        subtitleLabel.setForeground(VMM_Green);
        subtitleLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setFont(Roboto(16));
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setBackground(VMM_Red);
        getStartedButton.setPreferredSize(new Dimension(150, 75));
        getStartedButton.setMaximumSize(new Dimension(150, 75));
        getStartedButton.setMinimumSize(new Dimension(150, 75));
        getStartedButton.setBorderPainted(false);
        getStartedButton.setFocusPainted(false);
        getStartedButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        
        getStartedButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null,"This panel was pressed");
            }
        });
        
        JLabel agreementLabel = new JLabel("<html>By clicking \"Get Started,\" I agree to the <u>License Agreement</u> and have<br>read the <u>VMM Privacy Policy</u></html>");
        agreementLabel.setFont(Roboto(12));
        agreementLabel.setForeground(Color.WHITE);
        agreementLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        
        rightPanel.add(yourLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(subtitleLabel);
        rightPanel.add(Box.createVerticalStrut(30));
        rightPanel.add(getStartedButton);
        rightPanel.add(Box.createVerticalStrut(30));
        rightPanel.add(agreementLabel);
        rightPanel.add(Box.createVerticalStrut(25));
        
        // CENTER : ADDING TO CENTER PANEL
        centerPanel.add(leftPanel);
        centerPanel.add(rightPanel);

        frame.add(centerPanel, BorderLayout.CENTER);
        // FOOTER
        
        JPanel Footer = new JPanel(new GridBagLayout());
        Footer.setPreferredSize(new Dimension(100, 80));
        Footer.setBackground(Color.WHITE);
        Footer.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, VMM_Grey));
        add(Footer, BorderLayout.SOUTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridy = 0;

        //FOOTER: COMPANY LABEL
        
        JLabel companyLabel = new JLabel("© 2025 VMM Corporation");
        companyLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        companyLabel.setForeground(Color.DARK_GRAY);
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        Footer.add(companyLabel, gbc);
        
        // FOOTER: Social media icons
        JPanel socialPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        socialPanel.setBackground(Color.WHITE);
        
        socialPanel.add(new JLabel(twitterIcon));
        socialPanel.add(new JLabel(facebookIcon));
        socialPanel.add(new JLabel(instagramIcon));

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        Footer.add(socialPanel, gbc);

        // FOOTER : CONTACT LINKS
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 0));
        linkPanel.setBackground(Color.WHITE);

        JLabel contact = new JLabel("Contact Us");
        contact.setForeground(VMM_Green);
        contact.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contact.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel privacy = new JLabel("Privacy Policy");
        privacy.setForeground(VMM_Green);
        privacy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        privacy.setFont(new Font("SansSerif", Font.PLAIN, 14));

        linkPanel.add(contact);
        linkPanel.add(privacy);

        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        Footer.add(linkPanel, gbc);
        
        // HEADER
        
        JPanel Header = new JPanel();
        Header.setPreferredSize(new Dimension(100,100));
        Header.setBackground(Color.WHITE);
        Header.setLayout(new BorderLayout());
        
        // HEADER: LOGO
        
        JPanel Header_Left = new JPanel();
        Header_Left.setPreferredSize(new Dimension(230,80));
        Header_Left.setBackground(Color.WHITE);
        
        JLabel Header_Logo = new JLabel();
        Header_Logo.setPreferredSize(new Dimension(200,90));
        Header_Logo.setBackground(Color.WHITE);
        Header_Logo.setHorizontalAlignment(JLabel.CENTER);
        Header_Logo.setIcon(logo);
        Header_Logo.setOpaque(true);
        
        Header_Left.add(Header_Logo);

        // HEADER : CENTER BUTTONS
        
        JPanel Header_Center = new JPanel();
        Header_Center.setPreferredSize(new Dimension(230,80));
        Header_Center.setBackground(Color.WHITE);
        Header_Center.setLayout(new FlowLayout(FlowLayout.LEFT));
        Header_Center.setBorder(BorderFactory.createEmptyBorder(-5,0,-5,-5));
        
        JLabel FAQ = createHeaderButtons("FAQ");
        JLabel BLOG = createHeaderButtons("BLOG");
        JLabel ABOUT_US = createHeaderButtons("ABOUT US");
        
        Header_Center.add(FAQ);
        Header_Center.add(BLOG);
        Header_Center.add(ABOUT_US);
        
        // HEADER: SIGN OUT
        JPanel Header_Right = new JPanel();
        Header_Right.setPreferredSize(new Dimension(230,80));
        Header_Right.setBackground(Color.BLACK);
        Header_Right.setLayout(new BorderLayout());
        Header_Right.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        
        JLabel LogOut = new JLabel();
        LogOut.setBackground(Color.BLACK);
        LogOut.setVerticalAlignment(JLabel.CENTER);
        LogOut.setHorizontalAlignment(JLabel.CENTER);
        LogOut.setOpaque(true);
        LogOut.setText("Log Out");
        LogOut.setForeground(Color.LIGHT_GRAY);
        LogOut.setFont(Roboto(30));
        LogOut.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                LogOut.setBackground(Color.DARK_GRAY);
                LogOut.setForeground(Color.white);
                LogOut.repaint();
            };
            @Override
            public void mouseExited(MouseEvent e){
                LogOut.setBackground(Color.BLACK);
                LogOut.setForeground(Color.LIGHT_GRAY);
                LogOut.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                //frame.dispose();
                JOptionPane.showMessageDialog(null,"This panel was pressed");
                //panel.getComponent(0).get;
            }
        });
        
        Header_Right.add(LogOut,BorderLayout.CENTER);
        //
        Header.add(Header_Left,BorderLayout.WEST);
        Header.add(Header_Right,BorderLayout.EAST);
        Header.add(Header_Center,BorderLayout.CENTER);
        ///

        frame.add(Header,BorderLayout.NORTH);
        frame.add(Footer,BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private Font Roboto(int fontSize){
        Font Roboto = new Font("Roboto",Font.BOLD,fontSize);
        return Roboto; 
    }
        
    private JLabel createHeaderButtons(String text){
        
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(170,100));
        label.setBackground(Color.WHITE);
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
                //frame.dispose();
                
                if(label.getBackground()==Color.WHITE){
                    label.setBackground(VMM_Grey);
                    label.setForeground(VMM_Red);
                }
                else{
                    label.setBackground(Color.WHITE);
                    label.setForeground(VMM_Green);
                }
                JOptionPane.showMessageDialog(null,"This panel was pressed");
                //panel.getComponent(0).get;
            }
        });
        return label;
    }
}
