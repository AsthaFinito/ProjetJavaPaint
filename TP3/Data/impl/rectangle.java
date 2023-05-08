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
    private Color stroke_color;
    private int stroke_width;

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
        this.stroke_color=couleur;


    }
    public rectangle(Color couleur,int px,int py,Color StrokeColor,int stroke_width) {


        super(couleur,new Dot(px,py));
        this.longeur=0;
        this.largeur=0;
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
        this.stroke_color=StrokeColor;
        this.stroke_width=stroke_width;


    }
    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.longeur=hauteurBB;
        this.largeur=largeurBB;
    }


    @Override
    public void setDraw(Graphics2D g) {

        g.setColor(this.couleur);
        g.fillRect(this.X,this.Y,this.longeur,this.largeur);
        g.setColor(this.stroke_color);
        g.setStroke(new BasicStroke(this.stroke_width));
        g.drawRect(this.X,this.Y,this.longeur,this.largeur);

    }
}
