package day15;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo {
	public static void main(String arg[]) throws Exception{
		FileOutputStream fos = new FileOutputStream ("emp.dat") ;
		ObjectOutputStream oos = new ObjectOutputStream(fos) ;
		emp ob ;
		for ( int i=0; i<10;i++){
			ob =  new emp(i,"name"+i) ;oos.writeObject(ob) ;
			}
		}
}
	


class emp implements Serializable{
	public int eno ;
	public String ename ;
	emp(int a, String m){
		eno=a ;ename=m; 
		}
	void print(){
		System.out.println(eno + " \t:\t " + ename ) ;
		}
	}