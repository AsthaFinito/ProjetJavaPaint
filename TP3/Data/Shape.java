package org.isen.volumeModel.TP3.Data;

import java.awt.*;

public abstract class Shape {

    private Color couleur;



    private Dot point;
    protected int longeur;
    protected int largeur;



    public Shape(Color couleur,Dot point) {
        this.couleur = couleur;
        this.point=point;


    }
    public void setWidth(int width) {
        this.longeur = width;
    }

    public void setHeight(int height) {
        this.largeur = height;
    }
    public Shape(Color couleur,Dot point,int longeur,int largeur) {
        this.couleur = couleur;
        this.point=point;
        this.longeur=longeur;
        this.largeur=largeur;


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




    public abstract void setDraw(Graphics2D g);

    public int getX() {
        return this.point.GetX();
    }
    public int getY() {
        return this.point.GetY();
    }

    public boolean isOnShape(int mouseX, int mouseY) {

        int shapeX = this.getX();
        int shapeY = this.getY();
        int shapeWidth = this.getWidth();
        int shapeHeight = this.getHeight();
        System.out.println("Taille de la figure :"+shapeWidth+" "+ shapeHeight);
        if (mouseX >= shapeX && mouseX <= shapeX + shapeWidth && mouseY >= shapeY && mouseY <= shapeY + shapeHeight) {
            return true;
        }
        return false;
    }

    private int getHeight() {
        return this.longeur;
    }

    private int getWidth() {
        return this.largeur;
    }

    public void setXY(int x,int y) {
        this.point.SetXY(x,y);
        System.out.println("Nouvelle co :"+this.point.GetX()+" "+ this.point.GetY());
    }
}
