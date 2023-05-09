package org.isen.volumeModel.TP3.view.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.Data.impl.carre;
import org.isen.volumeModel.TP3.Data.impl.cercle;
import org.isen.volumeModel.TP3.Data.impl.ellipse;
import org.isen.volumeModel.TP3.Data.impl.rectangle;
import org.isen.volumeModel.TP3.controller.DrawController;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import static java.lang.Math.abs;


public class Dessin extends JPanel implements MouseListener, MouseMotionListener {
    private ArrayList<Shape> Shapes;
    private Color CurrentColor;
    private String Current_ShapeName;
    private int XSouris;
    private int YSouris;
    private DrawController controller;
    private Shape currentShape;



    public Dessin(DrawController c) {
      //  super(); // appel au constructeur par défaut de la super-classe
        this.CurrentColor=Color.black;
        this.Current_ShapeName="";
        addMouseListener(this);
        addMouseMotionListener(this);
        this.Shapes=new ArrayList<>();
        this.controller=c;
        this.currentShape=null;

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // appel à la méthode paintComponent() de la super-classe

        // Imposer la couleur du fond à blanc
        this.setBackground(Color.WHITE);

        // Dessiner un rectangle plein en rouge
        //g.setColor(Color.RED);
        //g.fillRect(50, 50, 100, 100);
        for(Shape S : Shapes){
            //System.out.println("Dans le for de dessin ");
            S.setDraw((Graphics2D) g);
        }

    }
    public void ChangeColor(Color NewColor){
        this.CurrentColor=NewColor;
    }
    public void ChangeStringShape(String NewString){
        this.Current_ShapeName=NewString;
    }

    public ArrayList<Shape> ReturnShapeListe(){

        return this.Shapes;
    }
    public void ReturnShapeName(){

        System.out.println("Nom de la shape : "+this.Current_ShapeName);
    }
    public void ReturnColor(){

        System.out.println("Couleur de la shape : "+this.CurrentColor);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Detection appuie de souris");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Detection lacher de souris");
        this.XSouris=e.getX();
        this.YSouris=e.getY();
        System.out.println("Souris au co :"+this.XSouris+" "+ this.YSouris);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Detection lacher de souris");
        int SourisX_Lache=e.getX();
        int SourisY_Lache=e.getY();
        int deplacementX=SourisX_Lache-this.XSouris;
        int deplacementY=SourisY_Lache-this.YSouris;


       // System.out.println("Valeur du deplacement : En X et En Y "+deplacementX+" "+deplacementY);
        if(Current_ShapeName.equals("Rectangle")){

            this.currentShape=new rectangle(CurrentColor,XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);


        } else if (Current_ShapeName.equals("Carre"))
        {
            System.out.println("Dans le carré?");
          //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new carre(CurrentColor,XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }else if (Current_ShapeName.equals("Cercle"))
        {
            System.out.println("Dans le cercle?");
            //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new cercle(CurrentColor,XSouris,YSouris,deplacementX);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }else if (Current_ShapeName.equals("Elipse"))
        {
            System.out.println("Dans l'elipse?");
            //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new ellipse(CurrentColor, XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        System.out.println("Detection lacher de souris");
        int SourisX_Lache=e.getX();
        int SourisY_Lache=e.getY();
            int deplacementX=SourisX_Lache-this.XSouris;
        int deplacementY=SourisY_Lache-this.YSouris;
        System.out.println("deplacementX -> "+deplacementX);
        System.out.println("deplacementY -> "+deplacementY);
        if(this.currentShape!=null){
            this.controller.RemoveShapeController(this.currentShape);
        }
        // System.out.println("Valeur du deplacement : En X et En Y "+deplacementX+" "+deplacementY);
        if(Current_ShapeName.equals("Rectangle")){

            this.currentShape=new rectangle(CurrentColor,XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);



        } else if (Current_ShapeName.equals("Carre"))
        {
            System.out.println("Dans le carré?");
            //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new carre(CurrentColor,XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }else if (Current_ShapeName.equals("Cercle"))
        {
            System.out.println("Dans le cercle?");
            //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new cercle(CurrentColor,XSouris,YSouris,deplacementX);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }else if (Current_ShapeName.equals("Elipse"))
        {
            System.out.println("Dans l'elipse?");
            //  Dot coo= new Dot(XSouris,YSouris);

            this.currentShape=new ellipse(CurrentColor, XSouris,YSouris);
            this.currentShape.setBoundingBox(deplacementX,deplacementY);
            this.controller.AddShapeController(this.currentShape);
            //Shapes.add(test);
            //repaint();
            //System.out.println("Fin d'ajout normalement -> "+Shapes.size());


        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("Detection déplacement de souris");
    }

    public void setShape(ArrayList<Shape> shapes) {
        this.Shapes = shapes;
    }



}