/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author julianamantilla
 */
public class Propiedad extends Casilla{
    
    private String nombre;
    private int costo;
    private int renta;
    private String color;

    public Propiedad() {
    }

    public Propiedad(String nombre, int costo, int renta, String color) {
        this.nombre = nombre;
        this.costo = costo;
        this.renta = renta;
        this.color = color;        
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    @Override
    public String toString() {
        return "Nombre de Propiedad: "+this.nombre+"\n"+
                "Grupo o Color:" +this.color+"\n"+
                "Costo de Compra: "+this.costo+"\n"+
                "Costo de Alquiler "+this.renta;
    }
}
