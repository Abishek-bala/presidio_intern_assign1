package day9;

public class ExceptionQuestion6 {

}

class EQ6parent{
	public EQ6parent(int i) throws Exception {
		if(i==0) {
			throw new Exception();
		}
	}
}

//class EQ6child extends EQ6parent{
//	public EQ6child(int i) {
//		// TODO Auto-generated constructor stub
//		try {
//			super(i);
//		}
//	}
//} //cannot catch exception thrown by parent constructor