/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectgame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author xavier
 */
public class ReController implements Initializable {

    @FXML
    private AnchorPane Colorz;
    @FXML
    private Label registrados;
    @FXML
    private GridPane Mapa;
    @FXML
    private Label Tiempo;
    @FXML
    private Button Guardar;
    @FXML
    private ComboBox<Servicio> Servicios;
    @FXML
    private Label presupuesto;
    private int presupuestoInicial;
    
    public static ArrayList <Servicio> servicioList = new ArrayList<>();
   
    
    
    
    public static ArrayList <Tile> paneles = new ArrayList<>();
    
    public int tiempo = 1;
    
    
    
    
    @FXML
    private Button Elegir;
    
    
    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        Thread t = new Thread( () -> ConsumirTiempo());
        t.start();
        
        
        registrados.setText(Usuario.user.toString().replace("[", "").replace("]", ""));
        
        leerServicio();
        
        Servicios.getItems().addAll(servicioList);
        
       
        
        llenarGrid();
        
        Thread ubicacion = new Thread(() -> ubicacionTenida());
        
        ubicacion.start();
        
        
        
        cambiarFondo();
        
        
        
        //tocar();
        
        
        
        
    } 
    
    
    public void ConsumirTiempo(){
        
        
       while(App.activo) 
            {
                try {
                    
                    tiempo+=1;
                    Platform.runLater(() -> Tiempo.setText("Tiempo "+ tiempo ));  
                    
                    
                    Thread.sleep(100);
                    
                    
                    
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } 
            }
    }
        
        
        
    
    
    
    
    
    
    
    
    public void llenarGrid(){
        
        
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                //StackPane qseparado = new StackPane();
                
                
                
                String editable = i+" "+j;
                
                Tile nuevoPane = new Tile(i, j, editable);
                
                
                paneles.add(nuevoPane);
                
                InputStream input = App.class.getResourceAsStream("Imagenes/grassTile.png");
                ImageView piso =new ImageView();
                piso.setImage(new Image(input,25,30, false, false));
       
                int iEditable = i+1;
                int jEditable  = j+1;
                
                
                //qseparado.getChildren().addAll(piso);
                
                nuevoPane.getChildren().addAll(piso);
                
                
                
                
                nuevoPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                System.out.println("Group!" + mouseEvent.getSource());
                
                
                
                ButtonType queen = new ButtonType("Construir");
                ButtonType rook = new ButtonType("Demoler");
                Alert a = new Alert(AlertType.NONE, "Elige entre: ", queen, rook);
                a.setTitle("Hola");
                a.setHeaderText("My header text");
                a.setResizable(true);
                a.setContentText("Content text");
                a.showAndWait().ifPresent(response -> {
                if (response == queen) {
                    
                    
                    
                    System.out.println("Yeah");
                    Alert b = new Alert(AlertType.INFORMATION);
                    b.setTitle("Va a contruir Yeahh");
                    b.setContentText("Por favor elige un tipo de construccion a lado del panel. ");
                    b.showAndWait();
                    
                    Elegir.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                    System.out.println("Group!" + mouseEvent.getSource());
                    
                    
                   
                    
                    Servicio s = Servicios.getValue();
                    
                    String nombre=s.getNombre();
                        
                    System.out.println(nombre);
                    
                    
                    String ruta=s.getRuta();
                    int Costomensual=s.getCostoMensual();
                    int Presioconstruccion=s.getPrecioConstruccion();
                    
                    
                    nuevoPane.getChildren().clear();
                    InputStream input = App.class.getResourceAsStream(ruta);
                    ImageView piso3 =new ImageView();
                    piso3.setImage(new Image(input,25,30, false, false));
                    
                    nuevoPane.getChildren().add(piso3);
                    
                    
                    Tile x = paneles.get(iEditable+1);
                    Tile y = paneles.get(jEditable+1);
                    
                    
                    InputStream owo = App.class.getResourceAsStream("Imagenes/houses/1.png");
                    ImageView loco =new ImageView();
                    loco.setImage(new Image(owo,25,30, false, false));
                    
                    
                    
                    
                    //casa
                    x.getChildren().clear(); 
                    
                    
                    x.getChildren().add(loco);
                    
                    
                   
                    
                    
                    y.getChildren().add(loco);
                    
                     
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    }
                    });
                    
                    
                    
                    
                } else if (response == rook) {
                    nuevoPane.getChildren().clear();
                    
                    InputStream input = App.class.getResourceAsStream("EXTRAS/gif-muro-07.gif");
                    ImageView pisoUWU =new ImageView();
                    pisoUWU.setImage(new Image(input,25,30, false, false));
                    
                    nuevoPane.getChildren().add(pisoUWU);
                    
                    
                 }
                });
                
                
                
                
                
                
                
                
                //Aqui esta mmda se puede crear un menu dicendo tu servicio a poner 
                
                }
                });
                
                
                Mapa.add(nuevoPane, i, j);
                
                
            }
                
        }Mapa.setGridLinesVisible(true);
    }  
    
    
    
    
    
    
    
    
    
    
    
    
    public void ubicacionTenida(){
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    public void crearServicio(Servicio s,int i,int j){
        
        
        
       

    }
    
    
    /*
     public void tocar(){
        
        
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                StackPane qseparado = new StackPane();
                
                int a = i;
                int b = j;
                qseparado.setOnMouseClicked(e -> cont(a,b));
                
                
                Mapa.add(qseparado, i, j);
                
                
            }
                
        }
        
    }
     
    
    public void cont(int columna, int fila){
        
        Node x = Grid(Mapa, columna, fila);
        try {
            if( x == null){
            InputStream image = App.class.getResourceAsStream("Imagenes/streer1.png");
            ImageView piso =new ImageView();
            piso.setImage(new Image(image, 35, 34, false, false));
        
            Mapa.add(piso, columna, fila);
        }else{
            
            InputStream image2 = App.class.getResourceAsStream("EXTRAS/gif-muro-07.gif");
            ImageView piso2 = new ImageView();
            piso2.setImage(new Image(image2, 25, 20, false, false));
            
            Mapa.add(piso2, columna, fila);
        }
            
        } catch (Exception e) {
        }
        
        
        
        
        
     
        
    }
    private Node Grid(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null; 
    }
    /////    
        
      
    */
   
    public void cambiarFondo(){
        
        Colorz.setStyle("-fx-background-color: #ffffff");
        
        
        switch(GameController.nuevoUsuario){
            case "Facil":
                presupuestoInicial=20000;
                presupuesto.setText("Presupuesto: "+presupuestoInicial);
                break;
            
            case "Medio":
                presupuestoInicial=10000;
                presupuesto.setText("Presupuesto: "+presupuestoInicial);
                break;
                
            case "Dificil":
                presupuestoInicial=5000;
                presupuesto.setText("Presupuesto: "+presupuestoInicial);
                break;
        } 
     
    }
    
    
    public  void Guardar(){
        GridPane guardado= Mapa;
        //Pelicula p=new Pelicula("Harry Poter","15:20");
        try(ObjectOutputStream s= new ObjectOutputStream(new FileOutputStream("nose.bin"))){
            s.writeObject(guardado);
            System.out.println("Se serializo con exito");
        }
        catch(IOException e){
            System.out.println("Error al serializar"+e);
        }
        System.out.println("*****");
    }
    
    
    
    public static void leerServicio(){
       try{
       //InputStream input = App.class.getResourceAsStream("archivos/servicios.csv");
       InputStreamReader lector= new InputStreamReader(App.class.getResourceAsStream("archivos/servicios.txt"));
       BufferedReader reader= new BufferedReader(lector);
       String linea;
       int i = 1;
       
       //No se tiene que leer la primera linea
       while ( (linea=reader.readLine()) != null){
           
           if (i!=1){
               String [] l = linea.split(";");
               servicioList.add(new Servicio(l[0],l[1],Integer.parseInt(l[2]),Integer.parseInt(l[3])));
               
           }else{
               i++;
           }
           
           
       }
       }
       
       catch (IOException | NullPointerException ex){
           ex.printStackTrace();
           Alert al=new Alert(AlertType.ERROR);  
           al.setTitle("Error al leer archivo");
           al.setContentText("no se encuentra el archivo"+ex.toString());
           al.showAndWait();
       }
       
    }
    
    
    
}

class Tile extends Pane {
        private String panelCreado;
        private int positionX;
        private int positionY;

        public Tile(int x, int y, String panel) {
            positionX = x;
            positionY = y;
            panelCreado = panel;
            
        }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public String toString() {
        return panelCreado;
    }
        
        
        
        
        
        
    }
