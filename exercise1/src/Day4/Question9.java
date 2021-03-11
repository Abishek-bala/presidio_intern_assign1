package Day4;

public class Question9 {
	public void reverse(int[] a) {
		
		int[] b = new int[a.length];
		int j=a.length;
		for(int i = 0; i<a.length ; i++ ) {
			b[j-1] = a[i];
			j-=1;	
		}
//		for(int i:b) {
//			System.out.println(i);
//		}
		for(int i=0;i<a.length;i++) {
			a[i] = b[i];
		}
		
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		Question9 o = new Question9();
		o.reverse(a);
		System.out.println("after reverse");
		for(int i:a) {
			System.out.println(i);
		}
	}
}
