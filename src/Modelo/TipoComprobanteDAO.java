/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.TipoComprobanteCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class TipoComprobanteDAO extends Conexion implements TipoComprobanteCRUD {

    @Override
    public boolean Registrar(TipoComprobante tc) throws Exception {
        try {
            String sql = "INSERT INTO tipocomprobante(descripcion)VALUE (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, tc.getDescripcion());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(TipoComprobante tc) throws Exception {
        try {
            String sql = ("UPDATE tipocomprobante set descripcion = ? where idtipocomprobante=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, tc.getDescripcion());
            pst.setInt(2, tc.getIdtipocomprobante());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public void Eliminar(TipoComprobante tc) throws Exception {
        try {
            boolean b = false;
            String sql = ("delete from tipocomprobante where idtipocomprbante=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, tc.getIdtipocomprobante());

            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<TipoComprobante> Listar() throws Exception {
        List<TipoComprobante> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM tipocomprobante");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                TipoComprobante tc = new TipoComprobante();
                tc.setIdtipocomprobante(res.getInt("idtipocomprobante"));
                tc.setDescripcion(res.getString("descripcion"));

                li.add(tc);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            this.cerrar();
        }
        return li;
    }

}
