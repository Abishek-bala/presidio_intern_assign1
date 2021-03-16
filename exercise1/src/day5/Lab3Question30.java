package day5;

public class Lab3Question30 {
	public String season(int m) {
		switch(m) {
		case 1:
			return "Winter";
		case 2:
			return "Winter";
		case 3:
			return "Summer";
		case 4:
			return "summer";
		case 5:
			return "summmer";
		case 6:
			return "summer";
		case 7:
			return "summer";
		case 8:
			return "Rainy";
		case 9:
			return "Rainy";
		case 10:
			return "Rainy";
		case 11:
			return "Winter";
		case 12:
			return "Winter";
		default:
			return "invalid month";
		}
	}
	public static void main(String[] args) {
		Lab3Question30 o = new Lab3Question30();
		System.out.println("january is " + o.season(1) + " season");
	}
}
