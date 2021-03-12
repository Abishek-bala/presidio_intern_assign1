package day5;
import java.util.*;

public class Question3 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter string");
	char[] str = sc.nextLine().toCharArray();
	for(int i=str.length-1;i>=0;i--) {
		System.out.print(str[i]);
	}
	
}
}
