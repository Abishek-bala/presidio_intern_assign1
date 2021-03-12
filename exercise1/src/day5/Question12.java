package day5;

public class Question12 {
	public static void main(String[] args) {
		boolean a = true, b = false;
		boolean c = a | b;//t
		boolean d = a & b;//f
		boolean e = a ^ b;//t
		boolean f = (! a & b) | (a &! b);//t
		boolean g =! a; //f
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		int i=10,j=20,x;
		x=(i>j)?i:j;
		System.out.println(x);
	}
}
