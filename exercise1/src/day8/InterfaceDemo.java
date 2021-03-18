package day8;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class InterfaceDemo {
	public static void main(String[] args) {
		AlopathyMedicalCollege almc = new AlopathyMedicalCollege();
		AyurvedhaMedicalCollege aymc = new AyurvedhaMedicalCollege();
		
		Object human1 = new Human();
		
		JetAcademy j = new JetAcademy();
		StewardAcademy s = new StewardAcademy();
		
		AlopathyMedicalCollege al = new AlopathyMedicalCollege();
		AyurvedhaMedicalCollege ay = new AyurvedhaMedicalCollege();
		
		human1 = Proxy.newProxyInstance(human1.getClass().getClassLoader(), 
				new Class[] {Doctor.class, Steward.class, Pilot.class, Surgeon.class, Pediatritian.class},
				new MyInvocationHandler(new Object[] {ay,j,s}));
		Doctor human1doctor = (Doctor)human1;
		human1doctor.doCure();
		
		Pilot human1Pilot = (Pilot)human1;
		human1Pilot.doFly();
		
		Steward human1Steward = (Steward)human1;
		human1Steward.doServe();
		
		Surgeon surgeon = (Surgeon)human1;
		surgeon.doSurgery();
		
	}
}

class MyInvocationHandler implements InvocationHandler{
	Object obj[];
	public MyInvocationHandler(Object obj[]) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object returnObject = null;
		for(Object o:obj) {
			Method[] m = o.getClass().getDeclaredMethods();
			for(Method met:m) {
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject = met.invoke(o, args);	
				}
				
			}
		}
		return returnObject;
	}
}

interface Pilot{
	public void doFly();
}

class JetAcademy implements Pilot{
	@Override
	public void doFly() {
		// TODO Auto-generated method stub
		System.out.println("learnt to fly");
	}
}

interface Steward{
	public void doServe();
}

class StewardAcademy implements Steward{
	@Override
	public void doServe() {
		// TODO Auto-generated method stub
		System.out.println("learnt to serve");
	}
}

interface Doctor{
	public void doCure();
}

interface Surgeon{
	public void doSurgery();
}

interface Pediatritian{
	public void childcare();
}

class Human{
	
}

class AlopathyMedicalCollege implements Doctor,Pediatritian,Surgeon{
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("this is the alopahy way");
	}
	@Override
	public void childcare() {
		// TODO Auto-generated method stub
		System.out.println("child care the alopathy way");
	}
	@Override
	public void doSurgery() {
		// TODO Auto-generated method stub
		System.out.println("do surgery the alopathy way");
	}
}

class AyurvedhaMedicalCollege implements Doctor,Pediatritian{
	@Override
	public void doCure() {
		// TODO Auto-generated method stub
		System.out.println("This is the ayurvedhic way");
	}
	@Override
	public void childcare() {
		// TODO Auto-generated method stub
		System.out.println("Child care the ayur way");
	}
}