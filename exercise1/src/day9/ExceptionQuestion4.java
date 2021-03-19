package day9;

public class ExceptionQuestion4 {
	public static void main(String[] args) {
		MyString s= new MyString("Hello");
		MyString se = new MyString();
		try {
			s.printString();
			se.printString();
		}catch(EmptyStringException ese) {
			System.out.println(ese);
		}
	}
}

class MyString{
	String str;
	public MyString() {
		// TODO Auto-generated constructor stub
	}
	public MyString(String str) {
//		super();
		this.str = str;
	}
	public void printString() throws EmptyStringException {
		if(str==null) {
			throw new EmptyStringException("The string is empty");
		}
		System.out.println(str);
	}
	
}

class EmptyStringException extends Exception{
	String exception_message;

	public EmptyStringException(String exception_message) {
		this.exception_message = exception_message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.exception_message;
	}
	
}
