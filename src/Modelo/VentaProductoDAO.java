package Modelo;

import Interfaces.VentaProductoCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VentaProductoDAO extends Conexion implements VentaProductoCRUD {

    @Override
    public boolean registrar(VentaProducto vp) throws Exception {
        try {
            String sql = "insert into ventaproducto (idproducto, idventa, preciou, cantidad, subtotal) values (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, vp.getIdProducto());
            pst.setInt(2, vp.getIdVenta());
            pst.setDouble(3, vp.getPrecio());
            pst.setInt(4, vp.getCantidad());
            pst.setDouble(5, vp.getSubtotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    public boolean registrar2(VentaProducto vp) throws Exception {
        try {
            String sql = "insert into ventaproducto2 (idproducto, idventa, preciou, cantidad, subtotal) values (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, vp.getIdProducto());
            pst.setInt(2, vp.getIdVenta());
            pst.setDouble(3, vp.getPrecio());
            pst.setInt(4, vp.getCantidad());
            pst.setDouble(5, vp.getSubtotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    public boolean registrar3(VentaProducto vp) throws Exception {
        try {
            String sql = "insert into ventaproducto3 (idproducto, idventa, preciou, cantidad, subtotal) values (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, vp.getIdProducto());
            pst.setInt(2, vp.getIdVenta());
            pst.setDouble(3, vp.getPrecio());
            pst.setInt(4, vp.getCantidad());
            pst.setDouble(5, vp.getSubtotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(VentaProducto vp) throws Exception {
        try {
            String sql = "update ventaproducto set idproducto=?, idventa=?, preciou=?, cantidad=?, subtotal=? where idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, vp.getIdProducto());
            pst.setInt(2, vp.getIdVenta());
            pst.setDouble(3, vp.getPrecio());
            pst.setInt(4, vp.getCantidad());
            pst.setDouble(5, vp.getSubtotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean anular(VentaProducto vp) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE ventaproducto SET cantidad = 0, subtotal = 0 WHERE idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, vp.getIdVenta());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<VentaProducto> listar() throws Exception {
        List<VentaProducto> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from ventaproducto");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                VentaProducto vp = new VentaProducto();
                vp.setId(rs.getInt("id"));
                vp.setIdProducto(rs.getInt("idproducto"));
                vp.setIdVenta(rs.getInt("idventa"));
                vp.setPrecio(rs.getDouble("preciou"));
                vp.setCantidad(rs.getInt("cantidad"));
                vp.setSubtotal(rs.getDouble("subtotal"));
                lista.add(vp);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public double getMontoDeVenta(int numVenta, int num) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = null;
            switch (num) {
                case 1:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from ventaproducto where idventa = " + numVenta + "");
                    break;
                case 2:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from ventaproducto2 where idventa = " + numVenta + "");
                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from ventaproducto3 where idventa = " + numVenta + "");
                    break;
            }

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getDouble("sum(subtotal)");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    public List<DatosAnulacion> getDatosTabla(int numVenta, Integer num, Integer idAlmacen) throws Exception {
        try {
            List<DatosAnulacion> lista = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            this.conectar();
            switch (num) {
                case 1:
                    pst = this.conexion.prepareStatement("SELECT productopresentacion.idproductopresentacion, producto.nombre, presentacion.descripcion,productopresentacion.precio, ventaproducto.cantidad, ventaproducto.subtotal\n"
                            + "from venta\n"
                            + "inner join ventaproducto on ventaproducto.idventa = venta.idventa\n"
                            + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "WHERE venta.idventa = " + numVenta + " and productopresentacion.idalmacen = " + idAlmacen);
                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setIdProductoPresentacion(rs.getInt(1));
                        da.setProducto(rs.getString(2));
                        da.setPresentacion(rs.getString(3));
                        da.setPrecio(rs.getDouble(4));
                        da.setCantidad(rs.getInt(5));
                        da.setSubtotal(rs.getDouble(6));
                        lista.add(da);
                        //model_diario.addRow(datos);
                    }
                    //tbl_diario.setModel(model_diario);    
                    break;
                case 2:
                    pst = this.conexion.prepareStatement("SELECT productopresentacion.idproductopresentacion, producto.nombre, presentacion.descripcion,productopresentacion.precio, ventaproducto2.cantidad, ventaproducto2.subtotal\n"
                            + "from venta2\n"
                            + "inner join ventaproducto2 on ventaproducto2.idventa = venta2.idventa2\n"
                            + "inner join producto on ventaproducto2.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "WHERE venta2.idventa2 = " + numVenta + " and productopresentacion.idalmacen = " + idAlmacen);

                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setIdProductoPresentacion(rs.getInt(1));
                        da.setProducto(rs.getString(2));
                        da.setPresentacion(rs.getString(3));
                        da.setPrecio(rs.getDouble(4));
                        da.setCantidad(rs.getInt(5));
                        da.setSubtotal(rs.getDouble(6));
                        lista.add(da);
                        //model_diario.addRow(datos);
                    }
                    //tbl_diario.setModel(model_diario);            

                    break;
                case 3:
                    pst = this.conexion.prepareStatement("SELECT productopresentacion.idproductopresentacion, producto.nombre, presentacion.descripcion,productopresentacion.precio, ventaproducto3.cantidad, ventaproducto3.subtotal\n"
                            + "from venta3\n"
                            + "inner join ventaproducto3 on ventaproducto3.idventa = venta3.idventa3\n"
                            + "inner join producto on ventaproducto3.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "WHERE venta3.idventa3 = " + numVenta + " and productopresentacion.idalmacen = " + idAlmacen);
                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setIdProductoPresentacion(rs.getInt(1));
                        da.setProducto(rs.getString(2));
                        da.setPresentacion(rs.getString(3));
                        da.setPrecio(rs.getDouble(4));
                        da.setCantidad(rs.getInt(5));
                        da.setSubtotal(rs.getDouble(6));
                        lista.add(da);
                        //model_diario.addRow(datos);
                    }
                    //tbl_diario.setModel(model_diario);     
                    break;
            }

            rs.close();
            pst.close();
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    public boolean sumarStock(int idProdPresentacion, double cant, int tipoVenta) throws Exception {
        //tipoVenta ==> 1= venta Real; 2= venta nota pedido
        String stock = "stock";
        if (tipoVenta == 2) {
            stock = "stock2";
        }
        
        String sql = "UPDATE `productopresentacion` SET "+stock+"=" + cant + " WHERE `idproductopresentacion`=" + idProdPresentacion + "";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    /* ACTUALIZAR LOS DETALLES DE VENTA CUANDO SE ANULE UNA VENTA */
    public boolean updateVentaProducto(int idVenta, Integer num) throws Exception {
        String sql = null;
        switch (num) {
            case 1:
                sql = "UPDATE `ventaproducto` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
                break;
            case 2:
                sql = "UPDATE `ventaproducto2` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
                break;
            case 3:
                sql = "UPDATE `ventaproducto3` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
                break;
            default:
                break;
        }
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    /* ACTUALIZAR LOS MONTOS DE OPERACION CUANDO SE ANULE UNA VENTA CON OPERACION COMBINADA */
    public boolean updateVentaProductoOP(int idventa, Integer num) throws Exception {
        String sql = null;
        switch (num) {
            case 1:
                sql = "UPDATE `operacion` SET `monto`='0' WHERE `idventa`=" + idventa + "";
                break;
            case 2:
                sql = "UPDATE `operacion2` SET `monto`='0' WHERE `idventa2`=" + idventa + "";
                break;
            case 3:
                sql = "UPDATE `operacion3` SET `monto`='0' WHERE `idventa3`=" + idventa + "";
                break;
            default:
                break;
        }
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
}
