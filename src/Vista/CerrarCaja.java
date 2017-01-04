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
import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Marce
 */
public class CerrarCaja extends javax.swing.JFrame {

    MyiReportVisor mrv;
    HashMap parametros = new HashMap();

    public CerrarCaja(String usuario) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        datosIniciales(usuario);
    }

    public CerrarCaja() {
    }

    public void datosIniciales(String usuario) throws Exception {
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        lblCaja.setText(new AbrirCajaControl().getCajaDeUsuario(usuario));
        txtUsuario.setText(usuario);
        if (new AbrirCajaControl().verificarEstadoCaja(usuario) > 0) {
            lblEstado.setText("CAJA APERTURADA");
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            txtMontoApertura.setText("" + new CerrarCajaControl().getSaldoInicial(idFlujoCaja));
            txtTarjetas.setText("" + new CerrarCajaControl().getMontoTarjetas(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText())));
            txtVentas.setText("" + new CerrarCajaControl().getMontoVentas(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText())));
            txtBalance.setText("" + calcularBalanceTotal());
        } else {
            lblEstado.setText("CAJA CERRADA");
        }
    }

    public double calcularBalanceTotal() {
        double saldoInicial = Double.parseDouble(txtMontoApertura.getText()), tarjetas = Double.parseDouble(txtTarjetas.getText()), ventas = Double.parseDouble(txtVentas.getText());
        return saldoInicial + tarjetas + ventas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTarjetas = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtMontoApertura = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVentas = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtSaldoContabilizado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        lblDescuadre = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnCerrarCaja = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        txtUsuario = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("INGRESOS"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("EGRESOS");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        txtTarjetas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTarjetas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 120, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel30.setText("SALDO INICIAL");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        txtMontoApertura.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMontoApertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtMontoApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 120, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("TARJETAS");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        txtVentas.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 120, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("VENTAS");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 420, 220));

        txtSaldoContabilizado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSaldoContabilizado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtSaldoContabilizado, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 230, 40));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("BALANCE TOTAL");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        lblDescuadre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblDescuadre.setForeground(new java.awt.Color(204, 0, 0));
        lblDescuadre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblDescuadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 120, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("DESCUADRE");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        btnCerrarCaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 220, -1));

        lblFecha.setText("____________");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel31.setText("FECHA:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel32.setText("ESTADO CAJA:");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        lblEstado.setText("________________");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 100, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel33.setText("SALDO CONTABILIZADO");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        txtBalance.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBalance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 120, -1));

        btnCalcular.setBackground(new java.awt.Color(51, 153, 0));
        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCalcular.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcular.setText("CALCULAR");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 470, 230, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 120, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("RESUMEN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 190, -1));

        jLabel1.setText("CAJA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        lblCaja.setText("____________");
        getContentPane().add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("LISTA DE VENTAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 190, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("7");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 70, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("8");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 70, 60));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("9");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 70, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("4");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 70, 60));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setText("5");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 70, 60));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setText("6");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 70, 60));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setText("1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 70, 60));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setText("2");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 70, 60));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton11.setText("3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 70, 60));

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton12.setText("0");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 70, 60));

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton13.setText("<");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 70, 60));

        txtUsuario.setEditable(false);
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        txtUsuario.setEnabled(false);
        txtUsuario.setFocusable(false);
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 230, -1));

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton14.setText(".");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 400, 70, 60));

        jLabel2.setText("alerta de cierre de caja");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 560, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        try {
            int opc = JOptionPane.showConfirmDialog(null, "¿CERRAR CAJA?");
            if (opc == 0) {
                FlujoCaja fc = new FlujoCaja();
                fc.setFechaFinal(new ManejadorFechas().getFechaActualMySQL());
                fc.setHoraFinal(new ManejadorFechas().getHoraActual());
                fc.setIngresos(Double.parseDouble(txtBalance.getText()));
                fc.setEstado("0");
                if (new CerrarCajaControl().cerrarCaja(new CerrarCajaControl().getIdUsuario(txtUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()), fc)) {
                    JOptionPane.showMessageDialog(null, "SE CERRO LA CAJA CORRECTAMENTE");
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR AL CERRAR LA CAJA");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        double balance = Double.parseDouble(txtBalance.getText());
        double saldoContado = Double.parseDouble(txtSaldoContabilizado.getText());
        double descuadre = Math.round(balance - saldoContado);
        if (descuadre > 0) {
            lblDescuadre.setForeground(Color.green);
            lblDescuadre.setText("" + descuadre);
        } else {
            lblDescuadre.setForeground(Color.red);
            lblDescuadre.setText("" + descuadre);
        }
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        parametros.put("total", total);
//        parametros.put("fecha", ff);
//        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ventadiaria.jrxml", parametros);
//        mrv.exportarAPdf();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String numero = txtSaldoContabilizado.getText() + ".";
        txtSaldoContabilizado.setText(numero);
    }//GEN-LAST:event_jButton14ActionPerformed

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
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblDescuadre;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtMontoApertura;
    private javax.swing.JTextField txtSaldoContabilizado;
    private javax.swing.JTextField txtTarjetas;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
