package day9;

public class Quesiton4 {
	public static void main(String[] args) {
		Derived d = new Derived();
		d.fun1(d);
		d.fun2(d);
		d.fun3(d);
		d.fun4(d);
	}
}

interface Inter1{
	public void met1();
	public void met2();
}

interface Inter2{
	public void met3();
	public void met4();
}

interface Inter3{
	public void met5();
	public void met6();
}

interface Inter4 extends Inter1,Inter2,Inter3{
	public void met7();
}

class Parent{
	public Parent() {
		// TODO Auto-generated constructor stub
		System.out.println("parent class cons");
	}
}

class Derived extends Parent implements Inter4{
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
	@Override
	public void met4() {
		// TODO Auto-generated method stub
		System.out.println("met4");

	}
	@Override
	public void met5() {
		// TODO Auto-generated method stub
		System.out.println("met5");

	}
	@Override
	public void met6() {
		// TODO Auto-generated method stub
		System.out.println("met6");

	}
	@Override
	public void met7() {
		// TODO Auto-generated method stub
		System.out.println("met7");

	}
	public Derived() {
		// TODO Auto-generated constructor stub
		System.out.println("child constructor");
	}
	public void fun1(Inter1 i1) {
		System.out.println("Inter1 object method");
	}
	public void fun2(Inter2 i2) {
		System.out.println("Inter2 object method");
	}
	public void fun3(Inter3 i3) {
		System.out.println("Inter3 object method");
	}
	public void fun4(Inter4 i4) {
		System.out.println("Inter4 object method");
	}
}



