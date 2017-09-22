package Modelo;

import Interfaces.FlujoCajaCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class FlujoCajaDAO extends Conexion implements FlujoCajaCRUD {

    @Override
    public boolean Registrar(FlujoCaja fc) throws Exception {
        try {
            String sql = "INSERT INTO flujocaja(fecha_inicio,hora_inicio,fecha_final, hora_final,ingresos,egresos,saldo,visa,master,jarras,descuadre,idusuario,idcaja, estado)VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setDouble(8, fc.getVisa());
            pst.setDouble(9, fc.getMaster());
            pst.setDouble(10, fc.getJarras());
            pst.setDouble(11, fc.getDescuadre());
            pst.setInt(12, fc.getIdUsuario());
            pst.setInt(13, fc.getIdCaja());
            pst.setString(14, fc.getEstado());
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
    public boolean Modificar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("UPDATE caja flujocaja SET fecha_inicio = ?,hora_inicio=?,fecha_final=? ,hora_final=? ,ingresos = ?, egresos = ?, saldo = ?,visa=?,master=?,jarras=?,descuadre = ? ,idusuario = ?, idcaja = ?, estado= ? WHERE idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFechaInicio());
            pst.setString(2, fc.getHoraInicio());
            pst.setString(3, fc.getFechaFinal());
            pst.setString(4, fc.getHoraFinal());
            pst.setDouble(5, fc.getIngresos());
            pst.setDouble(6, fc.getEgresos());
            pst.setDouble(7, fc.getSaldo());
            pst.setDouble(8, fc.getVisa());
            pst.setDouble(9, fc.getMaster());
            pst.setDouble(10, fc.getJarras());
            pst.setDouble(11, fc.getDescuadre());
            pst.setInt(12, fc.getIdUsuario());
            pst.setInt(13, fc.getIdCaja());
            pst.setString(14, fc.getEstado());
            pst.setInt(15, fc.getIdFlujoCaja());
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
    public boolean Eliminar(FlujoCaja fc) throws Exception {
        try {
            String sql = ("delete from flujocaja where idflujocaja = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, fc.getIdFlujoCaja());
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
    public List<FlujoCaja> Listar() throws Exception {
        List<FlujoCaja> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FlujoCaja fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));
                fc.setFechaInicio(res.getString("fecha_inicio"));
                fc.setHoraInicio(res.getString("hora_inicio"));
                fc.setFechaFinal(res.getString("fecha_final"));
                fc.setHoraFinal(res.getString("hora_final"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setVisa(res.getDouble("visa"));
                fc.setMaster(res.getDouble("master"));
                fc.setJarras(res.getDouble("jarras"));
                fc.setDescuadre(res.getDouble("descuadre"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                fc.setEstado(res.getString("estado"));
                lista.add(fc);
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

    /* METODO PARA OBTENER EL ID DE FLUJO DE CAJA PARA LA VALIDACION  */
    public int getIdFlujo(int idUsuario, int idCaja) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idflujocaja) FROM flujocaja where idusuario= " + idUsuario + " and idcaja=" + idCaja + " and estado = 1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt("MAX(idflujocaja)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    /* METODO PARA OBTENER EL ID DE FLUJO DE CAJA PARA VALIDAR EL LOGIN CUANDO YA SELECCIONO UNA CAJA */
    public int getEstadoConFecha(int idUsuario, String fecha) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select MAX(estado) from flujocaja where fecha_inicio = '" + fecha + "' and idusuario = " + idUsuario + "");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt("MAX(estado)");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
    /* OBTENER EL ID DE FLUJO DE CAJA CON USUARIO*/
    public int getEstadoConFecha(int idUsuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select MAX(estado) from flujocaja where idusuario = " + idUsuario + " AND estado = 1");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt("MAX(estado)");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    /* METODO PARA OBTENER LA FECHA DE UN DETERMINADO FLUJO DE CAJA */
    public String getFechaDeMaxIdFlujoDeUsuario(int idUsuario) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(fecha_inicio) FROM flujocaja where idusuario=" + idUsuario + "");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getString("MAX(fecha_inicio)");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return null;
    }

    /* monto total del flujo de caja */
    public double getMontoFlujo(int idFlujoCaja, int tipoPago, int numCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            //PreparedStatement pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 1 OR tipopago = 2 OR tipopago = 3 OR tipopago = 4");            
            PreparedStatement pst = null;
            switch (numCaja) {
                case 1:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and venta.tipopago = 1");
                    break;
                case 2:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta2 inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa where venta2.idflujocaja = " + idFlujoCaja + " and venta2.tipopago = 1");
                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta3 inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa where venta3.idflujocaja = " + idFlujoCaja + " and venta3.tipopago = 1");
                    break;
                default:
                    break;
            }
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(subtotal)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

//    public double getMontoNotaPedido(int idFlujoCaja) throws Exception {
//        double monto = 0.0;
//        try {
//            this.conectar();
//            //PreparedStatement pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 1 OR tipopago = 2 OR tipopago = 3 OR tipopago = 4");            
//            PreparedStatement pst = null;
//            pst = this.conexion.prepareStatement("select sum(operacion_np.monto) + (select sum(npbarra_prod.subtotal)\n"
//                    + "from npbarra\n"
//                    + "inner join npbarra_prod on npbarra.idnpbarra = npbarra_prod.idnpbarra\n"
//                    + "where npbarra.idflujocaja = " + idFlujoCaja + ")\n"
//                    + "from npbarra\n"
//                    + "inner join operacion_np on npbarra.idnpbarra = operacion_np.idnpbarra\n"
//                    + "where npbarra.idflujocaja = " + idFlujoCaja + "");
//            ResultSet res = pst.executeQuery();
//            while (res.next()) {
//                monto = res.getDouble(1);
//            }
//            pst.close();
//            res.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return monto;
//    }

    /* METODO PARA OBTENER EL MONTO VISA DESDE QUE SE APERTURA LA CAJA */
    public double getMontoVISA(int idFlujoCaja, int numCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            PreparedStatement pst = null;
            switch (numCaja) {
                case 1:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 3");
                    break;
                case 2:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta2 inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa where venta2.idflujocaja = " + idFlujoCaja + " and tipopago = 3");
                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta3 inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa where venta3.idflujocaja = " + idFlujoCaja + " and tipopago = 3");
                    break;
                default:

                    break;
            }

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(subtotal)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA OBTENER EL MONTO MASTERCARD DESDE QUE SE APERTURA LA CAJA */
    public double getMontoMASTER(int idFlujoCaja, int numCaja) throws Exception {
        double monto = 0.0;
        try {
            this.conectar();
            PreparedStatement pst = null;
            switch (numCaja) {
                case 2:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta2 inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa where venta2.idflujocaja = " + idFlujoCaja + " and tipopago = 2");
                    break;
                case 3:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta3 inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa where venta3.idflujocaja = " + idFlujoCaja + " and tipopago = 2");
                    break;
                default:
                    pst = this.conexion.prepareStatement("select sum(subtotal) from venta inner join ventaproducto on venta.idventa = ventaproducto.idventa where venta.idflujocaja = " + idFlujoCaja + " and tipopago = 2");
                    break;
            }
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                monto = res.getDouble("sum(subtotal)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* obtener el monto de visa,master o efectivo con operaciones combinadas */
    public double getMontosOpReales(int opc, int idFlujoCaja, int numCaja) throws Exception {
        double monto = -1;
        String operacion = null;
        String venta = null;
        String idventa = null;

        PreparedStatement pst = null;
        try {
            this.conectar();

            switch (numCaja) {

                case 1:
                    operacion = "operacion";
                    venta = "venta";
                    idventa = "idventa";
                    break;
                case 2:
                    operacion = "operacion2";
                    venta = "venta2";
                    idventa = "idventa2";
                    break;
                case 3:
                    operacion = "operacion3";
                    venta = "venta3";
                    idventa = "idventa3";
                    break;
            }

            switch (opc) {
                case 1: //obtener monto visa
                    pst = this.conexion.prepareStatement("select sum(monto)\n"
                            + "from " + venta + "\n"
                            + "inner join " + operacion + " on " + venta + "." + idventa + " = " + operacion + "." + idventa + "\n"
                            + "where " + venta + ".idflujocaja = " + idFlujoCaja + " and tarjeta = 'VISA'");
                    break;
                case 2://obtener monto master
                    pst = this.conexion.prepareStatement("select sum(monto)\n"
                            + "from " + venta + "\n"
                            + "inner join " + operacion + " on " + venta + "." + idventa + " = " + operacion + "." + idventa + "\n"
                            + "where " + venta + ".idflujocaja = " + idFlujoCaja + " and tarjeta = 'MASTERCARD'");
                    break;
                case 3://obtener monto efectivo
                    pst = this.conexion.prepareStatement("select sum(monto)\n"
                            + "from " + venta + "\n"
                            + "inner join " + operacion + " on " + venta + "." + idventa + " = " + operacion + "." + idventa + "\n"
                            + "where " + venta + ".idflujocaja = " + idFlujoCaja + " and tarjeta = 'EFECTIVO'");
                    break;
            }

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                monto = res.getDouble("sum(monto)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* obtener el monto de visa,master o efectivo con NOTAS DE PEDIDO */
    public double getMontosNotaPedido(int opc, int idFlujoCaja, int caja) throws Exception {
        double monto = -1;
        String tabla = "";        
        String tablaDetalle = "";
        String idnpBarra = "";
        switch(caja){
            case 1:
                tabla = "npbarra";
                tablaDetalle = "npbarra_prod";
                idnpBarra ="idnpbarra";
                break;
            case 2:
                tabla = "npbarra2";
                tablaDetalle = "npbarra_prod2";
                idnpBarra ="idnpbarra2";
                break;
            case 3:
                tabla = "npbarra3";
                tablaDetalle = "npbarra_prod3";
                idnpBarra ="idnpbarra3";
                break;
        }

        PreparedStatement pst = null;
        try {
            this.conectar();
            switch (opc) {
                case 1: //obtener monto visa
//                    pst = this.conexion.prepareStatement("select sum(operacion_np.monto) + (select sum(npbarra_prod.subtotal)\n"
//                            + "from npbarra\n"
//                            + "inner join npbarra_prod on npbarra.idnpbarra = npbarra_prod.idnpbarra\n"
//                            + "where npbarra.idflujocaja = " + idFlujoCaja + " and npbarra.tipopago = 3)\n"
//                            + "from npbarra\n"
//                            + "inner join operacion_np on npbarra.idnpbarra = operacion_np.idnpbarra\n"
//                            + "where npbarra.idflujocaja = " + idFlujoCaja + " and operacion_np.tarjeta = \"VISA\"");
                    pst = this.conexion.prepareStatement("SELECT sum(subtotal)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".tipopago = 3 and "+tabla+".idflujocaja = '" + idFlujoCaja + "'");
                    break;
                case 2://obtener monto master
                    pst = this.conexion.prepareStatement("SELECT sum(subtotal)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".tipopago = 2 and "+tabla+".idflujocaja = '" + idFlujoCaja + "'");
                    break;
                case 3://obtener monto efectivo
                    pst = this.conexion.prepareStatement("SELECT sum(subtotal)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".tipopago = 1 and "+tabla+".idflujocaja = '" + idFlujoCaja + "'");
                    break;
            }

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                monto = res.getDouble(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA OBTENER LOS MONTOS DE VISA-MASTER-EFECTIVO CON OPERACIONES COMBINADAS Y NOTAS DE PEDIDO */
    public double getMontosOPNotaPedido(int opc, int idFlujoCaja, int caja) throws Exception {
        double monto = -1;
        String tabla = "";
        String tablaDetalle = "";
        String idnpBarra = "";
        
        switch(caja){
            case 1:
                tabla = "npbarra";
                tablaDetalle = "operacion_np";
                idnpBarra ="idnpbarra";
                break;
            case 2:
                tabla = "npbarra2";
                tablaDetalle = "operacion_np2";
                idnpBarra ="idnpbarra2";
                break;
            case 3:
                tabla = "npbarra3";
                tablaDetalle = "operacion_np3";
                idnpBarra ="idnpbarra3";
                break;
        }

        PreparedStatement pst = null;
        try {
            this.conectar();
            switch (opc) {
                case 1: //obtener monto visa
//                    pst = this.conexion.prepareStatement("select sum(operacion_np.monto) + (select sum(npbarra_prod.subtotal)\n"
//                            + "from npbarra\n"
//                            + "inner join npbarra_prod on npbarra.idnpbarra = npbarra_prod.idnpbarra\n"
//                            + "where npbarra.idflujocaja = " + idFlujoCaja + " and npbarra.tipopago = 3)\n"
//                            + "from npbarra\n"
//                            + "inner join operacion_np on npbarra.idnpbarra = operacion_np.idnpbarra\n"
//                            + "where npbarra.idflujocaja = " + idFlujoCaja + " and operacion_np.tarjeta = \"VISA\"");
                    pst = this.conexion.prepareStatement("SELECT SUM(monto)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".idflujocaja = '"+idFlujoCaja+"' and tarjeta = 'VISA'");
                    break;
                case 2://obtener monto master
                    pst = this.conexion.prepareStatement("SELECT SUM(monto)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".idflujocaja = '"+idFlujoCaja+"' and tarjeta = 'MASTERCARD'");                    
                    break;
                case 3://obtener monto efectivo
                    pst = this.conexion.prepareStatement("SELECT SUM(monto)\n"
                            + "FROM "+tabla+" \n"
                            + "INNER JOIN "+tablaDetalle+" ON "+tabla+"."+idnpBarra+" = "+tablaDetalle+"."+idnpBarra+"\n"
                            + "WHERE "+tabla+".idflujocaja = '"+idFlujoCaja+"' and tarjeta = 'EFECTIVO'");                    
                    break;
            }

            ResultSet res = pst.executeQuery();
            if (res.next()) {
                monto = res.getDouble(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return monto;
    }

    /* METODO PARA ACTUALIZAR EL FLUJO DE CAJA CUANDO SE CIERRE LA CAJA */
    public boolean updateFlujoCaja(FlujoCaja fc) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `flujocaja` SET `fecha_final`='" + fc.getFechaFinal() + "', `hora_final`='" + fc.getHoraFinal() + "', `ingresos`='" + fc.getIngresos() + "', egresos = " + fc.getEgresos() + ", saldo = " + fc.getSaldo() + ",visa=" + fc.getVisa() + ",master=" + fc.getMaster() + ",jarras=" + fc.getJarras() + ",descuadre = " + fc.getDescuadre() + " ,`estado`='0' WHERE `idflujocaja`='" + fc.getIdFlujoCaja() + "'");
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

    /* METODO PARA OBTENER EL TOTAL DE BONIFICACIONES */
    public double getCantidadBonos() throws Exception {
        double cantidad = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select sum(ventaproducto.cantidad)\n"
                    + "from caja\n"
                    + "inner join flujocaja on caja.idcaja = flujocaja.idcaja\n"
                    + "inner join usuariocaja on caja.idcaja = usuariocaja.idcaja\n"
                    + "inner join usuario on usuariocaja.idusuario = usuario.idusuario\n"
                    + "inner join venta on usuario.idusuario = venta.idusuario\n"
                    + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                    + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "where flujocaja.estado = 1 and productopresentacion.precio >= 100");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                cantidad = res.getInt("sum(ventaproducto.cantidad)");
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return cantidad;
    }
    
    //obtener un flujo de caja a partir de su id
    public FlujoCaja obtener(int id) throws Exception {
        FlujoCaja fc = new FlujoCaja();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja WHERE idflujocaja = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                fc = new FlujoCaja();
                fc.setIdFlujoCaja(res.getInt("idflujocaja"));
                fc.setFechaInicio(res.getString("fecha_inicio"));
                fc.setHoraInicio(res.getString("hora_inicio"));
                fc.setFechaFinal(res.getString("fecha_final"));
                fc.setHoraFinal(res.getString("hora_final"));
                fc.setIngresos(res.getDouble("ingresos"));
                fc.setEgresos(res.getDouble("egresos"));
                fc.setSaldo(res.getDouble("saldo"));
                fc.setVisa(res.getDouble("visa"));
                fc.setMaster(res.getDouble("master"));
                fc.setJarras(res.getDouble("jarras"));
                fc.setDescuadre(res.getDouble("descuadre"));
                fc.setIdUsuario(res.getInt("idusuario"));
                fc.setIdCaja(res.getInt("idcaja"));
                fc.setEstado(res.getString("estado"));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return fc;
    }
}
