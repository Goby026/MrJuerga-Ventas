package Controlador;

import Modelo.Caja;
import Modelo.CajaDAO;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.ComprobanteDAO;
import Modelo.Conexion;
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
import Modelo.VentaDAO;
import Modelo.VentaProducto;
import Modelo.VentaProductoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentasControl {

    DefaultTableModel modelo;

    //metodo para llenar tabla segun categoria
//    public void LlenarTablaProductosConId(int idCategoria, int idAlmacen, JTable tabla, int small, int large, int xl) throws Exception {
//        modelo = new DefaultTableModel();
//        tabla.setModel(modelo);
//        ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
//
//        modelo.addColumn("PRODUCTO");
//        modelo.addColumn("PRESENTACIÓN");
//        modelo.addColumn("STOCK");
//        modelo.addColumn("PRECIO");
//
//        Object[] columna = new Object[4];
//
//        //int numeroRegistros = ved.listar().size();
//        //CICLO PARA LLENAR LA TABLA PRODUCTOS SEGUN LA CATEGORIA SELECCIONADA
//        for (ProductoPresentacion pp : ppdao.Listar(idAlmacen)) {
//            if (pp.getIdcategoria() == idCategoria) {
//                columna[0] = getProductoConId(pp.getIdProducto());
//                columna[1] = getPresentacionConId(pp.getIdPresentacion());
//                columna[2] = pp.getStock();
//                columna[3] = pp.getPrecio();
//                modelo.addRow(columna);
//            }
//        }
//        tabla.getColumnModel().getColumn(0).setPreferredWidth(300);
//        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
//
//    }
    public void titulos(JTable tabla) {
        String titulos[] = {"PRODUCTO", "PRESENTACIÓN", "STOCK", "PRECIO"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
    }

    public void LlenarTablaProductosConId(int idCategoria, int idAlmacen, JTable tabla, int small, int large, int xl) throws Exception {
        titulos(tabla);
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "select p.nombre, pre.descripcion, pp.stock, pp.precio\n"
                    + "from producto p\n"
                    + "inner join productopresentacion pp on p.idproducto = pp.idproducto\n"
                    + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "where pp.idcategoria = ? and pp.idalmacen= ?";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            pst.setInt(1, idCategoria);
            pst.setInt(2, idAlmacen);
            ResultSet res = pst.executeQuery();
            Object[] datos = new Object[4];

            while (res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getDouble(3);
                datos[3] = res.getDouble(4);
                modelo.addRow(datos);
            }
            
            tabla.setModel(modelo);
            
            pst.close();
            res.close();            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }

        tabla.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);

    }

    public void llenarTablaProductos(String nomCate, JTable tabla, int idAlmacen) throws Exception {
        int idCategoria = new CategoriaDAO().getIdCategoria(nomCate);
        //LOS IDS DE ALMACEN SE MANDAN EN DURO POR QUE SOLO VARIAN ENTRE 3 (1:almacen principal, 2:barra general, 3: barra VIP)        

        new VentasControl().LlenarTablaProductosConId(idCategoria, idAlmacen, tabla, 50, 100, 200);
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
            subtotal += (Double.parseDouble(tabla.getValueAt(i, 5).toString()));
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
    public int getIdDeUltimaVentaRegistrada() throws Exception {
        return new VentaDAO().getIdUltimaVenta();
    }

    /*OBTENER ULTIMO REGISTRO DE VENTA CAJA 2 */
    public int getIdDeUltimaVentaRegistrada2() throws Exception {
        return new VentaDAO().getIdUltimaVenta2();
    }

    /*OBTENER ULTIMO REGISTRO DE VENTA CAJA 3*/
    public int getIdDeUltimaVentaRegistrada3() throws Exception {
        return new VentaDAO().getIdUltimaVenta3();
    }

    /*OBTENER ULTIMO REGISTRO DE COMPROBANTE */
    public int getIdDeUltimoComprobanteRegistrado() throws Exception {
//        ComprobanteDAO cdao = new ComprobanteDAO();
//        int ultimaFila = cdao.Listar().size() - 1;
//        Comprobante c = cdao.Listar().get(ultimaFila);
//        return c.getIdcomprobante();
        return new ComprobanteDAO().getIdUltimoComprobante();
    }

    //metodo para registrar detalles de venta normal en barra general y barra VIP
    public int registrarDetalleDeVenta(JTable tabla, int numVenta, int numCaja) throws Exception {
        try {
            int flag = 0;
            int numFilas = tabla.getRowCount();
            ProductoPresentacion pp = null;//se debe obtener el idProducto a partir del idProductoPresentacion
            for (int i = 0; i < numFilas; i++) {
                VentaProducto vp = new VentaProducto();
                pp = new ProductoPresentacionDAO().Obtener(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                vp.setIdProducto(pp.getIdProducto());
                vp.setIdVenta(numVenta);
                vp.setPrecio(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                vp.setCantidad(Double.parseDouble(tabla.getValueAt(i, 4).toString()));
                vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                VentaProductoDAO vpdao = new VentaProductoDAO();

                switch (numCaja) {
                    case 1:
                        if (vpdao.registrar(vp)) {
                            //System.out.println("ID DE PRODUCTO::::: "+vp.getIdProducto());
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 2);
                                sbp.updateStockVenta();
                            }
                            flag++;
                        }
                        break;
                    case 2:
                        if (vpdao.registrar2(vp)) {
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 2);
                                sbp.updateStockVenta();
                            }
                            flag++;
                        }
                        break;
                    case 3:
                        if (vpdao.registrar3(vp)) {
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 3);
                                sbp.updateStockVenta();
                            }
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

    /* METODO PARA REGISTRAR DETALLE DE VENTA DE OPERACIONES COMBINADAS Y POR CAJA*/
    public int registrarDetalleDeVenta(JTable tabla, int numVenta, double monto, int numCaja) throws Exception {
        try {
            int flag = 0;
            int numFilas = tabla.getRowCount();
            ProductoPresentacion pp = null;//se debe obtener el idProducto a partir del idProductoPresentacion
            for (int i = 0; i < numFilas; i++) {
                VentaProducto vp = new VentaProducto();
                pp = new ProductoPresentacionDAO().Obtener(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
                vp.setIdProducto(pp.getIdProducto());
                vp.setIdVenta(numVenta);
                vp.setPrecio(Double.parseDouble(tabla.getValueAt(i, 3).toString()));
                vp.setCantidad(Double.parseDouble(tabla.getValueAt(i, 4).toString()));
                vp.setSubtotal(Double.parseDouble(tabla.getValueAt(i, 5).toString()));
                VentaProductoDAO vpdao = new VentaProductoDAO();
                switch (numCaja) {
                    case 1:
                        if (vpdao.registrar(vp)) {
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 2);
                                sbp.updateStockVenta();
                            }
                            flag++;
                        }
                        break;
                    case 2:
                        if (vpdao.registrar2(vp)) {
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 2);
                                sbp.updateStockVenta();
                            }
                            flag++;
                        }
                        break;
                    case 3:
                        if (vpdao.registrar3(vp)) {
                            for (int j = 0; j < vp.getCantidad(); j++) {
                                StockBebidasPreparadas sbp = new StockBebidasPreparadas(vp.getIdProducto(), 3);
                                sbp.updateStockVenta();
                            }
                            flag++;
                        }
                        break;
                    default:
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

    //metodo para restar stock en una venta real
    public boolean restarStock(JTable tabla) throws Exception {
        int numFilas = tabla.getRowCount();
        try {
            for (int i = 0; i < numFilas; i++) {
                int id = Integer.parseInt(tabla.getValueAt(i, 0).toString());
                System.out.println("id: " + id);
                double cantidad = Double.parseDouble(tabla.getValueAt(i, 4).toString());
                System.out.println("cantidad: " + cantidad);
                ProductoPresentacionDAO pdao = new ProductoPresentacionDAO();
                double stock = getStockProductoPresentacion(id, 1) - cantidad;//-------
                System.out.println(stock);
                pdao.modificar(id, stock, 1);//tercer parametro 1 => ventas reales ; 2=>nota de pedido
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

    public double getStockProductoPresentacion(int idProducto, int caja) throws SQLException {
        Conexion con = new Conexion();
        String sql = "";
        switch (caja) {
            case 1://ventas reales
                sql = "SELECT productopresentacion.stock FROM\n"
                        + "producto\n"
                        + "INNER JOIN productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                        + "WHERE productopresentacion.idproductopresentacion =" + idProducto;
                break;
            case 2://nota pedido
                sql = "SELECT productopresentacion.stock2 FROM\n"
                        + "producto\n"
                        + "INNER JOIN productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                        + "WHERE productopresentacion.idproductopresentacion =" + idProducto;
                break;
        }

        try {
            con.conectar();
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return res.getDouble(1);
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
