package day8;

public class DecoratorDemo {
	public static void main(String[] args) {
		Food thali = new Rice(new Chicken(new Dhal()));
		System.out.println("cost of thali = "+thali.cost());
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
	
	public Rice() {
		// TODO Auto-generated constructor stub
//		cost = 10;
	}
	private Food food;
	
	public Rice(Food food) {
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

class Dhal extends VegFood{
	int cost=5;
	public Dhal() {
		// TODO Auto-generated constructor stub
//		cost = 5;
	}
private Food food;
	
	public Dhal(Food food) {
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

class Chicken extends NonVegFood{
	int cost=25;
	public Chicken() {
		// TODO Auto-generated constructor stub
	}
private Food food;
	
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
