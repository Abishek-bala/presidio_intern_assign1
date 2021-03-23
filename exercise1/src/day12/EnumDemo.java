package day12;

public class EnumDemo {
	public static void main(String[] args) {
		Cars c= Cars.Maruthi;
		System.out.println(c.getPrize());
		Cars[] cc = Cars.values();
		Cars c2 = Cars.honda;
		for(Cars cars : cc) {
			System.out.println(cars.getPrize());
		}
		
		
		met(c);
		
	}

	public static void met(Cars c) {
		// TODO Auto-generated method stub
		switch(c) {
		case Maruthi:
			System.out.println("Maruthi");
			break;
		case nissan:
			System.out.println("nissan");
			break;
		case susuki:
			System.out.println("susuki");
			break;
		case honda:
			System.out.println("honda");
			break;
		default:
			System.out.println("car");
		}
	}
}

enum Cars{
	Maruthi(800),susuki,honda,nissan;
	int prize;
	Cars(int i) {
		// TODO Auto-generated constructor stub
		prize=i;
		System.out.println("prize = "+prize);
	}

	Cars() {
		// TODO Auto-generated constructor stub
		System.out.println("default cons called");
	}
	public int getPrize() {
		return this.prize;
	}
}
