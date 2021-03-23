package day10;


public class DecotatorToSingleton {

	public static void main(String[] args) throws Exception {
		Food thali = Rice.createObject();
		System.out.println("cost of thali = "+thali.cost());
		
		//Food thali2 = new Rice();
		
		//System.out.println(thali2.cost());
		
	}
}

abstract class Food {
	public abstract int cost();
}

abstract class VegFood extends Food{
	
}

abstract class NonVegFood extends Food{
	
}

class Rice extends VegFood{
	int cost=10;
	
	private Rice() {
		// TODO Auto-generated constructor stub
//		cost = 10;
	}
	private Food food;
	private static Rice rice;
	
	public Rice(Food food) {
		this.food = food;
	}
	
	synchronized public static Rice createObject() throws Exception{
		if(rice == null) {
			rice = new Rice();
		}
		return rice.createClone();
	}
	
	public Rice createClone() throws Exception{
		return (Rice)super.clone();
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return cost+food.cost();
		}
		return cost;
	}
	
}

//String str;
//private MyBusinessLogic() {
//	System.out.println("cons called...");		
//}
//private static MyBusinessLogic myb;
//synchronized public static MyBusinessLogic createObject() throws Exception{
//	if(myb==null) {
//		myb=new MyBusinessLogic();
//	}
//	return myb.createClone();		
//}
//public  MyBusinessLogic createClone()throws Exception {	
//		return (MyBusinessLogic)super.clone();		
//}


class Dhal extends VegFood{
	int cost=5;
	private Dhal() {
		// TODO Auto-generated constructor stub
//		cost = 5;
	}
private Food food;
	
	public Dhal(Food food) {
		this.food = food;
	}
	
	private static Dhal dhal;
	
	synchronized public static Dhal createObject() throws Exception{
		if(dhal  == null) {
			dhal = new Dhal();
		}
		return dhal.createClone();
	}
	
	public Dhal createClone() throws Exception{
		return (Dhal)super.clone();
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return cost+food.cost();
		}
		return cost;
	}
}

class Chicken extends NonVegFood{
	int cost=25;
	private Chicken() {
		// TODO Auto-generated constructor stub
	}
private Food food;
	private static Chicken chicken;
	
	synchronized public static Chicken createObject() throws Exception {
		if(chicken == null) {
			chicken = new Chicken();
		}
		return chicken.createClone();
		
	}
	
	public Chicken createClone() throws Exception{
		return (Chicken)super.clone();
	}
	
	public Chicken(Food food) {
		this.food = food;
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(food!=null) {
			return cost+food.cost();
		}
		return cost;
	}
}

