/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.VentaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Gaby
 */
public class VentaDAO extends Conexion implements VentaCRUD {

    @Override
    public boolean registrar(Venta v) throws Exception {
        try {
            String sql = "insert into venta (idventa, fecha, hora, idusuario, idcliente, idcomprobante, estado, tipopago,noperacion ,idcaja, idflujocaja) values (?,?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, v.getIdVenta());
            pst.setString(2, v.getFecha());
            pst.setString(3, v.getHora());
            pst.setInt(4, v.getIdUsuario());
            pst.setInt(5, v.getIdCliente());
            pst.setInt(6, v.getIdComprobante());
            pst.setInt(7, v.getEstado());
            pst.setInt(8,v.getTipopago());
            pst.setString(9,v.getnOperacion());
            pst.setInt(10, v.getIdcaja());
            pst.setInt(11, v.idFlujoCaja);
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
    public boolean modificar(Venta v) throws Exception {
        try {
            String sql = "UPDATE venta SET fecha=?, hora=?, idusuario=?, idcliente=?, idcomprobante=?, estado=?, tipopago = ?,noperacion = ? ,idcaja = ? ,idflujocaja = ? WHERE idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7,v.getTipopago());
            pst.setString(8,v.getnOperacion());
            pst.setInt(9, v.getIdcaja());
            pst.setInt(10, v.idFlujoCaja);
            pst.setInt(11, v.getIdVenta());
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
    public boolean anular(int numVenta) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE venta SET estado = 0 WHERE idventa = "+numVenta+"";
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
    public List<Venta> listar() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from venta");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("idventa"));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdComprobante(rs.getInt("idcomprobante"));
                v.setEstado(rs.getInt("estado"));
                v.setTipopago(rs.getInt("tipopago"));
                v.setnOperacion(rs.getString("noperacion"));
                v.setIdcaja(rs.getInt("idcaja"));
                v.setIdFlujoCaja(rs.getInt("idflujocaja"));
                lista.add(v);
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
