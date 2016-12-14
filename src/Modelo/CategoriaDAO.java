/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.CategoriaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class CategoriaDAO extends Conexion implements CategoriaCRUD{

    @Override
    public boolean Registrar(Categoria ca) throws Exception {
    try {
            String sql = "INSERT INTO categoria(descripcion,codcategoria)VALUE (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, ca.getDescripcion());
            pst.setString(2, ca.getCodcategoria());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
        this.cerrar();
    }
        return false;    
    }

    @Override
    public boolean Modificar(Categoria ca) throws Exception {
    try {
            String sql = ("UPDATE categoria set descripcion = ?, codcategoria=? where idcategoria=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, ca.getDescripcion());
            pst.setString(2, ca.getCodcategoria());
            pst.setInt(3, ca.getIdcategoria());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
pst.close();
        } catch (Exception e) {
            e.getMessage();
        }finally{
        this.cerrar();
    }
        return false;    
    }

    @Override
    public void Eliminar(Categoria ca) throws Exception {
        try {
            boolean b = false;
            String sql = ("delete from categoria where idcategoria=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ca.getIdcategoria());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
pst.close();
        } catch (Exception e) {
            e.getMessage();
        }finally{
            this.cerrar();
        }
    }

    @Override
    public List<Categoria> Listar() throws Exception {
    List<Categoria> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Categoria cat = new Categoria();
                cat.setIdcategoria(res.getInt("idcategoria"));
                cat.setDescripcion(res.getString("descripcion"));
                cat.setCodcategoria(res.getString("Codcategoria"));
                li.add(cat);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }
        return li;    
    }
    
}
