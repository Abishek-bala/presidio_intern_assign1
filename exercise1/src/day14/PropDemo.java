package day14;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropDemo {
	public static void main(String[] args) throws Exception {
		Properties pro = new Properties();
		pro.load(new FileInputStream("abc.properties"));
		Enumeration e = pro.elements();
		while (e.hasMoreElements()) {
			String value = (String)e.nextElement();
			System.out.println(value);
		}
		System.out.println(pro.getProperty("key1"));
	}
}
