package org.isen.volumeModel.TP3.view.impl;

import org.isen.volumeModel.TP3.Data.Shape;
import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.view.IDrawView;

import java.awt.*;
import java.beans.PropertyChangeEvent;

public class TestView implements IDrawView {

    private DrawController controller;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("PropertyChange in testView");
    }
    public TestView(DrawController DC){
        this.controller=DC;
        controller.RegisterView(this);
    }


    @Override
    public void display() {
        System.out.println("display in testView");
    }

    @Override
    public void close() {
        System.out.println("close in testView");
    }


}
