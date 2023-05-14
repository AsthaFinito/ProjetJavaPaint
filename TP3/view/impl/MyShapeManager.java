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

    private DefaultListModel<Shape> listModel;
    private JList<Shape> list;
    private JButton deleteButton;

    public MyShapeManager(String title,DrawController controller,ShapeListModel shapeListModel) {
        super(title);
        this.controller = controller;
        this.controller.RegisterView(this);


        this.listModel = new DefaultListModel<>();
        this.list = new JList<>(listModel);
        this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(list);
        getContentPane().add(listScrollPane, BorderLayout.CENTER);
        this.deleteButton = new JButton("Delete");
        this.deleteButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(500,500);

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
        //System.out.println("propertyChange dans le shapeManager");
        if(evt.getPropertyName().equals("AddShapes")){
            Object data = evt.getNewValue();
            if (data instanceof List){
                List<Shape> shapes = (List<Shape>) data;
                this.listModel.clear();
                for (Shape shape : shapes) {
                    this.listModel.addElement(shape);
                }
            }
        }
        else if (evt.getPropertyName().equals("RemoveShapes")) {

            this.listModel.clear();
            Object data = evt.getNewValue();
            List<Shape> shapes = (List<Shape>) data;
            for (Shape shape : shapes) {
                this.listModel.addElement(shape);
            }
        }
        else if (evt.getPropertyName().equals("RemoveAllShapes")) {

            this.listModel.clear();
            Object data = evt.getNewValue();
            List<Shape> shapes = (List<Shape>) data;
            for (Shape shape : shapes) {
                this.listModel.addElement(shape);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==deleteButton){
            System.out.println("Supression en cours");
            if(list == null){
                System.out.println("Impossible");
            }
            else{
                int index=list.getSelectedIndex();
                controller.RemoveShapeController(listModel.get(index));
            }
        }

    }
}