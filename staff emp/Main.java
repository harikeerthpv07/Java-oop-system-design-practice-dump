class Main {
    public static void main(String[] args) {
        Person per[]={new Professor("Hari",1,10000),new Student("Arjun",1122,"Computer Science"), new Staff("Kiran",33,1000)} ;
        for(Person p:per){
            System.out.println("Name is: "+p.name+" and role is: "+p.getRole());
            if(!p.getRole().equals("Student")){
                ((Payable)p).printPayStatus();
                System.out.println("Salary is"+((Payable)p).calculatePay());
            }
        }
        System.out.println("Total number of people created: "+Person.count);
    }
}

abstract class Person {
    String name;
    int id;
    static int count=0;
    Person(String name,int id){
        count+=1;
        this.name=name;
        this.id=id;
    }
    abstract String getRole();
}

interface Payable{
    double calculatePay();
    default void printPayStatus(){
        System.out.println("Payment calculation in progres");
    }
}

class Professor extends Person implements Payable{
    double salary;
    String Role;
    Professor(String name,int id,double salary){
        super(name,id);
        this.salary=salary;
        Role="Professor";
    }
    public double calculatePay(){
        return(salary+(.2*salary));
    }
    public String getRole(){
        return Role;
    }
}


class Student extends Person{
    String Role;
    final String Course_name;
    Student(String name,int id,String Course_name){
        super(name,id);
        Role="Student";
        this.Course_name=Course_name;
    }
    public String getRole(){
        return Role;
    }
}

class Staff extends Person implements Payable{
    String Role;
    double wage;
    Staff(String name,int id,double wage){
        super(name,id);
        Role="Staff";
        this.wage=wage;
    }
    public double calculatePay(){
        return(wage+(wage*.1));
    }
    public String getRole(){
        return Role;
    }
}



