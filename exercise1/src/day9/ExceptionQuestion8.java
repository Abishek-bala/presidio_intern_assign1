package day9;
import java.util.*;
public class ExceptionQuestion8 {
	public int avg(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum+=i;
		}
		return sum/a.length;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter marks of 10 students");
		int a[] = new int[10];
		for(int i=0;i<10;i++) {
			try {
				String input = s.next();
				a[i] = Integer.parseInt(input);
			}catch(NumberFormatException nfe) {
				System.out.println("invalid input for integer...enter again");
				i--;
			}
			
		}
		System.out.println("total = "+new ExceptionQuestion8().avg(a));
	
	}
}

