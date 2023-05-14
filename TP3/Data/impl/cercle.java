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
    private Color stroke_color;
    private int stroke_width;
    private int opacite;
    public cercle(Color couleur,int px,int py,int rayon) {
        super(couleur, new Dot(px,py));
        this.couleur = couleur;
        this.rayon = rayon;
        this.X=px;
        this.Y=py;
        this.opacite=100;
    }
    public cercle(Color couleur,int px,int py,int rayon,int opacite) {
        super(couleur, new Dot(px,py));
        this.couleur = couleur;
        this.rayon = rayon;
        this.X=px;
        this.Y=py;
        this.opacite=opacite;
    }

    public cercle(Color couleur, Dot point) {
        super(couleur, point);
    }

    public cercle(Color couleur,int px,int py,int rayon,Color stroke_color,int stroke_width) {

        super(couleur, new Dot(px,py));
        this.couleur = couleur;
        this.rayon = rayon;
        this.X=px;
        this.Y=py;
        this.stroke_color=stroke_color;
        this.stroke_width=stroke_width;
        this.opacite=100;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.cote=hauteurBB;

    }

    @Override
    public void setDraw(Graphics2D g) {
        if(this.rayon<0){
            this.X=this.X+this.rayon;
            this.Y=this.Y+this.rayon;
            this.rayon=-this.rayon;
        }
        if(opacite==100){
            g.setColor(this.couleur);
            g.fillOval(this.X,this.Y,this.rayon,this.rayon);
            g.setColor(this.stroke_color);
            g.setStroke(new BasicStroke(this.stroke_width));
            g.drawOval(this.X,this.Y,this.rayon,this.rayon);
        }
        else{
            g.setColor(this.couleur);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // réglage de l'opacité à 50%
            g.fillOval(this.X,this.Y,this.rayon,this.rayon);
        }



    }
}
