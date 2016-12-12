/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import Entidades.Pavallsscore;
import Servicios.Serviceuser;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

/**
 *
 * @author pauva
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        pruebas p= new pruebas();
         
    }
    public pruebas(){
    
//    Date f = new Date();
//        int y = f.getYear();
//        int m = f.getMonth();
//        int d = f.getDay();
//        int h = f.getHours();
//        int min = f.getMinutes();
//        int s = f.getSeconds();
//
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("JuegolanzaderaPauVallsMorenoPU");
        EntityManager em = emf.createEntityManager();
        Serviceuser sv = new Serviceuser(em);
        ServiceScore svs = new ServiceScore(em);
        ArrayList <Datos> array= svs.getMostvitiated();
        
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).User +","+ array.get(i).contador);
        }
//        
//        int datos = sv.findUserbyname("pau");
//        Pavallsuser pa= new Pavallsuser();
//        pa.setIduser(datos);
//        Calendar inicio = fecha(d, m, y, h, min, s);
//        Serviceuser serviceuser = sv;
//      
//        java.sql.Date dateinicio = new java.sql.Date(inicio.getTime().getTime());
//        
//        svs.adduser(pa, dateinicio);
  Date f = new Date();
  
        
//String speed= "Speed: -1.44 m/s";
//String velocidad="";
//boolean semaforo=false;
//
//        for (int i = 0; i < speed.length(); i++) {
//            
//            if (i > 7 && i <12) {
//                
//                velocidad += speed.charAt(i);
//            }
//        }
//         double i = Double.parseDouble(velocidad);
//        System.out.println(i);
//       
    }
    
     public Calendar fecha(int d, int m, int y, int h, int min, int s) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.DAY_OF_MONTH, d);
        calendar.set(Calendar.MONTH, m);
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, min);
        calendar.set(Calendar.SECOND, s);

        return calendar;
    }
      

        
        
        
        
        
        
//        Date date = new Date();
//       DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//System.out.println("Hora y fecha: "+hourdateFormat.format(date));


    }
    

