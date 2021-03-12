package Day4;

public class Question42 {
	public static void main(String[] args) {
		House h =new House(2,4);
		h.total_cost();
	}
}

class House{
	public int no_of_doors,no_of_windows;
	public House(int nd, int nw) {
		// TODO Auto-generated constructor stub
		no_of_doors = nd;
		no_of_windows = nw;
	}
	Door d = new Door();
	Window w =new Window();
	public void total_cost(){
		System.out.println("Total cost = "+ ((no_of_doors*d.cost)+(no_of_windows*w.cost)));
	}
	}

class Door{
	public int cost = 100;
}

class Window{
	public int cost = 50;
}
