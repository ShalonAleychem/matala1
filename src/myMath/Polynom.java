package myMath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.Scanner;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Ron
 *
 */
public class Polynom implements Polynom_able{
	// ********** add your code below ***********
	public Polynom() {
		this.iteretor();								
	}
	public Polynom(Polynom p1) {//deep copy polynom
		for(int i=0;i<p1.monom_list.size();i++)
		{
			this.monom_list.add(p1.monom_list.get(i));
		}
				
	}
	public Polynom(String str) {
	Polynom P;
	str.replaceAll("-", "+-");//in case there is a minus sign we will replace it with '+-' which is the same
	String[]S=str.split("-");
	for(int i=0;i<S.length;i++)
	{
		Monom M=new Monom();
		this.monom_list.add(i, );
	}
	
	
	}
	ArrayList<Monom> monom_list=new ArrayList<Monom>();
	@Override
	public double f(double x) {//calculate the polynom at x=something
		
		double result=0;
	
		for(int i=0;i<monom_list.size();i++)
		{
			result=result+(monom_list.get(i).get_coefficient()*Math.pow(x,monom_list.get(i).get_power()));
		}
		return result;
			
	}

	@Override
	public void add(Polynom_able p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Monom m1) {
		for(int i=0;i<this.monom_list.size();i++)
		{
			if(m1.get_power()==this.monom_list.get(i).get_power())
			{
				this.monom_list.get(i).add(m1);
			}
			else
			{
				monom_list.add(m1);
			}
		}
		
	}

	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isZero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Polynom_able derivative() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void initializelistofmonoms()//used in iterator
	{
		System.out.println("enter the number of monoms: ");
		
	}

	@Override
	public Iterator<Monom> iteretor() //get a collection of monoms and re-order them to get polynom
	{
		System.out.println("enter number of desired monoms");//kelet shel user
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		reader.close();
		for(int i=0;i<n;i++)
		{
			System.out.println("please enter coefficent");
			int c=reader.nextInt();
			reader.close();
			System.out.println("please enter power");
			int p=reader.nextInt();
			reader.close();
			Monom m=new Monom(c,p);
		   monom_list.add(m);
		}
		System.out.println("the polynom is: ");
		for(Monom m:monom_list)
		{
			System.out.print(m.get_coefficient()+"x^"+m.get_power()+" ");
		}
		return monom_list.iterator();
						
	}
	public String toString() {
		return "";
		}
	
}
