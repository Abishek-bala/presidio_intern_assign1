package day9;


import java.util.Scanner;

public class ExceptionQuestion9  {
	public float avg(int[] a) {
		float sum = 0;
		for (int i : a) {
			sum+=i;
		}
		System.out.println(sum);
		return sum/3;
	}
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter marks of 10 students");
		int a[] = new int[3];
		for(int i=0;i<3;i++) {
			try {
				String input = s.next();
				a[i] = Integer.parseInt(input);
				if(a[i]<=0||a[i]>100) {
					throw new InvalidExamMarkException("Invalid mark");
				}
			}catch(NumberFormatException nfe) {
				System.out.println("invalid input for integer...enter again");
				i--;
			}
			catch(InvalidExamMarkException ieme) {
				System.out.println(ieme);
				i--;
			}
		}
		System.out.println("Average = "+new ExceptionQuestion9().avg(a));
	
	}
}
	

class InvalidExamMarkException extends Exception{
	String msg;

	public InvalidExamMarkException(String msg) {
//		super();
		this.msg = msg;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
}
