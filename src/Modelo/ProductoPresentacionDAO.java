/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.ProductoPresentacionCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class ProductoPresentacionDAO extends Conexion implements ProductoPresentacionCRUD{

    @Override
    public boolean registrar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = "insert into productopresentacion (idproducto, idcategoria, idpresentacion, idalmacen,stock, precio)VALUES (?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setDouble(2, pp.getIdcategoria());
            pst.setInt(3, pp.getIdPresentacion());
            pst.setInt(4, pp.getIdalmacen());
            pst.setInt(5, pp.getStock());            
            pst.setDouble(6, pp.getPrecio());
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
    public boolean modificar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = ("UPDATE productopresentacion set idproducto = ?, idpresentacion=?, idalmacen = ?, stock = ?,precio = ?, idcategoria = ? where idproductopresentacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setInt(4, pp.getStock());
            pst.setDouble(5, pp.getPrecio());
            pst.setDouble(6, pp.getIdcategoria());
            pst.setInt(7, pp.getIdProductoPresentacion());
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
    public boolean eliminar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = ("delete from productopresentacion where idproductopresentacion= ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProductoPresentacion());
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
    public List<ProductoPresentacion> listar() throws Exception {
        List<ProductoPresentacion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt("idproductopresentacion"));
                pp.setIdProducto(rs.getInt("idproducto"));
                pp.setIdPresentacion(rs.getInt("idpresentacion"));
                pp.setIdalmacen(rs.getInt("idalmacen"));
                pp.setStock(rs.getInt("stock"));
                pp.setPrecio(rs.getDouble("precio"));
                pp.setIdcategoria(rs.getInt("idcategoria"));
                lista.add(pp);
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
