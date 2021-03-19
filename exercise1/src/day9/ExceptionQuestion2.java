package day9;

public class ExceptionQuestion2 {
	public static void main(String p[]){
		sample s=new sample(); 
		s.mth1();
		}
}

class sample{ 
	public void mth1(){
		mth2(); 
		System.out.println("caller");
		}
	public void mth2(){
		try{ return;
//			throw new Exception();
}catch(Exception e){
	System.out.println("catch-mth2");
	}finally{
		System.out.println("finally-mth2");
		}
	}
	
	}