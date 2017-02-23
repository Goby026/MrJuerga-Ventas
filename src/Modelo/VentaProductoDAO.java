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

    public double getMontoDeVenta(int numVenta) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(subtotal) from ventaproducto where idventa = " + numVenta + "");
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

    public List<DatosAnulacion> getDatosTabla(int numVenta, Integer num) throws Exception {
        try {
            List<DatosAnulacion> lista = null;
            PreparedStatement pst = null;
            ResultSet rs = null;
            this.conectar();
            switch (num) {
                case 2:
                    pst = this.conexion.prepareStatement("select producto.nombre,presentacion.descripcion ,productopresentacion.precio, ventaproducto2.cantidad, ventaproducto2.subtotal from caja\n"
                            + "inner join usuariocaja on caja.idcaja = usuariocaja.idcaja\n"
                            + "inner join usuario on usuariocaja.idusuario = usuario.idusuario\n"
                            + "inner join venta2 on usuario.idusuario = venta2.idusuario\n"
                            + "inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa\n"
                            + "inner join producto on ventaproducto2.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "where venta2.idventa2 = " + numVenta + "");

                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setProducto(rs.getString("producto.nombre"));
                        da.setPresentacion(rs.getString("presentacion.descripcion"));
                        da.setPrecio(rs.getDouble("productopresentacion.precio"));
                        da.setCantidad(rs.getInt("ventaproducto.cantidad"));
                        da.setSubtotal(rs.getDouble("ventaproducto.subtotal"));
                        lista.add(da);
                        //model_diario.addRow(datos);
                    }
                    //tbl_diario.setModel(model_diario);            

                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select producto.nombre,presentacion.descripcion ,productopresentacion.precio, ventaproducto3.cantidad, ventaproducto3.subtotal from caja\n"
                            + "inner join usuariocaja on caja.idcaja = usuariocaja.idcaja\n"
                            + "inner join usuario on usuariocaja.idusuario = usuario.idusuario\n"
                            + "inner join venta3 on usuario.idusuario = venta3.idusuario\n"
                            + "inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa\n"
                            + "inner join producto on ventaproducto3.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "where venta3.idventa3 = " + numVenta + "");
                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setProducto(rs.getString("producto.nombre"));
                        da.setPresentacion(rs.getString("presentacion.descripcion"));
                        da.setPrecio(rs.getDouble("productopresentacion.precio"));
                        da.setCantidad(rs.getInt("ventaproducto.cantidad"));
                        da.setSubtotal(rs.getDouble("ventaproducto.subtotal"));
                        lista.add(da);
                        //model_diario.addRow(datos);
                    }
                    //tbl_diario.setModel(model_diario);     
                    break;
                default:
                    pst = this.conexion.prepareStatement("select producto.nombre,presentacion.descripcion ,productopresentacion.precio, ventaproducto.cantidad, ventaproducto.subtotal from caja\n"
                            + "inner join usuariocaja on caja.idcaja = usuariocaja.idcaja\n"
                            + "inner join usuario on usuariocaja.idusuario = usuario.idusuario\n"
                            + "inner join venta on usuario.idusuario = venta.idusuario\n"
                            + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                            + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                            + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                            + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "where venta.idventa = " + numVenta + "");
                    lista = new ArrayList();
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        DatosAnulacion da = new DatosAnulacion();
                        da.setProducto(rs.getString("producto.nombre"));
                        da.setPresentacion(rs.getString("presentacion.descripcion"));
                        da.setPrecio(rs.getDouble("productopresentacion.precio"));
                        da.setCantidad(rs.getInt("ventaproducto.cantidad"));
                        da.setSubtotal(rs.getDouble("ventaproducto.subtotal"));
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

    public boolean sumarStock(int idProdPresentacion, int stock) throws Exception {
        String sql = "UPDATE `mrjuerga`.`productopresentacion` SET `stock`=" + stock + " WHERE `idproductopresentacion`=" + idProdPresentacion + "";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public boolean updateVentaProducto(int idVenta, Integer num) throws Exception {
        String sql = null;
        switch (num) {
            case 2:
                sql = "UPDATE `mrjuerga`.`ventaproducto2` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
                break;
            case 3:
                sql = "UPDATE `mrjuerga`.`ventaproducto3` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
                break;
            default:
                sql = "UPDATE `mrjuerga`.`ventaproducto` SET `cantidad`='0', `subtotal`='0' WHERE `idventa`=" + idVenta + "";
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
        }
        return false;
    }
}
