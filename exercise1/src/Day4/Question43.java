package Day4;

class X { 
	void do1() {
		System.out.println("do1");
	} 
	}
class Y extends X {
	protected int a=10;
	void do2() {
		System.out.println("do2");
	} 
	}
public class Question43 {
	public static void main(String [] args) {
		X x1 = new X();
		Y x2 = new Y();
		x2.do2();
		
		}
	}