package Day4;

public class Question24 {
	public static void main(String[] args) {
		quadratic q1 = new quadratic();
		int[] a = new int[3];
		q1.getvalue(a);
		System.out.println("a="+a[0]+"\nb="+a[1]+"\nc="+a[2]);
		quadratic q2 = new quadratic(1,2,3);
		q2.getvalue(a);
		System.out.println("a="+a[0]+"\nb="+a[1]+"\nc="+a[2]);
		int[] b = {2,3,4};
		q1.setvalue(b);
		q1.getvalue(a);
		System.out.println("a="+a[0]+"\nb="+a[1]+"\nc="+a[2]);
		q2.getvalue(a);
		System.out.println("a="+a[0]+"\nb="+a[1]+"\nc="+a[2]);
		int res = q2.compute(2);
		System.out.println("when x=2 and a=1 b=2 c=3 is = "+res);
		
	}
}

class quadratic{
	int a,b,c;
	quadratic(){
		a=1;
		b=1;
		c=1;
	}
	quadratic(int a,int b, int c){
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public void getvalue(int[] val) {
		val[0] = a;
		val[1] = b;
		val[2] = c;
	}
	public void setvalue(int[] val) {
		this.a = val[0];
		this.b = val[1];
		this.c = val[2];
	}
	public int compute(int x) {
		int s=0;
		s+=a*x*x;
		s+=b*x;
		s+=c;
		System.out.println(s);
		return s;
	}
}