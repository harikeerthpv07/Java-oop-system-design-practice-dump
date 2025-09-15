/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.ArrayList;
public class Main
{
	public static void main(String[] args) {
		Cart c1=new Cart();
		Electronics E1= new Electronics("Nothing 2A",20000);
		Clothing Cl1=new Clothing("Zudio jean",2000);
		Food f1=new Food("Masala Dosa",100);
		
		c1.addProduct(E1);
		c1.addProduct(Cl1);
		c1.addProduct(f1);

		
		c1.showProducts();
		
	}
}


abstract class Product{
    String name;
    double price;
    Product(String name,double price){
        this.name=name;
        this.price=price;
    }
    abstract void getInfo();
}

class Cart{
    ArrayList<Product>prdcts=new ArrayList<>();
    
    public void addProduct(Product p1){
        prdcts.add(p1);
    }
    public void showProducts() {
        System.out.println("--- Cart Contents ---");
        for (Product p : prdcts) {
            p.getInfo();  // polymorphism calls the correct subclass
        }
    }
}

class Electronics extends Product{
    Electronics(String name,double price){
        super(name,price);
    }
    public void getInfo(){
        System.out.println();
        System.out.println("Electronics, Name: "+name+", Price: "+price);
    }
}

class Clothing extends Product{
     
    Clothing(String name,double price){
        super(name,price);
    }
    public void getInfo(){

        System.out.println("Clothing, Name: "+super.name+", Price: "+super.price);
    }
}

class Food extends Product{
    Food(String name,double price){
        super(name,price);
    }
    public void getInfo(){

        System.out.println("Food, Name: "+super.name+", Price: "+super.price);
    }
}