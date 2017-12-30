/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.GastosControl;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Modelo.FlujoCajaDAO;
import Modelo.UsuarioGastos;
import Modelo.UsuarioGastosDAO;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author ELMER_05
 */
public class Gastos extends javax.swing.JFrame {

    MyiReportVisor mrv;
    HashMap parametros = new HashMap();
    
    public Gastos(String usuario) {
        initComponents();
        setLocationRelativeTo(null);
        cargarDatos(usuario);
    }

    public Gastos() {
    }

    public void cargarDatos(String usuario) {
        try {
            new GastosControl().cargarListaGastos(listaGastos);
            lblUsuario.setText(usuario);
            lblCaja.setText(new GastosControl().getCajaDeUsuario(usuario));
        } catch (Exception e) {
            e.printStackTrace();
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGastos = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        txtImporte = new javax.swing.JTextField();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnpunto = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LISTA DE GASTOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, -1));

        listaGastos.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(listaGastos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 240, 330));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("IMPORTE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(272, 80, 230, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("OBSERVACIONES");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 80, 350, -1));

        txaObservaciones.setColumns(20);
        txaObservaciones.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txaObservaciones.setLineWrap(true);
        txaObservaciones.setRows(5);
        jScrollPane2.setViewportView(txaObservaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, 350, 330));

        txtImporte.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 230, 50));

        btn7.setBackground(new java.awt.Color(0, 102, 204));
        btn7.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        getContentPane().add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 70, 60));

        btn8.setBackground(new java.awt.Color(0, 102, 204));
        btn8.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        getContentPane().add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 70, 60));

        btn9.setBackground(new java.awt.Color(0, 102, 204));
        btn9.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        getContentPane().add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 70, 60));

        btn4.setBackground(new java.awt.Color(0, 102, 204));
        btn4.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 70, 60));

        btn5.setBackground(new java.awt.Color(0, 102, 204));
        btn5.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 70, 60));

        btn6.setBackground(new java.awt.Color(0, 102, 204));
        btn6.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 70, 60));

        btn1.setBackground(new java.awt.Color(0, 102, 204));
        btn1.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 70, 60));

        btn2.setBackground(new java.awt.Color(0, 102, 204));
        btn2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 70, 60));

        btn3.setBackground(new java.awt.Color(0, 102, 204));
        btn3.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 70, 60));

        btn0.setBackground(new java.awt.Color(0, 102, 204));
        btn0.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btn0.setForeground(new java.awt.Color(255, 255, 255));
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        getContentPane().add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 70, 60));

        btnpunto.setBackground(new java.awt.Color(0, 102, 204));
        btnpunto.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnpunto.setForeground(new java.awt.Color(255, 255, 255));
        btnpunto.setText(".");
        btnpunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpuntoActionPerformed(evt);
            }
        });
        getContentPane().add(btnpunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 70, 60));

        btnborrar.setBackground(new java.awt.Color(204, 0, 0));
        btnborrar.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        btnborrar.setForeground(new java.awt.Color(255, 255, 255));
        btnborrar.setText("<");
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 390, 70, 60));

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 240, 70));

        jButton1.setText("LISTA DE GASTOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 240, 70));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GASTOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USUARIO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CAJA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("jLabel7");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 150, -1));

        lblCaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCaja.setForeground(new java.awt.Color(255, 255, 255));
        lblCaja.setText("jLabel7");
        jPanel1.add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        String numero = txtImporte.getText() + 7;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        String numero = txtImporte.getText() + 8;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        String numero = txtImporte.getText() + 9;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        String numero = txtImporte.getText() + 4;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        String numero = txtImporte.getText() + 5;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        String numero = txtImporte.getText() + 6;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        String numero = txtImporte.getText() + 1;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        String numero = txtImporte.getText() + 2;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        String numero = txtImporte.getText() + 3;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        String numero = txtImporte.getText() + 0;
        txtImporte.setText(numero);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnpuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpuntoActionPerformed
        String numero = txtImporte.getText() + ".";
        txtImporte.setText(numero);
    }//GEN-LAST:event_btnpuntoActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
        txtImporte.setText("");
    }//GEN-LAST:event_btnborrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//        if (listaGastos.isSelectionEmpty() || txtImporte.getText().isEmpty() || txaObservaciones.getText().isEmpty()) {
//            System.out.println("indique el gasto correctamente");
//        } else {
//            System.out.println("correcto");
//        }
        try {
            if (!txtImporte.getText().trim().isEmpty()) {
                if (!listaGastos.isSelectionEmpty() || !txaObservaciones.getText().trim().isEmpty()) {
                    System.out.println("correcto");
                    UsuarioGastos ug = new UsuarioGastos();
                    
                    //obtener el id de gasto seleccionado
                    //obtener el id de usuario
                    //capturo el monto
                    //fecha y hora
                    //obtener el id de flujo de caja
                    //finalmente capturamos la observacion
                    
                    ug.setIdGastos(new GastosControl().getIdGasto((String) listaGastos.getSelectedValue()));
                    ug.setIdUsuario(new GastosControl().getIdUsuario(lblUsuario.getText()));
                    ug.setMonto(Double.parseDouble(txtImporte.getText()));
                    ug.setFecha(new ManejadorFechas().getFechaActualMySQL());
                    ug.setHora(new ManejadorFechas().getHoraActual());
                    ug.setIdFlujoCaja(new FlujoCajaDAO().getIdFlujo(new GastosControl().getIdUsuario(lblUsuario.getText()), new GastosControl().getIdCaja(lblCaja.getText())));
                    ug.setObservacion(txaObservaciones.getText());
                    
                    if (new UsuarioGastosDAO().registrar(ug)) {
                        JOptionPane.showMessageDialog(null, "GASTO REGISTRADO");
                        txtImporte.setText("");
                        txaObservaciones.setText("");
                        cargarDatos(lblUsuario.getText());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SELECCIONE UN GASTO O DESCRIBA LA OBSERVACION DEL GASTO");
                }
            } else {
                JOptionPane.showMessageDialog(null, "INGRESE UN MONTO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new GastosControl().getIdUsuario(lblUsuario.getText()), new GastosControl().getIdCaja(lblCaja.getText()));
            parametros.put("flujo", idFlujoCaja);
            parametros.put("usuario", lblUsuario.getText());
            parametros.put("caja", lblCaja.getText());

            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ListaGastos.jrxml", parametros);
            mrv.exportarAPdf();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btnpunto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JList listaGastos;
    private javax.swing.JTextArea txaObservaciones;
    private javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables
}
