package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class cercle extends Shape {
    private int cote;
    private Color couleur;
    private int X;
    private int Y;
    private int rayon;

    public cercle(Color couleur,int px,int py,int rayon) {
        super(couleur, new Dot(px,py));
        this.couleur = couleur;
        this.rayon = rayon;
        this.X=px;
        this.Y=py;
    }

    public cercle(Color couleur, Dot point) {
        super(couleur, point);
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.cote=hauteurBB;

    }

    @Override
    public void setDraw(Graphics g) {

        g.setColor(this.couleur);
        g.fillOval(this.X,this.Y,this.rayon,this.rayon);

    }
}