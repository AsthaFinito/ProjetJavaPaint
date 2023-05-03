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
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class MyShapeManager extends JFrame implements ActionListener,IDrawView, PropertyChangeListener {

    private  ShapeListModel shapeListModel;

    //private final JList<String> shapeList;
  //  private final JButton removeButton;
    private DrawController controller;
    private  Dessin dessin;

    public MyShapeManager(String title,DrawController controller,ShapeListModel shapeListModel) {
        super(title);
        this.shapeListModel = shapeListModel;
        this.controller = controller;
        this.dessin = new Dessin(this.controller);
        this.controller.RegisterView(this);

        setLocation(500, 500);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Création de la liste de formes
        JList<Shape> shapeList = new JList<>();
        //shapeList.setModel(shapeListModel);
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(shapeList);

        // Création du bouton remove
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(this);

        // Ajout des composants à la fenêtre
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(removeButton, BorderLayout.SOUTH);
        setContentPane(contentPane);
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
    public void propertyChange(PropertyChangeEvent e) {

        System.out.println("PropertyChangeEvent mais dans le shapeManager -> "+e);
        //System.out.println("Affichage de l'event-> "+e.getPropertyName());
        if(e.getPropertyName().equals("AddShapes")){
            System.out.println("PropertyChangeEvent rentré dans le if ");
            Object data = e.getNewValue();
            if (data instanceof List){
                System.out.println("deuxième if ok ");
                List<Shape> shapes = (List<Shape>) data;
                this.shapeListModel.clear();
                for (Shape shape : shapes) {
                    this.shapeListModel.AddShape(shape);
                }
            }
        }
        else{
            System.out.println("test+"+this.shapeListModel);
            System.out.println("Pas d'actions reconnues (mais bien detectée) "+e);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}