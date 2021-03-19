package day9;
import java.util.*;
public class ExceptionQuestion7 {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		//System.out.println("continue? y/n");
		//String q = "y";
		
		while(true) {
			int n,d;
//			q=s.nextLine();
			System.out.println("Enter numerator");
			if(s.hasNextInt()) {
				n = s.nextInt();
			
//			int n = s.nextInt();
			System.out.println("enter denominator");
			d = s.nextInt();
			if(d!=0) {
				System.out.println(n/d);
			}
			else {
				System.out.println("divide by zero error");
				//continue;
			}
			
		}
		
		else {
			System.out.println("poor input");
			//continue;
		}
			//System.out.print("Do you want to continue? y/n");
			String q=s.nextLine();
	}
}
}
