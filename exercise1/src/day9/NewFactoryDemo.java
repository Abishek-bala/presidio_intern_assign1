package day9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class NewFactoryDemo {
	public static void main(String[] args) throws Exception {
		shoeseller s = newContainer.getShoeseller();
		Shoe newshoe = s.sellShoe();
		System.out.println(newshoe);
		Importer i = new ImporterImpl();
		Object obj = Proxy.newProxyInstance(s.getClass().getClassLoader(), new Class[] {shoeseller.class, Importer.class}, new MynewInvocationHandler(new Object[] {s,i})); 
	}
}

class MynewInvocationHandler implements InvocationHandler{
	Object obj[];
	public MynewInvocationHandler(Object obj[]) {
		this.obj=obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject=null;
		for(Object o:obj) {
			Method m[]=o.getClass().getDeclaredMethods();
			for(Method met:m) {
				if(met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject=method.invoke(o, args);
				}
			}
		}
		return returnObject;
	}
}

interface Importer{
	public void doImport();
}

class ImporterImpl implements Importer{
	@Override
	public void doImport() {
		// TODO Auto-generated method stub
		System.out.println("imported");

	}
}

class newContainer{
	public static shoeseller getShoeseller() throws Exception {
		ShoeShop shop = (ShoeShop)Class.forName("day9.NewShop").getConstructor().newInstance();
		ShoeManufacturer manufacturer = (ShoeManufacturer)Class.forName("day9.AdidasFactory").getConstructor().newInstance();
		shop.setManufacturer(manufacturer);
		return shop;
	}
}

interface seller{
	
}

interface shoeseller extends seller{
	public Shoe sellShoe();
	
}

abstract class ShoeShop implements shoeseller{
	public ShoeShop() {
		// TODO Auto-generated constructor stub
	}
	private ShoeManufacturer manufacturer;

	public ShoeManufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ShoeManufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
}

class NewShop extends ShoeShop {
	public NewShop() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe sellShoe() {
		// TODO Auto-generated method stub
//		System.out.println("sell them shoes");
		return getManufacturer().manufactureShoes();
	}
}
abstract class Shoe{
	
}

class LeatherShoe extends Shoe{
	
}

class SportsShoe extends Shoe{
	
}

interface Manufacturer{
	
}

interface ShoeManufacturer extends Manufacturer{
	public Shoe manufactureShoes();
}

abstract class ShoeFactory implements ShoeManufacturer{
	
}

class BataFactory extends ShoeFactory{
	public BataFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe manufactureShoes() {
		// TODO Auto-generated method stub
//		System.out.println("Manufacturing leather shoes");
		return new LeatherShoe();
	}
}

class AdidasFactory extends ShoeFactory{
	public AdidasFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe manufactureShoes() {
		// TODO Auto-generated method stub
//		System.out.println("Manufacturing Sport shoes");
		return new SportsShoe();
	}
}

