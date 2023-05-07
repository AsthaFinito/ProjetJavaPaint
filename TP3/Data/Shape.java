package org.isen.volumeModel.TP3.Data;

import java.awt.*;

public abstract class Shape {

    private Color couleur;



    private Dot point;



    public Shape(Color couleur,Dot point) {
        this.couleur = couleur;
        this.point=point;


    }
    public Shape(Dot point) {
        this.point=point;
        this.couleur=Color.BLACK;
    }
    public Shape(String texte,Color CouleurTexte,int X,int Y) {

        this.couleur=CouleurTexte;
    }



    public Color getCouleur() {
        return couleur;
    }

    public Dot getPoint() {
        return point;
    }

    public abstract void setBoundingBox(int hauteur, int largeur);

    public abstract void setDraw(Graphics g);





}
