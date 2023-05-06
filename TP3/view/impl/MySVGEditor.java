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
public class MySVGEditor extends JFrame implements IDrawView,ActionListener {
    private DrawController controller;
    private Dessin dessin;
    public MySVGEditor(String title, DrawController controller){
        super(title);
        this.controller=controller;
        this.controller.RegisterView(this);
        this.dessin = new Dessin(this.controller);
        setLocation(0,0);
        setSize(1280,760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)  ;
        Container contentPane=getContentPane();
        JMenuBar m = new JMenuBar();
        JMenu FichierSauvegarde = new JMenu("Fichier");
        JMenuItem OuvrirMenu = new JMenuItem("Ouvrir");
        JMenuItem EnregistrerMenu = new JMenuItem("Enregistrer");
        FichierSauvegarde.add(OuvrirMenu);
        FichierSauvegarde.add(EnregistrerMenu);
        m.add(FichierSauvegarde);
        setJMenuBar(m);
        JPanel panDessin = new JPanel(new BorderLayout());
        panDessin.setBorder(BorderFactory.createTitledBorder("Dessin"));
        panDessin.add(this.dessin, BorderLayout.CENTER);

// Interprétation de code
        JPanel panCode = new JPanel(new BorderLayout());
        panCode.setBorder(BorderFactory.createTitledBorder("Interprétation de code"));

// Ajouter le composant pour interpréter le code
// Exemple :
        JTextArea zoneCode = new JTextArea();
        panCode.add(new JScrollPane(zoneCode), BorderLayout.CENTER);
        JPanel panCentral = new JPanel(new GridLayout(1, 2));
        panCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panCentral.add(panDessin);
        panCentral.add(panCode);

// Ajouter le panneau central au contenu
        //Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(panCentral, BorderLayout.CENTER);
        JPanel panSouth=new JPanel();
        JPanel PanelRefresh=new JPanel();
        JPanel PanelImport=new JPanel();
        panSouth.setLayout(new GridLayout(1,2));
        panSouth.setPreferredSize(new Dimension(1280,125));
        JButton BoutonRefresh=new JButton("Refresh");
        BoutonRefresh.setBackground(Color.red);
        PanelRefresh.add(BoutonRefresh);
        JButton BoutonImport=new JButton("Import");
        BoutonImport.setBackground(Color.green);
        PanelImport.add(BoutonImport);
        panSouth.add(BoutonRefresh);
        panSouth.setLayout(new FlowLayout());
        panSouth.add(PanelImport);


        contentPane.add(panSouth,BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void display() {
        setVisible(true);
        System.out.println("Affichage de le deuxième fenetre? ");

    }

    @Override
    public void close() {
        setVisible(false);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
