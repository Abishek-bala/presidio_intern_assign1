package day13;
import java.util.*;
class Turtle { 
	int size; 
	public Turtle(int s) {
		size = s; 
		} 
	public boolean equals(Object o) { 
		return (this.size == ((Turtle)o).size); 
		} 
	// insert code here 9.
	 
}
public class Question20 {
	public static void main(String[] args) { 
		LinkedHashSet<Turtle> t = new LinkedHashSet<Turtle>(); 
		t.add(new Turtle(1)); 
		t.add(new Turtle(2));
		t.add(new Turtle(1)); 
		System.out.println(t.size()); 
		}
}
