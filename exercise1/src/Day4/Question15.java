package Day4;

import java.util.ArrayList;

public class Question15 {
	public boolean isPrime(int n) {
		for(int i=2;i<(n/2);i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
	public boolean isAmstrong(int num) {
		int s=0;
		int n=num;
		while(n>0) {
			int a=n%10;
			s+=a*a*a;
			n/=10;
		}
//		System.out.println(s);
		if(s==num) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Question15 o = new Question15();
		ArrayList<Integer> prime = new ArrayList<Integer>();
		for(int i=2; i<100;i++) {
			if(o.isPrime(i)) {
				prime.add(i);
			}
		}
		System.out.println(prime);
		System.out.println(o.isAmstrong(153));
	}

}
