package Day4;

public class Question27 {
	public static void main(String[] args) {
		int principal = 14000;
		float amt  = principal + (float)principal*0.4f;
		amt-=1500;
		amt+=amt*.12f;
		System.out.println(amt);
	}
}
