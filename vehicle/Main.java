

public class Main
{
	public static void main(String[] args) {
		Vehicles v1=new Car("Maruti","TN07SS8569",true);
		Vehicles v2=new Bike("FZ","TN01SM2255",false);
		Vehicles v3=new Car("Benz","TN07S7777",false);
		
		v1.showDetails();
		v1.isElectric();
		v2.showDetails();
		v2.isElectric();
		v3.showDetails();
		v3.isElectric();
	    
	}
}



abstract class Vehicles{
    String name;
    String vehicleNumber;
    
    Vehicles(String name,String vehicleNumber){
        this.name=name;
        this.vehicleNumber=vehicleNumber;
       
    }
    public void showDetails(){
        System.out.println("Name: "+name+", Vehicle Number: "+vehicleNumber);
    }
    public abstract void isElectric();
}

interface Electric{
    void isElectric();
}

class Car extends Vehicles implements Electric{
    boolean Electric;
    Car(String name,String vehicleNumber,boolean isElectric){
        super(name,vehicleNumber);
        Electric=isElectric;
    }
    public void isElectric(){
        System.out.println("Is Electric: "+Electric);
    }
    
}

class Bike extends Vehicles implements Electric{
    boolean Electric;
    Bike(String name,String vehicleNumber,boolean isElectric){
        super(name,vehicleNumber);
        Electric=isElectric;
    }
    public void isElectric(){
        System.out.println("Is Electric: "+Electric);
    }

}