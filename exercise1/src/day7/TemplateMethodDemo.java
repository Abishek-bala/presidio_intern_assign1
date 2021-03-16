package day7;

public class TemplateMethodDemo {
	public static void main(String[] args) {
		Dominos d = new NewPizza();
		d.dominoprocess();
	}
}


abstract class Dominos{
	final protected void ProcessToCook() {
		System.out.println("cooking hes been defined by lead chef");
	}
	
	final protected void AddIngridients() {
		System.out.println("Lead cook made the ingridients");
	}
	
	final protected void ProcessToPack() {
		System.out.println("packing process is defined by dominos");
	}
	
	final private void ProcessTocollection() {
		System.out.println("dominos has defined the collection and profit sharing process");
	}
	
	public abstract void cook();
	public abstract void deliver();
	
	final public void dominoprocess() {
		cook();
		deliver();
		ProcessTocollection();
	}
}

class NewPizza extends Dominos{

	@Override
	public void cook() {
		System.out.println("cooking started");
		ProcessToCook();
		AddIngridients();
		System.out.println("pizza ready");
		
	}

	@Override
	public void deliver() {
		// TODO Auto-generated method stub
		ProcessToPack();
		
	}
	
}