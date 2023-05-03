package org.isen.volumeModel.TP3.view.impl;



import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.model.ShapeListModel;
import org.isen.volumeModel.TP3.view.IDrawView;
import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.view.impl.Dessin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
public class MyShapeManager extends JFrame implements ActionListener,IDrawView {

    private  ShapeListModel shapeListModel;
    //private final JList<String> shapeList;
  //  private final JButton removeButton;
    private DrawController controller;
    private  Dessin dessin;

    public MyShapeManager(String title,DrawController controller,ShapeListModel shapeListModel) {
        super(title);
        this.shapeListModel = shapeListModel;



        this.controller=controller;
        this.dessin = new Dessin(this.controller);
        this.controller.RegisterView(this);
        setLocation(500,500);
        setSize(500,500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Création de la liste de formes
        JList<Object> shapeList = new JList<>();
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(shapeList);
        add(scrollPane);

        // Création du bouton remove
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        add(removeButton);
    }

    // Met à jour la liste de formes affichée


    @Override
    public void display() {
        setVisible(true);
        System.out.println("Affichage de le deuxième fenetre? ");
    }

    @Override
    public void close() {
        setVisible(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}