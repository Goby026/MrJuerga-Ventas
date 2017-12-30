/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AbrirCajaControl;
import Controlador.CerrarCajaControl;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.Redondear;
import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import Modelo.UsuarioGastosDAO;
import java.awt.Color;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * Grøver R£ndiÇh
 */
public class CerrarCaja extends javax.swing.JFrame {

    MyiReportVisor mrv, mrv2;
    HashMap parametros = new HashMap();
    HashMap parametros2 = new HashMap();
    int numCaja = 1;
    String usuario;
    double jarras = 0.0;

    public CerrarCaja(String usuario) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        datosIniciales(usuario);
        this.usuario = usuario;
    }

    public CerrarCaja() {
    }

    public void datosIniciales(String usuario) throws Exception {
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        lblCaja.setText(new AbrirCajaControl().getCajaDeUsuario(usuario));
        lblUsuario.setText(usuario);
        switch (lblCaja.getText()) {
            case "GENERAL 1":
                numCaja = 1;
                break;
            case "GENERAL 2":
                numCaja = 2;
                break;
            case "VIP":
                numCaja = 3;
                break;
            default:
                break;
        }
        if (new AbrirCajaControl().verificarEstadoCaja(usuario) > 0) {
            lblEstado.setText("CAJA APERTURADA");
            lblEstado.setForeground(Color.blue);
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            txtMontoApertura.setText("" + new CerrarCajaControl().getSaldoInicial(idFlujoCaja));
            /* VENTAS Y OPERACIONES COMBINADAS REALES */
            double visa = ((new FlujoCajaDAO().getMontoVISA(idFlujoCaja, numCaja)) + (new FlujoCajaDAO().getMontosOpReales(1, idFlujoCaja, numCaja)));
            double master = ((new FlujoCajaDAO().getMontoMASTER(idFlujoCaja, numCaja)) + (new FlujoCajaDAO().getMontosOpReales(2, idFlujoCaja, numCaja)));
            double efectivo = (((new CerrarCajaControl().getMontoVentas(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()), numCaja))) + (new FlujoCajaDAO().getMontosOpReales(3, idFlujoCaja, numCaja)));
            txtVisa.setText("" + visa);//getMontosOP(1,xxx) 1=VISA - operaciones combinadas VENTAS
            txtMaster.setText("" + master);//getMontosOP(1,xxx) 2=MASTERCARD
            txtEfectivo.setText("" + efectivo);//getMontosOP(1,xxx) 3=EFECTIVO                        

            //NOTAS DE PEDIDO Y OPERACIONES COMBINADAS
            double visaNp = new FlujoCajaDAO().getMontosNotaPedido(1, idFlujoCaja, numCaja);
            double masterNp = new FlujoCajaDAO().getMontosNotaPedido(2, idFlujoCaja, numCaja);
            double efectivoNp = new FlujoCajaDAO().getMontosNotaPedido(3, idFlujoCaja, numCaja);
            double visaNpOp = new FlujoCajaDAO().getMontosOPNotaPedido(1, idFlujoCaja, numCaja);
            double masterNpOp = new FlujoCajaDAO().getMontosOPNotaPedido(2, idFlujoCaja, numCaja);
            double efectivoNpOp = new FlujoCajaDAO().getMontosOPNotaPedido(3, idFlujoCaja, numCaja);
            txtVisaNotaPedido.setText("" + (visaNp + visaNpOp));
            txtMasterNotaPedido.setText("" + (masterNp + masterNpOp));
            txtEfectivoNotaPedido.setText("" + (efectivoNp + efectivoNpOp));

            txtEgresos.setText("" + new UsuarioGastosDAO().getMontoEgresos(idFlujoCaja));
            //txtTotalIngresos.setText("" + ((efectivo) - (visa + master)));
            //txtTotalNotaPedido.setText("" + ((efectivoNp + efectivoNpOp) - (visaNp + visaNpOp + masterNp + masterNpOp)));

            txtBalance.setText("" + TotalSistema());
        } else {
            lblEstado.setText("CAJA CERRADA");
        }
    }

//    public double calcularBalanceTotal(int idFlujoCaja) throws Exception {
//        double saldoInicial = Double.parseDouble(txtMontoApertura.getText()), visa = Double.parseDouble(txtVisa.getText()), mastercard = Double.parseDouble(txtMaster.getText()), efectivo = Double.parseDouble(txtEfectivo.getText()), egresos = Double.parseDouble(txtEgresos.getText()), jarras = Double.parseDouble(txtJarras.getText());
//        double notasPedido = new FlujoCajaDAO().getMontoNotaPedido(idFlujoCaja);
//        return (efectivo + jarras + notasPedido) - (visa + mastercard + egresos);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NumericJarras = new javax.swing.JDialog();
        txtMontoJarras = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jarraCalcular = new javax.swing.JButton();
        jarraSiete = new javax.swing.JButton();
        jarraOcho = new javax.swing.JButton();
        jarraNueve = new javax.swing.JButton();
        jarraCuatro = new javax.swing.JButton();
        jarraCinco = new javax.swing.JButton();
        jarraSeis = new javax.swing.JButton();
        jarraUno = new javax.swing.JButton();
        jarraDos = new javax.swing.JButton();
        jarraTres = new javax.swing.JButton();
        jarraCero = new javax.swing.JButton();
        jarraBorrar = new javax.swing.JButton();
        jarraPunto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtVisa = new javax.swing.JTextField();
        txtMontoApertura = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtEfectivo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMaster = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtSaldoContabilizado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblDescuadre = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnCerrarCaja = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnResumen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        btnListaDeVentas = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnVentasProductos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtEgresos = new javax.swing.JTextField();
        btnNotasPedidoProducto = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtEfectivoNotaPedido = new javax.swing.JTextField();
        txtMasterNotaPedido = new javax.swing.JTextField();
        txtVisaNotaPedido = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtJarras = new javax.swing.JTextField();
        btnMontoJarras = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnListaDeVentas1 = new javax.swing.JButton();

        NumericJarras.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMontoJarras.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMontoJarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NumericJarras.getContentPane().add(txtMontoJarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 40));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("MONTO DE JARRAS");
        NumericJarras.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, -1));

        jarraCalcular.setBackground(new java.awt.Color(51, 153, 0));
        jarraCalcular.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCalcular.setForeground(new java.awt.Color(255, 255, 255));
        jarraCalcular.setText("ACEPTAR");
        jarraCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCalcularActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 230, 60));

        jarraSiete.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraSiete.setText("7");
        jarraSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraSieteActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraSiete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 60));

        jarraOcho.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraOcho.setText("8");
        jarraOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraOchoActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraOcho, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, 60));

        jarraNueve.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraNueve.setText("9");
        jarraNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraNueveActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraNueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 70, 60));

        jarraCuatro.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCuatro.setText("4");
        jarraCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCuatroActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 60));

        jarraCinco.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCinco.setText("5");
        jarraCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCincoActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 70, 60));

        jarraSeis.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraSeis.setText("6");
        jarraSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraSeisActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraSeis, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 60));

        jarraUno.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraUno.setText("1");
        jarraUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraUnoActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 60));

        jarraDos.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraDos.setText("2");
        jarraDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraDosActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 70, 60));

        jarraTres.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraTres.setText("3");
        jarraTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraTresActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 70, 60));

        jarraCero.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCero.setText("0");
        jarraCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCeroActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 60));

        jarraBorrar.setBackground(new java.awt.Color(255, 51, 51));
        jarraBorrar.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jarraBorrar.setText("<");
        jarraBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraBorrarActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, 60));

        jarraPunto.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraPunto.setText(".");
        jarraPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraPuntoActionPerformed(evt);
            }
        });
        NumericJarras.getContentPane().add(jarraPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 70, 60));

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtVisa.setEditable(false);
        txtVisa.setBackground(new java.awt.Color(255, 153, 153));
        txtVisa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtVisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 120, -1));

        txtMontoApertura.setEditable(false);
        txtMontoApertura.setBackground(new java.awt.Color(102, 255, 102));
        txtMontoApertura.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMontoApertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtMontoApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 120, -1));

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("MASTERCARD");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 180, -1));

        txtEfectivo.setEditable(false);
        txtEfectivo.setBackground(new java.awt.Color(102, 255, 102));
        txtEfectivo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEfectivo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 120, -1));

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("EFECTIVO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 180, -1));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("VISA");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, -1));

        txtMaster.setEditable(false);
        txtMaster.setBackground(new java.awt.Color(255, 153, 153));
        txtMaster.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaster.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtMaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 120, -1));

        jLabel34.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("SALDO INICIAL");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 410, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 430, 240));

        txtSaldoContabilizado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSaldoContabilizado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtSaldoContabilizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 230, 40));

        jLabel14.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("TOTAL MONTO SISTEMA");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 530, -1, -1));

        lblDescuadre.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        lblDescuadre.setForeground(new java.awt.Color(204, 0, 0));
        lblDescuadre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblDescuadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 580, 180, 40));

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("DESCUADRE");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 590, 180, -1));

        btnCerrarCaja.setBackground(new java.awt.Color(0, 102, 255));
        btnCerrarCaja.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        btnCerrarCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 870, 260, 70));

        jLabel32.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("ESTADO CAJA:");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 990, 120, -1));

        lblEstado.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblEstado.setText("________________");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 990, 200, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("SALDO CONTABILIZADO");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 230, -1));

        txtBalance.setEditable(false);
        txtBalance.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        txtBalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, 180, -1));

        btnCalcular.setBackground(new java.awt.Color(51, 153, 0));
        btnCalcular.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 880, 230, 60));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, 180, 20));

        btnResumen.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnResumen.setText("RESUMEN");
        btnResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenActionPerformed(evt);
            }
        });
        getContentPane().add(btnResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 820, 260, 40));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("CAJA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 990, 50, -1));

        lblCaja.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblCaja.setText("____________");
        getContentPane().add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 990, 200, -1));

        btnListaDeVentas.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnListaDeVentas.setText("DETALLE DE VENTAS");
        btnListaDeVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaDeVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, 260, 40));

        jButton3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton3.setText("7");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 70, 60));

        jButton4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton4.setText("8");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 70, 60));

        jButton5.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton5.setText("9");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 70, 60));

        jButton6.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton6.setText("4");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 70, 60));

        jButton7.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton7.setText("5");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, 70, 60));

        jButton8.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton8.setText("6");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 670, 70, 60));

        jButton9.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton9.setText("1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 740, 70, 60));

        jButton10.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton10.setText("2");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 740, 70, 60));

        jButton11.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton11.setText("3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 740, 70, 60));

        jButton12.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton12.setText("0");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, 70, 60));

        jButton13.setBackground(new java.awt.Color(255, 51, 51));
        jButton13.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("<");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 810, 70, 60));

        jButton14.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jButton14.setText(".");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 810, 70, 60));

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CIERRE DE CAJA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblFecha.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("_______________");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 140, -1));

        jLabel31.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("USUARIO:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 120, -1));

        jLabel36.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel36.setText("FECHA:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 120, -1));

        lblUsuario.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("_______________");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 110));

        btnVentasProductos.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnVentasProductos.setText("VENTAS POR PRODUCTO");
        btnVentasProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasProductosActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentasProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 770, 260, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GASTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("EGRESOS");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 100, -1));

        txtEgresos.setEditable(false);
        txtEgresos.setBackground(new java.awt.Color(255, 153, 153));
        txtEgresos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEgresos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtEgresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 120, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 390, 70));

        btnNotasPedidoProducto.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnNotasPedidoProducto.setText("NOTAS DE PEDIDO PRODUCTO");
        btnNotasPedidoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotasPedidoProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNotasPedidoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 770, 260, 40));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOTAS DE PEDIDO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 11))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("VISA");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 180, -1));

        jLabel19.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("MASTERCARD");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, -1));

        jLabel20.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("EFECTIVO");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, -1));

        txtEfectivoNotaPedido.setEditable(false);
        txtEfectivoNotaPedido.setBackground(new java.awt.Color(102, 255, 102));
        txtEfectivoNotaPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtEfectivoNotaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtEfectivoNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 120, -1));

        txtMasterNotaPedido.setEditable(false);
        txtMasterNotaPedido.setBackground(new java.awt.Color(255, 153, 153));
        txtMasterNotaPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMasterNotaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtMasterNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 120, -1));

        txtVisaNotaPedido.setEditable(false);
        txtVisaNotaPedido.setBackground(new java.awt.Color(255, 153, 153));
        txtVisaNotaPedido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtVisaNotaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel4.add(txtVisaNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 120, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 390, 160));

        jLabel30.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel30.setText("INGRESO POR JARRAS");
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 440, -1, -1));

        txtJarras.setEditable(false);
        txtJarras.setBackground(new java.awt.Color(102, 255, 102));
        txtJarras.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        txtJarras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJarras.setText("0.0");
        txtJarras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJarrasKeyReleased(evt);
            }
        });
        getContentPane().add(txtJarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 440, 110, 30));

        btnMontoJarras.setText("MONTO");
        btnMontoJarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMontoJarrasActionPerformed(evt);
            }
        });
        getContentPane().add(btnMontoJarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 110, 30));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 980, 850, -1));

        btnListaDeVentas1.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        btnListaDeVentas1.setText("DETALLE NOTA DE PEDIDO");
        btnListaDeVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaDeVentas1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaDeVentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 720, 260, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        try {
            int opc = JOptionPane.showConfirmDialog(null, "¿CERRAR CAJA?");
            if (opc == 0) {
                if (!lblDescuadre.getText().trim().isEmpty()) {
                    FlujoCaja fc = new FlujoCaja();
                    fc.setFechaFinal(new ManejadorFechas().getFechaActualMySQL());
                    fc.setHoraFinal(new ManejadorFechas().getHoraActual());
                    fc.setIngresos(Double.parseDouble(txtBalance.getText()));
                    fc.setEgresos(Double.parseDouble(txtEgresos.getText()));
                    fc.setSaldo(Double.parseDouble(txtMontoApertura.getText()));
                    fc.setVisa(Double.parseDouble(txtVisa.getText()));
                    fc.setMaster(Double.parseDouble(txtMaster.getText()));
                    fc.setJarras(Double.parseDouble(txtJarras.getText()));
                    fc.setDescuadre(Double.parseDouble(lblDescuadre.getText()));
                    fc.setEstado("0");

                    if (new CerrarCajaControl().cerrarCaja(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()), fc)) {
                        JOptionPane.showMessageDialog(null, "SE CERRO LA CAJA CORRECTAMENTE");
                        datosIniciales(lblUsuario.getText());
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR AL CERRAR LA CAJA");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "INDIQUE MONTO CONTABILIZADO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        double balance = Double.parseDouble(txtBalance.getText());
        double saldoContado = Double.parseDouble(txtSaldoContabilizado.getText());
        double descuadre = Math.round(saldoContado - balance);
        if (descuadre > 0) {
            lblDescuadre.setForeground(Color.blue);
            lblDescuadre.setText("" + descuadre);
        } else {
            lblDescuadre.setForeground(Color.red);
            lblDescuadre.setText("" + descuadre);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenActionPerformed
        try {
            if (!lblDescuadre.getText().trim().isEmpty()) {
                int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));

                double v = Double.parseDouble(txtVisa.getText()) + Double.parseDouble(txtVisaNotaPedido.getText());
                double m = Double.parseDouble(txtMaster.getText()) + Double.parseDouble(txtMasterNotaPedido.getText());

                parametros.put("flujo", idFlujoCaja);
                parametros.put("usuario", lblUsuario.getText());
                parametros.put("nombres", new CerrarCajaControl().getNombreUsuario(lblUsuario.getText()));
                parametros.put("apellidos", new CerrarCajaControl().getApellidoUsuario(lblUsuario.getText()));
                parametros.put("caja", lblCaja.getText());
                parametros.put("visa", v);
                parametros.put("master", m);
                parametros.put("efectivo", txtBalance.getText());
                parametros.put("jarras", Double.parseDouble(txtJarras.getText()));
                parametros.put("egresos", txtEgresos.getText());
                parametros.put("balance", txtBalance.getText());
                parametros.put("descuadre", lblDescuadre.getText());
                parametros.put("contado", Double.parseDouble(txtSaldoContabilizado.getText()));
                parametros.put("np", Double.parseDouble(txtEfectivoNotaPedido.getText()));
                parametros.put("v", Double.parseDouble(txtEfectivo.getText()));

                mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenVentas" + numCaja + ".jrxml", parametros);
                mrv.exportarAPdf();
            } else {
                JOptionPane.showMessageDialog(null, "DEBE CALCULAR EL DESCUADRE FINAL, POR FAVOR INGRESE EL MONTO CONTABILIZADO");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnResumenActionPerformed

    private void btnListaDeVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeVentasActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));            
            parametros.put("flujo", idFlujoCaja);
            parametros.put("usuario", lblUsuario.getText());
            parametros.put("caja", lblCaja.getText());
            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ListaVentas" + numCaja + ".jrxml", parametros);
            mrv.exportarAPdf();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnListaDeVentasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 7;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 8;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 9;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 4;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 5;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 6;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 1;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 2;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 3;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String numero = txtSaldoContabilizado.getText() + 0;
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        txtSaldoContabilizado.setText("");
        lblDescuadre.setText("");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String numero = txtSaldoContabilizado.getText() + ".";
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnVentasProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasProductosActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            parametros.put("idflujo", idFlujoCaja);
            parametros.put("usuario", lblUsuario.getText());
            parametros.put("caja", lblCaja.getText());
            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenProductosVendidos" + numCaja + ".jrxml", parametros);
            //parametros2.put("idflujo", idFlujoCaja);
            //mrv2 = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\notasdePedido.jrxml", parametros2);

            mrv.exportarAPdf();
            //mrv2.exportarAPdf();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnVentasProductosActionPerformed

    private void txtJarrasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJarrasKeyReleased

    }//GEN-LAST:event_txtJarrasKeyReleased

    private void jarraCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCalcularActionPerformed
//        try {
//            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
//            txtEfectivo.setText("" + ((new CerrarCajaControl().getMontoVentas(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()), numCaja))+(new FlujoCajaDAO().getMontosOpReales(3, idFlujoCaja,numCaja))));            
//            if (!txtMontoJarras.getText().trim().isEmpty()) {
//                Double efectivo = Double.parseDouble(txtEfectivo.getText());
//                txtJarras.setText(txtMontoJarras.getText());
//                txtBalance.setText("" + calcularBalanceTotal(idFlujoCaja));
//                txtEfectivo.setText("" + (efectivo + Double.parseDouble(txtJarras.getText())));
//                txtMontoJarras.setText("");
//                NumericJarras.dispose();
//            } else {
//                txtJarras.setText("0.0");
//                txtEfectivo.setText("" + new CerrarCajaControl().getMontoVentas(new CerrarCajaControl().getIdUsuario(txtUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()), numCaja));
//                txtBalance.setText("" + calcularBalanceTotal(idFlujoCaja));
//                NumericJarras.dispose();
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(CerrarCaja.class.getName()).log(Level.SEVERE, null, ex);
//        }
        txtJarras.setText(txtMontoJarras.getText());
        lblDescuadre.setText(usuario);
        NumericJarras.dispose();
        txtBalance.setText("" + TotalSistema());

        //txtBalance.setText(""+(ingresos-egresos));
    }//GEN-LAST:event_jarraCalcularActionPerformed

    private void jarraSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraSieteActionPerformed
        String numero = txtMontoJarras.getText() + 7;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraSieteActionPerformed

    private void jarraOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraOchoActionPerformed
        String numero = txtMontoJarras.getText() + 8;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraOchoActionPerformed

    private void jarraNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraNueveActionPerformed
        String numero = txtMontoJarras.getText() + 9;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraNueveActionPerformed

    private void jarraCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCuatroActionPerformed
        String numero = txtMontoJarras.getText() + 4;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraCuatroActionPerformed

    private void jarraCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCincoActionPerformed
        String numero = txtMontoJarras.getText() + 5;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraCincoActionPerformed

    private void jarraSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraSeisActionPerformed
        String numero = txtMontoJarras.getText() + 6;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraSeisActionPerformed

    private void jarraUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraUnoActionPerformed
        String numero = txtMontoJarras.getText() + 1;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraUnoActionPerformed

    private void jarraDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraDosActionPerformed
        String numero = txtMontoJarras.getText() + 2;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraDosActionPerformed

    private void jarraTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraTresActionPerformed
        String numero = txtMontoJarras.getText() + 3;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraTresActionPerformed

    private void jarraCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCeroActionPerformed
        String numero = txtMontoJarras.getText() + 0;
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraCeroActionPerformed

    private void jarraBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraBorrarActionPerformed
        txtMontoJarras.setText("");
    }//GEN-LAST:event_jarraBorrarActionPerformed

    private void jarraPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraPuntoActionPerformed
        String numero = txtMontoJarras.getText() + ".";
        txtMontoJarras.setText(numero);
        jarras = Double.parseDouble(txtMontoJarras.getText());
    }//GEN-LAST:event_jarraPuntoActionPerformed

    private void btnMontoJarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMontoJarrasActionPerformed
        NumericJarras.setVisible(true);
        NumericJarras.setBounds(200, 200, 300, 550);
        lblDescuadre.setText("");
        txtSaldoContabilizado.setText("");
    }//GEN-LAST:event_btnMontoJarrasActionPerformed

    private void btnNotasPedidoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotasPedidoProductoActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            parametros.put("idflujo", idFlujoCaja);
            parametros.put("usuario", lblUsuario.getText());
            parametros.put("caja", lblCaja.getText());

            switch (numCaja) {
                case 1:
                    mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenProductosNotaPedido.jrxml", parametros);
                    break;
                case 2:
                    mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenProductosNotaPedido2.jrxml", parametros);
                    break;
                case 3:
                    mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenProductosNotaPedido3.jrxml", parametros);
                    break;
            }

            mrv.exportarAPdf();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnNotasPedidoProductoActionPerformed

    private void btnListaDeVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaDeVentas1ActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(lblUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));            
            parametros.put("flujo", idFlujoCaja);
            parametros.put("usuario", lblUsuario.getText());
            parametros.put("caja", lblCaja.getText());
            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ListaNotaPedido" + numCaja + ".jrxml", parametros);
            mrv.exportarAPdf();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnListaDeVentas1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CerrarCaja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog NumericJarras;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnListaDeVentas;
    private javax.swing.JButton btnListaDeVentas1;
    private javax.swing.JButton btnMontoJarras;
    private javax.swing.JButton btnNotasPedidoProducto;
    private javax.swing.JButton btnResumen;
    private javax.swing.JButton btnVentasProductos;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jarraBorrar;
    private javax.swing.JButton jarraCalcular;
    private javax.swing.JButton jarraCero;
    private javax.swing.JButton jarraCinco;
    private javax.swing.JButton jarraCuatro;
    private javax.swing.JButton jarraDos;
    private javax.swing.JButton jarraNueve;
    private javax.swing.JButton jarraOcho;
    private javax.swing.JButton jarraPunto;
    private javax.swing.JButton jarraSeis;
    private javax.swing.JButton jarraSiete;
    private javax.swing.JButton jarraTres;
    private javax.swing.JButton jarraUno;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblDescuadre;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtEfectivoNotaPedido;
    private javax.swing.JTextField txtEgresos;
    private javax.swing.JTextField txtJarras;
    private javax.swing.JTextField txtMaster;
    private javax.swing.JTextField txtMasterNotaPedido;
    private javax.swing.JTextField txtMontoApertura;
    private javax.swing.JTextField txtMontoJarras;
    private javax.swing.JTextField txtSaldoContabilizado;
    private javax.swing.JTextField txtVisa;
    private javax.swing.JTextField txtVisaNotaPedido;
    // End of variables declaration//GEN-END:variables

    private BigDecimal TotalSistema() {
        //double montoInicial = Double.parseDouble(txtMontoApertura.getText());
        double totalIngresos = Double.parseDouble(txtEfectivo.getText());
        double totalNotaPedido = Double.parseDouble(txtEfectivoNotaPedido.getText());
        double jarras = Double.parseDouble(txtJarras.getText());

        double ingresos = totalIngresos + totalNotaPedido + jarras;

        double egresos = Double.parseDouble(txtEgresos.getText());

        return new Redondear().Redondear2Digitos(ingresos - egresos);

    }

}
