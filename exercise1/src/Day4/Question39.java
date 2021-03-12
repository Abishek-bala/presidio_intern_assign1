package Day4;

public class Question39 {
	public static void main(String[] args) {
		Wipro[] w = {new Wipro(), new WiproTechnologies(), new WiproInfotech(), new WiproBPO()};
		for(Wipro i:w) {
			i.disp();
		}
	}
}

class Wipro{
	protected int i=10;
	public void disp() {
		System.out.println("Wipro"+i);
	}
}

class WiproTechnologies extends Wipro{
	public void disp() {
		System.out.println("wipro Technologies"+i);
	}
}

class WiproInfotech extends Wipro{
	protected int i=20;
	public void disp() {
		System.out.println("wipro Infotech"+i);
	}
}

class WiproBPO extends Wipro{
	public void disp() {
		System.out.println("wipro BPO");
	}
}
