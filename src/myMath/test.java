package myMath;

import java.util.ArrayList;
import java.util.Collections;

public class test {

	public static void main(String[] args) {
		
      Monom m1=new Monom(3,7);//Coefficient 3 and power is 7  
      Monom m2=new Monom(4,8);
      Monom m3=new Monom(9,2);
      Monom m4=new Monom(1,1);
      Monom m5=new Monom(4,4);
      Monom m6=new Monom(5,5);
      Monom m7=new Monom(11,9);
      Monom m8=new Monom(12,4);
      Monom m9=new Monom(4,2);
      Monom m10=new Monom(2,2);
      Monom m11=new Monom(9,8);
      Monom m12=new Monom(11,9);
     // Monom_Comperator m=new Monom_Comperator();
 
      //   System.out.println(m.compare(m1,m12));//output is -1. m1 is prior to m12 in some polynom which consists of these 2 elements
      /***********************************************/
      //Creating new list of monoms
     /* ArrayList<Monom> monoms = new ArrayList<Monom>();
      monoms.add(m1);
      monoms.add(m2);
      monoms.add(m3);
      monoms.add(m4);
      monoms.add(m5);
      monoms.add(m6);
      monoms.add(m7);
      monoms.add(m8);
      monoms.add(m9);
      monoms.add(m10);
      monoms.add(m11);
      monoms.add(m12);
      //Sorting monoms by Comperator criteria-smaller printed first 
      Monom_Comperator M=new Monom_Comperator();
      Collections.sort(monoms,M);*/
      
    /*  for(Monom m:monoms)
      {
    	  System.out.println(m.get_coefficient());
    	  System.out.println();
      }*/
      Polynom p1=new Polynom();
      p1.add(m1);
      p1.add(m3);
      p1.add(m5);
      System.out.println(p1.toString());
      
      
   	}

}
