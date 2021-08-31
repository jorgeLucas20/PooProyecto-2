/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectgame;

import java.util.ArrayList;

/**
 *
 * @author xavier
 */
public class Usuario {
    public static ArrayList<String> dificultad = new ArrayList<>();
    public static ArrayList<Usuario> user = new ArrayList<>();
    private String ciudad;
    private String alcalde; 
    private String seleccionarDificultad;

    public Usuario(String ciudad, String alcalde, String seleccionarDificultad) {
        this.ciudad = ciudad;
        this.alcalde = alcalde;
        this.seleccionarDificultad = seleccionarDificultad;
    }
    
    
    
    
  
    public static void UsuarioDificultades(){
        dificultad.add("Facil");
        dificultad.add("Medio");
        dificultad.add("Dificil");
        
        
    }

    
    public static void llenarUsuario(String a, String b, String c){
        user.add(new Usuario(a, b, c));
    }

    @Override
    public String toString() {
        return "Ciudad: " + ciudad +"        Usuario: "+ alcalde +"     Dificultad: "+ seleccionarDificultad ;
    }
    

    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------------
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }

    public String getSeleccionarDificultad() {
        return seleccionarDificultad;
    }

    public void setSeleccionarDificultad(String seleccionarDificultad) {
        this.seleccionarDificultad = seleccionarDificultad;
    }
    
    
    
    
    
    
    
}
