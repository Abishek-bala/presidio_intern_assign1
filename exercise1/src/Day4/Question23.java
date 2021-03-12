package Day4;

public class Question23 {
	public static void main(String[] args) {
		Q23 o = new Q23();
		System.out.println(o.a);
		o.a = 20;
		System.out.println(o.a);
		
	}
}

class Q23{
	protected int a =10;
}

class Q23Sub extends Q23 {
	//a=12;
}
