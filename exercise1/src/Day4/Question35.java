package Day4;

public class Question35 {
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.demoMethod();
		
		
	}
}

class Singleton {

	private static Singleton singleobj = null;

	   /* A private Constructor prevents any other
	    * class from instantiating.
	    */
	   private Singleton() { 
		   System.out.println("Singleton started");
	   }

	   /* Static 'instance' method */
	   public static Singleton getInstance( ) {
	      if(singleobj == null) {
	    	  singleobj = new Singleton();
	      }
		return singleobj;
	   }

	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for singleton");
	   }
	}