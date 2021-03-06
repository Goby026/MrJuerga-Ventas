/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class CajaDAO extends Conexion implements DAO<Caja> {

    @Override
    public boolean Registrar(Caja c) throws Exception {
        try {
            String sql = "INSERT INTO caja(nomcaja)VALUE (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNomCaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Caja c) throws Exception {
        try {
            String sql = ("UPDATE caja set nomcaja = ? where idcaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNomCaja());
            pst.setInt(2, c.getIdCaja());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        try {            
            String sql = ("delete from caja where idcaja=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);

            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Caja> Listar() throws Exception {
        List<Caja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM caja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Caja c = new Caja();
                c.setIdCaja(res.getInt("idcaja"));
                c.setNomCaja(res.getString("nomcaja"));
                lista.add(c);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Caja Obtener(int id) throws Exception {
        Caja c = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM caja WHERE idcaja = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                c = new Caja();
                c.setIdCaja(res.getInt("idcaja"));
                c.setNomCaja(res.getString("nomcaja"));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return c;
    }

}
