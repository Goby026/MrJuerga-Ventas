/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ManejadorFechas;
import Controlador.PagonPersonalControl;
import Controlador.Redondear;
import Controlador.Validaciones;
import Modelo.FlujoAsistenciaDAO;
import Modelo.FlujoCajaDAO;
import Modelo.Gasto;
import Modelo.GastoDAO;
import Modelo.UsuarioGastos;
import Modelo.UsuarioGastosDAO;
import Modelo.UsuarioPerfilDAO;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Marce
 */
public class PagosPersonal extends javax.swing.JFrame {

    //DefaultTableModel modeloPersonal;
    public PagosPersonal(String usuario) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        new PagonPersonalControl().cargarTabla(tblPersonal);
        lblTotal.setText(""+tblPersonal.getRowCount());
    }

    public PagosPersonal() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNumerico = new javax.swing.JDialog();
        txtMontoPenalizacion = new javax.swing.JTextField();
        btnSiete = new javax.swing.JButton();
        btnOcho = new javax.swing.JButton();
        btnNueve = new javax.swing.JButton();
        btnCuatro = new javax.swing.JButton();
        btnCinco = new javax.swing.JButton();
        btnSeis = new javax.swing.JButton();
        btnUno = new javax.swing.JButton();
        btnDos = new javax.swing.JButton();
        btnTres = new javax.swing.JButton();
        btnCero = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnAceptarPenalizacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBonificacion = new javax.swing.JTextField();
        btnRealizarPago = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        txtPago = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtPerfil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDcto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPenalidad = new javax.swing.JTextField();
        btnPanelNumerico = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        panelEstado = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        panelNumerico.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMontoPenalizacion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtMontoPenalizacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelNumerico.getContentPane().add(txtMontoPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 80));

        btnSiete.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSiete.setText("7");
        btnSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieteActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnSiete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 80));

        btnOcho.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnOcho.setText("8");
        btnOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOchoActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnOcho, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 90, 80));

        btnNueve.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnNueve.setText("9");
        btnNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNueveActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnNueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 90, 80));

        btnCuatro.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCuatro.setText("4");
        btnCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuatroActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, 80));

        btnCinco.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCinco.setText("5");
        btnCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCincoActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 90, 80));

        btnSeis.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSeis.setText("6");
        btnSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeisActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnSeis, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 90, 80));

        btnUno.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnUno.setText("1");
        btnUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnoActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 90, 80));

        btnDos.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnDos.setText("2");
        btnDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 90, 80));

        btnTres.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnTres.setText("3");
        btnTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTresActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 90, 80));

        btnCero.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnCero.setText("0");
        btnCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeroActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 190, 80));

        btnBorrar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnBorrar.setText("<");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 90, 80));

        btnAceptarPenalizacion.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAceptarPenalizacion.setText("ACEPTAR");
        btnAceptarPenalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarPenalizacionActionPerformed(evt);
            }
        });
        panelNumerico.getContentPane().add(btnAceptarPenalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 290, 80));

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("PAGO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 280, -1, -1));

        tblPersonal.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPersonal.setRowHeight(26);
        tblPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1100, 520));

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel2.setText("BONIFICACION");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 360, -1, -1));

        txtBonificacion.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtBonificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtBonificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 360, 180, -1));

        btnRealizarPago.setBackground(new java.awt.Color(0, 153, 0));
        btnRealizarPago.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnRealizarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnRealizarPago.setText("REALIZAR PAGO");
        btnRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRealizarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 570, 310, 90));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PAGOS PERSONAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 150));

        jButton12.setText("REPORTE DE PAGOS");
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 670, 310, 30));

        txtPago.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 280, 180, -1));

        lblTotal.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 710, 120, 30));

        txtPerfil.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtPerfil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 240, 180, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel7.setText("DESCUENTO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 320, -1, -1));

        txtDcto.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtDcto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDcto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 320, 180, -1));

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel9.setText("MONTO");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 470, -1, -1));

        txtMonto.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 470, 180, -1));

        jLabel10.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel10.setText("PENALIDAD");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 410, -1, -1));

        txtPenalidad.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        txtPenalidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPenalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 400, 180, -1));

        btnPanelNumerico.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        btnPanelNumerico.setText("C");
        btnPanelNumerico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPanelNumericoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPanelNumerico, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 390, 50, 50));

        jLabel11.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel11.setText("PERFIL");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 240, -1, -1));

        panelEstado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEstado.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelEstado.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        getContentPane().add(panelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 180, 180, 40));

        jLabel12.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel12.setText("ESTADO");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel13.setText("TOTAL:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 710, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed
        try {
            if (new Validaciones().validarCampoVacio(txtPago)) {
                if (new Validaciones().validarCampoVacio(txtBonificacion)) {
                    int fila = tblPersonal.getSelectedRow();
                    int idUsuario = Integer.parseInt(tblPersonal.getValueAt(fila, 0).toString());
                    int idFlujoAsistencia = new FlujoAsistenciaDAO().getIdFlujo(idUsuario);
                    if (new FlujoAsistenciaDAO().updateFlujoAssistencia(new ManejadorFechas().getFechaActualMySQL(), new ManejadorFechas().getHoraActual(), idFlujoAsistencia)) {
                        double monto = Double.parseDouble(txtMonto.getText());
                        
                    } else {
                    }
                    //int idGasto = new PagonPersonalControl().getIdGasto(cmbConcepto.getSelectedItem().toString());
                    
                    UsuarioGastos ug = new UsuarioGastos();
                    ug.setIdUsuario(idUsuario);
                    //ug.setIdGastos(idGasto);
                    //ug.setMonto(monto);
                    UsuarioGastosDAO ugdao = new UsuarioGastosDAO();
                    if (ugdao.registrar(ug)) {
                        JOptionPane.showMessageDialog(rootPane, "PAGO REGISTRADO");
                        //new PagonPersonalControl().limpiarCampos(txtPersonal, txtBonificacion, tblPersonal);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE MONTO DE PAGO");
                    txtBonificacion.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "INGRESE DNI DE PERSONAL");
                //txtPersonal.requestFocus();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRealizarPagoActionPerformed

    private void btnSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieteActionPerformed
        String numero = txtMontoPenalizacion.getText() + 7;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnSieteActionPerformed

    private void btnOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOchoActionPerformed
        String numero = txtMontoPenalizacion.getText() + 8;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnOchoActionPerformed

    private void btnNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNueveActionPerformed
        String numero = txtMontoPenalizacion.getText() + 9;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnNueveActionPerformed

    private void btnCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuatroActionPerformed
        String numero = txtMontoPenalizacion.getText() + 4;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnCuatroActionPerformed

    private void btnCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCincoActionPerformed
        String numero = txtMontoPenalizacion.getText() + 5;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnCincoActionPerformed

    private void btnSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeisActionPerformed
        String numero = txtMontoPenalizacion.getText() + 6;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnSeisActionPerformed

    private void btnUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnoActionPerformed
        String numero = txtMontoPenalizacion.getText() + 1;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnUnoActionPerformed

    private void btnDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosActionPerformed
        String numero = txtMontoPenalizacion.getText() + 2;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnDosActionPerformed

    private void btnTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTresActionPerformed
        String numero = txtMontoPenalizacion.getText() + 3;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnTresActionPerformed

    private void btnCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeroActionPerformed
        String numero = txtMontoPenalizacion.getText() + 0;
        txtMontoPenalizacion.setText(numero);
    }//GEN-LAST:event_btnCeroActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        txtMontoPenalizacion.setText("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAceptarPenalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarPenalizacionActionPerformed
        txtPenalidad.setText(txtMontoPenalizacion.getText());
        double bono = Double.parseDouble(txtPago.getText()) + Double.parseDouble(txtBonificacion.getText());
        double dctos = Double.parseDouble(txtDcto.getText()) + Double.parseDouble(txtPenalidad.getText());
        txtMonto.setText(""+ (bono - dctos));
        panelNumerico.dispose();
    }//GEN-LAST:event_btnAceptarPenalizacionActionPerformed

    private void btnPanelNumericoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPanelNumericoActionPerformed
        panelNumerico.setVisible(true);
        panelNumerico.setBounds(400, 200, 330, 630);
    }//GEN-LAST:event_btnPanelNumericoActionPerformed

    private void tblPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonalMouseClicked
        try {
            int fila = tblPersonal.getSelectedRow();
            String dniPersonal = tblPersonal.getValueAt(fila, 3).toString();
            int idusuario = new PagonPersonalControl().getIdUsuarioConDNI(dniPersonal);
            
            //levantar toda a informacion para pagar
            txtPerfil.setText(new UsuarioPerfilDAO().getPerfilConIdDeUsuario(idusuario));
            txtPago.setText(""+ new PagonPersonalControl().getPagoPersonal(idusuario));
            //DESCUENTOS:
            //planilla = 5.70
            //planilla con hijo = 6.20
            if (new PagonPersonalControl().getPlanillaPersonal(idusuario)>0) {
                //verificar si tiene carga familiar
                if (new PagonPersonalControl().getPlanillaPersonal(idusuario)==2) { //2=planilla con hijos
                    txtDcto.setText(""+6.20);
                }else{
                    txtDcto.setText(""+5.70);//planilla sin hijo
                }
            } else {
                txtDcto.setText("0");
            }
            int idAsistencia = new FlujoAsistenciaDAO().getIdFlujo(idusuario);
            if (new PagonPersonalControl().verificarPago(idAsistencia)>0) {
                panelEstado.setBackground(Color.GREEN);
                lblEstado.setForeground(Color.WHITE);
                lblEstado.setText("CANCELADO");
            } else {
                panelEstado.setBackground(Color.RED);
                lblEstado.setForeground(Color.WHITE);
                lblEstado.setText("POR PAGAR");
            }
            
            double getCantidadBonos = new FlujoCajaDAO().getCantidadBonos();
            double bonificacion = (getCantidadBonos*5)/Integer.parseInt(lblTotal.getText());
            txtBonificacion.setText(""+new Redondear().Redondear(bonificacion));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblPersonalMouseClicked

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
                try {
                    new PagosPersonal().setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptarPenalizacion;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCero;
    private javax.swing.JButton btnCinco;
    private javax.swing.JButton btnCuatro;
    private javax.swing.JButton btnDos;
    private javax.swing.JButton btnNueve;
    private javax.swing.JButton btnOcho;
    private javax.swing.JButton btnPanelNumerico;
    private javax.swing.JButton btnRealizarPago;
    private javax.swing.JButton btnSeis;
    private javax.swing.JButton btnSiete;
    private javax.swing.JButton btnTres;
    private javax.swing.JButton btnUno;
    private javax.swing.JButton jButton12;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panelEstado;
    private javax.swing.JDialog panelNumerico;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtBonificacion;
    private javax.swing.JTextField txtDcto;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoPenalizacion;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPenalidad;
    private javax.swing.JTextField txtPerfil;
    // End of variables declaration//GEN-END:variables
}
