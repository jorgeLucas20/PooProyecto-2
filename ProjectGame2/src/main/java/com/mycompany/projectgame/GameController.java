/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectgame;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author xavie
 */
public class GameController implements Initializable {

    @FXML
    private AnchorPane Color;
    
    @FXML
    private ImageView arrow1;
    @FXML
    private ImageView arrow2;
    @FXML
    private ComboBox<String> Dificultades;
    @FXML
    private TextField ciudad;
    @FXML
    private TextField alcalde;
    @FXML
    private Button registrar;
    @FXML
    private Label registrado;
    @FXML
    private Button registroz;
    @FXML
    private StackPane Fondo;
    

    @FXML
    private void jugar() throws IOException {
        App.setRoot("re");
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        llenar();
        cambiarColor();
        fondo(); 
        entradas();
        
        
        
    }

    public static String nuevoUsuario;
    
    
    public void cambiarColor()
    {
    Color.setStyle("-fx-background-color: #ffffff");
    InputStream fondo= App.class.getResourceAsStream("Imagenes/Commercial/commercial1.jpg");
    ImageView piso =new ImageView();
    piso.setImage(new Image(fondo, 69, 86, false, false));;

    
    Fondo.getChildren().addAll(piso);
    }
        
    public void fondo(){
       
        InputStream input2= App.class.getResourceAsStream("EXTRAS/arrow.gif");
        arrow1.setImage(new Image(input2));
        
        InputStream input3= App.class.getResourceAsStream("EXTRAS/arop.gif");
        arrow2.setImage(new Image(input3));
        
        
    }
    public void switchToSecondary() throws IOException {
        App.setRoot("re");
    }
    
    public void llenar(){
        Dificultades.getItems().addAll(Usuario.dificultad);
    }
    
    
    public void entradas(){
        
       
        registroz.setOnAction(t -> regist());
        
       
    }
    
    public void regist(){
        
        
        String ciu = ciudad.getText();
        
        String alcalde1 = alcalde.getText();
        
        String dificultad = Dificultades.getValue();
        
        nuevoUsuario = dificultad;
        
        Usuario.llenarUsuario(ciu, alcalde1, dificultad);
        registroz.setStyle("-fx-background-color: #000000");
        registroz.setText("Registrado");
        registrado.setText("Felicidades estas registrado.\nConsejo: No mejores mucho o te encontraran...");
        
    }
    
    
    
    
    
    
}
    
    
    
    

