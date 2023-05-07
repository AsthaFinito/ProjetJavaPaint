package org.isen.volumeModel.TP3.view.impl;

import org.isen.volumeModel.TP3.Data.impl.*;
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
import javax.xml.parsers.DocumentBuilderFactory;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import org.isen.volumeModel.TP3.Data.Shape;

public class MySVGEditor extends JFrame implements IDrawView,ActionListener {
    private DrawController controller;
    private Dessin dessin;
    private JTextField zoneCode;
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
        this.zoneCode = new JTextField ();
        this.zoneCode.addActionListener(this);
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
        BoutonRefresh.addActionListener(this);
        BoutonRefresh.setBackground(Color.red);
        PanelRefresh.add(BoutonRefresh);
        JButton BoutonImport=new JButton("Import");
        BoutonImport.setBackground(Color.green);
        PanelImport.add(BoutonImport);
        panSouth.add(BoutonRefresh);
        panSouth.setLayout(new FlowLayout());
        panSouth.add(PanelImport);


        contentPane.add(panSouth,BorderLayout.SOUTH);

        String userInput = zoneCode.getText();
        System.out.println("userInput ->"+userInput);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String userInput = zoneCode.getText();
        System.out.println("userInput ->" + userInput);

        try {
            // Create a document builder factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the SVG content to create a DOM document
            InputStream is = new ByteArrayInputStream(userInput.getBytes());
            Document doc = builder.parse(is);

            // Get the root element of the SVG document
            Element svg = doc.getDocumentElement();

            // Get a list of all the child elements of the SVG element
            NodeList svgChildren = svg.getChildNodes();

            // Loop through the child elements of the SVG element
            for (int i = 0; i < svgChildren.getLength(); i++) {
                Node svgChild = svgChildren.item(i);

                // Check if the child element is a path
                if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("path")) {
                    Element path = (Element) svgChild;

                    // Get the path data attribute
                    String pathData = path.getAttribute("d");

                    // Do something with the path data
                    System.out.println("Path data: " + pathData);
                }


                // Check if the child element is a rectangle
                if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("rect")) {
                    Element rect = (Element) svgChild;
                    System.out.println("Detection d'un rectangle ");
                    // Get the rectangle attributes
                    int x = (int) Float.parseFloat(rect.getAttribute("x"));
                    int y = (int) Float.parseFloat(rect.getAttribute("y"));
                    int width = (int) Float.parseFloat(rect.getAttribute("width"));
                    int height = (int) Float.parseFloat(rect.getAttribute("height"));
                    Color CurrentColor= Color.decode(rect.getAttribute("fill"));
                    Color CurrentColorStroke= Color.decode(rect.getAttribute("stroke"));
                    int CurrentTailleStroke = (int) Float.parseFloat(rect.getAttribute("stroke-width"));

                    // Do something with the rectangle data
                    System.out.println("Detection d'un rectangle -> Rectangle: (" + x + "," + y + ") " + width + "x" + height);

                    rectangle test=new rectangle(CurrentColor,x,y,CurrentColorStroke);
                    test.setBoundingBox(width,height);
                    this.controller.AddShapeController(test);

                }

                // Check if the child element is a circle
                if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("circle")) {
                    Element circle = (Element) svgChild;

                    // Get the circle attributes
                    int cx = (int) Float.parseFloat(circle.getAttribute("cx"));
                    int cy = (int) Float.parseFloat(circle.getAttribute("cy"));
                    int r = (int) Float.parseFloat(circle.getAttribute("r"));
                    Color CurrentColor= Color.decode(circle.getAttribute("fill"));
                    Color CurrentColorStroke= Color.decode(circle.getAttribute("stroke"));
                    int CurrentTailleStroke = (int) Float.parseFloat(circle.getAttribute("stroke-width"));

                    // Do something with the circle data
                    System.out.println("Detection d'un cercle -> Circle: (" + cx + "," + cy + ") r=" + r);

                    cercle test=new cercle(CurrentColor,cx,cy,r,CurrentColorStroke);
                    test.setBoundingBox(r,r);
                    this.controller.AddShapeController(test);
                }
                else if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("text")) {
                    // code pour le texte
                    //System.out.println("Detection d'un texte ");
                    Element text = (Element) svgChild;
                    System.out.println("Detection d'un texte ");
                    int x = (int) Float.parseFloat(text.getAttribute("x"));
                    int y = (int) Float.parseFloat(text.getAttribute("y"));
                    String textValueString = text.getTextContent().trim();
                    System.out.println("Recup du string : -> "+textValueString);
                    Color CurrentColor= Color.decode(text.getAttribute("stroke"));


                    // Do something with the text data
                    texte test=new texte(textValueString,CurrentColor,x,y);

                    this.controller.AddShapeController(test);

                }
                else if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("isen_magic")) {
                    // code pour le texte
                    System.out.println("Detection de isen_magic ");
                    Element text = (Element) svgChild;
                    int x = (int) Float.parseFloat(text.getAttribute("x"));
                    int y = (int) Float.parseFloat(text.getAttribute("y"));
                    image test=new image(x,y);

                    this.controller.AddShapeController(test);
                   // System.out.println("Fin de chargement");

                }
                else if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("polygon")) {
                    // code pour le texte
                    System.out.println("Detection de polygon ");
                    Element polygonElement = (Element) svgChild;
                    String points = polygonElement.getAttribute("points");


                    Color CurrentColor= Color.decode(polygonElement.getAttribute("fill"));
                    Color CurrentColorStroke= Color.decode(polygonElement.getAttribute("stroke"));


                    int CurrentTailleStroke = (int) Float.parseFloat(polygonElement.getAttribute("stroke-width"));

                    polygon test=new polygon(CurrentColor,CurrentColorStroke,CurrentTailleStroke,points);
                    this.controller.AddShapeController(test);
                    // System.out.println("Fin de chargement");

                }

                // Add more checks for other element types as needed
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
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
        System.out.println("PropertyChangeEvent -> "+evt);
        if(evt.getPropertyName().equals("AddShapes")){
            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }

    }
}
