package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.border.LineBorder;

public class MyMessageAccept extends JDialog{
    private JLabel message = new JLabel();
    private ButtonCustomed button = new ButtonCustomed("OK");

    public MyMessageAccept(JFrame frame, String Accept){
        super(frame, true);
        getContentPane().setBackground(new java.awt.Color(248, 248, 248));
        setUndecorated(true);
        setSize(320, 200);
        setBackground(ColorUIResource.WHITE);
        
        gui gui_ = new gui();

        message.setText(Accept);
        gui_.setFont(message, 1, 15);
        gui_.setFont(button, 1, 16);
        button.setBackground(new java.awt.Color(66, 100, 255));
        
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        gb.insets = new InsetsUIResource(10, 2, 10, 2);
        gb.gridx = 0;
        gb.gridy = 0;
        add(gui_.getJLabelImage("checked.png"), gb);

        gb.gridx = 0;
        gb.gridy = 1;
        add(message, gb);

        gb.gridx = 0;
        gb.gridy = 2;
        add(button, gb);

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
        
        setLocationRelativeTo(null);
    }

}
