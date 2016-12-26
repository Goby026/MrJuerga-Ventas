/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import Modelo.ProductoPresentacionDAO;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Marce
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//            Date horaFinal = new Date();
//            horaFinal.getTime();
//            System.out.println(horaFinal);
//            FlujoCajaDAO fcdao = new FlujoCajaDAO();
//            for (FlujoCaja fc : fcdao.Listar()) {
//                
//            }
//            System.out.println(new ManejadorFechas().getHoraActual());
            Date fechaHoy = new Date();
            fechaHoy.getTime();

            
            String fechaActual = new ManejadorFechas().getFechaActual();
            java.sql.Date mañana = new ManejadorFechas().sumarFechasDias((java.sql.Date) fechaHoy, 1);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
            String fechaMañana = sdf.format(mañana);
            if (fechaActual.equals("26-12-2016") && fechaMañana.equals("27-12-2016")) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
