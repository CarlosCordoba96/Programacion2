

import java.util.Scanner;



public class Shop {
	static Scanner sc=new Scanner(System.in);
	static Order or;
	static Product prod;
	static Employemngmn em=new Employemngmn();
	static Employees loged;
	static Salesmgnm s= new Salesmgnm();
	
	
	public static void main(String[] args) throws NonlogedException, NoPassException {
		menu();
		
	}
	public static void menu() throws NonlogedException, NoPassException{
		int option=1;
		boolean cont = true;
		option=check();
		if(option==4){
			cont=false;
		}
		
		do{
		//	check();
		while(option!=4){
			
			System.out.println("Welcome to our program, please select an option:\n1.Place an order. \n2.Modify product.\n3.Change employee password\n4.Log out.");
				option=sc.nextInt();
				
					while(option<1 || option>4){
						System.out.println("Please introduce again a valid option, from 1 to 4");
						option=sc.nextInt();
					
			}
					switch(option){
					case 1:
						System.out.println("Write the number of products you want to order");
						int k= sc.nextInt();
						while(k <1){
							System.out.println("Introduce a positive number");
							k= sc.nextInt();
						}
						or = new Order(k);
						int p=1;
						System.out.println();
						while(p!=4){
						System.out.println("Select an option:\n1.1 Add product. \n1.2 Visualize total price.\n1.3 Print out invoice .\n1.4 Finish placing order");
						p=sc.nextInt();
						while(p<1 || p>4){
							System.out.println("Please introduce again a valid option, from 1 to 4");
							p=sc.nextInt();
						}
					switch(p){
						case 1:
							s.showproducts();
							int pep=0;
							boolean conti = false;
							int units;
							while(pep<k && conti==false ){
								System.out.println("Write the name of the product");
								String name = sc.next();
								
								prod = s.search(name);
								
								while(prod == null){
									System.out.println("Please introduce a correct product name");
									name = sc.next();
									prod = s.search(name);
								}
								System.out.println("Please introduce the number of units you want ");
								
								units=sc.nextInt();
								while(s.isposible(name, units)==false){
									System.out.println("Error with the number of units you want ,introduce it again please");
									units=sc.nextInt();
								}
								
								
								or.addProduct(prod);
								pep++;
								System.out.println("Do you want to introduce another product? 1.Yes 2.No");
								int quest= sc.nextInt();
								if(quest ==2){
									conti=true;
									if(units==pep){
										loged.incprod(or.finalprice());
									}
								}
							}
					
							
							break;
						case 2:
						double finalp=or.finalprice();
						System.out.println("The final price is: "+finalp);
						
							break;
						case 3:
							or.showfacture();
							System.out.println("You have been attended by "+loged.getName());
							break;
						}
						//END OF OPTION 1
					}
						
						break;
					case 2:
						s.showproducts();
						int or;
						System.out.println();
						do{
						System.out.println("Select an option:\n2.1.Modify name. \n2.2.Modify price.\n2.3.Modify code.\n2.4.Modify Units. \n2.5.Return");
						or=sc.nextInt();
						while(or<1 || or>5){
							System.out.println("Please introduce again a valid option, from 1 to 5");
							or=sc.nextInt();
						}
						Option2(or);
						}while(or!=5);
						break;
					case 3:
						changepassword(loged);
						break;
					}
		
		}
		System.out.println("Do you want to continue with other user?, true or false");
		
		cont=sc.nextBoolean();
	if(cont==true){
		option=check();
		}
		}while(cont);
		System.out.println("\n End of the program");
		}
	public static void Option2(int or){
		switch(or){
		case 1:
			System.out.println("Introduce the name of the product you want to change its name");
			String name= sc.next();
			while(s.compare(name)==false){
				System.out.println("Introduce a correct name");
				 name= sc.next();
			}
			prod=s.search(name);
			
			System.out.println("Introduce the new name of the product");
			String nname=sc.next();
			
			s.changename(prod, nname);
			break;
		case 2:
			System.out.println("Introduce the name of the product you want to change its price");
			 name= sc.next();
			 while(s.compare(name)==false){
					System.out.println("Introduce a correct name");
					 name= sc.next();
				}
			prod=s.search(name);
			System.out.println("Introduce the new price of the product");
			int price=sc.nextInt();
			s.changeprice(prod, price);
			
			break;
		case 3:
			System.out.println("Introduce the name of the product");
			 name= sc.next();
			 while(s.compare(name)==false){
					System.out.println("Introduce a correct name");
					 name= sc.next();
				}
			prod=s.search(name);
			System.out.println("Introduce the new code of the product");
			int code=sc.nextInt();
			s.changecode(prod,code);
			break;
		case 4:
			System.out.println("Introduce the name of the product");
			 name= sc.next();
			 while(s.compare(name)==false){
					System.out.println("Introduce a correct name");
					 name= sc.next();
				}
			int number;
			System.out.println("Introduce the number of product");
			 number= sc.nextInt();
			 while(number<0 ){
					System.out.println("Introduce a correct number");
					 number= sc.nextInt();
				}
			 s.modifyproduct(name,number);
			
			break;
			
		}
		}
	
	/*********************************************************************
	*
	* Method name:changepassword
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Made the action of introduce a new password for a employee
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
	public static void changepassword(Employees loged){
		String password;
		int id;
		System.out.println("Introduce the new password:");
		password=sc.next();
		id=loged.getCode();
		em.Changepass(id, password);
	}
	/*********************************************************************
	*
	* Method name:check
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Made the action of check if the login and the password
	* correspond to a employee
	*
	* Calling arguments: none
	*
	* Return value: integer
	*
	* Required Files: None
	*
	* List of Checked Exceptions: NonlogedException, NoPassException
	*
	*********************************************************************/ 
	public static int check() throws NonlogedException, NoPassException{
		int login, opt=4;
		String password;
		boolean seguir= true, log=false, pas=false;
		int intentos =0;
		do{
			
		
		System.out.println("WELCOME TO THE PROGRAM, PLEASE, INTRODUCE YOUR USERNAME: ");
				login=sc.nextInt();
				try {
					em.checklogin(login);
					if(em.checklogin(login)== true){
						seguir=false;
						log=true;
					}else{
						log=false;
					}
				} catch (NonlogedException e1) {
				//Controlar error de login
					System.out.println("Error with the username");
					intentos++;
					log=false;
				}
			System.out.println("INTRODUCE YOUR PASSWORD: ");
				password=sc.next();
				try {
					em.checkpass(password);
					if(em.checkpass(password)== true){
						seguir=false;
						pas=true;
					}
					if(log== false){
						seguir=true;
					}
				
					
					
				} catch (NoPassException e) {
					System.out.println("Error with the password");
					if(log== true){
						intentos++;
					}
					
					seguir=true;
					pas=false;
					
				}
				
			
		
			
		}while(seguir==true && intentos<3);
		
		if(log==true && pas==true){
			opt=1;
			loged=em.search(login);
		}
		return opt;
	}
}
//Crear 2 excepciones login exception y password
/*Tendremos metodo comprobar, si se produce en login throw login, encima del check poner los throws y ya
en el metodo en el que llamamos a chek es donde ponemos el try y el catch*/