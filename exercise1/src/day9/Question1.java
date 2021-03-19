package day9;
import java.util.*;
public class Question1 {
	public static void main(String[] args) {
//		Scanner s= new Scanner(System.in);
//		System.out.println("enter the designation");
//		String designation = s.next();
		Employee e= new SalesTerritoryManager();
		System.out.println(e.calcPay());
		
	}
}

abstract class Employee{
	public abstract int calcPay();
}

abstract class Prod extends Employee{
	
}

class Worker extends Prod{
	public Worker() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calcPay() {
		// TODO Auto-generated method stub
		return 10000;
	}
	
}

abstract class Sales extends Employee{
	
}

class salesperson extends Sales{
	public salesperson() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calcPay() {
		// TODO Auto-generated method stub
		return 15000;
	}
}

class SalesManager extends salesperson{
	public SalesManager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calcPay() {
		// TODO Auto-generated method stub
		return 20000;
	}
}

class SalesTerritoryManager extends SalesManager{
	public SalesTerritoryManager() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calcPay() {
		// TODO Auto-generated method stub
		return 25000;
	}
}
