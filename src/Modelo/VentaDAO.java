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
            String sql = "insert into venta (fecha, hora, idusuario, idcliente, idtipocomprobante, estado, tipopago,noperacion ,idcaja, idflujocaja) values (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdTipoComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getTipopago());
            pst.setString(8, v.getnOperacion());
            pst.setInt(9, v.getIdcaja());
            pst.setInt(10, v.getIdFlujoCaja());
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

    public boolean registrar2(Venta v) throws Exception {
        try {
            String sql = "insert into venta2 (fecha, hora, idusuario, idcliente, idtipocomprobante, estado, tipopago,noperacion ,idcaja, idflujocaja) values (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdTipoComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getTipopago());
            pst.setString(8, v.getnOperacion());
            pst.setInt(9, v.getIdcaja());
            pst.setInt(10, v.getIdFlujoCaja());
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

    public boolean registrar3(Venta v) throws Exception {
        try {
            String sql = "insert into venta3 (fecha, hora, idusuario, idcliente, idtipocomprobante, estado, tipopago,noperacion ,idcaja, idflujocaja) values (?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdTipoComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getTipopago());
            pst.setString(8, v.getnOperacion());
            pst.setInt(9, v.getIdcaja());
            pst.setInt(10, v.getIdFlujoCaja());
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
            String sql = "UPDATE venta SET fecha=?, hora=?, idusuario=?, idcliente=?, idtipocomprobante=?, estado=?, tipopago = ?,noperacion = ? ,idcaja = ? ,idflujocaja = ? WHERE idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdTipoComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getTipopago());
            pst.setString(8, v.getnOperacion());
            pst.setInt(9, v.getIdcaja());
            pst.setInt(10, v.getIdFlujoCaja());
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
            String sql = "UPDATE venta SET estado = 0 WHERE idventa = " + numVenta + "";
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
                v.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
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

    //listar con parametros para la venta2 y venta3
    public List<Venta> listar(Integer num) throws Exception {
        //System.out.println(num);
        List<Venta> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = null;
            String idventa = "idventa";
            switch (num) {
                case 1:
                    pst = this.conexion.prepareStatement("select * from venta");
                    idventa = "idventa";
                    break;
                case 2:
                    pst = this.conexion.prepareStatement("select * from venta2");
                    idventa = "idventa2";
                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select * from venta3");
                    idventa = "idventa3";
                    break;
                default:
                    pst = this.conexion.prepareStatement("select * from venta");
                    idventa = "idventa";
                    break;
            }
            //System.out.println(idventa);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt(idventa));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
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

    //ultima venta caja 1
    public int getIdUltimaVenta() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT  idventa FROM venta ORDER BY fechasistema DESC limit 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idventa");
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

    //ultima venta caja 2
    public int getIdUltimaVenta2() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT  idventa2 FROM venta2 ORDER BY fechasistema DESC limit 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idventa2");
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

    //ultima venta caja 3
    public int getIdUltimaVenta3() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT  idventa3 FROM venta3 ORDER BY fechasistema DESC limit 1");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getInt("idventa3");
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
}
