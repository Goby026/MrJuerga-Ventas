package Vista;

import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.VentasControl;
import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import Modelo.Conexion;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    DefaultTableModel table1;
    DefaultTableModel modeloMasVendidos;
    MyiReportVisor mrv;
    HashMap parametros = new HashMap();

    public Ventas(String usuario) throws Exception {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        cargarDatos(usuario);
    }

    public Ventas() {
    }

    public void cargarDatos(String usuario) throws Exception {
//        panelVuelto.getRootPane().setBackground(Color.DARK_GRAY);
        panelPagoElectronico.setUndecorated(true);
        AWTUtilities.setWindowOpaque(panelPagoElectronico, false);
        panelVuelto.setUndecorated(true);
        AWTUtilities.setWindowOpaque(panelVuelto, false);
        new VentasControl().llenarListaCategorias(listaCategorias);
        txtCaja.setText(new VentasControl().getCajaDeUsuario(usuario));
        new Cronometro().iniciarCronometro(txtHora);
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        btnEfectivo.setSelected(true);
        cargarTitulosTablaPedidos();
        bloquearBotones();
        tablaProductosMasVendidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVuelto = new javax.swing.JDialog();
        btnCero = new javax.swing.JButton();
        btnSiete = new javax.swing.JButton();
        btnCuatro = new javax.swing.JButton();
        btnUno = new javax.swing.JButton();
        btnPunto = new javax.swing.JButton();
        btnOcho = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnDos = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnNueve = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        txtVuelto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRealizarVenta = new javax.swing.JButton();
        txtMontoRecibido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelPagoElectronico = new javax.swing.JDialog();
        btnCeroTarjeta = new javax.swing.JButton();
        btnSieteTarjeta = new javax.swing.JButton();
        btnCuatroTarjeta = new javax.swing.JButton();
        btnUnoTarjeta = new javax.swing.JButton();
        btnOchoTarjeta = new javax.swing.JButton();
        btnCincoTarjeta = new javax.swing.JButton();
        btnDosTarjeta = new javax.swing.JButton();
        btnBorrarTarjeta = new javax.swing.JButton();
        btnNueveTarjeta = new javax.swing.JButton();
        btnSeisTarjeta = new javax.swing.JButton();
        btnTresTarjeta = new javax.swing.JButton();
        btnCobrarConTarjeta = new javax.swing.JButton();
        txtNumReferencia = new javax.swing.JTextField();
        btnCancelarTarjeta = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        operacionCombinada = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        txtNumReferenciaCombinada = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtMontoCombinada = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtefectivoCombinada = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtRecibidoCombinada = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtVueltoCombinada = new javax.swing.JTextField();
        txtCobrarCombinada = new javax.swing.JButton();
        btnSalirOpCombinada = new javax.swing.JButton();
        btnCuatroCombinada = new javax.swing.JButton();
        btnSeisCombinada = new javax.swing.JButton();
        btnNueveCombinada = new javax.swing.JButton();
        btnCincoCombinada = new javax.swing.JButton();
        btnSieteCombinada = new javax.swing.JButton();
        btnOchoCombinada = new javax.swing.JButton();
        btnCeroCombinada = new javax.swing.JButton();
        btnBorrarCombinada = new javax.swing.JButton();
        btnunoCombinada = new javax.swing.JButton();
        btnDosCombinada = new javax.swing.JButton();
        btnTresCombinada = new javax.swing.JButton();
        tablet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCategorias = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btn5 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblPago = new javax.swing.JLabel();
        btnPendientes = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCaja = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cboxMasVendidos = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        btnMasterCard = new javax.swing.JToggleButton();
        btnVisa = new javax.swing.JToggleButton();
        cmbNotaDePedido = new javax.swing.JCheckBox();
        cmbFactura = new javax.swing.JCheckBox();
        btnEfectivo = new javax.swing.JToggleButton();
        btnOperacionCombinada = new javax.swing.JToggleButton();
        jLabel20 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();

        panelVuelto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelVuelto.setTitle("MONTOS");
        panelVuelto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCero.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero.png"))); // NOI18N
        btnCero.setBorderPainted(false);
        btnCero.setContentAreaFilled(false);
        btnCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 70, 70));

        btnSiete.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSiete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (7).png"))); // NOI18N
        btnSiete.setBorderPainted(false);
        btnSiete.setContentAreaFilled(false);
        btnSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnSiete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 70, 70));

        btnCuatro.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCuatro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (4).png"))); // NOI18N
        btnCuatro.setBorderPainted(false);
        btnCuatro.setContentAreaFilled(false);
        btnCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 70, 70));

        btnUno.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (1).png"))); // NOI18N
        btnUno.setBorderPainted(false);
        btnUno.setContentAreaFilled(false);
        btnUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 70, 70));

        btnPunto.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnPunto.setText(".");
        btnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 70, 60));

        btnOcho.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnOcho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (8).png"))); // NOI18N
        btnOcho.setBorderPainted(false);
        btnOcho.setContentAreaFilled(false);
        btnOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnOcho, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 70, 70));

        btnCinco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCinco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (5).png"))); // NOI18N
        btnCinco.setBorderPainted(false);
        btnCinco.setContentAreaFilled(false);
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 70, 70));

        btnDos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (2).png"))); // NOI18N
        btnDos.setBorderPainted(false);
        btnDos.setContentAreaFilled(false);
        btnDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 70, 70));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnBorrar.setText("<");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 70, 60));

        btnNueve.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNueve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (9).png"))); // NOI18N
        btnNueve.setBorderPainted(false);
        btnNueve.setContentAreaFilled(false);
        btnNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnNueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 70, 70));

        btnSeis.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSeis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (6).png"))); // NOI18N
        btnSeis.setBorderPainted(false);
        btnSeis.setContentAreaFilled(false);
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnSeis, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 70, 70));

        btnTres.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnTres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/numero (3).png"))); // NOI18N
        btnTres.setBorderPainted(false);
        btnTres.setContentAreaFilled(false);
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 70, 70));

        txtVuelto.setEditable(false);
        txtVuelto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtVuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelVuelto.getContentPane().add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 640, 230, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VUELTO");
        panelVuelto.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 590, 250, -1));

        btnRealizarVenta.setBackground(new java.awt.Color(0, 153, 0));
        btnRealizarVenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRealizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarVenta.setText("COBRAR");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 710, 230, 60));

        txtMontoRecibido.setEditable(false);
        txtMontoRecibido.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtMontoRecibido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelVuelto.getContentPane().add(txtMontoRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 230, 80));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 840, 220, 38));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MONTO RECIBIDO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, -1));

        panelVuelto.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 60));

        jLabel17.setBackground(new java.awt.Color(204, 204, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borderGalaxy.png"))); // NOI18N
        panelVuelto.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 910));

        jLabel19.setBackground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("MrJuerga");
        panelVuelto.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        panelVuelto.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 420, 710));

        panelPagoElectronico.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCeroTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCeroTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-0.png"))); // NOI18N
        btnCeroTarjeta.setBorderPainted(false);
        btnCeroTarjeta.setContentAreaFilled(false);
        btnCeroTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCeroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 70, 70));

        btnSieteTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSieteTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-7.png"))); // NOI18N
        btnSieteTarjeta.setBorderPainted(false);
        btnSieteTarjeta.setContentAreaFilled(false);
        btnSieteTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnSieteTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 70, 70));

        btnCuatroTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCuatroTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-4.png"))); // NOI18N
        btnCuatroTarjeta.setBorderPainted(false);
        btnCuatroTarjeta.setContentAreaFilled(false);
        btnCuatroTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCuatroTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 70, 70));

        btnUnoTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUnoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-1.png"))); // NOI18N
        btnUnoTarjeta.setBorderPainted(false);
        btnUnoTarjeta.setContentAreaFilled(false);
        btnUnoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnUnoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 70, 70));

        btnOchoTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnOchoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-8.png"))); // NOI18N
        btnOchoTarjeta.setBorderPainted(false);
        btnOchoTarjeta.setContentAreaFilled(false);
        btnOchoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnOchoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 70, 70));

        btnCincoTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCincoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-5.png"))); // NOI18N
        btnCincoTarjeta.setBorderPainted(false);
        btnCincoTarjeta.setContentAreaFilled(false);
        btnCincoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCincoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 70, 70));

        btnDosTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDosTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-2.png"))); // NOI18N
        btnDosTarjeta.setBorderPainted(false);
        btnDosTarjeta.setContentAreaFilled(false);
        btnDosTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnDosTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 70, 70));

        btnBorrarTarjeta.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrarTarjeta.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnBorrarTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-boton-circular-de-una-cruz.png"))); // NOI18N
        btnBorrarTarjeta.setBorderPainted(false);
        btnBorrarTarjeta.setContentAreaFilled(false);
        btnBorrarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnBorrarTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 70, 70));

        btnNueveTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNueveTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-9.png"))); // NOI18N
        btnNueveTarjeta.setBorderPainted(false);
        btnNueveTarjeta.setContentAreaFilled(false);
        btnNueveTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnNueveTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 70, 70));

        btnSeisTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSeisTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-6.png"))); // NOI18N
        btnSeisTarjeta.setBorderPainted(false);
        btnSeisTarjeta.setContentAreaFilled(false);
        btnSeisTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnSeisTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 70, 70));

        btnTresTarjeta.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnTresTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iphone-3.png"))); // NOI18N
        btnTresTarjeta.setBorderPainted(false);
        btnTresTarjeta.setContentAreaFilled(false);
        btnTresTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnTresTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 70, 70));

        btnCobrarConTarjeta.setBackground(new java.awt.Color(0, 153, 0));
        btnCobrarConTarjeta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCobrarConTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrarConTarjeta.setText("COBRAR");
        btnCobrarConTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarConTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCobrarConTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 230, 40));

        txtNumReferencia.setEditable(false);
        txtNumReferencia.setBackground(new java.awt.Color(255, 255, 255));
        txtNumReferencia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtNumReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumReferencia.setBorder(null);
        panelPagoElectronico.getContentPane().add(txtNumReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 50));

        btnCancelarTarjeta.setBorder(null);
        btnCancelarTarjeta.setBorderPainted(false);
        btnCancelarTarjeta.setContentAreaFilled(false);
        btnCancelarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCancelarTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 637, 60, 62));
        panelPagoElectronico.getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 230, 10));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("NUMERO DE OPERACION");
        panelPagoElectronico.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borderIphone.png"))); // NOI18N
        panelPagoElectronico.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 720));

        operacionCombinada.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("NUMERO REFERENCIA");
        operacionCombinada.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, 40));
        operacionCombinada.getContentPane().add(txtNumReferenciaCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 40));

        jButton2.setText("UP");
        operacionCombinada.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 90, 50));

        jButton3.setText("DOWN");
        operacionCombinada.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 90, 50));

        jLabel25.setText("MONTO");
        operacionCombinada.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 160, 40));
        operacionCombinada.getContentPane().add(txtMontoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 190, 40));

        jLabel26.setText("EFECTIVO");
        operacionCombinada.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 160, 40));
        operacionCombinada.getContentPane().add(txtefectivoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 190, 40));

        jLabel27.setText("RECIBIDO");
        operacionCombinada.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 160, 40));
        operacionCombinada.getContentPane().add(txtRecibidoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 190, 40));

        jLabel28.setText("VUELTO");
        operacionCombinada.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 160, 40));
        operacionCombinada.getContentPane().add(txtVueltoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 190, 40));

        txtCobrarCombinada.setText("COBRAR");
        operacionCombinada.getContentPane().add(txtCobrarCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, 360, 50));

        btnSalirOpCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirOpCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnSalirOpCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 772, 200, 30));

        btnCuatroCombinada.setText("4");
        operacionCombinada.getContentPane().add(btnCuatroCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 90, 60));

        btnSeisCombinada.setText("6");
        operacionCombinada.getContentPane().add(btnSeisCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 160, 90, 60));

        btnNueveCombinada.setText("9");
        operacionCombinada.getContentPane().add(btnNueveCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 100, 90, 60));

        btnCincoCombinada.setText("5");
        operacionCombinada.getContentPane().add(btnCincoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, 90, 60));

        btnSieteCombinada.setText("7");
        operacionCombinada.getContentPane().add(btnSieteCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 90, 60));

        btnOchoCombinada.setText("8");
        operacionCombinada.getContentPane().add(btnOchoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 90, 60));

        btnCeroCombinada.setText("0");
        operacionCombinada.getContentPane().add(btnCeroCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, 90, 60));

        btnBorrarCombinada.setText("<");
        operacionCombinada.getContentPane().add(btnBorrarCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, 90, 60));

        btnunoCombinada.setText("1");
        btnunoCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnunoCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnunoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 90, 60));

        btnDosCombinada.setText("2");
        operacionCombinada.getContentPane().add(btnDosCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 90, 60));

        btnTresCombinada.setText("3");
        operacionCombinada.getContentPane().add(btnTresCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 220, 90, 60));

        tablet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tablet.png"))); // NOI18N
        operacionCombinada.getContentPane().add(tablet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 820));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PUNTO DE VENTA - BARRA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaCategorias.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        listaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaCategorias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 280, 380));

        tblPedidos.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        tblPedidos.setForeground(new java.awt.Color(51, 51, 255));
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPedidos.setRowHeight(50);
        tblPedidos.setRowMargin(4);
        jScrollPane2.setViewportView(tblPedidos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, 1320, 220));

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764689_number-five.png"))); // NOI18N
        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 320, 130, -1));

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764699_number-seven.png"))); // NOI18N
        btn7.setBorder(null);
        btn7.setBorderPainted(false);
        btn7.setContentAreaFilled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        getContentPane().add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 190, 130, 130));

        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764709_number-nine.png"))); // NOI18N
        btn9.setBorder(null);
        btn9.setBorderPainted(false);
        btn9.setContentAreaFilled(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 190, 130, 130));

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764694_number-six.png"))); // NOI18N
        btn6.setBorder(null);
        btn6.setBorderPainted(false);
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 320, 130, 130));

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764704_number-eight.png"))); // NOI18N
        btn8.setBorder(null);
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 190, 130, -1));

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764685_number-four.png"))); // NOI18N
        btn4.setBorder(null);
        btn4.setBorderPainted(false);
        btn4.setContentAreaFilled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 320, 130, 130));

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764657_number-one.png"))); // NOI18N
        btn1.setBorder(null);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 450, -1, 130));

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764679_number-three.png"))); // NOI18N
        btn3.setBorder(null);
        btn3.setBorderPainted(false);
        btn3.setContentAreaFilled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1730, 450, 130, -1));

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764676_number-two.png"))); // NOI18N
        btn2.setBorder(null);
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1590, 450, 130, -1));

        btn0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1481764713_number-ten.png"))); // NOI18N
        btn0.setBorder(null);
        btn0.setBorderPainted(false);
        btn0.setContentAreaFilled(false);
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 580, 130, 130));

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cubo-de-basura.png"))); // NOI18N
        btnDel.setBorder(null);
        btnDel.setBorderPainted(false);
        btnDel.setContentAreaFilled(false);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1740, 580, 130, 130));

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("LISTA DE PEDIDOS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(null);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 110, 410, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("CANTIDAD");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 80, -1, -1));

        btnAgregar.setBackground(new java.awt.Color(255, 102, 0));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito-de-las-compras.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 580, 130, 130));

        tblProductos.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        tblProductos.setForeground(new java.awt.Color(153, 0, 0));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.setRowHeight(50);
        tblProductos.setRowMargin(10);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProductos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 1030, 380));

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel10.setText("PRODUCTOS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 100, -1));

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("X");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 950, 130, 50));

        btnCobrar.setBackground(new java.awt.Color(0, 153, 51));
        btnCobrar.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        btnCobrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCobrar.setText("OPERACION");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 870, 360, 120));

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel11.setText("S/.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 790, -1, -1));

        lblPago.setFont(new java.awt.Font("Dialog", 1, 96)); // NOI18N
        lblPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 740, 290, 110));

        btnPendientes.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnPendientes.setText("LISTA DE PEDIDOS");
        btnPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 950, 660, 50));

        jPanel8.setBackground(new java.awt.Color(51, 153, 255));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("VENTAS BARRA");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cajero.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(51, 153, 255));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1820, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(51, 153, 255));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1720, 20, 90, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(51, 153, 255));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("VENTAS BARRA");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(51, 153, 255));
        txtCaja.setForeground(new java.awt.Color(255, 255, 255));
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "CAJA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 250, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 70));

        jPanel6.setBackground(new java.awt.Color(51, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("DISCOTECK");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 0, -1, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MISTER JUERGA");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel18.setText("MISTER JUERGA");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1010, 1920, 40));

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel14.setText("CATEGORIAS");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 850, 290, 10));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel15.setText("PAGO");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 760, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 180, 410, 10));

        cboxMasVendidos.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        cboxMasVendidos.setForeground(new java.awt.Color(0, 102, 255));
        cboxMasVendidos.setText("LOS MAS VENDIDOS");
        cboxMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMasVendidosActionPerformed(evt);
            }
        });
        getContentPane().add(cboxMasVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 570, -1, -1));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("RUC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, 30, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("RAZÓN SOCIAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 120, -1));

        txtRazonSocial.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtRazonSocial.setEnabled(false);
        getContentPane().add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 420, -1));

        txtRuc.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtRuc.setEnabled(false);
        getContentPane().add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 90, 330, -1));

        btnMasterCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masterCard.png"))); // NOI18N
        btnMasterCard.setBorderPainted(false);
        btnMasterCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterCardActionPerformed(evt);
            }
        });
        getContentPane().add(btnMasterCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 130, 80));

        btnVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa.png"))); // NOI18N
        btnVisa.setBorderPainted(false);
        btnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 180, 130, 80));

        cmbNotaDePedido.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cmbNotaDePedido.setForeground(new java.awt.Color(0, 51, 204));
        cmbNotaDePedido.setText("NOTA DE PEDIDO");
        getContentPane().add(cmbNotaDePedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        cmbFactura.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        cmbFactura.setForeground(new java.awt.Color(0, 51, 204));
        cmbFactura.setText("FACTURA");
        cmbFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        btnEfectivo.setText("EFECTIVO");
        getContentPane().add(btnEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 180, 130, 80));

        btnOperacionCombinada.setText("OPERACIÓN COMBINADA");
        getContentPane().add(btnOperacionCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 180, -1, 80));

        jLabel20.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("DIRECCIÓN");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 120, -1));

        txtDireccion.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtDireccion.setEnabled(false);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 800, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCategoriasMouseClicked
        try {
            String categoria = listaCategorias.getSelectedValue().toString();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_listaCategoriasMouseClicked

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        try {
            if (btnVisa.isSelected() || btnMasterCard.isSelected()) {
                panelPagoElectronico.setVisible(true);
                panelPagoElectronico.setBounds(600, 200, 500, 1020);
            } else if (btnEfectivo.isSelected()) {
                //imprimir normalmente la boleta
                panelVuelto.setVisible(true);
                //panelVuelto.setModal(closable);
                panelVuelto.setBounds(580, 100, 460, 950);
            } else if (btnOperacionCombinada.isSelected()) {
                operacionCombinada.setVisible(true);
                operacionCombinada.setBounds(100, 100, 1175, 860);
            } else if (cmbFactura.isSelected()) {
                //recibir los tres parametros para la factura
                String razon = txtRazonSocial.getText();
                String ruc = txtRuc.getText();
                String direccion = txtDireccion.getText();
                //registrar cliente
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        String captura = txtCantidad.getText() + 0;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        String captura = txtCantidad.getText() + 1;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        String captura = txtCantidad.getText() + 2;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        String captura = txtCantidad.getText() + 3;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        String captura = txtCantidad.getText() + 4;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        String captura = txtCantidad.getText() + 5;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        String captura = txtCantidad.getText() + 6;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        String captura = txtCantidad.getText() + 7;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        String captura = txtCantidad.getText() + 8;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        String captura = txtCantidad.getText() + 9;
        txtCantidad.setText(captura);
        btnAgregar.setEnabled(true);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            int fila = tblProductos.getSelectedRow();
            int cod = new VentasControl().getIdProductoConNombre(tblProductos.getValueAt(fila, 0).toString());
            String prod = tblProductos.getValueAt(fila, 0).toString();
            String presentacion = tblProductos.getValueAt(fila, 1).toString();
            double prec = Double.parseDouble(tblProductos.getValueAt(fila, 3).toString());
            int cant = Integer.parseInt(txtCantidad.getText());
            double subtotal = prec * cant;
            if (cant == 0) {
                JOptionPane.showMessageDialog(getRootPane(), "EL VALOR 0 NO DISPONE DE OPERACIONES");
            } else {
                if (Integer.parseInt(tblProductos.getValueAt(fila, 2).toString()) < cant) {
                    JOptionPane.showMessageDialog(getRootPane(), "NO SE CUENTA CON LAS UNIDADES SOLICITADAS");
                } else {
                    Object datos[] = {cod, prod, presentacion, prec, cant, subtotal};
                    table1.addRow(datos);
                    tblPedidos.setModel(table1);
                    lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
                    tblProductos.clearSelection();
                    listaCategorias.clearSelection();
                    bloquearBotones();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int fila = tblProductos.getSelectedRow();
        if (fila >= 0) {
            desbloquearBotones();
            txtCantidad.setText("");
        } else {
            bloquearBotones();
        }

    }//GEN-LAST:event_tblProductosMouseClicked

    private void btnPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendientesActionPerformed
        new VentasPendientes().setVisible(true);
    }//GEN-LAST:event_btnPendientesActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        txtCantidad.setText("");
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        try {
            int fila = tblPedidos.getSelectedRow();
            table1.removeRow(fila);
            lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void cboxMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxMasVendidosActionPerformed
        //invocar metodo para ordenar los productos segun las ventas realizadas (los mas vendidos)
        try {
            if (cboxMasVendidos.isSelected()) {
                tablaProductosMasVendidos();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_cboxMasVendidosActionPerformed

    private void btnCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 0);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnCeroActionPerformed

    private void btnUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 1);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnUnoActionPerformed

    private void btnDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 2);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnDosActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 3);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 4);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnCuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 5);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 6);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 7);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnSieteActionPerformed

    private void btnOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 8);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnOchoActionPerformed

    private void btnNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + 9);
        double monto = Double.parseDouble(txtMontoRecibido.getText());
        double total = Double.parseDouble(lblPago.getText());
        if ((monto - total) > 0) {
            txtVuelto.setForeground(Color.green);
        } else {
            txtVuelto.setForeground(Color.red);
        }
        txtVuelto.setText("" + (monto - total));
    }//GEN-LAST:event_btnNueveActionPerformed

    private void btnPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntoActionPerformed
        txtMontoRecibido.setText(txtMontoRecibido.getText() + ".");
    }//GEN-LAST:event_btnPuntoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        panelVuelto.dispose();
        //Metodos para limpiar la caja de texto de montoRecibido
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtMontoRecibido.setText("");
        txtVuelto.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        try {
            //PRIMERO CAPTURAMOS DATOS PARA REGISTRAR COMPROBANTE
            String fecha = new ManejadorFechas().getFechaActualMySQL();
            String usuario = txtUsuario.getText();
            //cliente lo pasamos en duro
            //cantidad de que????
            Double subtotal = Double.parseDouble(lblPago.getText());
            //ruc lo pasamos en duro
            String direccion = "JR AYACUCHO 750";
            //tipo de pago lo pasamos en duro hasta normalizar el TIPODEPAGO
            Double total = Double.parseDouble(lblPago.getText());
            int idTipoComprobante = 1;
            
            int tipoPago=0;
            if(btnEfectivo.isSelected()){
                //efectivo = 1
                tipoPago = 1;
            }else if(btnMasterCard.isSelected()){
                //masterCard = 2
                tipoPago = 2;
            }else if(btnVisa.isSelected()){
                //visa = 3
                tipoPago = 3;
            }else if(btnOperacionCombinada.isSelected()){
                //combinada = 4
                tipoPago = 4;
            }

            //creamos el comprobante
            Comprobante c = new Comprobante();
            c.setFecha(fecha);
            c.setUsuario(usuario);
            c.setCliente("mrjuerga");
            c.setCantidad(0);
            c.setSubTotal(subtotal);
            c.setRuc("12345678912");
            c.setDireccion(direccion);
            c.setTipo_pago(String.valueOf(tipoPago));
            c.setTotal(total);
            c.setIdtipocomprobante(idTipoComprobante);

            //creamos el comprobante con acceso a datos
            ComprobanteDAO cdao = new ComprobanteDAO();
            //registramos el comprobante
            if (cdao.Registrar(c)) {
                System.out.println("Comprobante Registrado");
            } else {
                System.out.println("Error");
            }
            //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA
            Object[] datos = new Object[8];
            datos[0] = fecha;//fecha
            System.out.println("registro fecha");
            datos[1] = txtHora.getText();//hora
            System.out.println("registro hora");
            datos[2] = new VentasControl().getIdUsuarioConNombre(usuario);//usuario
            System.out.println("registro usuario");
            datos[3] = 1;//cliente
            System.out.println("registro cliente");
            datos[4] = new VentasControl().getIdDeUltimoComprobanteRegistrado();//ultimo comprobante registrado
            System.out.println("registro ultimo comprobante");
            datos[5] = 1;//ESTADO->> 0:PENDIENTE     1:PAGADO
            System.out.println("registro estado");
            datos[6] = tipoPago;//tipo de transaccion
            System.out.println("registro tipo de transaccion");
            datos[7] = new VentasControl().getIdCaja(txtCaja.getText());//caja que realiza la operacion
            System.out.println("registro caja que realizo la transaccion");
            VentasControl vc = new VentasControl();
            vc.registrarVenta(datos);
            System.out.println("venta registrada");
            //TERCERO REGISTRO LOS DETALLES DE LA VENTA
            //obtengo la ultima venta registrada
            int idventa = new VentasControl().getIdDeUltimaVentaRegistrada();
            System.out.println("ultima venta: " + idventa);
            int flag = vc.registrarDetalleDeVenta(tblPedidos, idventa);
            System.out.println("flag: " + flag);
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "VENTA REALIZADA EXITOSAMENTE");

//                parametros.put("id_venta", idventa);
//                parametros.put("total", total);
//                mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaVenta.jrxml", parametros, getPageSize());
//                mrv.setNombreArchivo("BoletaVenta");
//                try {
//                    mrv.exportarAPdfConCopia();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//                mrv.dispose();
                new VentasControl().restarStock(tblPedidos);
                panelVuelto.dispose();
                cargarDatos(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnCeroTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 0;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnCeroTarjetaActionPerformed

    private void btnSieteTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 7;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnSieteTarjetaActionPerformed

    private void btnCuatroTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 4;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnCuatroTarjetaActionPerformed

    private void btnUnoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 1;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnUnoTarjetaActionPerformed

    private void btnOchoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 8;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnOchoTarjetaActionPerformed

    private void btnCincoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 5;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnCincoTarjetaActionPerformed

    private void btnDosTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 2;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnDosTarjetaActionPerformed

    private void btnBorrarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTarjetaActionPerformed
        txtNumReferencia.setText("");
    }//GEN-LAST:event_btnBorrarTarjetaActionPerformed

    private void btnNueveTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 9;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnNueveTarjetaActionPerformed

    private void btnSeisTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 6;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnSeisTarjetaActionPerformed

    private void btnTresTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresTarjetaActionPerformed
        String captura = txtNumReferencia.getText() + 3;
        txtNumReferencia.setText(captura);
    }//GEN-LAST:event_btnTresTarjetaActionPerformed

    private void btnCobrarConTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarConTarjetaActionPerformed
        try {
            //PRIMERO CAPTURAMOS DATOS PARA REGISTRAR COMPROBANTE
            String fecha = new ManejadorFechas().getFechaActualMySQL();
            String usuario = txtUsuario.getText();
            //cliente lo pasamos en duro
            //cantidad de que????
            Double subtotal = Double.parseDouble(lblPago.getText());
            //ruc lo pasamos en duro
            String direccion = "JR AYACUCHO 772";
            String tipoPago = null;
            Double total = Double.parseDouble(lblPago.getText());
            int idTipoComprobante = 1;

            if (btnVisa.isSelected()) {
                tipoPago = "VISA";
            } else {
                tipoPago = "MASTER CARD";
            }

            //creamos el comprobante
            Comprobante c = new Comprobante();
            c.setFecha(fecha);
            c.setUsuario(usuario);
            c.setCliente("mrjuerga");
            c.setCantidad(0);
            c.setSubTotal(subtotal);
            c.setRuc("12345678912");
            c.setDireccion(direccion);
            c.setTipo_pago(tipoPago);
            c.setTotal(total);
            c.setIdtipocomprobante(idTipoComprobante);

            //creamos el comprobante con acceso a datos
            ComprobanteDAO cdao = new ComprobanteDAO();
            //registramos el comprobante
            if (cdao.Registrar(c)) {
                System.out.println("Comprobante Registrado");
            } else {
                System.out.println("Error");
            }
            //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA
            Object[] datos = new Object[8];
            datos[0] = fecha;//fecha
            System.out.println("registro fecha");
            datos[1] = txtHora.getText();//hora
            System.out.println("registro hora");
            datos[2] = new VentasControl().getIdUsuarioConNombre(usuario);//usuario
            System.out.println("registro usuario");
            datos[3] = 1;//cliente
            System.out.println("registro cliente");
            datos[4] = new VentasControl().getIdDeUltimoComprobanteRegistrado();//ultimo comprobante registrado
            System.out.println("registro ultimo comprobante");
            datos[5] = 1;//ESTADO->> 0:PENDIENTE     1:PAGADO
            System.out.println("registro estado");
            datos[6] = tipoPago;//tipo de transaccion en efectivo
            System.out.println("registro tipo de transaccion");
            datos[7] = new VentasControl().getIdCaja(txtCaja.getText());//caja que realiza la operacion
            System.out.println("registro caja que realizo la transaccion");
            VentasControl vc = new VentasControl();
            vc.registrarVenta(datos);
            System.out.println("venta registrada");
            //TERCERO REGISTRO LOS DETALLES DE LA VENTA            
            //obtengo la ultima venta registrada
            int idventa = new VentasControl().getIdDeUltimaVentaRegistrada();
            System.out.println("ultima venta: " + idventa);
            int flag = vc.registrarDetalleDeVenta(tblPedidos, idventa);
            System.out.println("flag: " + flag);
            if (flag > 0) {
                JOptionPane.showMessageDialog(null, "VENTA REALIZADA EXITOSAMENTE");

//                parametros.put("id_venta", idventa);
//                parametros.put("total", total);
//                mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaVenta.jrxml", parametros, getPageSize());
//                mrv.setNombreArchivo("BoletaVenta");
//                try {
//                    mrv.exportarAPdfConCopia();
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//                mrv.dispose();
                new VentasControl().restarStock(tblPedidos);
                panelVuelto.dispose();
                cargarDatos(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnCobrarConTarjetaActionPerformed

    private void btnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaActionPerformed
        if (btnVisa.isSelected()) {
            btnMasterCard.setEnabled(false);
        } else {
            btnMasterCard.setEnabled(true);
        }
    }//GEN-LAST:event_btnVisaActionPerformed

    private void btnMasterCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterCardActionPerformed
        if (btnMasterCard.isSelected()) {
            btnVisa.setEnabled(false);
        } else {
            btnVisa.setEnabled(true);
        }
    }//GEN-LAST:event_btnMasterCardActionPerformed

    private void btnCancelarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTarjetaActionPerformed
        panelPagoElectronico.dispose();
    }//GEN-LAST:event_btnCancelarTarjetaActionPerformed

    private void cmbFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacturaActionPerformed
        if (cmbFactura.isSelected()) {
            txtRazonSocial.setEnabled(true);
            txtRuc.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtRazonSocial.requestFocus();
        } else {
            txtRazonSocial.setEnabled(false);
            txtRuc.setEnabled(false);
            txtDireccion.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacturaActionPerformed

    private void btnSalirOpCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirOpCombinadaActionPerformed
        operacionCombinada.dispose();
    }//GEN-LAST:event_btnSalirOpCombinadaActionPerformed

    private void btnunoCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnunoCombinadaActionPerformed
        txtNumReferenciaCombinada.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtNumReferenciaCombinada.setText("1");
                System.out.println("get foco");
            }

            @Override
            public void focusLost(FocusEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }//GEN-LAST:event_btnunoCombinadaActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventas().setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn0;
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    public javax.swing.JButton btn4;
    public javax.swing.JButton btn5;
    public javax.swing.JButton btn6;
    public javax.swing.JButton btn7;
    public javax.swing.JButton btn8;
    public javax.swing.JButton btn9;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarCombinada;
    private javax.swing.JButton btnBorrarTarjeta;
    private javax.swing.JButton btnCancelarTarjeta;
    private javax.swing.JButton btnCero;
    private javax.swing.JButton btnCeroCombinada;
    private javax.swing.JButton btnCeroTarjeta;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCincoCombinada;
    private javax.swing.JButton btnCincoTarjeta;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnCobrarConTarjeta;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnCuatroCombinada;
    private javax.swing.JButton btnCuatroTarjeta;
    public javax.swing.JButton btnDel;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnDosCombinada;
    private javax.swing.JButton btnDosTarjeta;
    private javax.swing.JToggleButton btnEfectivo;
    private javax.swing.JToggleButton btnMasterCard;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnNueveCombinada;
    private javax.swing.JButton btnNueveTarjeta;
    private javax.swing.JButton btnOcho;
    private javax.swing.JButton btnOchoCombinada;
    private javax.swing.JButton btnOchoTarjeta;
    private javax.swing.JToggleButton btnOperacionCombinada;
    private javax.swing.JButton btnPendientes;
    private javax.swing.JButton btnPunto;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btnSalirOpCombinada;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSeisCombinada;
    private javax.swing.JButton btnSeisTarjeta;
    private javax.swing.JButton btnSiete;
    private javax.swing.JButton btnSieteCombinada;
    private javax.swing.JButton btnSieteTarjeta;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnTresCombinada;
    private javax.swing.JButton btnTresTarjeta;
    private javax.swing.JButton btnUno;
    private javax.swing.JButton btnUnoTarjeta;
    private javax.swing.JToggleButton btnVisa;
    private javax.swing.JButton btnunoCombinada;
    private javax.swing.JCheckBox cboxMasVendidos;
    private javax.swing.JCheckBox cmbFactura;
    private javax.swing.JCheckBox cmbNotaDePedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblPago;
    private javax.swing.JList listaCategorias;
    private javax.swing.JDialog operacionCombinada;
    private javax.swing.JDialog panelPagoElectronico;
    private javax.swing.JDialog panelVuelto;
    private javax.swing.JLabel tablet;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCaja;
    public javax.swing.JTextField txtCantidad;
    private javax.swing.JButton txtCobrarCombinada;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMontoCombinada;
    private javax.swing.JTextField txtMontoRecibido;
    private javax.swing.JTextField txtNumReferencia;
    private javax.swing.JTextField txtNumReferenciaCombinada;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRecibidoCombinada;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVuelto;
    private javax.swing.JTextField txtVueltoCombinada;
    private javax.swing.JTextField txtefectivoCombinada;
    // End of variables declaration//GEN-END:variables

    private void cargarTitulosTablaPedidos() {
        String[] titulos = {"CODIGO", "PRODUCTO", "PRESENTACION", "PRECIO", "CANTIDAD", "SUBTOTAL"};
        table1 = new DefaultTableModel(null, titulos);
        tblPedidos.setModel(table1);
    }

    public void bloquearBotones() {
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btnDel.setEnabled(false);
        btnAgregar.setEnabled(false);
        txtCantidad.setEnabled(false);
    }

    public void desbloquearBotones() {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btnDel.setEnabled(true);
        btnAgregar.setEnabled(true);
        txtCantidad.setEnabled(true);
    }

    public void borrarCampos() {
        txtMontoRecibido.setText("");
        txtVuelto.setText("");
        txtCantidad.setText("");
        lblPago.setText("");
    }

    public void titulosMasVendidos() {
        String columnas[] = {"PRODUCTO", "PRESENTACION", "STOCK", "PRECIO", "VENTAS"};
        modeloMasVendidos = new DefaultTableModel(null, columnas);
        tblProductos.setModel(modeloMasVendidos);
    }

    //metodo para cargar los productos mas vendidos
    public void tablaProductosMasVendidos() throws Exception {
        titulosMasVendidos();
        Conexion con = new Conexion();
        Object[] lista = new Object[5];
        try {
            con.conectar();
            Connection cc = con.getConexion();
            PreparedStatement pst = cc.prepareStatement("select producto.nombre,presentacion.descripcion,productopresentacion.stock,productopresentacion.precio, sum(ventaproducto.cantidad) from ventaproducto \n"
                    + "        inner join producto on ventaproducto.idproducto = producto.idproducto \n"
                    + "        inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "        inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "        group by producto.nombre\n"
                    + "        order by sum(ventaproducto.cantidad) desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista[0] = rs.getString("producto.nombre");
                lista[1] = rs.getString("presentacion.descripcion");
                lista[2] = rs.getString("productopresentacion.stock");
                lista[3] = rs.getString("productopresentacion.precio");
                lista[4] = rs.getString("sum(ventaproducto.cantidad)");
                modeloMasVendidos.addRow(lista);
            }
            tblProductos.setModel(modeloMasVendidos);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //METODO PARA LOS TAMAÑOS DE LA IMPRESION
    private int getPageSize() {
        int filas = tblPedidos.getRowCount();
        System.out.println("cantidad de filas: " + filas);
        int rowCount = 2;//FILAS DE GRACIA
        int fontSize = 7;//TAMAÑO DE LETRA DEL DETAIL
        int rowSize = fontSize + 2;//TAMAÑO DE LA FILA
        int caracteresPorLinea = 16;// CANTIDAD DE CARACTERES PARA QUE PASE A LA SIGTE LINEA
        for (int i = 0; i < filas; i++) {
            String descripcionDeProducto = tblPedidos.getValueAt(i, 1).toString();
            rowCount += (1 + (int) (descripcionDeProducto.length() / caracteresPorLinea));
        }
        int cabecera = 156;
        int piePagina = 217;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finale:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }
}
