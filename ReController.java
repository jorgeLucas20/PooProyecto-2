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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
 
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
 
    /**
     * Initializes the controller class.
     */
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
         
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
         
         
         
    }
     
     
     
     
     
     
    
     
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
     
     
}
