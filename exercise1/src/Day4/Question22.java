package Day4;

public class Question22 {
	public static void main(String[] args) {
		Q22 o = new Q22();
//		System.out.println(o.a;);
		System.out.println(o.b);
		System.out.println(o.c);
		System.out.println(o.d);
		
//		o.funa();
		o.funb();
		o.func();
		o.fund();
	}
	
}

class Q22{
	private int a=1;
	protected int b=2;
	public int c=3;
	int d=4;
	private int funa() {
		return 0;
	}
	protected int funb() {
		return 0;
	}
	public int func() {
		return 0;
	}
	int fund() {
		return 0;
	}
}