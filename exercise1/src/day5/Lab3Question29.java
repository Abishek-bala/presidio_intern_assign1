package day5;

public class Lab3Question29 {
	public boolean isVowel(char c) {
		switch(c) {
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		case 'A':
			return true;
		case 'E':
			return true;
		case 'I':
			return true;
		case 'O':
			return true;
		case 'U':
			return true;
			
		}
		return false;
	}
	public static void main(String[] args) {
		Lab3Question29 o = new Lab3Question29();
		System.out.println(o.isVowel('a'));
		System.out.println(o.isVowel('A'));
		System.out.println(o.isVowel('c'));
		System.out.println(o.isVowel('C'));
		System.out.println(o.isVowel('1'));
		
	}
}
