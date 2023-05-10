package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class triangle extends Shape {
    private Color FillColor;
    private int X1;
    private int X2;
    private int X3;
    private int Y1;
    private int Y2;
    private int Y3;

    public triangle(Color couleur, Dot point) {
        super(couleur, point);
    }
    public triangle(Color FillColor,int X1,int X2,int X3,int Y1,int Y2,int Y3){
        super(FillColor, new Dot(1,1));
        this.FillColor=FillColor;
        this.X1=X1;
        this.X2=X2;
        this.X3=X3;
        this.Y1=Y1;
        this.Y2=Y2;
        this.Y3=Y3;

    }

    @Override
    public void setBoundingBox(int hauteur, int largeur) {

    }

    @Override
    public void setDraw(Graphics2D g) {
        System.out.println("Dans le setDraw");
        int[] xPoints = { this.X1, this.X2, this.X3 };
        int[] yPoints = { this.Y1, this.Y2, this.Y3 };
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g.setColor(this.FillColor);
        g.fillPolygon(triangle);
    }
}
