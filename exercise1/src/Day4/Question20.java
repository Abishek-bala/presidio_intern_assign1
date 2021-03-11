package Day4;

public class Question20 {
	public static void main(String[] args) {
		int[][] marks = {
				{70,80,90,125,23,34,1234,23,12,67,89},
				{75,85,95,43,54,86,90,432,345,147,12},
				{60,70,80,12,23,31,14,15,32,54,67},
		};
		
		int[] max = new int[marks.length];
		for(int i=0;i<marks.length;i++) {
			max[i]+=marks[i][0];
			for(int j=1;j<marks[i].length;j++) {
				if(marks[i][j]>max[i]) {
					max[i]=marks[i][j];
				}
			}
		}
		for(int i = 0;i<marks.length; i++) {
			for(int j=0; j<marks[i].length; j++) {
				System.out.print(marks[i][j]+"\t");
			}
			System.out.println("MAX = "+max[i]);
		}
	}
	
}
