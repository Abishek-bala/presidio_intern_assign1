package Day4;
import java.util.*;
public class Question16 {
	public ArrayList<Integer> locate(int x, int[] a) {
		ArrayList<Integer> p = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++) {
			if(a[i]==x) {
				p.add(i);
			}
		}
		return p;
		
	}
	public static void main(String[] args) {
		int[] a = {1,2,1,3,4,2,1,5};
		Question16 o = new Question16();
		Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
		System.out.print("Enter number to be found in array ");
		int n= sc.nextInt();
		ArrayList<Integer> pos = o.locate(n,a);
		if(pos.size()>0) {
				System.out.println("positions in witch the number is present are : "+ pos);	
		}
		else {
			System.out.println("not present");
		}
	}

}
