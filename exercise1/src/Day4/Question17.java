package Day4;

public class Question17 {
	
	static int a=10;
	
	public static void main(String[] args) {
		final int i=10;
		//i=20;	
		Question17 o = new Question17();
		o.disp();
		
		//TestClass c = new TestClass();
		TestClass c = new TestClass(5);
	}
	
	public void disp(){
		System.out.println(a);
	}	
}

class TestClass{
	TestClass(int a){
		System.out.println("param cons called");
	}
}
