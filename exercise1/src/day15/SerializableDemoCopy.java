package day15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerializableDemoCopy {
	public static void main(String arg[])throws Exception{
		FileInputStream fis = new FileInputStream("emp.dat") ;
		ObjectInputStream ois = new ObjectInputStream(fis) ;
		emp ob ;
		while((ob = (emp) ois.readObject())!=null)
		{
			ob.print() ;
			}
		}
}
