package org.isen.volumeModel.TP3;

import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.model.ShapeListModel;
import org.isen.volumeModel.TP3.view.impl.PaintView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPaintView {
    public static void main(String[] args){
        ShapeListModel ListeFigure = new ShapeListModel();
        DrawController controller = new DrawController(ListeFigure);
        PaintView v= new PaintView("Display Draw",controller);
        v.display();

    }
}