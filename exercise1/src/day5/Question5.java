package day5;

public class Question5 {
	public static void main(String[] args) {
		int count = 0;
		int i,j,k;
		for(i=0;i<4;i++) {
			for(j=0;j<4;j++) {
				for(k=0;k<4;k++) {
					if((i!=j)&&(j!=k)&(i!=k)) {
						count++;
					}
				}
			}
		}
		System.out.println("count = "+count);
	}
}
