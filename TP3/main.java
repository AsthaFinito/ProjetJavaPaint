package org.isen.volumeModel.TP3;

import org.isen.volumeModel.TP3.Data.impl.carre;
import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.model.ShapeListModel;
import org.isen.volumeModel.TP3.view.impl.TestView;

public class main {
    public static void main(String[] args){
        System.out.println("go");
        ShapeListModel model_test=new ShapeListModel();
        DrawController ControllerTest=new DrawController(model_test);

        TestView testView= new TestView(ControllerTest);
       // ControllerTest.AddShapeController(new shape());
    }
}
