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
public class ProductoPresentacionDAO extends Conexion implements ProductoPresentacionCRUD {

    @Override
    public boolean registrar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = "insert into productopresentacion (idproducto, idpresentacion, idalmacen,stock,stock2,stock3, precio, precio2, idcategoria)VALUES (?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setInt(4, pp.getStock());
            pst.setInt(5, pp.getStock2());
            pst.setInt(6, pp.getStock3());
            pst.setDouble(7, pp.getPrecio());
            pst.setDouble(8, pp.getPrecio2());
            pst.setDouble(9, pp.getIdcategoria());
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
            String sql = ("UPDATE productopresentacion set idproducto = ?, idpresentacion=?, idalmacen = ?, stock = ?,stock2 = ?,stock3 = ?,precio = ?,precio2 = ?, idcategoria = ? where idproductopresentacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setInt(4, pp.getStock());
            pst.setInt(5, pp.getStock2());
            pst.setInt(6, pp.getStock3());
            pst.setDouble(7, pp.getPrecio());
            pst.setDouble(8, pp.getPrecio2());
            pst.setDouble(9, pp.getIdcategoria());
            pst.setInt(10, pp.getIdProductoPresentacion());

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

    public boolean modificar(int idProductoPresentacion,int stock ,int opc) throws Exception {
        try {
            String sql = "";
            switch (opc) {
                case 1://modificar stock ventas reales
                    sql = "UPDATE productopresentacion set stock = "+stock+" where idproductopresentacion=" + idProductoPresentacion;
                    break;
                case 2://modificar stock notas de pedido
                    sql = "UPDATE productopresentacion set stock2 = "+stock+" where idproductopresentacion=" + idProductoPresentacion;
                    break;
            }
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);

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
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getInt(5));
                pp.setStock2(rs.getInt(6));
                pp.setStock3(rs.getInt(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
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

    public List<ProductoPresentacion> listar(int idAlmacen) throws Exception {
        List<ProductoPresentacion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion WHERE idalmacen = ? AND estado = 1");
            pst.setInt(1, idAlmacen);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getInt(5));
                pp.setStock2(rs.getInt(6));
                pp.setStock3(rs.getInt(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
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
    
    public ProductoPresentacion obtener(int id) throws Exception{
        ProductoPresentacion pp=null;
        try {
            this.conectar();
            String sql = "SELECT * FROM productopresentacion WHERE idproductopresentacion = "+id;
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(res.getInt(1));
                pp.setIdProducto(res.getInt(2));
                pp.setIdPresentacion(res.getInt(3));
                pp.setIdalmacen(res.getInt(4));
                pp.setStock(res.getInt(5));
                pp.setStock2(res.getInt(6));
                pp.setStock3(res.getInt(7));
                pp.setPrecio(res.getInt(8));
                pp.setPrecio2(res.getInt(9));
                pp.setIdcategoria(res.getInt(10));
            }
            
            res.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return pp;
    }
    
    /*obtener productopresentaicon a partir de un producto y su almacen*/
    public ProductoPresentacion obtener(int idproducto,int idalmacen) throws Exception{
        ProductoPresentacion pp=null;
        try {
            this.conectar();
            String sql = "SELECT * FROM productopresentacion WHERE idproducto = "+idproducto+" AND idalmacen = "+idalmacen;
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(res.getInt(1));
                pp.setIdProducto(res.getInt(2));
                pp.setIdPresentacion(res.getInt(3));
                pp.setIdalmacen(res.getInt(4));
                pp.setStock(res.getInt(5));
                pp.setStock2(res.getInt(6));
                pp.setStock3(res.getInt(7));
                pp.setPrecio(res.getInt(8));
                pp.setPrecio2(res.getInt(9));
                pp.setIdcategoria(res.getInt(10));
            }
            
            res.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return pp;
    }

}
