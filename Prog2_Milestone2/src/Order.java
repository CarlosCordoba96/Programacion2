
public class Order {
	
	private Product[] prod;
	
	private int counter=0;//count the number of products added to the order
	public Order(int n){
		prod=new Product[n];
	}
	
	/*********************************************************************
	*
	* Method name: finalprice
	*
	*@author Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: Returns the total price of the order
	*
	* Calling arguments: none
	*
	* Return value: double
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public double finalprice(){
		double finalp=0;
		for(int i=0;i<prod.length;i++){
			if(prod[i]==null){
				finalp+=0;
			}
			finalp += prod[i].calculateprice();
		}
	return finalp;
			
	}
	
	/*********************************************************************
	*
	* Method name: showfacture
	*
	* @author Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: The method prints the full order
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
	public void showfacture(){
		for(int i=0;i<prod.length;i++){
			System.out.println(prod[i].toString());
		}
		
			
		}
	
	/*********************************************************************
	*
	* Method name:addProduct
	*
	* @author Carlos Córdoba Ruiz & Manuel Hurtado Lillo
	*
	* Description of the Method: We add to the order a product
	*
	* Calling arguments: (Product)pro
	*
	* Return value: void
	*
	* Required Files: None
	*
	* List of Checked Exceptions: 
	*
	*********************************************************************/ 
	public void addProduct(Product pro){
    int i=0;
    if(prod[i]==null){
    	prod[i]=pro;
    	counter++;
    		}else{
    			do{
    				if(prod[counter]==null){
    					prod[counter]=pro;
    				}
    				counter++;
    				}while(prod[counter-1].getName()!=pro.getName());
    			}
	}
	

}
	
	
	
	


