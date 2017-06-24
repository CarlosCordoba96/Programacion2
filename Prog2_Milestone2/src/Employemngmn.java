
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Employemngmn {
	
private Employees [] emp;

public Employemngmn(){
	read_emp();
}

public void write_emp(){
	
}
public void read_emp(){
	Scanner sc = null;
	String name,password;
	int code,level,retencion,n;
	double plus;
	int i=0;//i is used for day and j for night
	
	try {
		sc = new Scanner(new File ("empleados.txt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sc.useLocale(Locale.US);
	sc.next();
	n=sc.nextInt();
	emp=new Employees[n];
	while(sc.hasNext()){
		sc.next();
		name=sc.next();
		sc.next();
		code=sc.nextInt();
		sc.next();
		password=sc.next();
		sc.next();
		level=sc.nextInt();
		sc.next();
		if(sc.next().equals("diurno")){
			sc.next();
			retencion=sc.nextInt();
			emp[i]=new Employeedayshift(name,password,code,level,0,retencion);
			i++;
		}else{
			sc.next();
			plus=sc.nextDouble();
			emp[i]=new Employeenightshift(name,password,code,level,0,plus);
			i++;
		}
		
		
	}
	sc.close();
}
/*********************************************************************
*
* Method name: checklogin
*
* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
*
* Description of the Method: This method check if exist some employee with the login required
*
* Calling arguments:  (Int) login
*
* Return value: boolean
*
* Required Files: None
*
* List of Checked Exceptions: NonlogedException
*
*********************************************************************/
public boolean checklogin(int login) throws NonlogedException{
	boolean checked=false;
	int i;
		for(i=0;i<emp.length;i++){
			if(login==emp[i].getCode()){
				checked=true;
			}
		}
	if(checked==false){
		throw new NonlogedException ();
	}
	
	return checked;
}
public Employees search(int login){
	Employees aux=null;
	int i;
	for(i=0;i<emp.length;i++){
		if(login==emp[i].getCode()){
			aux=emp[i];
		}
	}
	
	return aux;
}
/*********************************************************************
*
* Method name: checkpass
*
* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
*
* Description of the Method: This method check if exist some employee with the password required
*
* Calling arguments:  (String) pass
*
* Return value: boolean
*
* Required Files: None
*
* List of Checked Exceptions: NoPassException
*
*********************************************************************/
public boolean checkpass(String pass) throws NoPassException{
	boolean check = false;
	for(int i=0;i<emp.length && check==false;i++){
		if(pass.equals(emp[i].getPassword())){
			check=true;
		}
	}
	if(check==false){
		throw new NoPassException();
		
	}
	
	
	
	return check;
}

/*********************************************************************
*
* Method name: Check
*
* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
*
* Description of the Method: This method check if exist some employee with that code and password
*
* Calling arguments: (int)login and (String) password
*
* Return value: boolean
*
* Required Files: None
*
* List of Checked Exceptions: 
*
*********************************************************************/ 
public boolean Check(int login, String password) {
boolean checked=false;
	for(int i=0;i<emp.length;i++){
		if(login==emp[i].getCode() && password.equals(emp[i].getPassword())){
			checked=true;
		}
	}
	return checked;
}

/*********************************************************************
*
* Method name: Changepass
*
* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
*
* Description of the Method: This method is used to change the password of a employee, we give the method the values of the code and the password
* of the user we want to change, and in the method we tell them to give the new password
*
* Calling arguments: (Int)id and (String) password
*
* Return value:void 
*
* Required Files: None
*
* List of Checked Exceptions: If the new password is the same that the user have 
*
*********************************************************************/ 
public void Changepass(int id, String password) {
	int i;
	for(i=0;i<emp.length;i++){
		if(id==emp[i].getCode()){
			emp[i].setPassword(password);
		}
	}
	
}
}
