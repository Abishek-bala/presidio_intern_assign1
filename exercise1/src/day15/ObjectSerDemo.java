package day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerDemo {
	public static void main(String[] args) throws Exception {
		Employee e = new Employee(1000);
		System.out.println(e.getSalary());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
		oos.writeObject(e);
		
		e.setSalary(2000);
		
		System.out.println("new salary = "+e.getSalary());
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));
		
		e= (Employee)ois.readObject();
		
		System.out.println("new val = "+e.getSalary());
	}
}


class Employee implements Serializable{
	int salary;

	public Employee(int salary) {
//		super();
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}