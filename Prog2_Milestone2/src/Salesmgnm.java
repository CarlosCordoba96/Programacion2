
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class Salesmgnm {
	private Offer[] off;
	private Product [] pro;
	public Salesmgnm(){
		
		read_offers();
		read_products();
		
	}
	
	
	public void read_products(){
		int codigo1, units, days, offert;
		double precio1;
		String nombre1,perecedero;
		int n=0;
		int i=0;
		String perishable;
		Scanner sc=null;
		try{
		 sc = new Scanner (new File ("productos.txt"));
		}catch (FileNotFoundException e){
			
		}
		sc.useLocale(Locale.US);//Para leer doubles y que no de error
		sc.next();
		n=sc.nextInt();
		pro=new Product[n];
		while(sc.hasNext()){
			sc.next();
			codigo1=sc.nextInt();
			sc.next();
			nombre1=sc.next();
			sc.next();
			precio1=sc.nextDouble();
			sc.next();
			units=sc.nextInt();
			sc.next();
			perecedero=sc.next();
			if(perecedero.equals("si")){
				sc.next();
				days=sc.nextInt();
				pro[i]=new Perishable(codigo1,nombre1,precio1,units,days);
				i++;
			}else{
				sc.next();
				offert=sc.nextInt();
				pro[i]=new NonPerishable(codigo1,nombre1,precio1,units,search_offert(offert));
				i++;
			}
		}
				
			
	}

	public void read_offers(){

		Scanner sc = null;
		int identifier, perc, max;
		String kind;
		int n;
		int i=0;//i is used for multiplicity and j for percentage offers
		try {
			sc = new Scanner(new File ("ofertas.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.useLocale(Locale.US);
		
		sc.next();
		n=sc.nextInt();
		
		off=new Offer[n];
		
		while(sc.hasNext()){
			sc.next();
			identifier=sc.nextInt();
			sc.next();
			kind=sc.next();
			if(kind.equals("porcentaje")){
				sc.next();
				perc=sc.nextInt();
				sc.next();
				max=sc.nextInt();
				off[i]=new OffertPercentage(identifier,kind,perc,max);
				i++;
			}else{
				off[i]=new OffertMult(identifier,kind);
				i++;
			}
		}
		sc.close();
	}
	public void write_offers(){
	
	}
	public void write_products(){
	
	}
	
	public Offer search_offert(int id){
		Offer aux = null;
		for(int i=0;i<off.length;i++){
			if(id==off[i].getIdentifier()){
				aux=off[i];
			}
		}
		return aux;
	}
	/*********************************************************************
	*
	* Method name:showproducts
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method:  This method prints the list of products avialable
	*
	* Calling arguments: none
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void showproducts(){
			for(int i=0;i<pro.length;i++){
				System.out.println(pro[i].toString());
			}
		
	}
	public Product search(String name){
		Product aux=null;
		for(int i=0;i<pro.length;i++){
			if(name.equals(pro[i].getName())){
				aux=pro[i];
			}
		}
		
		
		return aux;
				
	}
	
	public Product search_modify(String name,int unit) throws NumberofdeliverException{
		int i;
		Product aux=null;
		boolean search=false;
		for( i=0;i<pro.length&&search==false;i++){
			if(name.equals(pro[i].getName())){
				search=true;
				aux=(Product) pro[i].clone();
				pro[i].setUnits(pro[i].getUnits()-unit);
				i--;
			}
		}
		if(pro[i].getUnits()<unit){
			throw new NumberofdeliverException();
		}else{
			}
		
		aux.setUnits(unit);
		
		return aux;
				
	}
	/*********************************************************************
	*
	* Method name:compare
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: It search a product with the same name that we want and 
	* return true if it founds the product
	*
	* Calling arguments: String name
	*
	* Return value: boolean
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public boolean compare(String name){
		
		boolean exist=false;
		for(int i=0;i<pro.length;i++){
			if(name.equals(pro[i].getName())){
				exist=true;
			}
		}
		return exist;
	}
	/*********************************************************************
	*
	* Method name:changeprice
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method:We change the price of a product 
	*
	* Calling arguments: (Product) produ and (double) price
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void  changeprice(Product produ, double price){
		for(int i=0;i<pro.length;i++){
			if(produ.getCode()==pro[i].getCode()&& price!=(pro[i].getPrice()) ){
					pro[i].setPrice(price);					
				}
		}
		
	}
	/*********************************************************************
	*
	* Method name:changename
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: We change the name of a product 
	*
	* Calling arguments: (Product) produ and (String) name
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void changename(Product produ, String name){
		for(int i=0;i<pro.length;i++){
			if(produ.getCode()==pro[i].getCode()&& !(name.equals(pro[i].getName()) )){
					pro[i].setName(name);					
				}
		}
	}
	/*********************************************************************
	*
	* Method name:changecode
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Change the code of the product
	*
	* Calling arguments:  (Product) produ and (int) codigo
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void changecode(Product produ, int codigo){
		int pw;
		Scanner s=new Scanner(System.in);
		
		for(int i=0;i<pro.length;i++){
			if(codigo==pro[i].getCode()){
					System.out.println("Write the new code");
					pw=s.nextInt();
				for(int j=0;j<pro.length;j++){
					if(pw==(pro[j].getCode())){
						System.out.println("That code is already used, write a new one");
						pw=s.nextInt();
						j=-1;
					}
				}
				
					pro[i].setCode(pw);
				
				}
		}
	}
	/*********************************************************************
	*
	* Method name:modifyproduct
	*
	* Name of the original author: Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Change the units of the product
	*
	* Calling arguments:  (String) name and (int) cantidad
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void modifyproduct(String name,int cantidad){
		int i;
		for(i=0;i<pro.length;i++){
			if(name.equals(pro[i].getName())){
				pro[i].modifyunits(cantidad);
			}
		}
	}
	
	public boolean isposible(String name,int unit){
		boolean posible=true;
		int i;
		Product aux=null;
		boolean search=false;
		for( i=0;i<pro.length&&search==false;i++){
			if(name.equals(pro[i].getName())){
				search=true;
				if(unit>pro[i].getUnits()){
					posible=false;
				}
			}
		}
		
		
		return posible;
	}
	
	
}
