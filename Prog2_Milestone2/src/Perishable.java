
public class Perishable extends Product{

private int days;

	public Perishable(int code, String name, double price, int units,int days) {
		super(code, name, price, units);
		this.days=days;
		
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		
		this.days = days;
	}
	/*********************************************************************
	*
	* Method name:calculateprice
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Calculate the price depending in the units
	*
	* Calling arguments: none
	*
	* Return value: 
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public double calculateprice(){
		double fprice=0;
		fprice=price*units;
		return fprice;
	}
	@Override
	public String toString() {
		return "Perishable [days=" + days + ", code=" + code + ", name=" + name + ", price=" + price + ", units="
				+ units + "]";
	}

}
