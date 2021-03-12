package Day4;


public class Question28 {
	public static void main(String[] args) {
		Laddu laddu=new Laddu();
		Laddu o = new Laddu();
		System.out.println("Size of original laddu...:"+laddu.size);
		PassByValue pbv=new PassByValue();
		int a =5; //local variable =pass by value
		pbv.getLaddu(a);
		
		System.out.println("size of laddu after PBV...:"+a); // value doesn't change
		
		PassByRefobj pbr=new PassByRefobj();
		pbr.getLaddu(laddu);//object - pass by reference
		System.out.println("size of laddu after PBR....:"+laddu.size);
		System.out.println("size of Laddu o="+o.size);
		
		int [] arr = {1,2,3,4};
		
		passbyrefarr o1 = new passbyrefarr();
		
		o1.getarr(arr);
		
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
class Laddu{
	int size=10;
}
class PassByValue{
	public void getLaddu(int size) {
		size=0;
	}
}
class PassByRefobj{
	public void getLaddu(Laddu laddu) {
		laddu.size=0;
	}
}

class passbyrefarr{
	public void getarr(int[] a) {
		a[0] = 100;
		a[1] = 200;
	}
}
