package Day4;

public class Question4 {
	public String isPrime(int n) {
		if(n==1) {
			return "cannot be determined";
		}
		
		for(int i=2;i<(n/2);i++) {
			if(n%i == 0) {
				return "false";
			}
		}
		return "true";
	}
	public static void main(String[] args) {
		Question4 obj = new Question4();
		System.out.println(obj.isPrime(17));
		System.out.println(obj.isPrime(64));
		System.out.println(obj.isPrime(1));
		System.out.println(obj.isPrime(2));
	}
}
