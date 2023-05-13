package org.isen.volumeModel.TP3.Data.impl;

import org.isen.volumeModel.TP3.Data.Dot;
import org.isen.volumeModel.TP3.Data.Shape;

import java.awt.*;

public class carre extends Shape {
    private int cote;
    private Color couleur;
    private int X;
    private int Y;
    private int opacite;

    public carre(Color couleur, int px,int py) {

        super(couleur, new Dot(px,py));
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
        this.opacite=100;
    }
    public carre(Color couleur, int px,int py,int opacite) {

        super(couleur, new Dot(px,py));
        this.X=px;
        this.Y=py;
        this.couleur=couleur;
        this.opacite=opacite;
    }

    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.cote=hauteurBB;

    }

    @Override
    public void setDraw(Graphics2D g) {
        if(this.cote<0){
            this.X=this.X+this.cote;
            this.Y=this.Y+this.cote;
            this.cote=-this.cote;
        }

        if(this.opacite==100){
            g.setColor(this.couleur);
            g.fillRect(this.X,this.Y,this.cote,this.cote);
        }
        else{
            g.setColor(this.couleur);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f)); // réglage de l'opacité à 50%
            g.fillRect(this.X,this.Y,this.cote,this.cote);
        }


    }
}
