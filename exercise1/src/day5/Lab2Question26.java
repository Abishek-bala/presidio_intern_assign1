package day5;

public class Lab2Question26 {
	public static void main(String[] args) {
		int a, b; 
		a = 12;
		b = 65; 
		System.out.println("Before : a = "+a+" b = " + b); 
		a = a + b; 
		b = a - b;
		a = a - b;
		System.out.println("After : a = "+a+" b = " + b);
		a = a * b; 
		b = a / b;
		a = a / b;
		System.out.println("After : a = "+a+" b = " + b);
	}
}
