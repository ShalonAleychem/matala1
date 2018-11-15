
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Ron Sider
 *
 */
public class Monom implements function{
	//****************** Public Methods and Data *****************
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************
	public double get_coefficient() {
		return this._coefficient;
	}
	public int get_power() {
		return this._power;
	}
	public double f(double x) {
		double temp=Math.pow(x, this.get_power());
		return this.get_coefficient()*temp;
				
	}
	public void negative_monom()//use for polynom substract class
	{
		this.set_coefficient(-1*this.get_coefficient());
	}
	
	public void derivative()
	{
		this.set_coefficient(this.get_coefficient()*this.get_power());
		this.set_power(this.get_power()-1);		
	}
	
	public void add(Monom m)//Restriction: Monoms must be of the same power
	{
		if(m.get_power()==this.get_power())//only same power monom can be added, else- do nothing
		{
			this.set_coefficient(this.get_coefficient()+m.get_coefficient());
		}
		else
		{
			System.out.println("In order for it to stay Monom of the shape ax^b, you must enter two monoms of the same power");
		}
	}
	public void multiply(Monom m)
	{
		this.set_coefficient(this.get_coefficient()*m.get_coefficient());
		this.set_power(this.get_power()+m.get_power());
	}
	public double area(double x0,double x1,int eps)//full description of formula and variables in java doc & readme 
	{
		double Delta_X=(x1-x0)/eps;
		double sum=0;
		for(int i=1;i<=eps;i++)
		{
			double xi=x0+Delta_X*i;
			sum=sum+this.f(xi);
		}
		return sum*Delta_X;
	}
	public boolean Zero_Monom()
	{
		if(this.get_coefficient()==0)
			return true;
		else return false;
	}
	
	//****************** Private Methods and Data *****************
	
	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		this._power = p;
	}
	
	private double _coefficient; // 
	private int _power; 
}
