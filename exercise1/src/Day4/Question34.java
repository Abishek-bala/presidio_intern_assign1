package Day4;

public class Question34 {
	public static void main(String[] args) {
		final Final_Ref o = new Final_Ref();
		o.disp();
		o.a=20;
		o.disp();
	}
}

class Final_Ref{
	int a=10;
	
	public void disp() {
		System.out.println(a);
	}
}
