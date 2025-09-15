import java.util.ArrayList;
public class Main
{
	public static void main(String[] args) {
		Bank canara=new Bank();
		canara.addCustomer("Hari",1);
		canara.addCustomer("Arjun",2);
		
		
		canara.openSavings("Hari",1,1000);
		canara.openCurrent("Arjun",2,2000);
		
		canara.deposit("acc0",1000);
		canara.withdraw("acc1",200);
		
		
		canara.getAccounts();
	}
}

class Bank{
    ArrayList<Customer> cstmr=new ArrayList<>();
    ArrayList<Account> accnt=new ArrayList<>();
    static int count=0;
    
    public void addCustomer(String name,int custId){
        cstmr.add(new Customer(name,custId));
        System.out.println("Customer Name: "+name+", Customer Id: "+custId+", added Succesfully!");
    }
    
    
    public void openSavings(String name,int custId,double balance){
        for(Customer c:cstmr){
            if(c.name.equals(name) && c.custId==custId){
                
                String temp="acc"+count;
                count++;
                accnt.add(new SavingsAccount(name,temp,balance,custId));
                
                System.out.println("Savings ccount created Succesfully!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }
    
    public void openCurrent(String name,int custId,double balance){
        for(Customer c:cstmr){
            if(c.name.equals(name) && c.custId==custId){
                
                String temp="acc"+count;
                count++;
                accnt.add(new CurrentAccount(name,temp,balance,custId));
                
                System.out.println("Current ccount created Succesfully!");
                return;
            }
        }
        System.out.println("Customer not found!");
    }
    
    public void deposit(String accountNumber,double amount){
        if(amount<=0){
            System.out.println("Enter a valid amount!");
            return;
        }
        for(Account a:accnt){
            if(a.accountNumber.equals(accountNumber)){
                a.balance+=amount;
                return;
            }
        }
        System.out.println("Account not found!");
    }
    
    
    public void withdraw(String accountNumber,double amount){
        if(amount<=0){
            System.out.println("Enter a valid amount!");
            return;
        }
        for(Account a:accnt){
            if(a.accountNumber.equals(accountNumber) && amount<=a.balance){
                a.balance-=amount;
                System.out.println(amount+" withdrawn Succesfully!");
                System.out.println("Current balance: "+a.balance);
                return;
            }
        }
        System.out.println("Account not found");
    }
    
    
    public void getAccounts(){
        System.out.println("Total accounts: "+count);
    }
    
    
    
    
}

class Account{
    String name;
    String accountNumber;
    double balance;
    int custId;
    Account(String name,String accountNumber,double balance,int custId){
        this.name=name;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.custId=custId;
    }
}

class SavingsAccount extends Account{
    SavingsAccount(String name,String accountNumber,double balance,int custId){
        super(name,accountNumber,balance,custId);
    }
}

class CurrentAccount extends Account{
    CurrentAccount(String name,String accountNumber,double balance,int custId){
        super(name,accountNumber,balance,custId);
    }
}

class Customer{
    String name;
    int custId;
    Customer(String name,int custId){
        this.name=name;
        this.custId=custId;
    }
}