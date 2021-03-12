package Day4;

public class Question29 {
	public static void main(String[] args) {
		ComplexNums c1 = new ComplexNums(2, 3);
		ComplexNums c2 = new ComplexNums(3, 4);
		int[] arr = c1.add(c2);
		System.out.println("Sum = "+arr[0]+"+"+arr[1]+"i");
	}
}

class ComplexNums{
	private int real, img;
	ComplexNums(int rp, int ip){
		real = rp;
		img = ip;
	}
	public int[] add(ComplexNums c) {
		int[] arr = new int[2];
		arr[0] = this.real + c.real;
		arr[1] = this.img + c.img;
		return arr;
	}
}