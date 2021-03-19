package day9;

public class ExceptionQuestion3 {
	public static void main(String p[]){
		new_sample s=new new_sample(); 
		s.mth1();
		}
}

class new_sample{ 
	public void mth1(){
		mth2(); 
		System.out.println("caller");
		}
	public void mth2(){
		try{
//			return;
			System.exit(0);
			//throw new Exception();
}catch(Exception e){
	System.out.println("catch-mth2");
	}finally{
		System.out.println("finally-mth2");
		}
	}
	
	}
