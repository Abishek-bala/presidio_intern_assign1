package Day4;

public class Question19 {
	public void reverse(int[] a) {
			
			int[] b = new int[a.length];
			int j=a.length;
			for(int i = 0; i<a.length ; i++ ) {
				b[j-1] = a[i];
				j-=1;	
			}
			for(int i=0;i<a.length;i++) {
				a[i] = b[i];
			}
			
	}
	public static void main(String[] args) {
		int[][] a = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		Question19 o = new Question19();
		for(int i[]:a) {
			o.reverse(i);
		}
		for(int i[]:a) {
			for(int j:i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
}
