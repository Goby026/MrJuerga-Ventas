package Vista;

import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.VentasControl;
import Modelo.Conexion;
import Modelo.FlujoCajaDAO;
import Modelo.Operacion;
import Modelo.Operacion2;
import Modelo.Operacion3;
import Modelo.OperacionDAO;
import Modelo.OperacionDAO2;
import Modelo.OperacionDAO3;
import Modelo.Presentacion;
import Modelo.PresentacionDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.ProductoPresentacion;
import Modelo.ProductoPresentacionDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    DefaultTableModel table1;
    DefaultTableModel modeloMasVendidos;
    DefaultTableModel modeloOP;
    MyiReportVisor mrv;
    HashMap parametros = new HashMap();
    JTextField te = new JTextField();
    int tipoPago = 1;
    Integer num = null;
    int complemento = 0;
    String nroSerie = "003";
    int idWarehouse = 2;

    public Ventas(String usuario) throws Exception {
        setUndecorated(true);
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        PanelComplementos.getContentPane().setBackground(Color.white);
        cargarDatos(usuario);
    }

    public Ventas() {
    }

    public void addBotones() {
        grupoVisaMaster.add(btnVisaOP);
        grupoVisaMaster.add(btnMasterOP);
    }

    public void cargarDatos(String usuario) throws Exception {
//        panelVuelto.getRootPane().setBackground(Color.DARK_GRAY);
        panelPagoElectronico.setUndecorated(true);
        AWTUtilities.setWindowOpaque(panelPagoElectronico, false);
        panelVuelto.setUndecorated(true);
        AWTUtilities.setWindowOpaque(panelVuelto, false);
        //new VentasControl().llenarListaCategorias(listaCategorias);
        txtCaja.setText(new VentasControl().getCajaDeUsuario(usuario));
        new Cronometro().iniciarCronometro(txtHora);
        addBotones();
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        JScrollBar jScrollBar1 = new javax.swing.JScrollBar();
        jScrollBar1.setPreferredSize(new java.awt.Dimension(50, 0));
        scrollProductos.setVerticalScrollBar(jScrollBar1);
        cargarTitulosTablaPedidos();
        bloquearBotones();
        int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new VentasControl().getIdUsuarioConNombre(txtUsuario.getText()), new VentasControl().getIdCaja(txtCaja.getText()));
        switch (txtCaja.getText()) {
            case "GENERAL 1":
                num = 1;
                tablaProductosMasVendidos(idFlujoCaja);
                break;
            case "GENERAL 2":
                num = 2;
                tablaProductosMasVendidos2(idFlujoCaja);
                break;
            case "VIP":
                num = 3;
                idWarehouse = 3;
                tablaProductosMasVendidos3(idFlujoCaja);
                break;
            default:
                num = null;
                tablaProductosMasVendidos(idFlujoCaja);
        }
        System.out.println("NUMERO DE CAJA ES: " + num);
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
        lblIconoTarjeta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        operacionCombinada = new javax.swing.JDialog();
        lblCuenta = new javax.swing.JLabel();
        txtNumReferenciaCombinada = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtMontoCombinada = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtefectivoCombinada = new javax.swing.JTextField();
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
        btnVisaOP = new javax.swing.JToggleButton();
        btnMasterOP = new javax.swing.JToggleButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOp = new javax.swing.JTable();
        btnAgregarOP = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnQuitarOP = new javax.swing.JButton();
        btnPuntoCombinada = new javax.swing.JButton();
        tablet = new javax.swing.JLabel();
        fondo2 = new javax.swing.JPanel();
        fondo = new javax.swing.JPanel();
        grupoCategorias = new javax.swing.ButtonGroup();
        grupoVisaMaster = new javax.swing.ButtonGroup();
        PanelComplementos = new javax.swing.JDialog();
        jLabel29 = new javax.swing.JLabel();
        lblCantidadSlider = new javax.swing.JLabel();
        txtPresentacionComplemento = new javax.swing.JTextField();
        txtProductoComplemento = new javax.swing.JTextField();
        sliderCantidad = new javax.swing.JSlider();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnCocaCola = new javax.swing.JToggleButton();
        btnRedBull = new javax.swing.JToggleButton();
        btnGinger1 = new javax.swing.JToggleButton();
        btnGuarana = new javax.swing.JToggleButton();
        btnGloriaNaranja = new javax.swing.JToggleButton();
        btnGloriaPiña = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        btnConfirmarComplemento = new javax.swing.JButton();
        btnAguaMineral = new javax.swing.JToggleButton();
        PanelPromocion = new javax.swing.JDialog();
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
        scrollProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblProductos = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnEfectivo = new javax.swing.JButton();
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
        jLabel22 = new javax.swing.JLabel();
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
        jLabel20 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnFactura = new javax.swing.JToggleButton();
        jButton4 = new javax.swing.JButton();
        btnBebidasJarra = new javax.swing.JToggleButton();
        btnCocteles = new javax.swing.JToggleButton();
        btnBebidasPorBotella = new javax.swing.JToggleButton();
        btnGaseosasCervezas = new javax.swing.JToggleButton();
        btnOtros = new javax.swing.JToggleButton();
        btnCigarrillos = new javax.swing.JToggleButton();
        btnvisa = new javax.swing.JButton();
        btnMastercard = new javax.swing.JButton();
        btnOpCombinada = new javax.swing.JButton();
        btn3x2 = new javax.swing.JButton();

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
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
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
        panelPagoElectronico.getContentPane().add(btnCobrarConTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 230, 60));

        txtNumReferencia.setEditable(false);
        txtNumReferencia.setBackground(new java.awt.Color(255, 255, 255));
        txtNumReferencia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtNumReferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelPagoElectronico.getContentPane().add(txtNumReferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 230, 50));

        btnCancelarTarjeta.setBorderPainted(false);
        btnCancelarTarjeta.setContentAreaFilled(false);
        btnCancelarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTarjetaActionPerformed(evt);
            }
        });
        panelPagoElectronico.getContentPane().add(btnCancelarTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 637, 60, 62));
        panelPagoElectronico.getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 230, 10));
        panelPagoElectronico.getContentPane().add(lblIconoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 35, 35));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("NUMERO DE OPERACION");
        panelPagoElectronico.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borderIphone.png"))); // NOI18N
        panelPagoElectronico.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 720));

        operacionCombinada.setBackground(new java.awt.Color(61, 163, 162));
        operacionCombinada.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCuenta.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        lblCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblCuenta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCuenta.setText("::::::::::::::::::::::::::::::");
        operacionCombinada.getContentPane().add(lblCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 160, 20));

        txtNumReferenciaCombinada.setBackground(new java.awt.Color(70, 180, 162));
        txtNumReferenciaCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtNumReferenciaCombinada.setForeground(new java.awt.Color(255, 255, 255));
        txtNumReferenciaCombinada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumReferenciaCombinada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        operacionCombinada.getContentPane().add(txtNumReferenciaCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 160, 40));
        txtNumReferenciaCombinada.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                te = txtNumReferenciaCombinada;
            }

            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("de-selected");
            }
        });

        jLabel25.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("MONTO");
        operacionCombinada.getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 210, 20));

        txtMontoCombinada.setBackground(new java.awt.Color(70, 180, 162));
        txtMontoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtMontoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        txtMontoCombinada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMontoCombinada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        operacionCombinada.getContentPane().add(txtMontoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 160, 40));
        txtMontoCombinada.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                te = txtMontoCombinada;
            }

            @Override
            public void focusLost(FocusEvent e) {
                //System.out.println("de-selected");
            }
        });

        jLabel26.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 30)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 255, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("EFECTIVO");
        operacionCombinada.getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 620, 170, 30));

        txtefectivoCombinada.setBackground(new java.awt.Color(70, 180, 162));
        txtefectivoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtefectivoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        txtefectivoCombinada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtefectivoCombinada.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        operacionCombinada.getContentPane().add(txtefectivoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 260, 40));

        txtCobrarCombinada.setBackground(new java.awt.Color(102, 255, 0));
        txtCobrarCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtCobrarCombinada.setText("COBRAR");
        txtCobrarCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCobrarCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(txtCobrarCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 450, 50));

        btnSalirOpCombinada.setContentAreaFilled(false);
        btnSalirOpCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirOpCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnSalirOpCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 772, 190, 30));

        btnCuatroCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnCuatroCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnCuatroCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnCuatroCombinada.setText("4");
        btnCuatroCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnCuatroCombinada.setContentAreaFilled(false);
        btnCuatroCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnCuatroCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 330, 110, 90));

        btnSeisCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnSeisCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnSeisCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnSeisCombinada.setText("6");
        btnSeisCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnSeisCombinada.setContentAreaFilled(false);
        btnSeisCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnSeisCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 330, 110, 90));

        btnNueveCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnNueveCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnNueveCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnNueveCombinada.setText("9");
        btnNueveCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnNueveCombinada.setContentAreaFilled(false);
        btnNueveCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnNueveCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 110, 90));

        btnCincoCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnCincoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnCincoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnCincoCombinada.setText("5");
        btnCincoCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnCincoCombinada.setContentAreaFilled(false);
        btnCincoCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnCincoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, 110, 90));

        btnSieteCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnSieteCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnSieteCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnSieteCombinada.setText("7");
        btnSieteCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnSieteCombinada.setContentAreaFilled(false);
        btnSieteCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnSieteCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 110, 90));

        btnOchoCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnOchoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnOchoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnOchoCombinada.setText("8");
        btnOchoCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnOchoCombinada.setContentAreaFilled(false);
        btnOchoCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnOchoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, 110, 90));

        btnCeroCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnCeroCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnCeroCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnCeroCombinada.setText("0");
        btnCeroCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnCeroCombinada.setContentAreaFilled(false);
        btnCeroCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnCeroCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 110, 90));

        btnBorrarCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnBorrarCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnBorrarCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarCombinada.setText("<");
        btnBorrarCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnBorrarCombinada.setContentAreaFilled(false);
        btnBorrarCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnBorrarCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 530, 110, 90));

        btnunoCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnunoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnunoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnunoCombinada.setText("1");
        btnunoCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnunoCombinada.setContentAreaFilled(false);
        btnunoCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnunoCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnunoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 110, 90));

        btnDosCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnDosCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnDosCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnDosCombinada.setText("2");
        btnDosCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnDosCombinada.setContentAreaFilled(false);
        btnDosCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnDosCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 110, 90));

        btnTresCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnTresCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnTresCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnTresCombinada.setText("3");
        btnTresCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnTresCombinada.setContentAreaFilled(false);
        btnTresCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnTresCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 110, 90));

        btnVisaOP.setBackground(new java.awt.Color(70, 180, 162));
        btnVisaOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa.png"))); // NOI18N
        btnVisaOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaOPActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnVisaOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 130, 80));

        btnMasterOP.setBackground(new java.awt.Color(70, 180, 162));
        btnMasterOP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masterCard.png"))); // NOI18N
        btnMasterOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterOPActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnMasterOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 130, 80));

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("COMBINADAS");
        operacionCombinada.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 100, 40));

        tblOp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblOp);

        operacionCombinada.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 450, 190));

        btnAgregarOP.setBackground(new java.awt.Color(204, 255, 204));
        btnAgregarOP.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnAgregarOP.setText("AGREGAR");
        btnAgregarOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarOPActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnAgregarOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 450, 40));

        jLabel27.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 48)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("OPERACIONES");
        operacionCombinada.getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 300, 40));

        jLabel28.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("NUMERO REFERENCIA");
        operacionCombinada.getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 210, 20));

        btnQuitarOP.setBackground(new java.awt.Color(255, 102, 102));
        btnQuitarOP.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnQuitarOP.setText("quitar");
        btnQuitarOP.setBorderPainted(false);
        btnQuitarOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarOPActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnQuitarOP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 540, 80, 30));

        btnPuntoCombinada.setBackground(new java.awt.Color(61, 163, 162));
        btnPuntoCombinada.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        btnPuntoCombinada.setForeground(new java.awt.Color(255, 255, 255));
        btnPuntoCombinada.setText(".");
        btnPuntoCombinada.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnPuntoCombinada.setContentAreaFilled(false);
        btnPuntoCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntoCombinadaActionPerformed(evt);
            }
        });
        operacionCombinada.getContentPane().add(btnPuntoCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 110, 90));

        tablet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tablet.png"))); // NOI18N
        operacionCombinada.getContentPane().add(tablet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 820));

        fondo2.setBackground(new java.awt.Color(70, 180, 162));
        operacionCombinada.getContentPane().add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 550, 720));

        fondo.setBackground(new java.awt.Color(61, 163, 162));
        operacionCombinada.getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 550, 720));

        PanelComplementos.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        PanelComplementos.setTitle("COMPLEMENTOS");
        PanelComplementos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 204, 153));
        jLabel29.setText("PRODUCTO");
        PanelComplementos.getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 140, -1));

        lblCantidadSlider.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCantidadSlider.setForeground(new java.awt.Color(255, 204, 153));
        lblCantidadSlider.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadSlider.setText("1");
        PanelComplementos.getContentPane().add(lblCantidadSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 40, -1));

        txtPresentacionComplemento.setEditable(false);
        txtPresentacionComplemento.setBackground(new java.awt.Color(102, 102, 102));
        txtPresentacionComplemento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PanelComplementos.getContentPane().add(txtPresentacionComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 300, -1));

        txtProductoComplemento.setEditable(false);
        txtProductoComplemento.setBackground(new java.awt.Color(102, 102, 102));
        txtProductoComplemento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PanelComplementos.getContentPane().add(txtProductoComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 300, -1));

        sliderCantidad.setBackground(new java.awt.Color(102, 102, 102));
        sliderCantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sliderCantidad.setForeground(new java.awt.Color(255, 204, 153));
        sliderCantidad.setMajorTickSpacing(1);
        sliderCantidad.setMaximum(5);
        sliderCantidad.setMinimum(1);
        sliderCantidad.setPaintLabels(true);
        sliderCantidad.setPaintTicks(true);
        sliderCantidad.setValue(1);
        sliderCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderCantidadStateChanged(evt);
            }
        });
        PanelComplementos.getContentPane().add(sliderCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 270, 90));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 204, 153));
        jLabel31.setText("PRESENTACION");
        PanelComplementos.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 140, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 204, 153));
        jLabel32.setText("CANTIDAD");
        PanelComplementos.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 110, -1));

        btnCocaCola.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/COCA-COLA.png"))); // NOI18N
        btnCocaCola.setContentAreaFilled(false);
        btnCocaCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCocaColaActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnCocaCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 250));

        btnRedBull.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/red bull.png"))); // NOI18N
        btnRedBull.setContentAreaFilled(false);
        btnRedBull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedBullActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnRedBull, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 150, 250));

        btnGinger1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/schweppes.PNG"))); // NOI18N
        btnGinger1.setContentAreaFilled(false);
        btnGinger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGinger1ActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnGinger1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 250));

        btnGuarana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/botella-guarana.png"))); // NOI18N
        btnGuarana.setContentAreaFilled(false);
        btnGuarana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuaranaActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnGuarana, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 150, 250));

        btnGloriaNaranja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jugo-naranja.PNG"))); // NOI18N
        btnGloriaNaranja.setContentAreaFilled(false);
        btnGloriaNaranja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGloriaNaranjaActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnGloriaNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 150, 250));

        btnGloriaPiña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jugo-piña.PNG"))); // NOI18N
        btnGloriaPiña.setContentAreaFilled(false);
        btnGloriaPiña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGloriaPiñaActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnGloriaPiña, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 150, 250));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMPLEMENTOS");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, -1));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 10));

        btnConfirmarComplemento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmarComplemento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok-logo.jpg"))); // NOI18N
        btnConfirmarComplemento.setBorderPainted(false);
        btnConfirmarComplemento.setContentAreaFilled(false);
        btnConfirmarComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarComplementoActionPerformed(evt);
            }
        });
        jPanel3.add(btnConfirmarComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, 150, 130));

        PanelComplementos.getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 390, 810));

        btnAguaMineral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/san-mateo.png"))); // NOI18N
        btnAguaMineral.setContentAreaFilled(false);
        btnAguaMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAguaMineralActionPerformed(evt);
            }
        });
        PanelComplementos.getContentPane().add(btnAguaMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 150, 250));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PUNTO DE VENTA - BARRA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPedidos.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
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
        tblPedidos.setDragEnabled(true);
        tblPedidos.setRowHeight(50);
        tblPedidos.setRowMargin(4);
        tblPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblPedidos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, 1390, 220));

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-five.png"))); // NOI18N
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 280, 90, 100));

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-seven.png"))); // NOI18N
        btn7.setBorderPainted(false);
        btn7.setContentAreaFilled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        getContentPane().add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 180, 90, 100));

        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-nine.png"))); // NOI18N
        btn9.setBorderPainted(false);
        btn9.setContentAreaFilled(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 180, 90, 100));

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-six.png"))); // NOI18N
        btn6.setBorderPainted(false);
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 280, 90, 100));

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-eight.png"))); // NOI18N
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 180, 90, 100));

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-four.png"))); // NOI18N
        btn4.setBorderPainted(false);
        btn4.setContentAreaFilled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 280, 90, 100));

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-one.png"))); // NOI18N
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 380, 90, 100));

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-three.png"))); // NOI18N
        btn3.setBorderPainted(false);
        btn3.setContentAreaFilled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1690, 380, 90, 100));

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-two.png"))); // NOI18N
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 380, 90, 100));

        btn0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/number-ten.png"))); // NOI18N
        btn0.setBorderPainted(false);
        btn0.setContentAreaFilled(false);
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(1580, 490, 90, 100));

        btnDel.setBackground(new java.awt.Color(255, 0, 0));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/escobilla-de-suelo.png"))); // NOI18N
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        getContentPane().add(btnDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1680, 490, 90, 90));

        jLabel8.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel8.setText("LISTA DE PEDIDOS");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 55)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 110, 310, 70));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 28)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("CANTIDAD");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 80, 310, 30));

        btnAgregar.setBackground(new java.awt.Color(0, 102, 255));
        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok-me-gusta-signo-de-la-mano.png"))); // NOI18N
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setEnabled(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 490, 90, 90));

        tblProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProductos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 1, true));
        tblProductos.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
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
        tblProductos.setDragEnabled(true);
        tblProductos.setRowHeight(50);
        tblProductos.setRowMargin(10);
        tblProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        scrollProductos.setViewportView(tblProductos);

        getContentPane().add(scrollProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 1100, 440));

        lblProductos.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        lblProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductos.setText("PRODUCTOS");
        getContentPane().add(lblProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 1100, -1));

        btnQuitar.setBackground(new java.awt.Color(255, 0, 0));
        btnQuitar.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("X");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 950, 130, 50));

        btnEfectivo.setBackground(new java.awt.Color(0, 204, 0));
        btnEfectivo.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        btnEfectivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dinero.png"))); // NOI18N
        btnEfectivo.setText("EFECTIVO");
        btnEfectivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEfectivo.setIconTextGap(10);
        btnEfectivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 740, 140, 220));

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel11.setText("S/.");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 660, -1, -1));

        lblPago.setFont(new java.awt.Font("Consolas", 1, 80)); // NOI18N
        lblPago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 630, 350, 90));

        btnPendientes.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnPendientes.setText("LISTA DE PEDIDOS");
        btnPendientes.setEnabled(false);
        btnPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 970, 340, 30));

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
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1570, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(51, 153, 255));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 20, 90, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(51, 153, 255));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("VENTAS BARRA");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        txtCaja.setEditable(false);
        txtCaja.setBackground(new java.awt.Color(51, 153, 255));
        txtCaja.setForeground(new java.awt.Color(255, 255, 255));
        txtCaja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCaja.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "CAJA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 250, -1));

        jLabel22.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida.png"))); // NOI18N
        jLabel22.setText("SALIR");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1790, 0, 130, 70));

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
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("CATEGORIAS");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 300, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 720, 350, 10));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel15.setText("PAGO");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 620, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 180, 310, 10));

        cboxMasVendidos.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        cboxMasVendidos.setForeground(new java.awt.Color(0, 102, 255));
        cboxMasVendidos.setText("LOS MAS VENDIDOS");
        cboxMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxMasVendidosActionPerformed(evt);
            }
        });
        getContentPane().add(cboxMasVendidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 670, -1, 40));

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("RUC");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 30, -1));

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("RAZÓN SOCIAL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 120, -1));

        txtRazonSocial.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtRazonSocial.setEnabled(false);
        getContentPane().add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 370, -1));

        txtRuc.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtRuc.setEnabled(false);
        getContentPane().add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 240, -1));

        jLabel20.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 153, 153));
        jLabel20.setText("DIRECCIÓN");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 90, -1));

        txtDireccion.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtDireccion.setEnabled(false);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 800, -1));

        btnFactura.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnFactura.setText("FACTURA");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 70));

        jButton4.setText("B");
        jButton4.setEnabled(false);
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        btnBebidasJarra.setBackground(new java.awt.Color(102, 153, 255));
        grupoCategorias.add(btnBebidasJarra);
        btnBebidasJarra.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnBebidasJarra.setForeground(new java.awt.Color(255, 255, 255));
        btnBebidasJarra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bebidasJarra.png"))); // NOI18N
        btnBebidasJarra.setText("BEBIDAS EN JARRA");
        btnBebidasJarra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnBebidasJarra.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBebidasJarra.setIconTextGap(10);
        btnBebidasJarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasJarraActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebidasJarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 300, 72));

        btnCocteles.setBackground(new java.awt.Color(102, 102, 255));
        grupoCategorias.add(btnCocteles);
        btnCocteles.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnCocteles.setForeground(new java.awt.Color(255, 255, 255));
        btnCocteles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bebidasCopa.png"))); // NOI18N
        btnCocteles.setText("COCTELES EN COPA");
        btnCocteles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCocteles.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCocteles.setIconTextGap(10);
        btnCocteles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoctelesActionPerformed(evt);
            }
        });
        getContentPane().add(btnCocteles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 273, 300, 72));

        btnBebidasPorBotella.setBackground(new java.awt.Color(0, 102, 153));
        grupoCategorias.add(btnBebidasPorBotella);
        btnBebidasPorBotella.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnBebidasPorBotella.setForeground(new java.awt.Color(255, 255, 255));
        btnBebidasPorBotella.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bebidasBotella.png"))); // NOI18N
        btnBebidasPorBotella.setText("BEBIDAS POR BOTELLA");
        btnBebidasPorBotella.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnBebidasPorBotella.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnBebidasPorBotella.setIconTextGap(10);
        btnBebidasPorBotella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasPorBotellaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebidasPorBotella, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 346, 300, 72));

        btnGaseosasCervezas.setBackground(new java.awt.Color(0, 51, 255));
        grupoCategorias.add(btnGaseosasCervezas);
        btnGaseosasCervezas.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnGaseosasCervezas.setForeground(new java.awt.Color(255, 255, 255));
        btnGaseosasCervezas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gaseosasCervezas.png"))); // NOI18N
        btnGaseosasCervezas.setText("GASEOSAS Y CERVEZAS");
        btnGaseosasCervezas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnGaseosasCervezas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnGaseosasCervezas.setIconTextGap(10);
        btnGaseosasCervezas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaseosasCervezasActionPerformed(evt);
            }
        });
        getContentPane().add(btnGaseosasCervezas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 419, 300, 72));

        btnOtros.setBackground(new java.awt.Color(0, 102, 102));
        grupoCategorias.add(btnOtros);
        btnOtros.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnOtros.setForeground(new java.awt.Color(255, 255, 255));
        btnOtros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/otros.png"))); // NOI18N
        btnOtros.setText("OTROS");
        btnOtros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnOtros.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnOtros.setIconTextGap(10);
        btnOtros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnOtros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 565, 300, 72));

        btnCigarrillos.setBackground(new java.awt.Color(51, 0, 153));
        grupoCategorias.add(btnCigarrillos);
        btnCigarrillos.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnCigarrillos.setForeground(new java.awt.Color(255, 255, 255));
        btnCigarrillos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cigarrillo-con-humo.png"))); // NOI18N
        btnCigarrillos.setText("CIGARRILLO");
        btnCigarrillos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCigarrillos.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnCigarrillos.setIconTextGap(10);
        btnCigarrillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCigarrillosActionPerformed(evt);
            }
        });
        getContentPane().add(btnCigarrillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 492, 300, 72));

        btnvisa.setBackground(new java.awt.Color(204, 255, 255));
        btnvisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa.png"))); // NOI18N
        btnvisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvisaActionPerformed(evt);
            }
        });
        getContentPane().add(btnvisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 740, 150, 110));

        btnMastercard.setBackground(new java.awt.Color(255, 204, 153));
        btnMastercard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masterCard.png"))); // NOI18N
        btnMastercard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMastercardActionPerformed(evt);
            }
        });
        getContentPane().add(btnMastercard, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 850, 150, 110));

        btnOpCombinada.setBackground(new java.awt.Color(204, 255, 204));
        btnOpCombinada.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        btnOpCombinada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comb-buy.png"))); // NOI18N
        btnOpCombinada.setText("OP.COMB");
        btnOpCombinada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOpCombinada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOpCombinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpCombinadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpCombinada, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 740, 140, 220));

        btn3x2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3x2.png"))); // NOI18N
        btn3x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3x2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3x2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1800, 490, 90, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        try {
            tipoPago = 1;
            System.out.println("tipo de operacion: " + tipoPago);
            int filaPedidos = tblPedidos.getRowCount();
            if (filaPedidos <= 0) {
                JOptionPane.showMessageDialog(getRootPane(), "AGREGUE PRODUCTOS A LA LISTA DE PEDIDOS");
            } else if (btnFactura.isSelected()) {
                //recibir los tres parametros para la factura
//                String razon = txtRazonSocial.getText();
//                String ruc = txtRuc.getText();
//                String direccion = txtDireccion.getText();
                //registrar cliente
                panelVuelto.setVisible(true);
                panelVuelto.setBounds(580, 100, 460, 950);
            } else {
                //imprimir normalmente la boleta
                panelVuelto.setVisible(true);
                panelVuelto.setBounds(580, 100, 460, 950);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnEfectivoActionPerformed

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
        System.out.println("COMPLEMENTO OK:"+complemento);
        try {
            int opc = 2;
            switch (txtCaja.getText()) {
                case "VIP":
                    opc = 3;
                    break;
            }
            int fila = tblProductos.getSelectedRow();
            int cod = getIdProductoConNombre(tblProductos.getValueAt(fila, 0).toString(), opc);
            String prod = tblProductos.getValueAt(fila, 0).toString();
            String presentacion = tblProductos.getValueAt(fila, 1).toString();
            Double prec = Double.parseDouble(tblProductos.getValueAt(fila, 3).toString());
            System.out.println("precio: " + prec);
            Double cant = Double.parseDouble(txtCantidad.getText());
            System.out.println("cantidad: " + cant);
            double subtotal = prec * cant;
            System.out.println("subtotal: " + subtotal);
            if (cant == 0) {
                JOptionPane.showMessageDialog(getRootPane(), "EL VALOR 0 NO DISPONE DE OPERACIONES");
            } else if (Double.parseDouble(tblProductos.getValueAt(fila, 2).toString()) < cant) {
                JOptionPane.showMessageDialog(getRootPane(), "NO SE CUENTA CON LAS UNIDADES SOLICITADAS");
            } else {
                if (complemento > 0) {
                    PanelComplementos.setVisible(true);
                    PanelComplementos.setBounds(300, 100, 924, 824);
                    //905, 814
                }
                Object datos[] = {cod, prod, presentacion, prec, cant, subtotal};
                table1.addRow(datos);
                tblPedidos.setModel(table1);
                lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
                tblProductos.clearSelection();
//                listaCategorias.clearSelection();

                tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(20);
                tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(300);
                tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(200);
                tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
                tblPedidos.getColumnModel().getColumn(4).setPreferredWidth(50);
                tblPedidos.getColumnModel().getColumn(5).setPreferredWidth(50);

                bloquearBotones();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int fila = tblProductos.getSelectedRow();
        if (fila >= 0) {
            try {
                String nomProd = tblProductos.getValueAt(fila, 0).toString();
                int idProd = getIdProductoConNombre(nomProd, 2);
                ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProd);

                System.out.println("Categoria ="+pp.getIdcategoria());
                
                if (pp.getIdcategoria() == 3) {
                    complemento = 1;
                } else {
                    complemento = 0;
                }
                
                System.out.println("CLICK :"+complemento);

                desbloquearBotones();
                txtCantidad.setText("");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

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
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new VentasControl().getIdUsuarioConNombre(txtUsuario.getText()), new VentasControl().getIdCaja(txtCaja.getText()));
            if (cboxMasVendidos.isSelected()) {
                switch (num) {
                    case 1:
                        tablaProductosMasVendidos(idFlujoCaja);
                        break;
                    case 2:
                        tablaProductosMasVendidos2(idFlujoCaja);
                        break;
                    case 3:
                        tablaProductosMasVendidos3(idFlujoCaja);
                        break;
                }
            } else {
                LimpiarTabla(tblProductos, modeloMasVendidos);
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
            //VALIDAMOS SI ESTA ESCRITO EL TXT
            if (!txtMontoRecibido.getText().trim().isEmpty()) {//si NO esta vacio

                if (Double.parseDouble(txtVuelto.getText()) >= 0) {//si el monto es MAYOR a cero

                    int numTicket = -1;
                    String fecha = new ManejadorFechas().getFechaActualMySQL();
                    String usuario = txtUsuario.getText();
                    //cliente lo pasamos en duro
                    //cantidad, de que????
                    Double subtotal = Double.parseDouble(lblPago.getText());
                    //ruc lo pasamos en duro
                    String direccion = "JR AYACUCHO 772";
                    //tipo de pago lo pasamos en duro hasta normalizar el TIPODEPAGO
                    Double total = Double.parseDouble(lblPago.getText());
                    //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA
                    Venta v = new Venta();
//                    Object[] datos = new Object[10];
                    v.setFecha(fecha);
                    v.setHora(new ManejadorFechas().getHoraActual());
                    v.setIdUsuario(new VentasControl().getIdUsuarioConNombre(usuario));
                    v.setIdCliente(1);
                    v.setIdTipoComprobante(1);
                    v.setEstado(1);//ESTADO->> 0:PENDIENTE     1:PAGADO
                    v.setTipopago(tipoPago);
                    v.setnOperacion("");
                    v.setIdcaja(new VentasControl().getIdCaja(txtCaja.getText()));
                    v.setIdFlujoCaja(new FlujoCajaDAO().getIdFlujo(new VentasControl().getIdUsuarioConNombre(usuario), new VentasControl().getIdCaja(txtCaja.getText())));

                    VentasControl vc = new VentasControl();
                    VentaDAO vdao = new VentaDAO();
                    String caja = txtCaja.getText();
                    Integer idventa = null;
                    Integer flag = null;
                    switch (caja) {
                        case "GENERAL 1":
                            if (vdao.registrar(v)) {
                                idventa = new VentasControl().getIdDeUltimaVentaRegistrada();
                                flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                                numTicket = 1;
                                nroSerie = "003 -";
                                System.out.println("venta registrada");
                                System.out.println("SERIE: " + nroSerie);
                                System.out.println("numero de ticket: " + numTicket);
                            }
                            break;
                        case "GENERAL 2":
                            if (vdao.registrar2(v)) {
                                idventa = new VentasControl().getIdDeUltimaVentaRegistrada2();
                                flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                                numTicket = 2;
                                nroSerie = "004 -";
                                System.out.println("ventaCaja2 registrada");
                                System.out.println("SERIE: " + nroSerie);
                                System.out.println("numero de ticket: " + numTicket);
                            }
                            break;
                        case "VIP":
                            if (vdao.registrar3(v)) {
                                idventa = new VentasControl().getIdDeUltimaVentaRegistrada3();
                                flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                                numTicket = 3;
                                nroSerie = "005 -";
                                System.out.println("ventaCaja3 registrada");
                                System.out.println("SERIE: " + nroSerie);
                                System.out.println("numero de ticket: " + numTicket);
                            }
                            break;
                    }
                    //TERCERO REGISTRO LOS DETALLES DE LA VENTA
                    //comprobar de que tabla se debe tomar el ultimo id registrado                    
                    System.out.println("ultima venta: " + idventa);
                    System.out.println("flag: " + flag);
//                    String serie = null;

                    if (flag > 0) {
                        JOptionPane.showMessageDialog(null, "VENTA REALIZADA EXITOSAMENTE");

                        if (btnFactura.isSelected()) {
                            //REGISTRO DE FACTURA
                            parametros.put("id_venta", idventa);
                            parametros.put("raz_social", txtRazonSocial.getText());
                            parametros.put("ruc", txtRuc.getText());
                            parametros.put("direc", txtDireccion.getText());
                            parametros.put("cajero", txtUsuario.getText());
                            double igv = (Double.parseDouble(lblPago.getText()) / 1.18) * 0.18;
                            parametros.put("subtotal", Double.parseDouble(lblPago.getText()) - igv);
                            parametros.put("igv", igv);
                            parametros.put("entregado", Double.parseDouble(txtMontoRecibido.getText()));
                            parametros.put("vuelto", Double.parseDouble(txtVuelto.getText()));
                            parametros.put("total", Double.parseDouble(lblPago.getText()));
                            //parametros.put("nroSerie", serie);
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\FacturaVentaGeneralT3.jrxml", parametros, getPageSizeFactura());
                            mrv.setNombreArchivo("FacturaVentaGeneralT3");
                            try {
                                mrv.exportarAPdfConCopia();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            mrv.dispose();
                            new VentasControl().restarStock(tblPedidos);
                            panelVuelto.dispose();
                            txtRuc.setText("");
                            txtRazonSocial.setText("");
                            txtDireccion.setText("");
                            txtVuelto.setText("");
                            txtMontoRecibido.setText("");
                            btnFactura.setSelected(false);
                            lblPago.setText("");
                            txtCantidad.setText("");
                            cargarDatos(usuario);
                        } else {
                            //REGISTRO DE TICKET
                            //los tickets deben cambiar de acuerdo a la venta por que las tablas ahora son independientes
                            parametros.put("id_venta", idventa);
                            parametros.put("total", total);
                            parametros.put("nom_cajero", usuario);
                            parametros.put("recibido", Double.parseDouble(txtMontoRecibido.getText()));
                            parametros.put("vuelto", Double.parseDouble(txtVuelto.getText()));
                            parametros.put("nroSerie", nroSerie);
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaVentaT" + numTicket + ".jrxml", parametros, getPageSize());
                            mrv.setNombreArchivo("BoletaVentaT" + numTicket + "");
                            try {
                                mrv.exportarAPdfConCopia();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            mrv.dispose();
                            new VentasControl().restarStock(tblPedidos);
                            panelVuelto.dispose();
                            txtVuelto.setText("");
                            txtMontoRecibido.setText("");
                            lblPago.setText("");
                            txtCantidad.setText("");
                            cargarDatos(usuario);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "NO SE PUEDE REALIZAR LA VENTA");
                }
            } else {
                JOptionPane.showMessageDialog(null, "INGRESE MONTO RECIBIDO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
            if (!txtNumReferencia.getText().trim().isEmpty()) {
                //PRIMERO CAPTURAMOS DATOS PARA REGISTRAR COMPROBANTE
                String fecha = new ManejadorFechas().getFechaActualMySQL();
                String usuario = txtUsuario.getText();
                Double subtotal = Double.parseDouble(lblPago.getText());
                Double total = Double.parseDouble(lblPago.getText());
                //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA                
                Venta v = new Venta();
                v.setFecha(fecha);
                v.setHora(new ManejadorFechas().getHoraActual());
                v.setIdUsuario(new VentasControl().getIdUsuarioConNombre(usuario));//registra el id de usuario que hace la venta
                v.setIdCliente(1);//siempre sera cliente 1 = mrjuerga
                v.setIdTipoComprobante(1);//tipo comprobante 1 = boleta
                v.setEstado(1);//ESTADO->> 0:PENDIENTE     1:PAGADO
                v.setTipopago(tipoPago);//tipo de pago 2 o 3 segun sea visa o mastercard
                v.setnOperacion(txtNumReferencia.getText());//numero de operacion
                v.setIdcaja(new VentasControl().getIdCaja(txtCaja.getText()));//caja que realiza la operacion
                v.setIdFlujoCaja(new FlujoCajaDAO().getIdFlujo(new VentasControl().getIdUsuarioConNombre(usuario), new VentasControl().getIdCaja(txtCaja.getText())));//flujo de caja que realiza la operacion

                VentasControl vc = new VentasControl();
                VentaDAO vdao = new VentaDAO();
                String caja = txtCaja.getText();
                Integer idventa = null;
                Integer flag = null;
                int numTicket = -1;
                switch (caja) {
                    case "GENERAL 1":
                        if (vdao.registrar(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                            numTicket = 1;
                            nroSerie = "003 -";
                            System.out.println("venta registrada");
                            System.out.println("nroSerie: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);
                        }
                        break;
                    case "GENERAL 2":
                        if (vdao.registrar2(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada2();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                            numTicket = 2;
                            nroSerie = "004 -";
                            System.out.println("ventaCaja2 registrada");
                            System.out.println("nroSerie: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);
                        }
                        break;
                    case "VIP":
                        if (vdao.registrar3(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada3();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                            numTicket = 3;
                            nroSerie = "005 -";
                            System.out.println("ventaCaja3 registrada");
                            System.out.println("nroSerie: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);
                        }
                        break;
                }

                System.out.println("ultima venta: " + idventa);
                System.out.println("flag: " + flag);

                //TERCERO REGISTRO LOS DETALLES DE LA VENTA
                if (flag > 0) {
                    JOptionPane.showMessageDialog(null, "VENTA REALIZADA EXITOSAMENTE");

                    switch (tipoPago) {
                        case 1:
                            JOptionPane.showMessageDialog(getRootPane(), "NO SE PUEDE REALIZAR TRANSACCION DE EFECTIVO EN ESTE CASO");
                            break;
                        case 2:
                            parametros.put("id_venta", idventa);
                            parametros.put("nom_cajero", usuario);
                            parametros.put("total", total);
                            parametros.put("nroSerie", nroSerie);
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaMASTERT" + numTicket + ".jrxml", parametros, getPageSize());
                            mrv.setNombreArchivo("BoletaMASTER" + numTicket + "");
                            try {
                                mrv.exportarAPdfConCopia();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            mrv.dispose();
                            new VentasControl().restarStock(tblPedidos);
                            panelPagoElectronico.dispose();
                            lblPago.setText("");
                            txtNumReferencia.setText("");
                            cargarDatos(usuario);

                            break;
                        case 3:
                            parametros.put("id_venta", idventa);
                            parametros.put("nom_cajero", usuario);
                            parametros.put("total", total);
                            parametros.put("nroSerie", nroSerie);
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaVISAT" + numTicket + ".jrxml", parametros, getPageSize());
                            mrv.setNombreArchivo("BoletaVISA" + numTicket + "");
                            try {
                                mrv.exportarAPdfConCopia();
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            mrv.dispose();
                            new VentasControl().restarStock(tblPedidos);
                            panelPagoElectronico.dispose();
                            lblPago.setText("");
                            txtNumReferencia.setText("");
                            cargarDatos(usuario);
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE UN NUMERO DE REFERENCIA");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnCobrarConTarjetaActionPerformed

    private void btnCancelarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTarjetaActionPerformed
        panelPagoElectronico.dispose();
    }//GEN-LAST:event_btnCancelarTarjetaActionPerformed

    private void btnSalirOpCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirOpCombinadaActionPerformed
        operacionCombinada.dispose();
    }//GEN-LAST:event_btnSalirOpCombinadaActionPerformed

    private void btnunoCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnunoCombinadaActionPerformed
        String numero = te.getText() + 1;
        te.setText(numero);
    }//GEN-LAST:event_btnunoCombinadaActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        if (btnFactura.isSelected()) {
            txtRazonSocial.setEnabled(true);
            txtRuc.setEnabled(true);
            txtDireccion.setEnabled(true);
            txtRazonSocial.requestFocus();
        } else {
            txtRazonSocial.setEnabled(false);
            txtRuc.setEnabled(false);
            txtDireccion.setEnabled(false);
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void btnDosCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosCombinadaActionPerformed
        String numero = te.getText() + 2;
        te.setText(numero);
    }//GEN-LAST:event_btnDosCombinadaActionPerformed

    private void btnTresCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresCombinadaActionPerformed
        String numero = te.getText() + 3;
        te.setText(numero);
    }//GEN-LAST:event_btnTresCombinadaActionPerformed

    private void btnCuatroCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroCombinadaActionPerformed
        String numero = te.getText() + 4;
        te.setText(numero);
    }//GEN-LAST:event_btnCuatroCombinadaActionPerformed

    private void btnCincoCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoCombinadaActionPerformed
        String numero = te.getText() + 5;
        te.setText(numero);
    }//GEN-LAST:event_btnCincoCombinadaActionPerformed

    private void btnSeisCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisCombinadaActionPerformed
        String numero = te.getText() + 6;
        te.setText(numero);
    }//GEN-LAST:event_btnSeisCombinadaActionPerformed

    private void btnSieteCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteCombinadaActionPerformed
        String numero = te.getText() + 7;
        te.setText(numero);
    }//GEN-LAST:event_btnSieteCombinadaActionPerformed

    private void btnOchoCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoCombinadaActionPerformed
        String numero = te.getText() + 8;
        te.setText(numero);
    }//GEN-LAST:event_btnOchoCombinadaActionPerformed

    private void btnNueveCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveCombinadaActionPerformed
        String numero = te.getText() + 9;
        te.setText(numero);
    }//GEN-LAST:event_btnNueveCombinadaActionPerformed

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void btnBebidasJarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasJarraActionPerformed
        try {
            complemento = 0;
            String categoria = btnBebidasJarra.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);//2= BARRA GENERAL
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(102, 153, 255));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBebidasJarraActionPerformed

    private void btnCoctelesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoctelesActionPerformed
        try {
            complemento = 0;
            String categoria = btnCocteles.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(102, 102, 255));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCoctelesActionPerformed

    private void btnBebidasPorBotellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasPorBotellaActionPerformed
        try {
            complemento = 1;
            System.out.println("COMPLEMENTO:"+complemento);
            String categoria = btnBebidasPorBotella.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(153, 102, 255));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnBebidasPorBotellaActionPerformed

    private void btnGaseosasCervezasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaseosasCervezasActionPerformed
        try {
            complemento = 0;
            String categoria = btnGaseosasCervezas.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(204, 102, 255));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGaseosasCervezasActionPerformed

    private void btnCigarrillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCigarrillosActionPerformed
        try {
            complemento = 0;
            String categoria = btnCigarrillos.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(255, 51, 51));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCigarrillosActionPerformed

    private void btnOtrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtrosActionPerformed
        try {
            complemento = 0;
            String categoria = btnOtros.getText();
            VentasControl vc = new VentasControl();
            vc.llenarTablaProductos(categoria, tblProductos, 2);
            lblProductos.setText(categoria);
            lblProductos.setForeground(new Color(255, 102, 51));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnOtrosActionPerformed

    private void btnvisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvisaActionPerformed
        try {
            tipoPago = 3;
            System.out.println("tipo de operacion: " + tipoPago);
            int filaPedidos = tblPedidos.getRowCount();
            //System.out.println(filaPedidos);
            if (filaPedidos <= 0) {
                JOptionPane.showMessageDialog(getRootPane(), "AGREGUE PRODUCTOS A LA LISTA DE PEDIDOS");
            } else if (btnFactura.isSelected()) {
                //recibir los tres parametros para la factura
                String razon = txtRazonSocial.getText();
                String ruc = txtRuc.getText();
                String direccion = txtDireccion.getText();
                //registrar cliente
                panelVuelto.setVisible(true);
                panelVuelto.setBounds(580, 100, 460, 950);
            } else {
                //imprimir normalmente la boleta
                panelPagoElectronico.setVisible(true);
                panelPagoElectronico.setBounds(600, 200, 500, 1020);
                lblIconoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa_01.png")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnvisaActionPerformed

    private void btnMastercardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMastercardActionPerformed
        tipoPago = 2;
        System.out.println("tipo de operacion: " + tipoPago);
        int filaPedidos = tblPedidos.getRowCount();
        if (filaPedidos <= 0) {
            JOptionPane.showMessageDialog(getRootPane(), "AGREGUE PRODUCTOS A LA LISTA DE PEDIDOS");
        } else if (btnFactura.isSelected()) {
            //recibir los tres parametros para la factura
            String razon = txtRazonSocial.getText();
            String ruc = txtRuc.getText();
            String direccion = txtDireccion.getText();
            //registrar cliente
            panelVuelto.setVisible(true);
            panelVuelto.setBounds(580, 100, 460, 950);
        } else {
            //imprimir normalmente la boleta
            panelPagoElectronico.setVisible(true);
            panelPagoElectronico.setBounds(600, 200, 500, 1020);
            lblIconoTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mastercard_01.png")));
        }
    }//GEN-LAST:event_btnMastercardActionPerformed

    private void btnOpCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpCombinadaActionPerformed
        if (!lblPago.getText().trim().equals("")) {
            operacionCombinada.setVisible(true);
            operacionCombinada.setBounds(100, 50, 1180, 860);
            titulosOperacionCombinada();
            txtefectivoCombinada.setText(lblPago.getText());
        } else {
            JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "NO HAY PEDIDOS AGREGADOS");
        }
    }//GEN-LAST:event_btnOpCombinadaActionPerformed

    private void btnVisaOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaOPActionPerformed
        lblCuenta.setText("VISA");
    }//GEN-LAST:event_btnVisaOPActionPerformed

    private void btnBorrarCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCombinadaActionPerformed
        te.setText("");
    }//GEN-LAST:event_btnBorrarCombinadaActionPerformed

    private void btnMasterOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterOPActionPerformed
        lblCuenta.setText("MASTERCARD");
    }//GEN-LAST:event_btnMasterOPActionPerformed

    private void btnAgregarOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarOPActionPerformed

        if (lblCuenta.getText().equals("VISA") || lblCuenta.getText().equals("MASTERCARD")) {
            double monto = 0;
            if (!txtNumReferenciaCombinada.getText().trim().isEmpty()) {
                if (!txtMontoCombinada.getText().trim().isEmpty()) {
                    String dataOP[] = {lblCuenta.getText(), txtNumReferenciaCombinada.getText(), txtMontoCombinada.getText()};
                    modeloOP.addRow(dataOP);
                    for (int i = 0; i < tblOp.getRowCount(); i++) {
                        monto += Double.parseDouble(tblOp.getValueAt(i, 2).toString());
                    }
                    txtefectivoCombinada.setText("" + (Double.parseDouble(lblPago.getText()) - monto));
                    txtNumReferenciaCombinada.setText("");
                    txtMontoCombinada.setText("");
                    btnVisaOP.setSelected(false);
                    btnMasterOP.setSelected(false);
                    lblCuenta.setText("::::::::::::::");
                } else {
                    JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "INDIQUE MONTO");
                }
            } else {
                JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "INDIQUE NUMERO DE REFERENCIA");
            }
        } else {
            JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "INDIQUE TIPO DE TARJETA");
        }


    }//GEN-LAST:event_btnAgregarOPActionPerformed

    private void btnQuitarOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarOPActionPerformed
        int fila = tblOp.getSelectedRow();
        double monto = 0;
        if (fila >= 0) {
            modeloOP.removeRow(fila);
            for (int i = 0; i < tblOp.getRowCount(); i++) {
                monto += Double.parseDouble(tblOp.getValueAt(i, 2).toString());
            }
            txtefectivoCombinada.setText("" + (Double.parseDouble(lblPago.getText()) - monto));
        } else {
            JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "SELECCIONE UN ELEMENTO A QUITAR");
        }
    }//GEN-LAST:event_btnQuitarOPActionPerformed

    private void btnCeroCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroCombinadaActionPerformed
        String numero = te.getText() + 0;
        te.setText(numero);
    }//GEN-LAST:event_btnCeroCombinadaActionPerformed

    private void txtCobrarCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCobrarCombinadaActionPerformed
        /*  PAGO CON OPERACION COMBINADA  */
        try {
            //VALIDA SI HAY ELEMENTOS EN LA TABLA
            int fila = tblOp.getRowCount();
            if (fila >= 0) {
                int numTicket = -1;
                String fecha = new ManejadorFechas().getFechaActualMySQL();
                String usuario = txtUsuario.getText();
                //cliente lo pasamos en duro
                //cantidad de que????
                Double subtotal = Double.parseDouble(lblPago.getText());
                //ruc lo pasamos en duro
                String direccion = "JR AYACUCHO 772";
                //tipo de pago lo pasamos en duro hasta normalizar el TIPODEPAGO
                Double total = Double.parseDouble(lblPago.getText());
//                    int idTipoComprobante = 1;

                //SEGUNDO CAPTURAMOS DATOS PARA REGISTRAR VENTA
                Venta v = new Venta();
//                    Object[] datos = new Object[10];
                v.setFecha(fecha);
                v.setHora(new ManejadorFechas().getHoraActual());
                v.setIdUsuario(new VentasControl().getIdUsuarioConNombre(usuario));
                v.setIdCliente(1);
                v.setIdTipoComprobante(1);//BOLETA - TICKET
                v.setEstado(1);//ESTADO->> 0:ANULADO     1:ACTIVO
                v.setTipopago(4);//operacion combinada
                v.setnOperacion("");
                v.setIdcaja(new VentasControl().getIdCaja(txtCaja.getText()));
                v.setIdFlujoCaja(new FlujoCajaDAO().getIdFlujo(new VentasControl().getIdUsuarioConNombre(usuario), new VentasControl().getIdCaja(txtCaja.getText())));

                VentasControl vc = new VentasControl();
                VentaDAO vdao = new VentaDAO();
                String caja = txtCaja.getText();
                Integer idventa = null;
                Integer flag = null;
                switch (caja) {
                    case "GENERAL 1":
                        if (vdao.registrar(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                            numTicket = 1;
                            nroSerie = "003 -";
                            System.out.println("venta registrada");
                            System.out.println("SERIE: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);

                            /*CAPTURA LAS TARJETAS*/
                            OperacionDAO npDAO = new OperacionDAO();
                            for (int i = 0; i < tblOp.getRowCount(); i++) {
                                Operacion op = new Operacion();
                                op.setIdventa(idventa);
                                op.setTarjeta(tblOp.getValueAt(i, 0).toString());
                                op.setNumref(tblOp.getValueAt(i, 1).toString());
                                op.setMonto(Double.parseDouble(tblOp.getValueAt(i, 2).toString()));
                                npDAO.registrar(op);
                            }

                            /* CAPTURA EL MONTO EN EFECTIVO */
                            if (!txtefectivoCombinada.getText().equals("0.0")) {
                                Operacion op = new Operacion();
                                op.setIdventa(idventa);
                                op.setTarjeta("EFECTIVO");
                                op.setNumref("");
                                op.setMonto(Double.parseDouble(txtefectivoCombinada.getText()));
                                npDAO.registrar(op);
                            }

                        }
                        break;
                    case "GENERAL 2":
                        if (vdao.registrar2(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada2();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, Double.parseDouble(txtefectivoCombinada.getText()), num);
                            numTicket = 2;
                            nroSerie = "004 -";
                            System.out.println("ventaCaja2 registrada");
                            System.out.println("SERIE: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);

                            /*CAPTURA LAS TARJETAS*/
                            OperacionDAO2 npDAO2 = new OperacionDAO2();
                            for (int i = 0; i < tblOp.getRowCount(); i++) {
                                Operacion2 op2 = new Operacion2();
                                op2.setIdventa2(idventa);
                                op2.setTarjeta(tblOp.getValueAt(i, 0).toString());
                                op2.setNumref(tblOp.getValueAt(i, 1).toString());
                                op2.setMonto(Double.parseDouble(tblOp.getValueAt(i, 2).toString()));
                                npDAO2.registrar(op2);
                            }

                            /* CAPTURA EL MONTO EN EFECTIVO */
                            if (!txtefectivoCombinada.getText().equals("0.0")) {
                                Operacion2 op2 = new Operacion2();
                                op2.setIdventa2(idventa);
                                op2.setTarjeta("EFECTIVO");
                                op2.setNumref("");
                                op2.setMonto(Double.parseDouble(txtefectivoCombinada.getText()));
                                npDAO2.registrar(op2);
                            }
                        }
                        break;
                    case "VIP":
                        if (vdao.registrar3(v)) {
                            idventa = new VentasControl().getIdDeUltimaVentaRegistrada3();
                            flag = vc.registrarDetalleDeVenta(tblPedidos, idventa, num);
                            numTicket = 3;
                            nroSerie = "005 -";
                            System.out.println("ventaCaja3 registrada");
                            System.out.println("SERIE: " + nroSerie);
                            System.out.println("numero de ticket: " + numTicket);

                            /*CAPTURA LAS TARJETAS*/
                            OperacionDAO3 npDAO3 = new OperacionDAO3();
                            for (int i = 0; i < tblOp.getRowCount(); i++) {
                                Operacion3 op3 = new Operacion3();
                                op3.setIdventa3(idventa);
                                op3.setTarjeta(tblOp.getValueAt(i, 0).toString());
                                op3.setNumref(tblOp.getValueAt(i, 1).toString());
                                op3.setMonto(Double.parseDouble(tblOp.getValueAt(i, 2).toString()));
                                npDAO3.registrar(op3);
                            }

                            /* CAPTURA EL MONTO EN EFECTIVO */
                            if (!txtefectivoCombinada.getText().equals("0.0")) {
                                Operacion3 op3 = new Operacion3();
                                op3.setIdventa3(idventa);
                                op3.setTarjeta("EFECTIVO");
                                op3.setNumref("");
                                op3.setMonto(Double.parseDouble(txtefectivoCombinada.getText()));
                                npDAO3.registrar(op3);
                            }

                        }
                        break;
                }

                System.out.println("ultima venta: " + idventa);
                System.out.println("flag: " + flag);
//                    String serie = null;

                if (flag > 0) {
                    JOptionPane.showMessageDialog(null, "VENTA REALIZADA EXITOSAMENTE");

                    if (btnFactura.isSelected()) {
                        //REGISTRO DE FACTURA
                        parametros.put("id_venta", idventa);
                        parametros.put("raz_social", txtRazonSocial.getText());
                        parametros.put("ruc", txtRuc.getText());
                        parametros.put("direc", txtDireccion.getText());
                        parametros.put("cajero", txtUsuario.getText());
                        double igv = (Double.parseDouble(lblPago.getText()) / 1.18) * 0.18;
                        parametros.put("subtotal", Double.parseDouble(lblPago.getText()) - igv);
                        parametros.put("igv", igv);
                        parametros.put("entregado", Double.parseDouble(txtMontoRecibido.getText()));
                        parametros.put("vuelto", Double.parseDouble(txtVuelto.getText()));
                        parametros.put("total", Double.parseDouble(lblPago.getText()));
                        //parametros.put("nroSerie", serie);
                        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\FacturaVentaGeneralT3.jrxml", parametros, getPageSizeFactura());
                        mrv.setNombreArchivo("FacturaVentaGeneralT3");
                        try {
                            mrv.exportarAPdfConCopia();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        mrv.dispose();
                        new VentasControl().restarStock(tblPedidos);
                        panelVuelto.dispose();
                        txtRuc.setText("");
                        txtRazonSocial.setText("");
                        txtDireccion.setText("");
                        txtVuelto.setText("");
                        txtMontoRecibido.setText("");
                        btnFactura.setSelected(false);
                        lblPago.setText("");
                        txtCantidad.setText("");
                        cargarDatos(usuario);
                    } else {
                        //REGISTRO DE TICKET
                        //los tickets deben cambiar de acuerdo a la venta por que las tablas ahora son independientes
                        parametros.put("id_venta", idventa);
                        parametros.put("total", total);
                        parametros.put("nom_cajero", usuario);
                        parametros.put("nroSerie", nroSerie);
                        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\BoletaOperacionCombinada" + numTicket + ".jrxml", parametros, getPageSize());
                        mrv.setNombreArchivo("BoletaOperacionCombinada" + numTicket + "");
                        try {
                            mrv.exportarAPdfConCopia();
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        mrv.dispose();
                        new VentasControl().restarStock(tblPedidos);
                        operacionCombinada.dispose();
                        lblPago.setText("");
                        txtCantidad.setText("");
                        cargarDatos(usuario);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ERROR EN REGISTRO DE LAS VENTAS");
                }
            } else {
                JOptionPane.showMessageDialog(operacionCombinada.getRootPane(), "NO HAY FORMAS DE PAGO AÑADIDOS");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtCobrarCombinadaActionPerformed

    private void btnPuntoCombinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntoCombinadaActionPerformed
        String numero = te.getText() + ".";
        te.setText(numero);
    }//GEN-LAST:event_btnPuntoCombinadaActionPerformed

    private void sliderCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderCantidadStateChanged
        lblCantidadSlider.setText("" + sliderCantidad.getValue());
    }//GEN-LAST:event_sliderCantidadStateChanged

    private void btnConfirmarComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarComplementoActionPerformed
        if (!txtProductoComplemento.getText().trim().isEmpty()) {
            int idAlmacen = 2;
            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            try {
                int idProd = getIdProductoConNombre(txtProductoComplemento.getText(), idAlmacen);

                Object datos[] = {idProd, txtProductoComplemento.getText(), txtPresentacionComplemento.getText(), 0, lblCantidadSlider.getText(), 0};
                table1.addRow(datos);
                tblPedidos.setModel(table1);
                lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
                tblProductos.clearSelection();
//                listaCategorias.clearSelection();

                tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(20);
                tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(200);
                tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
                tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
                tblPedidos.getColumnModel().getColumn(4).setPreferredWidth(50);
                tblPedidos.getColumnModel().getColumn(5).setPreferredWidth(50);

                sliderCantidad.setValue(1);

                PanelComplementos.dispose();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN COMPLEMENTO PARA LA BEBIDA");
        }
    }//GEN-LAST:event_btnConfirmarComplementoActionPerformed

    private void btnCocaColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCocaColaActionPerformed
        int idProducto = 116;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnCocaColaActionPerformed

    private void btnRedBullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedBullActionPerformed
        int idProducto = 129;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnRedBullActionPerformed

    private void btnGloriaPiñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGloriaPiñaActionPerformed
        int idProducto = 126;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGloriaPiñaActionPerformed

    private void btnGloriaNaranjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGloriaNaranjaActionPerformed
        int idProducto = 124;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGloriaNaranjaActionPerformed

    private void btnGinger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGinger1ActionPerformed
        int idProducto = 119;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGinger1ActionPerformed

    private void btnGuaranaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuaranaActionPerformed
        int idProducto = 120;
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnGuaranaActionPerformed

    private void btnAguaMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAguaMineralActionPerformed
        int idProducto = 106;//463
        try {
            int idAlmacen = 2;

            switch (txtCaja.getText()) {
                case "VIP":
                    idAlmacen = 3;
                    break;
            }

            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto, idAlmacen);

            if (pp.getStock() > 0) {
                Producto prod = new ProductoDAO().obtener(idProducto);

                Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());

                txtProductoComplemento.setText(prod.getNombre());
                txtPresentacionComplemento.setText(p.getDescripcion());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE CUENTA CON LAS UNIDADES DE COMPLEMENTO SELECCIONADO");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAguaMineralActionPerformed

    private void btn3x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3x2ActionPerformed
        //analizar si el producto seleccionado esta en promocion
        int fila = tblProductos.getSelectedRow();
        if (fila >= 0) {
            String nomProd[] = {"CUBA LIBRE CABO BLANCO"};

            String prodSelec = tblProductos.getValueAt(fila, 0).toString();

            int c = 0;

            for (String prod : nomProd) {
                if (prod.equals(prodSelec)) {
                    c++;
                }
            }

            if (c > 0) {
                //JOptionPane.showMessageDialog(getRootPane(), "EL PRODUCTO SI TIENE 3X2");

                try {
                    int opc = 2;
                    switch (txtCaja.getText()) {
                        case "VIP":
                            opc = 3;
                            break;
                    }
                    int cod = getIdProductoConNombre(tblProductos.getValueAt(fila, 0).toString(), opc);
                    String prod = tblProductos.getValueAt(fila, 0).toString();
                    String presentacion = tblProductos.getValueAt(fila, 1).toString();
                    Double prec = Double.parseDouble(tblProductos.getValueAt(fila, 3).toString());
                    System.out.println("precio: " + prec);
                    Double cant = 3.0;
                    System.out.println("cantidad: " + cant);
                    double subtotal = prec * 2;
                    System.out.println("subtotal: " + subtotal);
                    if (cant == 0) {
                        JOptionPane.showMessageDialog(getRootPane(), "EL VALOR 0 NO DISPONE DE OPERACIONES");
                    } else if (Double.parseDouble(tblProductos.getValueAt(fila, 2).toString()) < cant) {
                        JOptionPane.showMessageDialog(getRootPane(), "NO SE CUENTA CON LAS UNIDADES SOLICITADAS");
                    } else {
                        if (complemento > 0) {
                            PanelComplementos.setVisible(true);
                            PanelComplementos.setBounds(300, 100, 924, 824);
                            //905, 814
                        }
                        Object datos[] = {cod, prod, presentacion, prec, cant, subtotal};
                        table1.addRow(datos);
                        tblPedidos.setModel(table1);
                        lblPago.setText("" + new VentasControl().calcularMonto(tblPedidos));
                        tblProductos.clearSelection();
//                listaCategorias.clearSelection();

                        tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(20);
                        tblPedidos.getColumnModel().getColumn(1).setPreferredWidth(300);
                        tblPedidos.getColumnModel().getColumn(2).setPreferredWidth(200);
                        tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
                        tblPedidos.getColumnModel().getColumn(4).setPreferredWidth(50);
                        tblPedidos.getColumnModel().getColumn(5).setPreferredWidth(50);

                        bloquearBotones();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(getRootPane(), "ERROR: EL PRODUCTO NO TIENE SALIDA 3X2");
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE PRODUCTO");
        }


    }//GEN-LAST:event_btn3x2ActionPerformed

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
    private javax.swing.JDialog PanelComplementos;
    private javax.swing.JDialog PanelPromocion;
    public javax.swing.JButton btn0;
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    private javax.swing.JButton btn3x2;
    public javax.swing.JButton btn4;
    public javax.swing.JButton btn5;
    public javax.swing.JButton btn6;
    public javax.swing.JButton btn7;
    public javax.swing.JButton btn8;
    public javax.swing.JButton btn9;
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarOP;
    private javax.swing.JToggleButton btnAguaMineral;
    private javax.swing.JToggleButton btnBebidasJarra;
    private javax.swing.JToggleButton btnBebidasPorBotella;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarCombinada;
    private javax.swing.JButton btnBorrarTarjeta;
    private javax.swing.JButton btnCancelarTarjeta;
    private javax.swing.JButton btnCero;
    private javax.swing.JButton btnCeroCombinada;
    private javax.swing.JButton btnCeroTarjeta;
    private javax.swing.JToggleButton btnCigarrillos;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCincoCombinada;
    private javax.swing.JButton btnCincoTarjeta;
    private javax.swing.JButton btnCobrarConTarjeta;
    private javax.swing.JToggleButton btnCocaCola;
    private javax.swing.JToggleButton btnCocteles;
    private javax.swing.JButton btnConfirmarComplemento;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnCuatroCombinada;
    private javax.swing.JButton btnCuatroTarjeta;
    public javax.swing.JButton btnDel;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnDosCombinada;
    private javax.swing.JButton btnDosTarjeta;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JToggleButton btnFactura;
    private javax.swing.JToggleButton btnGaseosasCervezas;
    private javax.swing.JToggleButton btnGinger1;
    private javax.swing.JToggleButton btnGloriaNaranja;
    private javax.swing.JToggleButton btnGloriaPiña;
    private javax.swing.JToggleButton btnGuarana;
    private javax.swing.JToggleButton btnMasterOP;
    private javax.swing.JButton btnMastercard;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnNueveCombinada;
    private javax.swing.JButton btnNueveTarjeta;
    private javax.swing.JButton btnOcho;
    private javax.swing.JButton btnOchoCombinada;
    private javax.swing.JButton btnOchoTarjeta;
    private javax.swing.JButton btnOpCombinada;
    private javax.swing.JToggleButton btnOtros;
    private javax.swing.JButton btnPendientes;
    private javax.swing.JButton btnPunto;
    private javax.swing.JButton btnPuntoCombinada;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarOP;
    private javax.swing.JButton btnRealizarVenta;
    private javax.swing.JToggleButton btnRedBull;
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
    private javax.swing.JToggleButton btnVisaOP;
    private javax.swing.JButton btnunoCombinada;
    private javax.swing.JButton btnvisa;
    private javax.swing.JCheckBox cboxMasVendidos;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel fondo2;
    private javax.swing.ButtonGroup grupoCategorias;
    private javax.swing.ButtonGroup grupoVisaMaster;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblCantidadSlider;
    private javax.swing.JLabel lblCuenta;
    private javax.swing.JLabel lblIconoTarjeta;
    private javax.swing.JLabel lblPago;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JDialog operacionCombinada;
    private javax.swing.JDialog panelPagoElectronico;
    private javax.swing.JDialog panelVuelto;
    private javax.swing.JScrollPane scrollProductos;
    private javax.swing.JSlider sliderCantidad;
    private javax.swing.JLabel tablet;
    private javax.swing.JTable tblOp;
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
    private javax.swing.JTextField txtPresentacionComplemento;
    private javax.swing.JTextField txtProductoComplemento;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVuelto;
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

    //metodo para cargar los productos mas vendidos caja 01
    public void tablaProductosMasVendidos(int idFlujoCaja) throws Exception {
        titulosMasVendidos();
        Conexion con = new Conexion();
        Object[] lista = new Object[5];
        try {
            con.conectar();
            Connection cc = con.getConexion();
            PreparedStatement pst = cc.prepareStatement("select producto.nombre,presentacion.descripcion,productopresentacion.stock,productopresentacion.precio, sum(ventaproducto.cantidad) \n"
                    + "from ventaproducto \n"
                    + "inner join producto on ventaproducto.idproducto = producto.idproducto \n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join venta on ventaproducto.idventa = venta.idventa\n"
                    + "where venta.idflujocaja = " + idFlujoCaja + " AND productopresentacion.idalmacen=2 \n"
                    + "group by producto.nombre\n"
                    + "order by sum(ventaproducto.cantidad) desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista[0] = rs.getString(1);
                lista[1] = rs.getString(2);
                lista[2] = rs.getString(3);
                lista[3] = rs.getString(4);
                lista[4] = rs.getString(5);
                modeloMasVendidos.addRow(lista);
            }
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblProductos.setModel(modeloMasVendidos);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //metodo para cargar los productos mas vendidos de ventas 2
    public void tablaProductosMasVendidos2(int idFlujoCaja) throws Exception {
        titulosMasVendidos();
        Conexion con = new Conexion();
        Object[] lista = new Object[5];
        try {
            con.conectar();
            Connection cc = con.getConexion();
            PreparedStatement pst = cc.prepareStatement("select producto.nombre,presentacion.descripcion,productopresentacion.stock,productopresentacion.precio, sum(ventaproducto2.cantidad) \n"
                    + "from ventaproducto2 \n"
                    + "inner join producto on ventaproducto2.idproducto = producto.idproducto \n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join venta2 on ventaproducto2.idventa = venta2.idventa2\n"
                    + "where venta2.idflujocaja = " + idFlujoCaja + " AND productopresentacion.idalmacen=2 \n"
                    + "group by producto.nombre\n"
                    + "order by sum(ventaproducto2.cantidad) desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista[0] = rs.getString(1);
                lista[1] = rs.getString(2);
                lista[2] = rs.getString(3);
                lista[3] = rs.getString(4);
                lista[4] = rs.getString(5);
                modeloMasVendidos.addRow(lista);
            }
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblProductos.setModel(modeloMasVendidos);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //metodo para cargar los productos mas vendidos de ventas 3
    public void tablaProductosMasVendidos3(int idFlujoCaja) throws Exception {
        titulosMasVendidos();
        Conexion con = new Conexion();
        Object[] lista = new Object[5];
        try {
            con.conectar();
            Connection cc = con.getConexion();
            PreparedStatement pst = cc.prepareStatement("select producto.nombre,presentacion.descripcion,productopresentacion.stock,productopresentacion.precio, sum(ventaproducto3.cantidad) \n"
                    + "from ventaproducto3 \n"
                    + "inner join producto on ventaproducto3.idproducto = producto.idproducto \n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join venta3 on ventaproducto3.idventa = venta3.idventa3\n"
                    + "where venta3.idflujocaja = " + idFlujoCaja + " AND productopresentacion.idalmacen=3 \n"
                    + "group by producto.nombre\n"
                    + "order by sum(ventaproducto3.cantidad) desc");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                lista[0] = rs.getString(1);
                lista[1] = rs.getString(2);
                lista[2] = rs.getString(3);
                lista[3] = rs.getString(4);
                lista[4] = rs.getString(5);
                modeloMasVendidos.addRow(lista);
            }
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(300);
            tblProductos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(4).setPreferredWidth(50);
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
        int fontSize = 9;//TAMAÑO DE LETRA DEL DETAIL
        int rowSize = fontSize + 2;//TAMAÑO DE LA FILA
        int caracteresPorLinea = 14;// CANTIDAD DE CARACTERES PARA QUE PASE A LA SIGTE LINEA
        for (int i = 0; i < filas; i++) {
            String descripcionDeProducto = tblPedidos.getValueAt(i, 1).toString();
            rowCount += (1 + (int) (descripcionDeProducto.length() / caracteresPorLinea));
        }
        int cabecera = 170;
        int piePagina = 75;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finales:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }

    //METODO PARA LOS TAMAÑOS DE LA IMPRESION
    private int getPageSizeFactura() {
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
        int cabecera = 220;
        int piePagina = 117;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finales:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }

    /* CARGAR TITULOS DE TABLA operacion combinada */
    public void titulosOperacionCombinada() {
        String cabecera[] = {"TARJETA", "NUM-REF", "MONTO"};
        modeloOP = new DefaultTableModel(null, cabecera);
        tblOp.setModel(modeloOP);
    }

    private int getIdProductoConNombre(String producto, int almacen) throws SQLException {
        Conexion con = new Conexion();
        String sql = "SELECT productopresentacion.idproductopresentacion FROM\n"
                + "producto\n"
                + "INNER JOIN productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                + "WHERE producto.nombre = '" + producto + "' AND productopresentacion.idalmacen = " + almacen;
        try {
            con.conectar();
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return res.getInt(1);
            }

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
        return -1;
    }

    private void LimpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }
}
