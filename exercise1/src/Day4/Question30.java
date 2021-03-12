package Day4;

public class Question30 {

}
class Date{
	int day,month,year;
	Date(int d,int m, int y){
		day=d;
		month=m;
		year=y;
	}
	public int[] getdate(){
		int[] a = {this.day, this.month, this.year};
		return a;
	}
	public void setdate(int[] a) {
		this.day = a[0];
		this.month = a[1];
		this.year = a[2];
	}
}

class Employee{
	Date joining_date;
	public int salary;
	public Employee(int[] d,int sal) {
		// TODO Auto-generated constructor stub
		salary = sal;
		joining_date.setdate(d);
	}
	public void disp() {
		System.out.println("employee class");
	}
}

class worker extends Employee{
	
	public worker(int[] d,int sal) {
		super(d,sal);
	}
	public void disp() {
		System.out.println("employee class");
	}
}
	
class SalesPerson extends Employee{
	
	public SalesPerson(int[] d,int sal) {
		super(d,sal);
	}
	
	public void disp() {
		System.out.println("Sales Person class");
	}
}

class SalesManager extends SalesPerson{
	
	public SalesManager(int[] d,int sal) {
		super(d,sal);
	}
	
	public void disp() {
		System.out.println("Sales Manager class");
	}
}

class SalesTerritoryManager extends SalesManager{
	
	public SalesTerritoryManager(int[] d,int sal) {
		super(d,sal);
	}
	
	public void disp() {
		System.out.println("Sales Territory Manager class");
	}
}
	
	