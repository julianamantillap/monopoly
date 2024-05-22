/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz;

import Codigo.JuegoMonopoly;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class BoardGame extends javax.swing.JFrame {

    String basePath = System.getProperty("user.dir");
    String ruta = basePath + "\\src\\main\\java\\Imagenes\\";
    private JuegoMonopoly juego;
    private HistorialJugadas hj;

    /**
     * Creates new form BoardGame
     */
    public BoardGame(JuegoMonopoly juego) {
        initComponents();
        this.juego = juego;
        cargarTablero();
        this.hj = new HistorialJugadas();
    }

    private BoardGame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void actualizarDinero(){
        
        switch(this.juego.getJugadores().size()){
            case 3 ->{
                this.hj.getTxtDinero1().setText(String.valueOf(this.juego.getJugadores().get(0).getDinero()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).getDinero()));
                this.hj.getTxtDinero3().setText(String.valueOf(this.juego.getJugadores().get(2).getDinero()));                
                break;
            }
            case 4 ->{
                this.hj.getTxtDinero1().setText(String.valueOf(this.juego.getJugadores().get(0).getDinero()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).getDinero()));
                this.hj.getTxtDinero3().setText(String.valueOf(this.juego.getJugadores().get(2).getDinero()));                
                this.hj.getTxtDinero4().setText(String.valueOf(this.juego.getJugadores().get(3).getDinero()));
                break;
            }
            case 5 ->{
                this.hj.getTxtDinero1().setText(String.valueOf(this.juego.getJugadores().get(0).getDinero()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).getDinero()));
                this.hj.getTxtDinero3().setText(String.valueOf(this.juego.getJugadores().get(2).getDinero()));                
                this.hj.getTxtDinero4().setText(String.valueOf(this.juego.getJugadores().get(3).getDinero()));
                this.hj.getTxtDinero5().setText(String.valueOf(this.juego.getJugadores().get(4).getDinero()));
                break;
            }
            case 6 ->{
                this.hj.getTxtDinero1().setText(String.valueOf(this.juego.getJugadores().get(0).getDinero()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).getDinero()));
                this.hj.getTxtDinero3().setText(String.valueOf(this.juego.getJugadores().get(2).getDinero()));                
                this.hj.getTxtDinero4().setText(String.valueOf(this.juego.getJugadores().get(3).getDinero()));
                this.hj.getTxtDinero5().setText(String.valueOf(this.juego.getJugadores().get(4).getDinero()));
                this.hj.getTxtDinero6().setText(String.valueOf(this.juego.getJugadores().get(5).getDinero()));
                break;       
            }
            default ->{
                this.hj.getTxtDinero1().setText(String.valueOf(this.juego.getJugadores().get(0).getDinero()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).getDinero()));
                break;
            }
        }    
    }
    
    public void actualizarPropiedades(){
        switch(this.juego.getJugadores().size()){
            case 3 ->{
                this.hj.getTxtJuego1().setText(String.valueOf(this.juego.getJugadores().get(0).listarPatrimonio()));
                this.hj.getTxtJuego2().setText(String.valueOf(this.juego.getJugadores().get(1).listarPatrimonio()));
                this.hj.getTxtJuego3().setText(String.valueOf(this.juego.getJugadores().get(2).listarPatrimonio()));                
                break;
            }
            case 4 ->{
                this.hj.getTxtJuego1().setText(String.valueOf(this.juego.getJugadores().get(0).listarPatrimonio()));
                this.hj.getTxtJuego2().setText(String.valueOf(this.juego.getJugadores().get(1).listarPatrimonio()));
                this.hj.getTxtJuego3().setText(String.valueOf(this.juego.getJugadores().get(2).listarPatrimonio()));                
                this.hj.getTxtJuego4().setText(String.valueOf(this.juego.getJugadores().get(3).listarPatrimonio()));
                break;
            }
            case 5 ->{
                this.hj.getTxtJuego1().setText(String.valueOf(this.juego.getJugadores().get(0).listarPatrimonio()));
                this.hj.getTxtJuego2().setText(String.valueOf(this.juego.getJugadores().get(1).listarPatrimonio()));
                this.hj.getTxtJuego3().setText(String.valueOf(this.juego.getJugadores().get(2).listarPatrimonio()));                
                this.hj.getTxtJuego4().setText(String.valueOf(this.juego.getJugadores().get(3).listarPatrimonio()));
                this.hj.getTxtJuego5().setText(String.valueOf(this.juego.getJugadores().get(4).listarPatrimonio()));
                break;
            }
            case 6 ->{
                this.hj.getTxtJuego1().setText(String.valueOf(this.juego.getJugadores().get(0).listarPatrimonio()));
                this.hj.getTxtDinero2().setText(String.valueOf(this.juego.getJugadores().get(1).listarPatrimonio()));
                this.hj.getTxtJuego3().setText(String.valueOf(this.juego.getJugadores().get(2).listarPatrimonio()));                
                this.hj.getTxtJuego4().setText(String.valueOf(this.juego.getJugadores().get(3).listarPatrimonio()));
                this.hj.getTxtJuego5().setText(String.valueOf(this.juego.getJugadores().get(4).listarPatrimonio()));
                this.hj.getTxtJuego6().setText(String.valueOf(this.juego.getJugadores().get(5).listarPatrimonio()));
                break;       
            }
            default ->{
                this.hj.getTxtJuego1().setText(String.valueOf(this.juego.getJugadores().get(0).listarPatrimonio()));
                this.hj.getTxtJuego2().setText(String.valueOf(this.juego.getJugadores().get(1).listarPatrimonio()));
                break;
            }
        }  
    }

    public void cargarTablero() {
        ImageIcon iconsalida = new ImageIcon(ruta + "salida.jpg");
        this.salida.setIcon(iconsalida);
        ImageIcon iconcafe1 = new ImageIcon(ruta + "cafe1.jpg");
        this.cafe1.setIcon(iconcafe1);
        ImageIcon iconarcacomunal1 = new ImageIcon(ruta + "arcacomunal1.jpg");
        this.arcacomunal1.setIcon(iconarcacomunal1);
        ImageIcon iconcafe2 = new ImageIcon(ruta + "cafe2.jpg");
        this.cafe2.setIcon(iconcafe2);
        ImageIcon iconimpuesto = new ImageIcon(ruta + "impuesto.jpg");
        this.impuesto.setIcon(iconimpuesto);
        ImageIcon icontren1 = new ImageIcon(ruta + "tren1.jpg");
        this.tren1.setIcon(icontren1);
        ImageIcon iconazul1 = new ImageIcon(ruta + "azul1.jpg");
        this.azul1.setIcon(iconazul1);
        ImageIcon iconsuerte1 = new ImageIcon(ruta + "suerte1.jpg");
        this.suerte1.setIcon(iconsuerte1);
        ImageIcon iconazul2 = new ImageIcon(ruta + "azul2.jpg");
        this.azul2.setIcon(iconazul2);
        ImageIcon iconazul3 = new ImageIcon(ruta + "azul3.jpg");
        this.azul3.setIcon(iconazul3);
        ImageIcon iconcarcel = new ImageIcon(ruta + "carcel.jpg");
        this.carcel.setIcon(iconcarcel);
        
        ImageIcon iconrosada1 = new ImageIcon(ruta + "rosada1.jpg");
        this.rosada1.setIcon(iconrosada1);
        ImageIcon iconservicios1 = new ImageIcon(ruta + "serviciospublicos2.jpg");
        this.servicios1.setIcon(iconservicios1);
        ImageIcon iconrosada2 = new ImageIcon(ruta + "rosada2.jpg");
        this.rosada2.setIcon(iconrosada2);
        ImageIcon iconrosada3 = new ImageIcon(ruta + "rosada3.jpg");
        this.rosada3.setIcon(iconrosada3);
        ImageIcon icontren2 = new ImageIcon(ruta + "tren2.jpg");
        this.tren2.setIcon(icontren2);
        ImageIcon iconnaranja1 = new ImageIcon(ruta + "naranja1.jpg");
        this.naranja1.setIcon(iconnaranja1);
        ImageIcon iconarcacomunal2 = new ImageIcon(ruta + "arcacomunal2.jpg");
        this.arcacomunal2.setIcon(iconarcacomunal2);
        ImageIcon iconnaranja2 = new ImageIcon(ruta + "naranja2.jpg");
        this.naranja2.setIcon(iconnaranja2);
        ImageIcon iconnaranja3 = new ImageIcon(ruta + "naranja3.jpg");
        this.naranja3.setIcon(iconnaranja3);
        ImageIcon iconparqueo = new ImageIcon(ruta + "parqueolibre.jpg");
        this.parqueolibre.setIcon(iconparqueo);
        
        ImageIcon iconrojo1 = new ImageIcon(ruta + "roja1.jpg");
        this.rojo1.setIcon(iconrojo1);
        ImageIcon iconsuerte2 = new ImageIcon(ruta + "suerte2.jpg");
        this.suerte2.setIcon(iconsuerte2);
        ImageIcon iconrojo2 = new ImageIcon(ruta + "roja2.jpg");
        this.rojo2.setIcon(iconrojo2);
        ImageIcon iconrojo3 = new ImageIcon(ruta + "roja3.jpg");
        this.rojo3.setIcon(iconrojo3);
        ImageIcon icontren3 = new ImageIcon(ruta + "tren3.jpg");
        this.tren3.setIcon(icontren3);
        ImageIcon iconamarillo1 = new ImageIcon(ruta + "amarillo1.jpg");
        this.amarillo1.setIcon(iconamarillo1);
        ImageIcon iconamarillo2 = new ImageIcon(ruta + "amarillo2.jpg");
        this.amarillo2.setIcon(iconamarillo2);
        ImageIcon iconservicios2 = new ImageIcon(ruta + "serviciospublicos1.jpg");
        this.servicios2.setIcon(iconservicios2);
        ImageIcon iconamarillo3 = new ImageIcon(ruta + "amarillo3.jpg");
        this.amarillo3.setIcon(iconamarillo3);
        ImageIcon iconalacarcel = new ImageIcon(ruta + "alacarcel.jpg");
        this.alacarcel.setIcon(iconalacarcel);
        
        ImageIcon iconverde1 = new ImageIcon(ruta + "verde1.jpg");
        this.verde1.setIcon(iconverde1);
        ImageIcon iconverde2 = new ImageIcon(ruta + "verde2.jpg");
        this.verde2.setIcon(iconverde2);
        ImageIcon iconarcacomunal3 = new ImageIcon(ruta + "arcacomunal3.jpg");
        this.arcacomunal3.setIcon(iconarcacomunal3);
        ImageIcon iconverde3 = new ImageIcon(ruta + "verde3.jpg");
        this.verde3.setIcon(iconverde3);
        ImageIcon icontren4 = new ImageIcon(ruta + "tren4.jpg");
        this.tren4.setIcon(icontren4);
        ImageIcon iconsuerte3 = new ImageIcon(ruta + "suerte3.jpg");
        this.suerte3.setIcon(iconsuerte3);
        ImageIcon iconcian1 = new ImageIcon(ruta + "cian1.jpg");
        this.cian1.setIcon(iconcian1);
        ImageIcon icontarifa = new ImageIcon(ruta + "tarifa.jpg");
        this.tarifa.setIcon(icontarifa);
        ImageIcon iconcian2 = new ImageIcon(ruta + "cian2.jpg");
        this.cian2.setIcon(iconcian2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rosada2 = new javax.swing.JButton();
        servicios1 = new javax.swing.JButton();
        rojo3 = new javax.swing.JButton();
        rosada1 = new javax.swing.JButton();
        tren3 = new javax.swing.JButton();
        amarillo1 = new javax.swing.JButton();
        amarillo2 = new javax.swing.JButton();
        rojo2 = new javax.swing.JButton();
        parqueolibre = new javax.swing.JButton();
        rojo1 = new javax.swing.JButton();
        servicios2 = new javax.swing.JButton();
        alacarcel = new javax.swing.JButton();
        amarillo3 = new javax.swing.JButton();
        arcacomunal1 = new javax.swing.JButton();
        salida = new javax.swing.JButton();
        cafe1 = new javax.swing.JButton();
        azul2 = new javax.swing.JButton();
        azul1 = new javax.swing.JButton();
        tren1 = new javax.swing.JButton();
        impuesto = new javax.swing.JButton();
        naranja2 = new javax.swing.JButton();
        cafe2 = new javax.swing.JButton();
        arcacomunal2 = new javax.swing.JButton();
        naranja3 = new javax.swing.JButton();
        suerte1 = new javax.swing.JButton();
        naranja1 = new javax.swing.JButton();
        carcel = new javax.swing.JButton();
        tren2 = new javax.swing.JButton();
        azul3 = new javax.swing.JButton();
        rosada3 = new javax.swing.JButton();
        suerte2 = new javax.swing.JButton();
        verde1 = new javax.swing.JButton();
        verde2 = new javax.swing.JButton();
        arcacomunal3 = new javax.swing.JButton();
        verde3 = new javax.swing.JButton();
        tren4 = new javax.swing.JButton();
        suerte3 = new javax.swing.JButton();
        cian1 = new javax.swing.JButton();
        tarifa = new javax.swing.JButton();
        cian2 = new javax.swing.JButton();
        Jugar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();
        Iniciar = new javax.swing.JButton();
        txtTurno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        MercadoPropiedad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Monopoly");
        setMaximumSize(new java.awt.Dimension(1120, 900));
        setMinimumSize(new java.awt.Dimension(1120, 900));
        setPreferredSize(new java.awt.Dimension(1120, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jPanel1.setAlignmentX(1.0F);
        jPanel1.setAlignmentY(1.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(1120, 900));
        jPanel1.setMinimumSize(new java.awt.Dimension(1120, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(1120, 900));

        rosada2.setMaximumSize(new java.awt.Dimension(100, 60));
        rosada2.setMinimumSize(new java.awt.Dimension(100, 60));
        rosada2.setPreferredSize(new java.awt.Dimension(100, 60));

        servicios1.setMaximumSize(new java.awt.Dimension(100, 60));
        servicios1.setMinimumSize(new java.awt.Dimension(100, 60));
        servicios1.setPreferredSize(new java.awt.Dimension(100, 60));

        rojo3.setMaximumSize(new java.awt.Dimension(60, 100));
        rojo3.setMinimumSize(new java.awt.Dimension(60, 100));
        rojo3.setPreferredSize(new java.awt.Dimension(60, 100));

        rosada1.setMaximumSize(new java.awt.Dimension(100, 60));
        rosada1.setMinimumSize(new java.awt.Dimension(100, 60));
        rosada1.setPreferredSize(new java.awt.Dimension(100, 60));

        tren3.setMaximumSize(new java.awt.Dimension(60, 100));
        tren3.setMinimumSize(new java.awt.Dimension(60, 100));
        tren3.setPreferredSize(new java.awt.Dimension(60, 100));

        amarillo1.setMaximumSize(new java.awt.Dimension(60, 100));
        amarillo1.setMinimumSize(new java.awt.Dimension(60, 100));
        amarillo1.setPreferredSize(new java.awt.Dimension(60, 100));

        amarillo2.setMaximumSize(new java.awt.Dimension(60, 100));
        amarillo2.setMinimumSize(new java.awt.Dimension(60, 100));
        amarillo2.setPreferredSize(new java.awt.Dimension(60, 100));

        rojo2.setMaximumSize(new java.awt.Dimension(60, 100));
        rojo2.setMinimumSize(new java.awt.Dimension(60, 100));
        rojo2.setPreferredSize(new java.awt.Dimension(60, 100));

        parqueolibre.setMaximumSize(new java.awt.Dimension(60, 100));
        parqueolibre.setMinimumSize(new java.awt.Dimension(60, 100));
        parqueolibre.setPreferredSize(new java.awt.Dimension(60, 100));

        rojo1.setMaximumSize(new java.awt.Dimension(60, 100));
        rojo1.setMinimumSize(new java.awt.Dimension(60, 100));
        rojo1.setPreferredSize(new java.awt.Dimension(60, 100));

        servicios2.setMaximumSize(new java.awt.Dimension(60, 100));
        servicios2.setMinimumSize(new java.awt.Dimension(60, 100));
        servicios2.setPreferredSize(new java.awt.Dimension(60, 100));

        alacarcel.setMaximumSize(new java.awt.Dimension(60, 100));
        alacarcel.setMinimumSize(new java.awt.Dimension(60, 100));
        alacarcel.setPreferredSize(new java.awt.Dimension(60, 100));

        amarillo3.setMaximumSize(new java.awt.Dimension(60, 100));
        amarillo3.setMinimumSize(new java.awt.Dimension(60, 100));
        amarillo3.setPreferredSize(new java.awt.Dimension(60, 100));

        arcacomunal1.setMaximumSize(new java.awt.Dimension(60, 100));
        arcacomunal1.setMinimumSize(new java.awt.Dimension(60, 100));
        arcacomunal1.setPreferredSize(new java.awt.Dimension(60, 100));

        salida.setMaximumSize(new java.awt.Dimension(60, 100));
        salida.setMinimumSize(new java.awt.Dimension(60, 100));
        salida.setPreferredSize(new java.awt.Dimension(60, 100));

        cafe1.setMaximumSize(new java.awt.Dimension(60, 100));
        cafe1.setMinimumSize(new java.awt.Dimension(60, 100));
        cafe1.setPreferredSize(new java.awt.Dimension(60, 100));

        azul2.setMaximumSize(new java.awt.Dimension(60, 100));
        azul2.setMinimumSize(new java.awt.Dimension(60, 100));
        azul2.setPreferredSize(new java.awt.Dimension(60, 100));

        azul1.setMaximumSize(new java.awt.Dimension(60, 100));
        azul1.setMinimumSize(new java.awt.Dimension(60, 100));
        azul1.setPreferredSize(new java.awt.Dimension(60, 100));

        tren1.setMaximumSize(new java.awt.Dimension(60, 100));
        tren1.setMinimumSize(new java.awt.Dimension(60, 100));
        tren1.setPreferredSize(new java.awt.Dimension(60, 100));

        impuesto.setMaximumSize(new java.awt.Dimension(60, 100));
        impuesto.setMinimumSize(new java.awt.Dimension(60, 100));
        impuesto.setPreferredSize(new java.awt.Dimension(60, 100));

        naranja2.setMaximumSize(new java.awt.Dimension(100, 60));
        naranja2.setMinimumSize(new java.awt.Dimension(100, 60));
        naranja2.setPreferredSize(new java.awt.Dimension(100, 60));

        cafe2.setMaximumSize(new java.awt.Dimension(60, 100));
        cafe2.setMinimumSize(new java.awt.Dimension(60, 100));
        cafe2.setPreferredSize(new java.awt.Dimension(60, 100));

        arcacomunal2.setMaximumSize(new java.awt.Dimension(100, 60));
        arcacomunal2.setMinimumSize(new java.awt.Dimension(100, 60));
        arcacomunal2.setPreferredSize(new java.awt.Dimension(100, 60));

        naranja3.setMaximumSize(new java.awt.Dimension(100, 60));
        naranja3.setMinimumSize(new java.awt.Dimension(100, 60));
        naranja3.setPreferredSize(new java.awt.Dimension(100, 60));

        suerte1.setMaximumSize(new java.awt.Dimension(60, 100));
        suerte1.setMinimumSize(new java.awt.Dimension(60, 100));
        suerte1.setPreferredSize(new java.awt.Dimension(60, 100));

        naranja1.setMaximumSize(new java.awt.Dimension(100, 60));
        naranja1.setMinimumSize(new java.awt.Dimension(100, 60));
        naranja1.setPreferredSize(new java.awt.Dimension(100, 60));

        carcel.setMaximumSize(new java.awt.Dimension(60, 100));
        carcel.setMinimumSize(new java.awt.Dimension(60, 100));
        carcel.setPreferredSize(new java.awt.Dimension(60, 100));

        tren2.setMaximumSize(new java.awt.Dimension(100, 60));
        tren2.setMinimumSize(new java.awt.Dimension(100, 60));
        tren2.setPreferredSize(new java.awt.Dimension(100, 60));

        azul3.setMaximumSize(new java.awt.Dimension(60, 100));
        azul3.setMinimumSize(new java.awt.Dimension(60, 100));
        azul3.setPreferredSize(new java.awt.Dimension(60, 100));

        rosada3.setMaximumSize(new java.awt.Dimension(100, 60));
        rosada3.setMinimumSize(new java.awt.Dimension(100, 60));
        rosada3.setPreferredSize(new java.awt.Dimension(100, 60));

        suerte2.setMaximumSize(new java.awt.Dimension(60, 100));
        suerte2.setMinimumSize(new java.awt.Dimension(60, 100));
        suerte2.setPreferredSize(new java.awt.Dimension(60, 100));

        verde1.setMaximumSize(new java.awt.Dimension(100, 60));
        verde1.setMinimumSize(new java.awt.Dimension(100, 60));
        verde1.setPreferredSize(new java.awt.Dimension(100, 60));

        verde2.setMaximumSize(new java.awt.Dimension(100, 60));
        verde2.setMinimumSize(new java.awt.Dimension(100, 60));
        verde2.setPreferredSize(new java.awt.Dimension(100, 60));

        arcacomunal3.setMaximumSize(new java.awt.Dimension(100, 60));
        arcacomunal3.setMinimumSize(new java.awt.Dimension(100, 60));
        arcacomunal3.setPreferredSize(new java.awt.Dimension(100, 60));

        verde3.setMaximumSize(new java.awt.Dimension(100, 60));
        verde3.setMinimumSize(new java.awt.Dimension(100, 60));
        verde3.setPreferredSize(new java.awt.Dimension(100, 60));

        tren4.setMaximumSize(new java.awt.Dimension(100, 60));
        tren4.setMinimumSize(new java.awt.Dimension(100, 60));
        tren4.setPreferredSize(new java.awt.Dimension(100, 60));

        suerte3.setMaximumSize(new java.awt.Dimension(100, 60));
        suerte3.setMinimumSize(new java.awt.Dimension(100, 60));
        suerte3.setPreferredSize(new java.awt.Dimension(100, 60));

        cian1.setMaximumSize(new java.awt.Dimension(100, 60));
        cian1.setMinimumSize(new java.awt.Dimension(100, 60));
        cian1.setPreferredSize(new java.awt.Dimension(100, 60));

        tarifa.setMaximumSize(new java.awt.Dimension(100, 60));
        tarifa.setMinimumSize(new java.awt.Dimension(100, 60));
        tarifa.setPreferredSize(new java.awt.Dimension(100, 60));

        cian2.setMaximumSize(new java.awt.Dimension(100, 60));
        cian2.setMinimumSize(new java.awt.Dimension(100, 60));
        cian2.setPreferredSize(new java.awt.Dimension(100, 60));

        Jugar.setText("Tirar Dado");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });

        historial.setColumns(20);
        historial.setRows(5);
        jScrollPane1.setViewportView(historial);

        Iniciar.setText("Iniciar Juego");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        txtTurno.setEditable(false);

        jLabel1.setText("Turno:");

        MercadoPropiedad.setText("Comerciar Propiedad");
        MercadoPropiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MercadoPropiedadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Jugar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(MercadoPropiedad))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arcacomunal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suerte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tren4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verde3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(verde1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(verde2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(carcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(azul3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(azul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suerte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(azul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tren1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(arcacomunal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(parqueolibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rojo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(suerte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rojo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rojo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tren3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amarillo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amarillo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(servicios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(amarillo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alacarcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(arcacomunal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rosada3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tren2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(naranja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rosada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(servicios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rosada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(naranja3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(naranja2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap(1014, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parqueolibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rojo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rojo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alacarcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amarillo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amarillo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amarillo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tren3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rojo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suerte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verde1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Iniciar)
                        .addComponent(Jugar)
                        .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(MercadoPropiedad)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arcacomunal3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verde3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tren4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suerte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cian2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(azul3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carcel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suerte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cafe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cafe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tren1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(azul1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(azul2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arcacomunal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(naranja3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(naranja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(arcacomunal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(naranja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tren2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rosada3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rosada2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(servicios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(rosada1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 885, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        
        int dinero = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de dinero que desea para los jugadores"));
        this.juego.registrarDineroInicial(dinero);
        
        hj.setLocation(1100+this.getLocation().x, 100);
        hj.setVisible(true);
        actualizarDinero();
        this.txtTurno.setText(this.juego.getJugadores().get(0).getNombre());
        
        switch(this.juego.getJugadores().size()){
            case 2:{
                this.hj.getTxtJugador1().setText(this.juego.getJugadores().get(0).getNombre());
                this.hj.getTxtJugador2().setText(this.juego.getJugadores().get(1).getNombre());
                break;
            }
            case 3:{
                this.hj.getTxtJugador1().setText(this.juego.getJugadores().get(0).getNombre());
                this.hj.getTxtJugador2().setText(this.juego.getJugadores().get(1).getNombre());
                this.hj.getTxtJugador3().setText(this.juego.getJugadores().get(2).getNombre());
                break;
            }
            case 4:{
                this.hj.getTxtJugador1().setText(this.juego.getJugadores().get(0).getNombre());
                this.hj.getTxtJugador2().setText(this.juego.getJugadores().get(1).getNombre());
                this.hj.getTxtJugador3().setText(this.juego.getJugadores().get(2).getNombre());
                this.hj.getTxtJugador4().setText(this.juego.getJugadores().get(3).getNombre());
                break;
            }
            case 5:{
                this.hj.getTxtJugador1().setText(this.juego.getJugadores().get(0).getNombre());
                this.hj.getTxtJugador2().setText(this.juego.getJugadores().get(1).getNombre());
                this.hj.getTxtJugador3().setText(this.juego.getJugadores().get(2).getNombre());
                this.hj.getTxtJugador4().setText(this.juego.getJugadores().get(3).getNombre());
                this.hj.getTxtJugador5().setText(this.juego.getJugadores().get(4).getNombre());
                break;
            }
            case 6:{
                this.hj.getTxtJugador1().setText(this.juego.getJugadores().get(0).getNombre());
                this.hj.getTxtJugador2().setText(this.juego.getJugadores().get(1).getNombre());
                this.hj.getTxtJugador3().setText(this.juego.getJugadores().get(2).getNombre());
                this.hj.getTxtJugador4().setText(this.juego.getJugadores().get(3).getNombre());
                this.hj.getTxtJugador5().setText(this.juego.getJugadores().get(4).getNombre());
                this.hj.getTxtJugador6().setText(this.juego.getJugadores().get(5).getNombre());
                break;
            }
        }
        
        
    }//GEN-LAST:event_IniciarActionPerformed

    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed

        this.historial.setText(this.historial.getText()+"\n"+this.juego.moverJugador());
        
        switch(this.juego.getTurno()){
            case 1:{
                this.txtTurno.setText(this.juego.getJugadores().get(0).getNombre());
                break;
            }
            case 2:{
                this.txtTurno.setText(this.juego.getJugadores().get(1).getNombre());
                break;
            }
            case 3:{
                this.txtTurno.setText(this.juego.getJugadores().get(2).getNombre());
                break;
            }
            case 4:{
                this.txtTurno.setText(this.juego.getJugadores().get(3).getNombre());
                break;
            }
            case 5:{
                this.txtTurno.setText(this.juego.getJugadores().get(4).getNombre());
                break;
            }
            case 6:{
                this.txtTurno.setText(this.juego.getJugadores().get(5).getNombre());
                break;
            }
        }
        actualizarDinero();
        actualizarPropiedades();
    }//GEN-LAST:event_JugarActionPerformed

    private void MercadoPropiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MercadoPropiedadActionPerformed

        switch(this.juego.getTurno()){
            case 1 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(0), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            case 2 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(1), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            case 3 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(2), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            case 4 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(3), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            case 5 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(4), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            case 6 -> {
                MercadoPropiedades mp = new MercadoPropiedades(this.juego.getJugadores().get(5), juego);
                mp.setVisible(true);
                this.actualizarDinero();
                this.actualizarPropiedades();
                break;
            }
            default ->{
                break;
            }   
        }
    }//GEN-LAST:event_MercadoPropiedadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton Jugar;
    private javax.swing.JButton MercadoPropiedad;
    private javax.swing.JButton alacarcel;
    private javax.swing.JButton amarillo1;
    private javax.swing.JButton amarillo2;
    private javax.swing.JButton amarillo3;
    private javax.swing.JButton arcacomunal1;
    private javax.swing.JButton arcacomunal2;
    private javax.swing.JButton arcacomunal3;
    private javax.swing.JButton azul1;
    private javax.swing.JButton azul2;
    private javax.swing.JButton azul3;
    private javax.swing.JButton cafe1;
    private javax.swing.JButton cafe2;
    private javax.swing.JButton carcel;
    private javax.swing.JButton cian1;
    private javax.swing.JButton cian2;
    private javax.swing.JTextArea historial;
    private javax.swing.JButton impuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton naranja1;
    private javax.swing.JButton naranja2;
    private javax.swing.JButton naranja3;
    private javax.swing.JButton parqueolibre;
    private javax.swing.JButton rojo1;
    private javax.swing.JButton rojo2;
    private javax.swing.JButton rojo3;
    private javax.swing.JButton rosada1;
    private javax.swing.JButton rosada2;
    private javax.swing.JButton rosada3;
    private javax.swing.JButton salida;
    private javax.swing.JButton servicios1;
    private javax.swing.JButton servicios2;
    private javax.swing.JButton suerte1;
    private javax.swing.JButton suerte2;
    private javax.swing.JButton suerte3;
    private javax.swing.JButton tarifa;
    private javax.swing.JButton tren1;
    private javax.swing.JButton tren2;
    private javax.swing.JButton tren3;
    private javax.swing.JButton tren4;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JButton verde1;
    private javax.swing.JButton verde2;
    private javax.swing.JButton verde3;
    // End of variables declaration//GEN-END:variables
}
