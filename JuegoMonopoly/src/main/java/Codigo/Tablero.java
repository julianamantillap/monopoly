/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author julianamantilla
 */
public class Tablero {
    
    private Casilla[] casillas;

    public Tablero() {
        
        casillas = new Casilla[40];
        
        //Propiedad Cafe
        casillas[1] = new Propiedad("Av. Meditarraneo", 600,20, "Cafe");
        casillas[3] = new Propiedad("Av. Báltico", 600,40,"Cafe");
        
        //Arca Comunal
        casillas[2] = new Casilla("Especial", "Arca Comunal", "Usted hereda 1000");
        casillas[17] = new Casilla("Especial", "Arca Comunal", "Pague al banco 500 para su medico");   
        casillas[33] = new Casilla("Especial", "Arca Comunal", "Pague 1500 para las escuelas");   
             
        //Ferrocarriles
        casillas[5] = new Propiedad("Ferrocarril de Short Line", 2000,250,"Negro");
        casillas[15] = new Propiedad("Ferrocarril de Reading", 2000,250,"Negro");
        casillas[25] = new Propiedad("Ferrocarril de Pensilvania", 2000,250,"Negro");
        casillas[35] = new Propiedad("Ferrocarril de B&O", 2000,250,"Negro");

        //Casillas especiales
        casillas[0] = new Casilla("Especial", "Salida","Gana 2000");
        casillas[4] = new Casilla("Especial","Impuesto","Pierde 2000");
        casillas[10] = new Casilla("Especial", "Carcel", "Descansa");
        casillas[20] = new Casilla("Especial", "Parada", "Descansa");
        casillas[30] = new Casilla("Especial", "Va a la Carcel", "Carcel");
        casillas[38] = new Casilla("Especial","Impuesto2","Pierde 750");
        
        //Propiedad Azul Celeste
        casillas[6] = new Propiedad("Av. Oriental", 1000,60,"Celeste");
        casillas[8] = new Propiedad("Av. Vermont", 1000,60, "Celeste");
        casillas[9] = new Propiedad("Av. Connecticut", 1200, 80, "Celeste");
        
        //Propiedad Rosada
        casillas[11] = new Propiedad("Av. San Carlos", 1400,100,"Rosada");
        casillas[13] = new Propiedad("Av. de Los Estados", 1400,100,"Rosada");
        casillas[14] = new Propiedad("Av. Virginia", 1600, 120,"Rosada");
        
        //Propiedad Servicios Publicos
        casillas[12] = new Propiedad("Servicio Público Energía", 1500, 60,"Gris");
        casillas[28] = new Propiedad("Servicio Público Agua", 1500, 60,"Gris");
        
        //Suerte
        casillas[7] = new Casilla("Especial", "Suerte", "El banco le paga un dividendo de 500");
        casillas[22] = new Casilla("Especial", "Suerte", "Adelante hasta la salida, cobrese 2000");   
        casillas[36] = new Casilla("Especial", "Suerte", "Ha sido elegido presidente de consejo, pague 500");
        
         //Propiedad Naranja
        casillas[16] = new Propiedad("Av. Plaza Santiago", 1800,140,"Naranja");
        casillas[18] = new Propiedad("Av. Av. Tenessee", 1800,140,"Naranja");
        casillas[19] = new Propiedad("Av. Nueva York", 2000, 160,"Naranja");
        
        //Propiedad Roja
        casillas[21] = new Propiedad("Av. Kentucky", 2200,180,"Roja");
        casillas[23] = new Propiedad("Av. Indiana", 2200,200,"Roja");
        casillas[24] = new Propiedad("Av. Illinois", 2400, 200,"Roja");
        
        //Propiedad Amarilla
        casillas[26] = new Propiedad("Av. Atlantico", 2600,220,"Amarilla");
        casillas[27] = new Propiedad("Av. Ventnor", 2600,220,"Amarilla");
        casillas[29] = new Propiedad("Av. Jardines Marvin", 2800, 220,"Amarilla");
        
        //Propiedad Verde
        casillas[31] = new Propiedad("Av. Pacífica", 3000,260,"Verde");
        casillas[32] = new Propiedad("Av. Carolina del Sur", 3000,260,"Verde");
        casillas[34] = new Propiedad("Av. Pensilvania", 3200, 280,"Verde");
        
        //Propiedad Azul Cian
        casillas[37] = new Propiedad("Av. Plaza del Parque", 3500,350,"Cian");
        casillas[39] = new Propiedad("Av. Paseo Tablado", 4000,500,"Cian");
    }

    public Casilla[] getCasillas() {
        return casillas;
    } 
}
