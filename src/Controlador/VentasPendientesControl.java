package Controlador;

import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.VentaProducto;
import Modelo.VentaProductoDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class VentasPendientesControl {

    DefaultTableModel modelo;

    public void cargarTablaVentas(JTable tabla) throws Exception {
        try {
            modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            VentaDAO vdao = new VentaDAO();

            modelo.addColumn("VENTA");
            modelo.addColumn("USUARIO");

            Object[] columna = new Object[2];

            //int numeroRegistros = ved.listar().size();
            //CICLO PARA LLENAR LA TABLA VENTAS PENDIENTES
            for (Venta v : vdao.listar()) {
                if (v.getEstado() == 0) {
                    columna[0] = v.getIdVenta();
                    columna[1] = v.getIdUsuario();
                    modelo.addRow(columna);
                }
            }
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void cargarTablaDetalles(JTable tabla, int idVenta) throws Exception {
        try {
            modelo = new DefaultTableModel();
            tabla.setModel(modelo);
            VentaProductoDAO vpdao = new VentaProductoDAO();

            modelo.addColumn("PRODUCTO");
            modelo.addColumn("PRECIO U.");
            modelo.addColumn("CANTIDAD");
            modelo.addColumn("SUBTOTAL");            

            Object[] columna = new Object[4];

            //int numeroRegistros = ved.listar().size();
            //CICLO PARA LLENAR LA TABLA VENTAS PENDIENTES
            for (VentaProducto vp : vpdao.listar()) {
                if (vp.getIdVenta() == idVenta) {
                    columna[0] = vp.getIdProducto();
                    columna[1] = vp.getPrecio();
                    columna[2] = vp.getCantidad();
                    columna[3] = vp.getSubtotal();
                    modelo.addRow(columna);
                }
            }
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        } catch (Exception e) {
            throw e;
        }
    }
}
