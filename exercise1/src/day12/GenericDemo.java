package day12;

import java.lang.reflect.Field;

public class GenericDemo {
	public static void main(String[] args) throws Exception {
		PaintBrush<Paint> pb = PaintContainer.getPaintBrush();
		Paint paint = (Paint)pb.obj;
		System.out.println("paint : "+paint+" Brush : "+pb);
		
		PaintBrush<Water> wb = WaterContainer.getPaintBrush();
		Water water = (Water)wb.getObj();
		System.out.println("Water : "+water+" Brush : "+wb);
	}
}

class PaintContainer{
	public static PaintBrush<Paint> getPaintBrush() throws Exception{
		PaintBrush<Paint> pb = new PaintBrush<>();
		Paint p = new RedPaint();
		Field field = pb.getClass().getDeclaredField("obj");
		In in = field.getAnnotation(In.class);
		if(in!=null) {
			pb.setObj(p);
		}
		return pb;
	}
}

class WaterContainer{
	public static PaintBrush<Water> getPaintBrush() throws Exception{
		PaintBrush<Water> pb = new PaintBrush<>();
//		Paint p = new RedPaint();
		Water w = new Water();
		Field field = pb.getClass().getDeclaredField("obj");
		In in = field.getAnnotation(In.class);
		if(in!=null) {
			pb.setObj(w);
		}
		return pb;
	}
}

abstract class Paint{}

class RedPaint extends Paint{
	
}

class BluePaint extends Paint{}

class PaintBrush<T>{
	@In
	T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T t) {
		obj = t;
	}
		
	
}

class Water{}