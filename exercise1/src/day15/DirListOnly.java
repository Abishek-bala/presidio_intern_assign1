package day15;

import java.io.File;
import java.io.FilenameFilter;

public class DirListOnly {
	public static void main(String[] args) {
		String dirname = "C:\\Users\\VC\\eclipse-workspace\\basicb4\\src";
		File f1 = new File(dirname);
		FilenameFilter only = new OnlyText("properties");
		if(f1.isDirectory()) {
			String s[] = f1.list(only);
			for(String file:s) {
				System.out.println(file);
			}
			
		}
		
	}
}

class OnlyText implements FilenameFilter{
String ext;
	
	
	public OnlyText(String ext) {
//		super();
		this.ext = "."+ext;
	}


	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return name.endsWith(ext);
	}
}
