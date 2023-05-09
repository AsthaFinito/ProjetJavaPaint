package org.isen.volumeModel.TP3.model;

import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.view.IDrawView;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

import java.util.ArrayList;
import java.util.List;



public class ShapeListModel {

    private int id;
    private int colorFigure;
    private  PropertyChangeSupport TestPCS;

    private List<Shape> ListeShape;
    public ShapeListModel(){
        TestPCS= new PropertyChangeSupport(this);
        ListeShape=new ArrayList();
    }
    public void register(PropertyChangeListener AttenteEvent){
        TestPCS.addPropertyChangeListener(AttenteEvent);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setColor(int color) {
        this.colorFigure = color;
    }
    public void AfficheCaracteristique(){
        System.out.println("Voici les caractéristiques de la figure :");
        System.out.println("    Couleurs :"+this.colorFigure);
        System.out.println("    Id :"+this.id);
    }

    public void AddShape(Shape S){

        this.ListeShape.add(S);
        TestPCS.firePropertyChange("AddShapes",null,ListeShape);

    }

    public void RemoveShape(Shape S){

        //int index=this.ListeShape.indexOf(S);
        this.ListeShape.remove(S);
        TestPCS.firePropertyChange("RemoveShapes",null,ListeShape);

    }

    public void RemovesAllShapes(){
        this.ListeShape.clear();
        TestPCS.firePropertyChange("RemoveAllShapes",null,ListeShape);
    }
    public List<Shape> getShapes() {
        return ListeShape;
    }


    public void clear() {
        this.ListeShape.clear();
        this.TestPCS.firePropertyChange("clearShape",null, this.ListeShape);
    }

    public void DisplayShapeManager() {
        this.TestPCS.firePropertyChange("DisplayShapeManager",null, this.ListeShape);
    }

    public void AddShapeSVG(Shape test) {
        this.ListeShape.add(test);
        TestPCS.firePropertyChange("AddShapesSVG",null,ListeShape);
    }

    public void RemovesAllShapesSVG() {
        this.ListeShape.clear();
        TestPCS.firePropertyChange("RemoveAllShapesSVG",null,ListeShape);
    }
}

