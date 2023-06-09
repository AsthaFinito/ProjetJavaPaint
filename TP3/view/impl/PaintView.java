package org.isen.volumeModel.TP3.view.impl;

import org.isen.volumeModel.TP3.controller.DrawController;
import org.isen.volumeModel.TP3.view.IDrawView;
import org.isen.volumeModel.TP3.Data.Shape;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;

public class PaintView extends JFrame implements IDrawView,ActionListener  {
    @Override
    public void display() {
        setVisible(true);
    }

    private Dessin dessin;
    private DrawController controller;
    int test_shapeManager;
    int test_SVGEditor;

    @Override
    public void close() {
        setVisible(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("PropertyChangeEvent -> "+evt);
        if(evt.getPropertyName().equals("shapelist")){
            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }
        else if(evt.getPropertyName().equals("RemoveShapes")){

            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }
        else if(evt.getPropertyName().equals("RemoveAllShapes")){

            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }
        else if(evt.getPropertyName().equals("AddShapes")){

            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }
        else if(evt.getPropertyName().equals("DisplayShapeManager")){

            //test.display();
        }


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        if(cmd.equals("Sud")){

            System.out.println("Bouton presse = +"+cmd);
        } else if (cmd.equals("Quit")) {
            System.exit(0);
        }
        else if(cmd.equals("Rectangle")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Rectangle");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Déplacement")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Déplacement");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Triangle")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Triangle");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Cercle")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Cercle");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Elipse")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Elipse");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Carré")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeStringShape("Carre");
            dessin.ReturnShapeName();
        }
        else if(cmd.equals("Green")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.GREEN);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Yellow")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.YELLOW);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Orange")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.ORANGE);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Red")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.RED);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Black")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.BLACK);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Magenta")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.MAGENTA);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Blue")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.BLUE);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Pink")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.PINK);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Gray")){

            System.out.println("Bouton presse = +"+cmd);
            dessin.ChangeColor(Color.GRAY);
            dessin.ReturnColor();
        }
        else if(cmd.equals("Nouveau")){
            System.out.println("Bouton presse = +"+cmd);


            controller.RemoveAllShapeController();
        }
        else if(cmd.equals("Auteurs")){
            System.out.println("Bouton presse = +"+cmd);
            JOptionPane.showMessageDialog(null, "Pourquoi les plongeurs plongent-ils toujours en arrière et jamais en avant ?\nParce que sinon ils tombent dans le bateau !", "Blague", JOptionPane.PLAIN_MESSAGE);


        }
        else if(cmd.equals("ShapeManager")){

            System.out.println("Valeur du i dans le shapeManager :"+test_shapeManager);
            if(test_shapeManager%2==0){
                controller.DisplayViewShapeManager();
                test_shapeManager=test_shapeManager+1;
            }
            else{
                controller.CloseViewShapeManager();
                test_shapeManager=test_shapeManager+1;
            }


        }
        else if(cmd.equals("SvgEditor")){

            System.out.println("Apparition du SvgEditor");
            if(test_SVGEditor%2==0){
                controller.DisplayViewSvg();
                test_SVGEditor=test_SVGEditor+1;
            }
            else{
                controller.CloseViewSvg();
                test_SVGEditor=test_SVGEditor+1;
            }



        }
        else{
            System.err.println(cmd);
        }
    }




    public PaintView(String title,DrawController controller){
        super(title);
        this.controller=controller;
        this.dessin = new Dessin(this.controller);
        this.controller.RegisterView(this);
        test_shapeManager=0;
        setLocation(0,0);
        setSize(1280,760);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane=getContentPane();
        JMenuBar m = new JMenuBar();
        JMenu FichierSauvegarde = new JMenu("Fichier");

        JMenuItem Nouveau = new JMenuItem("Nouveau");
        Nouveau.addActionListener(this);
        JMenuItem OuvrirMenu = new JMenuItem("Ouvrir");
        JMenuItem EnregistrerMenu = new JMenuItem("Enregistrer");
        JMenuItem QuitterMenu = new JMenuItem("Quitter");
        FichierSauvegarde.add(Nouveau);
        FichierSauvegarde.add(OuvrirMenu);
        FichierSauvegarde.add(EnregistrerMenu);
        FichierSauvegarde.addSeparator();
        FichierSauvegarde.add(QuitterMenu);
        Nouveau.setAccelerator(KeyStroke.getKeyStroke('U', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(), false));




        JMenu APropos = new JMenu("APropos");
        JMenuItem Auteurs = new JMenuItem("Auteurs");
        Auteurs.addActionListener(this);
        APropos.add(Auteurs);
        m.add(FichierSauvegarde);
        m.add(APropos);
        JMenu Vues = new JMenu("Vues");
        JCheckBox ShapeManager = new JCheckBox("ShapeManager");
        JCheckBox SvgEditor = new JCheckBox("SvgEditor");

        ShapeManager.addActionListener(this);
        SvgEditor.addActionListener(this);
        Vues.add(ShapeManager);
        Vues.add(SvgEditor);
        m.add(Vues);


        setJMenuBar(m);
        contentPane.add(this.dessin,BorderLayout.CENTER);
        JPanel pan1=new JPanel();
        JPanel PanelCouleur=new JPanel();
        JPanel PanelForme=new JPanel();
        pan1.setLayout(new GridLayout(1,2));
        pan1.setPreferredSize(new Dimension(1280,125));

        PanelCouleur.setLayout(new GridLayout(2,4));
        PanelCouleur.setPreferredSize(new Dimension(540,100));
        PanelForme.setLayout(new GridLayout(2,2));
        PanelForme.setPreferredSize(new Dimension(320,100));

        JButton BoutonGris=new JButton("Gray");
        BoutonGris.setBackground(Color.GRAY);
        BoutonGris.addActionListener(this);
        PanelCouleur.add(BoutonGris);

        JButton BoutonBlack=new JButton("Black");
        BoutonBlack.setBackground(Color.black);
        BoutonBlack.addActionListener(this);
        PanelCouleur.add(BoutonBlack);

        JButton BoutonRed=new JButton("Red");
        BoutonRed.setBackground(Color.red);
        BoutonRed.addActionListener(this);
        PanelCouleur.add(BoutonRed);

        JButton BoutonGreen=new JButton("Green");
        BoutonGreen.setBackground(Color.green);
        BoutonGreen.addActionListener(this);
        PanelCouleur.add(BoutonGreen);

        JButton BoutonBlue=new JButton("Blue");
        BoutonBlue.setBackground(Color.blue);
        BoutonBlue.addActionListener(this);
        PanelCouleur.add(BoutonBlue);

        JButton BoutonYellow=new JButton("Yellow");
        BoutonYellow.setBackground(Color.yellow);
        BoutonYellow.addActionListener(this);

        PanelCouleur.add(BoutonYellow);

        JButton BoutonPink=new JButton("Pink");
        BoutonPink.setBackground(Color.pink);
        BoutonPink.addActionListener(this);
        PanelCouleur.add(BoutonPink);

        JButton BoutonMagenta=new JButton("Magenta");
        BoutonMagenta.setBackground(Color.magenta);
        BoutonMagenta.addActionListener(this);
        PanelCouleur.add(BoutonMagenta);

        JButton BoutonOrange=new JButton("Orange");
        BoutonOrange.setBackground(Color.orange);
        BoutonOrange.addActionListener(this);
        PanelCouleur.add(BoutonOrange);

        pan1.add(PanelCouleur);


        JButton BoutonElipse=new JButton("Elipse");
        BoutonElipse.addActionListener(this);
        PanelForme.add(BoutonElipse);

        JButton BoutonCercle=new JButton("Cercle");
        BoutonCercle.addActionListener(this);
        PanelForme.add(BoutonCercle);

        JButton BouttonCarré=new JButton("Carré");
        BouttonCarré.addActionListener(this);
        PanelForme.add(BouttonCarré);

        JButton BouttonTriangle=new JButton("Triangle");
        BouttonTriangle.addActionListener(this);
        PanelForme.add(BouttonTriangle);

        JButton BoutonRectangle=new JButton("Rectangle");
        BoutonRectangle.addActionListener(this);
        PanelForme.add(BoutonRectangle);

        JButton BouttonDeplacement=new JButton("Déplacement");
        BouttonDeplacement.addActionListener(this);
        PanelForme.add(BouttonDeplacement);

        pan1.setLayout(new FlowLayout());
        pan1.add(PanelForme);


        contentPane.add(pan1,BorderLayout.SOUTH);



    }

}
