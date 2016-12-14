/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.PresentacionesCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class PresentacionDAO extends Conexion implements PresentacionesCRUD {

    @Override
    public boolean Registrar(Presentacion p) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO presentacion(descripcion,codPresentacion) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            pst.setString(2, p.getCodPresentacion());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Presentacion p) throws Exception {
        boolean b = false;

        try {
            String sql = "UPDATE presentacion SET descripcion = ?,codPresentacion = ? WHERE idPresentacion = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            pst.setString(2, p.getCodPresentacion());
            pst.setInt(3, p.getIdPresentacion());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Eliminar(Presentacion p) throws Exception {
        boolean b = false;

        try {
            String sql = "DELETE FROM presentacion WHERE idPresentacion = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdPresentacion());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
        
    }

    @Override
    public List<Presentacion> Listar() throws Exception {
         List<Presentacion> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM presentacion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                 Presentacion p = new Presentacion();
                p.setIdPresentacion(res.getInt("idPresentacion"));
                p.setDescripcion(res.getString("descripcion"));
                p.setCodPresentacion(res.getString("codPresentacion"));
                li.add(p);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return li;
       
    }

}
