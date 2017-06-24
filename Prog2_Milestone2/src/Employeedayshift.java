
public class Employeedayshift extends Employees {
private double reduction_percentage;
	
	public Employeedayshift(String name, String password, int code, int level, double productivity, double reduction_percentage) {
		super(name, password, code, level, productivity);
		this.reduction_percentage=reduction_percentage;
		
	}

	public double getReduction_percentage() {
		return reduction_percentage;
	}

	public void setReduction_percentage(double reduction_percentage) {
		this.reduction_percentage = reduction_percentage;
	}

	@Override
	public String toString() {
		return "Employeedayshift [reduction_percentage=" + reduction_percentage + ", name=" + name + ", password="
				+ password + ", code=" + code + ", level=" + level + ", productivity=" + productivity + "]";
	}
public void incrprod(double price){
	if(level==1){
		
		super.productivity+=1;
	}else if(level==2){
				if(price>300){
					super.productivity+=(2-(2*(reduction_percentage/100)));
				}else{
					super.productivity+= 2;
				}
				
	}else if(level==3){
		super.productivity+=(3-(3*(reduction_percentage/100)));
	}
}
	

	
	
	
	
	
}
