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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;


public class MySVGEditor extends JFrame implements IDrawView,ActionListener, DocumentListener {
    private DrawController controller;
    private Dessin dessin;
    private JTextField zoneCode;
    private JButton BoutonRefresh;
    private JButton BoutonImport;
    private List<Shape> StockageShape = new ArrayList<>();
    private RSyntaxTextArea NewZoneCode;
    private RTextScrollPane scrollPane;
    private JMenuItem EnregistrerMenu;
    private JMenuItem OuvrirMenu;
    private String DonneesEnregistrement;
    private String DonneesOuverture;
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
        this.OuvrirMenu = new JMenuItem("Ouvrir");
        this.OuvrirMenu.addActionListener(this);
        this.EnregistrerMenu = new JMenuItem("Enregistrer");
        this.EnregistrerMenu.addActionListener(this);
        FichierSauvegarde.add(this.OuvrirMenu);
        FichierSauvegarde.add(this.EnregistrerMenu);
        m.add(FichierSauvegarde);
        setJMenuBar(m);
        JPanel panDessin = new JPanel(new BorderLayout());
        panDessin.setBorder(BorderFactory.createTitledBorder("Dessin"));
        panDessin.add(this.dessin, BorderLayout.CENTER);

        JPanel panCode = new JPanel(new BorderLayout());
        panCode.setBorder(BorderFactory.createTitledBorder("Interprétation de code"));


        this.NewZoneCode = new RSyntaxTextArea(20, 60);
        this.NewZoneCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        this.NewZoneCode.setCodeFoldingEnabled(true);
        this.NewZoneCode.getDocument().addDocumentListener(this);

        // Ajout d'un ascenseur pour la zone de texte
        this.scrollPane = new RTextScrollPane(this.NewZoneCode);
        panCode.add(scrollPane, BorderLayout.CENTER);
        panCode.add(new JScrollPane(NewZoneCode), BorderLayout.CENTER);
        JPanel panCentral = new JPanel(new GridLayout(1, 2));
        panCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panCentral.add(panDessin);
        panCentral.add(panCode);


        contentPane.setLayout(new BorderLayout());
        contentPane.add(panCentral, BorderLayout.CENTER);
        JPanel panSouth=new JPanel();
        JPanel PanelRefresh=new JPanel();
        JPanel PanelImport=new JPanel();
        panSouth.setLayout(new GridLayout(1,2));
        panSouth.setPreferredSize(new Dimension(1280,125));
        this.BoutonRefresh=new JButton("Refresh");
        this.BoutonRefresh.addActionListener(this);
        this.BoutonRefresh.setBackground(Color.red);
        PanelRefresh.add(this.BoutonRefresh);
        this.BoutonImport=new JButton("Import");
        this.BoutonImport.addActionListener(this);
        this.BoutonImport.setBackground(Color.green);
        PanelImport.add(this.BoutonImport);
        panSouth.add(this.BoutonRefresh);
        panSouth.setLayout(new FlowLayout());
        panSouth.add(PanelImport);


        contentPane.add(panSouth,BorderLayout.SOUTH);

        String userInput = NewZoneCode.getText();
        System.out.println("userInput ->"+userInput);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String userInput = NewZoneCode.getText();
        System.out.println("userInput ->" + userInput);
        if(evt.getSource()==BoutonRefresh){
            System.out.println("Interpretation en cours");
            try {

                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


                DocumentBuilder builder = factory.newDocumentBuilder();


                InputStream is = new ByteArrayInputStream(userInput.getBytes());
                Document doc = builder.parse(is);


                Element svg = doc.getDocumentElement();


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
                        //Color CurrentColor= Color.decode(rect.getAttribute("fill"));
                        String CurrentColor= rect.getAttribute("fill");
                        String testColor=ColorCheck(CurrentColor);
                        System.out.println(testColor);
                        Color CurrentColor2=Color.decode(testColor);
                        //Color CurrentColorStroke= Color.decode(rect.getAttribute("stroke"));
                        String CurrentColorStroke= rect.getAttribute("fill");
                        testColor=ColorCheck(CurrentColor);
                        System.out.println(testColor);
                        Color CurrentColorStroke2=Color.decode(testColor);
                        int CurrentTailleStroke = (int) Float.parseFloat(rect.getAttribute("stroke-width"));

                        // Do something with the rectangle data
                        System.out.println("Detection d'un rectangle -> Rectangle: (" + x + "," + y + ") " + width + "x" + height);

                        rectangle test=new rectangle(CurrentColor2,x,y,CurrentColorStroke2);
                        test.setBoundingBox(width,height);
                        this.controller.AddShapeControllerSVG(test);
                        StockageShape.add(test);

                    }

                    // Check if the child element is a circle
                    if (svgChild.getNodeType() == Node.ELEMENT_NODE && svgChild.getNodeName().equals("circle")) {
                        Element circle = (Element) svgChild;

                        // Get the circle attributes
                        int cx = (int) Float.parseFloat(circle.getAttribute("cx"));
                        int cy = (int) Float.parseFloat(circle.getAttribute("cy"));
                        int r = (int) Float.parseFloat(circle.getAttribute("r"));
                        String CurrentColor= circle.getAttribute("fill");
                        String testColor=ColorCheck(CurrentColor);
                        System.out.println(testColor);
                        Color CurrentColor2=Color.decode(testColor);
                        //---------------------------------------------------------
                        String CurrentColorStroke= circle.getAttribute("stroke");
                        testColor=ColorCheck(CurrentColorStroke);
                        System.out.println(testColor);
                        Color CurrentColorStroke2=Color.decode(testColor);
                        int CurrentTailleStroke = (int) Float.parseFloat(circle.getAttribute("stroke-width"));

                        // Do something with the circle data
                        System.out.println("Detection d'un cercle -> Circle: (" + cx + "," + cy + ") r=" + r);

                        cercle test=new cercle(CurrentColor2,cx,cy,r,CurrentColorStroke2);
                        test.setBoundingBox(r,r);
                        this.controller.AddShapeControllerSVG(test);
                        StockageShape.add(test);
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
                        String CurrentColor= text.getAttribute("stroke");
                        String testColor=ColorCheck(CurrentColor);
                        System.out.println(testColor);
                        Color CurrentColor2=Color.decode(testColor);


                        // Do something with the text data
                        texte test=new texte(textValueString,CurrentColor2,x,y);

                        this.controller.AddShapeControllerSVG(test);
                        StockageShape.add(test);

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


                        String CurrentColor= polygonElement.getAttribute("fill");
                        String testColor=ColorCheck(CurrentColor);
                        System.out.println(testColor);
                        Color CurrentColor2=Color.decode(testColor);
                        //---------------------------------------------------------
                        String CurrentColorStroke= polygonElement.getAttribute("stroke");
                        testColor=ColorCheck(CurrentColorStroke);
                        System.out.println(testColor);
                        Color CurrentColorStroke2=Color.decode(testColor);


                        int CurrentTailleStroke = (int) Float.parseFloat(polygonElement.getAttribute("stroke-width"));

                        polygon test=new polygon(CurrentColor2,CurrentColorStroke2,CurrentTailleStroke,points);
                        this.controller.AddShapeControllerSVG(test);
                        StockageShape.add(test);
                        // System.out.println("Fin de chargement");

                    }

                    // Add more checks for other element types as needed
                }

            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
        else if(evt.getSource()==BoutonImport){
            System.out.println("Affichage dans le paint ");
            for (Shape shape : StockageShape) {
                if (shape != null) {
                    // Traitement de chaque forme
                    this.controller.AddShapeController(shape);
                }
            }





        }
        else if(evt.getSource()==EnregistrerMenu){
            this.DonneesEnregistrement=userInput;
            System.out.println("On enregistre le fichier");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Enregistrer le fichier");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fichier SVG (*.isvg)", "isvg"));
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".isvg")) {
                    fileToSave = new File(filePath + ".isvg");
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {

                    writer.write(this.DonneesEnregistrement);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
        else if(evt.getSource()==OuvrirMenu){

            System.out.println("On ouvre le fichier");
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Ouvrir le fichier");
            fileChooser.setFileFilter(new FileNameExtensionFilter("Fichier SVG (*.isvg)", "isvg"));
            int userSelection = fileChooser.showOpenDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                    String line;
                    StringBuilder stringBuilder = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    String fileContent = stringBuilder.toString();
                    this.DonneesOuverture=fileContent;
                    System.out.println(this.DonneesOuverture);
                    this.NewZoneCode.setText(this.DonneesOuverture);
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

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
        if(evt.getPropertyName().equals("AddShapesSVG")){
            Object data = evt.getNewValue();
            ArrayList<org.isen.volumeModel.TP3.Data.Shape> shapes = (ArrayList<org.isen.volumeModel.TP3.Data.Shape>) data;
            if(data instanceof List){
                dessin.setShape(shapes);
                dessin.repaint();
            }
        }

    }

    public String ColorCheck(String color){
        String temp;
        if(color.equals("marooon")){
            temp="#800000";
            return temp;
        }
        else if(color.equals("red")){
            temp="#ff0000";
            return temp;
        }
        else if(color.equals("orange")){
            temp="#ffA500";
            return temp;
        }
        else if(color.equals("yellow")){
            temp="#ffff00";
            return temp;
        }
        else if(color.equals("olive")){
            temp="#808000";
            return temp;
        }
        else if(color.equals("purple")){
            temp="#800080";
            return temp;
        }
        else if(color.equals("fuchsia")){
            temp="#ff00ff";
            return temp;
        }else if(color.equals("white")){
            temp="#ffffff";
            return temp;
        }
        else if(color.equals("lime")){
            temp="#00ff00";
            return temp;
        }
        else if(color.equals("green")){
            temp="#008000";
            return temp;
        }
        else if(color.equals("navy")){
            temp="#000080";
            return temp;
        }
        else if(color.equals("blue")){
            temp="#0000ff";
            return temp;
        }
        else if(color.equals("aqua")){
            temp="#00ffff";
            return temp;
        }
        else if(color.equals("teal")){
            temp="#008080";
            return temp;
        }
        else if(color.equals("black")){
            temp="#000000";
            return temp;
        }
        else if(color.equals("silver")){
            temp="#c0c0c0";
            return temp;
        }
        else if(color.equals("gray")){
            temp="#808080";
            return temp;
        }
        else if(color.equals("none")){
            temp="#ffffff";
            return temp;
        }
        else{
            System.out.println("Erreur else-if des couleurs ou couleur deja decode");
            return color;
        }

    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
