/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AbrirCajaControl;
import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import java.awt.Color;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Marce
 */
public class AbrirCaja extends javax.swing.JFrame {

    /**
     * Creates new form AbrirCaja
     */
    public AbrirCaja(String usuario) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        datosIniciales(usuario);
    }

    public AbrirCaja() {
    }

    public void datosIniciales(String usuario) throws Exception {
        Color c = new Color(153, 153, 153);
        getRootPane().setBackground(c);
        txtUsuario.setText(usuario);
        new Cronometro().iniciarCronometro(txtHora);
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        lblCaja.setText(new AbrirCajaControl().getCajaDeUsuario(usuario));
        int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new AbrirCajaControl().getIdUsuario(txtUsuario.getText()), new AbrirCajaControl().getIdCaja(lblCaja.getText()));
        if (new AbrirCajaControl().verificarEstadoCaja(usuario) > 0) {
            lblEstado.setText("CAJA APERTURADA");
            lblEstado.setForeground(Color.GREEN);
            lblMonto.setText(new AbrirCajaControl().getSaldoInicial(idFlujoCaja));
        } else {
            lblEstado.setText("CAJA CERRADA");
            lblEstado.setForeground(Color.RED);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel25 = new javax.swing.JLabel();
        txtSaldoInicial = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnAperturar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblCaja = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("CAJA");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        txtSaldoInicial.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSaldoInicial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoInicialActionPerformed(evt);
            }
        });
        getContentPane().add(txtSaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 230, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("SALDO INICIAL");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFecha.setText("_______________");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("FECHA");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        btnAperturar.setBackground(new java.awt.Color(51, 153, 0));
        btnAperturar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAperturar.setForeground(new java.awt.Color(255, 255, 255));
        btnAperturar.setText("APERTURAR");
        btnAperturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAperturarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAperturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 683, 230, 40));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 740, 230, -1));

        lblCaja.setText("________________");
        getContentPane().add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("GESTION DE CAJA");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, 30));
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(102, 102, 102));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 140, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(102, 102, 102));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        txtUsuario.setEnabled(false);
        txtUsuario.setFocusable(false);
        jPanel8.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 140, -1));

        jLabel31.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel31.setText("GESTION DE CAJA");
        jPanel8.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 70, -1, 30));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caja-registradora general.png"))); // NOI18N
        jPanel8.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 130));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 130));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("MONTO INICIAL");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        lblEstado.setText("________________");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("ESTADO");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        lblMonto.setText("_____");
        getContentPane().add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 800, 640, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("7");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 70, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("8");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 70, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("9");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 70, 60));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 70, 60));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 70, 60));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 70, 60));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setText("1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 70, 60));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton8.setText("2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 70, 60));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setText("3");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 520, 70, 60));

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton10.setText("0");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 590, 150, 60));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton11.setText("<");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 590, 70, 60));

        jButton12.setText("MOVIMIENTO");
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void inicio() {
        //metodo para cargar los datos por defecto del formulario
        //1° Obtener el estado de la caja que esta abriendo segun el usuario que se logea
        //para obtener la caja que se esta aperturando se debe preguntar que caja esta ocupando

        //2° cargamos la fecha actual del sistema en formato latam
        lblFecha.setText(new ManejadorFechas().getFechaActual());
    }

    private void btnAperturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAperturarActionPerformed
        if (!txtSaldoInicial.getText().trim().isEmpty()) {
            try {
                int flag = 0;
                FlujoCajaDAO fdao = new FlujoCajaDAO();

                if (new AbrirCajaControl().verificarApertura(new AbrirCajaControl().getIdUsuario(txtUsuario.getText()), new AbrirCajaControl().getIdCaja(lblCaja.getText()))) {
                    flag++;
                }
                
                System.out.println(flag);

                if (flag > 0) {
                    JOptionPane.showMessageDialog(getRootPane(), "YA SE APERTURO ESTA CAJA EL DIA DE HOY.");
                } else {
                    //registrar la hora inicial y la final al igual que la fecha inicial y fecha final
                    FlujoCaja fc = new FlujoCaja();
                    fc.setFechaInicio(new ManejadorFechas().getFechaActualMySQL());
                    fc.setHoraInicio(new ManejadorFechas().getHoraActual());
                    fc.setIngresos(Double.parseDouble(txtSaldoInicial.getText()));
                    fc.setEgresos(0);
                    fc.setSaldo(Double.parseDouble(txtSaldoInicial.getText()));
                    fc.setIdUsuario(new AbrirCajaControl().getIdUsuario(txtUsuario.getText()));
                    fc.setIdCaja(new AbrirCajaControl().getIdCaja(lblCaja.getText()));
                    fc.setEstado("1");
                    //estados de caja :  1=aperturado,   0=cerrado

                    if (fdao.Registrar(fc)) {
                        JOptionPane.showMessageDialog(getRootPane(), "SE APERTURO LA CAJA CON S/." + txtSaldoInicial.getText());
                        datosIniciales(txtUsuario.getText());
                        txtSaldoInicial.setText("");

                    } else {
                        JOptionPane.showMessageDialog(getRootPane(), "ERROR EN REGISTRO DE APERTURA");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "INGRESE UN MONTO INICIAL PARA APERTURAR LA CAJA");
        }
    }//GEN-LAST:event_btnAperturarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
                new AbrirCaja().setVisible(true);
            }
        });
    }

    private void txtSaldoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoInicialActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String numero = txtSaldoInicial.getText() + 7;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String numero = txtSaldoInicial.getText() + 8;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String numero = txtSaldoInicial.getText() + 9;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String numero = txtSaldoInicial.getText() + 4;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String numero = txtSaldoInicial.getText() + 5;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String numero = txtSaldoInicial.getText() + 6;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String numero = txtSaldoInicial.getText() + 1;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String numero = txtSaldoInicial.getText() + 2;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String numero = txtSaldoInicial.getText() + 3;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String numero = txtSaldoInicial.getText() + 0;
        txtSaldoInicial.setText(numero);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        txtSaldoInicial.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAperturar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtSaldoInicial;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
