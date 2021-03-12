package Day4;

public class Question32 {
	public static void main(String[] args) {
		
		test o = new test();
		System.out.println(test.no_of_objects);
		test o2 = new test();
		System.out.println(test.no_of_objects);
	}
}

class test{
	public static int no_of_objects = 0;
	{
	no_of_objects++;
	}
	test(){
		
	}
}