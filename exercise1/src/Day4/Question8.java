package Day4;

public class Question8 {
	public int locate(int x, int[] a) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==x) {
				return i;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		Question8 o = new Question8();
		System.out.println("position of 3 : " + o.locate(3,a));
		System.out.println("position of 5 : " + o.locate(5,a));
		System.out.println("position of 8 : " + o.locate(8,a));
	}
}
