/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Codigo;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author julianamantilla
 */
public class JuegoMonopoly {

    public Tablero tablero;
    private ArrayList<Jugador> jugadores;
    private int turno;

    public JuegoMonopoly() {

        this.jugadores = new ArrayList<>();
        this.tablero = new Tablero();
        this.turno = 1;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void agregarJugador(String nombre) {
        Jugador j = new Jugador(nombre);
        jugadores.add(j);
    }

    public int tirarDado() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        return dado1 + dado2;
    }

    public boolean sacarPar() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        return dado1 == dado2;
    }

    public void cambiarTurno() {
        turno = (turno % jugadores.size()) + 1;
    }

    public String moverJugador() {

        int cantmover = tirarDado();
        String mensaje = "";
        
        if(jugadores.size()<=1){
            JOptionPane.showMessageDialog(null, "El Juego ha terminado");
        }else{
        
        switch (turno) {

            case 1 -> {
                //Validar si esta en la carcel
                if (jugadores.get(0).isEncarcelado()) {
                    if (jugadores.get(0).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(0).setTurnoscarcel(3);
                            jugadores.get(0).setEncarcelado(false);
                        } else {
                            jugadores.get(0).setTurnoscarcel(jugadores.get(0).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(0).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() - 500);
                        jugadores.get(0).setTurnoscarcel(3);
                        jugadores.get(0).setEncarcelado(false);
                        verificarGanador(jugadores.get(0));
                    }
                } else {
                    jugadores.get(0).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(0).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(0), p) == null) {
                            if (jugadores.get(0).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(0), p).getNombre().equals(jugadores.get(0).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(0), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(0));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() - 1500);
                                        verificarGanador(jugadores.get(0));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() + 2000);
                                        jugadores.get(0).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                        jugadores.get(0).setDinero(jugadores.get(0).getDinero() - 500);
                                        verificarGanador(jugadores.get(0));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                jugadores.get(0).setDinero(jugadores.get(0).getDinero() - 2000);
                                verificarGanador(jugadores.get(0));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                jugadores.get(0).setPosicion(10);
                                jugadores.get(0).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(0).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(0).getPosicion()].getEfecto();
                                jugadores.get(0).setDinero(jugadores.get(0).getDinero() - 750);
                                verificarGanador(jugadores.get(0));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            case 2 -> {

                //Validar si esta en la carcel
                if (jugadores.get(1).isEncarcelado()) {
                    if (jugadores.get(1).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(1).setTurnoscarcel(3);
                            jugadores.get(1).setEncarcelado(false);
                        } else {
                            jugadores.get(1).setTurnoscarcel(jugadores.get(1).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(1).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() - 500);
                        jugadores.get(1).setTurnoscarcel(3);
                        jugadores.get(1).setEncarcelado(false);
                        verificarGanador(jugadores.get(1));
                    }
                } else {
                    jugadores.get(1).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(1).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(1), p) == null) {
                            if (jugadores.get(1).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(1), p).getNombre().equals(jugadores.get(1).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(1), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(1));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() - 1500);
                                        verificarGanador(jugadores.get(1));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() + 2000);
                                        jugadores.get(1).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                        jugadores.get(1).setDinero(jugadores.get(1).getDinero() - 500);
                                        verificarGanador(jugadores.get(1));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                jugadores.get(1).setDinero(jugadores.get(1).getDinero() - 2000);
                                verificarGanador(jugadores.get(1));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                jugadores.get(1).setPosicion(10);
                                jugadores.get(1).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(1).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(1).getPosicion()].getEfecto();
                                jugadores.get(1).setDinero(jugadores.get(1).getDinero() - 750);
                                verificarGanador(jugadores.get(1));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            case 3 -> {

                //Validar si esta en la carcel
                if (jugadores.get(2).isEncarcelado()) {
                    if (jugadores.get(2).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(2).setTurnoscarcel(3);
                            jugadores.get(2).setEncarcelado(false);
                        } else {
                            jugadores.get(2).setTurnoscarcel(jugadores.get(2).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(2).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 500);
                        jugadores.get(2).setTurnoscarcel(3);
                        jugadores.get(2).setEncarcelado(false);
                        verificarGanador(jugadores.get(2));
                    }
                } else {
                    jugadores.get(2).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(2).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(2), p) == null) {
                            if (jugadores.get(2).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(2), p).getNombre().equals(jugadores.get(2).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(2), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(2));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 1500);
                                        verificarGanador(jugadores.get(2));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() + 2000);
                                        jugadores.get(2).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 500);
                                        verificarGanador(jugadores.get(2));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 2000);
                                verificarGanador(jugadores.get(2));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                jugadores.get(2).setPosicion(10);
                                jugadores.get(2).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(2).getPosicion()].getEfecto();
                                jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 750);
                                verificarGanador(jugadores.get(2));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            case 4 -> {

                //Validar si esta en la carcel
                if (jugadores.get(3).isEncarcelado()) {
                    if (jugadores.get(3).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(3).setTurnoscarcel(3);
                            jugadores.get(3).setEncarcelado(false);
                        } else {
                            jugadores.get(3).setTurnoscarcel(jugadores.get(3).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(3).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() - 500);
                        jugadores.get(3).setTurnoscarcel(3);
                        jugadores.get(3).setEncarcelado(false);
                        verificarGanador(jugadores.get(3));
                    }
                } else {
                    jugadores.get(3).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(3).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(3), p) == null) {
                            if (jugadores.get(3).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(3), p).getNombre().equals(jugadores.get(3).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(3), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(3));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() - 1500);
                                        verificarGanador(jugadores.get(3));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(3).setDinero(jugadores.get(3).getDinero() + 2000);
                                        jugadores.get(3).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(2).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                        jugadores.get(2).setDinero(jugadores.get(2).getDinero() - 500);
                                        verificarGanador(jugadores.get(3));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                jugadores.get(3).setDinero(jugadores.get(3).getDinero() - 2000);
                                verificarGanador(jugadores.get(3));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                jugadores.get(3).setPosicion(10);
                                jugadores.get(3).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(3).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(3).getPosicion()].getEfecto();
                                jugadores.get(3).setDinero(jugadores.get(3).getDinero() - 750);
                                verificarGanador(jugadores.get(3));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            case 5 -> {

                //Validar si esta en la carcel
                if (jugadores.get(4).isEncarcelado()) {
                    if (jugadores.get(4).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(4).setTurnoscarcel(3);
                            jugadores.get(4).setEncarcelado(false);
                        } else {
                            jugadores.get(4).setTurnoscarcel(jugadores.get(4).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(4).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() - 500);
                        jugadores.get(4).setTurnoscarcel(3);
                        jugadores.get(4).setEncarcelado(false);
                        verificarGanador(jugadores.get(4));
                    }
                } else {
                    jugadores.get(4).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(4).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(4), p) == null) {
                            if (jugadores.get(4).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(4), p).getNombre().equals(jugadores.get(4).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(4), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(4));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() - 1500);
                                        verificarGanador(jugadores.get(4));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() + 2000);
                                        jugadores.get(4).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                        jugadores.get(4).setDinero(jugadores.get(4).getDinero() - 500);
                                        verificarGanador(jugadores.get(4));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                jugadores.get(4).setDinero(jugadores.get(4).getDinero() - 2000);
                                verificarGanador(jugadores.get(4));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                jugadores.get(4).setPosicion(10);
                                jugadores.get(4).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(4).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(4).getPosicion()].getEfecto();
                                jugadores.get(4).setDinero(jugadores.get(4).getDinero() - 750);
                                verificarGanador(jugadores.get(4));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            case 6 -> {

                //Validar si esta en la carcel
                if (jugadores.get(5).isEncarcelado()) {
                    if (jugadores.get(5).getTurnoscarcel() > 0) {
                        if (sacarPar()) {
                            JOptionPane.showMessageDialog(null, "Sacaste par, has salido de la carcel");
                            jugadores.get(5).setTurnoscarcel(3);
                            jugadores.get(5).setEncarcelado(false);
                        } else {
                            jugadores.get(5).setTurnoscarcel(jugadores.get(5).getTurnoscarcel() - 1);
                            cambiarTurno();
                            return "No ha sacado par, le quedan: " + jugadores.get(5).getTurnoscarcel() + " intentos";
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha sido multado para salir de la carcel por valor de 500");
                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() - 500);
                        jugadores.get(5).setTurnoscarcel(3);
                        jugadores.get(5).setEncarcelado(false);
                        verificarGanador(jugadores.get(5));
                    }
                } else {
                    jugadores.get(5).mover(cantmover);
                    mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha tirado los dados y sacó: " + cantmover + "\n";

                    if (tablero.getCasillas()[jugadores.get(5).getPosicion()] instanceof Propiedad p) {

                        if (buscarPropiedad(jugadores.get(5), p) == null) {
                            if (jugadores.get(5).comprarPropiedad(p)) {
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", y la ha comprado por: " + p.getCosto();
                            } else {
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", pero no cuenta con suficiente dinero para comprarla";
                            }
                        } else if (buscarPropiedad(jugadores.get(5), p).getNombre().equals(jugadores.get(5).getNombre())) {
                            mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual le pertence a el.";
                        } else {
                            mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la propiedad: " + p.getNombre() + ", la cual pertenece al jugador " + buscarPropiedad(jugadores.get(2), p).getNombre() + " y debe pagarle " + p.getRenta() + " de alquiler.";
                            verificarGanador(jugadores.get(5));
                        }
                    } else {
                        switch (tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre()) {

                            case "Arca Comunal":

                                switch (tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto()) {

                                    case "Usted hereda 1000":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() + 1000);
                                        break;
                                    case "Pague al banco 500 para su medico":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() + 1000);
                                        break;
                                    case "Pague 1500 para las escuelas":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() - 1500);
                                        verificarGanador(jugadores.get(5));
                                        break;
                                }
                                break;
                            case "Suerte":

                                switch (tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto()) {

                                    case "El banco le paga un dividendo de 500":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() + 500);
                                        break;
                                    case "Adelante hasta la salida, cobrese 2000":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() + 2000);
                                        jugadores.get(5).setPosicion(0);
                                        break;
                                    case "Ha sido elegido presidente de consejo, pague 500":
                                        mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                        jugadores.get(5).setDinero(jugadores.get(5).getDinero() - 500);
                                        verificarGanador(jugadores.get(5));
                                        break;
                                }
                                break;
                            case "Parada":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                break;
                            case "Salida":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                break;
                            case "Carcel":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                break;
                            case "Impuesto":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                jugadores.get(5).setDinero(jugadores.get(5).getDinero() - 2000);
                                verificarGanador(jugadores.get(5));
                                break;
                            case "Va a la Carcel":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                jugadores.get(5).setPosicion(10);
                                jugadores.get(5).setEncarcelado(true);
                                JOptionPane.showMessageDialog(null, "Has caido en la carcel, tiene tres turnos para sacar par o se le cobrará una multa de 500");
                                break;
                            case "Impuesto2":
                                mensaje += "El jugador " + jugadores.get(5).getNombre() + " ha caído en la casilla: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getNombre() + ", la cual tiene el siguiente efecto: " + tablero.getCasillas()[jugadores.get(5).getPosicion()].getEfecto();
                                jugadores.get(5).setDinero(jugadores.get(5).getDinero() - 750);
                                verificarGanador(jugadores.get(5));
                                break;
                        }
                    }
                    cambiarTurno();
                }

                break;
            }
            default -> {

                break;
            }

        }
    }
        return mensaje;
    }

    private Jugador buscarPropiedad(Jugador j1, Propiedad p) {

        for (Jugador j : jugadores) {
            if (j.getPatrimonio().contains(p)) {
                j1.setDinero(j1.getDinero() - p.getRenta());
                jugadores.set(jugadores.indexOf(j1), j1);
                j.setDinero(j.getDinero() + p.getRenta());
                jugadores.set(jugadores.indexOf(j), j);
                return j;
            }
        }
        return null;
    }

    public void verificarGanador(Jugador j) {
        
        if(j.getDinero()<=0){
            JOptionPane.showMessageDialog(null, "¡El jugador " + j.getNombre() + " ha perdido! Se quedó sin dinero.");
            System.out.println(jugadores.remove(j));
        }
        
        if (jugadores.size() > 1) {
            // Si hay más de un jugador, continúa el juego.
            cambiarTurno();
        } else {
            // Si solo queda un jugador, termina el juego.
            JOptionPane.showMessageDialog(null, "¡El jugador " + jugadores.get(0).getNombre() + " ha ganado el juego!");
            // Aquí puedes agregar lógica para terminar el juego si es necesario.
        }
    }
    
    public void registrarDineroInicial(int dinero){
        for (Jugador j : jugadores)
            j.setDinero(dinero); 
    }
    
    public Jugador venderPropiedad(Jugador vendedor, String comprador, Propiedad p, int valor){
        
        for(Jugador j:jugadores){
            if(j.getNombre().equals(comprador)){
                p.setCosto(valor);
                if(j.comprarPropiedad(p)){
                    vendedor.setDinero(vendedor.getDinero()+valor);
                    vendedor.getPatrimonio().remove(p);
                }
            }
        }
    return vendedor;
        
    }

}
