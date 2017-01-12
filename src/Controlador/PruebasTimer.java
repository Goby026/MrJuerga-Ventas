/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.FlujoCaja;
import Modelo.FlujoCajaDAO;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaby
 */
public class PruebasTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer mytimer = new Timer();
        final long seg = (1000*1);
        
        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
                try {
                    //repitiendo tiempos
                    System.out.println(new Date());
                    FlujoCajaDAO fcdao = new FlujoCajaDAO();
                    System.out.println(fcdao.Listar().get(0).getIdCaja());
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        
        mytimer.scheduleAtFixedRate(tarea, 0, seg);
    }
    
}
