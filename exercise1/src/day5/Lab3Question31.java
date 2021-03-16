package day5;

public class Lab3Question31 {
	public float operate(int a, int b, char o) {
		switch(o) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return (float)a/b;
		default:
			System.out.println("Invalid operator");
		}
		return -1;
	}
	public static void main(String[] args) {
		Lab3Question31 o = new Lab3Question31();
		System.out.println(o.operate(1, 2, '+'));
		System.out.println(o.operate(1, 2, '-'));
		System.out.println(o.operate(1, 2, '*'));
		System.out.println(o.operate(1, 2, '/'));
		System.out.println(o.operate(1, 2, 's'));
	}
}
