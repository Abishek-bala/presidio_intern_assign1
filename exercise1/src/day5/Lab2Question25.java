package day5;

public class Lab2Question25 {
	public int max_of_three(int a,int b, int c) {
		if(a>=b &&a>=c) {
			return a;
		}
		else if(b>=c) {
			return b;
		}
		return c;
	}
	public static void main(String[] args) {
		Lab2Question25 o = new Lab2Question25();
		System.out.println(o.max_of_three(1, 2, 3));
		System.out.println(o.max_of_three(3, 2, 1));
		System.out.println(o.max_of_three(2, 3, 1));
		System.out.println(o.max_of_three(1, 2, 2));
	}

}