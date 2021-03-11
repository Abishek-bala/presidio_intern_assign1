package Day4;

public class Question11 {
	public static void main(String[] args) {
		int[][] a = {
				{1},
				{2,3},
				{4,5,6},
				{7,8,9,10}
		};
		for(int i[]:a) {
			for(int j:i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
	}
}
