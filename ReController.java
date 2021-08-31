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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author xavie
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
    @FXML
    private Button Aceptar;
    private int tiempo;
    
    
    

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registrados.setText(Usuario.user.toString().replace("[", "").replace("]", ""));
        Tiempo.setText("Tiempo : "+tiempo);
        leerServicio();
        Servicios.getItems().addAll(servicioList);
        cambiarFondo();
        llenarGrid();
        Aceptar.setOnAction(t->  agregarValor(Servicios.getValue()));
        Thread t=new Thread(()-> pasoTemp());
        t.start();
        
        
        //tocar();   
    } 
    
    public void agregarValor(Servicio s){
        String nombre=s.getNombre();
        String ruta=s.getRuta();
        int Costomensual=s.getCostoMensual();
        int Presioconstruccion=s.getPrecioConstruccion();
        ponerServicio(ruta,Presioconstruccion);
        
        
        
    }
    
    public void llenarGrid(){
        
        
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                StackPane qseparado = new StackPane();
                InputStream input = App.class.getResourceAsStream("Imagenes/grassTile.png");
                ImageView piso =new ImageView();
                piso.setImage(new Image(input,25,30, false, false));;
       
                int iEditable = i;
                int jEditable  = j;

                qseparado.getChildren().addAll(piso);
                
                Mapa.add(qseparado, i, j);

            }
                
        }Mapa.setGridLinesVisible(true);
    }
    
     public void ponerServicio(String ruta,int Presioconstruccion){
        
        
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                StackPane qseparado = new StackPane();
                
       
                int iEditable = i;
                int jEditable  = j;
                
                cambiar(qseparado,ruta,Presioconstruccion);
         
                Mapa.add(qseparado, i, j);
 
            }
                
        }Mapa.setGridLinesVisible(true);
    }
    
    public void cambiar(StackPane x,String ruta,int Presioconstruccion){
        
        x.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
                 public void handle(MouseEvent mouseEvent) {
                System.out.println("Group!" + mouseEvent.getSource());
                
                ButtonType queen = new ButtonType("Construir");
                ButtonType rook = new ButtonType("Demoler");
                Alert a = new Alert(AlertType.NONE, "Elige entre: ", queen, rook);
                a.setTitle("Primero que nada , Buenos dias");
                
                a.setResizable(true);
                a.setContentText("Desea constuir o demoler un servicio?");
                a.showAndWait().ifPresent(response -> {
                if (response == queen) {
             
                    System.out.println("Yeah");
                    Alert b = new Alert(AlertType.INFORMATION);
                    b.setTitle("Va a contruir Yeahh");
                    b.setContentText("Por favor elige un tipo de construccion a lado del panel. ");
                    b.showAndWait();
                    
                    Aceptar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                    System.out.println("Group!" + mouseEvent.getSource());
   
                    Servicio s = Servicios.getValue();
                    
                    String nombre=s.getNombre();
                        System.out.println(nombre);
                    
                    
                    String ruta=s.getRuta();
                    int Costomensual=s.getCostoMensual();
                    int Presioconstruccion=s.getPrecioConstruccion();
                    
                    
                    x.getChildren().clear();
                    InputStream input = App.class.getResourceAsStream(ruta);
                    ImageView piso3 =new ImageView();
                    piso3.setImage(new Image(input,25,30, false, false));
                    
                    x.getChildren().add(piso3);
 
                    
                    }
                    });
                      
                    
                } else if (response == rook) {
                    x.getChildren().clear();
                    
                    InputStream input = App.class.getResourceAsStream("EXTRAS/gif-muro-07.gif");
                    ImageView pisoUWU =new ImageView();
                    pisoUWU.setImage(new Image(input,25,30, false, false));
                    
                    x.getChildren().add(pisoUWU);
                    
                    
                 }
                });
                
                InputStream input = App.class.getResourceAsStream(ruta);
                ImageView image =new ImageView();
                image.setImage(new Image(input,25,30, false, false));;
                
                
                x.getChildren().add(image);
                presupuestoInicial-=Presioconstruccion;
                presupuesto.setText("Presupuesto: "+presupuestoInicial);
                
                
                //Aqui esta mmda se puede crear un menu dicendo tu servicio a poner 
                
                }
                });
                
        
    }
    
    
    public void crearServicio(MouseEvent event,Servicio s){
        InputStream input = App.class.getResourceAsStream(s.getRuta());
        ImageView image =new ImageView();
        image.setImage(new Image(input,25,30, false, false));;
        
        
       

    }
    
    private Node Grid(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null; 
    }
    
    
   
   
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
    
    public void pasoTemp(){
        while(true){
        
        try {
            Platform.runLater(()-> Tiempo.setText("Tiempo : "+tiempo));
                    Thread.sleep(2000);
            Thread.sleep(1000);
            tiempo++;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        }
    }
    
    
    
}
