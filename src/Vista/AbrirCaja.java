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
        String captura = txtSaldoInicial.getText();
        lblMonto.setText(captura);
        if (new AbrirCajaControl().verificarEstadoCaja(usuario) > 0) {
            lblEstado.setText("CAJA APERTURADA");
            lblEstado.setForeground(Color.GREEN);
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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("CAJA");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        txtSaldoInicial.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSaldoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoInicialActionPerformed(evt);
            }
        });
        getContentPane().add(txtSaldoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 130, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel27.setText("SALDO INICIAL");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblFecha.setText("_______________");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel28.setText("FECHA");
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        btnAperturar.setBackground(new java.awt.Color(51, 153, 0));
        btnAperturar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAperturar.setForeground(new java.awt.Color(255, 255, 255));
        btnAperturar.setText("APERTURAR");
        btnAperturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAperturarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAperturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 160, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 160, -1));

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
        jLabel33.setText("MONTO");
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        lblEstado.setText("________________");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("ESTADO");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        lblMonto.setText("_____");
        getContentPane().add(lblMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel9.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 640, 40));

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
                
                for (FlujoCaja fc : fdao.Listar()) {
                    if (fc.getHoraFinal().equals(null)) {
                        flag++;
                    }
                }
                                
                System.out.println(flag);
                if (flag > 0) {
                    JOptionPane.showMessageDialog(getRootPane(), "YA SE APERTURO ESTA CAJA EL DIA DE HOY.");
                } else {
                    //registrar la hora inicial y la final al igual que la fecha inicial y fecha final
                    FlujoCaja fc = new FlujoCaja();
                    fc.setFechaInicio(new ManejadorFechas().getFechaActualMySQL());
                    fc.setHoraInicio(new ManejadorFechas().getHoraActual());
                    fc.setIngresos(0);
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
                System.out.println(ex.getMessage());
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAperturar;
    private javax.swing.JButton btnCancelar;
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
