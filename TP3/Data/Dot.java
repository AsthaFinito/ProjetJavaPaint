package org.isen.volumeModel.TP3.Data;

public class Dot {

    private int x;
    private int y;

    public Dot(){
        this.x=0;
        this.y=0;
    }

    public Dot(int px, int py) {
        this.x=px;
        this.y=py;
    }

    public void SetXY(int valeurX,int valeurY){
        this.x=valeurX;
        this.y=valeurY;
    }

    public int GetX(){
        return this.x;
    }
    public int GetY(){
        return this.y;
    }

    public void AffichePoint(){
        System.out.println("Le point à pour coordonée "+this.x+" "+this.y);

    }
}
