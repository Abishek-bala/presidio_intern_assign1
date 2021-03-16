package day6;
import java.util.Scanner;
public class FanDemo {
	public static void main(String[] args) {
		Fan f=new Fan();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter to pull the chain...");
			scan.next();
			f.pull();
		}
	}
}

class Fan{
	private State state;
	public final void sets(State state) {
		this.state = state;
	}
	public Fan() {
		this.state=new Off();
	}
	
	public void pull() {
		state.change_state(this);
	}

}

abstract class State{
		public abstract void change_state(Fan f); 
	}

class Off extends State{
	@Override
	public void change_state(Fan f) {
		// TODO Auto-generated method stub
		System.out.println("Switched on..Low state");
		f.sets(new Low());
	}
}

class High extends State{
	public void change_state(Fan f) {
		System.out.println("off state");
		f.sets(new Off());
	}
}

class Medium extends State{
	public void change_state(Fan f) {
		System.out.println("High state");
		f.sets(new High());
	}
}

class Low extends State{
	public void change_state(Fan f) {
		System.out.println("Medium state");
		f.sets(new Medium());
	}
}

