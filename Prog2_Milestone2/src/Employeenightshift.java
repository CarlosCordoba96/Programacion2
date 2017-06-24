
public class Employeenightshift extends Employees {
	
	
	private double plus_percentage;
	public Employeenightshift(String name, String password, int code, int level, double productivity,double plus_percentage) {
		
		super(name, password, code, level, productivity);
		this.plus_percentage=plus_percentage;
		
		
	}
	
	public double getPlus_percentage() {
		return plus_percentage;
	}
	public void setPlus_percentage(double plus_percentage) {
		this.plus_percentage = plus_percentage;
	}
	

	@Override
	public String toString() {
		return "Employeenightshift [plus_percentage=" + plus_percentage + ", name=" + name + ", password=" + password
				+ ", code=" + code + ", level=" + level + ", productivity=" + productivity + "]";
	}
	public void incrprod(double price){
		if(level==1){
			super.productivity+=1;
		}else if(level==2){
			super.productivity+=(2+(plus_percentage/100)*price);
		}else if(level==3){
			super.productivity+=(3+(plus_percentage/100)*price);
		}
	}
	
	
}
