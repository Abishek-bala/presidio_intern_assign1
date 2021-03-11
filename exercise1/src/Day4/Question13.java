package Day4;

public class Question13 {
	public static void main(String[] args) {
		int[][] marks = {
				{70,80,90},
				{75,85,95},
				{60,70,80},
		};
		String[] names = {"A","B", "C"};
		int[] total = new int[marks.length];
		for(int i=0;i<marks.length;i++) {
			for(int j=0;j<marks[i].length;j++) {
				total[i]+=marks[i][j];
			}
		}
		System.out.println("Name\tmat`\tphy\tchem\ttot");
		for(int i = 0;i<marks.length; i++) {
			System.out.print(names[i]+"\t");
			for(int j=0; j<marks[i].length; j++) {
				System.out.print(marks[i][j]+"\t");
			}
			System.out.println(total[i]);
		}
	}
}
