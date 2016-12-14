package Vista;

import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.VentasControl;
import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import Modelo.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
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
        panelVuelto.getRootPane().setBackground(Color.DARK_GRAY);
        new VentasControl().llenarListaCategorias(listaCategorias);
        new VentasControl().cargarTipoDocumento(cmbDocumento);
        txtCaja.setText(new VentasControl().getCajaDeUsuario(usuario));
        new Cronometro().iniciarCronometro(txtHora);
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
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
        panelPagoElectronico = new javax.swing.JDialog();
        btnCero1 = new javax.swing.JButton();
        btnSiete1 = new javax.swing.JButton();
        btnCuatro1 = new javax.swing.JButton();
        btnUno1 = new javax.swing.JButton();
        btnPunto1 = new javax.swing.JButton();
        btnOcho1 = new javax.swing.JButton();
        btnCinco1 = new javax.swing.JButton();
        btnDos1 = new javax.swing.JButton();
        btnBorrar1 = new javax.swing.JButton();
        btnNueve1 = new javax.swing.JButton();
        btnSeis1 = new javax.swing.JButton();
        btnTres1 = new javax.swing.JButton();
        txtVuelto1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnRealizarVenta1 = new javax.swing.JButton();
        txtMontoRecibido1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        cmbDocumento = new javax.swing.JComboBox();
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
        lblComprobante = new javax.swing.JLabel();
        lblUltimoComprobante1 = new javax.swing.JLabel();
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btnMasterCard = new javax.swing.JToggleButton();
        btnVisa1 = new javax.swing.JToggleButton();

        panelVuelto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        panelVuelto.setTitle("MONTOS");
        panelVuelto.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCero.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCero.setText("0");
        btnCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 70, 60));

        btnSiete.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSiete.setText("7");
        btnSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnSiete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 60));

        btnCuatro.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCuatro.setText("4");
        btnCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 60));

        btnUno.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUno.setText("1");
        btnUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 60));

        btnPunto.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnPunto.setText(".");
        btnPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 70, 60));

        btnOcho.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnOcho.setText("8");
        btnOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnOcho, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 70, 60));

        btnCinco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCinco.setText("5");
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 70, 60));

        btnDos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDos.setText("2");
        btnDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 70, 60));

        btnBorrar.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnBorrar.setText("<");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 70, 60));

        btnNueve.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNueve.setText("9");
        btnNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnNueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 60));

        btnSeis.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSeis.setText("6");
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnSeis, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 70, 60));

        btnTres.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnTres.setText("3");
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, 60));

        txtVuelto.setEditable(false);
        txtVuelto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtVuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelVuelto.getContentPane().add(txtVuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 230, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VUELTO");
        panelVuelto.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, -1));

        btnRealizarVenta.setBackground(new java.awt.Color(0, 153, 0));
        btnRealizarVenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRealizarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarVenta.setText("COBRAR");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(btnRealizarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 230, 60));

        txtMontoRecibido.setEditable(false);
        txtMontoRecibido.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtMontoRecibido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelVuelto.getContentPane().add(txtMontoRecibido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 80));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelVuelto.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 230, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MONTO RECIBIDO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        panelVuelto.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 50));

        panelPagoElectronico.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCero1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCero1.setText("0");
        btnCero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCero1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 70, 60));

        btnSiete1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSiete1.setText("7");
        btnSiete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiete1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnSiete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 60));

        btnCuatro1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCuatro1.setText("4");
        btnCuatro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatro1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCuatro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 60));

        btnUno1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUno1.setText("1");
        btnUno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUno1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnUno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 60));

        btnPunto1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnPunto1.setText(".");
        btnPunto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPunto1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnPunto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 70, 60));

        btnOcho1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnOcho1.setText("8");
        btnOcho1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcho1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnOcho1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 70, 60));

        btnCinco1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCinco1.setText("5");
        btnCinco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCinco1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCinco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 70, 60));

        btnDos1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDos1.setText("2");
        btnDos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDos1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnDos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 70, 60));

        btnBorrar1.setBackground(new java.awt.Color(255, 51, 51));
        btnBorrar1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        btnBorrar1.setText("<");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 70, 60));

        btnNueve1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNueve1.setText("9");
        btnNueve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueve1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnNueve1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 60));

        btnSeis1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSeis1.setText("6");
        btnSeis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeis1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnSeis1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 70, 60));

        btnTres1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnTres1.setText("3");
        btnTres1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTres1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnTres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, 60));

        txtVuelto1.setEditable(false);
        txtVuelto1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtVuelto1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelPagoElectronico.getContentPane().add(txtVuelto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 230, 60));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VUELTO");
        panelPagoElectronico.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 250, -1));

        btnRealizarVenta1.setBackground(new java.awt.Color(0, 153, 0));
        btnRealizarVenta1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRealizarVenta1.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarVenta1.setText("COBRAR");
        btnRealizarVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVenta1ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnRealizarVenta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 230, 60));

        txtMontoRecibido1.setEditable(false);
        txtMontoRecibido1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtMontoRecibido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelPagoElectronico.getContentPane().add(txtMontoRecibido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 80));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 230, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MONTO RECIBIDO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        panelPagoElectronico.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PUNTO DE VENTA - BARRA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel5.setText("DOCUMENTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        listaCategorias.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        listaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaCategorias);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, 380));

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

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 1320, 300));

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
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, -1));

        cmbDocumento.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        getContentPane().add(cmbDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(null);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 110, 360, 70));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("CANTIDAD");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 80, -1, -1));

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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 1030, 380));

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel10.setText("PRODUCTOS");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("X");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 960, 70, -1));

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
        getContentPane().add(btnPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 950, 250, 50));
        getContentPane().add(lblComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 160, 20));

        lblUltimoComprobante1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblUltimoComprobante1.setText("N° COMPROBANTE");
        getContentPane().add(lblUltimoComprobante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

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
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1550, 850, 290, 10));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel15.setText("PAGO");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 760, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1490, 180, 360, 10));

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
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 30, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("RAZON SOCIAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 120, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 330, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 330, -1));

        btnMasterCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masterCard.png"))); // NOI18N
        btnMasterCard.setBorderPainted(false);
        btnMasterCard.setContentAreaFilled(false);
        getContentPane().add(btnMasterCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 80, 130, 80));

        btnVisa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa.png"))); // NOI18N
        btnVisa1.setBorderPainted(false);
        btnVisa1.setContentAreaFilled(false);
        getContentPane().add(btnVisa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 80, 130, 80));

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
            panelVuelto.setVisible(true);
            //panelVuelto.setModal(closable);
            panelVuelto.setBounds(780, 300, 265, 690);
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
            double prec = Double.parseDouble(tblProductos.getValueAt(fila, 3).toString());
            int cant = Integer.parseInt(txtCantidad.getText());
            double subtotal = prec * cant;
            Object datos[] = {cod, prod, prec, cant, subtotal};
            table1.addRow(datos);
            tblPedidos.setModel(table1);
            lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
            tblProductos.clearSelection();
            listaCategorias.clearSelection();
            bloquearBotones();
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
            int idTipoComprobante = new VentasControl().getIdComprobanteConNombre(cmbDocumento.getSelectedItem().toString());

            //creamos el comprobante
            Comprobante c = new Comprobante();
            c.setFecha(fecha);
            c.setUsuario(usuario);
            c.setCliente("mrjuerga");
            c.setCantidad(0);
            c.setSubTotal(subtotal);
            c.setRuc("12345678912");
            c.setDireccion(direccion);
            c.setTipo_pago("CONTADO");
            c.setTotal(total);
            c.setIdtipocomprobante(idTipoComprobante);

            //creamos el comprobante con acceso a datos
            ComprobanteDAO cdao = new ComprobanteDAO();
            //ejecutamos el metodo registrar
            if (cdao.Registrar(c)) {
                System.out.println("Comprobante Registrado");
            } else {
                System.out.println("Error");
            }
            //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA
            Object[] datos = new Object[7];
            datos[0] = fecha;
            datos[1] = txtHora.getText();
            datos[2] = new VentasControl().getIdUsuarioConNombre(usuario);
            datos[3] = 1;
            datos[4] = 1;//capturar el ultimo comprobante registrado
            datos[5] = 1;//ESTADO->> 0:PENDIENTE     1:PAGADO
            datos[6] = 1;//capturar la caja que realiza la operacion
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
                
                parametros.put("id_venta", idventa);
                parametros.put("total", total);
                mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaVenta.jrxml", parametros, getPageSize());
                mrv.setNombreArchivo("BoletaVenta");
                try {
                    mrv.exportarAPdfConCopia();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                mrv.dispose();
                panelVuelto.dispose();
                cargarDatos(usuario);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnCero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCero1ActionPerformed

    private void btnSiete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiete1ActionPerformed

    private void btnCuatro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCuatro1ActionPerformed

    private void btnUno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUno1ActionPerformed

    private void btnPunto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPunto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPunto1ActionPerformed

    private void btnOcho1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcho1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOcho1ActionPerformed

    private void btnCinco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCinco1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCinco1ActionPerformed

    private void btnDos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDos1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnNueve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueve1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNueve1ActionPerformed

    private void btnSeis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeis1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeis1ActionPerformed

    private void btnTres1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTres1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTres1ActionPerformed

    private void btnRealizarVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRealizarVenta1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnCero;
    private javax.swing.JButton btnCero1;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCinco1;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnCuatro1;
    public javax.swing.JButton btnDel;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnDos1;
    private javax.swing.JToggleButton btnMasterCard;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnNueve1;
    private javax.swing.JButton btnOcho;
    private javax.swing.JButton btnOcho1;
    private javax.swing.JButton btnPendientes;
    private javax.swing.JButton btnPunto;
    private javax.swing.JButton btnPunto1;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JButton btnRealizarVenta1;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSeis1;
    private javax.swing.JButton btnSiete;
    private javax.swing.JButton btnSiete1;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnTres1;
    private javax.swing.JButton btnUno;
    private javax.swing.JButton btnUno1;
    private javax.swing.JToggleButton btnVisa1;
    private javax.swing.JCheckBox cboxMasVendidos;
    private javax.swing.JComboBox cmbDocumento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblComprobante;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblUltimoComprobante1;
    private javax.swing.JList listaCategorias;
    private javax.swing.JDialog panelPagoElectronico;
    private javax.swing.JDialog panelVuelto;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCaja;
    public javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMontoRecibido;
    private javax.swing.JTextField txtMontoRecibido1;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVuelto;
    private javax.swing.JTextField txtVuelto1;
    // End of variables declaration//GEN-END:variables

    private void cargarTitulosTablaPedidos() {
        String[] titulos = {"CODIGO", "PRODUCTO", "PRECIO", "CANTIDAD", "SUBTOTAL"};
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
