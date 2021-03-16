package day6;
public class ObjectCreationDemo {
	public static void main(String[] args)throws Exception {
		MyBusinessLogic myb=MyBusinessLogic.createObject();
		myb.str="first object...";
		MyBusinessLogic myb2=MyBusinessLogic.createObject();
		myb2.str="second object...";
		
		System.out.println(myb.str);
		
		SecondClass b=SecondClass.createObject();
		b.s="first object2...";
		SecondClass b2=SecondClass.createObject();
		b2.s="second object2...";
		
		System.out.println(b.s);
	}
}
class MyBusinessLogic implements Cloneable{
	String str;
	private MyBusinessLogic() {
		System.out.println("cons called...");		
	}
	private static MyBusinessLogic myb;
	synchronized public static MyBusinessLogic createObject() throws Exception{
		if(myb==null) {
			myb=new MyBusinessLogic();
		}
		return myb.createClone();		
	}
	public  MyBusinessLogic createClone()throws Exception {	
			return (MyBusinessLogic)super.clone();		
	}
}

class SecondClass implements Cloneable{
	String s;
	private SecondClass() {
		System.out.println("second cons");
	}
	
	private static SecondClass myb;
	
	synchronized public static SecondClass createObject() throws Exception{
		if(myb == null) {
			myb = new SecondClass();
		}
		return myb.createClone();
	}
	
	public SecondClass createClone() throws Exception{
		return (SecondClass)super.clone();
	}
}