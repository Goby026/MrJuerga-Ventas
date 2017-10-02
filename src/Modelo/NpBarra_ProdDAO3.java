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
public class NpBarra_ProdDAO3 extends Conexion implements NpBarraProdCRUD<NpBarra_Prod3>{

    @Override
    public boolean registrar(NpBarra_Prod3 pp) throws Exception {
        try {
            String sql = "insert into npbarra_prod3 (idproductopresentacion, idnpbarra3, preciou, cantidad, subtotal) values (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProductoPresentacion());
            pst.setInt(2, pp.getIdNpBarra());
            pst.setDouble(3, pp.getPrecioU());
            pst.setDouble(4, pp.getCantidad());
            pst.setDouble(5, pp.getSubtotal());
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
    public boolean modificar(NpBarra_Prod3 pp) throws Exception {
        return false;
    }

    @Override
    public boolean anular(int id) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE npbarra_prod3 SET cantidad = 0, subtotal = 0 WHERE idnpbarra_prod3 = ?";
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

    @Override
    public List<NpBarra_Prod3> listar() throws Exception {
        List<NpBarra_Prod3> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from npbarra_prod3");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                NpBarra_Prod3 vp = new NpBarra_Prod3();
                vp.setIdNpBarraProd3(rs.getInt("idnpbarra_prod3"));
                vp.setIdProductoPresentacion(rs.getInt("idproductopresentacion"));
                vp.setIdNpBarra(rs.getInt("idnpbarra3"));
                vp.setPrecioU(rs.getDouble("preciou"));
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
