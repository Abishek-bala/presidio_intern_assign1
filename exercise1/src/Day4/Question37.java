package Day4;
 
public class Question37 {
	public static void main(String[] args) {
		C objc = new C(10,"constructor called"); 
	}
}

class A{
	A(String s){
		System.out.println("class A "+s);
	}
}

class B{
	B(int i){
		System.out.println("class B"+i);
	}
}

class C extends A{
	C(int i, String s){
		super(s);
		B objb = new B(i);
	}
	
}