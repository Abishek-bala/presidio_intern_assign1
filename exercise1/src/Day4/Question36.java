package Day4;

public class Question36 {
	private int a;
	protected int b;
	public int c;
}

class child extends Question36 {
	public void disp() {
//		a=10; private isn't visible in child class
		b=20;
		c=30;
	}
}
