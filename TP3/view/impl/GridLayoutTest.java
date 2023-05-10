package org.isen.volumeModel.TP3.view.impl;

import javax.swing.*;
import java.awt.*;

public class GridLayoutTest extends JFrame {
    public GridLayoutTest(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0,200);
        setSize(500,250);
        Container contentPane= getContentPane();
        JPanel pan1=new JPanel();
        pan1.setLayout(new GridLayout(1,2));
        pan1.add(new JButton("1"));
        pan1.add(new JButton("2"));
        contentPane.add(pan1,BorderLayout.SOUTH);
        contentPane.add(new JLabel("OUest"),BorderLayout.WEST);
        contentPane.add(new JCheckBox("Nord"),BorderLayout.NORTH);
        contentPane.add(new JTextArea("Centre"),BorderLayout.CENTER);
        contentPane.add(new JTextField("Est"),BorderLayout.EAST);
        setVisible(true);
    }

    public static void main(String[] args){
        new GridLayoutTest("Hello world, i'm back");
    }
}
