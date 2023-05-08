package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class carre extends Shape {
    private int cote;
    private Color couleur;
    private int X;
    private int Y;

    public carre(Color couleur, int px,int py) {

        super(couleur, new Dot(px,py));
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.cote=hauteurBB;

    }

    @Override
    public void setDraw(Graphics2D g) {

        g.setColor(this.couleur);
        g.fillRect(this.X,this.Y,this.cote,this.cote);

    }
}
