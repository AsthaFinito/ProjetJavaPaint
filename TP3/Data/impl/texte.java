package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class texte extends Shape {
    private Color couleur;

    private int X;
    private int Y;
    private String texte;

    public texte(Color couleur, Dot point) {
        super(couleur, point);
    }
    public texte(String texte,Color CouleurTexte,int X,int Y){
        super(CouleurTexte,new Dot(X,Y));
        this.couleur=CouleurTexte;
        this.X=X;
        this.Y=Y;
        this.texte=texte;

    }

    @Override
    public void setBoundingBox(int hauteur, int largeur) {

    }

    @Override
    public void setDraw(Graphics2D g) {
        g.setColor(this.couleur);
        g.drawString(this.texte,this.X,this.Y);
    }
}
