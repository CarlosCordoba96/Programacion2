
public class Product implements Cloneable {
	protected int code;
	protected String name;
	protected double price;
	protected int units;
	
	public Product(int code,String name,double price, int units){
		this.code=code;
		this.name=name;
		this.price=price;
		this.units=units;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void modifyunits(int units){
		
		this.units+=units;
	}
	public double calculateprice(){
		return 0;
		
	}
	public Object clone(){
		Object obj=null;
		try{
			obj=super.clone();
		}catch(CloneNotSupportedException ex){
			System.out.println("No se puede clonar");
		}
		return obj;
	}
	

	
}
