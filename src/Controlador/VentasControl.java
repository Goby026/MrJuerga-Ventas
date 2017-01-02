package Controlador;

import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import Modelo.Presentacion;
import Modelo.PresentacionDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.ProductoPresentacion;
import Modelo.ProductoPresentacionDAO;
import Modelo.TipoComprobante;
import Modelo.TipoComprobanteDAO;
import Modelo.Usuario;
import Modelo.UsuarioCaja;
import Modelo.UsuarioCajaDAO;
import Modelo.UsuarioDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import Modelo.VentaProducto;
import Modelo.VentaProductoDAO;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentasControl {

    DefaultTableModel modelo;

    public void LlenarTablaProductosConId(int idCategoria, JTable tabla, int small, int large, int xl) throws Exception {
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRESENTACIÓN");
        modelo.addColumn("STOCK");
        modelo.addColumn("PRECIO");

        Object[] columna = new Object[4];

        //int numeroRegistros = ved.listar().size();
        //CICLO PARA LLENAR LA TABLA PRODUCTOS SEGUN LA CATEGORIA SELECCIONADA
        for (ProductoPresentacion pp : ppdao.listar()) {
            if (pp.getIdcategoria() == idCategoria) {
                columna[0] = getProductoConId(pp.getIdProducto());
                columna[1] = getPresentacionConId(pp.getIdPresentacion());
                columna[2] = pp.getStock();
                columna[3] = pp.getPrecio();
                modelo.addRow(columna);
            }
        }
        tabla.getColumnModel().getColumn(0).setPreferredWidth(xl);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(large);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(small);

    }
    
    public void llenarTablaProductos(String nomCate, JTable tabla) throws Exception {
        CategoriaDAO dcate = new CategoriaDAO();
        for (Categoria c : dcate.Listar()) {
            if (c.getDescripcion().equals(nomCate)) {
                int id = c.getIdcategoria();
                new VentasControl().LlenarTablaProductosConId(id, tabla, 50, 100, 200);
            }
        }
    }

    public void cargarTipoDocumento(JComboBox combo) throws Exception {
        TipoComprobanteDAO cdao = new TipoComprobanteDAO();
        for (TipoComprobante c : cdao.Listar()) {
            combo.addItem(c.getDescripcion());
        }
    }

    //metodo para cargar la lista de categorias
    public void llenarListaCategorias(JList lista) throws Exception {
        CategoriaDAO dcate = new CategoriaDAO();
        DefaultListModel list = new DefaultListModel();
        for (Categoria c : dcate.Listar()) {
            list.addElement(c.getDescripcion());
        }
        lista.setModel(list);
    }

    public double calcularMonto(JTable tabla) {
        double subtotal = 0.0;
        int numFilas = tabla.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            subtotal += (Double.parseDouble(tabla.getValueAt(i, 3).toString())) * (Integer.parseInt(tabla.getValueAt(i, 4).toString()));
        }
        return subtotal;
    }

    public int getIdComprobanteConNombre(String nomComprobante) throws Exception {
        TipoComprobanteDAO cdao = new TipoComprobanteDAO();
        for (TipoComprobante c : cdao.Listar()) {
            if (c.getDescripcion().equals(nomComprobante)) {
                return c.getIdtipocomprobante();
            }
        }
        return 0;
    }

    //metodo para obtener el id de usuario cob su nombre de usuario
    public int getIdUsuarioConNombre(String nombre) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(nombre)) {
                    return u.getId();
                }
            }
            return 0;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //metodo para obtener el id de categoria seleccionado en la lista de categorias
    public int getIdCategoriaConNombre(String nomCate) throws Exception {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
            for (Categoria c : cdao.Listar()) {
                if (c.getDescripcion().equals(nomCate)) {
                    return c.getIdcategoria();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }

    //metodo para obtener el nombre de presentacion con id
    public String getPresentacionConId(int idPresentacion) throws Exception {
        try {
            PresentacionDAO pdao = new PresentacionDAO();
            for (Presentacion p : pdao.Listar()) {
                if (p.getIdPresentacion() == idPresentacion) {
                    return p.getDescripcion();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    //metodo para obtener el id de presentacion con el nombre
    public int getIdPresentacion(String nomPresentacion) throws Exception {
        try {
            PresentacionDAO pdao = new PresentacionDAO();
            for (Presentacion p : pdao.Listar()) {
                if (p.getDescripcion().equals(nomPresentacion)) {
                    return p.getIdPresentacion();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }

    public String getPrecio(int idProd, int presentacion) throws Exception {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            for (ProductoPresentacion pp : ppdao.listar()) {
                if (pp.getIdProducto() == idProd && pp.getIdPresentacion() == presentacion) {
                    return "" + pp.getPrecio();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return "";
    }

    //obtener el nombre de producto con el id
    public String getProductoConId(int idProducto) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getIdProducto() == idProducto) {
                    return p.getNombre();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return "";
    }

    //obtener el id de producto con el nombre
    public int getIdProductoConNombre(String prod) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getNombre().equals(prod)) {
                    return p.getIdProducto();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }

    /*OBTENER ULTIMO REGISTRO DE VENTA */
    public int getIdDeUltimaVentaRegistrada() throws Exception {
        VentaDAO vdao = new VentaDAO();
        int ultimaFila = vdao.listar().size() - 1;
        Venta v = vdao.listar().get(ultimaFila);
        return v.getIdVenta();
    }
    
     /*OBTENER ULTIMO REGISTRO DE COMPROBANTE */
    public int getIdDeUltimoComprobanteRegistrado() throws Exception {
        ComprobanteDAO cdao = new ComprobanteDAO();
        int ultimaFila = cdao.Listar().size() - 1;
        Comprobante c = cdao.Listar().get(ultimaFila);
        return c.getIdcomprobante();
    }

    //metodo para registrar la venta
    public boolean registrarVenta(Object[] datos) throws Exception {
        Venta v = new Venta();
        v.setFecha((String) datos[0]);
        v.setHora((String) datos[1]);
        v.setIdUsuario((Integer) datos[2]);
        v.setIdCliente((Integer) datos[3]);
        v.setIdComprobante((Integer) datos[4]);
        v.setEstado((Integer) datos[5]);
        v.setTipopago((Integer) datos[6]);
        v.setnOperacion((String) datos[7]);
        v.setIdcaja((Integer) datos[8]);
        try {
            VentaDAO vdao = new VentaDAO();
            if (vdao.registrar(v)) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    //metodo para registrar detalles de venta
    public int registrarDetalleDeVenta(JTable tabla, int numVenta) throws Exception {
        try {
            int flag = 0;
            int numFilas = tabla.getRowCount();
            for (int i = 0; i < numFilas; i++) {
                VentaProducto vp = new VentaProducto();
                vp.setIdProducto(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                vp.setIdVenta(numVenta);
                vp.setPrecio(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                vp.setCantidad(Integer.parseInt(tabla.getValueAt(i, 4).toString()));
                vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                VentaProductoDAO vpdao = new VentaProductoDAO();
                if (vpdao.registrar(vp)) {
                    flag++;
                }
            }
            return flag;
        } catch (Exception e) {
            throw e;
        }
    }

    /*METODO PARA OBTENER EL NOMBRE DE CAJA CON SU ID*/
    public String getCajaConId(int idCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getIdCaja() == idCaja) {
                    return c.getNomCaja();
                }
            }
            return "NULL de getCajaConId";
        } catch (Exception e) {
            throw e;
        }
    }

    //METODO PARA OBTENER EL NOMBRE DE CAJA DEL USUARIO LOGEADO
    public String getCajaDeUsuario(String usuario) throws Exception {
        try {
            int idUsuario = getIdUsuarioConNombre(usuario);
            UsuarioCajaDAO udao = new UsuarioCajaDAO();
            for (UsuarioCaja uc : udao.Listar()) {
                if (uc.getIdusuario() == idUsuario) {
                    return getCajaConId(uc.getIdcaja());
                }
            }
            return "NULL de getCajaDeUsuario";
        } catch (Exception e) {
            throw e;
        }
    }
    
    /*METODO PARA OBTENER EL ID DE CAJA CON SU NOMBRE*/
    public int getIdCaja(String caja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getNomCaja().equals(caja)) {
                    return c.getIdCaja();
                }
            }
            return -1;
        } catch (Exception e) {
            throw e;
        }
    }

    //METODO PARA SUMAR LA CANTIDAD DE UN PRODUCTO QUE SE AÑADE A LA TABLA DE AÑADIDOS, SI ESTE PRODUCTO YA ESTUVIESE EN LA TABLA
    public void sumarCantidad(String prod, JTable tabla, int cantidad) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            if (tabla.getValueAt(i, 1).toString().equals(prod)) {
                int cant = Integer.parseInt(tabla.getValueAt(i, 3).toString()) + cantidad;
                tabla.setValueAt(cant, i, 3);
            }
        }
    }

    //metodo para restar stock en una venta
    public boolean restarStock(JTable tabla) throws Exception {
        int numFilas = tabla.getRowCount();
        try {
            for (int i = 0; i < numFilas; i++) {
                int id = Integer.parseInt(tabla.getValueAt(i, 0).toString());
                System.out.println("id: " + id);
                int cantidad = Integer.parseInt(tabla.getValueAt(i, 4).toString());
                System.out.println("cantidad: " + cantidad);
                ProductoPresentacionDAO pdao = new ProductoPresentacionDAO();
                int stock = getStockProductoPresentacion(id, getIdPresentacion(tabla.getValueAt(i, 2).toString())) - cantidad;
                System.out.println(stock);
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProducto(id);//mando el mismo id de producto
                pp.setIdPresentacion(getIdPresentacion(tabla.getValueAt(i, 2).toString())); //mando el nombre de presentacion al metodo para obtener el id
                pp.setIdalmacen(1);
                pp.setStock(stock);
                pp.setPrecio(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                pp.setIdcategoria(getIdCategoria(id, getIdPresentacion(tabla.getValueAt(i, 2).toString())));
                pp.setIdProductoPresentacion(getIdProductoPresentacion(id, getIdPresentacion(tabla.getValueAt(i, 2).toString())));
                pdao.modificar(pp);
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    //metodo para obtener el id de productopresentacion
    public int getIdProductoPresentacion(int idProducto, int idPresentacion) throws Exception {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            for (ProductoPresentacion pp : ppdao.listar()) {
                if (pp.getIdProducto() == idProducto && pp.getIdPresentacion() == idPresentacion) {
                    return pp.getIdProductoPresentacion();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }

    //metodo para obtener el idcategoria de productopresentacion
    public int getIdCategoria(int idProducto, int idPresentacion) throws Exception {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            for (ProductoPresentacion pp : ppdao.listar()) {
                if (pp.getIdProducto() == idProducto && pp.getIdPresentacion() == idPresentacion) {
                    return pp.getIdcategoria();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }
    
    //metodo para obtener el stock de producto con idProducto e idPresentacion
    public int getStockProductoPresentacion(int idProducto, int idPresentacion) throws Exception {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            for (ProductoPresentacion pp : ppdao.listar()) {
                if (pp.getIdProducto() == idProducto && pp.getIdPresentacion() == idPresentacion) {
                    return pp.getStock();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }
}
