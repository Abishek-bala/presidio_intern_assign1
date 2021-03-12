package day5;

public class Lab2Question24 {
	public static void main(String[] args) {
		Square s = new Square(5.0f);
		System.out.println(s.calcArea());
		System.out.println(s.calcPerim());
		Rectangle r = new Rectangle(4.0f,2.0f);
		System.out.println(r.calcArea());
		System.out.println(r.calcPerim());
	}
}

class Shape{
	public float calcArea() {
		return 0;
	}
	public float calcPerim() {
		return 0;
	} 
}

class Square extends Shape{
	float side;
	Square(float side){
		this.side = side;
	}
	public float calcArea() {
		return side*side;
	}
	
	public float calcPerim() {
		return 4*side;
}
}

class Rectangle extends Shape{
	float l,b;
	Rectangle(float l, float b){
		this.l = l;
		this.b = b;
	}
	public float calcArea() {
		return l*b;
	}
	
	public float calcPerim() {
		return 2*(l+b);
	}
	
}