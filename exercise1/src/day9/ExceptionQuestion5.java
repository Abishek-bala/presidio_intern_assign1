package day9;
import day9.EmptyStringException;
public class ExceptionQuestion5 {
	public static void main(String[] args) throws EmptyStringException {
		EQ5 obj1 = new EQ5("new string");
		EQ5 obj2 = new EQ5();
		try {
			System.out.println(obj1.returnString());
		
			System.out.println(obj2.returnString());
			}finally {
				System.out.println("Finally executing");
			}
		
	}
}

class EQ5{
	String str;
	public EQ5() {
		// TODO Auto-generated constructor stub
	}
	public EQ5(String str) {
//		super();
		this.str = str;
	}

	public String returnString() throws EmptyStringException{
		if(str==null) {
			throw new EmptyStringException("No string to return");
		}
		return str;
	}
}
