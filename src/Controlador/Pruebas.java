/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;

/**
 *
 * @author Marce
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        try {
//            //System.out.print("Ingrese la fecha de ingreso: ");
//            String hingreso = "19:00";//la hora de inicio se define cuando se apertura la caja
//            LocalTime ingreso = LocalTime.parse(hingreso);
//            //System.out.print("Ingrese la fecha de salida: ");
//            String hsalida = "06:00";//la hora de salida se debe configurar para el cierre automatico
//            LocalTime salida = LocalTime.parse(hsalida);
//
//            int minutes = (int) ChronoUnit.MINUTES.between(salida, ingreso);
//            System.out.println(minutes);
//            if (minutes > (60 * 12)) {
//                //si se pasa la hora de trabajo ingresa aca
//                System.out.println("¡Estás explotando a tus empleados!");
//            }else{
//                //si estamos en el horario correcto ingresa aca
//                System.out.println("Horario correcto");
//            }
//        } catch (DateTimeParseException e) {
//            System.out.println("Fecha de ingreso o salida inválida");
//        }
        int flag=0;
        int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(1, 1);
        FlujoCajaDAO fcdao = new FlujoCajaDAO();
        for (FlujoCaja fc : fcdao.Listar()) {
            if (fc.getIdFlujoCaja()==idFlujoCaja && fc.getEstado().equals("1")) {
                flag++;
            }
        }
        
        if (flag>0) {
            System.out.println("se aperturo la caja");
        }else {
            System.out.println("caja cerrada");
        }
        
//        System.out.println(new FlujoCajaDAO().getIdFlujo(1, 3));
        
//        FlujoCajaDAO fcdao = new FlujoCajaDAO();
//        for (FlujoCaja fc: fcdao.Listar()) {
//            System.out.println(fc.getEstado());
//        }

    }

}
