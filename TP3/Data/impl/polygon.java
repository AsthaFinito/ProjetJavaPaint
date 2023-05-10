package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Polygon;


public class polygon extends Shape {
    private Color FillColor;
    private String ListePoint;
    private int widthStroke;
    private Color StrokeColor;
    public polygon(Color couleur, Dot point) {
        super(couleur, point);

    }
    public polygon(Color couleurFill,Color ColorStroke,int widthStroke,String ListePoint) {
        super(new Dot(1,1));
        this.FillColor=couleurFill;
        this.StrokeColor=ColorStroke;
        this.ListePoint=ListePoint;
        this.widthStroke=widthStroke;

    }

    @Override
    public void setBoundingBox(int hauteur, int largeur) {

    }

    @Override
    public void setDraw(Graphics2D g) {
        System.out.println("Dessin du polygone");

        String[] pointValues = this.ListePoint.split("\\s+|,");
        int numPoints = pointValues.length / 2;
        int[] xPoints = new int[numPoints];
        int[] yPoints = new int[numPoints];

        for (int i = 0; i < numPoints; i++) {
            xPoints[i] = (int) Math.round(Double.parseDouble(pointValues[i * 2]));
            yPoints[i] = (int) Math.round(Double.parseDouble(pointValues[i * 2 + 1]));
        }

        g.setColor(this.FillColor);
        g.fillPolygon(xPoints, yPoints, numPoints);
        g.setStroke(new BasicStroke(this.widthStroke));
        g.setColor(this.StrokeColor);
        g.drawPolygon(xPoints, yPoints, numPoints);
    }
}
