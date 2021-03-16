package day5;
import java.util.*;
public class Lab3Question28 {
	public static void main(String[] args) {
		//let months 3-8 be summer, 9-11 be rainy and 11-2 be winter
		Scanner sc = new Scanner(System.in);
		System.out.println("enter month (between 1-12)");
		int m = sc.nextInt();
		if((m<3&&m>0) && (m>11 && m<=12)) {
			System.out.println("Winter");
		}
		else if(m<=11 && m>8) {
			System.out.println("Rainy");
		}
		else if(m<=8 && m>=3) {
			System.out.println("summer");
		}
		else {
			System.out.println("invalid month");
		}
	}
}
