/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projectgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ECUADOR
 */
public class Servicio {
    
    private String nombre;
    private String ruta;
    private int precioConstruccion;
    private int costoMensual;

    public Servicio(String nombre, String ruta, int precioConstruccion, int costoMensual) {
        this.nombre = nombre;
        this.ruta = ruta;
        this.precioConstruccion = precioConstruccion;
        this.costoMensual = costoMensual;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public int getPrecioConstruccion() {
        return precioConstruccion;
    }

    public int getCostoMensual() {
        return costoMensual;
    }

    
 @Override
    public String toString() {
        
        return nombre;
    }
 
    
}
