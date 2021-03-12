package day5;

public class Question10 {
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int c;
		int d; 
		c = ++b;   
		d = a++;
		c++;
		System.out.println(c);//4
		System.out.println(d);//1
	}
}
