package Controlador;

import Modelo.Gasto;
import Modelo.GastoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class PagonPersonalControl {

    DefaultTableModel modelo;

    //metodo para establecer los nombres de las columnas de la tabla personal
    public void titulosTabla(JTable tabla) {
        String titulos[] = {"ID","NOMBRES", "APELLIDOS","DNI"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
    }

    //metodo para llenar la tabla de personales cuando se ingrese el dni
    public void tablaPersonal(String dni, JTable tabla) throws Exception {
        try {
            titulosTabla(tabla);
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getDni().equals(dni)) {
                    Object[] columna = new Object[4];
                    columna[0] = u.getId();
                    columna[1] = u.getNombre();
                    columna[2] = u.getApellido();
                    columna[3] = u.getDni();
                    
                    System.out.println(columna[0]);
                    System.out.println(columna[1]);
                    System.out.println(columna[2]);
                    System.out.println(columna[3]);
                    modelo.addRow(columna);
                }
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean registrarPago(String fecha, String concepto, double monto) throws Exception {
        try {
            Gasto g = new Gasto();
            g.setConcepto(concepto);
            g.setMonto(monto);
            GastoDAO gdao = new GastoDAO();
            if (gdao.Registrar(g)) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void cargarComboConcepto(JComboBox cmb) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                cmb.addItem(g.getConcepto());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int getIdGasto(String concepto) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                if (g.getConcepto().equals(concepto)) {
                    return g.getIdgastos();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }
    
    public void limpiarCampos(JTextField txtPersonal, JTextField txtPago, JTable tblPersonal) {
        titulosTabla(tblPersonal);
        txtPersonal.setText("");
        txtPago.setText("");
        tblPersonal.setModel(modelo);
        for (int i = 0; i < tblPersonal.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

}
