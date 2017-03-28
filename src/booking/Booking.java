/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;
/**
 *
 * @author LENOVICA
 */
public class Booking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        angajat angajat1=new angajat();
        angajat angajat2=new angajat();
        angajat1.setNumeAngajat("Ionescu");
        angajat1.setIdAngajat(1);
        angajat2.setNumeAngajat("Visinescu");
        angajat2.setIdAngajat(2);
       // System.out.println( angajat1.getIdAngajat());
       // System.out.println(angajat2.getIdAngajat());
        //System.out.println(angajat1.getNumeAngajat());
        
        //verificari 
        //ocupat o=new ocupat();
       if(angajat1.esteInTimpProgram(18)) System.out.println("Este in timpul orelor de program se poate face programare");
       else System.out.println("Este in afara orelor de program si nu se fac programari");
       
        if(angajat1.sarbatoriLegale(1,12 )) System.out.println("In ziua aleasa nu este sarbatoare legala, se poate programa");
        else System.out.println("Nu puteti programa, este sarbatoare legala/zi libera");
        
        if (angajat1.weekend(16,12)) System.out.println("Puteti face programareeeeee");
        else System.out.println("Ziua aleasa este in weekend si nu se fac programari");
    
        //stabilire o data programata
    angajat1.setProgramareOra(9,30,10,30);
    if (angajat1.getProgramareOra(8,30,10,0))System.out.println("Puteti face programari in acest interval ");
    else System.out.println("Nu se pot face programari in intervalul dorit");
    
    angajat1.setProgramareOra(12, 0,12, 30);
    if (angajat1.getProgramareOra(12,0,12,30))System.out.println("Puteti face programari in acest interval ");
    
    }
    
    
    
}
