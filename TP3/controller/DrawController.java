package org.isen.volumeModel.TP3.controller;

import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.Data.impl.carre;
import org.isen.volumeModel.TP3.view.IDrawView;
import org.isen.volumeModel.TP3.model.ShapeListModel;

import java.util.ArrayList;
import java.util.List;

public class DrawController{

    private ShapeListModel DrawController_SLM;
    private List<IDrawView> DrawController_View;

    public DrawController(ShapeListModel SLM){
        this.DrawController_SLM=SLM;  // Modele
        this.DrawController_View= new ArrayList<IDrawView>(); // View
    }
    public void RegisterView(IDrawView IDV){
        DrawController_View.add(IDV);
        DrawController_SLM.register(IDV);
    }

    public void AddShapeController(Shape S){
            DrawController_SLM.AddShape(S);

    }

    public void RemoveShapeController(Shape S){
        DrawController_SLM.RemoveShape(S);

    }
    public void RemoveAllShapeController(){
        DrawController_SLM.RemovesAllShapes();

    }
    public void DisplayViewShapeManager(){
        DrawController_SLM.DisplayShapeManager();

    }
    public void CloseViewShapeManager(){

    }

    public void DisplayView(){
        for(IDrawView v :DrawController_View){
            v.display();
        }
    }

    public void CloseView(){
        int i = 0;
        System.out.println("Dans le close view");
        for(IDrawView v : DrawController_View){
            if(i == 1){
                v.close(); // Ferme la deuxième vue
                break; // Sort de la boucle après avoir fermé la deuxième vue
            }
            i++; // Incrémente le compteur à chaque tour de boucle
        }
    }


}
