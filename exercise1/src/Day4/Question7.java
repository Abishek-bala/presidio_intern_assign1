package Day4;
import java.util.*;
public class Question7 {
	public void ascend(int[] a) {
		Arrays.sort(a);
//		for(int i:a) {
//			System.out.print(i);
//		}
		//return a;
	}
	public void descending(int[] a) {
		for(int i = 0; i<a.length; i++) {
			for(int j = i+1; j<a.length; j++) {
				if(a[i]<a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
			

		}
//		for(int i:a) {
//			System.out.print(i);
//		}
		//return a;
	}
	public static void main(String[] args) {
		int[] a = {2,1,5,3,4};
		Question7 o = new Question7();
		o.ascend(a);
		System.out.print("ASC : ");
		for(int i:a) {
			System.out.print(i);
		}
		System.out.println();
		o.descending(a);
		System.out.print("desc : ");
		for(int i:a) {
			System.out.print(i);
		}
	}
	
}
