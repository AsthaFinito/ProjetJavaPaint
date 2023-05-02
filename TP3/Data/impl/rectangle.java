package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class rectangle extends Shape {


    private Color couleur;

    private int X;
    private int Y;
    private int longeur;
    private int largeur;

    public rectangle(Color couleur, Dot point) {
        super(couleur, point);
        this.longeur=0;
        this.largeur=0;
    }

    public rectangle(Color couleur,int px,int py) {


        super(couleur,new Dot(px,py));
        this.longeur=0;
        this.largeur=0;
        this.X=px;
        this.Y=py;
        this.couleur=couleur;


    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.longeur=hauteurBB;
        this.largeur=largeurBB;
    }

    @Override
    public void setDraw(Graphics g) {

        g.setColor(this.couleur);
        g.fillRect(this.X,this.Y,this.longeur,this.largeur);

    }
}
