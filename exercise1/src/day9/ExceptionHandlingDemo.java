package day9;
import java.util.*;
public class ExceptionHandlingDemo {
	public static void main(String[] args) throws Exception {
		Dog dog = new Dog();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the item");
		String itemname = s.next();
		Item item = (Item)Class.forName("day9."+itemname).getConstructor().newInstance();
		Child child = new Child();
		child.playWithDog(dog, item);
	}
}

abstract class DogExceptions extends Exception{
	public abstract void visit(Handler911 han);
}

class DogBiteExceptions extends DogExceptions{
	String msg;

	public DogBiteExceptions(String msg) {
	
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	
	@Override
	public void visit(Handler911 han) {
		// TODO Auto-generated method stub
		han.handle(this);
	}
	
}

class DogBarkExceptions extends DogExceptions{
	String msg;

	public DogBarkExceptions(String msg) {
	
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	@Override
	public void visit(Handler911 han) {
		// TODO Auto-generated method stub
		han.handle(this);
	}
}

abstract class Item{
	public abstract void execute() throws DogExceptions;
}

class Stone extends Item{
	public Stone() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute() throws DogExceptions {
		// TODO Auto-generated method stub
		throw new DogBarkExceptions("A stone was thrown");
	}
}

class Stick extends Item{
	@Override
	public void execute() throws DogExceptions {
		// TODO Auto-generated method stub
		throw new DogBiteExceptions("Beaten by a stick");
	}
	public Stick() {
		// TODO Auto-generated constructor stub
	}
}

class Dog{
	public void play(Item item) throws DogExceptions{
		item.execute();
	}
}

class Child {
	public void playWithDog(Dog dog, Item item)  {
		try {
			dog.play(item);
		}catch(DogExceptions de) {
			System.out.println(de);
			de.visit(new Handler911Impl());
		}
		
	}
}

interface Handler911{
	public void handle(DogBarkExceptions dba);
	public void handle(DogBiteExceptions dbi);
}

class Handler911Impl implements Handler911{
	@Override
	public void handle(DogBarkExceptions dba) {
		// TODO Auto-generated method stub
		System.out.println("Sending ambulance ");
	}
	
	@Override
	public void handle(DogBiteExceptions dbi) {
		// TODO Auto-generated method stub
		System.out.println("Barking will stop");
	}
	
}


