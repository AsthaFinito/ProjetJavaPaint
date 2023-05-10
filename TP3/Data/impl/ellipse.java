package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;


public class ellipse extends Shape {

    private  int opacite;
    private int grandAxe;
    private int petitAxe;
    private int X;
    private int Y;
    private Color couleur;
    public ellipse(Color couleur, Dot point) {
        super(couleur, point);

    }
    public ellipse(Color couleur,int px,int py) {



        super(couleur,new Dot(px,py));
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
        this.opacite=100;
    }
    public ellipse(Color couleur,int px,int py,int opacite) {



        super(couleur,new Dot(px,py));
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
        this.opacite=opacite;
    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.grandAxe=hauteurBB;
        this.petitAxe=largeurBB;
    }
    @Override
    public void setDraw(Graphics2D g) {
        if(opacite==100){
            g.setColor(this.couleur);
            g.fillOval(this.X,this.Y,this.petitAxe,this.grandAxe);
        }
        else{
            g.setColor(this.couleur);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // réglage de l'opacité à 50%
            g.fillOval(this.X,this.Y,this.petitAxe,this.grandAxe);
        }


    }
}