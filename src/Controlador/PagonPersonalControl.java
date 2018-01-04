package Controlador;

import Modelo.FlujoAsistencia;
import Modelo.FlujoAsistenciaDAO;
import Modelo.Gasto;
import Modelo.GastoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class PagonPersonalControl {

    DefaultTableModel modeloAsistencias;

    //metodo para establecer los nombres de las columnas de la tabla personal
    public void cargarTitulosTabla(JTable tabla) {
        String titulos[] = {"USUARIO","NOMBRES", "APELLIDOS","DNI"};
        modeloAsistencias = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloAsistencias);
    }

    public void cargarTabla(JTable tabla) throws Exception {
        try {
            cargarTitulosTabla(tabla);

            Object[] columna = new Object[5];

            for (int i = 0; i < new FlujoAsistenciaDAO().getDatosTabla().size(); i++) {
                columna[0] = new FlujoAsistenciaDAO().getDatosTabla().get(i).getIdAsistencia();
                columna[1] = new FlujoAsistenciaDAO().getDatosTabla().get(i).getNombre();
                columna[2] = new FlujoAsistenciaDAO().getDatosTabla().get(i).getApellido();
                columna[3] = new FlujoAsistenciaDAO().getDatosTabla().get(i).getDni();
                modeloAsistencias.addRow(columna);
            }
        } catch (Exception ex) {
            throw ex;
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
    
    public double getPagoPersonal(int idUsuario) throws Exception{
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getId()==idUsuario) {
                    return u.getSueldo();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }
    
    public int getPlanillaPersonal(int idUsuario) throws Exception{
        try {
            //PLANILLA:
            //2= planilla y familia
            //1 = esta en planilla
            //0 = no esta en planilla
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getId()==idUsuario) {
                    return u.getPlanilla();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }
    
    public int getIdUsuarioConDNI(String dni) throws Exception{
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getDni().equals(dni)) {
                    return u.getId();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
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
    
    public int verificarPago(int idAsistencia) throws Exception{
        try {
            FlujoAsistenciaDAO fadao= new FlujoAsistenciaDAO();
            for (FlujoAsistencia fa : fadao.listar()) {
                if (fa.getIdAsistencia()==idAsistencia) {
                    return fa.getEstadoPago();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }
    
    public void limpiarCampos(JTextField txtPersonal, JTextField txtPago, JTable tblPersonal) {
        cargarTitulosTabla(tblPersonal);
        txtPersonal.setText("");
        txtPago.setText("");
        tblPersonal.setModel(modeloAsistencias);
        for (int i = 0; i < tblPersonal.getRowCount(); i++) {
            modeloAsistencias.removeRow(i);
            i -= 1;
        }
    }

}
