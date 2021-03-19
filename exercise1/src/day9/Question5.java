package day9;
import day8.Pack9Question5;
public class Question5 {
	public static void main(String[] args) {
		InterfaceQuestion iq = new InterfaceQuestion();
		iq.met1();
		iq.met2();
		iq.met3();
	}
}

class InterfaceQuestion implements Pack9Question5{
	@Override
	public void met1() {
		// TODO Auto-generated method stub
		System.out.println("met1");
	}
	@Override
	public void met2() {
		// TODO Auto-generated method stub
		System.out.println("met2");
	}
	@Override
	public void met3() {
		// TODO Auto-generated method stub
		System.out.println("met3");
	}
}
