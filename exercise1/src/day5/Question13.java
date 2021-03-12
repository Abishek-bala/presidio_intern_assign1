package day5;

public class Question13 {
	public int Area(int r,int h) {
		int a=0;
		a+=3.14*r*r;
		a+=2*3.14*r*h;
		return a;
	}
	public float Energy(float mass, float acceleration, float height, float velocity) {
		float e= mass*((acceleration*height)+((velocity*velocity)/2));
		return e;
		
	}
	
	public static void main(String[] args) {
		Question13 o =new Question13();
		System.out.println(o.Area(5,10));
		System.out.println(o.Energy(250.0f,9.8f,100.0f,25.0f));
	}
	
}
