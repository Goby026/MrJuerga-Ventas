package Controlador;

import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Conexion;
import Modelo.NpBarra2DAO;
import Modelo.NpBarra3DAO;
import Modelo.NpBarraDAO;
import Modelo.NpBarra_Prod;
import Modelo.NpBarra_Prod2;
import Modelo.NpBarra_Prod3;
import Modelo.NpBarra_ProdDAO;
import Modelo.NpBarra_ProdDAO2;
import Modelo.NpBarra_ProdDAO3;
import Modelo.Presentacion;
import Modelo.PresentacionDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.ProductoPresentacion;
import Modelo.ProductoPresentacionDAO;
import Modelo.Usuario;
import Modelo.UsuarioCaja;
import Modelo.UsuarioCajaDAO;
import Modelo.UsuarioDAO;
import Modelo.VentaProducto;
import Modelo.VentaProductoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NpBarrasControl {

    DefaultTableModel modelo;

    public void LlenarTablaProductosConId(int idCategoria, JTable tabla, int idAlmacen, int small, int large, int xl) throws Exception {
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
        for (ProductoPresentacion pp : ppdao.Listar(idAlmacen)) {
            if (pp.getIdcategoria() == idCategoria) {
                columna[0] = getProductoConId(pp.getIdProducto());
                columna[1] = getPresentacionConId(pp.getIdPresentacion());
                columna[2] = pp.getStock2();
                columna[3] = pp.getPrecio();
                modelo.addRow(columna);
            }
        }
        tabla.getColumnModel().getColumn(0).setPreferredWidth(xl);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(large);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(small);

    }

    public void llenarTablaProductos(String nomCate, JTable tabla, int numCaja) throws Exception {
        int id = new CategoriaDAO().getIdCategoria(nomCate);
        new NpBarrasControl().LlenarTablaProductosConId(id, tabla, numCaja, 50, 100, 200);
    }

    //metodo para cargar la lista de categorias
//    public void llenarListaCategorias(JList lista) throws Exception {
//        CategoriaDAO dcate = new CategoriaDAO();
//        DefaultListModel list = new DefaultListModel();
//        for (Categoria c : dcate.Listar()) {
//            list.addElement(c.getDescripcion());
//        }
//        lista.setModel(list);
//    }
    public double calcularMonto(JTable tabla) {
        double subtotal = 0.0;
        int numFilas = tabla.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            subtotal += (Double.parseDouble(tabla.getValueAt(i, 3).toString())) * (Integer.parseInt(tabla.getValueAt(i, 4).toString()));
        }
        return subtotal;
    }

//    public int getIdComprobanteConNombre(String nomComprobante) throws Exception {
//        TipoComprobanteDAO cdao = new TipoComprobanteDAO();
//        for (TipoComprobante c : cdao.Listar()) {
//            if (c.getDescripcion().equals(nomComprobante)) {
//                return c.getIdtipocomprobante();
//            }
//        }
//        return 0;
//    }
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
            for (ProductoPresentacion pp : ppdao.Listar()) {
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

    /*OBTENER ULTIMO REGISTRO DE VENTA CAJA 1 */
    public int getIdDeUltimaNpBarraRegistrada(int caja) throws Exception {
        int id = 0;
        switch (caja) {
            case 1:
                id = new NpBarraDAO().getIdUltimaNota();
                break;
            case 2:
                id = new NpBarra2DAO().getIdUltimaNota();
                break;
            case 3:
                id = new NpBarra3DAO().getIdUltimaNota();
                break;
        }
        return id;
    }
    //metodo para registrar detalles de NOTA DE PEDIDO sin parametros
    public int registrarDetalleDeNpBarra(JTable tabla, int numVenta, int caja) throws Exception {
        try {

            int flag = 0;
            int numFilas = tabla.getRowCount();

            switch (caja) {
                case 1:
                    for (int i = 0; i < numFilas; i++) {
                        NpBarra_Prod vp = new NpBarra_Prod();
                        vp.setIdProductoPresentacion(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                        vp.setIdNpBarra(numVenta);
                        vp.setPrecioU(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                        vp.setCantidad(Integer.parseInt(tabla.getValueAt(i, 4).toString()));
                        vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                        NpBarra_ProdDAO vpdao = new NpBarra_ProdDAO();
                        if (vpdao.registrar(vp)) {
                            flag++;
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < numFilas; i++) {
                        NpBarra_Prod2 vp = new NpBarra_Prod2();
                        vp.setIdProductoPresentacion(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                        vp.setIdNpBarra(numVenta);
                        vp.setPrecioU(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                        vp.setCantidad(Integer.parseInt(tabla.getValueAt(i, 4).toString()));
                        vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                        NpBarra_ProdDAO2 vpdao = new NpBarra_ProdDAO2();
                        if (vpdao.registrar(vp)) {
                            flag++;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < numFilas; i++) {
                        NpBarra_Prod3 vp = new NpBarra_Prod3();
                        vp.setIdProductoPresentacion(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                        vp.setIdNpBarra(numVenta);
                        vp.setPrecioU(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                        vp.setCantidad(Integer.parseInt(tabla.getValueAt(i, 4).toString()));
                        vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                        NpBarra_ProdDAO3 vpdao = new NpBarra_ProdDAO3();
                        if (vpdao.registrar(vp)) {
                            flag++;
                        }
                    }
                    break;
            }

            return flag;
        } catch (Exception e) {
            throw e;
        }
    }

    /* MRTODO PARA REGISTRAR DETALLE DE VENTA REAL DE CAJA 2 O 3 CON PARAMETRO numCaja */
    public int registrarDetalleDeVenta(JTable tabla, int numVenta, int numCaja) throws Exception {
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
                switch (numCaja) {
                    case 2:
                        if (vpdao.registrar2(vp)) {
                            flag++;
                        }
                        break;
                    case 3:
                        if (vpdao.registrar3(vp)) {
                            flag++;
                        }
                        break;
                    default:
                        if (vpdao.registrar(vp)) {
                            flag++;
                        }
                        break;
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

    //metodo para restar stock en una venta con nota de pedido
    public boolean restarStock(JTable tabla, int caja) throws Exception {
        int numFilas = tabla.getRowCount();
        try {
            for (int i = 0; i < numFilas; i++) {
                int id = Integer.parseInt(tabla.getValueAt(i, 0).toString());//252
                System.out.println("id: " + id);
                int cantidad = Integer.parseInt(tabla.getValueAt(i, 4).toString());
                System.out.println("cantidad: " + cantidad);
                ProductoPresentacionDAO pdao = new ProductoPresentacionDAO();
                int stock = getStockProductoPresentacion(id)- cantidad;
                System.out.println("stock: "+stock);
                
                pdao.modificar(id, stock, 2);
                
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
            for (ProductoPresentacion pp : ppdao.Listar()) {
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
            for (ProductoPresentacion pp : ppdao.Listar()) {
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
//    public int getStockProductoPresentacion(int idProducto, int idPresentacion) throws Exception {
//        try {
//            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
//            for (ProductoPresentacion pp : ppdao.listar()) {
//                if (pp.getIdProducto() == idProducto && pp.getIdPresentacion() == idPresentacion) {
//                    return pp.getStock();
//                }
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//        return 0;
//    }
    public int totalJarras(int stockCaboBlanco) {
        try {
            return stockCaboBlanco * 6;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getStockProductoPresentacion(int idProducto) throws SQLException {
        Conexion con = new Conexion();
        String sql = "SELECT productopresentacion.stock2 FROM\n"
                + "producto\n"
                + "INNER JOIN productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                + "WHERE productopresentacion.idproductopresentacion ="+idProducto;
        try {
            con.conectar();
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return res.getInt(1);
            }

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
        return -1;
    }
}
