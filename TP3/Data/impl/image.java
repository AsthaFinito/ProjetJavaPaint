package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import javax.swing.*;
import java.awt.*;

public class image extends Shape {

    private int X;
    private int Y;
    private Image image;

    public image(Dot point) {
        super(point);
    }
    public image(int x,int y) {
        super(new Dot(x,y));
        this.X=x;
        this.Y=y;
        ImageIcon test=new ImageIcon("src/org/isen/volumeModel/TP3/Data/impl/isen.jpg");
        System.out.println("Pas d'erreur dans le chargement du constructeur Image");
        this.image=test.getImage();

    }

    @Override
    public void setBoundingBox(int hauteur, int largeur) {

    }

    @Override
    public void setDraw(Graphics2D g) {
        g.drawImage(this.image,X,Y,null);
    }
}
