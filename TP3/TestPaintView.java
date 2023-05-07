package org.isen.volumeModel.TP3;

import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.model.ShapeListModel;
import org.isen.volumeModel.TP3.view.impl.MySVGEditor;
import org.isen.volumeModel.TP3.view.impl.MyShapeManager;
import org.isen.volumeModel.TP3.view.impl.PaintView;

public class TestPaintView {
    public static void main(String[] args){
        ShapeListModel ListeFigure = new ShapeListModel();
        DrawController controller = new DrawController(ListeFigure);


        //System.out.println("Apres le v.display");

        PaintView v= new PaintView("Display Draw",controller);
        MyShapeManager test= new MyShapeManager("My Shape Manager",controller,ListeFigure);
        MySVGEditor test2= new MySVGEditor("My SVG Editor",controller);
        //test.display();
        v.display();



    }
}
