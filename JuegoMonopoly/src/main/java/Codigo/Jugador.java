/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author julianamantilla
 */
public class Jugador {

    private String nombre;
    private int posicion;
    private int dinero;
    private ArrayList<Propiedad> patrimonio;
    private boolean encarcelado;
    private int turnoscarcel;
    private int contcafe;
    private int contceleste;
    private int controsada;
    private int contnaranja;
    private int controja;
    private int contamarilla;
    private int contverde;
    private int contcian;
    private int contnegra;
    private int contgris;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.dinero = 0;
        this.patrimonio = new ArrayList<>();
        this.encarcelado = false;
        this.turnoscarcel = 3;
        contcafe = 0;
        contceleste = 0;
        controsada = 0;
        contnaranja = 0;
        controja = 0;
        contamarilla = 0;
        contverde = 0;
        contcian = 0;
        contnegra = 0;
        contgris = 0;
    }

    public void mover(int espacios) {
        posicion += espacios;
        if (posicion >= 40) {
            posicion = posicion % 40;
            dinero += 2000;
            JOptionPane.showMessageDialog(null, "Has cruzado la linea de salida, ganaste 2000");
        }
    }

    public boolean isEncarcelado() {
        return encarcelado;
    }

    public void setEncarcelado(boolean encarcelado) {
        this.encarcelado = encarcelado;
    }

    public int getTurnoscarcel() {
        return turnoscarcel;
    }

    public void setTurnoscarcel(int turnoscarcel) {
        this.turnoscarcel = turnoscarcel;
    }

    public ArrayList<Propiedad> getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(ArrayList<Propiedad> patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean comprarPropiedad(Propiedad p) {

        if (this.dinero < p.getCosto()) {
            return false;
        } else {
            dinero = dinero - p.getCosto();
            patrimonio.add(p);

            switch (p.getColor()) {
                case "Cafe" ->
                    contcafe++;
                case "Negro" ->
                    contnegra++;
                case "Celeste" ->
                    contceleste++;
                case "Rosada" ->
                    controsada++;
                case "Gris" ->
                    contgris++;
                case "Naranja" ->
                    contnaranja++;
                case "Roja" ->
                    controja++;
                case "Amarilla" ->
                    contamarilla++;
                case "Verde" ->
                    contverde++;
                case "Cian" ->
                    contcian++;
            }
            validarGrupo();
        }
        return true;
    }

    public void validarGrupo() {

        if (contcafe == 2) {

            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Cafe")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contcafe=0;
        }
        if (contceleste == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Celeste")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contceleste=0;
        }
        if (controsada == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Rosada")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            controsada=0;
        }
        if (contgris == 2) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Gris")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contgris=0;
        }
        if (contnaranja == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Naranja")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contnaranja=0;
        }
        if (controja == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Roja")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            controja=0;
        }
        if (contamarilla == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Amarilla")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contamarilla=0;
        }
        if (contverde == 3) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Verde")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contverde=0;
        }
        if (contcian == 2) {
            for (Propiedad p : patrimonio) {
                if (p.getColor().equals("Cian")) {
                    p.setRenta(p.getRenta() * 2);
                    patrimonio.set(patrimonio.indexOf(p), p);
                }
            }
            contcian=0;
        }
        switch (contnegra) {
            case 2 -> {
                for (Propiedad p : patrimonio) {
                    if (p.getColor().equals("Negro")) {
                        p.setRenta(p.getRenta() * 2);
                        patrimonio.set(patrimonio.indexOf(p), p);
                    }
                }
                contnegra--;
            }
            case 3 -> {
                for (Propiedad p : patrimonio) {
                    if (p.getColor().equals("Negro")) {
                        p.setRenta(p.getRenta() * 3);
                        patrimonio.set(patrimonio.indexOf(p), p);
                    }
                }
            }
            case 4 -> {
                for (Propiedad p : patrimonio) {
                    if (p.getColor().equals("Negro")) {
                        p.setRenta(p.getRenta() * 4);
                        patrimonio.set(patrimonio.indexOf(p), p);
                    }
                }
            }
            default -> {
            }
        }
    }

    public String listarPatrimonio() {

        String mensaje = "";

        for (Propiedad p : patrimonio) {
            mensaje += p.getColor() + "\n" + p.getNombre() + "\n" + p.getRenta() + "\n";
        }

        return mensaje;
    }
}
