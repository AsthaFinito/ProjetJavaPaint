package org.isen.volumeModel.TP3.view;

import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.model.ShapeListModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.List;

public class MyShapeManager extends JPanel implements ActionListener,IDrawView {

    private final ShapeListModel shapeListModel;
    private final JList<String> shapeList;
    private final JButton removeButton;

    public MyShapeManager(ShapeListModel shapeListModel) {
        this.shapeListModel = shapeListModel;

        // Création de la liste de formes
        shapeList = new JList<>();
        shapeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(shapeList);
        add(scrollPane);

        // Création du bouton remove
        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        add(removeButton);
    }

    // Met à jour la liste de formes affichée
    public void updateShapeList() {
        List<org.isen.volumeModel.TP3.Data.Shape> shapes = shapeListModel.getShapes();
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Shape shape : shapes) {
            model.addElement(shape.getClass().getSimpleName());
        }
        shapeList.setModel(model);
    }

    // Réagit au clic sur le bouton remove
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
            int index = shapeList.getSelectedIndex();
            if (index >= 0) {
               // shapeListModel.RemoveShape(index);
            }
        }
    }

    @Override
    public void display() {
        setVisible(true);
    }

    @Override
    public void close() {
        setVisible(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}