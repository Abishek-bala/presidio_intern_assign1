package day9;

public class Question2 {
	public static void main(String[] args) {
		Circle c= new Circle();
		System.out.println(c.findArea(4));
		Sphere s = new Sphere();
		System.out.println("surface area = "+s.findArea(3));
		System.out.println("volume = "+s.findVolume(3));
	}
}

interface CalcArea{
	public float findArea(float a);
	public float findArea(float a,float b, float c);
}

interface CalcVolume{
	public float findVolume(float a);
}

class Circle implements CalcArea{
	@Override
	public float findArea(float a) {
		// TODO Auto-generated method stub
		return 3.14f*a*a;
	}
	@Override
	public float findArea(float a, float b, float c) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Square implements CalcArea{
	@Override
	public float findArea(float a) {
		// TODO Auto-generated method stub
		return a*a;
	}
	@Override
	public float findArea(float a, float b, float c) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Triangle implements CalcArea{
	@Override
	public float findArea(float a) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float findArea(float a, float b, float c) {
		// TODO Auto-generated method stub
		return (a+b+c)/2;
	}
}

class Sphere implements CalcArea,CalcVolume{
	@Override
	public float findArea(float a) {
		// TODO Auto-generated method stub
		return 4*3.14f*a*a;
	}
	@Override
	public float findArea(float a, float b, float c) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float findVolume(float a) {
		// TODO Auto-generated method stub
		return (4/3)*3.14f*a*a*a;
	}
}

class Cuboid implements CalcArea,CalcVolume{
	@Override
	public float findArea(float a) {
		// TODO Auto-generated method stub
		return 6*a*a;
	}
	@Override
	public float findArea(float a, float b, float c) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public float findVolume(float a) {
		// TODO Auto-generated method stub
		return a*a*a;
	}
	
}

