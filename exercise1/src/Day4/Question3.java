package Day4;

public class Question3 {
	public static void main(String[] args) {
		byte b =100;
		short s =1234;
		int v = 32768;
		int calc = -9876345;
		long l = 1234567891;
		float f = 12.25f;
		double d = 12345.234d;
		boolean bool1 = true;
		boolean bool2 = false;
		char ch1 = 66; // code for X
		char ch2 = 'Y';
		System.out.println("byte Value = "+ b);
		System.out.println("short Value = "+ (byte)s);
		System.out.println("int Value = "+ (short)v);
		System.out.println("int second Value = "+ calc);
		System.out.println("long Value = "+ l);
		System.out.println("float Value = "+ f);
		System.out.println("double Value = "+ (float)d);
		System.out.println("boolean Value = "+ bool1);
		System.out.println("boolean Value = "+ bool2);
		System.out.println("char Value = "+ ch1);
		System.out.println("char Value = "+ (int)ch2);
		b=(byte)s;
		b=(byte)v;
		b=(byte)calc;
		
				
	}
}
