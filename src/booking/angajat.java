/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booking;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author LENOVICA
 */
public class angajat {
    private String numeAngajat;
    private long idAngajat;
    private int zi;
    private int luna;
    private boolean verificareOra=true;
    private boolean verificareData=true;
    private boolean lunaDispo[]=new boolean[13];
    private boolean ziuaDispo[]=new boolean[32];
    private boolean oraDispo[][]=new boolean[18][31];
    
    Calendar c=Calendar.getInstance();
    public angajat()
    {
        
    }
    public void setNumeAngajat(String nume)
    {
        numeAngajat=nume;
    }
    public void setIdAngajat(long id)
    {
        idAngajat=id;
    }
        
     public String getNumeAngajat()
    {
        
        return numeAngajat;
    }
     public long getIdAngajat()
     {
         return idAngajat;
     }
     
     
     
     boolean esteInTimpProgram(int ora)
    {
         if ((ora<8)||(ora>17))
        {
        verificareOra=false;
        //System.out.println("Este in afara orelor de program si nu puteti face programare");
        }
        
        return verificareOra;
    }
    
    
    //metoda de verificare a sarbatorilor legale
    boolean sarbatoriLegale(int ziua, int luna)
    {
       // System.out.println(c.get(Calendar.MONTH));
      ////  System.out.println(c.get(Calendar.DAY_OF_MONTH));
    //   System.out.println((Calendar.SATURDAY));
         
         switch (luna)
                {
            case 1:{
                if (ziua==1) verificareData=false;
                if (ziua==2) verificareData=false;
                if (ziua==24) verificareData=false;
                break;
            }
            case 5: if (ziua==1) verificareData=false;break;
            case 6: if((ziua==1)||(ziua==4)||(ziua==5)) verificareData=false;break;
            case 8:if(ziua==15) verificareData=false;break;
            case 11: if (ziua==30) verificareData=false; break;
            case 12: if ((ziua==1)||(ziua==24)||(ziua==25)) verificareData=false;
            break;
                
        }
         
        return verificareData;
        
    }
    //metoda de verificare daca este zi de weekend
    boolean weekend(int zi,int luna)
    {
    verificareData=true;
    
    GregorianCalendar gcal = new GregorianCalendar();
    int ziDinLuna = gcal.get(Calendar.DAY_OF_MONTH);
    int ziDinSaptamana=gcal.get(Calendar.DAY_OF_WEEK)-1;
   
      
    //vector in care se memoreaza numarul zilelor din fiecare luna 
    int zileLuna[]=new int[12];
    zileLuna[0]=31;
    if (gcal.get(Calendar.YEAR)%4==0)
    {
     zileLuna[1]=29;
    }
    else  zileLuna[1]=28;
      zileLuna[2]=31;
        zileLuna[3]=30;
        zileLuna[4]=31;
        zileLuna[5]=30;
        zileLuna[6]=31;   
         zileLuna[7]=31;
          zileLuna[8]=30;
           zileLuna[9]=31;
            zileLuna[10]=30;
             zileLuna[11]=31;
    
    
    int inc,z;
        
    //verific daca ziua cand se programeaza este din luna in curs 
    if (luna==(gcal.get(Calendar.MONTH)+1))
    {z=(((zi-ziDinLuna)))%7;
    System.out.println("ziua este din luna curenta"+z);
    }
    else {
        z=zileLuna[gcal.get(Calendar.MONTH)]-ziDinLuna;
        for (int i=(gcal.get(Calendar.MONTH)+1);i<luna-1;i++)
        {
            z=z+zileLuna[i];
        // System.out.println(z);
       //  System.out.println(gcal.get(Calendar.MONTH));
     //    System.out.println(luna);
        }
        z=z+zi;
    }
    
    inc=ziDinSaptamana;
   // System.out.println(ziDinSaptamana);
        
    //vector in care este memorata eticheta fiecarei zi din saptamana 
    //luni corespunde 1, marti 2;....etc
    
    int v[]=new int[8];
    for (int i=1;i<=7;i++)
        v[i]=i;
    
    
    // verificare daca s-a ajuns la eticheta de sfarsit de saptamana sa 
    //incrementeze din nou pana se ajunge la eticheta zilei cautate.
    // ex de vineri pana luni sunt 3 zile z=3, inc=eticheta zilei curente din sapt
    // inc creste pe masura ce parcurgem o zi si revine la eticheta lui luni cand 
    //ajunge la 7(duminica), 
    while (z!=0)
    {
        
        if (inc>=7) inc=1;
        else inc=inc+1;
        z=z-1;
        
    }
    if (((v[inc])==6)||(v[inc]==7)){ 
    verificareData=false;
    }
     
        return verificareData;
    }
    
//verificare existenta data in calendar
boolean existaData(int zi,int luna)
{
    switch (luna)
    {
        case 1: if((zi<1)||(zi>31)) verificareData=false;break;
        case 2:{ if(c.get(Calendar.YEAR)%4==0)
                  {
            if((zi<1)||(zi>29)) verificareData=false;
                  }
                if (c.get(Calendar.YEAR)%4!=0)
                {
                  if ((zi<1)||(zi>28)) verificareData=false;   
                }
        break;}
        case 3: if ((zi<1)||(zi>31)) verificareData=false;break;
        case 4: if ((zi<1)||(zi>30)) verificareData=false;break;
        case 5: if ((zi<1)||(zi>31)) verificareData=false;break;
        case 6: if ((zi<1)||(zi>30)) verificareData=false;break;
        case 7: if ((zi<1)||(zi>31)) verificareData=false;break;
        case 8: if ((zi<1)||(zi>31)) verificareData=false;break;
        case 9: if ((zi<1)||(zi>30)) verificareData=false;break;
        case 10: if ((zi<1)||(zi>31)) verificareData=false;break;
        case 11: if ((zi<1)||(zi>30)) verificareData=false;break;
        case 12: if ((zi<1)||(zi>31)) verificareData=false;break;
        default: verificareData=false;break;
    }
    return verificareData;
}

  
  
 //setarea intervalurilor de programare
 public void setProgramareOra(int orai,int mini,int oraf,int minf)
 {
     //true inseamna ocupat
    if ((mini==30)||(minf==0)||(mini==0)||(minf==30))
    {
       int i=orai;
       int j=mini;
       int k=0;
       if (mini==0) k=1;
       if (mini==30) k=2;
       
       while (i<=oraf)
       {
           while (k<2)
           {
           if (j==0)
           {
        oraDispo[i][0]=true;
        j=30;
        k=1;
           }
           if (j==30)
           {
               oraDispo[i][30]=true;
               j=0;
               k=2;
           }
           }
           k=0;
           i++; 
       }
    }
    
 }
 
 //verificare disponibilitate interval ore
public  boolean getProgramareOra(int orai,int mini,int oraf,int minf)
 {
     boolean validare=true;
     
     if (((mini==30)||(mini==0))&&((minf==0)||(minf==30)))
    {
        
       int i=orai;
       int j=mini;
           
      
       for(i=orai;i<=oraf;i++)
           
       {
           
     if (oraDispo[i][j]==false) 
      {
          validare=true;
      if (j==30) j=0;
         else  j=30;
            }
      if (oraDispo[i][j]==true) 
      {validare=false;
      
      }
      
          }
   
     
     return validare;
 }
     else return validare;
 }


//setarea zilei de programare


}





 


