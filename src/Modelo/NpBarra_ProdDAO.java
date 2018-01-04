/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.NpBarraProdCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class NpBarra_ProdDAO extends Conexion implements NpBarraProdCRUD<NpBarra_Prod> {

    @Override
    public boolean registrar(NpBarra_Prod pp) throws Exception {
        try {
            String sql = "insert into npbarra_prod (idproductopresentacion, idnpbarra, preciou, cantidad, subtotal, complemento) values (?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProductoPresentacion());
            pst.setInt(2, pp.getIdNpBarra());
            pst.setDouble(3, pp.getPrecioU());
            pst.setDouble(4, pp.getCantidad());
            pst.setDouble(5, pp.getSubtotal());
            pst.setInt(6, pp.getComplemento());
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
    public boolean modificar(NpBarra_Prod pp) throws Exception {
        return false;
    }

    @Override
    public boolean anular(int id) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE npbarra_prod SET cantidad = 0, subtotal = 0, complemento = 0 WHERE idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
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
    
    public boolean AnularNP(int id, int idCaja) throws Exception {
        try {
            this.conectar();
            //estado 0=anulado - 1=activo
            String sql = "";
            switch(idCaja){
                case 1:
                    sql = "UPDATE npbarra_prod SET cantidad = 0, subtotal = 0, complemento = 0 WHERE idnpbarra = ?";
                    break;
                case 2:
                    sql = "UPDATE npbarra_prod2 SET cantidad = 0, subtotal = 0, complemento = 0 WHERE idnpbarra2 = ?";
                    break;
                case 3:
                    sql = "UPDATE npbarra_prod3 SET cantidad = 0, subtotal = 0, complemento = 0 WHERE idnpbarra3 = ?";
                    break;
            }
            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
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
    public List<NpBarra_Prod> listar() throws Exception {
        List<NpBarra_Prod> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from npbarra_prod");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NpBarra_Prod vp = new NpBarra_Prod();
                vp.setIdNpBarraProd(rs.getInt("idnpbarra_prod"));
                vp.setIdProductoPresentacion(rs.getInt("idproductopresentacion"));
                vp.setIdNpBarra(rs.getInt("idnpbarra"));
                vp.setPrecioU(rs.getDouble("preciou"));
                vp.setCantidad(rs.getDouble("cantidad"));
                vp.setSubtotal(rs.getDouble("subtotal"));
                vp.setComplemento(rs.getInt("complemento"));
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

    //metodo para obtener todas los detalles a partir de una nota de pedido
    public List<NpBarra_Prod> listar(int idNp) throws Exception {
        List<NpBarra_Prod> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from npbarra_prod where idnpbarra_prod = ?");
            pst.setInt(1, idNp);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NpBarra_Prod vp = new NpBarra_Prod();
                vp.setIdNpBarraProd(rs.getInt("idnpbarra_prod"));
                vp.setIdProductoPresentacion(rs.getInt("idproductopresentacion"));
                vp.setIdNpBarra(rs.getInt("idnpbarra"));
                vp.setPrecioU(rs.getDouble("preciou"));
                vp.setCantidad(rs.getDouble("cantidad"));
                vp.setSubtotal(rs.getDouble("subtotal"));
                vp.setComplemento(rs.getInt("complemento"));
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

    //metodo para obtener los datos de nota de pedido de la tabla de la interfaz de anulaciones
    public List<DatosAnulacion> ListarNP(int idNp, int idCaja) throws Exception {
        List<DatosAnulacion> lista = null;
        try {
            this.conectar();
            String sql = "";
            switch (idCaja) {
                case 1:
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, np.preciou, np.cantidad, np.subtotal\n"
                            + "from npbarra n\n"
                            + "inner join npbarra_prod np on n.idnpbarra = np.idnpbarra\n"
                            + "inner join productopresentacion pp on np.idProductopresentacion = pp.idproductopresentacion\n"
                            + "inner join producto p on pp.idproducto = p.idproducto\n"
                            + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "where n.idnpbarra = ?";
                    break;
                case 2:
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, np.preciou, np.cantidad, np.subtotal\n"
                            + "	from npbarra2 n\n"
                            + "	inner join npbarra_prod2 np on n.idnpbarra2 = np.idnpbarra2\n"
                            + "	inner join productopresentacion pp on np.idProductopresentacion = pp.idproductopresentacion\n"
                            + "	inner join producto p on pp.idproducto = p.idproducto\n"
                            + "	inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "	where n.idnpbarra2";
                    break;
                case 3:
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, np.preciou, np.cantidad, np.subtotal\n"
                            + "	from npbarra3 n\n"
                            + "	inner join npbarra_prod3 np on n.idnpbarra3 = np.idnpbarra3\n"
                            + "	inner join productopresentacion pp on np.idProductopresentacion = pp.idproductopresentacion\n"
                            + "	inner join producto p on pp.idproducto = p.idproducto\n"
                            + "	inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "	where n.idnpbarra3 =";
                    break;
            }

            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, idNp);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                DatosAnulacion da = new DatosAnulacion();
                da.setIdProductoPresentacion(rs.getInt(1));
                da.setProducto(rs.getString(2));
                da.setPresentacion(rs.getString(3));
                da.setPrecio(rs.getDouble(4));
                da.setCantidad(rs.getInt(5));
                da.setSubtotal(rs.getDouble(6));
                lista.add(da);
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
    
    /* ACTUALIZAR LOS MONTOS DE OPERACION CUANDO SE ANULE UNA NOTA DE PEDIDO CON OPERACION COMBINADA */
    public boolean updateNpProductoOP(int idNotaPedido, Integer num) throws Exception {
        String sql = null;
        switch (num) {
            case 1:
                sql = "UPDATE `operacion_np` SET `monto`='0' WHERE `idoperacion_np`=" + idNotaPedido + "";
                break;
            case 2:
                sql = "UPDATE `operacion_np2` SET `monto`='0' WHERE `idoperacion_np2`=" + idNotaPedido + "";
                break;
            case 3:
                sql = "UPDATE `operacion_np3` SET `monto`='0' WHERE `idoperacion_np3`=" + idNotaPedido + "";
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
