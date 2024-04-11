/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;
import Model.gui;
import Model.ButtonCustomed;
import java.awt.BorderLayout;
import java.util.HashSet;
import javax.swing.JPanel;


/**
 *
 * @author Bon Nguyen
 */
public class CustomConfirmDialog extends JDialog{
    private gui gui_ = new gui();
    private JLabel mess;
    private JLabel details;
    private JLabel image;
    private JPanel panel;
    private ButtonCustomed btn1 = new ButtonCustomed();
    private ButtonCustomed btn2 = new ButtonCustomed();
    private boolean selected;
    
    public CustomConfirmDialog(JFrame frame, String title, String text, String icon){
        super(frame, true);
        getContentPane().setBackground(Color.white);
        mess = new JLabel(title);
        details = new JLabel(text);
        image = gui_.getJLabelImage(icon);
        setup();
    }

    private void setup(){
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();

        setSize(400, 220);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        gb.insets = new InsetsUIResource(2, 2, 10, 2);
        image.setSize(new DimensionUIResource(100, 110));
        gb.gridx = 0;
        gb.gridy = 0;
        gb.gridwidth = 4;
        
        image.setHorizontalAlignment(SwingConstants.CENTER);
        add(image, gb);

        mess.setForeground(new ColorUIResource(112, 49, 145));
        gui_.setFont(mess, 1, 20);
        gb.gridx = 0;
        gb.gridy = 1;
        gb.gridwidth = 4;
        
        mess.setSize(new DimensionUIResource(100, 110));
        mess.setHorizontalAlignment(SwingConstants.CENTER);
        add(mess, gb);

        gui_.setFont(details, 0, 16);
        gb.gridx = 0;
        gb.gridy = 2;
        gb.gridwidth = 4;
        gb.gridheight = 3;
        
        details.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(details, gb);
    
        btn1.setText("YES");
        btn2.setText("NO");
        gui_.setFont(btn1, 1, 14);
        gui_.setFont(btn2, 1, 14);

        btn1.setBackground(Color.BLUE);
        btn2.setBackground(Color.RED);
        btn1.setPreferredSize(new DimensionUIResource(175, 40));
        btn2.setPreferredSize(new DimensionUIResource(175, 40));
        btn1.setFocusPainted(false);
        btn2.setFocusPainted(false);

        gb.gridx = 0;
        gb.gridy = 5;
        gb.gridwidth = 2;
        
        add(btn1, gb);

        gb.gridx = 2;
        gb.gridy = 5;
        gb.gridwidth = 2;
        
        add(btn2, gb);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = true;
                dispose();
            }
        });

        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                selected = false;
                dispose();
            }
        });
        
        setLocationRelativeTo(null);
    }
    public boolean getSelected(){
        return selected;
    }
}

