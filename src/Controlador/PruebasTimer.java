/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

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
        final long seg = (1000*2);
        
        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {
                //repitiendo tiempos
                System.out.println(new Date());
            }
        };
        
        mytimer.scheduleAtFixedRate(tarea, 0, seg);
    }
    
}
