/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectgame;

import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author xavie
 */
public class ReController implements Initializable {

    @FXML
    private Label registrados;
    
    @FXML
    private Label presupuesto;
    @FXML
    private GridPane Ciudad;
    @FXML
    private Button up;
    @FXML
    private Button Right;
    @FXML
    private Button Down;
    @FXML
    private Button Left;
    @FXML
    private AnchorPane Colorz;
    @FXML
    private VBox edit;

    /**
     * Initializes the controller class.
     */
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //rearGridPane();
        label();
        cambiarFondo();
        Ciudad.setStyle("-fx-background-color: #536cff");
        
        
        
        final Circle circulo = new Circle(15, Color.TOMATO);
        circulo.setEffect(new Lighting());
        
        
        
        Ciudad.add(circulo, 0,0);
        GridPane.setHalignment(circulo, HPos.CENTER);
        
        up.setOnAction(t -> arriba(circulo));
        Down.setOnAction(t -> abajo(circulo));
        Left.setOnAction(t -> izquierda(circulo));
        Right.setOnAction(t -> derecha(circulo));
        
        
        tocar();
        /*
        Hilo panel = new Hilo(Ciudad, edit); 
        Thread hilo1 = new Thread(() -> tocar());
        hilo1.start();
        
        */
    }    
    
    
    
    
    //*****************************
    public void crearGridPane(){
        
        InputStream image = App.class.getResourceAsStream("Normal/grassTile.png");
        ImageView piso =new ImageView();
        piso.setImage(new Image(image, 70, 68, false, false));
        
     
        
        
        
        GridPane gp = new GridPane();
        gp.setHgap(30);
        gp.setVgap(18); 
        gp.setPadding(new Insets(10,10,10,10));
        
        
        
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                StackPane qseparado = new StackPane();
                
                qseparado.setStyle("-fx-background-color: #536cff");
                
                
                gp.add(qseparado, i, j);
                
                
            }
                
        }
            
        
        gp.setGridLinesVisible(true);
        
        edit.getChildren().add(gp);
        
    }

    
    
    
    //************************************
    public GridPane getCiudad() {
        return Ciudad;
    }
    
    
    
    public void tocar(){
        
       
        
        
        System.out.println("Se ejecuta");
        for(int i= 0 ; i<30; i++){
            for(int j = 0 ; j<18;j++){
                InputStream image = App.class.getResourceAsStream("Normal/grassTile.png");
                ImageView piso =new ImageView();
                piso.setImage(new Image(image, 35, 34, false, false));
                
                
                
                StackPane qseparado = new StackPane();
                qseparado.getChildren().add(piso);
                
                
                int a = i;
                int b = j;
                 
                Ciudad.add(qseparado, a, b);
                
                
                //Armar un thread
                qseparado.setOnMouseClicked(e -> cont(a,b));
                
                
                
                
                
               
                
                
                
                
            }
                
        }
        
    }
    
    
    public void cont(int columna, int fila){
        
        Node x = Pepito(Ciudad, columna, fila);
        
        
        if( x == null){
            InputStream image = App.class.getResourceAsStream("Normal/grassTile.png");
            ImageView piso =new ImageView();
            piso.setImage(new Image(image, 35, 34, false, false));
        
            Ciudad.add(piso, columna, fila);
        }else{
            
            InputStream image2 = App.class.getResourceAsStream("EXTRAS/gif-muro-07.gif");
            ImageView piso2 = new ImageView();
            piso2.setImage(new Image(image2, 25, 20, false, false));
            
            Ciudad.add(piso2, columna, fila);
        }
        
        
        
        
        
        
    }
    
    
    
    private Node Pepito(GridPane gridPane, int col, int row) {
    for (Node node : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
            return node;
        }
    }
    return null; 
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //new Rectangle(50,50, Color.BEIGE)
    
    
    
    
    
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    //Botones del juego
    
    public void arriba(Circle circulo){
        
        try{
            GridPane.setRowIndex(circulo, GridPane. getRowIndex(circulo)-1);
        }catch(IllegalArgumentException ex){
            
            Alert problema = new Alert(Alert.AlertType.INFORMATION);
            problema.setTitle("Hubo un error en al momento de moverte hacia arriba.");
            problema.setContentText("Flaco, sabes es bueno ser curioso, pero te pasas.");        
            problema.showAndWait();
        }
        
        
    }
    public void abajo(Circle circulo){
        try{
            GridPane.setRowIndex(circulo, GridPane. getRowIndex(circulo)+1);
        }catch(IllegalArgumentException ex){
            Alert problema = new Alert(Alert.AlertType.INFORMATION);
            problema.setTitle("Hubo un error en el momento de moverte hacia abajo");
            problema.setContentText("Bro, estas fuera de los limites");
            problema.showAndWait();
        }
        
    }
    
    
    public void izquierda(Circle circulo){
        try{
            GridPane.setColumnIndex(circulo, GridPane. getColumnIndex(circulo)-1);
        }catch(IllegalArgumentException ex){
            
            Alert problema = new Alert(Alert.AlertType.INFORMATION);
            problema.setTitle("Hubo un problema al momento de moverte hacia la izquierda");
            problema.setContentText("Bro, estas mal");
            problema.showAndWait();
            
        }
        
    }
    public void derecha(Circle circulo){
        try{
            GridPane.setColumnIndex(circulo, GridPane. getColumnIndex(circulo)+1);
        }catch(IllegalArgumentException ex){
            
            Alert problema = new Alert(Alert.AlertType.INFORMATION);
            problema.setTitle("Hubo un problema al momento de moverte hacia la derecha");
            problema.setContentText("Tas bien bro?");
            problema.showAndWait();
            
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void label(){
        
        registrados.setText(Usuario.user.toString());
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void cambiarFondo(){
        Colorz.setStyle("-fx-background-color: #000000");
        
        
        switch(GameController.nuevoUsuario){
            case "Modo niño chillon": presupuesto.setText("Presupuesto: 1000");
                break;
            
            case "Modo adulto promedio": presupuesto.setText("Presupuesto: 500");
                break;
                
            case "Te cagas bro": presupuesto.setText("Presupuesto: 500");
                break;
        }
        
        
        
    }

    private void Construir(MouseEvent event) {
        
        System.out.println("HOla");
        
        
    }
    
    
    public void imagenes(){
        
        Label info = new Label("Has elegido una casilla por favor seleciona ");
        
        
    }

    
    
    
    
    
    
    
    
    
}

