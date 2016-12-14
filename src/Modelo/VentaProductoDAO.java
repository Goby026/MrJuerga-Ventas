
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
    
}
