package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;


public class ellipse extends Shape {

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
    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.grandAxe=hauteurBB;
        this.petitAxe=largeurBB;
    }
    @Override
    public void setDraw(Graphics g) {
        g.setColor(this.couleur);
        g.fillOval(this.X,this.Y,this.petitAxe,this.grandAxe);

    }
}