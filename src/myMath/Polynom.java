package myMath;

import java.util.ArrayList;
import java.util.Collections;
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
 * @author Ron Sider & Adam Mashiah
 *
 */
public class Polynom implements Polynom_able{
	
	public void Init(String str) {//full description in accumulated doc.
		
		str=str.replaceAll("-", "+-");//same sign
		String[]S=str.split("\\+");
		for(String s:S)
		{									
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i)=='x')
				{
					String s1=s.substring(0, i);
					String s2=s.substring(i+2, s.length());
					double co=Double.parseDouble(s1);//coefficent
					int po=Integer.parseInt(s2);//power
					Monom m=new Monom(co,po);
					this.monom_list.add(m);
				}				
			}					
		}
		
		Collections.sort(monom_list, new Monom_Comperator());
	}
	
	ArrayList<Monom> monom_list=new ArrayList<Monom>();
	@Override
	public double f(double x) {//calculate value of polynom at certain point
		
		double result=0;
	
		for(int i=0;i<monom_list.size();i++)
		{
			result=result+(monom_list.get(i).get_coefficient()*Math.pow(x,monom_list.get(i).get_power()));
		}
		return result;			
	}

	@Override
	public void add(Polynom_able p1)
	{
		Iterator<Monom> it = p1.iteretor();
		Monom temp = it.next();
		while (it.hasNext())
		{
			this.add(temp);
			temp = it.next();
		}
		this.add(temp);	
		Collections.sort(this.monom_list, new Monom_Comperator());
	}

	@Override
	public void add(Monom m1) {
		int key = 0;
		Iterator<Monom> it = iteretor();
		Monom_Comperator temp = new Monom_Comperator();		
		if (this.monom_list.isEmpty())
			this.monom_list.add(m1);
		else if (this.monom_list.size() == 1)
		{
			Monom monom = new Monom(this.monom_list.get(0));
			int comparison = temp.compare(monom,m1);
			if (comparison == 0)
			{
				monom.add(m1);
				this.monom_list.set(key, monom);
			}
			if (comparison == -1)
			{
				this.monom_list.add(m1);
			}
			if (comparison==1)
				this.monom_list.add(m1);
						
		}
		else while(it.hasNext())
		{
			Monom monom = new Monom(it.next());
			int comparison = temp.compare(monom,m1);
			if (comparison == 0)
			{
				monom.add(m1);
				this.monom_list.set(key, monom);
				break;
			}
			if (comparison == 1)
			{
				
				this.monom_list.add(m1);
				
				break;
			}
			if (!it.hasNext() && comparison == -1 )
			{
				
				this.monom_list.add(m1);
				
				break;
			}
			key++;
		}
		Collections.sort(this.monom_list , new Monom_Comperator());
	}

	@Override
	public void substract(Polynom_able p1) {
		//Iterator<Monom>it1=this.iteretor();
		Iterator<Monom>it2=p1.iteretor();
		Monom m=it2.next();
		while(it2.hasNext())
		{
			m.negative_monom();
			this.add(m);
			m=it2.next();
		}
		
	}

	@Override
	public void multiply(Polynom_able p1) {
		
		
	}

	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom> it = this.iteretor();
		Iterator<Monom> _p1 = p1.iteretor();
		while (it.hasNext() && _p1.hasNext())
			if (!it.next().equals(_p1.next())) 
				return false;
		if (it.hasNext() || _p1.hasNext()) 
			return false;
		return true;
	}

	@Override
	public boolean isZero() {//zero polynom=every monom in pol. is the zero monom
		Iterator<Monom> it = this.iteretor();
		int count=0;
		while(it.hasNext())
		{
			Monom m=it.next();
			if(m.Zero_Monom()==true)
				count++;
		}
		if(count==this.monom_list.size())
		return true;
		else return false;					
	}

	@Override
	public double root(double x0, double x1, double eps) {
		double x_0=this.f(x0);
		double x_1=this.f(x1);
		if(x_0*x_1>=0)
		{
			System.out.println("Assertion of x0 and x1 is not correct");
		}
		double temp=x0;
		while((x1-x0)>=eps)
		{
			temp=(x1+x0)/2;
			if(this.f(temp)==0.0)
			break;
			else if(this.f(temp)*this.f(x0)<0)
			x1=temp;
			else
				x0=temp;
		}
		return temp;
	}

	@Override
	public Polynom copy() {
		Iterator<Monom>it=this.iteretor();
		Polynom p=new Polynom();
		while(it.hasNext())
		{
			Monom m=it.next();
			p.add(m);
		}
		return p;
	}

	@Override
	public Polynom_able derivative() {
		Polynom p=new Polynom();
		Iterator<Monom>it=this.iteretor();
		while(it.hasNext())
		{			
			Monom m=it.next();
			m.derivative();
			p.add(m);
		}
		
		return p;		
	}

	@Override
	public double area(double x0, double x1, double eps) {
		double Delta_X=(x1-x0)/eps;
		double sum=0;
		for(int i=1;i<=eps;i++)
		{
			double xi=x0+Delta_X*i;
			sum=sum+this.f(xi);
		}
		return sum*Delta_X;
	}
	

	@Override
	public Iterator<Monom> iteretor() //get a collection of monoms in "iterator" format
	{
		return this.monom_list.iterator();
						
	}
	@Override
	public String toString() {
		Iterator<Monom> it = this.iteretor();
		String str = it.next().toString();
		Monom temp ;
		while(it.hasNext())
		{
			temp = it.next();
			if (temp.get_coefficient() == 0)
				break;
			else if (temp.get_coefficient() > 0)
				str += "+";
			str += temp.toString();
		}
		return str;				
		}
	
}
