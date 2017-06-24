
public class Employees {

	protected String name;
	protected String password;
	protected int code;
	protected int level;
	protected double productivity;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getProductivity() {
		return productivity;
	}

	public void setProductivity(double productivity) {
		this.productivity = productivity;
	}
	public Employees (String name, String password, int code, int level, double productivity){
		
		this.name=name;
		this.password=password;
		this.code=code;
		this.level=level;
		this.productivity=productivity;
		
	}

	public void incprod(double finalprice) {
		productivity=0;		
	}

	


}
