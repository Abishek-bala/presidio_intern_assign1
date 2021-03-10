package day3;
import java.io.*;
public class Question15 { 
    public static void main(String argv[]){
    Question15 m=new Question15(); 
    System.out.println(m.amethod()); 
}
public int amethod() { 
    try {
            FileInputStream dis=new FileInputStream("Hello.txt"); 
            }catch (FileNotFoundException fne) { 
                    System.out.println("No such file found"); 
                    return -1; 
                    }catch(IOException ioe) { 
                    } finally{ 
    System.out.println("Doing finally"); 
    } 
    return 0; 
    } 
}