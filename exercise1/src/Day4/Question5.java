package Day4;

public class Question5 {
	public int sum(int[] a) {
		int s=0;
		for(int i:a) {
			s+=i;
		}
		return s;
		
	}
	public float average(int[] a) {
		return (sum(a)/a.length);
	}
	public static void main(String[] args) {
		Question5 o = new Question5();
		int[] a = {1,2,3,4,5};
		//float avg = o.average(a); 
		System.out.println("Average = "+ o.average(a));
	}
}
