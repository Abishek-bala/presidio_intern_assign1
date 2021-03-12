package Day4;

public class Question25 {

}

//protected - class cannot be protected access modifier
class base { 
	String Method() { 
		return "Wow"; 
		}
	}
class dervied { 
	public void useD() { 
		base z = new base(); 
		System.out.println("base says, " + z.Method()); 
		} 
	} 
