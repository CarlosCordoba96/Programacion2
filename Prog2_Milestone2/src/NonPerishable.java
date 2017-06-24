
public class NonPerishable extends Product{
	private Offer off;
	
	public NonPerishable(int code, String name, double price, int units,Offer off) {
		super(code, name, price, units);
		this.off=off;
	}

	@Override
	public String toString() {
		return "NonPerishable [off=" + off.getIdentifier() + ", code=" + code + ", name=" + name + ", price=" + price + ", units="
				+ units + "]";
	}

	public Offer getOff() {
		return off;
	}

	public void setOff(Offer off) {
		this.off = off;
	}
	public double calculateprice(){
		double fprice=price*units;
		
		if(off.getKind().equals("porcentaje")){
			int max=((OffertPercentage) off).getMax();
			int perc=((OffertPercentage) off).getPerc();
			if(max>units){
				fprice=units*price*((100-perc)/100);
			}else{
				fprice=max*price*((100-perc)/100)+(units-max)*price;
			}
			
			
		}else if(off.getKind().equals("3x2")){
			if(units>=3){
				if(units%3==0){
					int topay=2*(units/3);
					fprice=topay*price;
				}else{
					int topay=2*(units/3)+(units%3);
					fprice=topay*price;
				}
			}else{
				fprice=units*price;
			}
			
		}else if(off.getKind().equals("2x1")){
			if(units>=2){
				if(units%2==0){
					int topay=units/2;
					fprice=topay*price;
				}else{
					int topay=(units/2)+1;
					fprice=topay*price;
				}
			}else{
				fprice=units*price;
			}
		}
		return fprice;
	}

}
