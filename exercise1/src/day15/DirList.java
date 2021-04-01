package day15;

import java.io.File;

public class DirList {
	public static void main(String[] args) {
		String dirname = "C:\\Users\\VC\\eclipse-workspace\\basicb4\\src";
		File f1 = new File(dirname);
		if(f1.isDirectory()) {
			String s[] = f1.list();
			for(String file:s) {
				System.out.println(file);
			}
			
		}
		
	}
}
